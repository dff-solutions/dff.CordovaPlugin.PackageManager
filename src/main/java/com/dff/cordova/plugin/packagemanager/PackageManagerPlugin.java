package com.dff.cordova.plugin.packagemanager;

import android.util.Log;
import com.dff.cordova.plugin.common.CommonPlugin;
import com.dff.cordova.plugin.common.action.CordovaAction;
import com.dff.cordova.plugin.packagemanager.action.GetInstalledApplications;
import com.dff.cordova.plugin.packagemanager.action.LaunchPackage;
import com.dff.cordova.plugin.packagemanager.action.GetPackageInfo;
import org.apache.cordova.CallbackContext;
import org.json.JSONArray;
import org.json.JSONException;

/**
 * This plugin implements an interface for mocking gps position.
 *
 * @author dff solutions
 */
public class PackageManagerPlugin extends CommonPlugin {
    private static final String LOG_TAG = "PackageManagerPlugin";

    public PackageManagerPlugin() {
        super(LOG_TAG);
    }

    /**
     * Called after plugin construction and fields have been initialized.
     */
    public void pluginInitialize() {
        super.pluginInitialize();
    }

    /**
     * Executes the request.
     * <p>
     * This method is called from the WebView thread.
     * To do a non-trivial amount of work, use:
     * cordova.getThreadPool().execute(runnable);
     * <p>
     * To run on the UI thread, use:
     * cordova.getActivity().runOnUiThread(runnable);
     *
     * @param action          The action to execute.
     * @param args            The exec() arguments.
     * @param callbackContext The callback context used when calling back into JavaScript.
     * @return Whether the action was valid.
     */
    @Override
    public boolean execute(String action
            , final JSONArray args
            , final CallbackContext callbackContext)
            throws JSONException {
        CordovaAction cordovaAction = null;

        Log.d(LOG_TAG, "call for action: " + action + "; args: " + args);

        if (action.equals(GetPackageInfo.ACTION)) {
            cordovaAction = new GetPackageInfo(
                    action,
                    args,
                    callbackContext,
                    this.cordova
            );
        }
        else if (action.equals(LaunchPackage.ACTION)) {
            cordovaAction = new LaunchPackage(
                    action,
                    args,
                    callbackContext,
                    this.cordova
            );
        }
        else if (action.equals(GetInstalledApplications.ACTION)) {
            cordovaAction = new GetInstalledApplications(
                    action, args, callbackContext, this.cordova
            );
        }

        if (cordovaAction != null) {
            this.cordova.getThreadPool().execute(cordovaAction);
            return true;
        }

        return super.execute(action, args, callbackContext);
    }
}
