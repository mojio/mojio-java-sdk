package io.moj.mobile.android.sdk.model.values;

/**
 * Model object for a vehicle recall.
 * Created by skidson on 16-03-10.
 */
public class Recall {

    private String Title;
    private String NHTSACampaignNumber;
    private String MFRCampaignNumber;
    private String ComponentDescription;
    private String ReportManufacturer;
    private String ManufacturingStartDate;
    private String ManufacturingEndDate;
    private String RecallTypeCode;
    private String PotentialUnitsAffected;
    private String OwnerNotificationDate;
    private String RecallInitiator;
    private String ProductManufacturer;
    private String ReportReceivedDate;
    private String RecordCreationDate;
    private String RegulationPartNumber;
    private String FMVVSNumber;
    private String DefectSummary;
    private String ConsequenceSummary;
    private String CorrectiveAction;
    private String Notes;
    private String RecalledComponentId;

    public String getComponentDescription() {
        return ComponentDescription;
    }

    public void setComponentDescription(String componentDescription) {
        ComponentDescription = componentDescription;
    }

    public String getConsequenceSummary() {
        return ConsequenceSummary;
    }

    public void setConsequenceSummary(String consequenceSummary) {
        ConsequenceSummary = consequenceSummary;
    }

    public String getCorrectiveAction() {
        return CorrectiveAction;
    }

    public void setCorrectiveAction(String correctiveAction) {
        CorrectiveAction = correctiveAction;
    }

    public String getDefectSummary() {
        return DefectSummary;
    }

    public void setDefectSummary(String defectSummary) {
        DefectSummary = defectSummary;
    }

    public String getFMVVSNumber() {
        return FMVVSNumber;
    }

    public void setFMVVSNumber(String FMVVSNumber) {
        this.FMVVSNumber = FMVVSNumber;
    }

    public String getManufacturingEndDate() {
        return ManufacturingEndDate;
    }

    public void setManufacturingEndDate(String manufacturingEndDate) {
        ManufacturingEndDate = manufacturingEndDate;
    }

    public String getManufacturingStartDate() {
        return ManufacturingStartDate;
    }

    public void setManufacturingStartDate(String manufacturingStartDate) {
        ManufacturingStartDate = manufacturingStartDate;
    }

    public String getMFRCampaignNumber() {
        return MFRCampaignNumber;
    }

    public void setMFRCampaignNumber(String MFRCampaignNumber) {
        this.MFRCampaignNumber = MFRCampaignNumber;
    }

    public String getNHTSACampaignNumber() {
        return NHTSACampaignNumber;
    }

    public void setNHTSACampaignNumber(String NHTSACampaignNumber) {
        this.NHTSACampaignNumber = NHTSACampaignNumber;
    }

    public String getNotes() {
        return Notes;
    }

    public void setNotes(String notes) {
        Notes = notes;
    }

    public String getOwnerNotificationDate() {
        return OwnerNotificationDate;
    }

    public void setOwnerNotificationDate(String ownerNotificationDate) {
        OwnerNotificationDate = ownerNotificationDate;
    }

    public String getPotentialUnitsAffected() {
        return PotentialUnitsAffected;
    }

    public void setPotentialUnitsAffected(String potentialUnitsAffected) {
        PotentialUnitsAffected = potentialUnitsAffected;
    }

    public String getProductManufacturer() {
        return ProductManufacturer;
    }

    public void setProductManufacturer(String productManufacturer) {
        ProductManufacturer = productManufacturer;
    }

    public String getRecalledComponentId() {
        return RecalledComponentId;
    }

    public void setRecalledComponentId(String recalledComponentId) {
        RecalledComponentId = recalledComponentId;
    }

    public String getRecallInitiator() {
        return RecallInitiator;
    }

    public void setRecallInitiator(String recallInitiator) {
        RecallInitiator = recallInitiator;
    }

    public String getRecallTypeCode() {
        return RecallTypeCode;
    }

    public void setRecallTypeCode(String recallTypeCode) {
        RecallTypeCode = recallTypeCode;
    }

    public String getRecordCreationDate() {
        return RecordCreationDate;
    }

    public void setRecordCreationDate(String recordCreationDate) {
        RecordCreationDate = recordCreationDate;
    }

    public String getRegulationPartNumber() {
        return RegulationPartNumber;
    }

    public void setRegulationPartNumber(String regulationPartNumber) {
        RegulationPartNumber = regulationPartNumber;
    }

    public String getReportManufacturer() {
        return ReportManufacturer;
    }

    public void setReportManufacturer(String reportManufacturer) {
        ReportManufacturer = reportManufacturer;
    }

    public String getReportReceivedDate() {
        return ReportReceivedDate;
    }

    public void setReportReceivedDate(String reportReceivedDate) {
        ReportReceivedDate = reportReceivedDate;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    @Override
    public String toString() {
        return "Recall{" +
                "ComponentDescription='" + ComponentDescription + '\'' +
                ", Title='" + Title + '\'' +
                ", NHTSACampaignNumber='" + NHTSACampaignNumber + '\'' +
                ", MFRCampaignNumber='" + MFRCampaignNumber + '\'' +
                ", ReportManufacturer='" + ReportManufacturer + '\'' +
                ", ManufacturingStartDate='" + ManufacturingStartDate + '\'' +
                ", ManufacturingEndDate='" + ManufacturingEndDate + '\'' +
                ", RecallTypeCode='" + RecallTypeCode + '\'' +
                ", PotentialUnitsAffected='" + PotentialUnitsAffected + '\'' +
                ", OwnerNotificationDate='" + OwnerNotificationDate + '\'' +
                ", RecallInitiator='" + RecallInitiator + '\'' +
                ", ProductManufacturer='" + ProductManufacturer + '\'' +
                ", ReportReceivedDate='" + ReportReceivedDate + '\'' +
                ", RecordCreationDate='" + RecordCreationDate + '\'' +
                ", RegulationPartNumber='" + RegulationPartNumber + '\'' +
                ", FMVVSNumber='" + FMVVSNumber + '\'' +
                ", DefectSummary='" + DefectSummary + '\'' +
                ", ConsequenceSummary='" + ConsequenceSummary + '\'' +
                ", CorrectiveAction='" + CorrectiveAction + '\'' +
                ", Notes='" + Notes + '\'' +
                ", RecalledComponentId='" + RecalledComponentId + '\'' +
                '}';
    }
}
