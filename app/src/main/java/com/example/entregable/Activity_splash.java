package com.example.entregable;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.entregable.view.MainActivity;

public class Activity_splash extends AppCompatActivity {
    private final int DURACION_SPLASH = 2000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        new Handler().postDelayed(new Runnable(){
            public void run(){
                // Cuando pasen los 3 segundos, pasamos a la actividad principal de la aplicación
                Intent intent = new Intent(Activity_splash.this, MainActivity.class);
                startActivity(intent);
                finish();
            };
        }, DURACION_SPLASH);
    }
}


