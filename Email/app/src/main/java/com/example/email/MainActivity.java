package com.example.email;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;


import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<EmailModel> items;
    EditText editText;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        items = new ArrayList<>();

//        items.add(new EmailModel("A", "Van An", "Hello", "How are you?", "8:00AM"));
        for(int i =0; i<15;i++){
            items.add(new EmailModel("N", "Name"+i, "Aloha!", "Chao em, anh dung day tu chieu","8:00AM"));
        }

        final EmailAdapter adapter = new EmailAdapter(items);
        ListView listView = findViewById(R.id.list_view);
        listView.setAdapter(adapter);

        editText = findViewById(R.id.text_search);
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                adapter.filtered(filter(s.toString()));
                filter(s.toString());
            }
        });

        btn = findViewById(R.id.btn_favourite);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<EmailModel> filterList1 = new ArrayList<>();
                for(EmailModel item: items){
                    if(item.isIsfavourite() == true){
                        filterList1.add(item);
                    }
                }
                adapter.filtered(filterList1);
            }
        });
    }

    private List<EmailModel> filter(String toString) {
        ArrayList<EmailModel> filterList = new ArrayList<>();
        for (EmailModel item : items) {
            if (item.getName().toLowerCase().contains(toString.toLowerCase())) {
                filterList.add(item);
            }
            if (item.getSubject().toLowerCase().contains(toString.toLowerCase())) {
                filterList.add(item);
            }
            if (item.getContent().toLowerCase().contains(toString.toLowerCase())) {
                filterList.add(item);
            }
        }

        return filterList;
    }
}