package com.codespurt.admob;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button banner, interstitial;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        banner = (Button) findViewById(R.id.btn_banner);
        interstitial = (Button) findViewById(R.id.btn_interstitial);
    }

    @Override
    protected void onResume() {
        super.onResume();
        banner.setOnClickListener(this);
        interstitial.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_banner:
                startActivity(new Intent(this, BannerActivity.class));
                break;
            case R.id.btn_interstitial:
                startActivity(new Intent(this, InterstitialActivity.class));
                break;
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        banner.setOnClickListener(null);
        interstitial.setOnClickListener(null);
    }
}
