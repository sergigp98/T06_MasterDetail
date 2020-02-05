package com.example.t06_masterdetail.fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.t06_masterdetail.R;

public class FragmentDetalle extends Fragment {

    private TextView texto;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_detail, container, false);
        texto = v.findViewById(R.id.opcion);
        return v;

    }

    final static  String KEY_PARAM1 =  "argumento_uno";
    private String dato;

    public static FragmentDetalle newInstance(String dato) {

        FragmentDetalle fragmentDetalle = new FragmentDetalle();
        //Con los argumentos acompaño al fragment vaya donde vaya
        Bundle bundle = new Bundle();
        bundle.putString(KEY_PARAM1,dato);
        fragmentDetalle.setArguments(bundle);
        return  fragmentDetalle;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if(this.getArguments() != null){//Para que al iniciar no me de un nulo los argumentos
            this.dato = this.getArguments().getString(KEY_PARAM1);
        }

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        texto.setText(dato);
    }
}
