package com.finalproyect.medallium.ui.Adapters;

import android.content.Context;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.finalproyect.medallium.Ejemplo;
import com.finalproyect.medallium.R;
import com.finalproyect.medallium.domain.entities.Tribus;
import com.google.android.material.card.MaterialCardView;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;

import java.util.List;

public class TribuAdapter  extends RecyclerView.Adapter<TribuAdapter.TribusViewHolder> {

    private List<Tribus> tribuList;
    private View tribuView;
    private AlertDialog alertDialog;

    public TribuAdapter(List<Tribus> tribuList) {
        this.tribuList = tribuList;
    }

    @NonNull
    @Override
    public TribusViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        tribuView = LayoutInflater.from(parent.getContext()).inflate(R.layout.tribus_cardview, parent, false);
        return new TribusViewHolder(tribuView);
    }

    @Override
    public void onBindViewHolder(TribusViewHolder holder, int position) {
        Ejemplo ejemplo = new Ejemplo();

        Tribus tribu = tribuList.get(position);

        holder.nombreTribu.setText(tribu.getNombre());
        holder.nombreJapones.setText(tribu.getNombreJapones());

        Glide.with(holder.itemView.getContext()).load(tribu.getImage()).into(holder.logoTribu);

        int idTribu = tribu.getId_Tribu();

        ejemplo.setCardViewColor(holder.tribuCardView, idTribu);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mostrarInfo(holder.itemView.getContext(), tribu);
            }
        });
    }

    @Override
    public int getItemCount() {
        return tribuList != null ? tribuList.size() : 0;
    }

    public static class TribusViewHolder extends RecyclerView.ViewHolder{

        MaterialCardView tribuCardView = itemView.findViewById(R.id.card_view);
        TextView nombreTribu;
        TextView nombreJapones;
        ImageView logoTribu;
        ImageView cerrarModal;

        public TribusViewHolder(View itemView) {
            super(itemView);
            nombreTribu = itemView.findViewById(R.id.nombre_tribu);
            nombreJapones = itemView.findViewById(R.id.nombre_japones);
            logoTribu = itemView.findViewById(R.id.tribu_logo);
            cerrarModal = itemView.findViewById(R.id.close);
        }
    }

    private void mostrarInfo(Context context, Tribus tribu){
        Ejemplo ejemplo = new Ejemplo();
        LayoutInflater inflater = LayoutInflater.from(context);
        View tribuView = inflater.inflate(R.layout.tribu_descripcion_cardview, null, false);
        MaterialCardView cardView = tribuView.findViewById(R.id.tribus_descripcion);
        TextView nombreTribu = tribuView.findViewById(R.id.nombre_tribu);
        TextView cualidadPrincipal = tribuView.findViewById(R.id.cualidad_principal);
        TextView tipoBonus = tribuView.findViewById(R.id.caracteristicas);
        ImageView logoTribu = tribuView.findViewById(R.id.tribu_logo);
        ImageView cerrarModal = tribuView.findViewById(R.id.close);
        TextView descripcionTribu = tribuView.findViewById(R.id.tribu_descripcion);
        descripcionTribu.setMovementMethod(new ScrollingMovementMethod());

        ejemplo.setCardViewColor(cardView, tribu.getId_Tribu());

        cerrarModal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (alertDialog != null && alertDialog.isShowing()) {
                    alertDialog.dismiss();
                }
            }
        });

        nombreTribu.setText("Tribu " + tribu.getNombre());
        cualidadPrincipal.setText("Los Yo-kai de esta tribu: " + tribu.getCaracteristicasGenerales());
        tipoBonus.setText("Cualidad principal: " + tribu.getTipoBonus() + ".");
        Glide.with(context).load(tribu.getImage()).into(logoTribu);
        descripcionTribu.setText(tribu.getDescripcion());

        alertDialog = new MaterialAlertDialogBuilder(context)
                .setView(tribuView)
                .create();
        alertDialog.show();
    }
}
