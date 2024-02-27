package com.example.act_controllistview;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;


public class MainActivity extends AppCompatActivity {
    ListView lista;

    String[][] datos = {

           {"COCHINITA PIBIL", "Yucatán", "$60", "9", "Nacen de la época prehispánica, de la mano de las primeras civilizaciones encontradas en Yucatán, quienes probando por primera vez la carne de cerdo decidieron armar su propia receta Para cocinar este platillo, debes adobar una porción de carne de cerdo con achiote, envolviéndola en hojas de plátano e introduciéndola en un horno de tierra por un par de horas."},
            {"ENCHILADAS", "Puebla", "$90", "7", "Las enchiladas es uno de los platillos cuyos ingredientes en la preparación pueden variar con mayor frecuencia, todo dependerá del lugar donde las sirvan, siempre y cuando se respete la santa trinidad: tortilla de maíz, chile y queso.Algunas enchiladas son rellenadas con frijoles, lechuga, jalapeño y tomate, mientras que otras incluyen carne de res con papa y zanahoria."},
            {"FAJITAS", "Yucatán", "$60", "9", "La gastronomía Tex-Mex nació de la integración en el suroeste de Estados Unidos de los gustos culinarios de los mexicanos emigrados al territorio en busca de una vida mejor. Los vaqueros mexicanos que trabajaban en los ranchos texanos solían recibir para su alimentación las partes más duras de las reses beneficiadas y para comerlas más fácilmente se acostumbraron a cortarlas en pequeñas tiras a las que llamaron fajitas."},
            {"GUACAMOLE", "Mexico", "$80", "8", "Una salsa tan famosa como los más reconocidos platillos típicos, de hecho, es considerada como la principal para acompañar a la gastronomía mexicana a nivel internacional.Pero su popularidad nace en la cuna del pueblo mexicano, puesto que sus dos ingredientes fundamentales (aguacate y chile) son de los más económicos y abundantes en el territorio.Además, en la cultura prehispánica."},
            {"HUARACHE", "Mexico", "$98", "9", "Imitando las antiguas sandalias de las tribus indígenas mexicanas, el huarache consiste en una gruesa tortilla de maíz, chata y alargada, sobre la que se sirve carne de res o puerco, chile, frijoles, queso y vegetales.La creación de este platillo típico se le atribuye a la mexicana Carmen Gómez Medina, quien lo sirvió por primera vez en su respectivo puesto de comida, ubicado en el Canal de la Viga, en 1935."},
            {"MOLE", "Puebla", "$100", "8", "No se trata de una comida propiamente dicha, sino mas bien un acompañamiento que puede hacer convertir casi cualquier platillo en uno típico mexicano.Es una deliciosa salsa elaborada a partir de chiles, masa de maíz, bolillo y especias varias, sirviéndose principalmente junto con carnes cocidas."},
            {"POZOLE", " Guerrero ", "$80", "9", "Se trata de uno de los caldos más representativos de la gastronomía mexicana, cuya principal característica es que puede variar de color (rojo, verde y blanco son los principales) dependiendo de sus ingredientes.Pueden prepararse tanto con carne (sea de res, de puerco o de pollo) como con vegetales (aguacate, cebolla y chile), pero en todo momento se destaca por los granos de maíz tierno de cacahuazintle, a partir del cual varía el color del caldo.."},
            {"TACOS", " Mexico ", "$98", "10", " Su preparación básica es a partir de una (o varias) tortillas de maíz fritas, que pueden ser rellenadas con carne de res, pollo o pescado, aderezadas con granos, queso rallado y una variedad de vegetales salteados en trozos.Este platillo puede ser más o menos picante en función de la cantidad de chile que se agregue, y no debes olvidar preparar salsa de guacamole o pasta de tomate para acompañarlos y darles un mayor y mejor sabor."},
            {"TAMALES", " Veracruz", "$40", "8", "Aunque en los últimos años ha sido considerado uno de los platillos más humildes de la gastronomía mexicana, muchos desconocen que sus orígenes se remontan a los jefes y sacerdotes mexicas en la época prehispánica, quienes los utilizaban como ofrendas. Se preparan a partir de masa de maíz dividida en partes y rellena de carne, vegetales y chile, que se envuelve en hojas de mazorca y se cocinan hervidas al vapor."},
            {"TOTOPOS ", "Guerrero", "$135", "10", "Conocidos mundialmente por el nombre de nachos, los totopos son el aditivo perfecto para todo platillo mexicano en cualquier momento del día. Son simples tostadas de maíz trituradas, asadas directamente al fuego o fritas, servidos en sus características formas triangulares. Estos se suelen servir acompañados por una variedad de salsas, siendo las principales las preparadas a base de pasta de tomate y carne de res, guacamole, chile con jalapeño o queso fundido."}

    };

    int[] datosImg = {R.drawable.cochinita, R.drawable.enchiladas, R.drawable.fajitas, R.drawable.guacamole, R.drawable.huarache, R.drawable.mole,
            R.drawable.pozole,R.drawable.tacos, R.drawable.tamales, R.drawable.totopos};



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lista = (ListView) findViewById(R.id.lvLista);
        lista.setAdapter(new Adaptador(this, datos, datosImg));
        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent visorDetalles = new Intent(view.getContext(), DetallesPlatillos.class);
                visorDetalles.putExtra("TITULO", datos[position][0]);
                visorDetalles.putExtra("DETALLES", datos[position][4]);
                startActivity(visorDetalles);
            }
        });

    }
}
