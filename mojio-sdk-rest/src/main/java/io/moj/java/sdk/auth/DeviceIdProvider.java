package io.moj.java.sdk.auth;

/**
 * Interface responsible for providing unique id of the device on which this sdk is used.
 */
public interface DeviceIdProvider {

    public String getId();
}
