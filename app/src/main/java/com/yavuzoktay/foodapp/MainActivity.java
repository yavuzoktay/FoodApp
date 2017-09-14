package com.yavuzoktay.foodapp;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button btnSingIn, btnSingUp;
    TextView txtSlogan ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSingIn = (Button) findViewById(R.id.btn_sign_in);
        btnSingUp= (Button) findViewById(R.id.btn_sign_up);
        txtSlogan= (TextView) findViewById(R.id.txtSlogan);


//        //yazi tipleri belirleniyor.
//        Typeface  face = Typeface.createFromAsset(getAssets(),"fonts/openSansLightItalic.ttf");
//        txtSlogan.setTypeface(face);

        btnSingIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent signIn = new Intent(MainActivity.this,SignIn.class);
                startActivity(signIn);
            }
        });

        btnSingUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent signUp = new Intent(MainActivity.this,SignUp.class);
                startActivity(signUp);
            }
        });



    }


}
