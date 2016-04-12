package io.moj.mobile.android.sdk.model;

import java.util.Arrays;

import io.moj.mobile.android.sdk.model.values.Email;
import io.moj.mobile.android.sdk.model.values.Image;
import io.moj.mobile.android.sdk.model.values.PhoneNumber;

/**
 * Model object for an User.
 * Created by mojio on 2016-01-13.
 */
public class User extends AbstractMojioObject {

    public static final String FIRST_NAME = "FirstName";
    public static final String LAST_NAME = "LastName";
    public static final String USERNAME = "UserName";
    public static final String EMAILS = "Emails";
    public static final String PHONE_NUMBERS = "PhoneNumbers";
    public static final String IMAGE = "Image";
    public static final String TAGS = "Tags";

    private String FirstName;
    private String LastName;
    private String UserName;
    private Email[] Emails;
    private PhoneNumber[] PhoneNumbers;
    private Image Image;
    private String[] Tags;

    public Email[] getEmails() {
        return Emails;
    }

    public void setEmails(Email[] emails) {
        Emails = emails;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public Image getImage() {
        return Image;
    }

    public void setImage(Image image) {
        Image = image;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public PhoneNumber[] getPhoneNumbers() {
        return PhoneNumbers;
    }

    public void setPhoneNumbers(PhoneNumber[] phoneNumbers) {
        PhoneNumbers = phoneNumbers;
    }

    public String[] getTags() {
        return Tags;
    }

    public void setTags(String[] tags) {
        Tags = tags;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    @Override
    public String toString() {
        return "User{" +
                "Emails=" + Arrays.toString(Emails) +
                ", FirstName='" + FirstName + '\'' +
                ", LastName='" + LastName + '\'' +
                ", UserName='" + UserName + '\'' +
                ", PhoneNumbers=" + Arrays.toString(PhoneNumbers) +
                ", Image=" + Image +
                ", Tags=" + Arrays.toString(Tags) +
                "} " + super.toString();
    }
}
