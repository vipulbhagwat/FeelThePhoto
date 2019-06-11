package com.example.feelthephoto;

import android.content.Intent;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {
Button bt1,bt2;
ImageView imageView;
Intent intent;
Bitmap bitmp;
final static int picbycamera=10;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bt1=findViewById(R.id.button);
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try
                {
                    getApplicationContext().setWallpaper(bitmp);

                }
                    catch (IOException s)
                    {
                        s.printStackTrace();
                    }
                Toast.makeText(MainActivity.this,"FEEL ",Toast.LENGTH_SHORT).show();

              //  Intent intent=new Intent(MainActivity.this,Feel.class);
               // startActivity(intent);

            }
        });
        bt2=findViewById(R.id.button2);
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent =new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent,picbycamera);
                Toast.makeText(MainActivity.this,"LOOK ",Toast.LENGTH_SHORT).show();

              //  Intent intent=new Intent(MainActivity.this,Look.class);
               // startActivity(intent);

            }
        });

        imageView = findViewById(R.id.imageView);


    }
//Menu is included in application
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id=item.getItemId();
        switch (id)
        {
            case R.id.item1:
                Toast.makeText(this, "Settings", Toast.LENGTH_SHORT).show();
            break;
            case R.id.item2:
                Toast.makeText(this, "Exit", Toast.LENGTH_SHORT).show();
            break;
            case R.id.item3:
                Toast.makeText(this, "Lock", Toast.LENGTH_SHORT).show();
                break;
        }
        return true;

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode==RESULT_OK)
        {
            Bundle extras=data.getExtras();
            bitmp=(Bitmap) extras.get("data");
            imageView.setImageBitmap(bitmp);
        }
    }
}

