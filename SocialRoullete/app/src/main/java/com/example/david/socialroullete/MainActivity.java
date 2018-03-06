package com.example.david.socialroullete;

import android.annotation.TargetApi;
import android.bluetooth.BluetoothAdapter;
import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.database.Cursor;
import android.media.MediaPlayer;
import android.os.Build;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class MainActivity extends AppCompatActivity {
    private String name;
    private String phone;
    private int[] balas = new int[6];
    private int che = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }


    //Metodo para disparar
    public void disparar(View v) {
        if (che >= 1){

            MediaPlayer shooting = MediaPlayer.create(this, R.raw.shoot);

        //Se genera un numero aleatorio para saber donde ha parado el tambor
        Random rndB = new Random();
        int rndBal = rndB.nextInt(5 - 0 + 1) + 0;

        //Si hay una bala en ese agujero hay una bala, se procedera con el disparo
        if (balas[rndBal] == 1) {

            Resources res = getResources();
            String[] insulto = res.getStringArray(R.array.insultos);
            int insultNum = 0;
            for (String s : insulto) {
                insultNum++;
            }
            //Se crea un random para los insultos, y se envian a traves de un intent
            Random rnd = new Random();
            int rndInsult = rnd.nextInt(insultNum - 0 + 1) + 0;
            shooting.start();
            Intent sendIntent = new Intent();
            sendIntent.setAction(Intent.ACTION_SEND);
            sendIntent.putExtra(Intent.EXTRA_TEXT, insulto[rndInsult]);
            sendIntent.setType("text/plain");
            startActivity(sendIntent);
        } else {
            //en el caso de no disparar, se envia una frase agradable
            shooting.start();
            Intent sendIntent = new Intent();
            sendIntent.setAction(Intent.ACTION_SEND);
            sendIntent.putExtra(Intent.EXTRA_TEXT, "Solo recordarte lo mucho que se aprecia lo que te esfuerzas cada dia");
            sendIntent.setType("text/plain");
            startActivity(sendIntent);

        }
        }else {
            MediaPlayer coward = MediaPlayer.create(this, R.raw.coward);
            coward.start();
        }
    }


    //moviemiento entre layaouts
    public void goToRuleta(View v){setContentView(R.layout.ruleta);}
    public void goToManual(View v){setContentView(R.layout.manual);}
    public void goToHome(View v){setContentView(R.layout.activity_main);}



    //estos metodos se usan para poner y quitar cada respectiva bala
    public  void ponbala1(View v){
       if (balas[0] == 0) {

           balas[0] = 1;
           che = che + 1;
           MediaPlayer spin = MediaPlayer.create(this, R.raw.spin);
           spin.start();
           ImageView imageview = (ImageView) findViewById(R.id.bal1);
           imageview.setVisibility(View.VISIBLE);
           ImageView imageview2 =(ImageView) findViewById(R.id.balaN1);
           imageview2.setVisibility(View.INVISIBLE);
       } else {
           balas[0] = 0;
           che = che - 1;
           MediaPlayer spin = MediaPlayer.create(this, R.raw.spin);
           spin.start();
           ImageView imageview = (ImageView) findViewById(R.id.bal1);
           imageview.setVisibility(View.INVISIBLE);
           ImageView imageview2 = (ImageView) findViewById(R.id.balaN1);
           imageview2.setVisibility(View.VISIBLE);
       }
    }
    public  void ponbala2(View v){
        if (balas[1] == 0) {

            balas[1] = 1;
            che = che + 1;
            MediaPlayer spin = MediaPlayer.create(this, R.raw.spin);
            spin.start();
            ImageView imageview = (ImageView) findViewById(R.id.bal2);
            imageview.setVisibility(View.VISIBLE);
            ImageView imageview2 =(ImageView) findViewById(R.id.balaN2);
            imageview2.setVisibility(View.INVISIBLE);
        } else {
            balas[1] = 0;
            che = che - 1;
            MediaPlayer spin = MediaPlayer.create(this, R.raw.spin);
            spin.start();
            ImageView imageview = (ImageView) findViewById(R.id.bal2);
            imageview.setVisibility(View.INVISIBLE);
            ImageView imageview2 = (ImageView) findViewById(R.id.balaN2);
            imageview2.setVisibility(View.VISIBLE);
        }
    }
    public  void ponbala3(View v){
        if (balas[2] == 0) {

            balas[2] = 1;
            che = che + 1;
            MediaPlayer spin = MediaPlayer.create(this, R.raw.spin);
            spin.start();
            ImageView imageview = (ImageView) findViewById(R.id.bal3);
            imageview.setVisibility(View.VISIBLE);
            ImageView imageview2 =(ImageView) findViewById(R.id.balaN3);
            imageview2.setVisibility(View.INVISIBLE);
        } else {
            balas[2] = 0;
            che = che - 1;
            MediaPlayer spin = MediaPlayer.create(this, R.raw.spin);
            spin.start();
            ImageView imageview = (ImageView) findViewById(R.id.bal3);
            imageview.setVisibility(View.INVISIBLE);
            ImageView imageview2 = (ImageView) findViewById(R.id.balaN3);
            imageview2.setVisibility(View.VISIBLE);
        }
    }
    public  void ponbala4(View v){
        if (balas[3] == 0) {

            balas[3] = 1;
            che = che + 1;
            MediaPlayer spin = MediaPlayer.create(this, R.raw.spin);
            spin.start();
            ImageView imageview = (ImageView) findViewById(R.id.bal4);
            imageview.setVisibility(View.VISIBLE);
            ImageView imageview2 =(ImageView) findViewById(R.id.balaN4);
            imageview2.setVisibility(View.INVISIBLE);
        } else {
            balas[3] = 0;
            che = che - 1;
            MediaPlayer spin = MediaPlayer.create(this, R.raw.spin);
            spin.start();
            ImageView imageview = (ImageView) findViewById(R.id.bal4);
            imageview.setVisibility(View.INVISIBLE);
            ImageView imageview2 = (ImageView) findViewById(R.id.balaN4);
            imageview2.setVisibility(View.VISIBLE);
        }
    }
    public  void ponbala5(View v){
        if (balas[4] == 0) {

            balas[4] = 1;
            che = che + 1;
            MediaPlayer spin = MediaPlayer.create(this, R.raw.spin);
            spin.start();
            ImageView imageview = (ImageView) findViewById(R.id.bal5);
            imageview.setVisibility(View.VISIBLE);
            ImageView imageview2 =(ImageView) findViewById(R.id.balaN5);
            imageview2.setVisibility(View.INVISIBLE);
        } else {
            balas[4] = 0;
            che = che - 1;
            MediaPlayer spin = MediaPlayer.create(this, R.raw.spin);
            spin.start();
            ImageView imageview = (ImageView) findViewById(R.id.bal5);
            imageview.setVisibility(View.INVISIBLE);
            ImageView imageview2 = (ImageView) findViewById(R.id.balaN5);
            imageview2.setVisibility(View.VISIBLE);
        }
    }
    public  void ponbala6(View v){
        if (balas[5] == 0) {

            balas[5] = 1;
            che = che + 1;
            MediaPlayer spin = MediaPlayer.create(this, R.raw.spin);
            spin.start();
            ImageView imageview = (ImageView) findViewById(R.id.bal6);
            imageview.setVisibility(View.VISIBLE);
            ImageView imageview2 =(ImageView) findViewById(R.id.balaN6);
            imageview2.setVisibility(View.INVISIBLE);
        } else {
            balas[5] = 0;
            che = che - 1;
            MediaPlayer spin = MediaPlayer.create(this, R.raw.spin);
            spin.start();
            ImageView imageview = (ImageView) findViewById(R.id.bal6);
            imageview.setVisibility(View.INVISIBLE);
            ImageView imageview2 = (ImageView) findViewById(R.id.balaN6);
            imageview2.setVisibility(View.VISIBLE);
        }
    }


    //Esto no importa
    public void easterEgg(View v){
        MediaPlayer egg = MediaPlayer.create(this, R.raw.ussr);
        egg.start();
        ImageView imageview = (ImageView) findViewById(R.id.logoeg);
        imageview.setVisibility(View.VISIBLE);
        ImageView imageview2 =(ImageView) findViewById(R.id.logo);
        imageview2.setVisibility(View.INVISIBLE);
    }

    //Esta parte se deja por para un uso futuro, cuando se arreglen ciertos problemas tecnicos con los contactos
    public void xtremeMode() {

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

            Intent pickContact = new Intent(Intent.ACTION_PICK, ContactsContract.Contacts.CONTENT_URI);
            pickContact.setType(ContactsContract.CommonDataKinds.Phone.CONTENT_TYPE);
            startActivityForResult(pickContact, 1);



            //  EnviaSMS(txtTelefono,insulto[rndInsult]);


        } else {
            Toast.makeText(this, "Te has salvado", Toast.LENGTH_SHORT).show();

        }
    }
    public void contact(View v){
        Cursor contacts = getContentResolver().query(ContactsContract.Contacts.CONTENT_URI, null, null, null, null);
        String numbersArray[] = new String[contacts.getCount()];
        int i = 0;
        String snumber;
        int numberFieldColumnIndex = contacts.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER);

        while(contacts.moveToNext()) {
            String number = contacts.getString(numberFieldColumnIndex);
            numbersArray[i] =number ;
            i++;
        }

        Random rndC = new Random();
        int rndNum = rndC.nextInt(i);
        snumber = numbersArray[rndNum];
        Toast.makeText(this, snumber, Toast.LENGTH_SHORT).show();

        contacts.close();

    }
    public void EnviarSMS(View v){
        //   EditText txtTelefono=(EditText)findViewById(R.id.txtTelefono);
        // EnviaSMS(txtTelefono.getText().toString(),"Te felicito la navidad automáticamente");
    }
    @TargetApi(Build.VERSION_CODES.DONUT)
    public void EnviaSMS(String telefono, String mensaje){
        try {
            SmsManager smsManager = SmsManager.getDefault();
            smsManager.sendTextMessage(telefono, null, mensaje, null, null);
            Toast.makeText(getApplicationContext(), "SMS enviado.",Toast.LENGTH_LONG).show();
        } catch (Exception e) {
            Toast.makeText(getApplicationContext(),
                    "SMS no enviado, por favor, inténtalo otra vez.",
                    Toast.LENGTH_LONG).show();
            e.printStackTrace();
        }
    }
    public void getRandomContact(View v) {


        Cursor managedCursor = getContentResolver().query(ContactsContract.Contacts.CONTENT_URI,null, null, null, null);
        int size = managedCursor.getCount();

        Random rnd = new Random();
        int index = rnd.nextInt(size);
        managedCursor.moveToPosition(index);

        String contactId = "";
        int hasAPhoneNumber = Integer.parseInt(managedCursor.getString(managedCursor.getColumnIndex(ContactsContract.Contacts.HAS_PHONE_NUMBER)));

        // Repeat until we get a contact with a phone number
        while (hasAPhoneNumber == 0) {
            index = rnd.nextInt(size);
            managedCursor.moveToPosition(index);
            name = managedCursor.getString(managedCursor.getColumnIndex(ContactsContract.PhoneLookup.DISPLAY_NAME));
            hasAPhoneNumber = Integer.parseInt(managedCursor.getString(managedCursor.getColumnIndex(ContactsContract.Contacts.HAS_PHONE_NUMBER)));
            contactId = managedCursor.getString(managedCursor.getColumnIndex(ContactsContract.Contacts._ID));
        }

        // Find the contact's phone number and return it
        Cursor phones = getContentResolver().query(
                ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null,
                ContactsContract.CommonDataKinds.Phone.CONTACT_ID +" = "+ contactId, null, null);
        while (phones.moveToNext()) {
            phone = phones.getString(phones.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
        }
        Toast.makeText(this, phone, Toast.LENGTH_SHORT).show();
        //  return phone; // rnd.nextInt(size);
    }

}

