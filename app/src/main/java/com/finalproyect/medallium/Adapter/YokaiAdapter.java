package com.finalproyect.medallium.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.finalproyect.medallium.R;
import com.finalproyect.medallium.domain.entities.DetallesYokai;

import java.util.List;

public class YokaiAdapter extends RecyclerView.Adapter<YokaiAdapter.YokaiViewHolder> {

    private List<DetallesYokai> yokaiList;

    // Constructor que recibe la lista de Yokais
    public YokaiAdapter(List<DetallesYokai> yokaiList) {
        this.yokaiList = yokaiList;
    }

    @Override
    public YokaiViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // Inflar el layout para cada item
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.yokai_cardview, parent, false);
        return new YokaiViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(YokaiViewHolder holder, int position) {
        DetallesYokai yokai = yokaiList.get(position);

        holder.nombreYokai.setText(yokai.getYokai().getName());
        holder.nombreJapones.setText(yokai.getNombreJapo());

        Glide.with(holder.itemView.getContext())
                .load(yokai.getImage())
                .into(holder.yokaiImage);

        if (yokai.getYokai().getTribu() != null) {
            Glide.with(holder.itemView.getContext())
                    .load(yokai.getYokai().getTribu().getImagenPixel())
                    .into(holder.tribeIcon);
        }

        if (yokai.getYokai().getElemento() != null) {
            Glide.with(holder.itemView.getContext())
                    .load(yokai.getYokai().getElemento().getImage())
                    .into(holder.elementIcon);
        }

        if (yokai.getYokai().getRango() != null) {
            Glide.with(holder.itemView.getContext())
                    .load(yokai.getYokai().getRango().getImage())
                    .into(holder.rankButton);
        }
    }

    @Override
    public int getItemCount() {
        return yokaiList != null ? yokaiList.size() : 0;
    }

    public static class YokaiViewHolder extends RecyclerView.ViewHolder {
        TextView nombreYokai;
        TextView nombreJapones;
        ImageView yokaiImage;
        ImageView tribeIcon;
        ImageView elementIcon;
        ImageView rankButton;

        public YokaiViewHolder(View itemView) {
            super(itemView);
            nombreYokai = itemView.findViewById(R.id.nombre_yokai);
            nombreJapones = itemView.findViewById(R.id.nombre_japones);
            yokaiImage = itemView.findViewById(R.id.yokai_image);
            tribeIcon = itemView.findViewById(R.id.tribe_icon);
            elementIcon = itemView.findViewById(R.id.element_icon);
            rankButton = itemView.findViewById(R.id.rank_button);
        }
    }

    public void setYokais(List<DetallesYokai> yokais) {
        this.yokaiList = yokais;
        notifyDataSetChanged();
    }
}