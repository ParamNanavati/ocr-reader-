package com.google.android.gms.samples.vision.ocrreader;

import android.app.FragmentTransaction;
import android.content.Intent;

import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {


        @Override
        public boolean onNavigationItemSelected( MenuItem item) {


            switch (item.getItemId()) {

                case R.id.navadd:
                    add obj = new add();
                    FragmentTransaction ft = getFragmentManager().beginTransaction();
                    ft.replace(R.id.frag,obj);
                    ft.commit();
                    return true;

                case R.id.navhome:
                    home obj1 = new home();
                    FragmentTransaction ft1 = getFragmentManager().beginTransaction();
                    ft1.replace(R.id.frag,obj1);
                    ft1.commit();
                    return true;


                case R.id.navinfo:
                    info obj2 = new info();
                    FragmentTransaction ft2 = getFragmentManager().beginTransaction();
                    ft2.replace(R.id.frag,obj2);
                    ft2.commit();
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

        home obj3 = new home();
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.replace(R.id.frag,obj3);
        ft.commit();

    }
}
