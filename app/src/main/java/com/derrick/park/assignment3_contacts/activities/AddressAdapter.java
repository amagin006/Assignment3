package com.derrick.park.assignment3_contacts.activities;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.derrick.park.assignment3_contacts.R;
import com.derrick.park.assignment3_contacts.models.Contact;

import java.util.ArrayList;

public class AddressAdapter extends RecyclerView.Adapter<AddressAdapter.AddressViewHolder> {

    private Context mContext;
    private LayoutInflater mInflater;
    private ArrayList<Contact> mContactList;


    public AddressAdapter(Context context, ArrayList<Contact> contactArrayList) {
        this.mInflater = LayoutInflater.from(context);
        this.mContactList = contactArrayList;
        this.mContext = context;
    }

    @NonNull
    @Override
    public AddressViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View mItemView = mInflater.inflate(R.layout.contact_item, viewGroup, false);
        return new AddressViewHolder(mItemView);
    }

    @Override
    public void onBindViewHolder(@NonNull AddressViewHolder holder, int position) {
        holder.mAddressTextName.setText(mContactList.get(position).getName().toString());
        holder.mAddressTextPhoneNumber.setText(mContactList.get(position).getCell());
    }

    @Override
    public int getItemCount() { return mContactList.size();}

    public class AddressViewHolder extends RecyclerView.ViewHolder{
        public final TextView mAddressTextName;
        public final TextView mAddressTextPhoneNumber;

        public AddressViewHolder(View itemView){
            super(itemView);
            mAddressTextName = itemView.findViewById(R.id.name);
            mAddressTextPhoneNumber = itemView.findViewById(R.id.phone_number);

        }
    }
}
