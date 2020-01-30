package com.example.myFragments;


import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


/**
 * A simple {@link Fragment} subclass.
 */
public class RecyclerviewFragment extends Fragment  {


    public interface IButtonFragment2 {
        void returnToCalc();
    }

    IButtonFragment2 listener2;

    RecyclerviewAdapter adapter;
    Button button_back;
    String data;

    public static RecyclerviewFragment create(IButtonFragment2 listener2) {
        RecyclerviewFragment recyclerviewFragment = new RecyclerviewFragment();
        recyclerviewFragment.listener2 = listener2;
        return recyclerviewFragment;
    }

    public RecyclerviewFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_recyclerview, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        adapter = new RecyclerviewAdapter();
        RecyclerView recyclerView = view.findViewById(R.id.recycler_view);
        RecyclerviewFragment recycler = new RecyclerviewFragment();
      //  adapter.listener3 = (IButtonFragment2)getActivity();
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        button_back = view.findViewById(R.id.btn_back);
        button_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener2.returnToCalc();



            }
        });

        Bundle bundle = getArguments();
        if(bundle != null){
            data = bundle.getString("key");
            Log.e("ololo", "addText: " + data);
            adapter.addText(data);
        }
    }

//    public void showText(String s) {
//        Log.e("ololo", "showText: " + s);
//        adapter.notifyDataSetChanged();
//    }
}

