package com.example.baris.quiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        setContentView(R.layout.activity_main);
    }


    public void onButtonClicked(View view) {
        CheckBox visCheckBox = (CheckBox) findViewById(R.id.checkbox_vis);
        CheckBox metaalCheckbox = (CheckBox) findViewById(R.id.checkbox_metaal);
        CheckBox beerCheckBox = (CheckBox) findViewById(R.id.checkbox_beer);
        CheckBox schildpadCheckBox = (CheckBox) findViewById(R.id.checkbox_schildpad);
        CheckBox slangCheckBox = (CheckBox) findViewById(R.id.checkbox_slang);
        CheckBox gorillaCheckBox = (CheckBox) findViewById(R.id.checkbox_gorilla);
        CheckBox vleesCheckBox = (CheckBox) findViewById(R.id.checkbox_vlees);
        boolean hasVis = visCheckBox.isChecked();
        boolean hasMetaal = metaalCheckbox.isChecked();
        boolean hasSchildpad = schildpadCheckBox.isChecked();
        boolean hasSlang = slangCheckBox.isChecked();
        boolean hasBeer = beerCheckBox.isChecked();
        boolean hasGorilla = gorillaCheckBox.isChecked();
        boolean hasVlees = vleesCheckBox.isChecked();
        int totaal = 0;
        if (hasVlees && hasVis && !hasMetaal) {
            totaal += 1;

        }

        if (hasBeer && hasGorilla && !hasSchildpad && !hasSlang) {
            totaal += 1;
        }


        RadioButton amsterdamRadio = (RadioButton) findViewById(R.id.radio_amsterdam);
        boolean hasAmsterdam = amsterdamRadio.isChecked();

        if (hasAmsterdam) {
            totaal += 1;

        }


        EditText school = (EditText) findViewById(R.id.ROC_text);
        String name = school.getText().toString();

        String antwoord = "Regionaal opleidingscentrum ";
        String antwoord2 = "regionaal opleidingscentrum";
        String antwoord3 = "Regionaal Opleidingscentrum";

        if (name.matches(antwoord) || name.matches(antwoord2) || name.matches(antwoord3)) {
            totaal += 1;
        }

        antwoorden(totaal);
        Toast.makeText(this, "Je hebt zoveel goed: " + totaal, Toast.LENGTH_SHORT).show();
    }

    private void antwoorden(int totaal) {

        TextView antwoorden = (TextView) findViewById(R.id.antwoord);
        antwoorden.setText("Je hebt zoveel goed: " + totaal);
    }
}
