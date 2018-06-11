
package me.jerson.mobile.ads.airpush;

import android.util.Log;
import com.facebook.react.bridge.*;
import com.facebook.react.module.annotations.ReactModule;
import com.YOURPACKAGETOKEN.AdConfig;
import com.YOURPACKAGETOKEN.AdListener;
import com.YOURPACKAGETOKEN.Main;

public class RNAirpushModule extends ReactContextBaseJavaModule
    implements  LifecycleEventListener, AdListener {

  private static final String TAG = "RNAirpushModule";
  private ReactContext reactContext;
  private boolean isLoaded;
  private Main manager;

  public RNAirpushModule(ReactApplicationContext reactContext) {
    super(reactContext);
    this.reactContext = reactContext;
    this.reactContext.addLifecycleEventListener(this);
  }

  @Override
  public String getName() {
    return "RNAirpush";
  }

  protected void initManager() {

    if (manager == null && reactContext.getCurrentActivity() != null) {
      manager = new Main(reactContext.getCurrentActivity(), this);
    } else {
      Log.w(TAG, "[ERROR] initManager");
    }

  }

  @ReactMethod
  public void startIconAd() {
    initManager();
    if (manager != null) {
      manager.startIconAd();
    } else {
      Log.w(TAG, "[ERROR] startIconAd");
    }
  }

  @ReactMethod
  public void startPushAd() {
    initManager();
    if (manager != null) {
      manager.startPushAd();
    } else {
      Log.w(TAG, "[ERROR] startPushAd");
    }
  }

  @ReactMethod
  public void start360BannerAd() {
    initManager();
    if (manager != null && reactContext.getCurrentActivity() != null) {
      manager.start360BannerAd(reactContext.getCurrentActivity(), this);
    } else {
      Log.w(TAG, "[ERROR] start360BannerAd");
    }
  }

  @ReactMethod
  public void startInterstitialAd(String adType) {
    initManager();
    if (manager != null && reactContext.getCurrentActivity() != null) {
      manager.startInterstitialAd(getAdTypeFromString(adType), this);
    } else {
      Log.w(TAG, "[ERROR] startInterstitialAd");
    }
  }

  @ReactMethod
  public void setTestMode(int testMode) {

    boolean testModeVal = testMode == 1;
    AdConfig.setTestMode(testModeVal);
  }

  @ReactMethod
  public void setCachingEnabled(int cachingEnabled) {

    boolean cachingEnabledeVal = cachingEnabled == 1;
    AdConfig.setCachingEnabled(cachingEnabledeVal);
  }

  @ReactMethod
  public void setShowErrorDialog(int showErrorDialog) {
    boolean showErrorDialogVal = showErrorDialog == 1;
    AdConfig.setShowErrorDialog(showErrorDialogVal);
  }

  @ReactMethod
  public void setPlacementId(int placementId) {
    AdConfig.setPlacementId(placementId);
  }

  @ReactMethod
  public void setEulaLanguage(String eulaLanguage) {
    AdConfig.setEulaLanguage(getEulaLanguageFromString(eulaLanguage));
  }

  @ReactMethod
  public void setApiKey(String apiKey) {
    AdConfig.setApiKey(apiKey);
  }

  @ReactMethod
  public void setAppId(int appId) {
    AdConfig.setAppId(appId);
  }

  private AdConfig.EulaLanguage getEulaLanguageFromString(String eulaLanguage) {
    switch (eulaLanguage) {
    case "spanish":
      return AdConfig.EulaLanguage.SPANISH;
    case "french":
      return AdConfig.EulaLanguage.FRENCH;
    case "arabic":
      return AdConfig.EulaLanguage.ARABIC;
    case "chinese":
      return AdConfig.EulaLanguage.CHINESE;
    case "portuguese":
      return AdConfig.EulaLanguage.PORTUGUESE;
    case "german":
      return AdConfig.EulaLanguage.GERMAN;
    case "italian":
      return AdConfig.EulaLanguage.ITALIAN;
    case "japanese":
      return AdConfig.EulaLanguage.JAPANESE;
    case "russian":
      return AdConfig.EulaLanguage.RUSSIAN;
    case "turkish":
      return AdConfig.EulaLanguage.TURKISH;
    case "english":
    default:
      return AdConfig.EulaLanguage.ENGLISH;
    }
  }

  private AdConfig.AdType getAdTypeFromString(String adType) {
    switch (adType) {
    case "appwall":
      return AdConfig.AdType.appwall;
    case "interstitial":
      return AdConfig.AdType.interstitial;
    case "landing_page":
      return AdConfig.AdType.landing_page;
    case "overlay":
      return AdConfig.AdType.overlay;
    case "smartwall":
      return AdConfig.AdType.smartwall;
    case "video":
      return AdConfig.AdType.video;
    default:
      return AdConfig.AdType.interstitial;
    }
  }

  @Override
  public void onHostResume() {
    isLoaded = true;
    Log.d(TAG, "onHostResume");
  }

  @Override
  public void onHostPause() {
    isLoaded = true;
    Log.d(TAG, "onHostPause");

  }

  @Override
  public void onHostDestroy() {
    isLoaded = false;
    Log.d(TAG, "onHostDestroy");

  }

  @Override
  public void onError(ErrorType errorType, String s) {
    Log.d(TAG, "onError:" + s);

  }

  @Override
  public void onAdLoading() {
    Log.d(TAG, "onAdLoading");

  }

  @Override
  public void onAdLoaded() {
    Log.d(TAG, "onAdLoaded");

  }

  @Override
  public void onAdExpanded() {
    Log.d(TAG, "onAdExpanded");

  }

  @Override
  public void onAdClicked() {
    Log.d(TAG, "onAdClicked");

  }

  @Override
  public void onAdClosed() {
    Log.d(TAG, "onAdClosed");

  }

  @Override
  public void onAdCached(AdConfig.AdType adType) {
    Log.d(TAG, "onAdCached");

  }
}