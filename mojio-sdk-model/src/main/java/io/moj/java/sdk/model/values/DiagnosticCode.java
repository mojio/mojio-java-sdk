package io.moj.java.sdk.model.values;

import io.moj.java.sdk.model.enums.RiskSeverity;

/**
 * Model object for an DiagnosticCode value.
 * Created by mhorie on 2016-01-12.
 */
public class DiagnosticCode {

    private String Code;
    private String Description ;
    private String Timestamp;
    private RiskSeverity Severity;
    private String Instructions;
    private Boolean Ignored;

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

    @Override
    public String toString() {
        return "DiagnosticCode{" +
                "Code='" + Code + '\'' +
                ", Description='" + Description + '\'' +
                ", Timestamp='" + Timestamp + '\'' +
                ", Severity=" + Severity +
                ", Instructions='" + Instructions + '\'' +
                ", Ignored=" + Ignored +
                '}';
    }
}
