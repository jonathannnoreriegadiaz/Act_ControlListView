package com.example.act_controllistview;

import  android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;


public class Adaptador extends BaseAdapter{


    private static LayoutInflater inflater = null;

    Context contexto;
    String[][] datos;
    int[] datosImg;

    public Adaptador(Context conexto, String[][] datos, int[] imagenes)
    {
        this.contexto = conexto;
        this.datos = datos;
        this.datosImg = imagenes;

        inflater = (LayoutInflater)conexto.getSystemService(conexto.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public View getView(int i, View convertView, ViewGroup parent) {

        final View vista = inflater.inflate(R.layout.elemento_lista, null);

        TextView titulo = (TextView) vista.findViewById(R.id.tvTitulo);
        TextView precio = (TextView) vista.findViewById(R.id.tvPrecio);
        TextView director = (TextView) vista.findViewById(R.id.tvDirector);

        ImageView imagen = (ImageView) vista.findViewById(R.id.ivImagen);
        RatingBar calificacion = (RatingBar) vista.findViewById(R.id.ratingBarPerl);

        titulo.setText(datos[i][0]);
        director.setText(datos[i][1]);
        precio.setText("Precio " + datos[i][2]);
        imagen.setImageResource(datosImg[i]);
        calificacion.setProgress(Integer.valueOf(datos[i][3]));

        imagen.setTag(i);

        imagen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent visorImagen = new Intent(contexto, VisorImagen.class);
                visorImagen.putExtra("IMG", datosImg[(Integer)v.getTag()]);
                contexto.startActivity(visorImagen);
            }
        });
        titulo.setTag(i);
        titulo.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v){
                Intent visorDetallesPlatillos = new Intent(contexto,DetallesPlatillos.class);
                visorDetallesPlatillos.putExtra("TITULO",datos[(Integer)v.getTag()][0]);
                visorDetallesPlatillos.putExtra("DETALLES",datos[(Integer)v.getTag()][4]);
                contexto.startActivity(visorDetallesPlatillos);
            }
        });


        return vista;
    }

    @Override
    public int getCount() {
        return datosImg.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

}