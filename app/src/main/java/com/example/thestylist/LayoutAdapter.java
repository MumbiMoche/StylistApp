package com.example.thestylist;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class LayoutAdapter extends RecyclerView.Adapter<LayoutAdapter.LayoutAdapterHolder> {

    ArrayList<Integer> imageview;
    ArrayList<String> itemName;
    ArrayList<String> itemPrice;
    Context context;

    public LayoutAdapter(Context context, ArrayList<Integer> imageview, ArrayList<String> itemName, ArrayList<String> itemPrice) {
        this.imageview = imageview;
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.context = context;
    }

    public class LayoutAdapterHolder extends RecyclerView.ViewHolder{

        ImageView imageView;
        TextView name, price;

        public LayoutAdapterHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.image_girls);
            name = itemView.findViewById(R.id.item_name);
            price = itemView.findViewById(R.id.item_price);
        }
    }


    @NonNull
    @Override
    public LayoutAdapterHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_layout, parent, false);
        LayoutAdapterHolder layoutAdapterHolder = new LayoutAdapterHolder(view);
        return layoutAdapterHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull LayoutAdapterHolder holder, int position) {

        holder.imageView.setImageResource(imageview.get(position));
        holder.name.setText(itemName.get(position));
        holder.price.setText(itemPrice.get(position));

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "Clicked Item", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(context, ItemActivity.class);
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return itemName.size();
    }
}
