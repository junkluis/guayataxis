package com.example.cltcontrol.guayataxi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button btn_enviarDatos = findViewById(R.id.enviarDatos);
        final Spinner sp_marca = findViewById(R.id.marcaAuto);
        String[] str_marcas = new String[]{"Nissan","General Motors","Honda","Toyota","KIA","Mazda"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, str_marcas);
        sp_marca.setAdapter(adapter);


        final EditText et_nombres = findViewById(R.id.nombreChofer);
        final EditText et_placa = findViewById(R.id.codPlaca);
        final EditText et_edad = findViewById(R.id.edad);

        RadioButton rb_norte = findViewById(R.id.norte);
        RadioButton rb_centro = findViewById(R.id.centro);
        RadioButton rb_sur = findViewById(R.id.sur);
        RadioButton rb_duran = findViewById(R.id.duran);
        RadioButton rb_sanmbo = findViewById(R.id.samborondon);

        final ArrayList sectores = new ArrayList<RadioButton>();
        sectores.add(rb_norte);
        sectores.add(rb_centro);
        sectores.add(rb_sur);
        sectores.add(rb_duran);
        sectores.add(rb_sanmbo);


        //
        final String nombreChofer = et_nombres.getText().toString();
        final String placaChofer = et_placa.getText().toString();
        final String marca = sp_marca.getSelectedItem().toString();
        final String str_edad = et_edad.getText().toString();
        Log.d("MyApp", str_edad);
        final int edadChofer = 55;

        btn_enviarDatos.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                boolean comprobacion = validarDatosTaxista(nombreChofer, placaChofer, marca, edadChofer);
                if(comprobacion == true){
                    Toast.makeText(MainActivity.this,
                            "Datos validos",
                            Toast.LENGTH_SHORT ).show();

                } else {
                    Toast.makeText(MainActivity.this,
                            "Datos invalidos",
                            Toast.LENGTH_SHORT ).show();

                }
            }

        });
    }

    // function declaration
    static boolean validarDatosTaxista(String nombreChofer, String placaChofer, String marca, int edadChofer) {

        String[] marcasHabiles = new String[]{"Nissan","General Motors","Honda","Toyota","KIA","Mazda"};
        boolean comprobacion = true;

        ArrayList sectores_select = new ArrayList<RadioButton>();

        if (nombreChofer == null || nombreChofer.length() < 3 || nombreChofer.length() > 30) {
            comprobacion = false;
        }

        if (placaChofer == null || placaChofer.length() != 6 ) {
            comprobacion = false;
        }

        if (edadChofer <= 24 || edadChofer >= 66 ) {
            comprobacion = false;
        }

        if (!Arrays.asList(marcasHabiles).contains(marca)) {
            comprobacion = false;
        }

        System.out.println(comprobacion);

        return comprobacion;
    }


}
