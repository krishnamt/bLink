package com.blink;

import android.os.Bundle;
import android.webkit.WebView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;

public class WebViewAcitivity extends AppCompatActivity {
    private InterstitialAd mInterstitialAd;
    private AdRequest interAdRequest;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view_acitivity);
        showbannerAds();
        showInterstitialAds();

        WebView browser = (WebView) findViewById(R.id.webview);
        browser.loadUrl("https://www.linkintime.co.in/");

    }


    private void showInterstitialAds() {
        interAdRequest = new AdRequest.Builder().build();

        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId("ca-app-pub-8443700731167295/1862335025");
        mInterstitialAd.loadAd(interAdRequest);
        mInterstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdLoaded() {
                super.onAdLoaded();
                mInterstitialAd.show();
            }
        });
    }


    private void showbannerAds() {
        /*AdView mAdView = (AdView) findViewById(R.id.ad);
        AdRequest adRequest = new AdRequest.Builder().addTestDevice("7F58639D873F3859A5234B3D2BD8E11C").build();
        mAdView.loadAd(adRequest);*/
    }
}
