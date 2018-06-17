package me.jerson.mobile.ads.airpush;

import android.support.annotation.Nullable;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

import com.facebook.react.common.MapBuilder;
import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.views.view.ReactViewGroup;
import com.YOURPACKAGETOKEN.AdConfig;
import com.YOURPACKAGETOKEN.AdListener;
import com.YOURPACKAGETOKEN.AdView;

import java.util.Map;

public class RNAirpushBannerViewManager extends SimpleViewManager<ReactViewGroup> implements AdListener {

    public static final String TAG = "RNAirpushBannerView";

    public static final String PROP_WIDTH = "adWidth";
    public static final String PROP_HEIGHT = "adHeight";
    public static final String PROP_BANNER_TYPE = "bannerType";

    private String bannerType = "";
    private int width = 0;
    private int height = 0;
    private ThemedReactContext mThemedReactContext;

    @Override
    public void onError(ErrorType errorType, String s) {
        Log.d(TAG, "onError " + errorType.toString() + ":" + s);

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

    @Override
    public String getName() {
        return "RNAirpush";
    }

    @Override
    protected ReactViewGroup createViewInstance(ThemedReactContext themedReactContext) {

        mThemedReactContext = themedReactContext;
        ReactViewGroup view = new ReactViewGroup(themedReactContext);
        return view;
    }

    protected void attachNewAdView(final ReactViewGroup view) {
        Log.d(TAG, "attachNewAdView");

        if (this.width > 0 && this.height > 0 && !this.bannerType.equals("")) {

            AdView oldAdView = (AdView) view.getChildAt(0);
            if (oldAdView != null) {
                oldAdView.stopAd();
            }
            view.removeAllViews();
            final AdView adView = new AdView(mThemedReactContext.getCurrentActivity(), this);

            view.addView(adView);
            loadAd(adView);
        }

    }

    @Override
    @Nullable
    public Map<String, Object> getExportedCustomDirectEventTypeConstants() {
        MapBuilder.Builder<String, Object> builder = MapBuilder.builder();
        for (Events event : Events.values()) {
            builder.put(event.toString(), MapBuilder.of("registrationName", event.toString()));
        }
        return builder.build();
    }

    @ReactProp(name = PROP_HEIGHT)
    public void setHeight(final ReactViewGroup view, int height) {
        Log.d(TAG, "setHeight:" + height);

        this.height = height;
        attachNewAdView(view);
    }

    @ReactProp(name = PROP_WIDTH)
    public void setWidth(final ReactViewGroup view, int width) {
        Log.d(TAG, "setWidth:" + width);

        this.width = width;
        attachNewAdView(view);
    }

    @ReactProp(name = PROP_BANNER_TYPE)
    public void setBannerType(final ReactViewGroup view, String bannerType) {
        Log.d(TAG, "setBannerType:" + bannerType);

        if (bannerType != null && !bannerType.equals("")) {
            this.bannerType = getBannerTypeFromString(bannerType);
            attachNewAdView(view);
        }
    }

    private int convertDpToPx(int dp) {
        return Math.round(
                dp * (mThemedReactContext.getResources().getDisplayMetrics().xdpi / DisplayMetrics.DENSITY_DEFAULT));

    }

    private void updateSize(AdView adView) {
        int width = adView.getWidth();
        int height = adView.getHeight();

        int left = adView.getLeft();
        int top = adView.getTop();

        adView.measure(width, height);
        adView.layout(left, top, left + width, top + height);
        adView.setLayoutParams(new ViewGroup.LayoutParams(width, height));
    }

    private void loadAd(final AdView adView) {

        Log.d(TAG, "loadAd");

        adView.setWidth(this.width);
        adView.setHeight(this.height);
        adView.setBannerType(this.bannerType);
        adView.setVisibility(View.VISIBLE);
        adView.loadAd();

        updateSize(adView);

    }

    private String getBannerTypeFromString(String bannerType) {
        switch (bannerType) {
        case "abstractLarge":
            return AdView.BANNER_TYPE_ABSTRACT_LARGE;
        case "abstractSmall":
            return AdView.BANNER_TYPE_ABSTRACT_SMALL;
        case "mediumRectangle":
            return AdView.BANNER_TYPE_MEDIUM_RECTANGLE;
        case "richMedia":
            return AdView.BANNER_TYPE_RICH_MEDIA;
        case "video":
            return AdView.BANNER_TYPE_VIDEO;
        case "inAppAdd":
        default:
            return AdView.BANNER_TYPE_IN_APP_AD;
        }
    }

    public enum Events {
        EVENT_SIZE_CHANGE("onSizeChange"), EVENT_RECEIVE_AD("onAdViewDidReceiveAd"),
        EVENT_ERROR("onDidFailToReceiveAdWithError"), EVENT_WILL_PRESENT("onAdViewWillPresentScreen"),
        EVENT_WILL_DISMISS("onAdViewWillDismissScreen"), EVENT_DID_DISMISS("onAdViewDidDismissScreen"),
        EVENT_WILL_LEAVE_APP("onAdViewWillLeaveApplication");

        private final String mName;

        Events(final String name) {
            mName = name;
        }

        @Override
        public String toString() {
            return mName;
        }
    }

}