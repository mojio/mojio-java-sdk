package io.moj.java.sdk.websocket;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.neovisionaries.ws.client.WebSocket;
import com.neovisionaries.ws.client.WebSocketFactory;
import com.neovisionaries.ws.client.WebSocketState;

import io.moj.java.sdk.auth.Authenticator;

/**
 * A Wrapper for nv-websocket-client for Mojio-specific WebSocket calls.
 * Created by alexc on 2017-04-25.
 */

public class MojioWebSocket implements MojioWebSocketApi {
    private WebSocketFactory factory;
    private Map<MojioWebSocketListener, WebSocket> listenerWebSocketMap;
    private String baseUrl;
    private Authenticator authenticator;
    private String accessToken;

    public MojioWebSocket(String baseUrl, Authenticator authenticator) {
        factory = new WebSocketFactory();
        listenerWebSocketMap = new HashMap<>();
        this.baseUrl = baseUrl;
        this.authenticator = authenticator;
    }

    @Override
    public void getVehicle(String id, MojioWebSocketListener listener) throws IOException {
        setup(baseUrl + "/vehicles/" + id, listener);
    }

    @Override
    public void getVehicles(MojioWebSocketListener listener) throws IOException {
        setup(baseUrl + "/vehicles", listener);
    }

    @Override
    public void getMojio(String id, MojioWebSocketListener listener) throws IOException {
        setup(baseUrl + "/mojios/" + id, listener);
    }

    @Override
    public void getMojios(MojioWebSocketListener listener) throws IOException {
        setup(baseUrl + "/mojios", listener);
    }

    @Override
    public void removeListener(MojioWebSocketListener listener) {
        WebSocket ws = listenerWebSocketMap.remove(listener);
        if (ws != null) {
            ws.removeListener(listener);
            if (!listenerWebSocketMap.containsValue(ws)) {
                ws.disconnect();
            }
        }
    }

    private void setup(String url, MojioWebSocketListener listener) throws IOException {
        WebSocket ws = getSocket(url);
        if (ws == null) {
            // Create a new WebSocket only if one isn't already open.
            ws = factory.createSocket(url);
            connect(ws);
        } else if (ws.getState() == WebSocketState.CLOSING || ws.getState() == WebSocketState.CLOSED) {
            WebSocket newWs = ws.recreate();
            newWs.clearHeaders();
            connect(ws);
            updateSocketMap(ws, newWs);
            ws = newWs;
        }

        // Check if this is an existing listener. If yes, check for the attached WebSocket. If that's
        // also the same, we skip. Or else we add listener to the WebSocket.
        WebSocket ws2 = listenerWebSocketMap.get(listener);
        if (ws2 != ws) {
            removeListener(listener);
            ws.addListener(listener);
            listenerWebSocketMap.put(listener, ws);
        }
    }

    private void connect(final WebSocket webSocket) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                if (authenticator.getAccessToken() != null) {
                    accessToken = "Bearer " + authenticator.getAccessToken().getAccessToken();
                    webSocket.addHeader("Authorization", accessToken);
                    webSocket.connectAsynchronously();
                }
            }
        }).start();
    }

    private WebSocket getSocket(String url) {
        for (WebSocket ws : listenerWebSocketMap.values()) {
            if (ws.getURI().toString().equalsIgnoreCase(url)) {
                return ws;
            }
        }
        return null;
    }

    /**
     * Replacing all old WebSocket associated with listeners with the new one
     * @param oldWebSocket
     * @param newWebSocket
     */
    private void updateSocketMap(WebSocket oldWebSocket, WebSocket newWebSocket) {
        for (MojioWebSocketListener listener : listenerWebSocketMap.keySet()) {
            if (listenerWebSocketMap.get(listener) == oldWebSocket) {
                listenerWebSocketMap.put(listener, newWebSocket);
            }
        }
    }
}