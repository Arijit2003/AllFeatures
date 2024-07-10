package com.example.allfeatures;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    Button buttonCounter;
    int count=0;
    Spinner spinner;
    ArrayList<String> arrLst;
    ArrayAdapter<String> arrayAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        init();



        buttonCounter.setOnClickListener(v->{
            count++;
            updateUi();
        });
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int pos, long l) {
                String str=adapterView.getItemAtPosition(pos).toString();
                Toast.makeText(getApplicationContext(),str,Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    private  void init(){
        textView = findViewById(R.id.textView);
        buttonCounter=findViewById(R.id.buttonCounter);
        spinner=findViewById(R.id.spinner);
        initializeSpinnerRequirements();
        spinner.setAdapter(arrayAdapter);
    }

    private void initializeSpinnerRequirements(){
        arrLst=new ArrayList<>();
        arrLst.add("Android Development");
        arrLst.add("AIML");
        arrLst.add("JAVA");
        arrLst.add("DBMS");
        arrayAdapter=new ArrayAdapter<>(this, android.R.layout.simple_spinner_item,arrLst);
        arrayAdapter.setDropDownViewResource(android.R.layout.select_dialog_singlechoice);
    }


    private void updateUi(){
        textView.setText(String.valueOf(count));
    }


    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        outState.putInt("counter",count);
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        count = savedInstanceState.getInt("counter", 0);
        updateUi();
        super.onRestoreInstanceState(savedInstanceState);
    }
}