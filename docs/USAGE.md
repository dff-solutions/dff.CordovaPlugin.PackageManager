# Usage

Feature is available in JavaScript via global __`PackageManager`__.

## Constants

```ts
    GET_ACTIVITIES                       = 1;
    GET_RECEIVERS                        = 2;
    GET_SERVICES                         = 4;
    GET_PROVIDERS                        = 8;
    GET_INSTRUMENTATION                  = 16;
    GET_INTENT_FILTERS                   = 32;
    GET_RESOLVED_FILTER                  = 64;
    GET_META_DATA                        = 128;
    GET_GIDS                             = 256;
    MATCH_DISABLED_COMPONENTS            = 512;       // (0x00000200)
    GET_SHARED_LIBRARY_FILES             = 1024;
    GET_URI_PERMISSION_PATTERNS          = 2048;      // (0x00000800)
    GET_PERMISSIONS                      = 4096;
    MATCH_UNINSTALLED_PACKAGES           = 8192;      // (0x00002000)
    GET_CONFIGURATIONS                   = 16384;
    MATCH_DISABLED_UNTIL_USED_COMPONENTS = 32768;     // (0x00008000)
    MATCH_DEFAULT_ONLY                   = 65536;     // (0x00010000)
    MATCH_ALL                            = 131072;    // (0x00020000)
    MATCH_DIRECT_BOOT_UNAWARE            = 262144;    // (0x00040000)
    MATCH_DIRECT_BOOT_AWARE              = 524288;    // (0x00080000)
    MATCH_SYSTEM_ONLY                    = 1048576;   // (0x00100000)
    GET_SIGNING_CERTIFICATES             = 134217728; // (0x08000000)
```

## Interfaces

### PackageInfo

```ts
interface PackageInfo {
    firstInstallTime: number;
    lastUpdateTime: number;
    packageName: string;
    sharedUserId: string;
    sharedUserLabel: string;
    versionCode: int;
    versionName: string;
    activities: ActivityInfo[];
    applicationInfo: ApplicationInfo;
    configPreferences: ConfigurationInfo;
    gids: number[];
    instrumentation: InstrumentationInfo[];
    permissions: PermissionInfo[];
    providers: ProviderInfo[];
    receivers: ActivityInfo[];
    reqFeatures: FeatureInfo[];
    requestedPermissions: string[];
    requestedPermissionsFlags: number[];
    services: ServiceInfo[];
    signatures: Signature[];
}
```

### ActivityInfo

```ts
interface ActivityInfo {
    name: string;
    packageName: string;
    processName: string;
    isEnabled: boolean;
    enabled: boolean;
    exported: boolean;
    parentActivityName: string;
    permission: string;
    screenOrientation: number;
    softInputMode: number;
    targetActivity: string;
    taskAffinity: string;
    theme: number;
    uiOptions: number;
    configChanges: string[];
    flags: number;
    flagNames: string[];
    launchMode: number;
    launchModeName: string[];
}
```

### ApplicationInfo

```ts
interface ApplicationInfo {
    name: string;
    packageName: string;
    backupAgentName: string;
    className: string;
    compatibleWidthLimitDp: number;
    dataDir: string;
    descriptionRes: number;
    enabled: boolean;
    largestWidthLimitDp: number;
    manageSpaceActivityName: string;
    nativeLibraryDir: string;
    permission: string;
    processName: string;
    publicSourceDir: string;
    requiresSmallestWidthDp: number;
    sharedLibraryFiles: string[];
    sourceDir: string;
    targetSdkVersion: number;
    taskAffinity: string;
    theme: number;
    uiOptions: number;
    uid: number;
    flags: number;
    flagNames: string[];
}
```

### ConfigurationInfo

```ts
interface ConfigurationInfo {
    reqGlEsVersion: number;
    reqInputFeatures: number;
    reqKeyboardType: number;
    reqNavigation: number;
    reqTouchScreen: number;
		
}
```

### InstrumentationInfo

```ts
interface InstrumentationInfo {
    dataDir: string;
    functionalTest: boolean;
    handleProfiling: boolean;
    publicSourceDir: string;
    sourceDir: string;
    targetPackage: string;
}
```

### PermissionInfo

```ts
interface PermissionInfo {
    descriptionRes: number;
    flags: number;
    group: string;
    nonLocalizedDescription?: string;
    protectionLevel: number;
}
```

### ProviderInfo

```ts
interface ProviderInfo {
    authority: string;
    flags: number;
    grantUriPermissions: boolean;
    initOrder: number;
    isSyncable: string;
    multiprocess: boolean;
    readPermission: string;
    writePermission: string;
    pathPermissions: PathPermission[];
    uriPermissionPatterns: PatternMatcher[];
}
```

### PathPermission

```ts
interface PathPermission {
    path: string;
    readPermission: string;
    writePermission: string;
		
}
```

### PatternMatcher

```ts
interface PatternMatcher {
    type: number;
    path: string}
```

### FeatureInfo

```ts
interface FeatureInfo {	
    flags: number;
    name: string;
    reqGlEsVersion: number;
}
```

### ServiceInfo

```ts
interface ServiceInfo {
    name: string;
    packageName: string;
    processName: string;
    isEnabled: boolean;
    enabled: boolean;
    exported: boolean;
    permission: string;
    flags: number;
    flagNames: string[];
}
```

### Signature

```ts
interface Signature {
    charsString: string;
}
```

### ResolveInfo

```ts
interface ResolveInfo {
    icon: number;
    isDefault: boolean;
    labelRes: number;
    match: number;
    preferredOrder: number;
    priority: number;
    specificIndex: number;
    resolvePackageName: string;
    nonLocalizedLabel?: string;
    activityInfo: ActivityInfo;
    filter: IntentFilter;
    providerInfo: ProviderInfo;
    serviceInfo: ServiceInfo;
}
```

### IntentFilter
```ts
interface IntentFilter {
    actions: string[];
    categories: string;
    authorities: AuthorityEntry[];
    paths: PatternMatcher[];
    schemeSpecificParts: PatternMatcher[];
    schemes: string[];
    types: string[];
    countActions: number;
    countCategories: number;
    countDataAuthorities: number;
    countDataPaths: number;
    countDataSchemes: number;
    countDataSchemeSpecificParts: number;
    countDataTypes: number;
    priority: number;
}
```

#### AuthorityEntry
```ts
interface AuthorityEntry {
    host: string;
    port: string;
}
```

## Functions

### getPackageInfo

```ts
/**
 * Retrieve overall information about an application package that is installed on the system.
 *
 * @param {function} success Callback for success
 * @param {function} error Callback for error
 * @param args { Object } Named parameters.
 * @param args.flags { number } Flags which modify the data to be returned.
 * @return { PackageInfo } Package info of current package.
 */
PackageManager
    .getPackageInfo(
         (pkg) => console.info(pkg),
         console.error,
         {
            flags: PackageManager.GET_PERMISSIONS
    });
```


### launchPackage

```ts
/**
 * Launches the front-door activity of a specified package.
 *
 * @param {function} success Callback for success
 * @param {function} error Callback for error
 * @param args { Object } Named parameters.
 * @param args.package { string } Package to launch.
 */
PackageManager
    .launchPackage(
        () => console.log("success")
        console.error,
        {
            package: "com.android.settings"
        }
    );
```

### getInstalledPackages
```ts
/**
 * Return a List of all application packages that are installed for the current user.
 * If flag GET_UNINSTALLED_PACKAGES has been set, a list of all applications including
 * those deleted with DONT_DELETE_DATA (partially installed apps with data directory)
 * will be returned.
 *
 * @param {function} success Callback for success
 * @param {function} error Callback for error
 * @param args { Object } Named parameters.
 * @param args.flags { number } Additional option flags to modify the data returned.
 * 
 * @return { PackageInfo[] } Return a List of all packages that are installed for the current user. 
 */
PackageManager
    .getInstalledPackages(
        (pkgs) => console.info(pkgs)
        , console.error
        , {
            flags: 0
        }
    );
```

### getInstalledApplications
```ts
/**
 * Return a List of all application packages that are installed for the current user.
 * If flag GET_UNINSTALLED_PACKAGES has been set, a list of all applications including
 * those deleted with DONT_DELETE_DATA (partially installed apps with data directory) will be returned.
 *
 * @param {function} success Callback for success
 * @param {function} error Callback for error
 * @param args { Object } Named parameters.
 * @param args.flags { number } Additional option flags to modify the data returned.
 * 
 * @return { ApplicationInfo[] } A List of ApplicationInfo objects, one for each installed application. 
 */
PackageManager
    .getInstalledApplications(
        (apps) => console.info(apps)
        , console.error
        , {
            flags: 0
        }
    );
```

### queryIntentActivities

```ts
/**
 * Retrieve all activities that can be performed for the given intent.
 *
 * @param {function} success Callback for success
 * @param {function} error Callback for error
 * @param args { Object } Named parameters.
 * @param args.flags { number } Additional option flags to modify the data returned.
 * @param args.action { string } The general action to be performed, such as ACTION_VIEW, ACTION_EDIT, ACTION_MAIN, etc.
 * @param args.uri { string } The data to operate on, such as a person record in the contacts database, expressed as a Uri.
 * @param args.categories { string[] } The desired categories.
 * @param args.type { string } The MIME type of the data being handled by this intent.
 *
 * @return { ResolveInfo[] } Returns a List of ResolveInfo objects containing one entry for each matching activity,
 *                         ordered from best to worst.
 */
PackageManager
    .queryIntentActivities(
        (resolveInfo) => console.log(resolveInfo),
        console.error, 
        {
            action: "android.intent.action.VIEW",
            uri: "geo:",
            flags: 0
        }
    );
```

### queryBroadcastReceivers

```ts
/**
 * Retrieve all receivers that can handle a broadcast of the given intent.
 *
 * @param {function} success Callback for success
 * @param {function} error Callback for error
 * @param args { Object } Named parameters.
 * @param args.flags { number } Additional option flags to modify the data returned.
 * @param args.action { string } The general action to be performed, such as ACTION_VIEW, ACTION_EDIT, ACTION_MAIN, etc.
 * @param args.uri { string } The data to operate on, such as a person record in the contacts database, expressed as a Uri.
 * @param args.categories { string[] } The desired categories.
 * @param args.type { string } The MIME type of the data being handled by this intent.
 *
 * @return { ResolveInfo[] } Returns a List of ResolveInfo objects containing one entry for each matching receiver,
 *                         ordered from best to worst.
 */
PackageManager
    .queryBroadcastReceivers(
        (resolveInfo) => console.log(resolveInfo),
        console.error, 
        {
            action: "android.intent.action.BOOT_COMPLETED",
            flags: 0
        }
    );
```