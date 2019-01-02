package com.derrick.park.assignment3_contacts.activities;

import android.content.Intent;
import android.graphics.PathEffect;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.derrick.park.assignment3_contacts.R;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AddActivity extends AppCompatActivity {
    public static final String ADD_NAME= "ADDNAME";
    public static final String ADD_TEL = "ADDTEL";
    private EditText mNameText;
    private EditText mTelText;
    private Button mAddButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        mNameText = findViewById(R.id.nameText);
        mTelText = findViewById(R.id.telText);
        mAddButton = findViewById(R.id.addButton);

    }


    public void addButtonOn(View view) {
        String addName = mNameText.getText().toString();
        String addTel = mTelText.getText().toString();

        Pattern patternName = Pattern.compile("^[A-Z][a-z]*\\s[A-Z][a-z]*$");
        Pattern patternPhone = Pattern.compile("^\\d{10}$");

        Matcher matcherName = patternName.matcher(addName);
        Matcher matcherPhone = patternPhone.matcher(addTel);

        if (matcherName.find() && matcherPhone.find()) {
            Intent replyIntent = new Intent(this, MainActivity.class);
            replyIntent.putExtra(ADD_NAME, addName);
            replyIntent.putExtra(ADD_TEL, addTel);
            setResult(RESULT_OK, replyIntent);
            finish();
        } else if (matcherName.find()) {
            Toast.makeText(this, "Enter 10degits Number", Toast.LENGTH_SHORT).show();
        } else if (matcherPhone.find()) {
            Toast.makeText(this,
                    "Enter Name" +
                            "\n(First letter should be Capital and needs space between First name and Last name)" +
                            "\n e.g.\"Steven Jobs\"", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this, "Enter Name(First letter should be Capital) and 10degits Number", Toast.LENGTH_SHORT).show();
        }



    }
}
