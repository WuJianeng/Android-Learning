package com.example.json_resolve;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private TextView text = null;
    private Button button = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text = findViewById(R.id.text);
        button = findViewById(R.id.send_request_button);

        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.send_request_button :
                String address = "http://47.111.249.166:8082/etd/course/hottest-courses";
                address = "http://hao123.com";
                String response = null;
                try {
                    response = HttpUtil.sendHttpRequest(address);
                }catch (Exception e) {
                    e.printStackTrace();
                }
                text.setText(response);
        }
    }
}
