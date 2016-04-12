package io.moj.java.sdk;

import java.util.Collections;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/**
 * An enumeration of different backend endpoints for the Mojio API.
 * Created by skidson on 15-11-09.
 */
public enum Environment {

    PROD(""),
    TRIAL("trial"),
    STAGING("staging"),
    EU_PROD("eu-production"),
    EU_STAGING("eu-staging"),
    NA_PROD("na-production"),
    NA_STAGING("na-staging");

    private static final int DEFAULT_VERSION = 2;
    private static final String SCHEME = "https://";
    private static final String FORMAT_ACCOUNTS_HOSTNAME = SCHEME + "%saccounts.moj.io";
    private static final String FORMAT_MY_MOJIO_HOSTNAME = SCHEME + "%smy.moj.io";
    private static final String FORMAT_API_HOSTNAME = SCHEME + "%sapi.moj.io/v%d";
    private static final String FORMAT_PUSH_HOSTNAME = SCHEME + "%spush.moj.io/v%d";
    private static final String PATH_FORGOT_PASSWORD = "/account/forgot-password";

    private static final Map<String, Environment> PREFIX_MAP;
    static {
        Map<String, Environment> prefixes = new HashMap<>();
        for (Environment environment : values())
            prefixes.put(environment.prefix, environment);
        PREFIX_MAP = Collections.unmodifiableMap(prefixes);
    }

    private final String prefix;

    Environment(String hostname) {
        this.prefix = hostname;
    }

    public String getAccountsUrl() {
        return String.format(Locale.US, FORMAT_ACCOUNTS_HOSTNAME, buildUrlPrefix());
    }

    public String getPasswordRecoveryUrl() {
        return getAccountsUrl() + PATH_FORGOT_PASSWORD;
    }

    public String getApiUrl() {
        return getApiUrl(DEFAULT_VERSION);
    }

    public String getApiUrl(int version) {
        return String.format(Locale.US, FORMAT_API_HOSTNAME, buildUrlPrefix(), version);
    }

    public String getPushUrl() {
        return getPushUrl(DEFAULT_VERSION);
    }

    public String getPushUrl(int version) {
        return String.format(Locale.US, FORMAT_PUSH_HOSTNAME, buildUrlPrefix(), version);
    }

    public String getMyMojioUrl() {
        return String.format(Locale.US, FORMAT_MY_MOJIO_HOSTNAME, buildUrlPrefix());
    }

    public String getPrefix() {
        return prefix;
    }

    private String buildUrlPrefix() {
        return prefix + (prefix == null || prefix.equals("") ? "" : "-");
    }

    public static Environment getDefault() {
        return PROD;
    }

    public static Environment fromPrefix(String prefix) {
        return PREFIX_MAP.get(prefix);
    }

}
