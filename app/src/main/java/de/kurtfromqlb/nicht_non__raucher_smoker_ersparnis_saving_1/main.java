package de.kurtfromqlb.nicht_non__raucher_smoker_ersparnis_saving_1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class main extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }
    public void lasssehen(View view) {
        startActivity(new Intent(getApplicationContext(),edit.class));
    }
}
