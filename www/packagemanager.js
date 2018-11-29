'use strict';

var cordova = require('cordova');
var feature = "PackageManager";
function PackageManager(feature) {
    this.feature = feature;
}

var actions = [
    "getPackageInfo",
    "launchPackage",
    "getInstalledApplications",
    "getInstalledPackages",
    "queryBroadcastReceivers",
    "queryIntentActivities",
    "startActivity"
];

var eventActions = [];

PackageManager.prototype.GET_ACTIVITIES                       = 1;
PackageManager.prototype.GET_RECEIVERS                        = 2;
PackageManager.prototype.GET_SERVICES                         = 4;
PackageManager.prototype.GET_PROVIDERS                        = 8;
PackageManager.prototype.GET_INSTRUMENTATION                  = 16;
PackageManager.prototype.GET_INTENT_FILTERS                   = 32;
PackageManager.prototype.GET_RESOLVED_FILTER                  = 64;
PackageManager.prototype.GET_META_DATA                        = 128;
PackageManager.prototype.GET_GIDS                             = 256;
PackageManager.prototype.MATCH_DISABLED_COMPONENTS            = 512;       // (0x00000200)
PackageManager.prototype.GET_SHARED_LIBRARY_FILES             = 1024;
PackageManager.prototype.GET_URI_PERMISSION_PATTERNS          = 2048;      // (0x00000800)
PackageManager.prototype.GET_PERMISSIONS                      = 4096;
PackageManager.prototype.MATCH_UNINSTALLED_PACKAGES           = 8192;      // (0x00002000)
PackageManager.prototype.GET_CONFIGURATIONS                   = 16384;
PackageManager.prototype.MATCH_DISABLED_UNTIL_USED_COMPONENTS = 32768;     // (0x00008000)
PackageManager.prototype.MATCH_DEFAULT_ONLY                   = 65536;     // (0x00010000)
PackageManager.prototype.MATCH_ALL                            = 131072;    // (0x00020000)
PackageManager.prototype.MATCH_DIRECT_BOOT_UNAWARE            = 262144;    // (0x00040000)
PackageManager.prototype.MATCH_DIRECT_BOOT_AWARE              = 524288;    // (0x00080000)
PackageManager.prototype.MATCH_SYSTEM_ONLY                    = 1048576;   // (0x00100000)
PackageManager.prototype.GET_SIGNING_CERTIFICATES             = 134217728; // (0x08000000)


function createActionFunction(action) {
    return function (success, error, args) {
        args = args || {};

        cordova.exec(success, error, feature, action, [args]);
    }
}

function createEventActionFunction(action) {
    return function (success, error, args) {
        args = args || {};

        cordova.exec(success, error, feature, action, [args]);
    }
}

actions.forEach(function (action) {
    PackageManager.prototype[action] = createActionFunction(action);
});

eventActions.forEach(function (action) {
    PackageManager.prototype[action] = createEventActionFunction(action);
});


module.exports = new PackageManager(feature);
