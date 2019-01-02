package com.derrick.park.assignment3_contacts.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.derrick.park.assignment3_contacts.R;

public class AddActivity extends AppCompatActivity {
    public static final String ADD_NAME= "ADDNAME";
    public static final String ADD_TEL = "ADDTEL";
    private EditText mNameText;
    private EditText mTelText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        mNameText = findViewById(R.id.nameText);
        mTelText = findViewById(R.id.telText);


    }


    public void addButtonOn(View view) {
        String addName = mNameText.getText().toString();
        String addTel = mTelText.getText().toString();

        Intent replyIntent = new Intent(this, MainActivity.class);
        replyIntent.putExtra(ADD_NAME, addName);
        replyIntent.putExtra(ADD_TEL, addTel);
        setResult(RESULT_OK, replyIntent);
        finish();
    }
}
