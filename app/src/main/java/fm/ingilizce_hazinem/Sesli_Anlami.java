package fm.ingilizce_hazinem;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.os.Vibrator;
import android.speech.tts.TextToSpeech;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 11.8.2017.
 */
public class Sesli_Anlami extends AppCompatActivity implements View.OnClickListener,TextToSpeech.OnInitListener {
        Button kelime,a,b,c,son,ss;
        public static List<Kelimeler_ModelSinifi> kelimelis;
        private TextToSpeech oku;
        Intent intent;
        deneme d;
        public static int dogru;
        public static int yanlis;
        private static final int aa=1;
        int sirasi=0;
        MediaPlayer ses;
        Vibrator titresim;
        VeriTbani_ModelSinifi db;
        String hangidil=null;
        @Override
        public void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.sesli_anlami);
                kelime= (Button) findViewById(R.id.btnkelime);
                a= (Button) findViewById(R.id.btna);
                b= (Button) findViewById(R.id.btnb);
                c= (Button) findViewById(R.id.btnc);
                son= (Button) findViewById(R.id.btnd);
                kelime.setOnClickListener(this);
                a.setOnClickListener(this);
                b.setOnClickListener(this);
                c.setOnClickListener(this);
                son.setOnClickListener(this);

                 db=new VeriTbani_ModelSinifi(getApplicationContext());
                kelimelis=new ArrayList<Kelimeler_ModelSinifi>();
                kelimelis=db.TumKayitlar();
                d=new deneme();
                d.rastgele_sayi_üret(a,b,c,kelime,son,1);
                ActionBar actionBar = getSupportActionBar();
                actionBar.setBackgroundDrawable(new ColorDrawable(getResources().getColor(android.R.color.holo_orange_light)));
                intent=new Intent();
                intent.setAction(TextToSpeech.Engine.ACTION_CHECK_TTS_DATA);
                startActivityForResult(intent,44);
                ses=MediaPlayer.create(getApplicationContext(),R.raw.ses);
                titresim= (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                Window window = getWindow();
                window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT_WATCH) {
                        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
                        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
                        window.setStatusBarColor(getResources().getColor(android.R.color.holo_orange_light));
                }
        }

        @Override
public void onClick(View v) {
        switch (v.getId()){
        case R.id.btnkelime:
        String text= (String) kelime.getText();
        if(text!=""&& text.length()>0){
        oku.speak(text,TextToSpeech.QUEUE_ADD,null);

        }else elsee();
        break;
        case R.id.btna:
        if(deneme.gelenc==a.getText()) {
       iff();
        }else elsee();
        break;
        case R.id.btnb:

        if(deneme.gelenc==b.getText()) {
                iff();
        }else elsee();
        break;
        case R.id.btnc:
        if(deneme.gelenc==c.getText()) {
                iff();
        }else elsee();
        break;
        case R.id.btnd:
        if(deneme.gelenc==son.getText()) {
                iff();
        }else elsee();
        break;
        }
        }

@Override
public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode==44){
        if(resultCode==TextToSpeech.Engine.CHECK_VOICE_DATA_PASS){
        oku=new TextToSpeech(getApplicationContext(), (TextToSpeech.OnInitListener)this);
        }else{
        Intent intent2=new Intent();
        intent2.setAction(TextToSpeech.Engine.ACTION_CHECK_TTS_DATA);
        startActivity(intent2);
        }
        }
        }
        private void iff(){
                ses.start();
                dogru++;
                sorusonu();
                sirasi++;
                d.rastgele_sayi_üret(a,b,c,kelime,son,sirasi);
        }

        protected Dialog onCreateDialog(int id){
                switch (id){
                        case aa:
                                final Dialog dialog=new Dialog(this);
                                dialog.setContentView(R.layout.test_sonuncu_custom_dialog);
                                dialog.setCancelable(false);
                                final TextView txtdogru= (TextView) dialog.findViewById(R.id.txtdogrusorusayisi);
                                final TextView txtyanlis= (TextView) dialog.findViewById(R.id.txtyanlissorusayisi);
                                final Button btntestibitir= (Button) dialog.findViewById(R.id.btntestibitir);
                                final Button btntestitekrarla= (Button) dialog.findViewById(R.id.btntestitekrarla);
                                txtdogru.setText(dogru+"");
                                txtyanlis.setText(yanlis+"");

                                btntestitekrarla.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                                sirasi=0;
                                                dogru=0;
                                                yanlis=0;
                                                Intent i=new Intent(getApplicationContext(),Sesli_Anlami.class);
                                                startActivity(i);
                                                dialog.cancel();
                                        }
                                });
                                btntestibitir.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                                sirasi=0;
                                                dogru=0;
                                                yanlis=0;
                                                Intent i=new Intent(getApplicationContext(),Anasayfa.class);
                                                startActivity(i);
                                                dialog.cancel();
                                        }
                                });
                                return  dialog;
                        default:
                                return super.onCreateDialog(id);

                }
        }
        private void elsee(){
                titresim.vibrate(250);
                yanlis++;
                sorusonu();
                sirasi++;
                d.rastgele_sayi_üret(a,b,c,kelime,son,sirasi);
        }
        private void sorusonu(){
                if(sirasi==kelimelis.size()-2){

                        showDialog(aa);

                }
        }

@Override
public void onInit(int status) {

        }
        @Override
        public boolean onCreateOptionsMenu(Menu menu) {
                getMenuInflater().inflate(R.menu.gosterilecek_dili_sec,menu);
                return true;
        }
        //--------------------------------------------------------------
        @Override
        public boolean onOptionsItemSelected(MenuItem item) {
                if(item.getItemId()==R.id.ingilizce){
                        sirasi=0;
                        hangidil="İngilizce";
                        kelimelis=db.TumKayitlar(hangidil);
                        secilikelime();


                        return  true;
                }else if(item.getItemId()==R.id.almanca){
                        sirasi=0;
                        hangidil="Almanca";
                        kelimelis=db.TumKayitlar(hangidil);
                        secilikelime();
                        return true;
                }else if(item.getItemId()==R.id.fransızca){
                        sirasi=0;
                        hangidil="Fransızca";
                        kelimelis=db.TumKayitlar(hangidil);
                        secilikelime();
                        return true;
                }
                else if(item.getItemId()==R.id.italyanca) {
                        sirasi=0;
                        hangidil="İtalyanca";
                        kelimelis=db.TumKayitlar(hangidil);
                        secilikelime();
                        return true;
                }else if(item.getItemId()==R.id.ispanyolca){
                        sirasi=0;
                        hangidil="İspanyolca";
                        kelimelis=db.TumKayitlar(hangidil);
                        secilikelime();
                        return true;
                }
                else if(item.getItemId()==R.id.portekizce){
                        sirasi=0;
                        hangidil="Portekizce";
                        kelimelis=db.TumKayitlar(hangidil);
                        secilikelime();
                        return true;
                }
                else if(item.getItemId()==R.id.tumu){
                        sirasi=0;
                        hangidil=null;
                        kelimelis=db.TumKayitlar();
                        secilikelime();
                        return true;
                }

                return super.onOptionsItemSelected(item);

        }//tekrarlandıgında karışık dil geliyo..
        private void secilikelime(){
                if(kelimelis.size()<6){
                        Toast.makeText(getApplicationContext(),"Seçili dilde yeteri kadar kelime yok.Seçilen dilde en az 6 adet  kelime olması gerekmektedir.",Toast.LENGTH_SHORT).show();
                        sirasi=0;
                        kelimelis=db.TumKayitlar(null);
                        Toast.makeText(getApplicationContext(),"Başka dil seçmediğiniz sürece kelimeler karışık olarak gelecektir.",Toast.LENGTH_SHORT).show();
                }
        }
}
