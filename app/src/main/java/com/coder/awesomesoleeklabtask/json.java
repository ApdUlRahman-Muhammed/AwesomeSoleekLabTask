package com.coder.awesomesoleeklabtask;

import android.content.Context;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class json {
    Context c;

    public json(Context context) {
        c = context;
    }

    public ArrayList<String> JSONParser(String json) {
        ArrayList<String> countries = new ArrayList<>();
        try {
            JSONArray jsonArray = new JSONArray(json);
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject results = jsonArray.getJSONObject(i);
                String name=results.getString("name");
                countries.add(name);
            }
            return countries;
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;

    }
}


