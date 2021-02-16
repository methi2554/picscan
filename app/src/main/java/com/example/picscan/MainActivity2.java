package com.example.picscan;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipboardManager;
import android.content.Intent;
import android.os.Bundle;
import android.renderscript.ScriptGroup;
import android.speech.RecognizerIntent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Locale;

public class MainActivity2 extends AppCompatActivity {

    private static final int REQUEST_CODE_SPEECH_INPUT = 1000;

    EditText mtextTv;
    ImageView mmicBtn;
    ImageView copytext;
    ImageView deletetext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        mmicBtn=findViewById(R.id.micBtn);
        mtextTv=findViewById(R.id.textTv);
        copytext = findViewById(R.id.copybtn);
        deletetext = findViewById(R.id.deletebtn);

        mmicBtn.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                speak();
            }
        });

        copytext.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                ClipboardManager clipboard = (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);
                String getstring = mtextTv.getText().toString();
                Toast.makeText(MainActivity2.this, "copied", Toast.LENGTH_SHORT).show();
                Toast.makeText(MainActivity2.this, getstring, Toast.LENGTH_SHORT).show();
                //Help to continue :)
            }
        });

        deletetext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Text = mtextTv.getText().toString();
                if(Text.isEmpty()){
                    Toast.makeText(MainActivity2.this, "Already Empty", Toast.LENGTH_SHORT).show();

                }
                else {
                    mtextTv.setText(" ");
                }
            }
        });

    }

    private void speak() {
        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE , Locale.getDefault());
        intent.putExtra(RecognizerIntent.EXTRA_PROMPT , "Hi say something");
        //start intent
        try {
            //if there was no error show dialog
            startActivityForResult(intent , REQUEST_CODE_SPEECH_INPUT);
        }
        catch (Exception e){
            //if there was some error  get error message and show
            Toast.makeText(MainActivity2.this, ""+e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode,resultCode,data);
        switch (requestCode){
            case REQUEST_CODE_SPEECH_INPUT : {
                if(resultCode == RESULT_OK && null != data){
                    //get text array from intent
                    ArrayList<String> result = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                    //set to text view
                    mtextTv.setText(result.get(0));
                }
                break;
            }
        }

    }
}