package com.dff.cordova.plugin.packagemanager.model.json;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.content.pm.ServiceInfo;

public class JSONServiceInfo {
	public static JSONObject toJSON(ServiceInfo serviceInfo) throws JSONException {
		JSONObject jsonServiceInfo = new JSONObject();
		
		jsonServiceInfo.put("name", serviceInfo.name);
		jsonServiceInfo.put("packageName", serviceInfo.packageName);
		jsonServiceInfo.put("processName", serviceInfo.processName);
		jsonServiceInfo.put("isEnabled", serviceInfo.isEnabled());
		jsonServiceInfo.put("enabled", serviceInfo.enabled);
		jsonServiceInfo.put("exported", serviceInfo.exported);
		jsonServiceInfo.put("permission", serviceInfo.permission);
		
		JSONArray jsonFlags = new JSONArray();
		
		if ((ServiceInfo.FLAG_ISOLATED_PROCESS & serviceInfo.flags) == ServiceInfo.FLAG_ISOLATED_PROCESS) {
			jsonFlags.put("FLAG_ISOLATED_PROCESS");
		}
		
		if ((ServiceInfo.FLAG_SINGLE_USER & serviceInfo.flags) == ServiceInfo.FLAG_SINGLE_USER) {
			jsonFlags.put("FLAG_SINGLE_USER");
		}
		
		if ((ServiceInfo.FLAG_STOP_WITH_TASK & serviceInfo.flags) == ServiceInfo.FLAG_STOP_WITH_TASK) {
			jsonFlags.put("FLAG_STOP_WITH_TASK");
		}
		
		jsonServiceInfo.put("flags", jsonFlags);
		
		return jsonServiceInfo;
	}
}
