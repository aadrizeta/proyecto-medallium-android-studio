package com.finalproyect.medallium;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.card.MaterialCardView;

public class Ejemplo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_ejemplo);

        LinearLayout mainContainer = findViewById(R.id.mainContainer);

        LayoutInflater inflater = LayoutInflater.from(this);
        View cardView = inflater.inflate(R.layout.yokai_cardview, mainContainer, false);

        MaterialCardView yokaiCardView = cardView.findViewById(R.id.card_view);
        yokaiCardView.setStrokeColor(getResources().getColor(R.color.tribu_color_guapo));

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

        favButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toggleFavButton(favButton);
            }
        });

        tribeIcon.setImageResource(R.drawable.tribe_icon_small_guapo);
        elementIcon.setImageResource(R.drawable.image22);
        rankButton.setImageResource(R.drawable.image23);

        mainContainer.addView(cardView);
    }
    public void toggleFavButton(ImageView favButton){
        if (favButton.getTag().equals("black")){
            favButton.setImageResource(R.drawable.usable_icon_red_fav_icon);
            favButton.setTag("red");
        } else {
            favButton.setImageResource(R.drawable.usable_icon_favorite_heart);
            favButton.setTag("black");
        }
    }
}