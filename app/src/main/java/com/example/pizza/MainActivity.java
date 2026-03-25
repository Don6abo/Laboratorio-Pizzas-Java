package com.example.pizza;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    GridView gvPizzas;

    String[] nombres = {"Hawaiana", "Americana", "Cuatro Quesos"};
    int[] imagenes = {R.drawable.hawaiana, R.drawable.americana, R.drawable.cuatroquesos};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gvPizzas = findViewById(R.id.gvPizzas);


        gvPizzas.setAdapter(new BaseAdapter() {
            @Override
            public int getCount() { return nombres.length; }

            @Override
            public Object getItem(int position) { return null; }

            @Override
            public long getItemId(int position) { return 0; }

            @Override
            public View getView(int i, View view, ViewGroup viewGroup) {
                View vista = getLayoutInflater().inflate(R.layout.item_pizza, null);

                ImageView image = vista.findViewById(R.id.imgPizza);
                TextView text = vista.findViewById(R.id.tvNombrePizza);

                image.setImageResource(imagenes[i]);
                text.setText(nombres[i]);

                return vista;
            }
        });


        gvPizzas.setOnItemClickListener((parent, view, position, id) -> {
            Toast.makeText(MainActivity.this, "Has elegido: " + nombres[position], Toast.LENGTH_SHORT).show();
        });
    }
}