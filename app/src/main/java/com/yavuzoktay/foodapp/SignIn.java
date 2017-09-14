package com.yavuzoktay.foodapp;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.rengwuxian.materialedittext.MaterialEditText;
import com.yavuzoktay.foodapp.common.Common;
import com.yavuzoktay.foodapp.model.User;

public class SignIn extends AppCompatActivity {

    MaterialEditText edtPhone, edtPassword;
    Button btnSingIn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        edtPhone= (MaterialEditText) findViewById(R.id.editTextPhone);
        edtPassword = (MaterialEditText) findViewById(R.id.editTextPassword);
        btnSingIn = (Button) findViewById(R.id.btn_sign_in);


        //Firebase başlama
        final FirebaseDatabase database =  FirebaseDatabase.getInstance();
        final DatabaseReference table_user = database.getReference("User");

        btnSingIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final ProgressDialog mDialog= new ProgressDialog(SignIn.this);
                mDialog.setMessage("Please waiting...");
                mDialog.show();

                table_user.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                       //kullanıcının veritabanında bulunup bulunmadıgını kontrol ediyoruz.
                        if(dataSnapshot.child(edtPhone.getText().toString()).exists()){
                        //user bilgilerini al
                                 mDialog.dismiss();
                                 User user = dataSnapshot.child(edtPhone.getText().toString()).getValue(User.class);
                                 user.setPhone(edtPhone.getText().toString());
                            if(user.getPassword().equals(edtPassword.getText().toString()))
                                 {
                                        Intent homeIntent = new Intent(SignIn.this,Home.class);
                                        Common.currentUser=user;
                                        startActivity(homeIntent);
                                        finish();
                                 }
                                else  {
                                    Toast.makeText(SignIn.this, "Giriş Bilgileriyle Eşleşmiyor !!!", Toast.LENGTH_SHORT).show();
                                      }
                        }
                        else{
                            mDialog.dismiss();
                            Toast.makeText(SignIn.this, "Kullanıcı Bilgilerini Bulamadık", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });
            }
        });


    }
}
