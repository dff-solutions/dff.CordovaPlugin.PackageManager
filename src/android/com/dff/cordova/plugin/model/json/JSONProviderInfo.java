package com.dff.cordova.plugin.model.json;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.content.pm.ProviderInfo;

public class JSONProviderInfo {
	public static JSONObject toJSON(ProviderInfo providerInfo) throws JSONException {
		JSONObject jsonProviderInfo = new JSONObject();
		
		jsonProviderInfo.put("authority", providerInfo.authority);
		jsonProviderInfo.put("flags", providerInfo.flags);
		jsonProviderInfo.put("grantUriPermissions", providerInfo.grantUriPermissions);
		jsonProviderInfo.put("initOrder", providerInfo.initOrder);
		// jsonProviderInfo.put("isSyncable", providerInfo.isSyncable);
		jsonProviderInfo.put("multiprocess", providerInfo.multiprocess);
		jsonProviderInfo.put("readPermission", providerInfo.readPermission);
		jsonProviderInfo.put("writePermission", providerInfo.writePermission);
		
		if (providerInfo.pathPermissions != null) {
			JSONArray jsonPathPermissions = new JSONArray();
			
			for (int i = 0; i < providerInfo.pathPermissions.length; i++) {
				jsonPathPermissions.put(JSONPathPermission.toJSON(providerInfo.pathPermissions[i]));
			}
			
			jsonProviderInfo.put("pathPermissions", jsonPathPermissions);
		}
		
		if (providerInfo.uriPermissionPatterns != null) {
			JSONArray jsonUriPermissionPatterns = new JSONArray();
			
			for (int i = 0; i < providerInfo.uriPermissionPatterns.length; i++) {
				jsonUriPermissionPatterns.put(JSONUriPermissionPatterns.toJSON(providerInfo.uriPermissionPatterns[i]));
			}
			
			jsonProviderInfo.put("uriPermissionPatterns", jsonUriPermissionPatterns);
		}
		
		return jsonProviderInfo;
	}
}
