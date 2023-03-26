package com.example.braillescanner;

import static com.example.braillescanner.R.id.second_img;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

public class SecondActivity extends AppCompatActivity {

    ImageView second_img;
    Button translate;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        second_img=(ImageView) findViewById(R.id.second_img);
        translate=(Button) findViewById(R.id.translate);
        intent=getIntent();
        Uri uri=(Uri) intent.getParcelableExtra("img");
        second_img.setImageURI(uri);

    }
}