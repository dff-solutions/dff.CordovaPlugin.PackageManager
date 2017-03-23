# dff.CordovaPlugin.PackageManager

Cordova plugin to access functionality of Android [PackageManager](http://developer.android.com/reference/android/content/pm/PackageManager.html "PackageManager")

## Supported Platforms
  * Android

## Install

    cordova plugin add git@github.com:dff-solutions/dff.CordovaPlugin.PackageManager.git

## Usage
Feature is available in JavaScript via global `PackageManager`.

### Constants

    GET_ACTIVITIES = 1;
    GET_GIDS = 256;
    GET_CONFIGURATIONS = 16384;
    GET_INSTRUMENTATION = 16;
    GET_PERMISSIONS = 4096;
    GET_PROVIDERS = 8;
    GET_RECEIVERS = 2;
    GET_SERVICES = 4;
    GET_SIGNATURES = 64;

### getPackageInfo

```js
/**
 * Retrieve overall information about an application package that is installed on the system.
 *
 * @param args {Object} Named parameters.
 * @param args.flags {Object} Flags which modify the data to be returned. Can be combined by logical OR. See Constants.
 * @return {Promise} A Promise that resolves with package info.
 */
PackageManager
    .getPackageInfo({
        flags: PackageManager.GET_PERMISSIONS
    })
    .then(function (info) {
        console.log(info);
    })
    .catch(function (reason) {
        console.error(reason);
    });
```


### launchPackage

```js
/**
 * Launches the front-door activity of a specified package.
 *
 * @param args {Object} Named parameters.
 * @param args.package {Object} Package to launch.
 * @return {Promise} A Promise that resolves if package is launched.
 */
PackageManager
    .launchPackage({
        package: "com.android.settings"
    })
    .then(function () {
        console.log("success");
    })
    .catch(function (reason) {
        console.error(reason);
    });
```

## Documentation
- <a href="https://dff-solutions.github.io/dff.CordovaPlugin.PackageManager/" target="_blank" >JAVA DOC</a>
