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

public class BoysAdaptor extends RecyclerView.Adapter<BoysAdaptor.BoysAdaptorHolder> {
    ArrayList<Integer> images;
    ArrayList<String> name;
    ArrayList<String> price;

    private Context context;

    public BoysAdaptor(Context context, ArrayList<Integer> images, ArrayList<String> name, ArrayList<String> price) {
        this.images = images;
        this.name = name;
        this.price = price;
        this.context = context;
    }

    public class BoysAdaptorHolder extends RecyclerView.ViewHolder{

        private ImageView imageView;
        private TextView itemName;
        private TextView itemPrice;

        public BoysAdaptorHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.image_girls);
            itemName = itemView.findViewById(R.id.item_name);
            itemPrice= itemView.findViewById(R.id.item_price);
        }
    }
    @NonNull
    @Override
    public BoysAdaptorHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_layout, parent, false);
        BoysAdaptorHolder layoutAdapterHolder = new BoysAdaptorHolder(view);
        return layoutAdapterHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull BoysAdaptorHolder holder, int position) {

        holder.imageView.setImageResource(images.get(position));
        holder.itemName.setText(name.get(position));
        holder.itemPrice.setText(price.get(position));

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
        return name.size();
    }
}
