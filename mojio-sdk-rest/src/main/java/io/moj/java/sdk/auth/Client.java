package io.moj.java.sdk.auth;

/**
 * Model for encapsulating client application details.
 * Created by skidson on 2016-04-13.
 */
public class Client {

    private String key;
    private String secret;

    public Client(String key, String secret) {
        this.key = key;
        this.secret = secret;
    }

    public String getKey() {
        return key;
    }

    public String getSecret() {
        return secret;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Client client = (Client) o;

        if (key != null ? !key.equals(client.key) : client.key != null) return false;
        return secret != null ? secret.equals(client.secret) : client.secret == null;

    }

    @Override
    public int hashCode() {
        int result = key != null ? key.hashCode() : 0;
        result = 31 * result + (secret != null ? secret.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Client{" +
                "key='" + key + '\'' +
                ", secret='" + secret + '\'' +
                '}';
    }
}
