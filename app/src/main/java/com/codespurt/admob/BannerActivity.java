package com.codespurt.admob;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.codespurt.admob.utils.BannerAds;
import com.google.android.gms.ads.AdView;

/**
 * Created by CodeSpurt on 10-08-2017.
 */

public class BannerActivity extends AppCompatActivity {

    private AdView mAdView;
    private BannerAds bannerAds;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ad_banner);

        mAdView = (AdView) findViewById(R.id.adView);

        setupAds();
    }

    private void setupAds() {
        bannerAds = new BannerAds(this, mAdView);
        bannerAds.showAd();
        bannerAds.setListener();
    }
}