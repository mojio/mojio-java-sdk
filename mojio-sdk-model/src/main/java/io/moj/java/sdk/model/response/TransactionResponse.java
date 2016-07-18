package io.moj.java.sdk.model.response;

/**
 * Model object for the response from APIs that create transactions.
 * Created by skidson on 2016-07-18.
 */
public class TransactionResponse extends MessageResponse {

    private String TransactionId;

    public String getTransactionId() {
        return TransactionId;
    }

    public void setTransactionId(String transactionId) {
        TransactionId = transactionId;
    }

    @Override
    public String toString() {
        return "TransactionResponse{" +
                "TransactionId='" + TransactionId + '\'' +
                "} " + super.toString();
    }
}
