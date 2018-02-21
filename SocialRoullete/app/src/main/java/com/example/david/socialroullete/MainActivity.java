package com.example.david.socialroullete;

import android.app.ActionBar;
import android.content.Intent;
import android.content.res.Resources;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    int[] balas = new int[6];

    public void noobMode(View v) {

        Random rndB = new Random();
        int rndBal = rndB.nextInt(5 - 0 + 1) + 0;

        if (balas[rndBal] == 1) {

            Resources res = getResources();
            String[] insulto = res.getStringArray(R.array.insultos);
            int insultNum = 0;
            for (String s : insulto) {
                insultNum++;
            }

            Random rnd = new Random();
            int rndInsult = rnd.nextInt(insultNum - 0 + 1) + 0;

            Intent sendIntent = new Intent();
            sendIntent.setAction(Intent.ACTION_SEND);
            sendIntent.putExtra(Intent.EXTRA_TEXT, insulto[rndInsult]);
            sendIntent.setType("text/plain");
            startActivity(sendIntent);
        } else {
            Toast.makeText(this, "Te has salvado", Toast.LENGTH_SHORT).show();

        }
    }

    public void goToNoob(View v){
        setContentView(R.layout.easymode);
    }

    public  void ponbala1(View v){
        balas[0] = 1;
        ImageView imageview =(ImageView) findViewById(R.id.bala1);
        imageview.setVisibility(View.VISIBLE);

        ImageView imageview2 =(ImageView) findViewById(R.id.bala);
        imageview2.setVisibility(View.INVISIBLE);
    }
    public  void ponbala2(View v){
        balas[1] = 1;
        ImageView imageview =(ImageView) findViewById(R.id.bala2);
        imageview.setVisibility(View.VISIBLE);
        ImageView imageview2 =(ImageView) findViewById(R.id.bala7);
        imageview2.setVisibility(View.INVISIBLE);
    }
    public  void ponbala3(View v){
        balas[2] = 1;
        ImageView imageview =(ImageView) findViewById(R.id.bala3);
        imageview.setVisibility(View.VISIBLE);
        ImageView imageview2 =(ImageView) findViewById(R.id.bala8);
        imageview2.setVisibility(View.INVISIBLE);
    }
    public  void ponbala4(View v){
        balas[3] = 1;
        ImageView imageview =(ImageView) findViewById(R.id.bala4);
        imageview.setVisibility(View.VISIBLE);
        ImageView imageview2 =(ImageView) findViewById(R.id.bala9);
        imageview2.setVisibility(View.INVISIBLE);
    }
    public  void ponbala5(View v){
        balas[4] = 1;
        ImageView imageview =(ImageView) findViewById(R.id.bala5);
        imageview.setVisibility(View.VISIBLE);
        ImageView imageview2 =(ImageView) findViewById(R.id.bala10);
        imageview2.setVisibility(View.INVISIBLE);
    }
    public  void ponbala6(View v){
        balas[5] = 1;
        ImageView imageview =(ImageView) findViewById(R.id.bala6);
        imageview.setVisibility(View.VISIBLE);
        ImageView imageview2 =(ImageView) findViewById(R.id.bala11);
        imageview2.setVisibility(View.INVISIBLE);
    }

}