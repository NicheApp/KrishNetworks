package com.nishkarsh.kirishnetwork;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    SharedPreferences sharedpreferences;

    TextView name,email,showdata;
    ImageView img;
    Button submit;
    String Name,Email;
    private static final int MY_CAMERA_PERMISSION_CODE = 100;
    private static final int CAMERA_REQUEST = 1888;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SharedPreferences prefs=getSharedPreferences("MyPref",MODE_PRIVATE);
        setContentView(R.layout.activity_main);
        name= findViewById(R.id.name);
        email=findViewById(R.id.email);
        img= findViewById(R.id.photo);
        submit=findViewById(R.id.submit);
        showdata=findViewById(R.id.show_data);
        if(!prefs.getString("name","").equals(""))
            showdata.setText("Name: "+prefs.getString("name","")+"\nEmail: "+prefs.getString("email",""));
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkSelfPermission(Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED)
                {
                    requestPermissions(new String[]{Manifest.permission.CAMERA}, MY_CAMERA_PERMISSION_CODE);
                }
                else
                {
                    Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                    startActivityForResult(cameraIntent, CAMERA_REQUEST);
                }
            }
        });

        submit.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Name=name.getText().toString();
        Email=email.getText().toString();
        if(isValidEmail(Email,Name)) {


            SharedPreferences.Editor myEdit = prefs.edit();


            myEdit.putString("name", Name);
            myEdit.putString("email", Email);
            myEdit.commit();
            showdata.setText("Name: " + prefs.getString("name", "") + "\nEmail: " + prefs.getString("email", ""));
            Toast.makeText(getApplicationContext(), "Data Stored!", Toast.LENGTH_SHORT).show();
        }
        else
        {
            Toast.makeText(getApplicationContext(), "Please Enter Valid Email!", Toast.LENGTH_SHORT).show();
        }
    }
});




    }
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults)
    {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == MY_CAMERA_PERMISSION_CODE)
        {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED)
            {
                Toast.makeText(this, "camera permission granted", Toast.LENGTH_LONG).show();
                Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(cameraIntent, CAMERA_REQUEST);
            }
            else
            {
                Toast.makeText(this, "camera permission denied", Toast.LENGTH_LONG).show();
            }
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == CAMERA_REQUEST && resultCode == Activity.RESULT_OK)
        {
            Bitmap photo = (Bitmap) data.getExtras().get("data");
            img.setImageBitmap(photo);
        }
    }
    public static boolean isValidEmail(CharSequence target,String name) {
        if (target == null || name==null) {
            return false;
        } else {
            return android.util.Patterns.EMAIL_ADDRESS.matcher(target).matches();
        }
    }
}