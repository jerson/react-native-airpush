import React from "react";

import {
  NativeModules,
  Platform,
  requireNativeComponent,
  View
} from "react-native";

const { RNAirpush } = NativeModules;

const RNBannerView = requireNativeComponent("RNAirpushBannerView", BannerView);

const TAG = "[Airpush]";
export default class Airpush {
  static setAppId(appId) {
    __DEV__ && console.debug(TAG, "setAppId", appId);
    if (Platform.OS !== "android") {
      __DEV__ && console.warn(TAG, "not supported on", Platform.OS);
      return;
    }
    RNAirpush.setAppId(appId);
  }
  static setApiKey(apiKey) {
    __DEV__ && console.debug(TAG, "setApiKey", apiKey);
    if (Platform.OS !== "android") {
      __DEV__ && console.warn(TAG, "not supported on", Platform.OS);
      return;
    }
    RNAirpush.setApiKey(apiKey);
  }
  static setEulaLanguage(language) {
    __DEV__ && console.debug(TAG, "setEulaLanguage", language);
    if (Platform.OS !== "android") {
      __DEV__ && console.warn(TAG, "not supported on", Platform.OS);
      return;
    }
    RNAirpush.setEulaLanguage(language);
  }

  static setPlacementId(id) {
    __DEV__ && console.debug(TAG, "setPlacementId", id);
    if (Platform.OS !== "android") {
      __DEV__ && console.warn(TAG, "not supported on", Platform.OS);
      return;
    }
    RNAirpush.setPlacementId(id);
  }
  static setTestMode(enabled) {
    __DEV__ && console.debug(TAG, "setTestMode", enabled);
    if (Platform.OS !== "android") {
      __DEV__ && console.warn(TAG, "not supported on", Platform.OS);
      return;
    }
    RNAirpush.setTestMode(enabled);
  }

  static setCachingEnabled(enabled) {
    __DEV__ && console.debug(TAG, "setCachingEnabled", enabled);
    if (Platform.OS !== "android") {
      __DEV__ && console.warn(TAG, "not supported on", Platform.OS);
      return;
    }
    RNAirpush.setCachingEnabled(enabled);
  }

  static setShowErrorDialog(enabled) {
    __DEV__ && console.debug(TAG, "setShowErrorDialog", enabled);
    if (Platform.OS !== "android") {
      __DEV__ && console.warn(TAG, "not supported on", Platform.OS);
      return;
    }
    RNAirpush.setShowErrorDialog(enabled);
  }

  static startIconAd() {
    __DEV__ && console.debug(TAG, "startIconAd");
    if (Platform.OS !== "android") {
      __DEV__ && console.warn(TAG, "not supported on", Platform.OS);
      return;
    }
    RNAirpush.startIconAd();
  }

  static startPushAd() {
    __DEV__ && console.debug(TAG, "startPushAd");
    if (Platform.OS !== "android") {
      __DEV__ && console.warn(TAG, "not supported on", Platform.OS);
      return;
    }
    RNAirpush.startPushAd();
  }

  static start360BannerAd() {
    __DEV__ && console.debug(TAG, "start360BannerAd");
    if (Platform.OS !== "android") {
      __DEV__ && console.warn(TAG, "not supported on", Platform.OS);
      return;
    }
    RNAirpush.start360BannerAd();
  }

  static startInterstitialAd(adType) {
    __DEV__ && console.debug(TAG, "startInterstitialAd", adType);
    if (Platform.OS !== "android") {
      __DEV__ && console.warn(TAG, "not supported on", Platform.OS);
      return;
    }
    RNAirpush.startInterstitialAd(adType);
  }
}

export class BannerView extends React.Component {
  render() {
    const { width, height, style, ...props } = this.props;

    return (
      <View style={[style, { width, height }]}>
        <RNBannerView
          style={[style, { width, height }]}
          adWidth={adWidth}
          adHeight={adHeight}
          {...props}
        />
      </View>
    );
  }
}
