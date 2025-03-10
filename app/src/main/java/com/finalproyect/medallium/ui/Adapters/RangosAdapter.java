package com.finalproyect.medallium.ui.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.finalproyect.medallium.Ejemplo;
import com.finalproyect.medallium.R;
import com.finalproyect.medallium.domain.entities.Rango;
import com.google.android.material.card.MaterialCardView;

import java.util.List;

public class RangosAdapter extends RecyclerView.Adapter<RangosAdapter.RangosViewHolder>{

    private List<Rango> rangoList;
    private View rangoView;
    public RangosAdapter(List<Rango> rangoList){
        this.rangoList = rangoList;
    }

    @NonNull
    @Override
    public RangosViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        rangoView = LayoutInflater.from(parent.getContext()).inflate(R.layout.rangos_cardview, parent, false);
        return new RangosViewHolder(rangoView);
    }

    @Override
    public void onBindViewHolder(RangosViewHolder holder, int position) {

        Ejemplo ejemplo = new Ejemplo();
        Rango rango = rangoList.get(position);
        holder.nombreRango.setText(rango.getName());
        holder.descripcionRango.setText(rango.getDescripcion());
        holder.caracteristicasRango.setText(rango.getCaracteristicasGenerales());
        holder.tipoBonusRango.setText(rango.getTipoBonus());

        Glide.with(holder.itemView.getContext()).load(rango.getImage()).into(holder.logoRango);
        int idRango = rango.getId_Rango();
        switch (idRango){
            case 1:
                holder.rangoCardView.setStrokeColor(holder.itemView.getResources().getColor(R.color.elemento_sanacion));
                break;
            case 2:
                holder.rangoCardView.setStrokeColor(holder.itemView.getResources().getColor(R.color.elemento_relampago));
                break;
            case 3:
                holder.rangoCardView.setStrokeColor(holder.itemView.getResources().getColor(R.color.elemento_hielo));
                break;
            case 4:
                holder.rangoCardView.setStrokeColor(holder.itemView.getResources().getColor(R.color.elemento_tierra));
                break;
            case 5:
                holder.rangoCardView.setStrokeColor(holder.itemView.getResources().getColor(R.color.elemento_agua));
                break;
            case 6:
                holder.rangoCardView.setStrokeColor(holder.itemView.getResources().getColor(R.color.elemento_absorcion));
                break;
        }
        holder.clickable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ejemplo.launchListView(v.getContext(), "rango", idRango);
            }
        });
    }

    @Override
    public int getItemCount() {
        return rangoList != null ? rangoList.size() : 0;
    }

    public static class RangosViewHolder extends RecyclerView.ViewHolder{
        MaterialCardView rangoCardView = itemView.findViewById(R.id.card_view_tribu);
        TextView nombreRango;
        TextView descripcionRango;
        TextView caracteristicasRango;
        TextView tipoBonusRango;
        ImageView logoRango;
        TextView clickable;

        public RangosViewHolder(View itemView) {
            super(itemView);
            nombreRango = itemView.findViewById(R.id.rango_nombre);
            descripcionRango = itemView.findViewById(R.id.rango_descripcion);
            caracteristicasRango = itemView.findViewById(R.id.rango_caracteristicas);
            tipoBonusRango = itemView.findViewById(R.id.rango_tipoBonus);
            logoRango = itemView.findViewById(R.id.rango_logo);
            clickable = itemView.findViewById(R.id.rango_clickable);
        }
    }
}
