package com.example.sanikakulkarni.learningforkids;

import android.content.Intent;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import android.view.View;
import android.widget.ImageView;

import java.util.Locale;


public class StartLearning extends AppCompatActivity {
    ImageView v1;
    TextToSpeech t1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_learning);

    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_start_learning, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    public void learningAlphabets(View view) {
        v1 = (ImageView)findViewById(R.id.imageView2);
        t1=new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if(status != TextToSpeech.ERROR) {
                    t1.setLanguage(Locale.ENGLISH);
                }
            }
        });
        v1.setOnClickListener(new ImageView.OnClickListener() {
            @Override
            public void onClick(View v) {
                String toSpeak = "A for Apple";
                t1.speak(toSpeak,TextToSpeech.QUEUE_FLUSH,null);
            }
        });

    }

    public void learningAlphabetsB(View view) {
        Intent myIntent = new Intent(StartLearning.this,LearnB.class);
        startActivity(myIntent);
    }
}
