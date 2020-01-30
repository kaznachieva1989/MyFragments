package com.example.myFragments;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class CalculatorFragment extends Fragment {
    public interface IButtonFragment1 {
        void openNextFragment(String s);
        //void addResult(String s);
    }

    IButtonFragment1 listener;

    public static CalculatorFragment create(IButtonFragment1 listener){
        CalculatorFragment calculatorFragment = new CalculatorFragment();
        calculatorFragment.listener = listener;
        return  calculatorFragment;
    }



    private boolean isOpPressed = false;
    private double firstNumber = 0;
    private int secondNumberIndex = 0;
    private char currentOp;

    public CalculatorFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_calculator, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        final TextView calculatorScreen = view.findViewById(R.id.calculatorScreen);
        final Button n0 = view.findViewById(R.id.n0);
        final Button n1 = view.findViewById(R.id.n1);
        final Button n2 = view.findViewById(R.id.n2);
        final Button n3 = view.findViewById(R.id.n3);
        final Button n4 = view.findViewById(R.id.n4);
        final Button n5 = view.findViewById(R.id.n5);
        final Button n6 = view.findViewById(R.id.n6);
        final Button n7 = view.findViewById(R.id.n7);
        final Button n8 = view.findViewById(R.id.n8);
        final Button n9 = view.findViewById(R.id.n9);
        final Button dot = view.findViewById(R.id.dot);
        final Button equals = view.findViewById(R.id.equals);
        final Button addition = view.findViewById(R.id.addition);
        final Button subtraction = view.findViewById(R.id.subtraction);
        final Button multiplication = view.findViewById(R.id.multiplication);
        final Button division = view.findViewById(R.id.division);

        final View.OnClickListener calculatorListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final int id = v.getId();
                switch (id) {
                    case R.id.n0:
                        calculatorScreen.append("0");
                        break;
                    case R.id.n1:
                        calculatorScreen.append("1");
                        break;
                    case R.id.n2:
                        calculatorScreen.append("2");
                        break;
                    case R.id.n3:
                        calculatorScreen.append("3");
                        break;
                    case R.id.n4:
                        calculatorScreen.append("4");
                        break;
                    case R.id.n5:
                        calculatorScreen.append("5");
                        break;
                    case R.id.n6:
                        calculatorScreen.append("6");
                        break;
                    case R.id.n7:
                        calculatorScreen.append("7");
                        break;
                    case R.id.n8:
                        calculatorScreen.append("8");
                        break;
                    case R.id.n9:
                        calculatorScreen.append("9");
                        break;
                    case R.id.dot:
                        calculatorScreen.append(".");
                        break;
                    case R.id.equals:
                        if (isOpPressed) {
                            String screenContent = calculatorScreen.getText().toString();
                            String secondNumberString = screenContent.substring(secondNumberIndex, screenContent.length());
                            double secondNumber = Double.parseDouble(secondNumberString);
                            if (currentOp == '+') {
                                secondNumber += firstNumber;
                                calculatorScreen.setText(String.valueOf(secondNumber));
                                String result = calculatorScreen.getText().toString();
                                listener.openNextFragment(result);
                               // listener.addResult(result);
                            }
                            if (currentOp == '-') {
                                firstNumber -= secondNumber;
                                calculatorScreen.setText(String.valueOf(firstNumber));
                                String result = calculatorScreen.getText().toString();
                                listener.openNextFragment(result);
                            }
                            if (currentOp == '*') {
                                secondNumber *= firstNumber;
                                calculatorScreen.setText(String.valueOf(secondNumber));
                                String result = calculatorScreen.getText().toString();
                                listener.openNextFragment(result);
                            }
                            if (currentOp == '/') {
                                firstNumber /= secondNumber;
                                calculatorScreen.setText(String.valueOf(firstNumber));
                                String result = calculatorScreen.getText().toString();
                                listener.openNextFragment(result);
                            }
                        }
                        break;
                    case R.id.addition:
                        String screenContent = calculatorScreen.getText().toString();
                        secondNumberIndex = screenContent.length() + 1;
                        firstNumber = Double.parseDouble(calculatorScreen.getText().toString());
                        calculatorScreen.append("+");
                        isOpPressed = true;
                        currentOp = '+';
                        break;
                    case R.id.subtraction:
                        screenContent = calculatorScreen.getText().toString();
                        secondNumberIndex = screenContent.length() + 1;
                        firstNumber = Double.parseDouble(calculatorScreen.getText().toString());
                        calculatorScreen.append("-");
                        isOpPressed = true;
                        currentOp = '-';
                        break;
                    case R.id.multiplication:
                        screenContent = calculatorScreen.getText().toString();
                        secondNumberIndex = screenContent.length() + 1;
                        firstNumber = Double.parseDouble(calculatorScreen.getText().toString());
                        calculatorScreen.append("*");
                        isOpPressed = true;
                        currentOp = '*';
                        break;
                    case R.id.division:
                        screenContent = calculatorScreen.getText().toString();
                        secondNumberIndex = screenContent.length() + 1;
                        firstNumber = Double.parseDouble(calculatorScreen.getText().toString());
                        calculatorScreen.append("/");
                        isOpPressed = true;
                        currentOp = '/';
                        break;

                }
            }
        };
        n0.setOnClickListener(calculatorListener);
        n1.setOnClickListener(calculatorListener);
        n2.setOnClickListener(calculatorListener);
        n3.setOnClickListener(calculatorListener);
        n4.setOnClickListener(calculatorListener);
        n5.setOnClickListener(calculatorListener);
        n6.setOnClickListener(calculatorListener);
        n7.setOnClickListener(calculatorListener);
        n8.setOnClickListener(calculatorListener);
        n9.setOnClickListener(calculatorListener);
        dot.setOnClickListener(calculatorListener);
        equals.setOnClickListener(calculatorListener);
        addition.setOnClickListener(calculatorListener);
        subtraction.setOnClickListener(calculatorListener);
        multiplication.setOnClickListener(calculatorListener);
        division.setOnClickListener(calculatorListener);

        final Button delete = view.findViewById(R.id.del);
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String displayedElements = calculatorScreen.getText().toString();
                int length = displayedElements.length();
                if (length > 0) {
                    displayedElements = displayedElements.substring(0, length - 1);
                    calculatorScreen.setText(displayedElements);
                }
            }
        });

        final Button cleareverything = view.findViewById(R.id.cleareverything);
        cleareverything.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculatorScreen.setText("");

            }
        });
    }
}

