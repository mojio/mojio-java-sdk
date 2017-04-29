package io.moj.java.sdk.websocket;

import java.io.IOException;
import java.util.HashMap;

import com.neovisionaries.ws.client.WebSocket;
import com.neovisionaries.ws.client.WebSocketFactory;

import io.moj.java.sdk.logging.Log;

/**
 * Created by alexc on 2017-04-25.
 */

public class MojioWebSocket {
    private static WebSocketFactory factory;
    private String baseUrl;
    private String accessToken;
    private HashMap<MojioWebSocketListener, WebSocket> listenerWebSocketMap = new HashMap<>();

    public MojioWebSocket(String baseUrl) {
        if (factory == null) {
            factory = new WebSocketFactory();
            this.baseUrl = baseUrl;
        }
    }

    public void setAccessToken(String token) {
        accessToken = "Bearer " + token;
    }

    public void connect(String suffix, MojioWebSocketListener listener) throws IOException {
        String url = baseUrl + suffix;
        WebSocket ws = getSocket(url);


        if (ws == null) {
            ws = factory.createSocket(url);
            ws.addHeader("Authorization", accessToken);
            Log.d("Alex", url + ", " + accessToken);
            ws.connectAsynchronously();
        }

        ws.addListener(listener);
        listenerWebSocketMap.put(listener, ws);
    }

    public void disconnect(MojioWebSocketListener listener) {
        WebSocket ws = listenerWebSocketMap.remove(listener);
        if (ws != null) {
            ws.removeListener(listener);
            if (!listenerWebSocketMap.containsValue(ws)) {
                ws.disconnect();
            }
        }
    }

//    public void getVehicle(String id, MojioWebSocketListener listener) throws IOException {
//        String url = baseUrl + "vehicle/" + id;
//        connect(url, listener);
//    }
//
//    public void getVehicles(MojioWebSocketListener listener) throws IOException {
//        String url = baseUrl + "vehicles";
//        connect(url, listener);
//    }
//
//    public void getMojio(String id, MojioWebSocketListener listener) throws IOException {
//        String url = baseUrl + "mojio/" + id;
//        connect(url, listener);
//    }
//
//    public void getMojios(MojioWebSocketListener listener) throws IOException {
//        String url = baseUrl + "mojios";
//        connect(url, listener);
//    }

    private WebSocket getSocket(String url) {
        for (WebSocket ws : listenerWebSocketMap.values()) {
            if (ws.getURI().toString().equalsIgnoreCase(url)) {
                return ws;
            }
        }
        return null;
    }
}
