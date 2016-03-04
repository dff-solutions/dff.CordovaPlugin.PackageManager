package com.dff.cordova.plugin.packagemanager.action;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.LOG;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

import com.dff.cordova.plugin.packagemanager.common.action.CordovaAction;
import com.dff.cordova.plugin.packagemanager.model.json.JSONPackageInfo;

public class PackageManagerActionPackageInfo extends CordovaAction {
	
	private PackageManager packageManager;
	private String packagename;

	public PackageManagerActionPackageInfo(String action, JSONArray args,
			CallbackContext callbackContext, PackageManager packageManager,
			String packagename) {
		super(action, args, callbackContext);
		this.packageManager = packageManager;
		this.packagename = packagename;
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
			
			packageinfo = this.packageManager.getPackageInfo(this.packagename, flags);
			jsonPackageInfo = JSONPackageInfo.toJSON(packageinfo);
			
			this.callbackContext.success(jsonPackageInfo);
			
		}
		catch(JSONException e) {
			LOG.e(this.getClass().getName(), e.getMessage(), e);
			callbackContext.error(e.getMessage());
		}
		catch(Exception ex) {
			LOG.e(this.getClass().getName(), ex.getMessage(), ex);
			callbackContext.error(ex.getMessage());
		}
		
		
		
	}

}
