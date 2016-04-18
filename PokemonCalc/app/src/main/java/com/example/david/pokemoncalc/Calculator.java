package com.example.david.pokemoncalc;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
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
                int hp, atk, def, spAtk, spDef, speed;
                double baseHp, baseAtk, baseDef, baseSpAtk, baseSpDef, baseSpeed, lvl;
                double evHp, evAtk, evDef, evSpAtk, evSpDef, evSpeed;
                double ivHp, ivAtk, ivDef, ivSpAtk, ivSpDef, ivSpeed;

                EditText num1 = (EditText) findViewById(R.id.baseHp) ;
                baseHp = Integer.parseInt(num1.getText().toString());
                EditText num2 = (EditText) findViewById(R.id.evHp) ;
                evHp = Integer.parseInt(num2.getText().toString());
                EditText num3 = (EditText) findViewById(R.id.ivHp) ;
                ivHp = Integer.parseInt(num3.getText().toString());
                EditText num4 = (EditText) findViewById(R.id.lvl) ;
                lvl = Integer.parseInt(num4.getText().toString());

                StatsCalculator calculator = new StatsCalculator();
                hp = calculator.calcHp(baseHp, evHp, ivHp, lvl);

                num1 = (EditText) findViewById(R.id.baseAtk) ;
                baseAtk = Integer.parseInt(num1.getText().toString());
                num2 = (EditText) findViewById(R.id.evAtk) ;
                evAtk = Integer.parseInt(num2.getText().toString());
                num3 = (EditText) findViewById(R.id.ivAtk) ;
                ivAtk = Integer.parseInt(num3.getText().toString());
                atk = calculator.calcStat(baseAtk, evAtk, ivAtk, lvl);

                num1 = (EditText) findViewById(R.id.baseDef) ;
                baseDef = Integer.parseInt(num1.getText().toString());
                num2 = (EditText) findViewById(R.id.evDef) ;
                evDef = Integer.parseInt(num2.getText().toString());
                num3 = (EditText) findViewById(R.id.ivDef) ;
                ivDef = Integer.parseInt(num3.getText().toString());
                def = calculator.calcStat(baseDef, evDef, ivDef, lvl);

                num1 = (EditText) findViewById(R.id.baseSpAtk) ;
                baseSpAtk = Integer.parseInt(num1.getText().toString());
                num2 = (EditText) findViewById(R.id.evSpAtk) ;
                evSpAtk = Integer.parseInt(num2.getText().toString());
                num3 = (EditText) findViewById(R.id.ivSpAtk) ;
                ivSpAtk = Integer.parseInt(num3.getText().toString());
                spAtk = calculator.calcStat(baseSpAtk, evSpAtk, ivSpAtk, lvl);

                num1 = (EditText) findViewById(R.id.baseSpDef) ;
                baseSpDef = Integer.parseInt(num1.getText().toString());
                num2 = (EditText) findViewById(R.id.evSpDef) ;
                evSpDef = Integer.parseInt(num2.getText().toString());
                num3 = (EditText) findViewById(R.id.ivSpDef) ;
                ivSpDef = Integer.parseInt(num3.getText().toString());
                spDef = calculator.calcStat(baseSpDef, evSpDef, ivSpDef, lvl);

                num1 = (EditText) findViewById(R.id.baseSpeed) ;
                baseSpeed = Integer.parseInt(num1.getText().toString());
                num2 = (EditText) findViewById(R.id.evSpeed) ;
                evSpeed = Integer.parseInt(num2.getText().toString());
                num3 = (EditText) findViewById(R.id.ivSpeed) ;
                ivSpeed = Integer.parseInt(num3.getText().toString());
                speed = calculator.calcStat(baseSpeed, evSpeed, ivSpeed, lvl);

                temp = (TextView) findViewById(R.id.finalHp);
                if (temp != null) {

                    temp.setText(hp + "");
                }
                temp = (TextView) findViewById(R.id.finalAtk);
                if (temp != null) {
                    temp.setText(atk + "");
                }
                temp = (TextView) findViewById(R.id.finalDef);
                if (temp != null) {
                    temp.setText(def + "");
                }
                temp = (TextView) findViewById(R.id.finalSpAtk);
                if (temp != null) {
                    temp.setText(spAtk + "");
                }
                temp = (TextView) findViewById(R.id.finalSpDef);
                if (temp != null) {
                    temp.setText(spDef + "");
                }
                temp = (TextView) findViewById(R.id.finalSpeed);
                assert temp != null;
                temp.setText(speed+"");

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
