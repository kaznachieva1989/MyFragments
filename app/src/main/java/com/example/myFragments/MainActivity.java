package com.example.myFragments;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity implements CalculatorFragment.IButtonFragment1, RecyclerviewFragment.IButtonFragment2 {
    CalculatorFragment calculatorFragment;
    RecyclerviewFragment recyclerviewFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        calculatorFragment = new CalculatorFragment();
        calculatorFragment.listener = this;

        recyclerviewFragment = new RecyclerviewFragment();
        recyclerviewFragment.listener2 = this;
        changeFragment(R.id.container, calculatorFragment);
    }

    public void changeFragment(int container, Fragment fragment) {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(container, fragment);
        transaction.commit();

    }

    @Override
    public void openNextFragment(String s) {
        Bundle bundle = new Bundle();
        bundle.putString("key", s);
        recyclerviewFragment.setArguments(bundle);
        changeFragment(R.id.container, recyclerviewFragment);
    }

    @Override
    public void returnToCalc() {
        changeFragment(R.id.container, calculatorFragment);
    }
}
