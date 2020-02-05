package com.example.t06_masterdetail;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.widget.FrameLayout;

import com.example.t06_masterdetail.fragments.FragmentDetalle;
import com.example.t06_masterdetail.fragments.FragmentMaster;

public class MainActivity extends AppCompatActivity implements FragmentMaster.OnFragmentMsaterListener {

    FrameLayout frameMaster, frameDetail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        instacias();
        cargaInicial();
    }

    private void cargaInicial() {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.sitio_master, new FragmentMaster());
        ft.commit();

        if (frameDetail != null) {
            FragmentManager fm2 = getSupportFragmentManager();
            FragmentTransaction ft2 = fm2.beginTransaction();
            ft2.replace(R.id.sitio_detail, new FragmentDetalle());
            ft2.commit();
        }

    }

    private void instacias() {
        frameMaster = findViewById(R.id.sitio_master);
        frameDetail = findViewById(R.id.sitio_detail);
    }

    @Override
    public void onFragmentMasterSelected(String opcion) {
        if (frameDetail == null) {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.sitio_master, /*new FragmentDetalle()*/FragmentDetalle.newInstance(opcion));
            ft.addToBackStack(null);
            ft.commit();
        } else {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.sitio_detail, /*new FragmentDetalle()*/FragmentDetalle.newInstance(opcion));
            ft.commit();
        }
    }

}
