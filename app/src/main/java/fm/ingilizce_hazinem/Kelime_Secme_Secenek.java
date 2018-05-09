package fm.ingilizce_hazinem;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.Toast;

/**
 * Created by user on 22.8.2017.
 */
public class Kelime_Secme_Secenek extends Fragment {

    RelativeLayout relativeLayout;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.kelime_secme_secenek,container,false);
        relativeLayout= (RelativeLayout) view.findViewById(R.id.relative);
        relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Kleime_Bulma_Secenek.kelimelis.size()>6) {
                    Intent in=new Intent(getActivity(),Kelime_Secme.class);
                    startActivity(in);
                    deneme.tiklanan=0;
                }else
                    Toast.makeText(getActivity(),"Test için Kelime sayısı yetersiz.",Toast.LENGTH_LONG).show();

            }
        });

        return view;
    }
}
