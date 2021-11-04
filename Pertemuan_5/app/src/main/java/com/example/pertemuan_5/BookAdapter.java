package com.example.pertemuan_5;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class BookAdapter extends RecyclerView.Adapter <BookAdapter.ViewHolder>{

    Context context;
    ArrayList<Book> listBook;

    BookAdapter(Context context, ArrayList<Book> listBook){
        this.context = context;
        this.listBook = listBook;
    }

    @NonNull
    @Override
    //  menampilkan tampilan layout di activity
    public BookAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_item_book, parent, false);
        return new ViewHolder(view);
    }

    // menghubungkan data dan view
    @Override
    public void onBindViewHolder(@NonNull BookAdapter.ViewHolder holder, int position) {
        Book book = listBook.get(position);
        holder.itemThumbnail.setImageResource(book.thumbnail);
        holder.itemTitle.setText(book.title);
    }

    @Override
    public int getItemCount() {
        return listBook.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView itemThumbnail;
        TextView itemTitle;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            itemThumbnail = itemView.findViewById(R.id.itemThumbnail);
            itemTitle = itemView.findViewById(R.id.itemTitle);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int position = getAdapterPosition();
            Book book = listBook.get(position);
            Toast.makeText(context, "Author : " + book.getAuthor() + "/nPrice : " + book.getPrice(), Toast.LENGTH_SHORT).show();
        }
    }
}
