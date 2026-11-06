package com.example.clv_ds7;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class BookAdapter extends ArrayAdapter<Book> {

    Context context;
    public BookAdapter(@NonNull Context context, int resource, @NonNull ArrayList<Book> objects) {
        super(context, resource, objects);
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View myView;
        if(convertView == null)
        {
            myView = LayoutInflater.from(context).inflate(R.layout.custom_item_design_lv, parent, false);
        }
        else
        {
            myView = convertView;
        }

        TextView tvId = myView.findViewById(R.id.tvBookId);
        TextView tvName = myView.findViewById(R.id.tvBookName);
        TextView tvAuthor = myView.findViewById(R.id.tvBookAuthorName);

        Book book = getItem(position);
        tvId.setText(String.valueOf(book.getId()));
        tvName.setText(book.getName());
        tvAuthor.setText(book.getAuthor());

        myView.setOnClickListener((v)->{
            Toast.makeText(context, "Clicked: "+book.getAuthor(), Toast.LENGTH_SHORT).show();
        });

        return myView;
    }
}
