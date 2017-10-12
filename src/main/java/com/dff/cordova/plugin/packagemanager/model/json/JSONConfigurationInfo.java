package com.dff.cordova.plugin.packagemanager.model.json;

import org.json.JSONException;
import org.json.JSONObject;

import android.content.pm.ConfigurationInfo;

public class JSONConfigurationInfo {

	public static JSONObject toJSON(ConfigurationInfo configurationInfo) throws JSONException {
		JSONObject jsonConfigurationInfo = new JSONObject();
		
		jsonConfigurationInfo.put("reqGlEsVersion", configurationInfo.reqGlEsVersion);
		jsonConfigurationInfo.put("reqInputFeatures", configurationInfo.reqInputFeatures);
		jsonConfigurationInfo.put("reqKeyboardType", configurationInfo.reqKeyboardType);
		jsonConfigurationInfo.put("reqNavigation", configurationInfo.reqNavigation);
		jsonConfigurationInfo.put("reqTouchScreen", configurationInfo.reqTouchScreen);
		
		return jsonConfigurationInfo;
	}
}
