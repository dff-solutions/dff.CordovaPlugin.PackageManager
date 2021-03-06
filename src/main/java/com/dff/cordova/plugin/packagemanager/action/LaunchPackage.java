package com.dff.cordova.plugin.packagemanager.action;

import android.content.Intent;
import com.dff.cordova.plugin.common.action.CordovaAction;
import com.dff.cordova.plugin.common.log.CordovaPluginLog;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaInterface;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class LaunchPackage extends CordovaAction {
    private static final String TAG = "LaunchPackage";
    public static final String ACTION = "launchPackage";
    public static final String JSON_ARG_PACKAGE = "package";
    public static final String[] JSON_ARGS = {
            JSON_ARG_PACKAGE
    };

    public LaunchPackage(String action, JSONArray args,
                             CallbackContext callbackContext, CordovaInterface cordova) {
        super(action, args, callbackContext, cordova);
    }

    @Override
    public void run() {
        try {
            JSONObject jsonArgs = super.checkJsonArgs(args, JSON_ARGS);

            String pck = jsonArgs.getString(JSON_ARG_PACKAGE);

            CordovaPluginLog.i(TAG, "launch package " + pck);

            Intent intent = this.cordova
                    .getActivity()
                    .getPackageManager()
                    .getLaunchIntentForPackage(pck);

            this.cordova.getActivity().startActivity(intent);
            callbackContext.success();
        } catch (JSONException e) {
            CordovaPluginLog.e(TAG, e.getMessage(), e);
            callbackContext.error(e.getMessage());
        } catch (Exception ex) {
            CordovaPluginLog.e(TAG, ex.getMessage(), ex);
            callbackContext.error(ex.getMessage());
        }
    }
}
