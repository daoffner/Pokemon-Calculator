package com.example.david.pokemoncalc;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Calculator extends AppCompatActivity {

    private Button homeButton;
    private Button calcButton;
    private TextView temp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        calcButton = (Button) findViewById(R.id.calc);
        calcButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                StatsCalculator calculator = new StatsCalculator();
                int hp=calculator.calcHp(R.id.baseHp, R.id.evHp, R.id.ivHp, R.id.lvl);
                int atk=calculator.calcStat(R.id.baseAtk, R.id.evAtk, R.id.ivAtk, R.id.lvl);
                int def=calculator.calcStat(R.id.baseDef, R.id.evDef, R.id.ivDef, R.id.lvl);
                int spAtk=calculator.calcStat(R.id.baseSpAtk, R.id.evSpAtk, R.id.ivSpAtk, R.id.lvl);
                int spDef=calculator.calcStat(R.id.baseSpDef, R.id.evSpDef, R.id.ivSpDef, R.id.lvl);
                int speed=calculator.calcStat(R.id.baseSpeed, R.id.evSpeed, R.id.ivSpeed, R.id.lvl);
                temp= (TextView) findViewById(R.id.finalHp);
                temp.setText(hp);
                temp= (TextView) findViewById(R.id.finalAtk);
                temp.setText(atk);
                temp= (TextView) findViewById(R.id.finalDef);
                temp.setText(def);
                temp= (TextView) findViewById(R.id.finalSpAtk);
                temp.setText(spAtk);
                temp= (TextView) findViewById(R.id.finalSpDef);
                temp.setText(spDef);
                temp= (TextView) findViewById(R.id.finalSpeed);
                temp.setText(speed);

            }
        });
        homeButton = (Button) findViewById(R.id.home);
        homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                //startActivity(new Intent(Calculator.this, Home.class));
            }
        });

    }

}
