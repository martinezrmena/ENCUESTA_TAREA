package usonsonate.com.encuestarestaurante;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class AdaptadorEncuestado extends ArrayAdapter<Encuestado> {
    SimpleDateFormat formatter;

    public AdaptadorEncuestado(Context context, List<Encuestado> objects) {
        super(context, 0, objects);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Obteniendo el dato
        Encuestado encuestado = getItem(position);
        //TODO inicializando el layout correspondiente al item (Contacto)
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_encuestado, parent, false);
        }
        TextView lblNombre = (TextView) convertView.findViewById(R.id.lblNombre);
        TextView lblApellido = (TextView) convertView.findViewById(R.id.lblApellido);
        TextView lblEdad = (TextView) convertView.findViewById(R.id.lblEdad);
        TextView lblFecha = (TextView) convertView.findViewById(R.id.lblFecha);

        // mostrar los datos
        formatter = new SimpleDateFormat("dd-MM-yyyy");
        lblNombre.setText(encuestado.getNombre());
        lblApellido.setText(encuestado.getApellido());
        lblEdad.setText(String.valueOf(encuestado.getEdad()));
        lblFecha.setText(formatter.format(encuestado.getFechaNac()));

        // Return la convertView ya con los datos
        return convertView;
    }


}
