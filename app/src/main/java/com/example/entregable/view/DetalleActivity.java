package com.example.entregable.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.Button;

import com.example.entregable.R;

public class DetalleActivity extends AppCompatActivity {
    private FragmentManager fragmentManager;
    private DetalleFragment detalleFragment;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle);



        this.fragmentManager = getSupportFragmentManager();
        this.detalleFragment = new DetalleFragment();
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        detalleFragment.setArguments(bundle);
        FragmentTransaction fragmentTransaction = this.fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.activityDetalleContenedorFragment,detalleFragment).commit();






    }
}
