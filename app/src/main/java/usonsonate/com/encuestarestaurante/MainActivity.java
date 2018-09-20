package usonsonate.com.encuestarestaurante;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.getbase.floatingactionbutton.FloatingActionButton;
import com.getbase.floatingactionbutton.FloatingActionsMenu;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private FloatingActionButton btnRegistrar, btnSeleccionar, btnRestaurante, btnLista;
    public static int ENVIOENCUESTADOS = 50;
    public static int ENVIOCOMIDAS = 51;
    public static int ENVIORESTAURANTE = 52;
    private ArrayList<String> ListaSeleccionados;
    private ArrayList<String> ListaResutanrantes;
    ActionBar actionBar;
    FloatingActionsMenu btnMainMenu;
    private ArrayList<Encuestado> lstEncuestados;
    SimpleDateFormat formatter;
    Date date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        actionBar = getSupportActionBar();
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#370A54")));

        btnMainMenu = findViewById(R.id.MainButton);
        ListaSeleccionados = new ArrayList<String>();
        ListaResutanrantes = new ArrayList<String>();
        btnRegistrar = findViewById(R.id.btnRegistrarEncuesta);
        btnSeleccionar = findViewById(R.id.btnSeleccionarComida);
        btnRestaurante = findViewById(R.id.btnRestaurante);
        btnLista = findViewById(R.id.btnLista);
        lstEncuestados = new ArrayList<>();
        formatter  = new SimpleDateFormat("dd-MM-yyyy");

    }

    public void btnViewListaEncuestadoClick(View v){
        Intent intento = new Intent(MainActivity.this, ListEncuestados.class);
        Bundle contenedor = new Bundle();
        contenedor.putSerializable("array", lstEncuestados);
        intento.putExtras(contenedor);
        startActivity(intento);

    }

    public void btnRegistrarOnClick(View v){
        Intent nuevo = new Intent(this, Encuestados.class);
        startActivityForResult(nuevo, ENVIOENCUESTADOS);

    }

    public void btnSeleccionarOnClick(View v){
        Intent nuevo = new Intent(this, Comidas.class);
        startActivityForResult(nuevo, ENVIOCOMIDAS);
    }

    public void btnRestauranteOnClick(View v){
        Intent nuevo = new Intent(this, Restaurantes.class);
        startActivityForResult(nuevo, ENVIORESTAURANTE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==ENVIOENCUESTADOS){
            if(data==null) return;
            //recibo el dato
            String fecha = data.getStringExtra("FECHA");
            try {
                formatter = new SimpleDateFormat("dd-MM-yyyy");
                date = formatter.parse(fecha);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            Encuestado e = new Encuestado(
                    data.getStringExtra("NOMBRE"),
                    Integer.parseInt(data.getStringExtra("EDAD")),
                    data.getStringExtra("APELLIDO"),
                    date
            );
            lstEncuestados.add(e);
            Toast.makeText(MainActivity.this, "Selecciono: " + data.getStringExtra("APELLIDO"), Toast.LENGTH_SHORT).show();

        }else if(requestCode == ENVIOCOMIDAS){
            if(data==null) return;
            //recibo el dato
            ListaSeleccionados = (ArrayList<String>) data.getStringArrayListExtra("miLista");
            Toast.makeText(MainActivity.this, "Selecciono: " + ListaSeleccionados.get(1).toString(), Toast.LENGTH_SHORT).show();
        }else if(requestCode == ENVIORESTAURANTE){
            if(data==null) return;
            //recibo el dato
            ListaResutanrantes = (ArrayList<String>) data.getStringArrayListExtra("miLista");
            Toast.makeText(MainActivity.this, "Selecciono: " + ListaResutanrantes.get(0).toString(), Toast.LENGTH_SHORT).show();
        }
    }
}
