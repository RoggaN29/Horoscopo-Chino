package mx.unam.dgtic.diplomado.horoscopochino;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Typeface fuenteFrontier;
    private TextView tvNombres;
    private TextView tvApellidos;

    private EditText etNombres;
    private EditText etApellidos;

    private Button fechaSelector;
    private Button btnAceptar;
    int year = 1990;
    int month = 00;
    int day = 01;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fuenteFrontier = Typeface.createFromAsset(getAssets(), "finalfrontier.ttf");

        tvNombres = findViewById(R.id.tvNombres);
        tvApellidos = findViewById(R.id.tvApellidos);
        etNombres = findViewById(R.id.etNombres);
        etApellidos = findViewById(R.id.etApellidos);

        tvNombres.setTypeface(fuenteFrontier);
        tvApellidos.setTypeface(fuenteFrontier);
        etNombres.setTypeface(fuenteFrontier);
        etApellidos.setTypeface(fuenteFrontier);

        fechaSelector = (Button) findViewById(R.id.fecha);
        btnAceptar = (Button) findViewById(R.id.btnAceptar);

        fechaSelector.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog(0);
            }
        });
        btnAceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(etNombres.getText().toString().equals("") || etApellidos.getText().toString().equals("")) {
                    Toast.makeText(MainActivity.this, "Por favor llena todos los campos",Toast.LENGTH_SHORT).show();
                    if(etNombres.getText().length()==0) etNombres.setError("Requerido");
                    if(etApellidos.getText().length()==0) etApellidos.setError("Requerido");
                }else{
                    Intent intent = new Intent(MainActivity.this, ResultActivity.class);
                    intent.putExtra("nombre", etNombres.getText().toString());
                    intent.putExtra("apellidos", etApellidos.getText().toString());
                    intent.putExtra("year",year);
                    intent.putExtra("month",month);
                    intent.putExtra("day",day);
                    startActivity(intent);
                }
            }
        });
    }

    @Override
    @Deprecated
    protected Dialog onCreateDialog(int id) {
        return new DatePickerDialog(this, datePickerListener, year, month, day);
    }

    private DatePickerDialog.OnDateSetListener datePickerListener = new DatePickerDialog.OnDateSetListener() {
        public void onDateSet(DatePicker view, int selectedYear,
                              int selectedMonth, int selectedDay) {
            day = selectedDay;
            month = selectedMonth;
            year = selectedYear;
            fechaSelector.setText(selectedDay + " / " + (selectedMonth + 1) + " / "
                    + selectedYear);
        }
    };
}
