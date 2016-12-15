# dff.CordovaPlugin.PackageManager

Cordova plugin to access functionality of Android [PackageManager](http://developer.android.com/reference/android/content/pm/PackageManager.html "PackageManager")

## Supported Platforms
  * Android
  
## Install

```sh
$ cordova plugin add git@github.com:dff-solutions/dff.CordovaPlugin.PackageManager.git
```
    
## Usage
Feature is available in JavaScript via global `PackageManager`.

### Constants

```js
GET_ACTIVITIES = 1;
GET_GIDS = 256;
GET_CONFIGURATIONS = 16384;
GET_INSTRUMENTATION = 16;
GET_PERMISSIONS = 4096;
GET_PROVIDERS = 8;
GET_RECEIVERS = 2;
GET_SERVICES = 4;
GET_SIGNATURES = 64;
```

### getPackageInfo
```js
PackageManager
    .getPackageInfo(success, error, args)
```

`args` is expected to be an object containing optional property `flags`. Flags modify the data to be returned.
Multiple flags can be added.

```js
PackageManager
    .getPackageInfo(function (info) {
        console.log(info);
    }, function (reason) {
        console.error(reason);
    }, {
        flags: PackageManager.GET_PERMISSIONS
    }
);
```
