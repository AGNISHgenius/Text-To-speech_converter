package com.example.tts;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Locale;

public class MainActivity extends AppCompatActivity implements
        TextToSpeech.OnInitListener{


    EditText ed;
    TextToSpeech tts;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ed = findViewById(R.id.e);

        tts = new TextToSpeech(this,this);

    }

    public void btnClick(View V){
        speak();
    }


    public void speak()
    {
        String data = ed.getText().toString();
        tts.speak(data,TextToSpeech.QUEUE_FLUSH,null);
    }

    public void onInit(int i)
    {
        if (i==TextToSpeech.SUCCESS)
        {
            int xx =  tts.setLanguage(Locale.ENGLISH);
            if(xx==TextToSpeech.LANG_MISSING_DATA || xx==TextToSpeech.LANG_NOT_SUPPORTED)
            {
                Toast.makeText(getApplicationContext(),"LANG_NOT_SUPPORTED",Toast.LENGTH_SHORT).show();

            }
            else{

                speak();
            }
        }
        else{
            Toast.makeText(getApplicationContext(), "onInit failed", Toast.LENGTH_SHORT).show();
        }
    }



}
