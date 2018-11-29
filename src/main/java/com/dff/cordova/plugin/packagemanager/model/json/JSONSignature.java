package com.dff.cordova.plugin.packagemanager.model.json;

import org.json.JSONException;
import org.json.JSONObject;

import android.content.pm.Signature;

public class JSONSignature {
	public static JSONObject toJSON(Signature signature) throws JSONException {
		JSONObject jsonSignature = new JSONObject();
		jsonSignature.put("charsString", signature.toCharsString());
		return jsonSignature;
	}
}
