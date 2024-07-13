package com.example.allfeatures.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.allfeatures.R;

import java.lang.reflect.Array;
import java.util.ArrayList;


public class Fragment1_List extends Fragment {

    ListView listView;
    ArrayList<String> arrLst = new ArrayList<>();
    AutoCompleteTextView autoCompleteTV;




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fragment1__list, container, false);

        init(view);

        listView.setOnItemClickListener((adapterView, view1, pos, l) -> {
            Toast.makeText(requireActivity(), arrLst.get(pos).concat("Clicked"), Toast.LENGTH_SHORT).show();
        });

        return view;
    }


    private void init(View view){
        listView=view.findViewById(R.id.listView);
        autoCompleteTV=view.findViewById(R.id.autoCompleteTV);
        initializeListView();
        initializeAutoCompleteTextView();
    }
    private void initializeListView(){
        arrLst.add("ANDROID DEVELOPMENT");
        arrLst.add("WEB DEVELOPMENT");
        arrLst.add("AI/ML");
        arrLst.add("NODE");
        arrLst.add("MONGODB");
        arrLst.add("IOT");
        arrLst.add("HTML");
        arrLst.add("JAVA");
        arrLst.add("PYTHON");
        arrLst.add("CSS");
        arrLst.add("JAVASCRIPT");
        arrLst.add("SQL");
        arrLst.add("OS");
        arrLst.add("DBMS");
        arrLst.add("ANDROID DEVELOPMENT");
        arrLst.add("WEB DEVELOPMENT");
        arrLst.add("AI/ML");
        arrLst.add("NODE");
        arrLst.add("MONGODB");
        arrLst.add("IOT");
        arrLst.add("HTML");
        arrLst.add("JAVA");
        arrLst.add("PYTHON");
        arrLst.add("CSS");
        arrLst.add("JAVASCRIPT");
        arrLst.add("SQL");
        arrLst.add("OS");
        arrLst.add("DBMS");
        // for custom array adapter you need extend it by BaseAdapter
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(requireActivity(),android.R.layout.simple_list_item_1,arrLst);
        listView.setAdapter(arrayAdapter);

    }


    private void initializeAutoCompleteTextView(){
        ArrayList<String> arLst = new ArrayList<>();
        arLst.add("ANDROID DEVELOPMENT");
        arLst.add("WEB DEVELOPMENT");
        arLst.add("AI/ML");
        arLst.add("NODE");
        arLst.add("MONGODB");
        arLst.add("IOT");
        arLst.add("HTML");
        arLst.add("JAVA");
        arLst.add("PYTHON");
        arLst.add("CSS");
        arLst.add("JAVASCRIPT");
        arLst.add("SQL");
        arLst.add("OS");
        arLst.add("DBMS");
        ArrayAdapter<String> arrAdapter = new ArrayAdapter<>(requireActivity(), android.R.layout.simple_list_item_1,arLst);
        autoCompleteTV.setAdapter(arrAdapter);
        autoCompleteTV.setThreshold(3);
    }

}