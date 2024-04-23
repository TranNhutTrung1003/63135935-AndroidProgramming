package com.tnt.ntu.viewmenu_bottomnavigation;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.zip.Inflater;

public class CustomerAdapter extends RecyclerView.Adapter<CustomerAdapter.CustomerHolder>{
    Context context;
    ArrayList<Customer> lsData;

    public CustomerAdapter(Context context, ArrayList<Customer> lsData) {
        this.context = context;
        this.lsData = lsData;
    }

    @NonNull
    @Override
    public CustomerHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.customer_item, parent, false);
        CustomerHolder customerHolder = new CustomerHolder(view);
        return customerHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CustomerHolder holder, int position) {
        Customer customer = lsData.get(position);
        String name = customer.getTenKH();
        int age = customer.getTuoi();
        String anh = customer.getAnhKH();
        holder.txtName.setText(name);
        holder.txtAge.setText(age);
        String packedName = holder.itemView.getContext().getPackageName();
        int anhID = holder.itemView.getResources().getIdentifier(anh, "mipmap", packedName);
        holder.txtAnh.setImageResource(anhID);
    }

    @Override
    public int getItemCount() {
        return lsData.size();
    }

    class CustomerHolder extends RecyclerView.ViewHolder{
        TextView txtName, txtAge;
        ImageView txtAnh;

        public CustomerHolder(@NonNull View itemView) {
            super(itemView);
            txtName = itemView.findViewById(R.id.txtName);
            txtAge = itemView.findViewById(R.id.txtAge);
            txtAnh = itemView.findViewById(R.id.ImageCustomer);
        }
    }
}
