package com.example.david.socialroullete;

import android.content.ContentResolver;
import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private String name;
    private String phone;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    int[] balas = new int[6];
    int che = 0;
    public void disparar(View v) {
        if (che >= 1){


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

            Intent sendIntent = new Intent();
            sendIntent.setAction(Intent.ACTION_SEND);
            sendIntent.putExtra(Intent.EXTRA_TEXT, "Solo recordarte lo mucho que se aprecia lo que te esfuerzas cada dia");
            sendIntent.setType("text/plain");
            startActivity(sendIntent);

        }
        }else {
            Toast.makeText(this, "Te has deshonrado", Toast.LENGTH_SHORT).show();
        }
    }

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



    public String getNumber(){
        ContentResolver cr = getContentResolver();
        Cursor cursor = cr.query(ContactsContract.Contacts.CONTENT_URI, null, "DISPLAY_NAME = '" + "NAME" + "'", null, null);
        cursor.moveToFirst();
        String contactId = cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts._ID));
        Cursor phones = cr.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null, ContactsContract.CommonDataKinds.Phone.CONTACT_ID + " = " + contactId, null, null);
        List numbers = new ArrayList();

        while (phones.moveToNext()) {
            String number = phones.getString(phones.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
            int type = phones.getInt(phones.getColumnIndex(ContactsContract.CommonDataKinds.Phone.TYPE));
            switch (type) {
                case ContactsContract.CommonDataKinds.Phone.TYPE_MOBILE:
                    numbers.add(number);
                    break;
            }
        }

        Random randGen = new Random();
        return (String) numbers.get(randGen.nextInt(numbers.size()));
    }



    public void EnviaSMS(String telefono,String mensaje){
        try {
            SmsManager sms1 = SmsManager.getDefault();
            sms1.sendTextMessage(telefono, null, mensaje, null, null);
            Toast.makeText(getApplicationContext(), "Has disparado",Toast.LENGTH_LONG).show();
        }
        catch (Exception e) {
            Toast.makeText(getApplicationContext(),
                    "Se te ha encascillado, intentalo de nuevo",
                    Toast.LENGTH_LONG).show();
            e.printStackTrace();
        }
    }





    public void goToRuleta(View v){setContentView(R.layout.ruleta);}

    public  void ponbala1(View v){
       if (balas[0] == 0) {

           balas[0] = 1;
           che = che + 1;
           ImageView imageview = (ImageView) findViewById(R.id.bala1);
           imageview.setVisibility(View.VISIBLE);
           ImageView imageview2 =(ImageView) findViewById(R.id.bala);
           imageview2.setVisibility(View.INVISIBLE);
       } else {
           balas[0] = 0;
           che = che - 1;
           ImageView imageview = (ImageView) findViewById(R.id.bala1);
           imageview.setVisibility(View.INVISIBLE);
           ImageView imageview2 = (ImageView) findViewById(R.id.bala);
           imageview2.setVisibility(View.VISIBLE);
       }
    }
    public  void ponbala2(View v){
        if (balas[1] == 0) {

            balas[1] = 1;
            che = che + 1;
            ImageView imageview = (ImageView) findViewById(R.id.bala2);
            imageview.setVisibility(View.VISIBLE);
            ImageView imageview2 =(ImageView) findViewById(R.id.bala7);
            imageview2.setVisibility(View.INVISIBLE);
        } else {
            balas[1] = 0;
            che = che - 1;
            ImageView imageview = (ImageView) findViewById(R.id.bala2);
            imageview.setVisibility(View.INVISIBLE);
            ImageView imageview2 = (ImageView) findViewById(R.id.bala7);
            imageview2.setVisibility(View.VISIBLE);
        }
    }
    public  void ponbala3(View v){
        if (balas[2] == 0) {

            balas[2] = 1;
            che = che + 1;
            ImageView imageview = (ImageView) findViewById(R.id.bala3);
            imageview.setVisibility(View.VISIBLE);
            ImageView imageview2 =(ImageView) findViewById(R.id.bala8);
            imageview2.setVisibility(View.INVISIBLE);
        } else {
            balas[2] = 0;
            che = che - 1;
            ImageView imageview = (ImageView) findViewById(R.id.bala3);
            imageview.setVisibility(View.INVISIBLE);
            ImageView imageview2 = (ImageView) findViewById(R.id.bala8);
            imageview2.setVisibility(View.VISIBLE);
        }
    }
    public  void ponbala4(View v){
        if (balas[3] == 0) {

            balas[3] = 1;
            che = che + 1;
            ImageView imageview = (ImageView) findViewById(R.id.bala4);
            imageview.setVisibility(View.VISIBLE);
            ImageView imageview2 =(ImageView) findViewById(R.id.bala9);
            imageview2.setVisibility(View.INVISIBLE);
        } else {
            balas[3] = 0;
            che = che - 1;
            ImageView imageview = (ImageView) findViewById(R.id.bala4);
            imageview.setVisibility(View.INVISIBLE);
            ImageView imageview2 = (ImageView) findViewById(R.id.bala9);
            imageview2.setVisibility(View.VISIBLE);
        }
    }
    public  void ponbala5(View v){
        if (balas[4] == 0) {

            balas[4] = 1;
            che = che + 1;
            ImageView imageview = (ImageView) findViewById(R.id.bala5);
            imageview.setVisibility(View.VISIBLE);
            ImageView imageview2 =(ImageView) findViewById(R.id.bala10);
            imageview2.setVisibility(View.INVISIBLE);
        } else {
            balas[4] = 0;
            che = che - 1;
            ImageView imageview = (ImageView) findViewById(R.id.bala5);
            imageview.setVisibility(View.INVISIBLE);
            ImageView imageview2 = (ImageView) findViewById(R.id.bala10);
            imageview2.setVisibility(View.VISIBLE);
        }
    }
    public  void ponbala6(View v){
        if (balas[5] == 0) {

            balas[5] = 1;
            che = che + 1;
            ImageView imageview = (ImageView) findViewById(R.id.bala6);
            imageview.setVisibility(View.VISIBLE);
            ImageView imageview2 =(ImageView) findViewById(R.id.bala11);
            imageview2.setVisibility(View.INVISIBLE);
        } else {
            balas[5] = 0;
            che = che - 1;
            ImageView imageview = (ImageView) findViewById(R.id.bala6);
            imageview.setVisibility(View.INVISIBLE);
            ImageView imageview2 = (ImageView) findViewById(R.id.bala11);
            imageview2.setVisibility(View.VISIBLE);
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