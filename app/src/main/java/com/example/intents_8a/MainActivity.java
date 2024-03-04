package com.example.intents_8a;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    TextInputEditText etName, etPhone, etAddress, etUrl;
    Button btnSend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();



        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = etName.getText().toString();
                String phone = etPhone.getText().toString().trim();
                String url = etUrl.getText().toString().trim();
                String address = etAddress.getText().toString();

                if(!url.contains("https:\\"))
                {
                    url = "https:\\"+url;
                }



                Intent sendData = new Intent(MainActivity.this, ShowDetailActivity.class);
                sendData.putExtra("key_name", name);
                sendData.putExtra("key_phone", phone);
                sendData.putExtra("key_url", url);
                sendData.putExtra("key_address", address);
                startActivity(sendData);
                finish();



            }
        });

    }

    private void init()
    {
        etName = findViewById(R.id.etName);
        etPhone = findViewById(R.id.etPhone);
        etUrl = findViewById(R.id.etUrl);
        etAddress = findViewById(R.id.etAddress);
        btnSend = findViewById(R.id.btnSend);
    }


}