package com.udacity.sandwichclub.utils;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JsonUtils {

    public static final String KEY_MAIN_NAME = "mainName";
    public static final String KEY_ALSO_KNOW_AS = "alsoKnownAs";
    public static final String KEY_PLACE_OF_ORIGIN = "placeOfOrigin";
    public static final String KEY_DESCRIPTION = "description";
    public static final String KEY_IMAGE = "image";
    public static final String INGREDIENTS = "ingredients";

    public static Sandwich parseSandwichJson(String json) {

        try {
            JSONObject jsonObj = new JSONObject(json);
            JSONObject nameObj = jsonObj.getJSONObject(KEY_NAME);
            String mainName = nameObj.optString(KEY_MAIN_NAME);
            JSONArray alsoKnownAsArray = nameObj.getJSONArray(KEY_ALSO_KNOW_AS);
            List<String> alsoKnownAsList = convertToList(alsoKnownAsArray);

            String placeOfOrigin = jsonObj.optString(KEY_PLACE_OF_ORIGIN);
            String description = jsonObj.optString(KEY_DESCRIPTION);
            String image = jsonObj.optString(KEY_IMAGE);
            JSONArray ingredientsArray = jsonObj.getJSONArray(INGREDIENTS);
            List<String> ingredientList = convertToList(ingredientsArray);

            return new Sandwich(mainName, alsoKnownAsList, placeOfOrigin, description, image, ingredientList);
        }
        catch (JSONException e) {

        }
        return null;
    }

    private static List<String> convertToList(JSONArray jsonArray) throws JSONException {
        List<String> strings = new ArrayList<String>();

        for (int i = 0; i < jsonArray.length(); i++) {
            strings.add(jsonArray.optString(i));
        }
        return strings;
    }
}
