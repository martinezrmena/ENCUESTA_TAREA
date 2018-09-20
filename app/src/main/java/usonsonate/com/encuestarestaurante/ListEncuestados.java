package usonsonate.com.encuestarestaurante;

import android.app.ListActivity;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;

public class ListEncuestados extends ListActivity {

    ArrayList<Encuestado> listaEncuestadoNueva, listaEncuestadoRecibido;
    private AdaptadorEncuestado adaptadorEncuestado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_list_encuestados);

        setTitle("LISTA ENCUESTADOS");


        Bundle contenedor = getIntent().getExtras();
        listaEncuestadoRecibido = (ArrayList<Encuestado>) contenedor.getSerializable("array");
        listaEncuestadoNueva = new ArrayList<>();

        adaptadorEncuestado = new AdaptadorEncuestado(ListEncuestados.this, listaEncuestadoNueva);
        setListAdapter(adaptadorEncuestado);

        FillListEncuestado();
    }


    private void FillListEncuestado(){
        for (final Encuestado c:listaEncuestadoRecibido){
            listaEncuestadoNueva.add(c);
            adaptadorEncuestado.notifyDataSetChanged();
        }
    }
}
