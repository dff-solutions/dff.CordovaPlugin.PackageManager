package com.dff.cordova.plugin.packagemanager.model.json;

import org.json.JSONException;
import org.json.JSONObject;

import android.content.pm.ServiceInfo;

public class JSONServiceInfo {
	public static JSONObject toJSON(ServiceInfo servicInfo) throws JSONException {
		JSONObject jsonServiceInfo = new JSONObject();
		
		jsonServiceInfo.put("flags", servicInfo.flags);
		jsonServiceInfo.put("permission", servicInfo.permission);
		
		return jsonServiceInfo;
	}
}
