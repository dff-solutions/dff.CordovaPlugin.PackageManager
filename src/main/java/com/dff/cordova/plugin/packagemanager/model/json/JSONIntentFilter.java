package com.dff.cordova.plugin.packagemanager.model.json;

import android.content.IntentFilter;
import android.os.PatternMatcher;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Iterator;

public class JSONIntentFilter {
    public static JSONObject toJSON(IntentFilter filter) throws JSONException {
        JSONObject jsonIntentFilter = new JSONObject();
        JSONArray jsonActions = new JSONArray();
        JSONArray jsonCategories = new JSONArray();
        JSONArray jsonAuthorities = new JSONArray();
        JSONArray jsonPaths = new JSONArray();
        JSONArray jsonSchemeSpecificParts = new JSONArray();
        JSONArray jsonSchemes = new JSONArray();
        JSONArray jsonTypes = new JSONArray();

        if (filter != null) {
            // actions
            for (Iterator<String> iter = filter.actionsIterator(); iter.hasNext();) {
                jsonActions.put(iter.next());
            }

            jsonIntentFilter.put("actions", jsonActions);

            // categories
            for (Iterator<String> iter = filter.categoriesIterator(); iter.hasNext();) {
                jsonCategories.put(iter.next());
            }

            jsonIntentFilter.put("categories", jsonCategories);

            // authorities
            Iterator<IntentFilter.AuthorityEntry> authorityEntryIterator = filter.authoritiesIterator();

            if (authorityEntryIterator != null) {
                while (authorityEntryIterator.hasNext()) {
                    jsonAuthorities.put(JSONIntentFilterAuthorityEntry.toJSON(authorityEntryIterator.next()));
                }
            }

            jsonIntentFilter.put("authorities", jsonAuthorities);

            // paths
            Iterator<PatternMatcher> patternMatcherIterator = filter.pathsIterator();
            if (patternMatcherIterator != null) {
                while (patternMatcherIterator.hasNext()){
                    jsonPaths.put(JSONPatternMatcher.toJSON(patternMatcherIterator.next()));
                }
            }
            jsonIntentFilter.put("paths", jsonPaths);

            // schemeSpecificParts
            Iterator<PatternMatcher> schemeSpecificPartsIterator  = filter.schemeSpecificPartsIterator();

            if (schemeSpecificPartsIterator != null) {
                while (schemeSpecificPartsIterator.hasNext()) {
                    jsonSchemeSpecificParts.put(JSONPatternMatcher.toJSON(schemeSpecificPartsIterator.next()));
                }
            }
            jsonIntentFilter.put("schemeSpecificParts", jsonSchemeSpecificParts);

            // schemes
            Iterator<String> schemesIterator = filter.schemesIterator();

            if (schemesIterator != null) {
                while (schemesIterator.hasNext()) {
                    jsonSchemes.put(schemesIterator.next());
                }
            }
            jsonIntentFilter.put("schemes", jsonSchemes);

            // types
            Iterator<String> typesIterator = filter.typesIterator();

            if (typesIterator != null) {
                while (typesIterator.hasNext()) {
                    jsonTypes.put(typesIterator.next());
                }
            }
            jsonIntentFilter.put("types", jsonTypes);

            jsonIntentFilter.put("countActions", filter.countActions());
            jsonIntentFilter.put("countCategories", filter.countCategories());
            jsonIntentFilter.put("countDataAuthorities", filter.countDataAuthorities());
            jsonIntentFilter.put("countDataPaths", filter.countDataPaths());
            jsonIntentFilter.put("countDataSchemes", filter.countDataSchemes());
            jsonIntentFilter.put("countDataSchemeSpecificParts", filter.countDataSchemeSpecificParts());
            jsonIntentFilter.put("countDataTypes", filter.countDataTypes());
            jsonIntentFilter.put("priority", filter.getPriority());
        }

        return jsonIntentFilter;
    }
}
