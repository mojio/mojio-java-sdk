package io.moj.java.sdk.websocket;

import java.io.IOException;

/**
 * Mojio WebSocket API
 * Created by alexc on 2017-05-01.
 */

public interface MojioWebSocketApi {

    void getVehicles(MojioWebSocketListener listener) throws IOException;

    void getVehicle(String id, MojioWebSocketListener listener) throws IOException;

    void getMojios(MojioWebSocketListener listener) throws IOException;

    void getMojio(String id, MojioWebSocketListener listener) throws IOException;

    void removeListener(MojioWebSocketListener listener);
}
