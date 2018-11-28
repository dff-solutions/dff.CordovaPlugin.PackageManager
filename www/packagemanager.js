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

PackageManager.prototype.GET_ACTIVITIES = 1;
PackageManager.prototype.GET_GIDS = 256;
PackageManager.prototype.GET_CONFIGURATIONS = 16384;
PackageManager.prototype.GET_INSTRUMENTATION = 16;
PackageManager.prototype.GET_PERMISSIONS = 4096;
PackageManager.prototype.GET_PROVIDERS = 8;
PackageManager.prototype.GET_RECEIVERS = 2;
PackageManager.prototype.GET_SERVICES = 4;
PackageManager.prototype.GET_SIGNATURES = 64;


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
