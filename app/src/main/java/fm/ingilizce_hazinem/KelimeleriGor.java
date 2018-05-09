package fm.ingilizce_hazinem;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v4.app.NavUtils;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.ActionMode;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 4.8.2017.
 */
public class KelimeleriGor extends AppCompatActivity {
        //ListView kelimeler;
        List<String> vVeriler;
        TableLayout tablo;
    public static List<Kelimeler_ModelSinifi> kelimelis;
      //  TextView tv;
        ActionMode actionMode;
        long idisi;
        Dialog dialog;
    int tiklanan_dil_id=2;
    String hangidil=null;

   public static int toplamkelimesayisi;
   private static final int sayi =1;

    String gelendil,gelenkelime,gelenanlam;
    ImageView tv_tikla;
    Button tv_Anlami;



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.kelimeleri_gor);
      //  kelimeler= (ListView) findViewById(R.id.listView);
       // tv= (TextView) findViewById(R.id.tv);
        tablo= (TableLayout) findViewById(R.id.tablo);

        try {
            gel();
        }catch (Exception e){
            Toast.makeText(getApplicationContext(),"Kayıt Bulunamadı..",Toast.LENGTH_LONG).show();
        }

        Window window = getWindow();
        window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT_WATCH) {
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(getResources().getColor(android.R.color.holo_orange_light));
        }

        ActionBar actionBar = getSupportActionBar();
        actionBar.setBackgroundDrawable(new ColorDrawable(getResources().getColor(android.R.color.holo_orange_light)));


    }
    public void gel(){
        tablo.removeAllViews();
        VeriTbani_ModelSinifi  db=new VeriTbani_ModelSinifi(getApplicationContext());
        List<Kelimeler_ModelSinifi> kelimelis=new ArrayList<Kelimeler_ModelSinifi>();
        kelimelis=db.TumKayitlar(hangidil);
        toplamkelimesayisi=kelimelis.size();

        final TableRow satir1=new TableRow(KelimeleriGor.this);
        satir1.setGravity(Gravity.CENTER);
        

        for(final Kelimeler_ModelSinifi kelime:kelimelis){
           final TableRow satir=new TableRow(KelimeleriGor.this);
            satir.setGravity(Gravity.CENTER);

             tv_tikla=new ImageView(KelimeleriGor.this);
            tv_tikla.setImageResource(R.drawable.uzuntik);
            tv_tikla.setPadding(2,2,2,2);

            Button tv_Dil=new Button(KelimeleriGor.this);
            tv_Dil.setTextColor(Color.BLACK);
            tv_Dil.setPadding(2,2,2,2);
            tv_Dil.setText(kelime.getDil());


            Button tv_Kelime=new Button(KelimeleriGor.this);
            tv_Kelime.setPadding(2,2,2,2);
            tv_Kelime.setTextColor(Color.BLACK);
            tv_Kelime.setTextColor(Color.WHITE);
            tv_Kelime.setText(kelime.getKelime());



             tv_Anlami=new Button(KelimeleriGor.this);
            tv_Anlami.setPadding(2,2,2,2);
            tv_Anlami.setTextColor(Color.BLACK);
            tv_Anlami.setTextColor(Color.WHITE);
            tv_Anlami.setText(kelime.getAnlami());

            satir.addView(tv_tikla);
            satir.addView(tv_Dil);
            satir.addView(tv_Kelime);
            satir.addView(tv_Anlami);
            tablo.addView(satir);

            tv_tikla.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {

                     idisi=kelime.getId();
                    //  gelendil=kelime.getDil();
                    gelenanlam=tv_Anlami.getText().toString();
                    //  gelenkelime=kelime.getKelime();
                    // satir.setBackgroundColor(Color.LTGRAY);

                    if(actionMode!=null){
                        return  false;
                    }
                    MyActionModeCallback callback=new MyActionModeCallback();
                    actionMode=startActionMode(callback);
                    v.setSelected(true);
                    return true;

                }
            });



        }

    }
     class MyActionModeCallback implements ActionMode.Callback{


        @Override
        public boolean onCreateActionMode(ActionMode mode, Menu menu) {
            mode.getMenuInflater().inflate(R.menu.context_menu,menu);
            return true;
        }

        @Override
        public boolean onPrepareActionMode(ActionMode mode, Menu menu) {


            return false;
            //action mode başlatılmadan önce yapılacak işlemler burda tanımlanır.
        }

        @Override
        public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
            if(item.getItemId()==R.id.sil)
            {
                    VeriTbani_ModelSinifi db=new VeriTbani_ModelSinifi(getApplicationContext());
                    db.Sil(idisi);
                    gel();
                    mode.finish();
            }/*else if(item.getItemId()==R.id.guncelle)

            {
            //    showDialog(sayi);
                mode.finish();
            }*/

            return true;
        }

        @Override
        public void onDestroyActionMode(ActionMode mode) {
            actionMode=null;
        }
    }



  /*  @Override
    protected Dialog onCreateDialog(final int id) {
        switch (id){
            case sayi:
                Toast.makeText(getApplicationContext(),gelendil,Toast.LENGTH_LONG).show();
                if(gelendil=="İngilizce"){
                    tiklanan_dil_id=0;
                    Toast.makeText(getApplicationContext(),"if içi",Toast.LENGTH_LONG).show();
                }else if(gelendil=="Almanca"){
                    tiklanan_dil_id=1;
                    Toast.makeText(getApplicationContext(),"if içi",Toast.LENGTH_LONG).show();
                }else if(gelendil=="Fransızca"){
                    tiklanan_dil_id=2;
                    Toast.makeText(getApplicationContext(),"if içi",Toast.LENGTH_LONG).show();
                }else if(gelendil=="İtalyanca"){
                    tiklanan_dil_id=3;
                    Toast.makeText(getApplicationContext(),"if içi",Toast.LENGTH_LONG).show();
                } else if(gelendil=="İspanyolca"){
                    tiklanan_dil_id=4;
                    Toast.makeText(getApplicationContext(),"if içi",Toast.LENGTH_LONG).show();
                }else if(gelendil=="Portekizce"){
                    tiklanan_dil_id=5;
                    Toast.makeText(getApplicationContext(),"if içi",Toast.LENGTH_LONG).show();
                }else
                    Toast.makeText(getApplicationContext(),"if içi degil",Toast.LENGTH_LONG).show();
                Toast.makeText(getApplicationContext(),tiklanan_dil_id+"",Toast.LENGTH_LONG).show();*/
              /*  dialog=new Dialog(this);
                dialog.setContentView(R.layout.kelimeler_icerigi_custom);
                Button btn= (Button) dialog.findViewById(R.id.btniceriktendegisiklikkaydet);
               // final Spinner editdil= (Spinner) dialog.findViewById(R.id.spinner2);
                final EditText editkelime= (EditText) dialog.findViewById(R.id.editicerikkelime);
                final EditText editanlam= (EditText) dialog.findViewById(R.id.editicerikanlam);
              //  ArrayAdapter adapter = ArrayAdapter.createFromResource(this,R.array.Diller,android.R.layout.simple_spinner_item);
              //  adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
              //  editdil.setAdapter(adapter);

              //  editdil.setSelection(tiklanan_dil_id);//hata var ilk tıkladığımda seçtiğim dilin idsi geliyor hep.
                editanlam.setText(gelenanlam+"");//hata var ilk tıkladığımda seçtiğim dilin idsi geliyor hep.
                editkelime.setText(gelenkelime+"");//hata var ilk tıkladığımda seçtiğim dilin idsi geliyor hep.
                //SORUN DİALOG PENCERESİNDE GERİ YAPINCA ANA SAYFAYA DÖNMEDEN AYNI KALIYO ANASAYFAYA GİDİP TEKRAR GİRİNCE DEĞİŞİYOR.

                btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                            VeriTbani_ModelSinifi db=new VeriTbani_ModelSinifi(getApplicationContext());
                             db.Guncelle(idisi,editkelime.getText().toString(),editanlam.getText().toString());
                             gel();

                                dialog.dismiss();

                    }
                });
               return dialog;
            default:
                return super.onCreateDialog(id);


        }
    }*/
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.gosterilecek_dili_sec,menu);
        return true;
    }
    //--------------------------------------------------------------
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()==R.id.ingilizce){
            hangidil="İngilizce";
            gel();
            return  true;
        }else if(item.getItemId()==R.id.almanca){
            hangidil="Almanca";
            gel();
            return true;
        }else if(item.getItemId()==R.id.fransızca){
            hangidil="Fransızca";
            gel();
            return true;
        }
        else if(item.getItemId()==R.id.italyanca) {
            hangidil="İtalyanca";
            gel();
            return true;
        }else if(item.getItemId()==R.id.ispanyolca){
            hangidil="İspanyolca";
            gel();
            return true;
        }
        else if(item.getItemId()==R.id.portekizce){

            hangidil="Portekizce";
            gel();

            return true;
        }
        else if(item.getItemId()==R.id.tumu){
            hangidil=null;
            gel();
            return true;
        }
        else if(item.getItemId()==R.id.toplam){
            Toast.makeText(getApplicationContext(),"Toplam Kelime Sayısı : "+toplamkelimesayisi,Toast.LENGTH_LONG).show();
            return true;
        }
        return super.onOptionsItemSelected(item);

    }
}

