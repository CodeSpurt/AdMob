package com.codespurt.admob;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.codespurt.admob.utils.InterstitialAds;

/**
 * Created by CodeSpurt on 10-08-2017.
 */

public class InterstitialActivity extends AppCompatActivity implements View.OnClickListener {

    private Button showAd;
    private InterstitialAds interstitialAds;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ad_interstitial);

        showAd = (Button) findViewById(R.id.btn_show_interstitial);

        setupAds();
    }

    @Override
    protected void onResume() {
        super.onResume();
        showAd.setOnClickListener(this);
    }

    private void setupAds() {
        interstitialAds = new InterstitialAds(this, "InterstitialActivity");
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_show_interstitial:
                try {
                    interstitialAds.showAd();
                    interstitialAds.setListener();
                } catch (Exception e) {
                    e.printStackTrace();
                    Log.d("Ads", "Ad is not loaded yet");
                }
                break;
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        showAd.setOnClickListener(null);
    }
}