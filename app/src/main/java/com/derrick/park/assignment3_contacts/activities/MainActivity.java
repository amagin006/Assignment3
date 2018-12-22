package com.derrick.park.assignment3_contacts.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.derrick.park.assignment3_contacts.R;
import com.derrick.park.assignment3_contacts.models.Contact;
import com.derrick.park.assignment3_contacts.models.ContactList;
import com.derrick.park.assignment3_contacts.network.ContactClient;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private ArrayList<Contact> mContactList;
    private RecyclerView mRecycleView;
    private AddressAdapter mAdapter;

    public static final String TAG = MainActivity.class.getSimpleName();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Call<ContactList> call = ContactClient.getContacts(40);

        call.enqueue(new Callback<ContactList>() {
            @Override
            public void onResponse(Call<ContactList> call, Response<ContactList> response) {
                if (response.isSuccessful()) {
                     mContactList = response.body().getContactList();
                     for(Contact contact: mContactList) {
                         Log.d(TAG, "onResponse: " + mContactList.size());
                         Log.d(TAG, "onResponse: " + contact);
                     }
                    setActivity(mContactList);
                }
            }

            @Override
            public void onFailure(Call<ContactList> call, Throwable t) {
                // Error Handling

            }
        });

    }

    public void setActivity(final ArrayList<Contact> contacts){

        Collections.sort(mContactList, new Comparator<Contact>() {
            @Override
            public int compare(Contact o1, Contact o2) {
                return o1.getName().getFirst().compareTo(o2.getName().getFirst());
            }
        });

        mRecycleView = findViewById(R.id.recycleview);
        mAdapter = new AddressAdapter(this, contacts);
        mRecycleView.setAdapter(mAdapter);
        mRecycleView.setLayoutManager(new LinearLayoutManager(MainActivity.this));

    }



}
