package com.dff.cordova.plugin.packagemanager.action;

import android.content.Intent;
import android.net.Uri;
import com.dff.cordova.plugin.common.action.CordovaAction;
import com.dff.cordova.plugin.common.log.CordovaPluginLog;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaInterface;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class StartActivity extends CordovaAction {
    private static final String TAG = "StartActivity";
    public static final String ACTION = "startActivity";
    public static final String JSON_ARG_URI = "uri";
    public static final String[] JSON_ARGS = {
            JSON_ARG_URI
    };

    public StartActivity(String action, JSONArray args,
                         CallbackContext callbackContext, CordovaInterface cordova) {
        super(action, args, callbackContext, cordova);
    }

    @Override
    public void run() {
        try {
            JSONObject jsonArgs = super.checkJsonArgs(args, JSON_ARGS);

            String uri = jsonArgs.getString(JSON_ARG_URI);

            CordovaPluginLog.i(TAG, "start activity " + uri);

            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));

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
