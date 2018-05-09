package fm.ingilizce_hazinem;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.widget.LinearLayout;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;

/**
 * Created by user on 9.9.2017.
 */
public class reklamgetir extends AppCompatActivity {
    private AdView adView;
    private InterstitialAd gecisreklami;
    private AdRequest adRequest;

    public  void reklamiyukle(LinearLayout layout, Context context,String dene){
        adView=new AdView(context);
        adView.setAdSize(AdSize.BANNER);
        adView.setAdUnitId(dene);
        layout.addView(adView);
        AdRequest adRequest=new AdRequest.Builder().addTestDevice(AdRequest.DEVICE_ID_EMULATOR).build();
        adView.loadAd(adRequest);
    }

    public void gecisreklami(Context context){
        adRequest=new AdRequest.Builder().build();
        gecisreklami=new InterstitialAd(context);
        gecisreklami.setAdUnitId("ca-app-pub-8449130834114994/6311504281");
        gecisreklami.setAdListener(new AdListener() {
            @Override
            public void onAdClosed() {
                loadgecisreklami();
            }



            @Override
            public void onAdLoaded() {
                loadgecisreklami();
            }
    });
        loadgecisreklami();
    }
     public  void  loadgecisreklami(){

        gecisreklami.loadAd(adRequest);
    }
    public  void showgecisreklami(){
        if(gecisreklami.isLoaded()){
            gecisreklami.show();
        }
    }
}
