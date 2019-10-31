package com.example.entregable.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.widget.Toast;

import com.example.entregable.R;
import com.example.entregable.model.Disco;
import com.example.entregable.model.ContenedorDisco;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

public class MainActivity extends AppCompatActivity implements ListaFragment.ListaFragmentListener {
    private FragmentManager fragmentManager;
    private ListaFragment listaFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.fragmentManager = getSupportFragmentManager();
        this.listaFragment = new ListaFragment();

        FragmentTransaction fragmentTransaction = this.fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.activityMainContenedorDeFragment, listaFragment).commit();


    }

    private void leerJson() {
        ContenedorDisco contenedorDisco = null;

        try {
            AssetManager manager = this.getAssets();
            InputStream newsJson = null;
            newsJson = manager.open("news.json");
            BufferedReader bufferReaderIn = new BufferedReader(new InputStreamReader(newsJson));
            //Creamos un Objeto de la clase Gson que me permitirá sencillamente parsear el Json.
            Gson gson = new Gson();

            //Utilizando el objeto gson y el método fromJson, realizamos el parsing el archivo que tenemos en el bufferReaderIn y utilizando como “molde” la clase News.
            contenedorDisco = gson.fromJson(bufferReaderIn, ContenedorDisco.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        List<Disco> cancion = contenedorDisco.getDiscos();
        Disco disco = cancion.get(0);
        String nombre = disco.getNombreDisco();
        String tema = disco.getNombreArtista();

        Toast toast = Toast.makeText(this, tema, Toast.LENGTH_LONG);
        toast.show();
    }

    @Override
    public void informarSeleccionDesdeListaFragment(Disco disco) {
        Intent intent = new Intent(this, DetalleActivity.class);
        //creo el bundle
        Bundle bundle = new Bundle();
        //le doy el chat al bundle
        bundle.putSerializable(DetalleFragment.KEY_CELDA, disco);
        //asociamos el bundle al intent
        intent.putExtras(bundle);
        //iniciamos la actividad
        startActivity(intent);

    }
}
