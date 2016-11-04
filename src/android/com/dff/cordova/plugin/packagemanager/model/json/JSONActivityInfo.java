package com.dff.cordova.plugin.packagemanager.model.json;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.content.pm.ActivityInfo;

public class JSONActivityInfo {
	public static JSONObject toJSON(ActivityInfo activityinfo) throws JSONException {
		JSONObject jsonActivityInfo = new JSONObject();
		
		jsonActivityInfo.put("name", activityinfo.name);
		jsonActivityInfo.put("packageName", activityinfo.packageName);
		jsonActivityInfo.put("processName", activityinfo.processName);
		jsonActivityInfo.put("isEnabled", activityinfo.isEnabled());
		jsonActivityInfo.put("enabled", activityinfo.enabled);
		jsonActivityInfo.put("exported", activityinfo.exported);
		jsonActivityInfo.put("parentActivityName", activityinfo.parentActivityName);
		jsonActivityInfo.put("permission", activityinfo.permission);
		jsonActivityInfo.put("screenOrientation", activityinfo.screenOrientation);
		jsonActivityInfo.put("softInputMode", activityinfo.softInputMode);
		jsonActivityInfo.put("targetActivity", activityinfo.targetActivity);
		jsonActivityInfo.put("taskAffinity", activityinfo.taskAffinity);
		jsonActivityInfo.put("theme", activityinfo.theme);
		jsonActivityInfo.put("uiOptions", activityinfo.uiOptions);		

		JSONArray jsonConfigChanges = new JSONArray();
		
		if ((ActivityInfo.CONFIG_DENSITY & activityinfo.configChanges) == ActivityInfo.CONFIG_DENSITY) {
		    jsonConfigChanges.put("CONFIG_DENSITY");
		}

		if ((ActivityInfo.CONFIG_FONT_SCALE & activityinfo.configChanges) == ActivityInfo.CONFIG_FONT_SCALE) {
		    jsonConfigChanges.put("CONFIG_FONT_SCALE");
		}

		if ((ActivityInfo.CONFIG_KEYBOARD & activityinfo.configChanges) == ActivityInfo.CONFIG_KEYBOARD) {
		    jsonConfigChanges.put("CONFIG_KEYBOARD");
		}

		if ((ActivityInfo.CONFIG_KEYBOARD_HIDDEN & activityinfo.configChanges) == ActivityInfo.CONFIG_KEYBOARD_HIDDEN) {
		    jsonConfigChanges.put("CONFIG_KEYBOARD_HIDDEN");
		}

		if ((ActivityInfo.CONFIG_LAYOUT_DIRECTION & activityinfo.configChanges) == ActivityInfo.CONFIG_LAYOUT_DIRECTION) {
		    jsonConfigChanges.put("CONFIG_LAYOUT_DIRECTION");
		}

		if ((ActivityInfo.CONFIG_LOCALE & activityinfo.configChanges) == ActivityInfo.CONFIG_LOCALE) {
		    jsonConfigChanges.put("CONFIG_LOCALE");
		}

		if ((ActivityInfo.CONFIG_MCC & activityinfo.configChanges) == ActivityInfo.CONFIG_MCC) {
		    jsonConfigChanges.put("CONFIG_MCC");
		}

		if ((ActivityInfo.CONFIG_MNC & activityinfo.configChanges) == ActivityInfo.CONFIG_MNC) {
		    jsonConfigChanges.put("CONFIG_MNC");
		}

		if ((ActivityInfo.CONFIG_NAVIGATION & activityinfo.configChanges) == ActivityInfo.CONFIG_NAVIGATION) {
		    jsonConfigChanges.put("CONFIG_NAVIGATION");
		}

		if ((ActivityInfo.CONFIG_ORIENTATION & activityinfo.configChanges) == ActivityInfo.CONFIG_ORIENTATION) {
		    jsonConfigChanges.put("CONFIG_ORIENTATION");
		}

		if ((ActivityInfo.CONFIG_SCREEN_LAYOUT & activityinfo.configChanges) == ActivityInfo.CONFIG_SCREEN_LAYOUT) {
		    jsonConfigChanges.put("CONFIG_SCREEN_LAYOUT");
		}

		if ((ActivityInfo.CONFIG_SCREEN_SIZE & activityinfo.configChanges) == ActivityInfo.CONFIG_SCREEN_SIZE) {
		    jsonConfigChanges.put("CONFIG_SCREEN_SIZE");
		}

		if ((ActivityInfo.CONFIG_SMALLEST_SCREEN_SIZE & activityinfo.configChanges) == ActivityInfo.CONFIG_SMALLEST_SCREEN_SIZE) {
		    jsonConfigChanges.put("CONFIG_SMALLEST_SCREEN_SIZE");
		}

		if ((ActivityInfo.CONFIG_TOUCHSCREEN & activityinfo.configChanges) == ActivityInfo.CONFIG_TOUCHSCREEN) {
		    jsonConfigChanges.put("CONFIG_TOUCHSCREEN");
		}

		if ((ActivityInfo.CONFIG_UI_MODE & activityinfo.configChanges) == ActivityInfo.CONFIG_UI_MODE) {
		    jsonConfigChanges.put("CONFIG_UI_MODE");
		}

		jsonActivityInfo.put("configChanges", jsonConfigChanges);
		
		JSONArray jsonFlags = new JSONArray();
		if ((ActivityInfo.FLAG_ALLOW_TASK_REPARENTING & activityinfo.flags) == ActivityInfo.FLAG_ALLOW_TASK_REPARENTING) {
		    jsonFlags.put("FLAG_ALLOW_TASK_REPARENTING");
		}

		if ((ActivityInfo.FLAG_ALWAYS_RETAIN_TASK_STATE & activityinfo.flags) == ActivityInfo.FLAG_ALWAYS_RETAIN_TASK_STATE) {
		    jsonFlags.put("FLAG_ALWAYS_RETAIN_TASK_STATE");
		}

//		if ((ActivityInfo.FLAG_AUTO_REMOVE_FROM_RECENTS & activityinfo.flags) == ActivityInfo.FLAG_AUTO_REMOVE_FROM_RECENTS) {
//		    jsonFlags.put("FLAG_AUTO_REMOVE_FROM_RECENTS");
//		}

		if ((ActivityInfo.FLAG_CLEAR_TASK_ON_LAUNCH & activityinfo.flags) == ActivityInfo.FLAG_CLEAR_TASK_ON_LAUNCH) {
		    jsonFlags.put("FLAG_CLEAR_TASK_ON_LAUNCH");
		}

//		if ((ActivityInfo.FLAG_ENABLE_VR_MODE & activityinfo.flags) == ActivityInfo.FLAG_ENABLE_VR_MODE) {
//		    jsonFlags.put("FLAG_ENABLE_VR_MODE");
//		}

		if ((ActivityInfo.FLAG_EXCLUDE_FROM_RECENTS & activityinfo.flags) == ActivityInfo.FLAG_EXCLUDE_FROM_RECENTS) {
		    jsonFlags.put("FLAG_EXCLUDE_FROM_RECENTS");
		}

		if ((ActivityInfo.FLAG_FINISH_ON_CLOSE_SYSTEM_DIALOGS & activityinfo.flags) == ActivityInfo.FLAG_FINISH_ON_CLOSE_SYSTEM_DIALOGS) {
		    jsonFlags.put("FLAG_FINISH_ON_CLOSE_SYSTEM_DIALOGS");
		}

		if ((ActivityInfo.FLAG_FINISH_ON_TASK_LAUNCH & activityinfo.flags) == ActivityInfo.FLAG_FINISH_ON_TASK_LAUNCH) {
		    jsonFlags.put("FLAG_FINISH_ON_TASK_LAUNCH");
		}

		if ((ActivityInfo.FLAG_HARDWARE_ACCELERATED & activityinfo.flags) == ActivityInfo.FLAG_HARDWARE_ACCELERATED) {
		    jsonFlags.put("FLAG_HARDWARE_ACCELERATED");
		}

		if ((ActivityInfo.FLAG_IMMERSIVE & activityinfo.flags) == ActivityInfo.FLAG_IMMERSIVE) {
		    jsonFlags.put("FLAG_IMMERSIVE");
		}

		if ((ActivityInfo.FLAG_MULTIPROCESS & activityinfo.flags) == ActivityInfo.FLAG_MULTIPROCESS) {
		    jsonFlags.put("FLAG_MULTIPROCESS");
		}

		if ((ActivityInfo.FLAG_NO_HISTORY & activityinfo.flags) == ActivityInfo.FLAG_NO_HISTORY) {
		    jsonFlags.put("FLAG_NO_HISTORY");
		}

//		if ((ActivityInfo.FLAG_RELINQUISH_TASK_IDENTITY & activityinfo.flags) == ActivityInfo.FLAG_RELINQUISH_TASK_IDENTITY) {
//		    jsonFlags.put("FLAG_RELINQUISH_TASK_IDENTITY");
//		}
//
//		if ((ActivityInfo.FLAG_RESUME_WHILE_PAUSING & activityinfo.flags) == ActivityInfo.FLAG_RESUME_WHILE_PAUSING) {
//		    jsonFlags.put("FLAG_RESUME_WHILE_PAUSING");
//		}

		if ((ActivityInfo.FLAG_SINGLE_USER & activityinfo.flags) == ActivityInfo.FLAG_SINGLE_USER) {
		    jsonFlags.put("FLAG_SINGLE_USER");
		}

		if ((ActivityInfo.FLAG_STATE_NOT_NEEDED & activityinfo.flags) == ActivityInfo.FLAG_STATE_NOT_NEEDED) {
		    jsonFlags.put("FLAG_STATE_NOT_NEEDED");
		}

		jsonActivityInfo.put("flags", jsonFlags);
		
		String jsonLaunchMode = null;
		if (ActivityInfo.LAUNCH_MULTIPLE == activityinfo.launchMode) {
		    jsonLaunchMode = "LAUNCH_MULTIPLE";
		}
		else if (ActivityInfo.LAUNCH_SINGLE_INSTANCE == activityinfo.launchMode) {
		    jsonLaunchMode = "LAUNCH_SINGLE_INSTANCE";
		}
		else if (ActivityInfo.LAUNCH_SINGLE_TASK == activityinfo.launchMode) {
		    jsonLaunchMode = "LAUNCH_SINGLE_TASK";
		}
		else if (ActivityInfo.LAUNCH_SINGLE_TOP == activityinfo.launchMode) {
		    jsonLaunchMode = "LAUNCH_SINGLE_TOP";
		}

		jsonActivityInfo.put("launchMode", jsonLaunchMode);
		
		return jsonActivityInfo;
	}
}
