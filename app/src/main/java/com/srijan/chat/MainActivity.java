package com.srijan.chat;

import android.os.Bundle;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
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

        String[] sourceNames = {"Srijan Mondal", "Sk Masum Ali", "Sk Arien Ahmed"};
        List<NameAdapter.Contact> contacts = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < 18; i++) {
            String name = sourceNames[i % sourceNames.length];
            String phone = "+91 " + (7000000000L + (long) (random.nextDouble() * 2999999999L));
            contacts.add(new NameAdapter.Contact(name, phone));
        }

        RecyclerView recyclerView = findViewById(R.id.namesRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new NameAdapter(contacts));
    }
}