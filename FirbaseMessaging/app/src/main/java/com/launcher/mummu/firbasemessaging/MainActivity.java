package com.launcher.mummu.firbasemessaging;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.firebase.iid.FirebaseInstanceId;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button mGetTokenButton;
    private ImageView mImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mGetTokenButton = (Button) findViewById(R.id.button2);
        mGetTokenButton.setOnClickListener(this);
        mImageView = (ImageView) findViewById(R.id.imageView);
        Intent intent = getIntent();
        if (intent != null) {
            String url = intent.getStringExtra("URL");
            Glide.with(this)
                    .load(url)
                    .centerCrop()
                    .placeholder(R.mipmap.ic_launcher)
                    .crossFade()
                    .into(mImageView);
        }

    }

    @Override
    public void onClick(View v) {
        String token = FirebaseInstanceId.getInstance().getToken();
        Toast.makeText(this, token, Toast.LENGTH_SHORT).show();
    }
}
