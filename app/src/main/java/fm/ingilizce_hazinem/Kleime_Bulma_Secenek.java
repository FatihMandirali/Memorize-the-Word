package fm.ingilizce_hazinem;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import io.github.douglasjunior.androidSimpleTooltip.SimpleTooltip;

/**
 * Created by user on 22.8.2017.
 */
public class Kleime_Bulma_Secenek extends android.support.v4.app.Fragment {
    RelativeLayout relativeLayout;
    public static List<Kelimeler_ModelSinifi> kelimelis;
    VeriTbani_ModelSinifi db;
    ImageView img;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.kelime_bulma_secenek,container,false);
        relativeLayout= (RelativeLayout) view.findViewById(R.id.relative);
        img= (ImageView) view.findViewById(R.id.imageView2);

        new SimpleTooltip.Builder(getActivity()).anchorView(img).text("Diğer Seçenekler İçin Lütfen Ekranı Kaydırın.").gravity(Gravity.TOP).animated(true).transparentOverlay(true).build().show();

        db=new VeriTbani_ModelSinifi(getActivity());
        kelimelis=new ArrayList<Kelimeler_ModelSinifi>();
        kelimelis=db.TumKayitlar();
        relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(kelimelis.size()>6) {
                    Intent in = new Intent(getActivity(), Kelime_Bulma.class);
                    startActivity(in);
                    deneme.tiklanan = 1;
                }else
                    Toast.makeText(getActivity(),"Test için Kelime sayısı yetersiz.",Toast.LENGTH_LONG).show();
            }
        });

        return view;
    }
}
