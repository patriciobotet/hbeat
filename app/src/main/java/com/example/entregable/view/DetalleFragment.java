package com.example.entregable.view;

import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.entregable.R;
import com.example.entregable.model.Disco;

public class DetalleFragment extends Fragment {

    public static final String KEY_CELDA = "celda";
    private Button play_pausa;
    private MediaPlayer mp;




    public DetalleFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_detalle, container, false);
        ImageView imageView = view.findViewById(R.id.fragmentDetalleImageView);
        TextView textViewNombre = view.findViewById(R.id.fragmentDetalleTextViewNombre);



        play_pausa = view.findViewById(R.id.btn_play_pause);
        mp = MediaPlayer.create(this.getContext(),R.raw.cancion);//.create(this,R.raw.fail);
        play_pausa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mp.isPlaying()){
                    mp.pause();
                    play_pausa.setBackgroundResource(R.drawable.ic_play_circle_outline_black_24dp);
                } else {
                    mp.start();
                    play_pausa.setBackgroundResource(R.drawable.ic_pause_circle_outline_black_24dp);
                }
            }
        });

        mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                play_pausa.setBackgroundResource(R.drawable.ic_play_circle_outline_black_24dp);
            }
        });

        //recuperamos el bundle
        Bundle bundle = getArguments();

        //recuperamos el chat previamente serializado (putSerializable)
        Disco disco = (Disco) bundle.getSerializable(KEY_CELDA);

        //seteamos los valores correspondientes
        imageView.setImageResource(disco.getImagen());
        textViewNombre.setText(disco.getNombreDisco());




        return view;




    }

}
