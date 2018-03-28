package de.kurtfromqlb.nicht_non__raucher_smoker_ersparnis_saving_1;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created by Kurt Balle on 27.03.2018.
 */
public class result extends AppCompatActivity {

    TextView tvresult, tv, textview, text;
    SharedPreferences sp;
    int result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result);
    }

    public void onClick(View v) {
       makeCalculations();
       zeigetage();
     }

     public void makeCalculations() {

         tv = findViewById(R.id.tvresult);

         sp = getSharedPreferences("mysharedpref", MODE_PRIVATE);

         String date = sp.getString("Date", null);
         String heute = sp.getString("Heute", null);
         String anzahltag = sp.getString("Anzahltag", null);
         String preis = sp.getString("Preis", null);
         String anzahlbox = sp.getString("Anzahlbox", null);

         Integer convertedPreis = Integer.valueOf(preis);
         Integer convertedAnzahltag = Integer.valueOf(anzahltag);
         Integer convertedAnzahlbox = Integer.valueOf(anzahlbox);

         int n1 = convertedPreis;
         int n2 = convertedAnzahltag;
         int n3 = convertedAnzahlbox;

         result = n1 * n2 / n3;
         //    result = (double) Math.round(result * 100) / 100.0;
         tv.setText("Ersparnis: " + "\n\n" + result + " Euro");
/*
        // Aktuelles Datum:http://www.torsten-horn.de/techdocs/java-date.htm
        // Date dt = new Date();
        // System.out.println( "Date = " + dt );          // z.B. 'Fri Jan 26 19:03:56 GMT+01:00 2001'
        // System.out.println( "ms = " + dt.getTime() );  // z.B. '980532236731'

         Calendar cal_1 = new GregorianCalendar();
         Calendar cal_2 = new GregorianCalendar();
         cal_1.set( 1997, Calendar.MARCH, 1, 0, 0, 0 );                      // erster Zeitpunkt
         cal_2.set( 1998, Calendar.APRIL, 2, 0, 0, 0 );                      // zweiter Zeitpunkt
         long time = cal_2.getTime().getTime() - cal_1.getTime().getTime();  // Differenz in ms
         long days = Math.round( (double)time / (24. * 60.*60.*1000.) );     // Differenz in Tagen
        // System.out.println( "Zeit-Differenz in Tagen: " + days );
*/
     }
          public void zeigetage (){
              text = findViewById(R.id.textView);
        sp = getSharedPreferences("mysharedpref", MODE_PRIVATE);

        String date = sp.getString("Date", "01/03/2018");
        String heute = sp.getString("Heute", null);

             String dateStart = date;
             String dateStop = heute;

             //HH converts hour in 24 hours format (0-23), day calculation
             SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");

             Date d1 = null;
             Date d2 = null;

            try {
                 d1 = format.parse(dateStart);
                 d2 = format.parse(dateStop);

                 //in milliseconds
                 long diff = d2.getTime() - d1.getTime();

                 long diffSeconds = diff / 1000 % 60;
                 long diffMinutes = diff / (60 * 1000) % 60;
                 long diffHours = diff / (60 * 60 * 1000) % 24;
                 long diffDays = diff / (24 * 60 * 60 * 1000);

                text.setText((int) diffDays);
                // System.out.print(diffDays + " days, ");
                // System.out.print(diffHours + " hours, ");
                // System.out.print(diffMinutes + " minutes, ");
                // System.out.print(diffSeconds + " seconds.");

             } catch (Exception e) {
                 e.printStackTrace();
             }

         }




/*
        @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
        public void beenden (View view){
            // RAM leeren
            //    System.exit(0);
            // result beenden und zu edit zurück
            //    finish();
            // alle activity beenden im selben task mi derselben affinity (zugehörigkeit)
            this.finishAffinity();
        }
*/
    }
