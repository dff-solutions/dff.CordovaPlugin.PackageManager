package com.dff.cordova.plugin.packagemanager.action;

import android.content.Intent;
import android.net.Uri;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaInterface;

import com.dff.cordova.plugin.common.action.CordovaAction;

public abstract class QueryIntentAction extends CordovaAction {
    public static final String JSON_ARG_ACTION = "action";
    public static final String JSON_ARG_URI = "uri";
    public static final String JSON_ARG_FLAGS = "flags";
    public static final String JSON_ARG_CATEGORIES = "categories";
    public static final String JSON_ARG_TYPE = "type";

    public QueryIntentAction(String action, JSONArray args,
                                 CallbackContext callbackContext, CordovaInterface cordova) {
        super(action, args, callbackContext, cordova);
    }

    public Intent parseIntentFromArgs(JSONObject jsonArgs) throws JSONException {
        String action;
        Uri uri;
        Intent queryIntent = new Intent();

        if (jsonArgs != null) {
            if (!jsonArgs.isNull(JSON_ARG_ACTION)) {
                action = jsonArgs.getString(JSON_ARG_ACTION);
    
                queryIntent.setAction(action);
            }
    
            if (!jsonArgs.isNull(JSON_ARG_URI)) {
                String uriStr = jsonArgs.getString(JSON_ARG_URI);
                uri = Uri.parse(uriStr);
                queryIntent.setData(uri);
            }
    
            if (!jsonArgs.isNull(JSON_ARG_CATEGORIES)) {
                JSONArray jsonCategories = jsonArgs.getJSONArray(JSON_ARG_CATEGORIES);
                for (int i = 0; i < jsonCategories.length(); i++) {
                    queryIntent.addCategory(jsonCategories.getString(i));
                }
            }
    
            if (!jsonArgs.isNull(JSON_ARG_TYPE)) {
                queryIntent.setType(jsonArgs.getString(JSON_ARG_TYPE));
            }
        }

        return queryIntent;
    }
}
