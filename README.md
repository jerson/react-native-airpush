# react-native-airpush

Airpush support for **Android**

## Getting started

`$ npm install react-native-airpush --save`

### Mostly automatic installation

`$ react-native link react-native-airpush`

### Manual installation

#### Android

1.  Open up `android/app/src/main/java/[...]/MainActivity.java`

- Add `import me.jerson.mobile.ads.airpush.RNAirpushPackage;` to the imports at the top of the file
- Add `new RNAirpushPackage()` to the list returned by the `getPackages()` method

2.  Append the following lines to `android/settings.gradle`:
    ```
    include ':react-native-airpush'
    project(':react-native-airpush').projectDir = new File(rootProject.projectDir, 	'../node_modules/react-native-airpush/android')
    ```
3.  Insert the following lines inside the dependencies block in `android/app/build.gradle`:
    ```
      compile project(':react-native-airpush')
    ```
4.  Add `com-YOURPACKAGETOKEN.jar` to your `android/app/libs/airpush` dir
5.  Replace `YOURPACKAGETOKEN` with your Airpush token in `android/src/main/java/me/jerson/mobile/ads/airpush/*.java` dir


## Usage

```javascript
import Airpush, { BannerView } from "react-native-airpush";

type AdType =
  | "appwall"
  | "interstitial"
  | "landing_page"
  | "overlay"
  | "smartwall"
  | "video";

Airpush.setAppId(appId);
Airpush.setApiKey(apiKey);
Airpush.setEulaLanguage(language);
Airpush.setPlacementId(id);
Airpush.setTestMode(enabled);
Airpush.setCachingEnabled(enabled);
Airpush.setShowErrorDialog(enabled);
Airpush.startIconAd();
Airpush.startPushAd();
Airpush.start360BannerAd();
Airpush.startInterstitialAd(adType);

<BannerView width={320} height={50} />;
```
