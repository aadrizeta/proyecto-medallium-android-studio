package com.finalproyect.medallium;

import android.app.Activity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.card.MaterialCardView;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;

public class Ejemplo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_ejemplo);

        LinearLayout mainContainer = findViewById(R.id.mainContainer);
        LayoutInflater inflater = LayoutInflater.from(this);

        View cardView = inflater.inflate(R.layout.yokai_cardview, mainContainer, false);

        ImageView yokaiImage = cardView.findViewById(R.id.yokai_image);
        yokaiImage.setImageResource(R.drawable.image8);

        TextView nombreYokai = cardView.findViewById(R.id.nombre_yokai);
        nombreYokai.setText("Jibanyan");

        TextView nombreJapones = cardView.findViewById(R.id.nombre_japones);
        nombreJapones.setText("ジバニャン");

        ImageView tribeIcon = cardView.findViewById(R.id.tribe_icon);
        ImageView elementIcon = cardView.findViewById(R.id.element_icon);
        ImageView rankButton = cardView.findViewById(R.id.rank_button);

        ImageView favButton = cardView.findViewById(R.id.fav_button);
        favButton.setTag("black");

        favButton.setOnClickListener(v -> toggleFavButton(favButton));

        tribeIcon.setImageResource(R.drawable.tribe_icon_small_guapo);
        elementIcon.setImageResource(R.drawable.image22);
        rankButton.setImageResource(R.drawable.image23);

        mainContainer.addView(cardView);

        cardView.setOnClickListener(v -> {
            // Inflar cardView2 dentro del listener
            View cardView2 = inflater.inflate(R.layout.tribu_descripcion_cardview, null, false);
            ImageView cerrar = cardView2.findViewById(R.id.close);
            TextView descripcion = cardView2.findViewById(R.id.tribu_descripcion);
            descripcion.setMovementMethod(new ScrollingMovementMethod());

            // Construcción del diálogo
            AlertDialog alertDialog = new MaterialAlertDialogBuilder(Ejemplo.this)
                    .setView(cardView2)
                    .create();
            alertDialog.show();

            // Cierra el diálogo al hacer clic en el botón cerrar
            cerrar.setOnClickListener(v1 -> alertDialog.dismiss());
        });
    }

    public void toggleFavButton(ImageView favButton) {
        if (favButton.getTag().equals("black")) {
            favButton.setImageResource(R.drawable.usable_icon_red_fav_icon);
            favButton.setTag("red");
        } else {
            favButton.setImageResource(R.drawable.usable_icon_favorite_heart);
            favButton.setTag("black");
        }
    }
    public static void regresar(Activity activity){
        activity.finish();
    }
    //metodo para cambiar los bordes de un cardView segun id de tribu
    public void setCardViewColor(MaterialCardView cardView, int idTribu){
        switch (idTribu){
            case 2:
                cardView.setStrokeColor(cardView.getResources().getColor(R.color.tribu_color_guapo));
                break;
            case 3:
                cardView.setStrokeColor(cardView.getResources().getColor(R.color.tribu_color_valiente));
                break;
            case 4:
                cardView.setStrokeColor(cardView.getResources().getColor(R.color.tribu_color_misterioso));
                break;
            case 5:
                cardView.setStrokeColor(cardView.getResources().getColor(R.color.tribu_color_robusto));
                break;
            case 6:
                cardView.setStrokeColor(cardView.getResources().getColor(R.color.tribu_color_oscuro));
                break;
            case 7:
                cardView.setStrokeColor(cardView.getResources().getColor(R.color.tribu_color_siniestro));
                break;
            case 8:
                cardView.setStrokeColor(cardView.getResources().getColor(R.color.tribu_color_amable));
                break;
            case 9:
                cardView.setStrokeColor(cardView.getResources().getColor(R.color.tribu_color_maléfico));
                break;
            case 10:
                cardView.setStrokeColor(cardView.getResources().getColor(R.color.tribu_color_escurridiza));
                break;
            default:
                cardView.setStrokeColor(cardView.getResources().getColor(R.color.black));

        }
    }
}
