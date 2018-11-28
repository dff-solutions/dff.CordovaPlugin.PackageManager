package com.dff.cordova.plugin.packagemanager.model.json;

import android.content.IntentFilter;
import org.json.JSONException;
import org.json.JSONObject;

public class JSONIntentFilterAuthorityEntry {
    public static JSONObject toJSON(IntentFilter.AuthorityEntry entry) throws JSONException {
        JSONObject jsonEntry = new JSONObject();

        if (entry != null) {
            jsonEntry.put("host", entry.getHost());
            jsonEntry.put("port", entry.getPort());
        }

        return jsonEntry;
    }
}
