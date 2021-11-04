package com.example.pertemuan_5;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList <Book> listBook;
    RecyclerView rvBook;
    BookAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listBook = new ArrayList<>();

        Book book1 = new Book("Harry Potter 1", "J.K Rowling", 10.3, R.drawable.book1);
//        book1.setTitle("Harry Potter 1");
//        book1.setAuthor("J.K Rowling");
//        book1.setPrice(10.3);
//        book1.setThumbnail(R.drawable.book1);

        Book book2 = new Book("Harry Potter 2", "J.K Rowling", 9.9, R.drawable.book2);
//        book2.setTitle("Harry Potter 2");
//        book2.setAuthor("J.K Rowling");
//        book2.setPrice(10.9);
//        book2.setThumbnail(R.drawable.book2);

        listBook.add(book1);
        listBook.add(book2);

        rvBook = findViewById(R.id.rvBook);

        // Linear Layout
        rvBook.setLayoutManager(new LinearLayoutManager(this));

        // Grid Layout
//        rvBook.setLayoutManager(new GridLayoutManager(this, 3));

        // Staggered layout
//        rvBook.setLayoutManager(new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL));

        adapter = new BookAdapter(this, listBook);
        rvBook.setAdapter(adapter);
    }
}