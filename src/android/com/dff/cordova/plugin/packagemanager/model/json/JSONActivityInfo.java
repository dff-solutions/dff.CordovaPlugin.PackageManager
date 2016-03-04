package com.dff.cordova.plugin.packagemanager.model.json;

import org.json.JSONException;
import org.json.JSONObject;

import android.content.pm.ActivityInfo;

public class JSONActivityInfo {
	public static JSONObject toJSON(ActivityInfo activityinfo) throws JSONException {
		JSONObject jsonActivityInfo = new JSONObject();
		
		jsonActivityInfo.put("configChanges", activityinfo.configChanges);
		jsonActivityInfo.put("flags", activityinfo.flags);
		jsonActivityInfo.put("launchMode", activityinfo.launchMode);
		jsonActivityInfo.put("parentActivityName", activityinfo.parentActivityName);
		jsonActivityInfo.put("permission", activityinfo.permission);
		jsonActivityInfo.put("screenOrientation", activityinfo.screenOrientation);
		jsonActivityInfo.put("softInputMode", activityinfo.softInputMode);
		jsonActivityInfo.put("targetActivity", activityinfo.targetActivity);
		jsonActivityInfo.put("theme", activityinfo.theme);
		jsonActivityInfo.put("uiOptions", activityinfo.uiOptions);
		
		return jsonActivityInfo;		
	}
}
