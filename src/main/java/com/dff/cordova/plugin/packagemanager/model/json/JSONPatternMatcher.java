package com.dff.cordova.plugin.packagemanager.model.json;

import android.os.PatternMatcher;
import org.json.JSONException;
import org.json.JSONObject;

public class JSONPatternMatcher {
    public static JSONObject toJSON(PatternMatcher matcher) throws JSONException {
        JSONObject jsonPatternMatcher = new JSONObject();
        String typeName = null;

        if (matcher != null) {
            jsonPatternMatcher.put("path", matcher.getPath());
            jsonPatternMatcher.put("type", matcher.getType());

            switch (matcher.getType()) {
                case PatternMatcher.PATTERN_LITERAL:
                    typeName = "PATTERN_LITERAL";
                    break;
                case PatternMatcher.PATTERN_PREFIX:
                    typeName = "PATTERN_PREFIX";
                    break;
                case PatternMatcher.PATTERN_SIMPLE_GLOB:
                    typeName = "PATTERN_SIMPLE_GLOB";
                    break;
            }

            jsonPatternMatcher.put("typeName", typeName);
        }

        return jsonPatternMatcher;
    }
}
