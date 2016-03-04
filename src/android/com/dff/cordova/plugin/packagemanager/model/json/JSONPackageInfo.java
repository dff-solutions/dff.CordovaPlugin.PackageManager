package com.dff.cordova.plugin.packagemanager.model.json;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.content.pm.PackageInfo;

public class JSONPackageInfo {

	public static JSONObject toJSON(PackageInfo packageinfo) throws JSONException {
		JSONObject jsonPackageInfo = new JSONObject();
		
		jsonPackageInfo.put("firstInstallTime", packageinfo.firstInstallTime);
		jsonPackageInfo.put("lastUpdateTime", packageinfo.lastUpdateTime);
		jsonPackageInfo.put("packageName", packageinfo.packageName);
		jsonPackageInfo.put("sharedUserId", packageinfo.sharedUserId);
		jsonPackageInfo.put("sharedUserLabel", packageinfo.sharedUserLabel);
		jsonPackageInfo.put("versionCode", packageinfo.versionCode);
		jsonPackageInfo.put("versionName", packageinfo.versionName);
		
		if (packageinfo.activities != null) {
			JSONArray jsonActivityInfo = new JSONArray();
			
			for (int i = 0; i < packageinfo.activities.length; i++) {
				jsonActivityInfo.put(JSONActivityInfo.toJSON(packageinfo.activities[i]));
			}
			
			jsonPackageInfo.put("activities", jsonActivityInfo);
		}
		
		if (packageinfo.applicationInfo != null) {
			jsonPackageInfo.put("applicationInfo", JSONApplicationInfo.toJSON(packageinfo.applicationInfo));
		}
		
		JSONArray jsonConfigPreferences = new JSONArray();
		if (packageinfo.configPreferences != null) {
			for (int i = 0; i < packageinfo.configPreferences.length; i++) {
				jsonConfigPreferences.put(JSONConfigurationInfo.toJSON(packageinfo.configPreferences[i]));					
			}				
		}
		jsonPackageInfo.put("configPreferences", jsonConfigPreferences);
		
		JSONArray jsonGids = new JSONArray();
		if (packageinfo.gids != null) {
			for (int i = 0; i < packageinfo.gids.length; i++) {
				jsonGids.put(packageinfo.gids[i]);
			}
		}
		jsonPackageInfo.put("gids", jsonGids);
		
		JSONArray jsonInstrumentation = new JSONArray();
		if (packageinfo.instrumentation != null) {
			for (int i = 0; i < packageinfo.instrumentation.length; i++) {
				jsonInstrumentation.put(JSONInstrumentationInfo.toJSON(packageinfo.instrumentation[i]));
			}
		}
		jsonPackageInfo.put("instrumentation", jsonInstrumentation);
		
		JSONArray jsonPermissions = new JSONArray();
		if (packageinfo.permissions != null) {
			for (int i = 0; i < packageinfo.permissions.length; i++) {
				jsonPermissions.put(JSONPermissionInfo.toJSON(packageinfo.permissions[i]));
			}
		}
		jsonPackageInfo.put("permissions", jsonPermissions);
		
		JSONArray jsonProviders = new JSONArray();
		if (packageinfo.providers != null) {
			for (int i = 0; i < packageinfo.providers.length; i++) {
				jsonProviders.put(JSONProviderInfo.toJSON(packageinfo.providers[i]));
			}
		}
		jsonPackageInfo.put("providers", jsonProviders);
		
		JSONArray jsonReceivers = new JSONArray();
		if (packageinfo.receivers != null) {
			for (int i = 0; i < packageinfo.receivers.length; i++) {
				jsonReceivers.put(JSONActivityInfo.toJSON(packageinfo.receivers[i]));
			}
		}
		jsonPackageInfo.put("receivers", jsonReceivers);
		
		JSONArray jsonReqFeatures = new JSONArray();
		if (packageinfo.reqFeatures != null) {
			for (int i = 0; i < packageinfo.reqFeatures.length; i++) {
				jsonReqFeatures.put(JSONFeatureInfo.toJSON(packageinfo.reqFeatures[i]));
			}
		}
		jsonPackageInfo.put("reqFeatures", jsonReqFeatures);
		
		JSONArray jsonRequestedPermissions = new JSONArray();
		if (packageinfo.requestedPermissions != null) {
			for (int i = 0; i < packageinfo.requestedPermissions.length; i++) {
				jsonRequestedPermissions.put(packageinfo.requestedPermissions[i]);
			}
		}
		jsonPackageInfo.put("requestedPermissions", jsonRequestedPermissions);
		
		JSONArray jsonRequestedPermissionsFlags = new JSONArray();
		if (packageinfo.requestedPermissionsFlags != null) {
			for (int i = 0; i < packageinfo.requestedPermissionsFlags.length; i++) {
				jsonRequestedPermissionsFlags.put(packageinfo.requestedPermissionsFlags[i]);
			}
		}
		jsonPackageInfo.put("requestedPermissionsFlags", jsonRequestedPermissionsFlags);
		
		JSONArray jsonServices = new JSONArray();
		if (packageinfo.services != null) {
			for (int i = 0; i < packageinfo.services.length; i++) {
				jsonServices.put(JSONServiceInfo.toJSON(packageinfo.services[i]));
			}
		}
		jsonPackageInfo.put("services", jsonServices);
		
		JSONArray jsonSignatures = new JSONArray();
		if (packageinfo.signatures != null) {
			for (int i = 0; i < packageinfo.signatures.length; i++) {
				jsonSignatures.put(JSONSignature.toJSON(packageinfo.signatures[i]));
			}
		}
		jsonPackageInfo.put("signatures", jsonSignatures);
		
		return jsonPackageInfo;
	}
}
