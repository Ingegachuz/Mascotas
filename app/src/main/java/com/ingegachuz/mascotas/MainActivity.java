package com.ingegachuz.mascotas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Mascota>mascotas;
    private RecyclerView listaMascotas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // android.support.v7.widget.Toolbar miActionBar = (android.support.v7.widget.Toolbar) findViewById(R.id.miActionBar);
       // setSupportActionBar(miActionBar);

        listaMascotas = (RecyclerView) findViewById(R.id.rvMascotas);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listaMascotas.setLayoutManager(llm);
        inicializarListaMascotas();
        inicializarAdaptador();

    }
    public MascotaAdaptador adaptador;
    private void inicializarAdaptador(){
        adaptador = new MascotaAdaptador(mascotas,this);
        listaMascotas.setAdapter(adaptador);

    }

    public void inicializarListaMascotas(){
        mascotas = new ArrayList<Mascota>();

        mascotas.add(new Mascota(R.drawable.chihuahua_icon_225x158, "Chiquito", "4"));
        mascotas.add(new Mascota(R.drawable.dog_bows_icon, "Catty", "4"));
        mascotas.add(new Mascota(R.drawable.dog_icon2_225x158, "Orejas", "2"));
        mascotas.add(new Mascota(R.drawable.dog_labrador_icon, "Cachorro", "3"));
        mascotas.add(new Mascota(R.drawable.kitten_icon_225x158, "Kitten", "2"));

    }

    public void irSegundaActividad(View v){
        Intent segunda = new Intent(this, MascotasFavoritas.class);
        startActivity(segunda);
    }
}
