package com.dff.cordova.plugin.packagemanager.model.json;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.content.pm.ActivityInfo;
import android.content.pm.ConfigurationInfo;
import android.content.pm.InstrumentationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PermissionInfo;
import android.content.pm.ProviderInfo;
import android.content.pm.ServiceInfo;
import android.content.pm.Signature;

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
			
			for (ActivityInfo ai : packageinfo.activities) {
				jsonActivityInfo.put(JSONActivityInfo.toJSON(ai));
			}
			
			jsonPackageInfo.put("activities", jsonActivityInfo);
		}
		
		if (packageinfo.applicationInfo != null) {
			jsonPackageInfo.put("applicationInfo", JSONApplicationInfo.toJSON(packageinfo.applicationInfo));
		}
		
		JSONArray jsonConfigPreferences = new JSONArray();
		if (packageinfo.configPreferences != null) {
			for (ConfigurationInfo ci : packageinfo.configPreferences) {
				jsonConfigPreferences.put(JSONConfigurationInfo.toJSON(ci));
			}				
		}
		jsonPackageInfo.put("configPreferences", jsonConfigPreferences);
		
		JSONArray jsonGids = new JSONArray();
		if (packageinfo.gids != null) {
			for (int gid : packageinfo.gids) {
				jsonGids.put(gid);
			}
		}
		jsonPackageInfo.put("gids", jsonGids);
		
		JSONArray jsonInstrumentation = new JSONArray();
		if (packageinfo.instrumentation != null) {
			for (InstrumentationInfo ii : packageinfo.instrumentation) {
				jsonInstrumentation.put(JSONInstrumentationInfo.toJSON(ii));
			}
		}
		jsonPackageInfo.put("instrumentation", jsonInstrumentation);
		
		JSONArray jsonPermissions = new JSONArray();
		if (packageinfo.permissions != null) {
			for (PermissionInfo pi : packageinfo.permissions) {
				jsonPermissions.put(JSONPermissionInfo.toJSON(pi));
			}
		}
		jsonPackageInfo.put("permissions", jsonPermissions);
		
		JSONArray jsonProviders = new JSONArray();
		if (packageinfo.providers != null) {
			for (ProviderInfo pi : packageinfo.providers) {
				jsonProviders.put(JSONProviderInfo.toJSON(pi));
			}
		}
		jsonPackageInfo.put("providers", jsonProviders);
		
		JSONArray jsonReceivers = new JSONArray();
		if (packageinfo.receivers != null) {
			for (ActivityInfo ai : packageinfo.receivers) {
				jsonReceivers.put(JSONActivityInfo.toJSON(ai));
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
			for (String reqPermission : packageinfo.requestedPermissions) {
				jsonRequestedPermissions.put(reqPermission);
			}
		}
		jsonPackageInfo.put("requestedPermissions", jsonRequestedPermissions);
		
		JSONArray jsonRequestedPermissionsFlags = new JSONArray();
		if (packageinfo.requestedPermissionsFlags != null) {
			for (int reqPermissionFlag : packageinfo.requestedPermissionsFlags) {
				jsonRequestedPermissionsFlags.put(reqPermissionFlag);
			}
		}
		jsonPackageInfo.put("requestedPermissionsFlags", jsonRequestedPermissionsFlags);
		
		JSONArray jsonServices = new JSONArray();
		if (packageinfo.services != null) {
			for (ServiceInfo si : packageinfo.services) {
				jsonServices.put(JSONServiceInfo.toJSON(si));
			}
		}
		jsonPackageInfo.put("services", jsonServices);
		
		JSONArray jsonSignatures = new JSONArray();
		if (packageinfo.signatures != null) {
			for (Signature signature : packageinfo.signatures) {
				jsonSignatures.put(JSONSignature.toJSON(signature));
			}
		}
		jsonPackageInfo.put("signatures", jsonSignatures);
		
		return jsonPackageInfo;
	}
}
