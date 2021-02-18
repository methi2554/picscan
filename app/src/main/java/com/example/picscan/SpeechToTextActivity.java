package com.example.picscan;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.Locale;

public class SpeechToTextActivity extends AppCompatActivity {

    private static final int REQUEST_CODE_SPEECH_INPUT = 1000;

    TextView mtextTv;
    ImageButton mmicBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_texttospeech);
        mmicBtn=findViewById(R.id.micBtn);
        mtextTv=findViewById(R.id.textTv);


        mmicBtn.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                speak();
            }
        });
    }
    private void speak() {
        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE ,Locale.getDefault());
        intent.putExtra(RecognizerIntent.EXTRA_PROMPT , "Hi say something");
        //start intent
        try {
            //if there was no error show dialog
            startActivityForResult(intent , REQUEST_CODE_SPEECH_INPUT);
        }
        catch (Exception e){
            //if there was some error  get error message and show
            Toast.makeText(SpeechToTextActivity.this, ""+e.getMessage(), Toast.LENGTH_SHORT).show();
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
