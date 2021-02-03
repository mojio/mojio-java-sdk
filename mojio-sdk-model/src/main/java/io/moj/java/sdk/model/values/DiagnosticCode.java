package io.moj.java.sdk.model.values;

import com.google.gson.annotations.SerializedName;

import io.moj.java.sdk.model.enums.RiskSeverity;

import java.io.Serializable;

/**
 * Model object for an DiagnosticCode value.
 * Created by mhorie on 2016-01-12.
 */
public class DiagnosticCode implements Serializable {

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

    // This flag is used to specify DiagnosticCode generated from received warnings
    // as they don't have a specific code (e.t. Tire Pressure, Engine Oil)
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

    public Boolean getIsExtraCode() { return IsExtraCode; }

    public void setIsExtraCode(Boolean specialCode) { IsExtraCode = specialCode; }

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
