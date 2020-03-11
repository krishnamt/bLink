package com.blink;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    private InterstitialAd mInterstitialAd;
    private AdRequest interAdRequest;
    Button btn;
    ProgressBar progressBar1;
    EditText editBox;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        progressBar1 = (ProgressBar)findViewById(R.id.progressBar1);
        editBox = (EditText)findViewById(R.id.editBox);
        progressBar1.setVisibility(View.GONE);
        btn = (Button)findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(editBox.getText().toString().trim().equals("")){
                    Toast.makeText(MainActivity.this,"Please enter data!",Toast.LENGTH_SHORT).show();
                }else {
                    progressBar1.setVisibility(View.VISIBLE);
                    showTimer();
                }

            }
        });
        showbannerAds();
        showInterstitialAds();
    }

    private void showTimer(){
        new CountDownTimer(3000, 1000) {

            public void onTick(long millisUntilFinished) {

            }

            public void onFinish() {
                progressBar1.setVisibility(View.GONE);
                startActivity(new Intent(MainActivity.this,WebViewAcitivity.class));
            }
        }.start();
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




//        AdView adView = new AdView(MainActivity.this);
//        adView.setAdSize(AdSize.BANNER);
//        adView.setAdUnitId("ca-app-pub-8443700731167295/2983845005");
      /*-  AdView mAdView = (AdView) findViewById(R.id.ad);
        AdRequest adRequest = new AdRequest.Builder().addTestDevice("7F58639D873F3859A5234B3D2BD8E11C").build();
        mAdView.loadAd(adRequest);*/
    }
}
