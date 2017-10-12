package com.dff.cordova.plugin.packagemanager.model.json;

import org.json.JSONException;
import org.json.JSONObject;

import android.os.PatternMatcher;

public class JSONUriPermissionPatterns {
	public static JSONObject toJSON(PatternMatcher patternMatcher) throws JSONException {
		JSONObject jsonPatternMatcher = new JSONObject();
		
		jsonPatternMatcher.put("type", patternMatcher.getType());
		jsonPatternMatcher.put("path", patternMatcher.getPath());
		
		return jsonPatternMatcher;
	}
}
