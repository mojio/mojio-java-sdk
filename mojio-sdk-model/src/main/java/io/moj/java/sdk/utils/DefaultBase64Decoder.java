package io.moj.java.sdk.utils;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.StringUtils;

import io.moj.java.sdk.model.interfaces.Base64Decoder;

/**
 * Base implementation for Base 64 encoding.
 * Created by Mauro on 2017-08-04.
 */
public class DefaultBase64Decoder implements Base64Decoder {

    public String decodeBase64(String encoded) {
        byte[] payloadBytes = StringUtils.getBytesUtf8(encoded);
        return StringUtils.newStringUtf8(Base64.decodeBase64(payloadBytes));
    }
}
