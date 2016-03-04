package com.dff.cordova.plugin.packagemanager.model.json;

import org.json.JSONException;
import org.json.JSONObject;

import android.content.pm.InstrumentationInfo;

public class JSONInstrumentationInfo {

	public static JSONObject toJSON(InstrumentationInfo instrumentationInfo) throws JSONException {
		JSONObject jsonInstrumentationInfo = new JSONObject();
		
		jsonInstrumentationInfo.put("dataDir", instrumentationInfo.dataDir);
		jsonInstrumentationInfo.put("functionalTest", instrumentationInfo.functionalTest);
		jsonInstrumentationInfo.put("handleProfiling", instrumentationInfo.handleProfiling);
		jsonInstrumentationInfo.put("publicSourceDir", instrumentationInfo.publicSourceDir);
		jsonInstrumentationInfo.put("sourceDir", instrumentationInfo.sourceDir);
		jsonInstrumentationInfo.put("targetPackage", instrumentationInfo.targetPackage);
		
		return jsonInstrumentationInfo;
	}
}
