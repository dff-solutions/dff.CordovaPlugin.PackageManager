package com.dff.cordova.plugin.packagemanager.model.json;

import org.json.JSONException;
import org.json.JSONObject;

import android.content.pm.FeatureInfo;

public class JSONFeatureInfo {
	public static JSONObject toJSON(FeatureInfo featureInfo) throws JSONException {
		JSONObject jsonFeatureInfo = new JSONObject();
		
		
		jsonFeatureInfo.put("flags", featureInfo.flags);
		jsonFeatureInfo.put("name", featureInfo.name);
		jsonFeatureInfo.put("reqGlEsVersion", featureInfo.reqGlEsVersion);
		
		return jsonFeatureInfo;
	}
}
