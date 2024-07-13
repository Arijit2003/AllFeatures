package com.example.allfeatures.activites;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
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

import com.example.allfeatures.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    Button buttonCounter;
    int count=0;
    Spinner spinner;
    Button translate,scale,rotate,alpha,resetBtn,nextBtn;

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


        resetBtn.setOnClickListener(v->{
            buttonCounter.clearAnimation();
        });
        translate.setOnClickListener(v->{
            Animation anim = AnimationUtils.loadAnimation(this,R.anim.translate);
            //buttonCounter.setAnimation(anim); // when the screen refreshed/loads
            buttonCounter.startAnimation(anim);
        });
        alpha.setOnClickListener(v->{
            Animation anim = AnimationUtils.loadAnimation(this,R.anim.alpha);
            buttonCounter.startAnimation(anim);
        });
        rotate.setOnClickListener(v->{
            Animation anim = AnimationUtils.loadAnimation(this,R.anim.rotate);
            buttonCounter.startAnimation(anim);
        });
        scale.setOnClickListener(v->{
            Animation anim = AnimationUtils.loadAnimation(this,R.anim.scale);
            buttonCounter.startAnimation(anim);
        });
        buttonCounter.setOnClickListener(v->{
            count++;
            updateUi();
        });
        nextBtn.setOnClickListener(v->{
            startActivity(new Intent(this,ContainerActivity.class));
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
        translate=findViewById(R.id.translate);
        rotate =findViewById(R.id.rotate);
        scale=findViewById(R.id.scale);
        alpha=findViewById(R.id.alpha);
        resetBtn=findViewById(R.id.resetBtn);
        initializeSpinnerRequirements();
        spinner.setAdapter(arrayAdapter);
        nextBtn=findViewById(R.id.nextBtn);
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