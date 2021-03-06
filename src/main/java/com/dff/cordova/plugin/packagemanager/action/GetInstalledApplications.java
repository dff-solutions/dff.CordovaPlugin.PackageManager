package com.dff.cordova.plugin.packagemanager.action;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import com.dff.cordova.plugin.common.action.CordovaAction;
import com.dff.cordova.plugin.common.log.CordovaPluginLog;
import com.dff.cordova.plugin.packagemanager.model.json.JSONApplicationInfo;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaInterface;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;


public class GetInstalledApplications  extends CordovaAction {
    private static final String LOG_TAG = "GetPackageInfo";
    public static final String ACTION = "getInstalledApplications";
    public static final String JSON_ARG_FLAGS = "flags";

    public GetInstalledApplications(String action, JSONArray args,
                          CallbackContext callbackContext, CordovaInterface cordova) {
        super(action, args, callbackContext, cordova);
    }

    @Override
    public void run() {
        super.run();

        int flags = 0;
        JSONObject jsonArgs;
        List<ApplicationInfo> applicationInfos;
        JSONObject jsonApplicationInfo;
        JSONArray jsonApplicationInfos = new JSONArray();

        try {
            if (!args.isNull(0)) {
                jsonArgs = args.getJSONObject(0);

                if (jsonArgs != null) {
                    flags = jsonArgs.optInt(JSON_ARG_FLAGS, 0);
                }
            }

            PackageManager packageManager = this.cordova.getActivity().getPackageManager();

            applicationInfos = packageManager.getInstalledApplications(flags);

            for (ApplicationInfo ai : applicationInfos) {
                jsonApplicationInfo = JSONApplicationInfo.toJSON(ai);
                jsonApplicationInfos.put(jsonApplicationInfo);
            }

            this.callbackContext.success(jsonApplicationInfos);
        } catch (JSONException e) {
            CordovaPluginLog.e(LOG_TAG, e.getMessage(), e);
            callbackContext.error(e.getMessage());
        } catch (Exception ex) {
            CordovaPluginLog.e(LOG_TAG, ex.getMessage(), ex);
            callbackContext.error(ex.getMessage());
        }
    }
}
