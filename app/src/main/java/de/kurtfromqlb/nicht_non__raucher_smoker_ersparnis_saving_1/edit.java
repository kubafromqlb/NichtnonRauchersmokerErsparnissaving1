package de.kurtfromqlb.nicht_non__raucher_smoker_ersparnis_saving_1;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
/**
 * Created by Kurt Balle on 27.03.2018.
 */
public class edit extends AppCompatActivity implements View.OnClickListener {
    Calendar myCalendar = Calendar.getInstance();
    String SHARED_PREF_NAME = "mysharedpref";
    int Year, Month, Day;
    EditText datum;
    EditText etpartperday, etpriceperbox, etpartperbox;
    TextView tvpartperdayoutput, tvpriceperboxoutbox, tvpartperboxoutput, tvdateoutput;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit);
        etpartperday = findViewById(R.id.etpartperday);
        etpriceperbox = findViewById(R.id.etpriceperbox);
        etpartperbox = findViewById(R.id.etpartperbox);
        tvdateoutput = findViewById(R.id.tvdateoutput);
        tvpartperdayoutput = findViewById(R.id.tvpartperdayoutput);
        tvpriceperboxoutbox = findViewById(R.id.tvpriceperboxoutput);
        tvpartperboxoutput = findViewById(R.id.tvpartperboxoutput);
        datum = (EditText) findViewById(R.id.etdate);
        datum.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        if (v == datum) {
            // Use the current date as the default date in the picker
            final Calendar c = Calendar.getInstance();
            Year = c.get(Calendar.YEAR);
            Month = c.get(Calendar.MONTH);
            Day = c.get(Calendar.DAY_OF_MONTH);
            DatePickerDialog dpd = new DatePickerDialog(this,
                    new DatePickerDialog.OnDateSetListener()
                    {
    @Override
    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                            datum.setText(dayOfMonth + "." + (monthOfYear + 1) + "." + year);
                        }
                    }, Year, Month, Day);
            dpd.show();
        }
        // bin fertig
        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
           saveName();
           zuresult();
           }
        });
    }
    public void saveName() {
        String date = datum.getText().toString();
        String heute = new SimpleDateFormat("dd.MM.yyyy").format(new Date());
        String anzahltag = etpartperday.getText().toString();
        String preis = etpriceperbox.getText().toString();
        String anzahlbox = etpartperbox.getText().toString();
        if (etpartperday.getText().length() <= 0) {
            Toast.makeText(edit.this, "Anzahl eingeben", Toast.LENGTH_SHORT).show();
        } else if (etpriceperbox.getText().length() <= 0) {
            Toast.makeText(edit.this, "Preis eingeben", Toast.LENGTH_SHORT).show();
        } else if (etpartperbox.getText().length() <= 0) {
            Toast.makeText(edit.this, "Stück eingeben", Toast.LENGTH_SHORT).show();
        } else {
            // funktioniert auch
            //    if (name.isEmpty()) {
            //        etpartperday.setError("Anzahl eintragen");
            //        etpartperday.requestFocus();
            //        return;
            //    }
            SharedPreferences sp = getSharedPreferences("mysharedpref", MODE_PRIVATE);
            SharedPreferences.Editor editor = sp.edit();
            editor.putString("Datum", date);
            editor.putString("Heute", heute);
            editor.putString("Anzahltag", anzahltag);
            editor.putString("Preis", preis);
            editor.putString("Anzahlbox", anzahlbox);
            editor.apply();
            //etdatum.setText("");
            etpartperday.setText("");
            etpriceperbox.setText("");
            etpartperbox.setText("");
        }
    }
       public void zuresult () {
        //   if (button == R.id.button) {
        startActivity(new Intent(edit.this, result.class));
    }
}