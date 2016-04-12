package io.moj.mobile.android.sdk.model.values;

/**
 * Model object for a vehicle service bulletin.
 * Created by skidson on 16-03-10.
 */
public class ServiceBulletin {

    private String ItemNumber;
    private String BulletinNumber;
    private String ReplacementBulletinNumber;
    private String DateAdded;
    private String Component;
    private String BulletinDate;
    private String Summary;

    public String getBulletinDate() {
        return BulletinDate;
    }

    public void setBulletinDate(String bulletinDate) {
        BulletinDate = bulletinDate;
    }

    public String getBulletinNumber() {
        return BulletinNumber;
    }

    public void setBulletinNumber(String bulletinNumber) {
        BulletinNumber = bulletinNumber;
    }

    public String getComponent() {
        return Component;
    }

    public void setComponent(String component) {
        Component = component;
    }

    public String getDateAdded() {
        return DateAdded;
    }

    public void setDateAdded(String dateAdded) {
        DateAdded = dateAdded;
    }

    public String getItemNumber() {
        return ItemNumber;
    }

    public void setItemNumber(String itemNumber) {
        ItemNumber = itemNumber;
    }

    public String getReplacementBulletinNumber() {
        return ReplacementBulletinNumber;
    }

    public void setReplacementBulletinNumber(String replacementBulletinNumber) {
        ReplacementBulletinNumber = replacementBulletinNumber;
    }

    public String getSummary() {
        return Summary;
    }

    public void setSummary(String summary) {
        Summary = summary;
    }

    @Override
    public String toString() {
        return "ServiceBulletin{" +
                "BulletinDate='" + BulletinDate + '\'' +
                ", ItemNumber='" + ItemNumber + '\'' +
                ", BulletinNumber='" + BulletinNumber + '\'' +
                ", ReplacementBulletinNumber='" + ReplacementBulletinNumber + '\'' +
                ", DateAdded='" + DateAdded + '\'' +
                ", Component='" + Component + '\'' +
                ", Summary='" + Summary + '\'' +
                '}';
    }
}
