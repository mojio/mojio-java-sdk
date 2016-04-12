package io.moj.java.sdk;

import org.junit.Test;

import java.util.Locale;

import static com.google.common.truth.Truth.assertThat;
import static com.google.common.truth.Truth.assertWithMessage;
import static junit.framework.Assert.assertEquals;

/**
 * Created by skidson on 2016-04-12.
 */
public class EnvironmentTest {

    private static final String SCHEME = "https://";

    @Test
    public void testUrlLocales() {
        Environment e = Environment.getDefault();
        Locale.setDefault(Locale.US);
        String apiUrl = e.getApiUrl();
        String pushUrl = e.getPushUrl();
        String accountsUrl = e.getAccountsUrl();
        String passwordRecoveryUrl = e.getPasswordRecoveryUrl();
        String myMojioUrl = e.getMyMojioUrl();

        // Turkey's Locale is known for affecting capitalization, ensure we aren't using the default
        Locale.setDefault(new Locale("tr-TR"));
        assertThat(apiUrl).isEqualTo(e.getApiUrl());
        assertThat(pushUrl).isEqualTo(e.getPushUrl());
        assertThat(accountsUrl).isEqualTo(e.getAccountsUrl());
        assertThat(passwordRecoveryUrl).isEqualTo(e.getPasswordRecoveryUrl());
        assertThat(myMojioUrl).isEqualTo(e.getMyMojioUrl());
    }

    /**
     * Validates that environments with a prefix have a dash and those that don't do not.
     */
    @Test
    public void testPrefixes() {
        for (Environment environment : Environment.values()) {
            String prefix = environment.getPrefix();

            String[] uris = new String[] {
                    environment.getAccountsUrl(),
                    environment.getMyMojioUrl(),
                    environment.getPasswordRecoveryUrl(),
                    environment.getPushUrl(),
                    environment.getApiUrl()
            };

            for (String uri : uris) {
                assertThat(uri).isNotNull();
                assertThat(uri).startsWith(SCHEME);

                String authority = uri.substring(SCHEME.length());
                assertThat(authority).startsWith(prefix);

                // assert the authority doesn't start with a dash
                assertWithMessage("Uri '" + uri + "' should not start with a dash")
                        .that(authority).doesNotMatch("^-.*");
            }
        }
    }

    @Test
    public void testGetDefault() {
        // sanity check to make sure we don't ever accidentally release pointing anywhere but prod
        assertThat(Environment.PROD).isEqualTo(Environment.getDefault());
    }

    @Test
    public void testTypeFromKey() {
        for (Environment environment : Environment.values()) {
            Environment environmentFromPrefix = Environment.fromPrefix(environment.getPrefix());
            assertEquals(environment, environmentFromPrefix);
        }
        assertThat(Environment.fromPrefix("NotARealPrefix")).isNull();
    }


}
