package io.moj.java.sdk.model;

import com.google.gson.annotations.SerializedName;

public class TirePressureObject {
    @SerializedName(value = "tp_wrn")
    private Boolean tpWrn;

    @SerializedName(value = "rftp_st")
    private String rftpSt;

    @SerializedName(value = "rrtp_st")
    private String rrtpSt;

    @SerializedName(value = "rrotp_st")
    private String rrotpSt;

    @SerializedName(value = "lftp_st")
    private String lftpSt;

    @SerializedName(value = "lrtp_st")
    private String lrtpSt;

    @SerializedName(value = "lrotp_st")
    private String lrotpSt;

    public Boolean getTpWrn() {
        return tpWrn;
    }

    public void setTpWrn(Boolean tpWrn) {
        this.tpWrn = tpWrn;
    }

    public String getRftpSt() {
        return rftpSt;
    }

    public void setRftpSt(String rftpSt) {
        this.rftpSt = rftpSt;
    }

    public String getRrtpSt() {
        return rrtpSt;
    }

    public void setRrtpSt(String rrtpSt) {
        this.rrtpSt = rrtpSt;
    }

    public String getRrotpSt() {
        return rrotpSt;
    }

    public void setRrotpSt(String rrotpSt) {
        this.rrotpSt = rrotpSt;
    }

    public String getLftpSt() {
        return lftpSt;
    }

    public void setLftpSt(String lftpSt) {
        this.lftpSt = lftpSt;
    }

    public String getLrtpSt() {
        return lrtpSt;
    }

    public void setLrtpSt(String lrtpSt) {
        this.lrtpSt = lrtpSt;
    }

    public String getLrotpSt() {
        return lrotpSt;
    }

    public void setLrotpSt(String lrotpSt) {
        this.lrotpSt = lrotpSt;
    }

    @Override
    public String toString() {
        return "TirePressureObject{" +
                "tpWrn=" + tpWrn +
                ", rftpSt='" + rftpSt + '\'' +
                ", rrtpSt='" + rrtpSt + '\'' +
                ", rrotpSt='" + rrotpSt + '\'' +
                ", lftpSt='" + lftpSt + '\'' +
                ", lrtpSt='" + lrtpSt + '\'' +
                ", lrotpSt='" + lrotpSt + '\'' +
                '}';
    }
}
