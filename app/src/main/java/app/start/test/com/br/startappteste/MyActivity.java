package app.start.test.com.br.startappteste;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.startapp.android.publish.StartAppAd;

import app.start.test.com.br.startappteste.startAds.StartAds;


public class MyActivity extends Activity {
    private static StartAppAd mStartApp;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_my);
            mStartApp = StartAds.buildStartApp(this);
        }


        @Override
        public boolean onCreateOptionsMenu(Menu menu) {
            // Inflate the menu; this adds items to the action bar if it is present.
            getMenuInflater().inflate(R.menu.my, menu);
            return true;
        }

        @Override
        public boolean onOptionsItemSelected(MenuItem item) {
            // Handle action bar item clicks here. The action bar will
            // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onResume(){
        super.onResume();
        mStartApp.onResume();
    }

    @Override
    public void onPause(){
        super.onPause();
        mStartApp.onPause();
    }

    public void changeBanner(View view){
        Intent intent = new Intent(this, BannerActivity.class);
        startActivity(intent);
    }

    public void changeInterstitials(View view){
        StartAds.showInterstitial(view.getContext(), MyActivity.this, new InterstitialsActivity(), StartAppAd.AdMode.AUTOMATIC);
    }

    public void changeSplash(View view){
        Intent intent = new Intent(this, SplashScreenActivity.class);
        startActivity(intent);
    }

    public void changeSlider(View view){
        Intent intent = new Intent(this, SliderActivity.class);
        startActivity(intent);
    }
}
