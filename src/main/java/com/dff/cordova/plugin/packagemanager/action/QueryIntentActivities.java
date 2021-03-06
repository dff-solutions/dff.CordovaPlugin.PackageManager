package com.dff.cordova.plugin.packagemanager.action;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import com.dff.cordova.plugin.common.action.CordovaAction;
import com.dff.cordova.plugin.common.log.CordovaPluginLog;
import com.dff.cordova.plugin.packagemanager.model.json.JSONResolveInfo;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaInterface;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

public class QueryIntentActivities extends QueryIntentAction {
    private static final String LOG_TAG = "QueryIntentActivities";
    public static final String ACTION = "queryIntentActivities";


    public QueryIntentActivities(String action, JSONArray args,
                                 CallbackContext callbackContext, CordovaInterface cordova) {
        super(action, args, callbackContext, cordova);
    }

    @Override
    public void run() {
        super.run();

        int flags = 0;
        JSONObject jsonArgs;
        List<ResolveInfo> resolveInfo;
        JSONArray jsonResolveInfo = new JSONArray();
        Intent queryIntent = new Intent();

        try {
            if (!args.isNull(0)) {
                jsonArgs = args.getJSONObject(0);

                if (jsonArgs != null) {
                    flags = jsonArgs.optInt(JSON_ARG_FLAGS, 0);
                    queryIntent = super.parseIntentFromArgs(jsonArgs);
                }
            }

            PackageManager packageManager = this.cordova.getActivity().getPackageManager();

            resolveInfo = packageManager.queryIntentActivities(queryIntent, flags);

            for (ResolveInfo info : resolveInfo) {
                jsonResolveInfo.put(JSONResolveInfo.toJSON(info));
            }

            this.callbackContext.success(jsonResolveInfo);
        } catch (JSONException e) {
            CordovaPluginLog.e(LOG_TAG, e.getMessage(), e);
            callbackContext.error(e.getMessage());
        } catch (Exception ex) {
            CordovaPluginLog.e(LOG_TAG, ex.getMessage(), ex);
            callbackContext.error(ex.getMessage());
        }
    }
}
