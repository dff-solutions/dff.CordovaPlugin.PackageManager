package com.dff.cordova.plugin.packagemanager.action;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import com.dff.cordova.plugin.common.action.CordovaAction;
import com.dff.cordova.plugin.common.log.CordovaPluginLog;
import com.dff.cordova.plugin.packagemanager.model.json.JSONPackageInfo;
import com.dff.cordova.plugin.packagemanager.model.json.JSONResolveInfo;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaInterface;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.net.Uri;
import java.util.List;

public class QueryBroadcastReceivers extends QueryIntentAction {
    private static final String LOG_TAG = "QueryBroadcastReceivers";
    public static final String ACTION = "queryBroadcastReceivers";

    public QueryBroadcastReceivers(String action, JSONArray args,
                                CallbackContext callbackContext, CordovaInterface cordova) {
        super(action, args, callbackContext, cordova);
    }

    @Override
    public void run() {
        super.run();

        int flags = 0;
        JSONObject jsonArgs;
        Intent queryIntent = new Intent();
        List<ResolveInfo> resolveInfo;
        JSONArray jsonResolveInfo = new JSONArray();

        try {
            if (!args.isNull(0)) {
                jsonArgs = args.getJSONObject(0);

<<<<<<< Updated upstream
                if (jsonArgs != null) {
                    flags = jsonArgs.optInt(JSON_ARG_FLAGS, 0);

                    if (jsonArgs.has(JSON_ARG_ACTION) && !jsonArgs.isNull(JSON_ARG_ACTION)) {
                        action = jsonArgs.getString(JSON_ARG_ACTION);

                        queryIntent.setAction(action);
                    }

                    if (jsonArgs.has(JSON_ARG_URI) && !jsonArgs.isNull(JSON_ARG_URI)) {
                        String uriStr = jsonArgs.getString(JSON_ARG_URI);
                        uri = Uri.parse(uriStr);
                        queryIntent.setData(uri);
                    }

                    if (jsonArgs.has(JSON_ARG_CATEGORIES) && !jsonArgs.isNull(JSON_ARG_CATEGORIES)) {
                        JSONArray jsonCategories = jsonArgs.getJSONArray(JSON_ARG_CATEGORIES);
                        for (int i = 0; i < jsonCategories.length(); i++) {
                            queryIntent.addCategory(jsonCategories.getString(i));
                        }
                    }

                    if (jsonArgs.has(JSON_ARG_TYPE) && !jsonArgs.isNull(JSON_ARG_TYPE)) {
                        queryIntent.setType(jsonArgs.getString(JSON_ARG_TYPE));
                    }
                }
=======
                queryIntent = super.parseIntentFromArgs(jsonArgs);
>>>>>>> Stashed changes
            }

            PackageManager packageManager = this.cordova.getActivity().getPackageManager();

            resolveInfo = packageManager.queryBroadcastReceivers(queryIntent, flags);

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
