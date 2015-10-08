package com.dff.cordova.plugin.packagemanager;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.json.JSONArray;
import org.json.JSONException;

import android.content.Context;
import android.content.pm.PackageManager;
import android.util.Log;

import com.dff.cordova.plugin.common.action.CordovaAction;
import com.dff.cordova.plugin.packagemanager.action.PackageManagerActionPackageInfo;

/**
 * This plugin implements an interface for mocking gps position.
 *
 * @author dff solutions
 */
public class PackageManagerPlugin extends CordovaPlugin {
	private Context appContext;
	private PackageManager packageManager;

   /**
	* Called after plugin construction and fields have been initialized.
	*/
    public void pluginInitialize() {
    	super.pluginInitialize();
    	appContext = this.cordova.getActivity().getApplicationContext();
    	this.packageManager = appContext.getPackageManager();
    }
    
    /**
    * Executes the request.
    *
    * This method is called from the WebView thread.
    * To do a non-trivial amount of work, use:
    * cordova.getThreadPool().execute(runnable);
    *
    * To run on the UI thread, use:
    * cordova.getActivity().runOnUiThread(runnable);
    *
    * @param action The action to execute.
    * @param args The exec() arguments.
    * @param callbackContext The callback context used when calling back into JavaScript.
    * @return Whether the action was valid.
    */
	@Override
    public boolean execute(String action
    		, final JSONArray args
    		, final CallbackContext callbackContext)
        throws JSONException {
    	CordovaAction cordovaAction = null;
		
    	Log.i(this.getClass().getName(), "call for action: " + action + "; args: " + args);
    	
    	if (action.equals("packageinfo")) {
    		
    		cordovaAction = new PackageManagerActionPackageInfo(
    				action,
    				args,
    				callbackContext,
    				this.packageManager,
    				appContext.getApplicationInfo().packageName
				);
    	}
    	
    	if (cordovaAction != null) {    		    		
    		cordova.getActivity().runOnUiThread(cordovaAction);    		
            return true;
    	}    	

        return false;
    }
}
