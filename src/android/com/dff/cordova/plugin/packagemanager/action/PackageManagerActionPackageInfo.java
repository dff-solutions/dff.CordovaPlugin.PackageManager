package com.dff.cordova.plugin.packagemanager.action;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaInterface;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

import com.dff.cordova.plugin.common.action.CordovaAction;
import com.dff.cordova.plugin.common.log.CordovaPluginLog;
import com.dff.cordova.plugin.packagemanager.model.json.JSONPackageInfo;

public class PackageManagerActionPackageInfo extends CordovaAction {
	public static final String LOG_TAG = "com.dff.cordova.plugin.packagemanager.action.PackageManagerActionPackageInfo";	
	
	public PackageManagerActionPackageInfo(String action, JSONArray args,
			CallbackContext callbackContext, CordovaInterface cordova) {
		super(action, args, callbackContext, cordova);
	}
	
	@Override
	public void run() {
		super.run();
		
		int flags = 0;
		JSONObject jsonArgs;
		PackageInfo packageinfo;
		JSONObject jsonPackageInfo;
		
		try {
			jsonArgs = args.getJSONObject(0);
			
			if (jsonArgs != null) {
				flags = jsonArgs.optInt("flags", 0);
			}
			
			String packagename = this.cordova.getActivity().getPackageName();
			PackageManager packageManager = this.cordova.getActivity().getPackageManager(); 
			
			packageinfo = packageManager.getPackageInfo(packagename, flags);
			jsonPackageInfo = JSONPackageInfo.toJSON(packageinfo);
			
			this.callbackContext.success(jsonPackageInfo);
			
		}
		catch(JSONException e) {
			CordovaPluginLog.e(LOG_TAG, e.getMessage(), e);
			callbackContext.error(e.getMessage());
		}
		catch(Exception ex) {
			CordovaPluginLog.e(LOG_TAG, ex.getMessage(), ex);
			callbackContext.error(ex.getMessage());
		}
		
		
		
	}

}
