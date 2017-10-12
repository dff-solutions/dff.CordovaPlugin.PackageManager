package com.dff.cordova.plugin.packagemanager.model.json;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.content.pm.ApplicationInfo;

public class JSONApplicationInfo {

	public static JSONObject toJSON(ApplicationInfo applicationinfo) throws JSONException {
		JSONObject jsonApplicationInfo = new JSONObject();
		JSONArray jsonSharedLibraryFiles = new JSONArray();
		
		jsonApplicationInfo.put("name", applicationinfo.name);
		jsonApplicationInfo.put("packageName", applicationinfo.packageName);
		jsonApplicationInfo.put("backupAgentName", applicationinfo.backupAgentName);
		jsonApplicationInfo.put("className", applicationinfo.className);
		jsonApplicationInfo.put("compatibleWidthLimitDp", applicationinfo.compatibleWidthLimitDp);
		jsonApplicationInfo.put("dataDir", applicationinfo.dataDir);
		jsonApplicationInfo.put("descriptionRes", applicationinfo.descriptionRes);
		jsonApplicationInfo.put("enabled", applicationinfo.enabled);

		jsonApplicationInfo.put("largestWidthLimitDp", applicationinfo.largestWidthLimitDp);
		jsonApplicationInfo.put("manageSpaceActivityName", applicationinfo.manageSpaceActivityName);
		jsonApplicationInfo.put("nativeLibraryDir", applicationinfo.nativeLibraryDir);
		jsonApplicationInfo.put("permission", applicationinfo.permission);
		jsonApplicationInfo.put("processName", applicationinfo.processName);
		jsonApplicationInfo.put("publicSourceDir", applicationinfo.publicSourceDir);
		jsonApplicationInfo.put("requiresSmallestWidthDp", applicationinfo.requiresSmallestWidthDp);
		
		if (applicationinfo.sharedLibraryFiles != null) {
			for (String slf : applicationinfo.sharedLibraryFiles) {
				jsonSharedLibraryFiles.put(slf);
			}
			
			jsonApplicationInfo.put("sharedLibraryFiles", jsonSharedLibraryFiles);			
		}
		
		jsonApplicationInfo.put("sourceDir", applicationinfo.sourceDir);
		jsonApplicationInfo.put("targetSdkVersion", applicationinfo.targetSdkVersion);
		jsonApplicationInfo.put("taskAffinity", applicationinfo.taskAffinity);
		jsonApplicationInfo.put("theme", applicationinfo.theme);
		jsonApplicationInfo.put("uiOptions", applicationinfo.uiOptions);
		jsonApplicationInfo.put("uid", applicationinfo.uid);
		
		JSONArray jsonFlags = new JSONArray();
		
		if ((ApplicationInfo.FLAG_ALLOW_BACKUP & applicationinfo.flags) == ApplicationInfo.FLAG_ALLOW_BACKUP) {
		    jsonFlags.put("FLAG_ALLOW_BACKUP");
		}

		if ((ApplicationInfo.FLAG_ALLOW_CLEAR_USER_DATA & applicationinfo.flags) == ApplicationInfo.FLAG_ALLOW_CLEAR_USER_DATA) {
		    jsonFlags.put("FLAG_ALLOW_CLEAR_USER_DATA");
		}

		if ((ApplicationInfo.FLAG_ALLOW_TASK_REPARENTING & applicationinfo.flags) == ApplicationInfo.FLAG_ALLOW_TASK_REPARENTING) {
		    jsonFlags.put("FLAG_ALLOW_TASK_REPARENTING");
		}

		if ((ApplicationInfo.FLAG_DEBUGGABLE & applicationinfo.flags) == ApplicationInfo.FLAG_DEBUGGABLE) {
		    jsonFlags.put("FLAG_DEBUGGABLE");
		}

		if ((ApplicationInfo.FLAG_EXTERNAL_STORAGE & applicationinfo.flags) == ApplicationInfo.FLAG_EXTERNAL_STORAGE) {
		    jsonFlags.put("FLAG_EXTERNAL_STORAGE");
		}

//		if ((ApplicationInfo.FLAG_EXTRACT_NATIVE_LIBS & applicationinfo.flags) == ApplicationInfo.FLAG_EXTRACT_NATIVE_LIBS) {
//		    jsonFlags.put("FLAG_EXTRACT_NATIVE_LIBS");
//		}

		if ((ApplicationInfo.FLAG_FACTORY_TEST & applicationinfo.flags) == ApplicationInfo.FLAG_FACTORY_TEST) {
		    jsonFlags.put("FLAG_FACTORY_TEST");
		}

//		if ((ApplicationInfo.FLAG_FULL_BACKUP_ONLY & applicationinfo.flags) == ApplicationInfo.FLAG_FULL_BACKUP_ONLY) {
//		    jsonFlags.put("FLAG_FULL_BACKUP_ONLY");
//		}
//
//		if ((ApplicationInfo.FLAG_HARDWARE_ACCELERATED & applicationinfo.flags) == ApplicationInfo.FLAG_HARDWARE_ACCELERATED) {
//		    jsonFlags.put("FLAG_HARDWARE_ACCELERATED");
//		}

		if ((ApplicationInfo.FLAG_HAS_CODE & applicationinfo.flags) == ApplicationInfo.FLAG_HAS_CODE) {
		    jsonFlags.put("FLAG_HAS_CODE");
		}

		if ((ApplicationInfo.FLAG_INSTALLED & applicationinfo.flags) == ApplicationInfo.FLAG_INSTALLED) {
		    jsonFlags.put("FLAG_INSTALLED");
		}

		if ((ApplicationInfo.FLAG_IS_DATA_ONLY & applicationinfo.flags) == ApplicationInfo.FLAG_IS_DATA_ONLY) {
		    jsonFlags.put("FLAG_IS_DATA_ONLY");
		}

//		if ((ApplicationInfo.FLAG_IS_GAME & applicationinfo.flags) == ApplicationInfo.FLAG_IS_GAME) {
//		    jsonFlags.put("FLAG_IS_GAME");
//		}

		if ((ApplicationInfo.FLAG_KILL_AFTER_RESTORE & applicationinfo.flags) == ApplicationInfo.FLAG_KILL_AFTER_RESTORE) {
		    jsonFlags.put("FLAG_KILL_AFTER_RESTORE");
		}

		if ((ApplicationInfo.FLAG_LARGE_HEAP & applicationinfo.flags) == ApplicationInfo.FLAG_LARGE_HEAP) {
		    jsonFlags.put("FLAG_LARGE_HEAP");
		}

//		if ((ApplicationInfo.FLAG_MULTIARCH & applicationinfo.flags) == ApplicationInfo.FLAG_MULTIARCH) {
//		    jsonFlags.put("FLAG_MULTIARCH");
//		}

		if ((ApplicationInfo.FLAG_PERSISTENT & applicationinfo.flags) == ApplicationInfo.FLAG_PERSISTENT) {
		    jsonFlags.put("FLAG_PERSISTENT");
		}

		if ((ApplicationInfo.FLAG_RESIZEABLE_FOR_SCREENS & applicationinfo.flags) == ApplicationInfo.FLAG_RESIZEABLE_FOR_SCREENS) {
		    jsonFlags.put("FLAG_RESIZEABLE_FOR_SCREENS");
		}

		if ((ApplicationInfo.FLAG_RESTORE_ANY_VERSION & applicationinfo.flags) == ApplicationInfo.FLAG_RESTORE_ANY_VERSION) {
		    jsonFlags.put("FLAG_RESTORE_ANY_VERSION");
		}

		if ((ApplicationInfo.FLAG_STOPPED & applicationinfo.flags) == ApplicationInfo.FLAG_STOPPED) {
		    jsonFlags.put("FLAG_STOPPED");
		}

		if ((ApplicationInfo.FLAG_SUPPORTS_LARGE_SCREENS & applicationinfo.flags) == ApplicationInfo.FLAG_SUPPORTS_LARGE_SCREENS) {
		    jsonFlags.put("FLAG_SUPPORTS_LARGE_SCREENS");
		}

		if ((ApplicationInfo.FLAG_SUPPORTS_NORMAL_SCREENS & applicationinfo.flags) == ApplicationInfo.FLAG_SUPPORTS_NORMAL_SCREENS) {
		    jsonFlags.put("FLAG_SUPPORTS_NORMAL_SCREENS");
		}

		if ((ApplicationInfo.FLAG_SUPPORTS_RTL & applicationinfo.flags) == ApplicationInfo.FLAG_SUPPORTS_RTL) {
		    jsonFlags.put("FLAG_SUPPORTS_RTL");
		}

		if ((ApplicationInfo.FLAG_SUPPORTS_SCREEN_DENSITIES & applicationinfo.flags) == ApplicationInfo.FLAG_SUPPORTS_SCREEN_DENSITIES) {
		    jsonFlags.put("FLAG_SUPPORTS_SCREEN_DENSITIES");
		}

		if ((ApplicationInfo.FLAG_SUPPORTS_SMALL_SCREENS & applicationinfo.flags) == ApplicationInfo.FLAG_SUPPORTS_SMALL_SCREENS) {
		    jsonFlags.put("FLAG_SUPPORTS_SMALL_SCREENS");
		}

		if ((ApplicationInfo.FLAG_SUPPORTS_XLARGE_SCREENS & applicationinfo.flags) == ApplicationInfo.FLAG_SUPPORTS_XLARGE_SCREENS) {
		    jsonFlags.put("FLAG_SUPPORTS_XLARGE_SCREENS");
		}

//		if ((ApplicationInfo.FLAG_SUSPENDED & applicationinfo.flags) == ApplicationInfo.FLAG_SUSPENDED) {
//		    jsonFlags.put("FLAG_SUSPENDED");
//		}

		if ((ApplicationInfo.FLAG_SYSTEM & applicationinfo.flags) == ApplicationInfo.FLAG_SYSTEM) {
		    jsonFlags.put("FLAG_SYSTEM");
		}

		if ((ApplicationInfo.FLAG_TEST_ONLY & applicationinfo.flags) == ApplicationInfo.FLAG_TEST_ONLY) {
		    jsonFlags.put("FLAG_TEST_ONLY");
		}

		if ((ApplicationInfo.FLAG_UPDATED_SYSTEM_APP & applicationinfo.flags) == ApplicationInfo.FLAG_UPDATED_SYSTEM_APP) {
		    jsonFlags.put("FLAG_UPDATED_SYSTEM_APP");
		}

//		if ((ApplicationInfo.FLAG_USES_CLEARTEXT_TRAFFIC & applicationinfo.flags) == ApplicationInfo.FLAG_USES_CLEARTEXT_TRAFFIC) {
//		    jsonFlags.put("FLAG_USES_CLEARTEXT_TRAFFIC");
//		}

		if ((ApplicationInfo.FLAG_VM_SAFE_MODE & applicationinfo.flags) == ApplicationInfo.FLAG_VM_SAFE_MODE) {
		    jsonFlags.put("FLAG_VM_SAFE_MODE");
		}

		jsonApplicationInfo.put("flags", jsonFlags);
		
		
		return jsonApplicationInfo;
	}
}
