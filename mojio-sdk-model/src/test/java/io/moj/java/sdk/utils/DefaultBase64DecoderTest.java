package io.moj.java.sdk.utils;

import org.junit.Test;

import io.moj.java.sdk.model.interfaces.Base64Decoder;

import static com.google.common.truth.Truth.assertThat;

/**
 * Created by Mauro on 2017-08-04.
 */
public class DefaultBase64DecoderTest {

    @Test
    public void testDecodeBase64() {
        Base64Decoder decoder = new DefaultBase64Decoder();
        assertThat(decoder.decodeBase64("aGVsbG8gd29ybGQ=")).isEqualTo("hello world");
        assertThat(decoder.decodeBase64("MTIzNDU2Nzg5MA==")).isEqualTo("1234567890");
        assertThat(decoder.decodeBase64("eyJhYWEiOiIxMTEiLCJiYmIiOiIyMjIifQ==")).isEqualTo("{\"aaa\":\"111\",\"bbb\":\"222\"}");
    }
}
