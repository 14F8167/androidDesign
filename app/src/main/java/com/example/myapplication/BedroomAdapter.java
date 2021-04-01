package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class BedroomAdapter extends RecyclerView.Adapter<BedroomAdapter.CustomViewHolder> {

    Context context;
    List<BedroomUtil> bedroomUtilList;

    public BedroomAdapter() {
    }

    public BedroomAdapter(Context context, List<BedroomUtil> bedroomUtilList) {
        this.context = context;
        this.bedroomUtilList = bedroomUtilList;
    }

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.bedroom_item_layout,null);
        view.setLayoutParams(new RecyclerView.LayoutParams(RecyclerView.LayoutParams.WRAP_CONTENT, RecyclerView.LayoutParams.WRAP_CONTENT));
        BedroomAdapter.CustomViewHolder viewHolder = new BedroomAdapter.CustomViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {

        BedroomUtil bedroomUtil = bedroomUtilList.get(position);
        holder.sofa_name.setText(bedroomUtil.getName());
        holder.sofa_price.setText(bedroomUtil.getPrice());

        holder.sofa_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, DetailsActivity.class);
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return bedroomUtilList.size();
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder {

        TextView sofa_name, sofa_price;
        LinearLayout sofa_layout;

        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);
            sofa_name = itemView.findViewById(R.id.sofa_name);
            sofa_price = itemView.findViewById(R.id.sofa_price);
            sofa_layout = itemView.findViewById(R.id.sofa_layout);

        }
    }

}
