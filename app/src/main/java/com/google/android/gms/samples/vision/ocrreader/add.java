package com.google.android.gms.samples.vision.ocrreader;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.Locale;

/**
 * Created by Param on 01-Jul-18.
 */

public class add extends Fragment implements TextToSpeech.OnInitListener {
    ArrayAdapter<String> adapter;
    private TextToSpeech tts;
    private final int SPEECH_RECOGNITION_CODE = 1;
Intent i;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.add,container,false);
        ImageView hos = (ImageView) view.findViewById(R.id.hos);
        ImageView sch = (ImageView) view.findViewById(R.id.school);
        ImageView col = (ImageView) view.findViewById(R.id.col);
        ImageView res = (ImageView) view.findViewById(R.id.res);
        ImageView pol = (ImageView) view.findViewById(R.id.pol);
        ImageView par = (ImageView) view.findViewById(R.id.par);
        tts = new TextToSpeech(getActivity(), add.this);

        hos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                speakOut("looking for Near by hospital in google map");
                Uri uri = Uri.parse("https://www.google.com/maps/search/near+by+hospital" );
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });

        sch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                speakOut("looking for Near by school in google map");
                Uri uri = Uri.parse("https://www.google.com/maps/search/near+by+school" );
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });

        col.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                speakOut("looking for Near by college in google map");
                Uri uri = Uri.parse("https://www.google.com/maps/search/near+by+college" );
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });

        res.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                speakOut("looking for Near by Restaurant in google map");
                Uri uri = Uri.parse("https://www.google.com/maps/search/near+by+Restaurant" );
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });

        pol.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                speakOut("looking for Near by police station in google map");
                Uri uri = Uri.parse("https://www.google.com/maps/search/near+by+police+station" );
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });

        par.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                speakOut("looking for Near by park in google map");
                Uri uri = Uri.parse("https://www.google.com/maps/search/near+by+park" );
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
        return  view;
    }
    private void speakOut(String text) {
        //  String text = editText.getText().toString();
        tts.speak(text, TextToSpeech.QUEUE_FLUSH, null);
    }


    @Override
    public void onInit(int status) {

        if (status == TextToSpeech.SUCCESS) {

            int result = tts.setLanguage(Locale.US);

            if (result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                Log.e("TTS", "This Language is not supported");
            }

            else {
                //buttonSpeak.setEnabled(true);
                // speakOut();
            }

        }
        else {
            Log.e("TTS", "Initilization Failed!");
        }

    }
}
