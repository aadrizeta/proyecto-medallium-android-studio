package com.finalproyect.medallium.ui.navMenu.home.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.finalproyect.medallium.Ejemplo;
import com.finalproyect.medallium.R;
import com.finalproyect.medallium.domain.entities.DetallesYokai;
import com.finalproyect.medallium.ui.views.YokaiView.VistaYokaiActivity;
import com.google.android.material.card.MaterialCardView;

import java.util.List;

public class YokaiAdapter extends RecyclerView.Adapter<YokaiAdapter.YokaiViewHolder> {

    private List<DetallesYokai> yokaiList;
    private View yokaiView;

    // Constructor que recibe la lista de Yokais
    public YokaiAdapter(List<DetallesYokai> yokaiList) {
        this.yokaiList = yokaiList;
    }

    @Override
    public YokaiViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // Inflar el layout para cada item
        yokaiView= LayoutInflater.from(parent.getContext())
                .inflate(R.layout.yokai_cardview, parent, false);
        return new YokaiViewHolder(yokaiView);
    }

    @Override
    public void onBindViewHolder(YokaiViewHolder holder, int position) {
        DetallesYokai yokai = yokaiList.get(position);
        Ejemplo ejemplo = new Ejemplo();

        holder.nombreYokai.setText(yokai.getYokai().getName());
        holder.nombreJapones.setText(yokai.getNombreJapo());

        Glide.with(holder.itemView.getContext())
                .load(yokai.getImage())
                .into(holder.yokaiImage);

        if (yokai.getYokai().getTribu() != null) {
            Glide.with(holder.itemView.getContext())
                    .load(yokai.getYokai().getTribu().getImagenPixel())
                    .into(holder.tribeIcon);
            int idTribu = yokai.getYokai().getTribu().getId_Tribu();
            ejemplo.setCardViewColor(holder.yokaiCardView, idTribu);
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
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Aquí podríamos lanzar un evento para seleccionar este yokai
                // o abrir una nueva activity con detalles del yokai seleccionado
                launchYokaiView(v.getContext(), yokai);

            }
        });
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
        MaterialCardView yokaiCardView = itemView.findViewById(R.id.card_view);
        ImageView favButton;


        public YokaiViewHolder(View itemView) {
            super(itemView);
            nombreYokai = itemView.findViewById(R.id.nombre_yokai);
            nombreJapones = itemView.findViewById(R.id.nombre_japones);
            yokaiImage = itemView.findViewById(R.id.yokai_image);
            tribeIcon = itemView.findViewById(R.id.tribe_icon);
            elementIcon = itemView.findViewById(R.id.element_icon);
            rankButton = itemView.findViewById(R.id.rank_button);
            favButton = itemView.findViewById(R.id.fav_button);
            favButton.setTag("black");
            favButton.setOnClickListener(v -> toggleFavButton(favButton));
        }
        //metodo toggleFavButton
        public void toggleFavButton(ImageView favButton) {
            if (favButton.getTag().equals("black")) {
                favButton.setImageResource(R.drawable.usable_icon_red_fav_icon);
                favButton.setTag("red");
            } else {
                favButton.setImageResource(R.drawable.usable_icon_favorite_heart);
                favButton.setTag("black");
            }
        }
    }

    public void setYokais(List<DetallesYokai> yokais) {
        this.yokaiList = yokais;
        notifyDataSetChanged();
    }
    private void launchYokaiView(Context context, DetallesYokai yokai){
        Intent intent = new Intent(context, VistaYokaiActivity.class);
        intent.putExtra("detallesYokai", yokai);
        context.startActivity(intent);
    }
}