package com.finalproyect.medallium.ui.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.finalproyect.medallium.R;
import com.finalproyect.medallium.domain.entities.Elemento;
import com.google.android.material.card.MaterialCardView;

import java.util.List;

public class ElementosAdapter extends RecyclerView.Adapter<ElementosAdapter.ElementosViewHolder>{

    private List<Elemento> elementoList;
    private View elementoView;
    public ElementosAdapter(List<Elemento> elementoList){
        this.elementoList = elementoList;
    }

    @NonNull
    @Override
    public ElementosViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        elementoView = LayoutInflater.from(parent.getContext()).inflate(R.layout.elementos_cardview, parent, false);
        return new ElementosViewHolder(elementoView);
    }

    @Override
    public void onBindViewHolder(ElementosViewHolder holder, int position) {

        Elemento elemento = elementoList.get(position);
        holder.nombreElemento.setText(elemento.getNombre());
        holder.descripcionElemento.setText(elemento.getDescripcion());

        Glide.with(holder.itemView.getContext()).load(elemento.getImage()).into(holder.logoElemento);
        int idElemento = elemento.getId_Elemento();
        switch (idElemento){
            case 1:
                holder.elementoCardView.setStrokeColor(holder.itemView.getResources().getColor(R.color.elemento_hielo));
                break;
            case 2:
                holder.elementoCardView.setStrokeColor(holder.itemView.getResources().getColor(R.color.elemento_viento));
                break;
            case 3:
                holder.elementoCardView.setStrokeColor(holder.itemView.getResources().getColor(R.color.elemento_relampago));
                break;
            case 4:
                holder.elementoCardView.setStrokeColor(holder.itemView.getResources().getColor(R.color.elemento_absorcion));
                break;
            case 5:
                holder.elementoCardView.setStrokeColor(holder.itemView.getResources().getColor(R.color.elemento_sanacion));
                break;
            case 6:
                holder.elementoCardView.setStrokeColor(holder.itemView.getResources().getColor(R.color.elemento_agua));
                break;
            case 7:
                holder.elementoCardView.setStrokeColor(holder.itemView.getResources().getColor(R.color.elemento_fuego));
                break;
            case 8:
                holder.elementoCardView.setStrokeColor(holder.itemView.getResources().getColor(R.color.elemento_tierra));
                break;
            default:
                holder.elementoCardView.setStrokeColor(holder.itemView.getResources().getColor(R.color.black));
                break;
        }
    }

    @Override
    public int getItemCount() {
        return elementoList != null ? elementoList.size() : 0;
    }

    public static class ElementosViewHolder extends RecyclerView.ViewHolder{
        MaterialCardView elementoCardView = itemView.findViewById(R.id.card_view);
        TextView nombreElemento;
        TextView descripcionElemento;
        ImageView logoElemento;

        public ElementosViewHolder(View itemView) {
            super(itemView);
            nombreElemento = itemView.findViewById(R.id.elemento_nombre);
            descripcionElemento = itemView.findViewById(R.id.elemento_descripcion);
            logoElemento = itemView.findViewById(R.id.elemento_logo);
        }
    }
}
