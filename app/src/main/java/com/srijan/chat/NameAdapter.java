package com.srijan.chat;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class NameAdapter extends RecyclerView.Adapter<NameAdapter.ViewHolder> {
    public static class Contact {
        String name;
        String phone;
        Contact(String name, String phone) {
            this.name = name;
            this.phone = phone;
        }
    }

    private final List<Contact> contacts;

    public NameAdapter(List<Contact> contacts) {
        this.contacts = contacts;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_name, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Contact contact = contacts.get(position);
        holder.nameText.setText(contact.name);
        holder.phoneText.setText(contact.phone);
        holder.itemView.setOnClickListener(v -> 
            Toast.makeText(v.getContext(), "Calling " + contact.name, Toast.LENGTH_SHORT).show()
        );
    }

    @Override
    public int getItemCount() {
        return contacts.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView nameText;
        TextView phoneText;
        ViewHolder(View view) {
            super(view);
            nameText = view.findViewById(R.id.nameText);
            phoneText = view.findViewById(R.id.phoneText);
        }
    }
}