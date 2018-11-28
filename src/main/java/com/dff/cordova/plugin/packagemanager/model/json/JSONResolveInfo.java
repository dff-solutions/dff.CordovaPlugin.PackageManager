package com.dff.cordova.plugin.packagemanager.model.json;

import android.content.pm.ResolveInfo;
import org.json.JSONException;
import org.json.JSONObject;

public class JSONResolveInfo {
    public static JSONObject toJSON(ResolveInfo info) throws JSONException {
        JSONObject jsonResolveInfo = new JSONObject();

        if (info != null) {
            jsonResolveInfo.put("icon", info.icon);
            jsonResolveInfo.put("isDefault", info.isDefault);
            jsonResolveInfo.put("labelRes", info.labelRes);
            jsonResolveInfo.put("match", info.match);
            jsonResolveInfo.put("preferredOrder", info.preferredOrder);
            jsonResolveInfo.put("priority", info.priority);
            jsonResolveInfo.put("specificIndex", info.specificIndex);
            jsonResolveInfo.put("resolvePackageName", info.resolvePackageName);

            if (info.nonLocalizedLabel != null) {
                jsonResolveInfo.put("nonLocalizedLabel", info.nonLocalizedLabel);
            }

            // json objects
            jsonResolveInfo.put("activityInfo", JSONActivityInfo.toJSON(info.activityInfo));
            jsonResolveInfo.put("filter", JSONIntentFilter.toJSON(info.filter));
            jsonResolveInfo.put("providerInfo", JSONProviderInfo.toJSON(info.providerInfo));
            jsonResolveInfo.put("serviceInfo", JSONServiceInfo.toJSON(info.serviceInfo));
        }

        return jsonResolveInfo;
    }
}
