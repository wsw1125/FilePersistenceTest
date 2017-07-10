package com.example.administrator.filepersistencetest;


import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity {
    private EditText edit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edit = (EditText) findViewById(R.id.edit);
        String inputText = edit.getText().toString();
        Button saveData = (Button) findViewById(R.id.save_data);
        Button restoreData = (Button) findViewById(R.id.restore_data);
        saveData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor = getSharedPreferences("data", MODE_PRIVATE).edit();
                editor.putString("name", "Toom");
                editor.putInt("age", 10);
                editor.putBoolean("选择", false);
                editor.apply();
            }
        });
        restoreData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences perfer = getSharedPreferences("data", MODE_PRIVATE);
                String name = perfer.getString("name", "");
                int age = perfer.getInt("age", 0);
                Boolean bol = perfer.getBoolean("选择", false);
                Log.d("MainActivity", "name is" + name);
                Log.d("MainActivity", "age is" + age);
                Log.d("MainActivity", "bol is" + bol);
            }
        });
    }


}
