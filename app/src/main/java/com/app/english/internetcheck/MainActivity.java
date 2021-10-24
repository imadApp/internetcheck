package com.app.english.internetcheck;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btn ;

    Network network ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = findViewById(R.id.button );

          // initialization Network
        network = new Network(this  );
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

               boolean x =  network.networkcheck();

               if(x){
                   Toast.makeText(getBaseContext() , "The operation is successful\n" +
                           "\n" ,Toast.LENGTH_SHORT ).show();
               } else {
                   Toast.makeText(getBaseContext() , "Operation unsuccessful\n" +
                           "\n" ,Toast.LENGTH_SHORT ).show();

               }

            }
        });
    }
}