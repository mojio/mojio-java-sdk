package io.moj.java.sdk.model.enums;

import com.google.gson.annotations.SerializedName;

import io.moj.java.sdk.math.Multiplier;
import io.moj.java.sdk.math.UnitConverter;

import java.util.Locale;

/**
 * When Google Maps reverse geocoding returns an address, if a road is not named, the name will
 * be defaulted to "Unnamed Road", regardless of the language. Our Mojio platform does not translate
 * this - it passes what Google has directly to client.
 *
 * An example of unnamed road is at lat=26.26467 lng=78.22317. (On Google Maps webpage, they do
 * not show a road name. When doing reverse geocoding, "Unnamed Road" is returned.
 *
 * This enum simply contains the "Unnamed Road" translation for all languages that Mojio supports, and
 * do a string replace.
 *
 * We should *not* have to worry about "Unnamed Road" found as part of City, County, House number, etc.
 */
public enum UnnamedRoadTranslation {

    CS("Místo bez č.p."),
    DE("Unbenannte Straße"),
    ES("Camino sin nombre"),
    FR("Route sans nom"),
    PL("Droga bez nazwy");

    private static final String UNNAMED_ROAD_UNTRANSLATED = "Unnamed Road";
    private String unnamedRoadTranslated;

    UnnamedRoadTranslation(String unnamedRoadTranslated) {
        this.unnamedRoadTranslated = unnamedRoadTranslated;
    }

    public static String replaceAnyUnnamedRoadWithLocalizedString(String address) {
        if (address != null) {
            String currentLanguage = Locale.getDefault().getLanguage().toUpperCase();

            for (UnnamedRoadTranslation str : values()) {
                if (str.name().equalsIgnoreCase(currentLanguage)) {
                    return address.replace(UNNAMED_ROAD_UNTRANSLATED, str.unnamedRoadTranslated);
                }
            }
        }
        return address;
    }
}