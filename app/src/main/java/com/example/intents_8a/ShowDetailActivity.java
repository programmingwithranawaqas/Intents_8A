package com.example.intents_8a;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class ShowDetailActivity extends AppCompatActivity {

    TextView tvName;

    ImageView ivCall, ivCallFriend, ivUrl, ivAddress;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_detail);

        String name = getIntent().getStringExtra(Keys.KEY_NAME);
        String address = getIntent().getStringExtra(Keys.KEY_ADDRESS);
        String url = getIntent().getStringExtra(Keys.KEY_URL);
        String phone = getIntent().getStringExtra(Keys.KEY_PHONE);

        tvName = findViewById(R.id.tvName);
        ivUrl = findViewById(R.id.ivUrl);
        ivAddress = findViewById(R.id.ivAddress);
        ivCallFriend = findViewById(R.id.ivCallFriend);
        ivCall = findViewById(R.id.ivCall);


        tvName.setText(name);

        ivCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+phone));
                startActivity(intent);
            }
        });

        ivCallFriend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                startActivity(intent);
            }
        });

        ivAddress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:0,0?q="+address));
                startActivity(intent);
            }
        });

        ivUrl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(intent);
            }
        });


    }
}