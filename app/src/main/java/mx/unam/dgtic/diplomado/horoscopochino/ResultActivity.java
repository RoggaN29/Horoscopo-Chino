package mx.unam.dgtic.diplomado.horoscopochino;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Calendar;

public class ResultActivity extends AppCompatActivity {

    private static final String LOGTAG = "DEPURACION";

    private TextView nombre;
    private TextView edad;
    private TextView signo;
    private ImageView imagenSigno;

    private String strSigno = "";
    private int referenceImage = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        nombre = (TextView) findViewById(R.id.nombre);
        signo = (TextView) findViewById(R.id.signo);
        edad = (TextView) findViewById(R.id.edad);
        imagenSigno = (ImageView) findViewById(R.id.imagenSigno);

        Intent iin= getIntent();
        Bundle b = iin.getExtras();

        if(b!=null)
        {

            String nombre = (String) b.getString("nombre","no name");
            String apellidos = (String) b.getString("apellidos");
            Log.d(LOGTAG,"El nombre que llegó a ResultActivity es: "+ nombre +" y los apellidos son: "+ apellidos);

            int year = (int) b.get("year");
            int month = (int) b.get("month");
            int day = (int) b.get("day");

            Calendar dob = Calendar.getInstance();
            Calendar today = Calendar.getInstance();

            dob.set(year, month, day);
            int age = today.get(Calendar.YEAR) - dob.get(Calendar.YEAR);

            if (today.get(Calendar.DAY_OF_YEAR) < dob.get(Calendar.DAY_OF_YEAR)){
                age--;
            }

            this.nombre.setText(nombre + " " +apellidos);
            edad.setText(age + "");

            switch (year%12){
                case 0:
                    //mono
                    strSigno = "El Mono";
                    referenceImage = R.drawable.mono;
                    break;
                case 1:
                    //gallo
                    strSigno = "El Gallo";
                    referenceImage = R.drawable.gallo;
                    break;
                case 2:
                    //perro
                    strSigno = "El Perro";
                    referenceImage = R.drawable.perro;
                    break;
                case 3:
                    //cerdo
                    strSigno = "El Cerdo";
                    referenceImage = R.drawable.cerdo;
                    break;
                case 4:
                    //rata
                    strSigno = "La Rata";
                    referenceImage = R.drawable.rata;
                    break;
                case 5:
                    //buey
                    strSigno = "El Buey";
                    referenceImage = R.drawable.buey;
                    break;
                case 6:
                    //tigre
                    strSigno = "El Tigre";
                    referenceImage = R.drawable.tigre;
                    break;
                case 7:
                    //conejo
                    strSigno = "El Conejo";
                    referenceImage = R.drawable.conejo;
                    break;
                case 8:
                    //dragon
                    strSigno = "El Dragon";
                    referenceImage = R.drawable.dragon;
                    break;
                case 9:
                    //serpiente
                    strSigno = "La Serpiente";
                    referenceImage = R.drawable.serpiente;
                    break;
                case 10:
                    //caballo
                    strSigno = "El Caballo";
                    referenceImage = R.drawable.caballo;
                    break;
                case 11:
                    //cabra
                    strSigno = "La Cabra";
                    referenceImage = R.drawable.cabra;
                    break;

                    default:
                        break;
            }

            signo.setText(strSigno);
            imagenSigno.setImageResource(referenceImage);
        }
    }
}
