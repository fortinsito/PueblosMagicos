package com.example.asociacionfortin.pueblosmgicos;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

public class ActivityPrincipal extends AppCompatActivity {



    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction transaction = fragmentManager.beginTransaction();

            switch (item.getItemId()) {
                case R.id.navigation_notifications:
                    transaction.replace(R.id.content, new Notificaciones()).commit();
                    return true;
                case R.id.navigation_social:
                    transaction.replace(R.id.content, new Social()).commit();
                    return true;
                case R.id.navigation_descubrir:
                    transaction.replace(R.id.content, new Descubrir()).commit();
                    return true;
                case R.id.navigation_add_visita:
                    transaction.replace(R.id.content, new AgregarVisita()).commit();
                    return true;
                case R.id.navigation_perfil:
                    transaction.replace(R.id.content, new Perfil()).commit();
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.content, new Notificaciones()).commit();

    }

}
