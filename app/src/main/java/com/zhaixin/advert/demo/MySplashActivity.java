package com.zhaixin.advert.demo;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.heart.weather.R;
import com.zhaixin.listener.OnBannerAdListener;
import com.zhaixin.listener.OnInterstitialAdListener;
import com.zhaixin.listener.OnSplashAdListener;
import com.zhaixin.listener.error.ErrorMessage;
import com.zhaixin.open.BannerAd;
import com.zhaixin.open.InterstitialAd;
import com.zhaixin.open.SplashAd;
import com.zhaixin.provider.SdkProviderType;

import androidx.appcompat.app.AppCompatActivity;

public class MySplashActivity extends AppCompatActivity {

    //开屏ID
    private static String SId = "0DE066CE2FAF4A24B08E04D28DE08EC7";
    //插屏ID
    private static String CId = "1995B0E4D89B41B298B1789B1DBFF275";
    //bannerID
    private static String BID = "F8E3D639C08A4FFB8CFC0C9D4099040A";

    private FrameLayout content, bannerContent;
    private SplashAd Sad;
    private InterstitialAd Cad;

    private BannerAd bad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_ACTIVITY_TRANSITIONS);
        getWindow().clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
        getWindow().setStatusBarColor(Color.TRANSPARENT);
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_my_splash);

        content = findViewById(R.id.content);

        bannerContent = findViewById(R.id.bannerContent);

        splash();

        banner();

        interstitial();

    }

    private void splash() {

        Sad = new SplashAd(MySplashActivity.this, SId, new OnSplashAdListener() {
            @Override
            public void onLoad(SdkProviderType type) {
                Sad.showAd(content);
            }

            @Override
            public void onShow(SdkProviderType type) {

            }

            @Override
            public void onClick(SdkProviderType type) {

            }


            @Override
            public void onClose(SdkProviderType type) {
                Toast.makeText(MySplashActivity.this, "CLOSE", Toast.LENGTH_SHORT).show();
                MySplashActivity.this.finish();
            }

            @Override
            public void onError(SdkProviderType type, ErrorMessage message) {

            }
        });
        Sad.loadAd();
    }

    private void interstitial() {
        Cad = new InterstitialAd(MySplashActivity.this, 100, CId, new OnInterstitialAdListener() {
            @Override
            public void onLoad(SdkProviderType type) {
                Cad.showAd();
            }

            @Override
            public void onShow(SdkProviderType type, int sdkId) {

            }

            @Override
            public void onClick(SdkProviderType type, int sdkId) {

            }


            @Override
            public void onClose(SdkProviderType type) {

            }

            @Override
            public void onError(SdkProviderType type, ErrorMessage message) {

            }
        });
        Cad.loadAd();
    }

    private void banner() {
        bad = new BannerAd(MySplashActivity.this, BID, new OnBannerAdListener() {
            @Override
            public void onLoad(SdkProviderType type) {
                bad.showAd(bannerContent);
            }

            @Override
            public void onViewCreated(SdkProviderType type, View view) {

            }

            @Override
            public void onShow(SdkProviderType type, View view) {

            }

            @Override
            public void onClick(SdkProviderType type, View view) {

            }


            @Override
            public void onClose(SdkProviderType type, View view) {

            }

            @Override
            public void onError(SdkProviderType type, ErrorMessage message) {

            }
        });
        bad.loadAd();
    }
}