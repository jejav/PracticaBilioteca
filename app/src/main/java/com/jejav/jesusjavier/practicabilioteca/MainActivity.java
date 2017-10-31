package com.jejav.jesusjavier.practicabilioteca;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    FragmentManager fm;
    FragmentTransaction ft;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    ft=fm.beginTransaction();
                    FragmentPrincipal fragment =new FragmentPrincipal();
                    ft.replace(R.id.content,fragment).commit();
                    return true;
                case R.id.lista:
                    ft=fm.beginTransaction();
                    Fragment_Lista fragment1 =new Fragment_Lista();
                    ft.replace(R.id.content,fragment1).commit();

                    return true;

            }
            return false;
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        fm=getSupportFragmentManager();
        ft=fm.beginTransaction();

        FragmentPrincipal fragment =new FragmentPrincipal();
        ft.replace(R.id.content,fragment).commit();
    }

}
