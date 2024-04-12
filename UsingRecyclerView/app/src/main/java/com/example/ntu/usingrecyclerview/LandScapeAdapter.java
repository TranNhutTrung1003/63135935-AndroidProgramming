package com.example.ntu.usingrecyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class LandScapeAdapter extends RecyclerView.Adapter<LandScapeAdapter.ItemLandHolder> {

    Context context;
    ArrayList<LandScape> lstData;

    public LandScapeAdapter(Context context, ArrayList<LandScape> lstData) {
        this.context = context;
        this.lstData = lstData;
    }

    @NonNull
    @Override
    public ItemLandHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.item_landscape, parent, false);
        ItemLandHolder viewHolder = new ItemLandHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ItemLandHolder holder, int position) {
        LandScape landScapeHienThi = lstData.get(position);
        String cation = landScapeHienThi.getLandscapeName();
        String tenFileAnh = landScapeHienThi.getLandscapeImage();

        holder.textViewCation.setText(cation);
        String packageName = holder.itemView.getContext().getPackageName();
        int imageId = holder.itemView.getResources().getIdentifier(tenFileAnh, "mipmap", packageName);
        holder.imageViewLandScape.setImageResource(imageId);
    }

    @Override
    public int getItemCount() {
        return lstData.size();
    }

    public class ItemLandHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView textViewCation;
        ImageView imageViewLandScape;

        public ItemLandHolder(@NonNull View itemView) {
            super(itemView);
            textViewCation = itemView.findViewById(R.id.textViewCation);
            imageViewLandScape = itemView.findViewById(R.id.imageViewLand);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int clickedPosition = getAdapterPosition();
            LandScape land = lstData.get(clickedPosition);
            Toast.makeText(v.getContext(), "Bạn đã nhấn vào " + land.getLandscapeName(), Toast.LENGTH_SHORT).show();
        }
    }
}
