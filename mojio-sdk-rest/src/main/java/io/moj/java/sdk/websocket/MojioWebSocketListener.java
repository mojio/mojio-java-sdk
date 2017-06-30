package io.moj.java.sdk.websocket;

import com.neovisionaries.ws.client.WebSocket;
import com.neovisionaries.ws.client.WebSocketAdapter;
import com.neovisionaries.ws.client.WebSocketException;
import com.neovisionaries.ws.client.WebSocketFrame;

import java.util.List;
import java.util.Map;

/**
 * WebSocket listener class. Note that these methods will be called on a background thread and not
 * the main thread.
 * Created by alexc on 2017-04-27.
 */

public abstract class MojioWebSocketListener extends WebSocketAdapter {

    @Override
    public void onTextMessage(WebSocket websocket, String text) {
        onResponse(text);
    }

    @Override
    public void onConnected(WebSocket websocket, Map<String, List<String>> headers) throws Exception {
        onConnected(headers);
    }

    @Override
    public void onDisconnected(WebSocket websocket, WebSocketFrame serverCloseFrame, WebSocketFrame clientCloseFrame, boolean closedByServer) throws Exception {
        onDisconnected();
    }

    @Override
    public void onError(WebSocket websocket, WebSocketException cause) throws Exception {
        onError(cause);
    }

    abstract public void onResponse(String text);

    abstract public void onConnected(Map<String, List<String>> headers);

    abstract public void onDisconnected();

    abstract public void onError(Exception e);
}
