package io.moj.java.sdk.model.values;

import com.google.gson.annotations.SerializedName;

import io.moj.java.sdk.model.enums.RiskSeverity;

/**
 * Model object for an DiagnosticCode value.
 * Created by mhorie on 2016-01-12.
 */
public class DiagnosticCode {

    @SerializedName(value = "Code", alternate = "code")
    private String Code;
    @SerializedName(value = "Description", alternate = "description")
    private String Description ;
    @SerializedName(value = "Timestamp", alternate = "timestamp")
    private String Timestamp;
    @SerializedName(value = "Severity", alternate = "severity")
    private RiskSeverity Severity;
    @SerializedName(value = "Instructions", alternate = "instructions")
    private String Instructions;
    @SerializedName(value = "Ignored", alternate = "ignored")
    private Boolean Ignored;

    private Boolean IsExtraCode = false;

    public String getCode() {
        return Code;
    }

    public void setCode(String code) {
        Code = code;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getInstructions() {
        return Instructions;
    }

    public void setInstructions(String instructions) {
        Instructions = instructions;
    }

    public RiskSeverity getSeverity() {
        return Severity;
    }

    public void setSeverity(RiskSeverity severity) {
        Severity = severity;
    }

    public String getTimestamp() {
        return Timestamp;
    }

    public void setTimestamp(String timestamp) {
        Timestamp = timestamp;
    }

    public Boolean getIgnored() {
        return Ignored;
    }

    public void setIgnored(Boolean ignored) {
        Ignored = ignored;
    }

    public Boolean isExtraCode() { return IsExtraCode; }

    public void setExtraCode(Boolean specialCode) { IsExtraCode = specialCode; }

    @Override
    public String toString() {
        return "DiagnosticCode{" +
                "Code='" + Code + '\'' +
                ", Description='" + Description + '\'' +
                ", Timestamp='" + Timestamp + '\'' +
                ", Severity=" + Severity +
                ", Instructions='" + Instructions + '\'' +
                ", Ignored=" + Ignored +
                ", IsExtraCode=" + IsExtraCode +
                '}';
    }
}
