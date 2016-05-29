package com.ingegachuz.mascotas;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Inge on 29/05/2016.
 */
public class MascotaAdaptador extends RecyclerView.Adapter<MascotaAdaptador.MascotaViewHolder> {
    ArrayList<Mascota> mascotas;
    Activity activity;

    public MascotaAdaptador(ArrayList<Mascota> mascotas, Activity activity){
        this.mascotas = mascotas;
        this.activity = activity;
    }

    @Override
    public MascotaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_mascota, parent, false);
        return new MascotaViewHolder(v);

    }

    @Override
    public void onBindViewHolder(final MascotaViewHolder mascotaViewHolder, int position) {
        final Mascota mascota = mascotas.get(position);
        mascotaViewHolder.imgFoto.setImageResource(mascota.getFoto());
        mascotaViewHolder.tvNombrecv.setText(mascota.getNombre());
        mascotaViewHolder.tvCantidad.setText(mascota.getCantidad());

       mascotaViewHolder.imgFoto.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Toast.makeText(activity, mascota.getNombre(), Toast.LENGTH_SHORT).show();
               Intent intent = new Intent(activity, MascotasFavoritas.class);
               intent.putExtra("nombre", mascota.getNombre());
               intent.putExtra("cantidad", mascota.getCantidad());
               activity.startActivity(intent);
           }
       });

        mascotaViewHolder.btnLike.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Toast.makeText(activity, "Diste Like a" + mascota.getNombre(), Toast.LENGTH_SHORT).show();

            }
        });

    }



    @Override
    public int getItemCount() {
        return mascotas.size();
    }




    public static class MascotaViewHolder extends RecyclerView.ViewHolder {

        private ImageView imgFoto;
        private TextView tvNombrecv;
        private ImageButton btnLike;
        private TextView tvCantidad;

        public MascotaViewHolder(View itemView) {
            super(itemView);
            imgFoto      = (ImageView) itemView.findViewById(R.id.imgFoto);
            tvNombrecv   = (TextView) itemView.findViewById(R.id.tvNombreCV);
            tvCantidad   = (TextView)itemView.findViewById((R.id.tvCantidad));
            btnLike      = (ImageButton)itemView.findViewById(R.id.btnLike);
        }
    }
}
