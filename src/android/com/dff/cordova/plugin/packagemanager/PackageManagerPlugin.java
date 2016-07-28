package com.dff.cordova.plugin.packagemanager;

import org.apache.cordova.CallbackContext;
import org.json.JSONArray;
import org.json.JSONException;

import com.dff.cordova.plugin.common.CommonPlugin;
import com.dff.cordova.plugin.common.action.CordovaAction;
import com.dff.cordova.plugin.common.log.CordovaPluginLog;
import com.dff.cordova.plugin.packagemanager.action.PackageManagerActionPackageInfo;

/**
 * This plugin implements an interface for mocking gps position.
 *
 * @author dff solutions
 */
public class PackageManagerPlugin extends CommonPlugin {
	private static final String LOG_TAG = "com.dff.cordova.plugin.packagemanager.PackageManagerPlugin";
	
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
		
    	CordovaPluginLog.i(LOG_TAG, "call for action: " + action + "; args: " + args);
    	
    	if (action.equals("packageinfo")) {    		
    		cordovaAction = new PackageManagerActionPackageInfo(
    				action,
    				args,
    				callbackContext,
    				this.cordova
				);
    	}
    	
    	if (cordovaAction != null) {    		    		
    		this.cordova.getThreadPool().execute(cordovaAction);    		
            return true;
    	}    	

        return super.execute(action, args, callbackContext);
    }
}
