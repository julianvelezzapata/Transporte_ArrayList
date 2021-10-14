package com.example.transporte_arraylist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // creo los objetos que van a almacenar los archivos
    EditText jetcantidad, jetcodigo;
    CheckBox  jcbalimentacion;
    RadioButton jrbavion, jrbmoto, jrbbus;
    RadioGroup jrgtransporte;
    TextView jtvtotal;
    int pos, sw=0;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().hide();
        jetcantidad=findViewById(R.id.etcantidad);
        jcbalimentacion=findViewById(R.id.cbalimentacion);
        jrbavion=findViewById(R.id.rbavion);
        jrbmoto=findViewById(R.id.rbmoto);
        jrbbus=findViewById(R.id.rbbus);
        jtvtotal=findViewById(R.id.tvtotal);
        jrgtransporte = findViewById(R.id.rgtransporte);
        jetcodigo = findViewById(R.id.etcodigo);
    }

    public void Calcular(View view


    ){
        String cantidad;
        cantidad = jetcantidad.getText().toString();

        if (cantidad.isEmpty()){
            Toast.makeText(this,"La cantidad es requerida",Toast.LENGTH_LONG).show();
        }else {
            int valor_transporte = 0, valor_alimentacion = 0, valor_total = 0;
            if (jrbavion.isChecked())
                valor_transporte = 100000;
            else if (jrbmoto.isChecked())
                valor_transporte =   50000;
            else if  (jrbbus.isChecked())
                valor_transporte =  10000;
            if (jcbalimentacion.isChecked()){
                valor_alimentacion = 15000;
            }else
                valor_alimentacion = 0;
            valor_total = (((valor_alimentacion + valor_transporte)*19)/100) + valor_alimentacion + valor_transporte ;

            //mostrar datos
            jtvtotal.setText(String.valueOf(valor_total));
        }
    }

    private void limpiar_campos(){
        jetcantidad.setText("");
        jetcodigo.setText("");
        jrbbus.setChecked(false);
        jrbmoto.setChecked(false);
        jrbavion.setChecked(true);
        jcbalimentacion.setChecked(false);
        jtvtotal.setText("");
        jetcantidad.requestFocus();
        sw=0;
    }
}