package com.dff.cordova.plugin.packagemanager.model.json;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.content.pm.ApplicationInfo;

public class JSONApplicationInfo {

	public static JSONObject toJSON(ApplicationInfo applicationinfo) throws JSONException {
		JSONObject jsonApplicationInfo = new JSONObject();
		JSONArray jsonSharedLibraryFiles = new JSONArray();
		
		jsonApplicationInfo.put("backupAgentName", applicationinfo.backupAgentName);
		jsonApplicationInfo.put("className", applicationinfo.className);
		jsonApplicationInfo.put("compatibleWidthLimitDp", applicationinfo.compatibleWidthLimitDp);
		jsonApplicationInfo.put("dataDir", applicationinfo.dataDir);
		jsonApplicationInfo.put("descriptionRes", applicationinfo.descriptionRes);
		jsonApplicationInfo.put("enabled", applicationinfo.enabled);
		jsonApplicationInfo.put("flags", applicationinfo.flags);
		jsonApplicationInfo.put("largestWidthLimitDp", applicationinfo.largestWidthLimitDp);
		jsonApplicationInfo.put("manageSpaceActivityName", applicationinfo.manageSpaceActivityName);
		jsonApplicationInfo.put("nativeLibraryDir", applicationinfo.nativeLibraryDir);
		jsonApplicationInfo.put("permission", applicationinfo.permission);
		jsonApplicationInfo.put("processName", applicationinfo.processName);
		jsonApplicationInfo.put("publicSourceDir", applicationinfo.publicSourceDir);
		jsonApplicationInfo.put("requiresSmallestWidthDp", applicationinfo.requiresSmallestWidthDp);
		
		if (applicationinfo.sharedLibraryFiles != null) {
			for (int i = 0; i < applicationinfo.sharedLibraryFiles.length; i++) {
				jsonSharedLibraryFiles.put(applicationinfo.sharedLibraryFiles[i]);
			}
			
			jsonApplicationInfo.put("sharedLibraryFiles", jsonSharedLibraryFiles);			
		}
		
		jsonApplicationInfo.put("sourceDir", applicationinfo.sourceDir);
		jsonApplicationInfo.put("targetSdkVersion", applicationinfo.targetSdkVersion);
		jsonApplicationInfo.put("taskAffinity", applicationinfo.taskAffinity);
		jsonApplicationInfo.put("theme", applicationinfo.theme);
		jsonApplicationInfo.put("uiOptions", applicationinfo.uiOptions);
		jsonApplicationInfo.put("uid", applicationinfo.uid);
		
		return jsonApplicationInfo;
	}
}
