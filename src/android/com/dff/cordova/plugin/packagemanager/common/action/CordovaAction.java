package com.dff.cordova.plugin.packagemanager.common.action;

import org.apache.cordova.CallbackContext;
import org.json.JSONArray;
import android.util.Log;

public abstract class CordovaAction implements Runnable {

	protected String action;
	protected JSONArray args;
	protected CallbackContext callbackContext;
	
	public CordovaAction(String action, JSONArray args, CallbackContext callbackContext) {
		this.action = action;
		this.args = args;
		this.callbackContext = callbackContext;
	}
	
	@Override
	public void run() {
		Log.i(this.getClass().getName(), "running action: " + this.action + "; args: " + this.args);
	}

}
