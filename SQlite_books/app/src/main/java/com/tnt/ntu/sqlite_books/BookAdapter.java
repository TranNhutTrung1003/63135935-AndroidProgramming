package com.tnt.ntu.sqlite_books;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class BookAdapter extends RecyclerView.Adapter<BookAdapter.BookHolder> {

    ArrayList<Book> lsData;
    Context context;

    public BookAdapter(ArrayList<Book> lsData, Context context) {
        this.lsData = lsData;
        this.context = context;
    }

    @NonNull
    @Override
    public BookHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.item_book, parent, false);
        BookHolder bookHolder = new BookHolder(view);
        return bookHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull BookHolder holder, int position) {
        Book book = lsData.get(position);

        String name = book.getBookName().toString();
        String decription = book.getDescription().toString();

        holder.txtName.setText(name);
        holder.txtPage.setText(String.valueOf(book.getPage()));
        holder.txtId.setText(String.valueOf(book.getBookID()));
        holder.txtPrice.setText(String.valueOf(book.getPrice()));
        holder.txtDecription.setText(decription);
    }

    @Override
    public int getItemCount() {
        return lsData.size();
    }

    class BookHolder extends RecyclerView.ViewHolder{
        TextView txtName, txtPrice, txtDecription, txtId, txtPage;

        public BookHolder(@NonNull View itemView) {
            super(itemView);
            txtName = itemView.findViewById(R.id.txtName);
            txtId = itemView.findViewById(R.id.txtID);
            txtPrice = itemView.findViewById(R.id.txtPrice);
            txtDecription = itemView.findViewById(R.id.txtDecription);
            txtPage = itemView.findViewById(R.id.txtPage);
        }
    }
}
