package edu.byu.loganmc.youpick;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.Toast;

import edu.byu.loganmc.youpick.model.Settings;

public class SettingsActivity extends AppCompatActivity {

    private boolean validateInputs(){
        //Not sure what needs to happen here
        return true;
    }

    private boolean saveChanges(){
        if (!validateInputs()){
            return false;
        }
        Settings settings = Settings.getInstance();
        settings.setMinPrice(getMinPrice());
        settings.setMaxPrice(getMaxPrice());
        Switch animation = (Switch) findViewById(R.id.animationsSwitch);
        settings.setAnimations(animation.isChecked());
        Switch sounds = (Switch) findViewById(R.id.soundSwitch);
        settings.setSounds(sounds.isChecked());
        EditText radiusInMiles = (EditText) findViewById(R.id.radius);
        settings.setRadiusInMiles(Integer.parseInt(radiusInMiles.getText().toString()));
        return true;
    }
    private int getMinPrice(){
        int result;
        RadioGroup minPrice = (RadioGroup) findViewById(R.id.minPrice);
        int selectedID = minPrice.getCheckedRadioButtonId();
        switch (selectedID) {
            case R.id.minPrice$:
                return 1;
            case R.id.minPrice$$:
                return 2;

            case R.id.minPrice$$$:
                return 3;
            case R.id.minPrice$$$$:
                return 4;
        }
        return 1;
    }
    private int getMaxPrice(){
        int result;
        RadioGroup minPrice = (RadioGroup) findViewById(R.id.maxPrice);
        int selectedID = minPrice.getCheckedRadioButtonId();
        switch (selectedID) {
            case R.id.maxPrice$:
                return 1;
            case R.id.maxPrice$$:
                return 2;

            case R.id.maxPrice$$$:
                return 3;
            case R.id.maxPrice$$$$:
                return 4;
        }
        return 1;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        final RadioGroup minPrice = (RadioGroup) findViewById(R.id.minPrice);
        minPrice.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
                int selectedRadioID = minPrice.getCheckedRadioButtonId();
                RadioButton max$ = (RadioButton) findViewById(R.id.maxPrice$);
                RadioButton max$$ = (RadioButton) findViewById(R.id.maxPrice$$);
                RadioButton max$$$ = (RadioButton) findViewById(R.id.maxPrice$$$);
                RadioButton max$$$$ = (RadioButton) findViewById(R.id.maxPrice$$$$);

                switch (selectedRadioID){
                    case R.id.minPrice$:
                        max$.setEnabled(true);
                        max$$.setEnabled(true);
                        max$$$.setEnabled(true);
                        max$$$$.setEnabled(true);
                        break;
                    case R.id.minPrice$$:
                        max$.setEnabled(false);
                        max$$.setEnabled(true);
                        max$$$.setEnabled(true);
                        max$$$$.setEnabled(true);
                        break;
                    case R.id.minPrice$$$:
                        max$.setEnabled(false);
                        max$$.setEnabled(false);
                        max$$$.setEnabled(true);
                        max$$$$.setEnabled(true);
                        break;
                    case R.id.minPrice$$$$:
                        max$.setEnabled(false);
                        max$$.setEnabled(false);
                        max$$$.setEnabled(false);
                        max$$$$.setEnabled(true);
                        break;
                }
            }
        });

        final RadioGroup maxPrice = (RadioGroup) findViewById(R.id.maxPrice);
        maxPrice.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
                int selectedRadioId = maxPrice.getCheckedRadioButtonId();
                RadioButton min$ = (RadioButton) findViewById(R.id.minPrice$);
                RadioButton min$$ = (RadioButton) findViewById(R.id.minPrice$$);
                RadioButton min$$$ = (RadioButton) findViewById(R.id.minPrice$$$);
                RadioButton min$$$$ = (RadioButton) findViewById(R.id.minPrice$$$$);

                switch (selectedRadioId){
                    case R.id.maxPrice$:
                        min$.setEnabled(true);
                        min$$.setEnabled(false);
                        min$$$.setEnabled(false);
                        min$$$$.setEnabled(false);
                        break;
                    case R.id.maxPrice$$:
                        min$.setEnabled(true);
                        min$$.setEnabled(true);
                        min$$$.setEnabled(false);
                        min$$$$.setEnabled(false);
                        break;
                    case R.id.maxPrice$$$:
                        min$.setEnabled(true);
                        min$$.setEnabled(true);
                        min$$$.setEnabled(true);
                        min$$$$.setEnabled(false);
                        break;
                    case R.id.maxPrice$$$$:
                        min$.setEnabled(true);
                        min$$.setEnabled(true);
                        min$$$.setEnabled(true);
                        min$$$$.setEnabled(true);
                        break;
                }


            }
        });


        Button saveButton = (Button) findViewById(R.id.saveButton);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (!saveChanges()){
                    Toast.makeText(SettingsActivity.this, "Form was not filled out correctly!",
                            Toast.LENGTH_LONG).show();
                    return;
                }
                Intent intent = new Intent(SettingsActivity.this, MainActivity.class);
                SettingsActivity.this.startActivity(intent);
            }
        });
    }
}
