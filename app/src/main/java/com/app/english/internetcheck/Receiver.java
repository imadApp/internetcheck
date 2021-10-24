package com.app.english.internetcheck;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.widget.Toast;

public class Receiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

        if(intent.getAction().equals("android.net.conn.CONNECTIVITY_CHANGE")){
            // فحص الانترنيت
            if(isOnline(context)){

                Toast.makeText(context , "Networked"  , Toast.LENGTH_SHORT).show();

            }  else {

                Toast.makeText(context , "not connected Networked"  , Toast.LENGTH_SHORT).show();

            }
        }






/**
 if(intent.getAction().equals("android.intent.action.BOOT_COMPLETED")){

 Toast.makeText(context , "Boot Completed"  ,Toast.LENGTH_SHORT ).show();
 }

 if(intent.getAction().equals("android.intent.action.HEADSET_PLUG")){
 int state  = intent.getIntExtra("state"  , -1)  ;

 switch (state){
 case 1 :

 Toast.makeText(context  ,"Plugged"  , Toast.LENGTH_SHORT ).show();

 break;

 case 0  :
 Toast.makeText(context  ,"in Plugged"  , Toast.LENGTH_SHORT ).show();


 break;

 }

 }

 **/
    } boolean isOnline(Context context ){

        try {

            ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo net = cm.getActiveNetworkInfo()  ;
            return  (net != null && net.isConnected()) ;


        } catch (Exception e){

            e.printStackTrace();
            return  false ;

        }

    }
}

