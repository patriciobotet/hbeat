package com.example.entregable.view;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.entregable.R;
import com.example.entregable.controller.DiscoController;
import com.example.entregable.model.Disco;

import java.util.List;

public class ListaFragment extends Fragment implements DiscoAdapter.MusicaAdapterListener{

    private RecyclerView recyclerView;
    private ListaFragmentListener listaFragmentListener;


    public ListaFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.listaFragmentListener = (ListaFragmentListener) context;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){
        View view =  inflater.inflate(R.layout.fragment_lista, container, false);
        this.recyclerView = view.findViewById(R.id.recyclerViewDiscoHorizontal);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.getContext(), RecyclerView.HORIZONTAL, false);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this.getContext(),2,RecyclerView.HORIZONTAL,false);
        //RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL, false);

        this.recyclerView.setLayoutManager(gridLayoutManager);

        DiscoController discoController = new DiscoController();
        List<Disco> discoList =  discoController.getCeldas();
        DiscoAdapter adapter = new DiscoAdapter(discoList,this);
        this.recyclerView.setAdapter(adapter);
        //this.recyclerView.setHasFixedSize(true);
        return view;
    }

    @Override
    public void informarSeleccion(Disco disco) {
    listaFragmentListener.informarSeleccionDesdeListaFragment(disco);
    }



    public interface ListaFragmentListener{
        public void informarSeleccionDesdeListaFragment(Disco disco);
    }
}
