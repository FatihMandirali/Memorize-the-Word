package fm.ingilizce_hazinem;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;

import java.util.ArrayList;
import java.util.List;

import io.github.douglasjunior.androidSimpleTooltip.SimpleTooltip;

/**
 * Created by user on 1.8.2017.
 */
public class Anasayfa extends AppCompatActivity implements View.OnClickListener{
    Button btnkelimeekle,btnkelimegor,btntestet,btnistatistik;
   private static final int aa=1;
    VeriTbani_ModelSinifi db;
    List<Kelimeler_ModelSinifi> kelimelis;
    private InterstitialAd gecisreklami;
    private AdRequest adRequest;
    LinearLayout layout;





    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.anasayfa);

        layout= (LinearLayout) findViewById(R.id.lineerReklamBanner);
        btnkelimeekle= (Button) findViewById(R.id.btnkelimekle);
        btntestet= (Button) findViewById(R.id.btntestet);
        btnkelimegor= (Button) findViewById(R.id.btnkelimelerigor);
        btnkelimeekle.setOnClickListener(this);
        btnkelimegor.setOnClickListener(this);
        btntestet.setOnClickListener(this);
        Window window = getWindow();
        window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT_WATCH) {
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(getResources().getColor(android.R.color.holo_orange_light));
        }
        db=new VeriTbani_ModelSinifi(getApplicationContext());
        kelimelis=new ArrayList<Kelimeler_ModelSinifi>();

        reklamgetir reklam=new reklamgetir();
        String dene=getString(R.string.reklambanner);
        reklam.reklamiyukle(layout,getApplicationContext(),dene);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case  R.id.btnkelimekle:

                showDialog(aa);

                break;
            case R.id.btnkelimelerigor:
                Intent i=new Intent(getApplicationContext(),KelimeleriGor.class);
                startActivity(i);

                break;
            case R.id.btntestet:


                    Intent gecis2 = new Intent(Anasayfa.this, TesteBasla.class);
                    startActivity(gecis2);
                break;

        }

    }

   /* @Override
    public void onBackPressed() {
        super.onBackPressed();
        System.exit(0);
    }*/

    protected Dialog onCreateDialog(int id){
        switch (id){
            case aa:
                final Dialog dialog=new Dialog(this);
                dialog.setContentView(R.layout.kelime_ekle);
                final Button btnekle= (Button) dialog.findViewById(R.id.btnkelimeyiEkle);
                final Button btnkelimeleregit= (Button) dialog.findViewById(R.id.btnkelimelerigor);
                final Spinner diller= (Spinner) dialog.findViewById(R.id.spinner);
                final EditText kelimee= (EditText) dialog.findViewById(R.id.editkelime);
                final EditText kelimeanlami= (EditText) dialog.findViewById(R.id.editkelimeTr);
                ArrayAdapter adapter = ArrayAdapter.createFromResource(this,R.array.Diller,android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                diller.setAdapter(adapter);
                btnekle.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        try {

                            String dil=diller.getSelectedItem().toString();
                            String kelime=kelimee.getText().toString();
                            String anlami=kelimeanlami.getText().toString();

                            Kelimeler_ModelSinifi kelimeler=new Kelimeler_ModelSinifi(dil,kelime,anlami);
                            VeriTbani_ModelSinifi db=new VeriTbani_ModelSinifi(getApplicationContext());
                            long id= db.KayitEkle(kelimeler);
                            if(id==-1){
                                Toast.makeText(getApplicationContext(),"Kayıt Eklenirken Hata Oluştu..",Toast.LENGTH_LONG).show();
                            }else{
                                Toast.makeText(getApplicationContext(),"Kayıt Başarılı..",Toast.LENGTH_LONG).show();
                                kelimelis=db.TumKayitlar();
                            }
                            kelimee.setText("");
                            kelimeanlami.setText("");
                        }catch (Exception e){
                            Toast.makeText(getApplicationContext(),"Başarısız",Toast.LENGTH_LONG).show();
                        }
                        dialog.cancel();
                    }
                });
                btnkelimeleregit.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent i=new Intent(getApplicationContext(),KelimeleriGor.class);
                        startActivity(i);
                    }
                });

                return dialog;
            default:
                return super.onCreateDialog(id);

        }
    }


}
