package com.example.litepal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import org.litepal.LitePal;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button addData = findViewById(R.id.add_data);
        addData.setOnClickListener(this);
        Button getData = findViewById(R.id.get_data);
        getData.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.add_data:
                Book book = new Book();
                book.setName("The Da Vinci Code");
                book.setAuthor("Dan Brown");
                book.setPages(454);
                book.setPrice(16.96);
                book.setPress("Unknown");
                book.save();
                break;
            case R.id.get_data:
                Book firstBook = LitePal.findFirst(Book.class);
                Toast.makeText(getApplicationContext(), firstBook, Toast.LENGTH_LONG).show();
                break;

        }
    }
}
