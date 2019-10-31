package com.example.entregable.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.entregable.R;
import com.example.entregable.model.Disco;

import java.util.List;

public class DiscoAdapter extends RecyclerView.Adapter {

    private List<Disco> discoList;
    private MusicaAdapterListener listener;

    public DiscoAdapter(List<Disco> discoList, MusicaAdapterListener DiscoAdapterListener) {

        this.discoList = discoList;
        this.listener = DiscoAdapterListener;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.celda_celda, parent, false);
        CeldaViewHolder celdaViewHolder = new CeldaViewHolder(view);
        return celdaViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        CeldaViewHolder celdaViewHolder = (CeldaViewHolder) holder;
        Disco disco = this.discoList.get(position);
        celdaViewHolder.bind(disco);

    }

    @Override
    public int getItemCount() {

        return this.discoList.size();
    }


    private class CeldaViewHolder extends RecyclerView.ViewHolder{
        private ImageView imageViewCelda;
        private TextView textViewNombreArtista;
        private TextView textViewNombreCancion;
        private Disco disco;

        public CeldaViewHolder(@NonNull View itemView) {
            super(itemView);
            this.imageViewCelda = itemView.findViewById(R.id.celdaChatImageView);
            this.textViewNombreArtista = itemView.findViewById(R.id.celdaTextViewNombreArtista);
            this.textViewNombreCancion = itemView.findViewById(R.id.celdaTextViewNombreCancion);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int adapterPosition = getAdapterPosition();
                    Disco disco = discoList.get(adapterPosition);
                    listener.informarSeleccion(disco);
                }
            });
        }


    public void bind(Disco unaDisco){
            this.imageViewCelda.setImageResource(unaDisco.getImagen());
            this.textViewNombreArtista.setText(unaDisco.getNombreArtista());
            this.textViewNombreCancion.setText(unaDisco.getNombreDisco());

        }
    }

    public interface MusicaAdapterListener{
        public void informarSeleccion(Disco disco);

    }
}
