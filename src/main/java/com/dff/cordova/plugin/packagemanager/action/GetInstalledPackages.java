package com.dff.cordova.plugin.packagemanager.action;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import com.dff.cordova.plugin.packagemanager.model.json.JSONPackageInfo;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

public class GetInstalledPackages extends CordovaAction {
    private static final String LOG_TAG = "GetInstalledPackages";
    public static final String ACTION = "getInstalledPackages";
    public static final String JSON_ARG_FLAGS = "flags";

    public GetInstalledPackages(String action, JSONArray args,
                                    CallbackContext callbackContext, CordovaInterface cordova) {
        super(action, args, callbackContext, cordova);
    }

    @Override
    public void run() {
        super.run();

        int flags = 0;
        JSONObject jsonArgs;
        List<PackageInfo> packageInfo;
        JSONArray jsonPackageInfo = new JSONArray();

        try {
            if (!args.isNull(0)) {
                jsonArgs = args.getJSONObject(0);

                if (jsonArgs != null) {
                    flags = jsonArgs.optInt(JSON_ARG_FLAGS, 0);
                }
            }

            PackageManager packageManager = this.cordova.getActivity().getPackageManager();

            packageInfo = packageManager.getInstalledPackages(flags);

            for (PackageInfo info : packageInfo) {
                jsonPackageInfo.put(JSONPackageInfo.toJSON(info));
            }

            this.callbackContext.success(jsonPackageInfo);
        } catch (JSONException e) {
            CordovaPluginLog.e(LOG_TAG, e.getMessage(), e);
            callbackContext.error(e.getMessage());
        } catch (Exception ex) {
            CordovaPluginLog.e(LOG_TAG, ex.getMessage(), ex);
            callbackContext.error(ex.getMessage());
        }
    }
}
