package io.moj.java.sdk.model;

import com.google.gson.annotations.SerializedName;

public class EmailRequest {

    public EmailRequest(String email) {
        this.email = email;
    }

    @SerializedName("Email")
    private String email;

    public String get_email() {
        return email;
    }

    public void set_email(String _email) {
        this.email = _email;
    }

}
