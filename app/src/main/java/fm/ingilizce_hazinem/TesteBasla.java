package fm.ingilizce_hazinem;

import android.app.Activity;
import android.app.FragmentManager;
import android.os.Build;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;

/**
 * Created by user on 4.8.2017.
 */
public class TesteBasla extends FragmentActivity {
    FragmentManager fragmentManager;
    LinearLayout linearLayout;
    ViewPager viewPager=null;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.teste_basla);
        viewPager= (ViewPager) findViewById(R.id.pager);
        fragmentManager=getFragmentManager();
        android.support.v4.app.FragmentManager fragmentManager=getSupportFragmentManager();
        viewPager.setAdapter(new Myadapter(fragmentManager));
        Window window = getWindow();
        window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT_WATCH) {
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(getResources().getColor(android.R.color.holo_orange_light));
        }
    }
}
class Myadapter extends FragmentPagerAdapter {

    public Myadapter(android.support.v4.app.FragmentManager fm) {
        super(fm);
    }

    @Override
    public android.support.v4.app.Fragment getItem(int position) {
        android.support.v4.app.Fragment fragment=null;
        if(position==0){
            fragment=new Kleime_Bulma_Secenek();
        }
        if(position==1){
            fragment=new Kelime_Secme_Secenek();
        }
        if(position==2){
            fragment=new Sesli_Kelime_Secenek();
        }
       /* if(position==3){
            fragment=new Sesli_Anlami_Secenek();
        }
        if(position==4){
            fragment=new Eslestirme_Secenek();
        }*/
        return fragment;
    }

    @Override
    public int getCount() {
        return 3;
    }

   /* @Override
    public CharSequence getPageTitle(int position) {
        if(position==0){
            return  "Birinci";
        }
        if(position==1){
            return  "ikinci";
        }
        if(position==2){
            return  "ücüncü";
        }
        if(position==3){
            return  "dorduncü";
        }
        if(position==4){
            return  "Bes";
        }
        return null;
    }*/
}
