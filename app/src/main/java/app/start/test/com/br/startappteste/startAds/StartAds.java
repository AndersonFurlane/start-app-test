package app.start.test.com.br.startappteste.startAds;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.startapp.android.publish.Ad;
import com.startapp.android.publish.AdDisplayListener;
import com.startapp.android.publish.AdEventListener;
import com.startapp.android.publish.StartAppAd;
import com.startapp.android.publish.splash.SplashConfig;

/**
 * Created by andersonfurlane on 10/28/14.
 */
public class StartAds {

    public static StartAppAd buildStartApp(Context context) {
        StartAppAd startAppAd = new StartAppAd(context);
        startAppAd.init(context, "Your Developer Id", "Your App ID",);
        return startAppAd;
    }

    public static void showSlider(Context context){
        StartAppAd startAds = buildStartApp(context);
        startAds.showSlider( (Activity) context);
    }

    public static void showSplashScreen(Context context, Bundle bundle){
        StartAppAd startAds = buildStartApp(context);
        SplashConfig config = new SplashConfig();
        config.setTheme(SplashConfig.Theme.BLAZE);
        startAds.showSplash((Activity) context, bundle, config);
    }

    public static void showInterstitial(final Context context, final Activity origin, final Activity destination, final StartAppAd.AdMode type){
        final StartAppAd startAds = buildStartApp(context);
        startAds.loadAd (type, new AdEventListener() {
            @Override
            public void onReceiveAd(Ad ad) {
                if (ad.isReady()){
                    startAds.showAd(new AdDisplayListener() {
                        @Override
                        public void adHidden(Ad ad) {
                            Intent intent = new Intent(origin, destination.getClass());
                            context.startActivity(intent);
                        }
                        @Override
                        public void adDisplayed(Ad ad) {
                        }
                        @Override
                        public void adClicked(Ad ad) {
                        }
                    });
                }
            }
            @Override
            public void onFailedToReceiveAd(Ad ad) {
            }
        });
    }
}