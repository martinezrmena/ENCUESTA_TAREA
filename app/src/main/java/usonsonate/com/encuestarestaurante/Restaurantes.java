package usonsonate.com.encuestarestaurante;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

public class Restaurantes extends AppCompatActivity {

    private Button btnGuadar, btnAgregar;
    private String[] DATOS = {"El Salvador", "Honduras", "Guatemala", "Nicaragua", "Costa Rica", "Belice", "Panama", "Belgica"};
    private ArrayAdapter<String> adapatador;
    private ArrayList<String> ListaDatos;
    private AutoCompleteTextView atxbDatos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurantes);

        btnGuadar = findViewById(R.id.btnGuardar);
        btnAgregar = findViewById(R.id.btnAgregar);
        ListaDatos = new ArrayList<String>();
        atxbDatos = findViewById(R.id.atxbDatos);


        //ACTIVIDAD ACTUAL, ESTILO PARA MOSTRAR SUGERENCIAS, CONJUNTO DE DATOS
        adapatador = new ArrayAdapter<String>(Restaurantes.this, android.R.layout.simple_dropdown_item_1line, this.DATOS);

        //Configurar el autocompletetextview
        //cantidad de letras desde donde se comenzara a hacer el filtro
        atxbDatos.setThreshold(1);
        //establecemos el adaptador
        atxbDatos.setAdapter(adapatador);

    }

    public void btnGuardarOnClick(View v){
        if (ListaDatos.size() != 0){
            Intent resultIntent = new Intent();
            // TODO envio los datos mediante el intent
            resultIntent.putStringArrayListExtra("miLista", ListaDatos);
            resultIntent.putExtra("DATOS", "CORRECTO");
            setResult(MainActivity.ENVIORESTAURANTE, resultIntent);

            finish();
        }else{

            Toast.makeText(this, "Debe seleccionar al menos un elemento", Toast.LENGTH_SHORT).show();
        }

    }

    public void btnAgregarOnClick(View v){
        if (atxbDatos.getText().toString().length() !=0 ){
            ListaDatos.add(atxbDatos.getText().toString());
            atxbDatos.setText("");
        }
    }
}
