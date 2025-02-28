package com.finalproyect.medallium.ui.views.YokaiView;

import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.viewpager2.widget.ViewPager2;

import com.bumptech.glide.Glide;
import com.finalproyect.medallium.R;
import com.finalproyect.medallium.domain.entities.DetallesYokai;
import com.finalproyect.medallium.ui.views.YokaiView.tabbedViews.adapter.ViewPagerAdapter;
import com.finalproyect.medallium.ui.views.YokaiView.tabbedViews.fragments.DescripcionYokai;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class VistaYokaiActivity extends AppCompatActivity {

    private ImageView yokaiCircle;
    private ViewPagerAdapter adapter;
    private ViewPager2 viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_vista_yokai);

        TabLayout tabLayout = findViewById(R.id.tab_layout);
        viewPager = findViewById(R.id.viewPager);

        TextView nombreYokai = findViewById(R.id.nombre_yokai);
        TextView nombreJapones = findViewById(R.id.nombre_yokai_japones);
        ImageView imagenYokai = findViewById(R.id.imagen_yokai);
        ImageView tribeIcon = findViewById(R.id.tribe_icon);

        ImageView botonAtras = findViewById(R.id.go_back_button);
        botonAtras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                VistaYokaiActivity.this.finish();
            }
        });
        ImageView favButton = findViewById(R.id.add_fav_button);
        favButton.setTag("black");
        favButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toggleFavButton(favButton);
            }
        });
        ImageView botonAgregar = findViewById(R.id.add_button);
        botonAgregar.setTag("black");
        botonAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(VistaYokaiActivity.this, "Agregado a la lista", Toast.LENGTH_SHORT).show();
                toggleAddButton(botonAgregar);
            }
        });



        yokaiCircle = findViewById(R.id.background_circle);

        TextView nombreElemento = findViewById(R.id.nombre_elemento);
        ImageView imagenElemento = findViewById(R.id.imagen_elemento);

        ImageView imagenRango = findViewById(R.id.imagen_rango);

        DetallesYokai yokai = (DetallesYokai) getIntent().getSerializableExtra("detallesYokai");
        String dbComidas = yokai.getComida();
        String[] comidas = dbComidas.split(", ");

        int idTribu = yokai.getYokai().getTribu().getId_Tribu();
        changeCircleColor(idTribu);

        nombreYokai.setText(yokai.getYokai().getName());
        nombreJapones.setText(yokai.getNombreJapo());
        nombreElemento.setText(yokai.getYokai().getElemento().getNombre());

        Glide.with(this).load(yokai.getImage()).into(imagenYokai);
        Glide.with(this).load(yokai.getYokai().getTribu().getImagenPixel()).into(tribeIcon);
        Glide.with(this).load(yokai.getYokai().getElemento().getImage()).into(imagenElemento);
        Glide.with(this).load(yokai.getYokai().getRango().getImage()).into(imagenRango);

        adapter = new ViewPagerAdapter(this);
        viewPager.setAdapter(adapter);

        new TabLayoutMediator(tabLayout, viewPager, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                switch (position) {
                    case 0:
                        tab.setText("Descripción");
                        break;
                    case 1:
                        tab.setText("Estadísticas");
                        break;
                    case 2:
                        tab.setText("Fusiones");
                        break;
                    default:
                        tab.setText("Descripción");
                        break;
                }
            }
        }).attach();
        viewPager.post(() ->{
            DescripcionYokai descripcionYokai = (DescripcionYokai) adapter.getRegisteredFragment(0);
            if (descripcionYokai != null){
                descripcionYokai.setDescripcion(yokai.getDescripcion());
                descripcionYokai.setMedallaImage(yokai.getMedalla());
                descripcionYokai.setComidaYkw1(comidas[0]);
                descripcionYokai.setComidaYkw2(comidas[1]);
                descripcionYokai.setComidaYkw3(comidas[2]);
            } else {
                Toast.makeText(this, "puto antonio", Toast.LENGTH_SHORT).show();
            }
        });
        //descripcionYokai.setDescripcion("puto antonio");
    }
    private void changeCircleColor(int idTribu) {
        GradientDrawable drawable = (GradientDrawable) yokaiCircle.getDrawable();
        int color;
        switch (idTribu) {
            case 2:
                color = ContextCompat.getColor(this, R.color.tribu_color_guapo);
                break;
            case 3:
                color = ContextCompat.getColor(this, R.color.tribu_color_valiente);
                break;
            case 4:
                color = ContextCompat.getColor(this, R.color.tribu_color_misterioso);
                break;
            case 5:
                color = ContextCompat.getColor(this, R.color.tribu_color_robusto);
                break;
            case 6:
                color = ContextCompat.getColor(this, R.color.tribu_color_oscuro);
                break;
            case 7:
                color = ContextCompat.getColor(this, R.color.tribu_color_siniestro);
                break;
            case 8:
                color = ContextCompat.getColor(this, R.color.tribu_color_amable);
                break;
            case 9:
                color = ContextCompat.getColor(this, R.color.tribu_color_maléfico);
                break;
            case 10:
                color = ContextCompat.getColor(this, R.color.tribu_color_escurridiza);
                break;
            default:
                color = ContextCompat.getColor(this, R.color.black);
        }
        drawable.setColor(color);
    }
    public void toggleFavButton(ImageView favButton) {
        if (favButton.getTag().equals("black")) {
            favButton.setImageResource(R.drawable.usable_icon_red_fav_icon);
            favButton.setTag("red");
            Toast.makeText(VistaYokaiActivity.this, "Añadido a favoritos", Toast.LENGTH_SHORT).show();
        } else {
            favButton.setImageResource(R.drawable.usable_icon_favorite_heart);
            favButton.setTag("black");
            Toast.makeText(VistaYokaiActivity.this, "Eliminado de favoritos", Toast.LENGTH_SHORT).show();
        }
    }
    public void toggleAddButton(ImageView addButton) {
        if (addButton.getTag().equals("black")) {
            addButton.setImageResource(R.drawable.baseline_check_circle_24);
            addButton.setTag("green");
            Toast.makeText(VistaYokaiActivity.this, "Agregado a la lista", Toast.LENGTH_SHORT).show();
        } else {
            addButton.setImageResource(R.drawable.baseline_add_circle_outline_24);
            addButton.setTag("black");
            Toast.makeText(VistaYokaiActivity.this, "Eliminado de la lista", Toast.LENGTH_SHORT).show();
        }
    }
}