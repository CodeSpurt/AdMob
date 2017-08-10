package com.codespurt.admob.utils;

import android.content.Context;
import android.util.Log;

import com.codespurt.admob.R;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;

/**
 * Created by CodeSpurt on 10-08-2017.
 */

public class InterstitialAds {

    private Context context;
    private InterstitialAd mInterstitialAd;
    private String fromWhichActivity;
    private boolean isTestDevice = true;

    public InterstitialAds(Context context, String fromWhichActivity) {
        this.context = context;
        this.fromWhichActivity = fromWhichActivity;

        switch (fromWhichActivity) {
            case "InterstitialActivity":
                initializeAds(context.getResources().getString(R.string.admob_interstitial_ad_unit_id));
                break;
        }
    }

    private void initializeAds(String adUnitId) {
        mInterstitialAd = new InterstitialAd(context);
        mInterstitialAd.setAdUnitId(adUnitId);
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
            mInterstitialAd.loadAd(getTestDeviceAd());
        } else {
            mInterstitialAd.loadAd(getOriginalAd());
        }
        mInterstitialAd.show();
    }

    public void reloadAd() {
        mInterstitialAd.setAdListener(new AdListener() {

            @Override
            public void onAdClosed() {
                // Load the next interstitial.
                mInterstitialAd.loadAd(getTestDeviceAd());
            }
        });
    }

    public void setListener() {
        mInterstitialAd.setAdListener(new AdListener() {

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
                // Code to be executed when the ad is displayed.
                Log.i("Ads", "onAdOpened");
            }

            @Override
            public void onAdLeftApplication() {
                // Code to be executed when the user has left the app.
                Log.i("Ads", "onAdLeftApplication");
            }

            @Override
            public void onAdClosed() {
                // Code to be executed when when the interstitial ad is closed.
                Log.i("Ads", "onAdClosed");
            }
        });
    }
}