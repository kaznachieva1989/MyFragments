package com.example.myFragments;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity implements CalculatorFragment.IButtonFragment1, RecyclerviewFragment.IButtonFragment2 {
    CalculatorFragment calculatorFragment = CalculatorFragment.create(this);
    RecyclerviewFragment recyclerviewFragment = RecyclerviewFragment.create(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        changeFragment(R.id.container, calculatorFragment);
    }

    public void changeFragment(int container, Fragment fragment){
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    @Override
    public void openNextFragment(String s ) {
        Bundle bundle = new Bundle();
        bundle.putString("key", s);
        recyclerviewFragment.setArguments(bundle);
        changeFragment(R.id.container, recyclerviewFragment);
    }

//    @Override
//    public void addResult (String s) {
//        Log.e("ololo", "addResult: " + s);
//        recyclerviewFragment.showText(s);
//    }


    @Override
    public void returnToCalc() {
//        CalculatorFragment calculatorFragment = new CalculatorFragment();
//        FragmentManager manager = getSupportFragmentManager();
//        FragmentTransaction transaction = manager.beginTransaction();
//        transaction.replace(R.id.container, calculatorFragment);
//        transaction.addToBackStack(null);
//        transaction.commit();

        changeFragment(R.id.container,calculatorFragment);
//        getFragmentManager().popBackStackImmediate();
    }
}
