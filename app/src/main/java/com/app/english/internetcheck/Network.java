package com.app.english.internetcheck;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Build;

public class Network {
             BroadcastReceiver broadcastReceiver  ;
             Context context ;
              IntentFilter filter ;


     public Network(Context context)  {

             //broadcastReceiver initialization
             broadcastReceiver = new Receiver() ;
             this.context = context;


         // نوع الحدث الاتصال بالانترنيت
          filter = new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION) ;


         if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.N){

             this.context.registerReceiver(broadcastReceiver  ,filter  );


         }   if (Build.VERSION.SDK_INT>=Build.VERSION_CODES.O) {

             this .context.registerReceiver(broadcastReceiver  ,filter  );


         }


     } public  void  unregisterNetwork(){

         try {

                  context.unregisterReceiver(broadcastReceiver);

         } catch (Exception e){
                 e.printStackTrace();
         }



      // network check

    }  public boolean   networkcheck(){

            Receiver x = new Receiver() ;

            if( x.isOnline(context )) {

                return  true ;

        } else  {

                return  false ;
            }


    }
}
