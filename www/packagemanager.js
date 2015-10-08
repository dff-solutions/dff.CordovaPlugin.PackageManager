/**
 * JavaScript interface to abstract
 * the usage of the cordova Sygic Navigation plugin.
 *
 * @module com/dff/cordova/plugins/sygic
 */

'use strict';

var cordova = require('cordova');
var feature = "PackageManager";
var self = {};

self.GET_ACTIVITIES = 1;
self.GET_GIDS = 256;
self.GET_CONFIGURATIONS = 16384;
self.GET_INSTRUMENTATION = 16;
self.GET_PERMISSIONS = 4096;
self.GET_PROVIDERS = 8;
self.GET_RECEIVERS = 2;
self.GET_SERVICES = 4;
self.GET_SIGNATURES = 64;

/**
 * Get Package info of app.
 *
 */
self.getPackageInfo = function (success, error, args) {
    cordova.exec(success, error, feature, "packageinfo", [args]);
};


module.exports = self;