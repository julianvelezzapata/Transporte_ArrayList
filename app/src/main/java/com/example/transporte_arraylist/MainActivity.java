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

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity  {

    // creo los objetos que van a almacenar los archivos
    EditText jetcantidad, jetcodigo;
    CheckBox  jcbalimentacion;
    RadioButton jrbavion, jrbmoto, jrbbus;
    TextView jtvtotal;
    ClsTransporte objtransporte = new ClsTransporte();
    ArrayList<ClsTransporte> altransporte;
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


        jetcodigo = findViewById(R.id.etcodigo);
        altransporte = new ArrayList<ClsTransporte>();
    }

    public void Calcular(View view){
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

    public void  Guardar(View view) {
        String codigo, transporte = null, cantidad , alimentacion, total, bus, avion, moto;
        codigo = jetcodigo.getText().toString();
        cantidad = jetcantidad.getText().toString();
        alimentacion = jcbalimentacion.getText().toString();
        total = jtvtotal.getText().toString();
        bus = jrbbus.getText().toString();
        avion = jrbavion.getText().toString();
        moto = jrbmoto.getText().toString();


        if (cantidad.isEmpty() || codigo.isEmpty()) {
            Toast.makeText(this, "llenar los campos", Toast.LENGTH_LONG).show();
        } else {
                    if(sw==1){
                                if (jrbavion.isChecked())
                                        transporte = avion;
                                        altransporte.get(pos).setTransporte(transporte);
                                        if (jrbmoto.isChecked())
                                        transporte = moto;
                                        altransporte.get(pos).setTransporte(transporte);
                                        if  (jrbbus.isChecked()) {
                                            transporte = bus;
                                            altransporte.get(pos).setTransporte(transporte);
                                        }

                                altransporte.get(pos).setCodigo(codigo);
                                altransporte.get(pos).setCantidad(cantidad);
                                altransporte.get(pos).setAlimentacion(alimentacion);
                                altransporte.get(pos).setTotal(total);
                                Toast.makeText(this, "Registro modificado", Toast.LENGTH_SHORT).show();
                                limpiar_campos();
                                sw = 0;
                               }
                                else{
                                    pos=0;
                                    sw=0;
                                    while( pos < altransporte.size() && sw ==0){
                                        objtransporte = altransporte.get(pos);
                                        if (objtransporte.getCodigo().equals(codigo))
                                            sw=1;
                                        else
                                            pos++;
                                    }
                                    if(sw == 0){
                                        objtransporte = new ClsTransporte(codigo, transporte, cantidad, alimentacion,total);
                                        altransporte.add(objtransporte);
                                        Toast.makeText(this, "Registro adicionado", Toast.LENGTH_SHORT).show();
                                        limpiar_campos();
                                    }
                                    else {
                                        limpiar_campos();
                                        Toast.makeText(this, "Estudiante ya registrado", Toast.LENGTH_SHORT).show();
                                        sw=0;
                                    }
                                }


                 }



    }

    public void consultar (View view){Consultar_Transporte();}

    private void Consultar_Transporte(){
        String carnet;
        pos=0;
        sw=0;
        carnet=jetcodigo.getText().toString();
        if (carnet.isEmpty()){
            Toast.makeText(this, "numero de codigo es requerido", Toast.LENGTH_LONG).show();
            jetcodigo.requestFocus();
        }
        else{
            while (pos < altransporte.size() && sw==0){
                objtransporte=altransporte.get(pos);
                if (objtransporte.getCodigo().equals(carnet))
                    sw=1;
                else
                    pos++;
            }
            if (sw == 0)
                Toast.makeText(this, "codigo no registrado", Toast.LENGTH_SHORT).show();
            else{
                jetcantidad.setText(objtransporte.getCantidad());
                jtvtotal.setText(objtransporte.getCantidad());

            }
            jetcodigo.requestFocus();
        }
    }




}