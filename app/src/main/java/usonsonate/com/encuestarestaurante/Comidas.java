package usonsonate.com.encuestarestaurante;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;

import java.util.ArrayList;

public class Comidas extends AppCompatActivity {

    private ArrayList<CheckBox> ListaValores;
    private ArrayList<String> ListaSeleccionados;
    private Button btnGuardar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comidas);
        setTitle("TIPO DE COMIDA");

        ListaValores = new ArrayList<CheckBox>();
        ListaSeleccionados = new ArrayList<String>();
        ListaValores.add((CheckBox) findViewById(R.id.chkCarnes));
        ListaValores.add((CheckBox) findViewById(R.id.chkEnsalada));
        ListaValores.add((CheckBox) findViewById(R.id.chkPastas));
        btnGuardar = findViewById(R.id.btnGuardar);
        InitCheckboxes();

    }


    private void InitCheckboxes(){

        for (final CheckBox chk:ListaValores){
            chk.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton compoundButton, boolean checked) {
                    if (checked){
                        ListaSeleccionados.add(chk.getText().toString());
                    }else{
                        ListaSeleccionados.remove(chk.getText().toString());
                    }
                }
            });
        }
    }

    public void btnGuardarOnClick(View v){
        if (ListaSeleccionados.size() != 0){
            Intent resultIntent = new Intent();
            // TODO envio los datos mediante el intent
            resultIntent.putStringArrayListExtra("miLista", ListaSeleccionados);
            resultIntent.putExtra("DATOS", "CORRECTO");
            setResult(MainActivity.ENVIOCOMIDAS, resultIntent);

            finish();
        }else{

            Toast.makeText(this, "Debe seleccionar al menos un elemento", Toast.LENGTH_SHORT).show();
        }

    }
}
