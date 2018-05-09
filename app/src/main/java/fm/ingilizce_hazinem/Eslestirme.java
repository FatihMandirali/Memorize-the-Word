package fm.ingilizce_hazinem;

import android.app.Dialog;
import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.os.Vibrator;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 16.8.2017.
 */
public class Eslestirme extends AppCompatActivity {
    Button btncevap,btna,btnb,btnc,btnd;
    LinearLayout linearLayout;
    float xx,yy;
    public static List<Kelimeler_ModelSinifi> kelimelis;
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
        setContentView(R.layout.eslestirme);
        btncevap= (Button) findViewById(R.id.btnkelime);
        btncevap.setOnTouchListener(handle);
        btna= (Button) findViewById(R.id.btna);
        btnb= (Button) findViewById(R.id.btnb);
        btnc= (Button) findViewById(R.id.btnc);
        btnd= (Button) findViewById(R.id.btnd);
        linearLayout= (LinearLayout) findViewById(R.id.lineerbutonlar);

         db=new VeriTbani_ModelSinifi(getApplicationContext());
        kelimelis=new ArrayList<Kelimeler_ModelSinifi>();
        kelimelis=db.TumKayitlar();
        d=new deneme();
        d.rastgele_sayi_üret(btna,btnb,btnc,btncevap,btnd,1);

        Window window = getWindow();
        window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT_WATCH) {
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(getResources().getColor(android.R.color.holo_orange_light));
        }
        ActionBar actionBar = getSupportActionBar();
        actionBar.setBackgroundDrawable(new ColorDrawable(getResources().getColor(android.R.color.holo_orange_light)));
        ses=MediaPlayer.create(getApplicationContext(),R.raw.ses);
        titresim= (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
    }

    private  View.OnTouchListener handle=new View.OnTouchListener() {
        @Override
        public boolean onTouch(View v, MotionEvent event) {
            xx = event.getRawX();
            yy = event.getRawY();
            switch (event.getAction()) {

                case MotionEvent.ACTION_MOVE:
                    btncevap.setX(xx);
                    btncevap.setY(yy);

                    if(btncevap.getY()-linearLayout.getY()<20 ) {
                    btna.setBackgroundColor(Color.BLUE);
                    }else{
                    btna.setBackgroundColor(Color.RED);
                    }
                    if(btncevap.getY()-linearLayout.getY()<120 && btncevap.getY()-linearLayout.getY()>100  ) {
                        btnb.setBackgroundColor(Color.BLUE);
                    }else{
                        btnb.setBackgroundColor(Color.RED);
                    }
                    if(btncevap.getY()-linearLayout.getY()<220 && btncevap.getY()-linearLayout.getY()>200  ) {
                        btnc.setBackgroundColor(Color.BLUE);
                    }else{
                        btnc.setBackgroundColor(Color.RED);
                    }
                    if(btncevap.getY()-linearLayout.getY()<320 && btncevap.getY()-linearLayout.getY()>300  ) {
                        btnd.setBackgroundColor(Color.BLUE);
                    }else{
                        btnd.setBackgroundColor(Color.RED);
                    }

                    break;
                case MotionEvent.ACTION_UP://btncevap.getX()-linearLayout.getX()<10 &&
                    if( btncevap.getY()-linearLayout.getY()<20 ) {
                        if(deneme.gelenc==btna.getText()) {
                           iff();

                        }else elsee();
                }
                    if( btncevap.getY()-linearLayout.getY()<120 && btncevap.getY()-linearLayout.getY()>100 ) {

                        if(deneme.gelenc==btnb.getText()) {
                            iff();

                        }else elsee();
                }
                    if( btncevap.getY()-linearLayout.getY()<220 && btncevap.getY()-linearLayout.getY()>200 ) {
                        if(deneme.gelenc==btnc.getText()) {
                            iff();
                        }else elsee();
                    }
                    if( btncevap.getY()-linearLayout.getY()<320 && btncevap.getY()-linearLayout.getY()>300 ) {

                        if(deneme.gelenc==btnd.getText()) {
                            iff();

                        }else elsee();
                    }

                    break;
            }
            return true;
        }
    };
    private void iff(){
        ses.start();
        dogru++;
        sorusonu();
        sirasi++;
        d.rastgele_sayi_üret(btna,btnb,btnc,btncevap,btnd,sirasi);
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
                        Intent i=new Intent(getApplicationContext(),Eslestirme.class);
                        startActivity(i);
                        dialog.cancel();
                    }
                });
                btntestibitir.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
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
        d.rastgele_sayi_üret(btna,btnb,btnc,btncevap,btnd,sirasi);
    }
    private void sorusonu(){
        if(sirasi==kelimelis.size()-2){

            showDialog(aa);

        }
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
