package io.moj.java.sdk;

import java.util.Collections;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/**
 * An enumeration of different backend endpoints for the Mojio API.
 * Created by skidson on 15-11-09.
 */
public enum MojioEnvironment implements Environment {

    PROD(""),
    STAGING("staging"),
    DEVELOP("develop"),
    TRIAL("trial"),
    LOAD("load");

    private static final int DEFAULT_VERSION = 2;
    private static final String HTTPS = "https://";
    private static final String WSS = "wss://";
    private static final String FORMAT_ACCOUNTS_HOSTNAME = HTTPS + "%saccounts.moj.io";
    private static final String FORMAT_MY_MOJIO_HOSTNAME = HTTPS + "%smy.moj.io";
    private static final String FORMAT_HTTPS_API_HOSTNAME = HTTPS + "%sapi.moj.io/v%d";
    private static final String FORMAT_WSS_API_HOSTNAME = WSS + "%sapi.moj.io/v%d";
    private static final String FORMAT_PUSH_HOSTNAME = HTTPS + "%spush.moj.io/v%d";
    private static final String PATH_FORGOT_PASSWORD = "/account/forgot-password";

    private static final Map<String, MojioEnvironment> PREFIX_MAP;
    static {
        Map<String, MojioEnvironment> prefixes = new HashMap<>();
        for (MojioEnvironment environment : values())
            prefixes.put(environment.prefix, environment);
        PREFIX_MAP = Collections.unmodifiableMap(prefixes);
    }

    private final String prefix;

    MojioEnvironment(String hostname) {
        this.prefix = hostname;
    }

    @Override
    public String getAccountsUrl() {
        return String.format(Locale.US, FORMAT_ACCOUNTS_HOSTNAME, buildUrlPrefix());
    }

    @Override
    public String getPasswordRecoveryUrl() {
        return getAccountsUrl() + PATH_FORGOT_PASSWORD;
    }

    @Override
    public String getApiUrl() {
        return getApiUrl(DEFAULT_VERSION);
    }

    @Override
    public String getApiUrl(int version) {
        return String.format(Locale.US, FORMAT_HTTPS_API_HOSTNAME, buildUrlPrefix(), version);
    }

    @Override
    public String getPushUrl() {
        return getPushUrl(DEFAULT_VERSION);
    }

    @Override
    public String getPushUrl(int version) {
        return String.format(Locale.US, FORMAT_PUSH_HOSTNAME, buildUrlPrefix(), version);
    }

    @Override
    public String getMyMojioUrl() {
        return String.format(Locale.US, FORMAT_MY_MOJIO_HOSTNAME, buildUrlPrefix());
    }

    @Override
    public String getWsUrl() {
        return getWsUrl(DEFAULT_VERSION);
    }

    @Override
    public String getWsUrl(int version) {
        return String.format(Locale.US, FORMAT_WSS_API_HOSTNAME, buildUrlPrefix(), version);
    }

    @Override
    public String getPrefix() {
        return prefix;
    }

    private String buildUrlPrefix() {
        return prefix + (prefix == null || prefix.equals("") ? "" : "-");
    }

    public static MojioEnvironment getDefault() {
        return PROD;
    }

    public static MojioEnvironment fromPrefix(String prefix) {
        return PREFIX_MAP.get(prefix);
    }

}
