package app.start.test.com.br.startappteste;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.startapp.android.publish.StartAppAd;

import app.start.test.com.br.startappteste.startAds.StartAds;

public class InterstitialsActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interstitials);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.interstitials, menu);
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

    public void interstitialsAutomatic(View view){
        Intent intent = new Intent();
        StartAds.showInterstitial(view.getContext(), InterstitialsActivity.this, new InterstitialsActivity(), StartAppAd.AdMode.AUTOMATIC);
    }
    public void interstitialsFullPage(View view){
        StartAds.showInterstitial(view.getContext(), InterstitialsActivity.this, new InterstitialsActivity(), StartAppAd.AdMode.FULLPAGE);
    }
    public void interstitialsOfferWall(View view){
        StartAds.showInterstitial(view.getContext(), InterstitialsActivity.this, new InterstitialsActivity(), StartAppAd.AdMode.OFFERWALL);
    }
    public void interstitialsOverlay(View view){
        StartAds.showInterstitial(view.getContext(), InterstitialsActivity.this, new InterstitialsActivity(), StartAppAd.AdMode.OVERLAY);
    }
}
