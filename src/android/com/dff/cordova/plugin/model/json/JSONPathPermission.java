package com.dff.cordova.plugin.model.json;

import org.json.JSONException;
import org.json.JSONObject;

import android.content.pm.PathPermission;

public class JSONPathPermission {
	public static JSONObject toJSON(PathPermission pathPermission) throws JSONException {
		JSONObject jsonPathPermission = new JSONObject();
		
		jsonPathPermission.put("path", pathPermission.getPath());
		jsonPathPermission.put("readPermission", pathPermission.getReadPermission());
		jsonPathPermission.put("writePermission", pathPermission.getWritePermission());
		
		return jsonPathPermission;
	}
}
