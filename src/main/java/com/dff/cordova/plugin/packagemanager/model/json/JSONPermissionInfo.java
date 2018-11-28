package com.dff.cordova.plugin.packagemanager.model.json;

import org.json.JSONException;
import org.json.JSONObject;

import android.content.pm.PermissionInfo;

public class JSONPermissionInfo {
	public static JSONObject toJSON(PermissionInfo permissionInfo) throws JSONException {
		JSONObject jsonPermission = new JSONObject();
		
		jsonPermission.put("descriptionRes", permissionInfo.descriptionRes);
		jsonPermission.put("flags", permissionInfo.flags);
		jsonPermission.put("group", permissionInfo.group);

		if (permissionInfo.nonLocalizedDescription != null) {
			jsonPermission.put("nonLocalizedDescription", permissionInfo.nonLocalizedDescription.toString());
		}

		jsonPermission.put("protectionLevel", permissionInfo.protectionLevel);
		
		return jsonPermission;
	}
}
