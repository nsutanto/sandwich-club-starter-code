package com.udacity.sandwichclub.utils;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JsonUtils {

    public static Sandwich parseSandwichJson(String json) {

        try {
            JSONObject jsonObj = new JSONObject(json);
            JSONObject nameObj = jsonObj.getJSONObject("name");
            String mainName = nameObj.getString("mainName");
            JSONArray alsoKnownAsArray = nameObj.getJSONArray("alsoKnownAs");
            List<String> alsoKnownAsList = convertToList(alsoKnownAsArray);

            String placeOfOrigin = jsonObj.getString("placeOfOrigin");
            String description = jsonObj.getString("description");
            String image = jsonObj.getString("image");
            JSONArray ingredientsArray = jsonObj.getJSONArray("ingredients");
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
            strings.add(jsonArray.getString(i));
        }
        return strings;
    }
}
