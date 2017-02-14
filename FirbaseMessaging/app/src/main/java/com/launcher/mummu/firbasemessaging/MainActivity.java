package com.launcher.mummu.firbasemessaging;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.iid.FirebaseInstanceId;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button mGetTokenButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mGetTokenButton = (Button) findViewById(R.id.button2);
        mGetTokenButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String token = FirebaseInstanceId.getInstance().getToken();
        Toast.makeText(this, token, Toast.LENGTH_SHORT).show();
    }
}
