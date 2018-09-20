package usonsonate.com.encuestarestaurante;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Calendar;
import java.util.Date;

public class Encuestados extends AppCompatActivity {

    private EditText txbFecha;
    private int dia, mes, year;
    private Button btnGuardar;
    private EditText txbEdad, txbNombre, txbApellido;
    private static int ENVIOENCUESTADOS = 50;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_encuestados);

        txbFecha = findViewById(R.id.txbFecha);
        txbFecha.setInputType(InputType.TYPE_NULL);
        btnGuardar = findViewById(R.id.btnGuardar);
        txbEdad = findViewById(R.id.txbEdad);
        txbApellido = findViewById(R.id.txbApellido);
        txbNombre = findViewById(R.id.txbNombre);

        txbFecha.setText("");
        txbEdad.setText("");
        txbApellido.setText("");
        txbNombre.setText("");

    }

    public void txbFechaOnClick(View v){

        final Calendar c = Calendar.getInstance();
        dia = c.get(Calendar.DAY_OF_MONTH);
        mes = c.get(Calendar.MONTH);
        year = c.get(Calendar.YEAR);

        final DatePickerDialog datePickerDialog = new DatePickerDialog(Encuestados.this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int day) {
                txbFecha.setText(day + "-" + (month +1) + "-" + year);
            }
        },year,mes,dia);

        datePickerDialog.show();
    }

    public void btnGuardarOnClick(View v){

        if (txbApellido.getText().toString().length() != 0 && txbNombre.getText().toString().length() != 0 && txbEdad.getText().toString().length() != 0 && txbFecha.getText().toString().length() != 0 ){
            Intent resultIntent = new Intent();
            // TODO envio los datos mediante el intent
            resultIntent.putExtra("NOMBRE", txbNombre.getText().toString());
            resultIntent.putExtra("APELLIDO", txbApellido.getText().toString());
            resultIntent.putExtra("EDAD", txbEdad.getText().toString());
            resultIntent.putExtra("FECHA", txbFecha.getText().toString());
            setResult(MainActivity.ENVIOENCUESTADOS, resultIntent);
            finish();
        }else{

            Toast.makeText(this, "Verifica los campos, hay campos vacios.", Toast.LENGTH_SHORT ).show();
        }
    }
}
