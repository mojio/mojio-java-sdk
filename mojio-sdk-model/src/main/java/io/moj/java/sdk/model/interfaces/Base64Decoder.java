package io.moj.java.sdk.model.interfaces;

/**
 * Interface for base 64 decoding.
 * Created by Mauro on 2017-08-04.
 */
public interface Base64Decoder {

    /**
     * @param encoded the UTF-8 encoded string
     * @return the decoded byte array re-stringfied in UTF-8
     */
    String decodeBase64(String encoded);

}
