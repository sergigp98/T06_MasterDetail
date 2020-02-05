package com.example.t06_masterdetail.fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.t06_masterdetail.R;

public class FragmentMaster extends Fragment {

    private ListView lista;
    private  OnFragmentMsaterListener listener;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        try {
            listener = (OnFragmentMsaterListener) context;
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_master, container, false);
        lista = v.findViewById(R.id.lista_mater);
        final String[] opciones = {"opcion 1", "opcion 2", "opcion 3", "opcion 4", "opcion 5"};
        ArrayAdapter<String> adaptadorLista = new ArrayAdapter(getContext(), android.R.layout.simple_list_item_1, opciones);
        lista.setAdapter(adaptadorLista);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                listener.onFragmentMasterSelected(opciones[position]);
            }
        });
        return v;
    }

    public interface OnFragmentMsaterListener {
        void onFragmentMasterSelected(String opcion);
    }
}
