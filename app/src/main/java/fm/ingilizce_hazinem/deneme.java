package fm.ingilizce_hazinem;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 24.8.2017.
 */
public class deneme {
    public static String gelenc;
    public static int tiklanan;
    int rastgele3, rastgele2, rastgele1, rastgele;
    public void rastgele_sayi_üret(Button a, Button b, Button c,Button kelime,Button son,int siradaki) {
        if(tiklanan==1) {
            rastgele = (int) (Math.random() * (Kelime_Bulma.kelimelis.size() - 1));
            rastgele1 = (int) (Math.random() * (Kelime_Bulma.kelimelis.size() - 1));
            rastgele2 = (int) (Math.random() * (Kelime_Bulma.kelimelis.size() - 1));
            rastgele3 = (int) (Math.random() * (Kelime_Bulma.kelimelis.size() - 1));
        }
        else if(tiklanan==0){
            rastgele = (int) (Math.random() * (Kelime_Secme.kelimelis.size() - 1));
            rastgele1 = (int) (Math.random() * (Kelime_Secme.kelimelis.size() - 1));
            rastgele2 = (int) (Math.random() * (Kelime_Secme.kelimelis.size() - 1));
            rastgele3 = (int) (Math.random() * (Kelime_Secme.kelimelis.size() - 1));
        }/* else if(tiklanan==2){
            rastgele = (int) (Math.random() * (Sesli_Anlami.kelimelis.size() - 1));
            rastgele1 = (int) (Math.random() * (Sesli_Anlami.kelimelis.size() - 1));
            rastgele2 = (int) (Math.random() * (Sesli_Anlami.kelimelis.size() - 1));
            rastgele3 = (int) (Math.random() * (Sesli_Anlami.kelimelis.size() - 1));
        }*/
        else if(tiklanan==3){
            rastgele = (int) (Math.random() * (Sesli_Kelime.kelimelis.size() - 1));
            rastgele1 = (int) (Math.random() * (Sesli_Kelime.kelimelis.size() - 1));
            rastgele2 = (int) (Math.random() * (Sesli_Kelime.kelimelis.size() - 1));
            rastgele3 = (int) (Math.random() * (Sesli_Kelime.kelimelis.size() - 1));
        }
       /* else if(tiklanan==4){
            rastgele = (int) (Math.random() * (Eslestirme.kelimelis.size() - 1));
            rastgele1 = (int) (Math.random() * (Eslestirme.kelimelis.size() - 1));
            rastgele2 = (int) (Math.random() * (Eslestirme.kelimelis.size() - 1));
            rastgele3 = (int) (Math.random() * (Eslestirme.kelimelis.size() - 1));
        }*/
        for (; ; ) {
            if (rastgele != rastgele1 && rastgele != rastgele2 && rastgele != rastgele3 && rastgele1 != rastgele2 && rastgele1 != rastgele3
                    && rastgele2 != rastgele3) {
                if(tiklanan==1) {
                    //int siradakisayi=Kelime_Bulma.kelimelis.size();
                    for(;;) {
                        int[] dizi = {siradaki, rastgele1, rastgele2, rastgele3};
                        int rastgelekelime1 = (int) (Math.random() * (dizi.length));
                        int rastgelekelime2 = (int) (Math.random() * (dizi.length));
                        int rastgelekelime3 = (int) (Math.random() * (dizi.length));
                        int rastgelekelime4 = (int) (Math.random() * (dizi.length));
                        if (rastgelekelime1 != rastgelekelime2 && rastgelekelime1 != rastgelekelime3 && rastgelekelime1 != rastgelekelime4 && rastgelekelime2 != rastgelekelime3 && rastgelekelime2 != rastgelekelime4 && rastgelekelime3 != rastgelekelime4) {
                            a.setText(Kelime_Bulma.kelimelis.get(dizi[rastgelekelime1]).getKelime());
                            b.setText(Kelime_Bulma.kelimelis.get(dizi[rastgelekelime2]).getKelime());
                            c.setText(Kelime_Bulma.kelimelis.get(dizi[rastgelekelime3]).getKelime());
                            son.setText(Kelime_Bulma.kelimelis.get(dizi[rastgelekelime4]).getKelime());
                            kelime.setText(Kelime_Bulma.kelimelis.get(dizi[0]).getAnlami());
                            gelenc = (Kelime_Bulma.kelimelis.get(dizi[0]).getKelime());
                            break;
                        } else {
                            rastgelekelime1 = (int) (Math.random() * (dizi.length));
                            rastgelekelime2 = (int) (Math.random() * (dizi.length));
                            rastgelekelime3 = (int) (Math.random() * (dizi.length));
                            rastgelekelime4 = (int) (Math.random() * (dizi.length));
                        }
                    }
                }else if(tiklanan==0){
                    for(;;) {
                        int[] dizi = {siradaki, rastgele1, rastgele2, rastgele3};
                        int rastgelekelime1 = (int) (Math.random() * (dizi.length));
                        int rastgelekelime2 = (int) (Math.random() * (dizi.length));
                        int rastgelekelime3 = (int) (Math.random() * (dizi.length));
                        int rastgelekelime4 = (int) (Math.random() * (dizi.length));
                        if (rastgelekelime1 != rastgelekelime2 && rastgelekelime1 != rastgelekelime3 && rastgelekelime1 != rastgelekelime4 && rastgelekelime2 != rastgelekelime3 && rastgelekelime2 != rastgelekelime4 && rastgelekelime3 != rastgelekelime4) {
                            a.setText(Kelime_Secme.kelimelis.get(dizi[rastgelekelime1]).getAnlami());
                            b.setText(Kelime_Secme.kelimelis.get(dizi[rastgelekelime2]).getAnlami());
                            c.setText(Kelime_Secme.kelimelis.get(dizi[rastgelekelime3]).getAnlami());
                            son.setText(Kelime_Secme.kelimelis.get(dizi[rastgelekelime4]).getAnlami());
                            kelime.setText(Kelime_Secme.kelimelis.get(dizi[0]).getKelime());
                            gelenc = (Kelime_Secme.kelimelis.get(dizi[0]).getAnlami());
                            break;
                        } else {
                            rastgelekelime1 = (int) (Math.random() * (dizi.length));
                            rastgelekelime2 = (int) (Math.random() * (dizi.length));
                            rastgelekelime3 = (int) (Math.random() * (dizi.length));
                            rastgelekelime4 = (int) (Math.random() * (dizi.length));
                        }
                    }
                }
               /* else if(tiklanan==2){
                    for(;;) {
                        int[] dizi = {siradaki, rastgele1, rastgele2, rastgele3};
                        int rastgelekelime1 = (int) (Math.random() * (dizi.length));
                        int rastgelekelime2 = (int) (Math.random() * (dizi.length));
                        int rastgelekelime3 = (int) (Math.random() * (dizi.length));
                        int rastgelekelime4 = (int) (Math.random() * (dizi.length));
                        if (rastgelekelime1 != rastgelekelime2 && rastgelekelime1 != rastgelekelime3 && rastgelekelime1 != rastgelekelime4 && rastgelekelime2 != rastgelekelime3 && rastgelekelime2 != rastgelekelime4 && rastgelekelime3 != rastgelekelime4) {
                            a.setText(Sesli_Anlami.kelimelis.get(dizi[rastgelekelime1]).getAnlami());
                            b.setText(Sesli_Anlami.kelimelis.get(dizi[rastgelekelime2]).getAnlami());
                            c.setText(Sesli_Anlami.kelimelis.get(dizi[rastgelekelime3]).getAnlami());
                            son.setText(Sesli_Anlami.kelimelis.get(dizi[rastgelekelime4]).getAnlami());
                            kelime.setText(Sesli_Anlami.kelimelis.get(dizi[0]).getKelime());
                            gelenc = (Sesli_Anlami.kelimelis.get(dizi[0]).getAnlami());
                            break;
                        } else {
                            rastgelekelime1 = (int) (Math.random() * (dizi.length));
                            rastgelekelime2 = (int) (Math.random() * (dizi.length));
                            rastgelekelime3 = (int) (Math.random() * (dizi.length));
                            rastgelekelime4 = (int) (Math.random() * (dizi.length));
                        }
                    }
                }*/
                if(tiklanan==3) {
                    for(;;) {
                        int[] dizi = {siradaki, rastgele1, rastgele2, rastgele3};
                        int rastgelekelime1 = (int) (Math.random() * (dizi.length));
                        int rastgelekelime2 = (int) (Math.random() * (dizi.length));
                        int rastgelekelime3 = (int) (Math.random() * (dizi.length));
                        int rastgelekelime4 = (int) (Math.random() * (dizi.length));
                        if (rastgelekelime1 != rastgelekelime2 && rastgelekelime1 != rastgelekelime3 && rastgelekelime1 != rastgelekelime4 && rastgelekelime2 != rastgelekelime3 && rastgelekelime2 != rastgelekelime4 && rastgelekelime3 != rastgelekelime4) {
                            a.setText(Sesli_Kelime.kelimelis.get(dizi[rastgelekelime1]).getKelime());
                            b.setText(Sesli_Kelime.kelimelis.get(dizi[rastgelekelime2]).getKelime());
                            c.setText(Sesli_Kelime.kelimelis.get(dizi[rastgelekelime3]).getKelime());
                            son.setText(Sesli_Kelime.kelimelis.get(dizi[rastgelekelime4]).getKelime());
                            kelime.setText(Sesli_Kelime.kelimelis.get(dizi[0]).getAnlami());
                            gelenc = (Sesli_Kelime.kelimelis.get(dizi[0]).getKelime());
                            break;
                        } else {
                            rastgelekelime1 = (int) (Math.random() * (dizi.length));
                            rastgelekelime2 = (int) (Math.random() * (dizi.length));
                            rastgelekelime3 = (int) (Math.random() * (dizi.length));
                            rastgelekelime4 = (int) (Math.random() * (dizi.length));
                        }
                    }
                }
              /*  if(tiklanan==4) {
                    for(;;) {
                        int[] dizi = {siradaki, rastgele1, rastgele2, rastgele3};
                        int rastgelekelime1 = (int) (Math.random() * (dizi.length));
                        int rastgelekelime2 = (int) (Math.random() * (dizi.length));
                        int rastgelekelime3 = (int) (Math.random() * (dizi.length));
                        int rastgelekelime4 = (int) (Math.random() * (dizi.length));
                        if (rastgelekelime1 != rastgelekelime2 && rastgelekelime1 != rastgelekelime3 && rastgelekelime1 != rastgelekelime4 && rastgelekelime2 != rastgelekelime3 && rastgelekelime2 != rastgelekelime4 && rastgelekelime3 != rastgelekelime4) {
                            a.setText(Eslestirme.kelimelis.get(dizi[rastgelekelime1]).getKelime());
                            b.setText(Eslestirme.kelimelis.get(dizi[rastgelekelime2]).getKelime());
                            c.setText(Eslestirme.kelimelis.get(dizi[rastgelekelime3]).getKelime());
                            son.setText(Eslestirme.kelimelis.get(dizi[rastgelekelime4]).getKelime());
                            kelime.setText(Eslestirme.kelimelis.get(dizi[0]).getAnlami());
                            gelenc = (Eslestirme.kelimelis.get(dizi[0]).getKelime());
                            break;
                        } else {
                            rastgelekelime1 = (int) (Math.random() * (dizi.length));
                            rastgelekelime2 = (int) (Math.random() * (dizi.length));
                            rastgelekelime3 = (int) (Math.random() * (dizi.length));
                            rastgelekelime4 = (int) (Math.random() * (dizi.length));
                        }
                    }
                }*/

                break;
            } else {
                if(tiklanan==1) {
                    rastgele = (int) (Math.random() * (Kelime_Bulma.kelimelis.size() - 1));
                    rastgele1 = (int) (Math.random() * (Kelime_Bulma.kelimelis.size() - 1));
                    rastgele2 = (int) (Math.random() * (Kelime_Bulma.kelimelis.size() - 1));
                    rastgele3 = (int) (Math.random() * (Kelime_Bulma.kelimelis.size() - 1));
                }
                else if(tiklanan==0){
                    rastgele = (int) (Math.random() * (Kelime_Secme.kelimelis.size() - 1));
                    rastgele1 = (int) (Math.random() * (Kelime_Secme.kelimelis.size() - 1));
                    rastgele2 = (int) (Math.random() * (Kelime_Secme.kelimelis.size() - 1));
                    rastgele3 = (int) (Math.random() * (Kelime_Secme.kelimelis.size() - 1));
                } /*else if(tiklanan==2){
                    rastgele = (int) (Math.random() * (Sesli_Anlami.kelimelis.size() - 1));
                    rastgele1 = (int) (Math.random() * (Sesli_Anlami.kelimelis.size() - 1));
                    rastgele2 = (int) (Math.random() * (Sesli_Anlami.kelimelis.size() - 1));
                    rastgele3 = (int) (Math.random() * (Sesli_Anlami.kelimelis.size() - 1));
                }*/
                else if(tiklanan==3){
                    rastgele = (int) (Math.random() * (Sesli_Kelime.kelimelis.size() - 1));
                    rastgele1 = (int) (Math.random() * (Sesli_Kelime.kelimelis.size() - 1));
                    rastgele2 = (int) (Math.random() * (Sesli_Kelime.kelimelis.size() - 1));
                    rastgele3 = (int) (Math.random() * (Sesli_Kelime.kelimelis.size() - 1));
                }
               /* else if(tiklanan==4){
                    rastgele = (int) (Math.random() * (Eslestirme.kelimelis.size() - 1));
                    rastgele1 = (int) (Math.random() * (Eslestirme.kelimelis.size() - 1));
                    rastgele2 = (int) (Math.random() * (Eslestirme.kelimelis.size() - 1));
                    rastgele3 = (int) (Math.random() * (Eslestirme.kelimelis.size() - 1));
                }*/
            }
        }
    }
}

