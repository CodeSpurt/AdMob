package com.codespurt.admob.utils;

import android.content.Context;
import android.util.Log;

import com.codespurt.admob.R;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

/**
 * Created by CodeSpurt on 10-08-2017.
 */

public class BannerAds {

    private Context context;
    private AdView adView;
    private boolean isTestDevice = true;

    public BannerAds(Context context, AdView adView) {
        this.context = context;
        this.adView = adView;

        initializeAds();
    }

    private void initializeAds() {
        MobileAds.initialize(context, context.getResources().getString(R.string.admob_app_id));
    }

    private AdRequest getOriginalAd() {
        AdRequest adRequest = new AdRequest.Builder().build();
        return adRequest;
    }

    private AdRequest getTestDeviceAd() {
        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice(context.getResources().getString(R.string.test_device))
                .build();
        return adRequest;
    }

    public void showAd() {
        if (isTestDevice) {
            if (getTestDeviceAd().isTestDevice(context)) {
                adView.loadAd(getTestDeviceAd());
            }
        } else {
            adView.loadAd(getOriginalAd());
        }
    }

    public void setListener() {
        adView.setAdListener(new AdListener() {

            @Override
            public void onAdLoaded() {
                // Code to be executed when an ad finishes loading.
                Log.i("Ads", "onAdLoaded");
            }

            @Override
            public void onAdFailedToLoad(int errorCode) {
                // Code to be executed when an ad request fails.
                Log.i("Ads", "onAdFailedToLoad");
            }

            @Override
            public void onAdOpened() {
                // Code to be executed when an ad opens an overlay that
                // covers the screen.
                Log.i("Ads", "onAdOpened");
            }

            @Override
            public void onAdLeftApplication() {
                // Code to be executed when the user has left the app.
                Log.i("Ads", "onAdLeftApplication");
            }

            @Override
            public void onAdClosed() {
                // Code to be executed when when the user is about to return
                // to the app after tapping on an ad.
                Log.i("Ads", "onAdClosed");
            }
        });
    }
}