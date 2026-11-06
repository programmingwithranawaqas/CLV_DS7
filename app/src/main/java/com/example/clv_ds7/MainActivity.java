package com.example.clv_ds7;

import android.os.Bundle;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<Book> books;
    ListView lvBooks;
    BookAdapter bookAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        init();
    }
    private void init()
    {
        books = new ArrayList<>();
        books.add(new Book(1, "PF", "Kashif Zafar"));
        books.add(new Book(2, "OOP", "Aamir Wali"));
        books.add(new Book(3, "DSA", "Rana Waqas Ali"));

        lvBooks = findViewById(R.id.lvBooks);

        bookAdapter = new BookAdapter(this, 0, books);

        lvBooks.setAdapter(bookAdapter);

    }

}