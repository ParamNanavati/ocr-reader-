package com.google.android.gms.samples.vision.ocrreader;

import android.app.Fragment;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.net.Uri;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.speech.tts.TextToSpeech;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.android.tflitecamerademo.CameraActivity;

import java.util.ArrayList;
import java.util.Locale;

import static android.app.Activity.RESULT_OK;

public class home extends Fragment implements TextToSpeech.OnInitListener {
FloatingActionButton mic;
    private TextToSpeech tts;
    Intent i;
    private final int SPEECH_RECOGNITION_CODE = 1;
    ArrayAdapter<String> adapter;
    int c=0;
    String list[]={"Your leave is approved successfully...","Your leave is in process..."};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.home,container,false);

        CardView c1 = (CardView) view.findViewById(R.id.c1);
        CardView c2 = (CardView) view.findViewById(R.id.c2);
        CardView c3 = (CardView) view.findViewById(R.id.c3);
        CardView c4 = (CardView) view.findViewById(R.id.c4);
        CardView c5 = (CardView) view.findViewById(R.id.c5);
        FloatingActionButton cam = (FloatingActionButton) view.findViewById(R.id.cam);
        tts = new TextToSpeech(getActivity(), home.this);

        c1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                speakOut("ok searching for Latest News");
                Uri uri = Uri.parse("http://www.specialpeople.org.uk/" );
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });

        c2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                speakOut("ok searching for BBC News");
                Uri uri = Uri.parse("https://www.bbc.com/news/topics/cnrxy1nq9kxt/special-needs" );
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });

        c3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                speakOut("ok searching for tech news");
                Uri uri = Uri.parse("https://www.hongkiat.com/blog/assistive-apps-gadgets/" );
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);

            }
        });

        c4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                speakOut("ok searching for International news");
                Uri uri = Uri.parse("https://www.hhs.gov/programs/social-services/programs-for-people-with-disabilities/index.html" );
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });

        c5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                speakOut("ok searching for Times of india");
                Uri uri = Uri.parse("https://timesofindia.indiatimes.com/topic/disability/news");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });

        cam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // TODO: Code for Speach to Text..
                startSpeechToText();
                // i = new Intent(getActivity().getApplicationContext(),OcrCaptureActivity.class);
                //startActivity(i);
            }
        });
        return  view;
    }

    private void startSpeechToText() {
        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());
           /*intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,
          RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);*/
          intent.putExtra(RecognizerIntent.EXTRA_PROMPT,
            "Speak something...");
         try {
            startActivityForResult(intent, SPEECH_RECOGNITION_CODE);
             } catch (ActivityNotFoundException a) {
             Toast.makeText(getActivity(),
                     "Sorry! Speech recognition is not supported in this device.",
                     Toast.LENGTH_SHORT).show();
         }
    }
    /**      * Callback for speech recognition activity      * */
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case SPEECH_RECOGNITION_CODE: {
                if (resultCode == RESULT_OK && null != data) {
                    ArrayList<String> result = data
                            .getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                    String text = result.get(0);


            //TODO: Camera Activity

               if(text.toString().equals("open camera") || text.toString().equals("start camera"))
               {
                   i = new Intent(getActivity().getApplicationContext(),OcrCaptureActivity.class);
                   startActivity(i);
                   speakOut("opening camera");
               }


                    if(text.toString().equals("detect object") || text.toString().equals("object detection"))
                    {
                        i = new Intent(getActivity().getApplicationContext(), CameraActivity.class);
                        startActivity(i);
                        speakOut("opening camera");
                    }




            //TODO: WhatsApp Activity
                 if(text.substring(0,4).equals("send"))
                 {
                     String[] arrOfStr = text.split("to", 2);
                     String msg = arrOfStr[0].substring(4);
                     String num = "+91 " +arrOfStr[1].toString();
                     openWhatsApp(getView(),num,msg);
                     speakOut("Sending message");
                 }


            //TODO: Search on Browser Activity
                    if(text.substring(0,6).equals("search"))
                    {
                        String[] arrOfStr = text.split("search", 2);
                        //String url = arrOfStr[1].replace(' ','+');
                        Uri uri = Uri.parse("https://www.google.com/search?q=" + arrOfStr[1]);
                        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                        startActivity(intent);
                        speakOut("ok searching for "+arrOfStr[1]);

                    }

            //TODO: Google map Activity
                    if(text.substring(0,4).equals("find"))
                    {
                        String[] arrOfStr = text.split("find", 2);
                        //String url = arrOfStr[1].replace(' ','+');
                        speakOut("looking for "+arrOfStr[1] + " in google map");
                        Uri uri = Uri.parse("https://www.google.com/maps/search/" + arrOfStr[1]);
                        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                        startActivity(intent);
                    }

                    if(text.substring(0,4).equals("take"))
                    {
                        String[] arrOfStr = text.split("to", 2);
                        //String url = arrOfStr[1].replace(' ','+');
                        speakOut("ok. taking you to "+arrOfStr[1]);
                        Uri uri = Uri.parse("https://www.google.com/maps/dir/Your Location/" + arrOfStr[1]);
                        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                        startActivity(intent);
                    }

            }


                  }
        }
    }



    //TODO: Text to speech code


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

    private void speakOut(String text) {
      //  String text = editText.getText().toString();
        tts.speak(text, TextToSpeech.QUEUE_FLUSH, null);
    }

    public void openWhatsApp(View view , String num , String msg){
        try {
            String text = msg;// Replace with your message.

            String toNumber = num; // Replace with mobile phone number without +Sign or leading zeros, but with country code
            //Suppose your country is India and your phone number is “xxxxxxxxxx”, then you need to send “91xxxxxxxxxx”.


            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("http://api.whatsapp.com/send?phone="+toNumber +"&text="+text));
            startActivity(intent);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}

