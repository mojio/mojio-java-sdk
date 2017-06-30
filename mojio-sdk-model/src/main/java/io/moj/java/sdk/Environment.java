package io.moj.java.sdk;

/**
 * Interface for a Mojio environment.
 * Created by skidson on 2016-04-14.
 */
public interface Environment {

    String getAccountsUrl();

    String getPasswordRecoveryUrl();

    String getApiUrl();

    String getApiUrl(int version);

    String getPushUrl();

    String getPushUrl(int version);

    String getWsUrl();

    String getWsUrl(int version);

    String getMyMojioUrl();

    String getPrefix();

}
