package com.example.franchiser;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.franchiser.R;

import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    private List<Item> itemList;
    private List<Item> filteredList; // Add this list to store filtered items

    Context context;
    public MyAdapter(List<Item> itemList, Context context) {
        this.itemList = itemList;
        this.context = context;
        this.filteredList = new ArrayList<>(itemList); // Initialize filtered list
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView titleTextView;
        public ImageView imageView;

        public ViewHolder(View view) {
            super(view);
            titleTextView = view.findViewById(R.id.titleTextView);
            imageView = view.findViewById(R.id.imageView);
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Item item = filteredList.get(position); // Use filtered list
        holder.titleTextView.setText(item.getTitle());
        holder.imageView.setImageResource(item.getImageResource());

        holder.titleTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(context, new_layout.class);
                intent.putExtra("Imagename",item.getImageResource());
                intent.putExtra("Title",item.getTitle());

                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return filteredList.size(); // Use filtered list size
    }

    // Add this method to update the filtered list
    public void filterList(List<Item> filteredItems) {
        filteredList = filteredItems;
        notifyDataSetChanged();
    }
}
