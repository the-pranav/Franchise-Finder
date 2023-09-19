package com.example.franchiser;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class foodApdapter extends RecyclerView.Adapter<foodApdapter.foodViewHolder> {

    String[] data;
    public foodApdapter(String[] data){
        this.data = data;
    }
    @NonNull
    @Override
    public foodViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.list_item_layout,parent,false);
        return new foodViewHolder(view);
    }



    @Override
    public void onBindViewHolder(foodViewHolder holder, int position) {

        String title = data[position];
//        holder.imgIcon.setImageResource();
        holder.txtTitle.setText(title);

    }

    @Override
    public int getItemCount() {
        return data.length;
    }

    public class foodViewHolder extends RecyclerView.ViewHolder{
        ImageView imgIcon;
        TextView txtTitle;
//        CardView main_card;
       public foodViewHolder(@NonNull View itemView) {
           super(itemView);
           imgIcon = (ImageView) itemView.findViewById(R.id.imageView);
           txtTitle = (TextView) itemView.findViewById(R.id.titleTextView);
//           main_card = itemView.findViewById(R.id.main_card);
       }
   }
}
