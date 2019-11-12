package io.moj.java.sdk.model.values;

import com.google.gson.annotations.SerializedName;

import java.util.Objects;

public class Country {

    @SerializedName("name")
    public String name;

    @SerializedName("telcc")
    public Integer code;

    @SerializedName("alpha2")
    public String alpha2;

    @Override
    public int hashCode() {
        int result = code != null ? code.hashCode() : 0;
        result = 31 * result + (code != null ? code.hashCode() : 0);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Country country = (Country) o;

        if (!Objects.equals(code, country.code)) return false;
        return Objects.equals(name, country.name);

    }

    @Override
    public String toString() {
        return "Country{" +
                "alpha2='" + alpha2 + '\'' +
                ", name='" + name + '\'' +
                ", code=" + code +
                '}';
    }
}
