package com.example.braillescanner;

import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageView imageView;
    Button startbutton;
    ActivityResultLauncher<String> img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView= (ImageView)findViewById(R.id.imageView);
        startbutton= (Button)findViewById(R.id.startbutton);

        if(ContextCompat.checkSelfPermission(MainActivity.this,
              android.Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(MainActivity.this,new String[]{android.Manifest.permission.CAMERA},101);
        }


        img=registerForActivityResult(
                new ActivityResultContracts.GetContent(),
                new ActivityResultCallback<Uri>() {
                    @Override
                    public void onActivityResult(Uri result) {

                        imageView.setImageURI(result);
                    }
                }
        );

        startbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                img.launch("image/*");
//                Intent intent=new Intent((MediaStore.ACTION_IMAGE_CAPTURE));
//                startActivityForResult(intent,101);
            }
        });
    }

//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//        if(requestCode==101){
//            Bitmap bitmap=(Bitmap) data.getExtras().get("data");
//            imageView.setImageBitmap(bitmap);
//        }
//    }
}