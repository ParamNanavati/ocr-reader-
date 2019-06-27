package com.google.android.gms.samples.vision.ocrreader;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class web extends AppCompatActivity {

    private WebView wb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);
        wb = (WebView) findViewById(R.id.wb);
        wb.setWebViewClient(new WebViewClient());



        Intent i = getIntent();
        String string = i.getStringExtra("h");


         if(string.equals("hos")) {
            wb.loadUrl("https://www.google.com/maps/search/near+by+hospital/@22.3091937,73.1365537,13z/data=!3m1!4b1");
        }
        else if(string.equals("sch")){
            wb.loadUrl("https://www.google.com/maps/search/near+by+school/@22.3143401,73.1416594,13z/data=!3m1!4b1");
        }

        else if(string.equals("col")){
            wb.loadUrl("https://www.google.com/maps/search/near+by+college/@22.3137839,73.1702631,15z/data=!3m1!4b1");
        }

        else if(string.equals("res")){
            wb.loadUrl("https://www.google.com/maps/search/nearby+restaurants/@22.3138624,73.1702631,15z/data=!3m1!4b1");
        }

        else if(string.equals("pol")){
            wb.loadUrl("https://www.google.com/maps/search/nearby+police+station/@22.3139408,73.1702631,15z/data=!3m1!4b1");
        }

        else if(string.equals("par")){
            wb.loadUrl("https://www.google.com/maps/search/nearby+park/@22.3139801,73.1702631,15z/data=!3m1!4b1");
        }

        else if(string.equals("card1")){
             wb.loadUrl("http://www.specialpeople.org.uk/");

         }

         else if(string.equals("card2")){
             wb.loadUrl("https://www.bbc.com/news/topics/cnrxy1nq9kxt/special-needs");

         }

         else if(string.equals("card3")){
             wb.loadUrl("https://www.hongkiat.com/blog/assistive-apps-gadgets/");

         }

         else if(string.equals("card4")){
             wb.loadUrl("https://www.hhs.gov/programs/social-services/programs-for-people-with-disabilities/index.html");

         }

         else if(string.equals("card5")){
             wb.loadUrl("https://timesofindia.indiatimes.com/topic/disability/news");

         }

        WebSettings webSettings = wb.getSettings();
        webSettings.setJavaScriptEnabled(true);
    }

    @Override
    public void onBackPressed(){

        if(wb.canGoBack()){
            wb.goBack();
        }
        else {
            super.onBackPressed();
        }
    }
}
