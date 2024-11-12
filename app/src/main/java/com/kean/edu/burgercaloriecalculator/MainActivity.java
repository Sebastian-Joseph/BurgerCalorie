package com.kean.edu.burgercaloriecalculator;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;
import android.view.View.OnClickListener;

public class MainActivity extends AppCompatActivity {
    private Burger burger;

    private RadioGroup pattyRG;
    private CheckBox prosciuttoCBX;
    private RadioGroup cheeseRG;
    private SeekBar sauceSBR;
    private TextView caloriesTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        burger = new Burger();
        initialize();
        registerChangeListener();
    }

    private void initialize() {
        pattyRG = findViewById(R.id.radioGroup);
        prosciuttoCBX = findViewById(R.id.checkBox);
        cheeseRG = findViewById(R.id.radioGroup2);
        sauceSBR = findViewById(R.id.seekBar);
        caloriesTV = findViewById(R.id.caloriesText);
        displayCalories();

        if (caloriesTV == null) {
            System.out.println("caloriesTV is null.");
        }

    }

    private void registerChangeListener() {
        pattyRG.setOnCheckedChangeListener(foodListener);
        cheeseRG.setOnCheckedChangeListener(foodListener);
        prosciuttoCBX.setOnClickListener(baconListener);
        sauceSBR.setOnSeekBarChangeListener(sauceListener);
    }


    private RadioGroup.OnCheckedChangeListener foodListener = new RadioGroup.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup rbGroup, int radioId) {
            if (rbGroup == pattyRG) {
                updatePattyCalories(radioId);
            } else if (rbGroup == cheeseRG) {
                updateCheeseCalories(radioId);
            }
            displayCalories();
        }
    };

    private void updatePattyCalories(int radioId) {
        if (radioId == R.id.radioButton) {
            burger.setPattyCalories(Burger.BEEF);
        } else if (radioId == R.id.radioButton2) {
            burger.setPattyCalories(Burger.LAMB);
        } else if (radioId == R.id.radioButton3) {
            burger.setPattyCalories(Burger.OSTRICH);
        }
        System.out.println("Patty calories set to: " + burger.getTotalCalories());
    }


    private void updateCheeseCalories(int radioId) {
        if (radioId == R.id.radioButton4) {
            burger.setCheeseCalories(Burger.ASIAGO);
        } else if (radioId == R.id.radioButton5) {
            burger.setCheeseCalories(Burger.CREME_FRAICHE);
        }
    }

    private OnClickListener baconListener = new OnClickListener() {
        @Override
        public void onClick(View v) {
            if (((CheckBox) v).isChecked()) {
                burger.setProsciuttoCalories(Burger.PROSCIUTTO);
            } else {
                burger.clearProsciuttoCalories();
            }
            displayCalories();
        }
    };

    private SeekBar.OnSeekBarChangeListener sauceListener = new SeekBar.OnSeekBarChangeListener() {
        @Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            burger.setSauceCalories(progress);
            displayCalories();
        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {
            // Optional: Handle touch start if needed
        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {
            // Optional: Handle touch stop if needed
        }
    };

    private void displayCalories() {
        runOnUiThread(() -> {
            String calorieText = "Calories: " + burger.getTotalCalories();
            System.out.println("Setting calories TextView: " + calorieText);
            caloriesTV.setText(calorieText);
        });
    }



}
