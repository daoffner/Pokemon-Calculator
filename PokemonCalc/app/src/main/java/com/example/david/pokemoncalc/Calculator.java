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
import android.widget.Toast;

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
                double baseHp = 0, baseAtk = 0, baseDef = 0, baseSpAtk = 0, baseSpDef = 0, baseSpeed = 0, lvl = 0;
                double evHp = 0, evAtk = 0, evDef = 0, evSpAtk = 0, evSpDef = 0, evSpeed = 0;
                double ivHp = 0, ivAtk = 0, ivDef = 0, ivSpAtk = 0, ivSpDef = 0, ivSpeed = 0;
                try {
                    EditText num1 = (EditText) findViewById(R.id.baseHp);
                    if (num1 == null) {
                        Toast t = Toast.makeText(Calculator.this, "Must enter a number greater than 0.", Toast.LENGTH_LONG);
                        t.show();     return;
                    } else
                        baseHp = Integer.parseInt(num1.getText().toString());

                    EditText num2 = (EditText) findViewById(R.id.evHp);
                    if (num2 == null) {
                        Toast t = Toast.makeText(Calculator.this, "Must enter a number greater than 0 but less than 255.", Toast.LENGTH_LONG);
                        t.show();     return;
                    } else {
                        evHp = Integer.parseInt(num2.getText().toString());
                        if (evHp >= 255) {
                            Toast t = Toast.makeText(Calculator.this, "Must enter a number greater than 0 but less than 255.", Toast.LENGTH_LONG);
                            t.show();     return;
                        }
                    }

                    EditText num3 = (EditText) findViewById(R.id.ivHp);
                    if (num2 == null) {
                        Toast t = Toast.makeText(Calculator.this, "Must enter a number greater than 0 but less than 31.", Toast.LENGTH_LONG);
                        t.show();     return;
                    } else {
                        ivHp = Integer.parseInt(num3.getText().toString());
                        if (ivHp >= 31) {
                            Toast t = Toast.makeText(Calculator.this, "Must enter a number greater than 0 but less than 31.", Toast.LENGTH_LONG);
                            t.show();     return;
                        }
                    }

                    EditText num4 = (EditText) findViewById(R.id.lvl);
                    if (num4 == null) {
                        Toast t = Toast.makeText(Calculator.this, "Must enter a number greater than 0.", Toast.LENGTH_LONG);
                        t.show();     return;
                    } else
                        lvl = Integer.parseInt(num4.getText().toString());

                    StatsCalculator calculator = new StatsCalculator();
                    hp = calculator.calcHp(baseHp, evHp, ivHp, lvl);

                    num1 = (EditText) findViewById(R.id.baseAtk);
                    if (num1 == null) {
                        Toast t = Toast.makeText(Calculator.this, "Must enter a number greater than 0.", Toast.LENGTH_LONG);
                        t.show();     return;
                    } else
                        baseAtk = Integer.parseInt(num1.getText().toString());

                    num2 = (EditText) findViewById(R.id.evAtk);
                    if (num2 == null) {
                        Toast t = Toast.makeText(Calculator.this, "Must enter a number greater than 0 but less than 255.", Toast.LENGTH_LONG);
                        t.show();     return;
                    } else {
                        evAtk = Integer.parseInt(num2.getText().toString());
                        if (evAtk >= 255) {
                            Toast t = Toast.makeText(Calculator.this, "Must enter a number greater than 0 but less than 255.", Toast.LENGTH_LONG);
                            t.show();     return;
                        }
                    }

                    num3 = (EditText) findViewById(R.id.ivAtk);
                    if (num3 == null) {
                        Toast t = Toast.makeText(Calculator.this, "Must enter a number greater than 0 but less than 31.", Toast.LENGTH_LONG);
                        t.show();     return;
                    } else {
                        ivAtk = Integer.parseInt(num3.getText().toString());
                        if (ivAtk >= 31) {
                            Toast t = Toast.makeText(Calculator.this, "Must enter a number greater than 0 but less than 31.", Toast.LENGTH_LONG);
                            t.show();     return;
                        }
                    }

                    atk = calculator.calcStat(baseAtk, evAtk, ivAtk, lvl);

                    num1 = (EditText) findViewById(R.id.baseDef);
                    if (num1 == null) {
                        Toast t = Toast.makeText(Calculator.this, "Must enter a number greater than 0.", Toast.LENGTH_LONG);
                        t.show();     return;
                    } else
                        baseDef = Integer.parseInt(num1.getText().toString());

                    num2 = (EditText) findViewById(R.id.evDef);
                    if (num2 == null) {
                        Toast t = Toast.makeText(Calculator.this, "Must enter a number greater than 0 but less than 255.", Toast.LENGTH_LONG);
                        t.show();     return;
                    } else {
                        evDef = Integer.parseInt(num2.getText().toString());
                        if (evDef >= 255) {
                            Toast t = Toast.makeText(Calculator.this, "Must enter a number greater than 0 but less than 255.", Toast.LENGTH_LONG);
                            t.show();     return;
                        }
                    }

                    num3 = (EditText) findViewById(R.id.ivDef);
                    if (num3 == null) {
                        Toast t = Toast.makeText(Calculator.this, "Must enter a number greater than 0 but less than 31.", Toast.LENGTH_LONG);
                        t.show();     return;
                    } else {
                        ivDef = Integer.parseInt(num3.getText().toString());
                        if (ivDef >= 31) {
                            Toast t = Toast.makeText(Calculator.this, "Must enter a number greater than 0 but less than 31.", Toast.LENGTH_LONG);
                            t.show();     return;
                        }
                    }

                    def = calculator.calcStat(baseDef, evDef, ivDef, lvl);

                    num1 = (EditText) findViewById(R.id.baseSpAtk);
                    if (num1 == null) {
                        Toast t = Toast.makeText(Calculator.this, "Must enter a number greater than 0.", Toast.LENGTH_LONG);
                        t.show();     return;
                    } else
                        baseSpAtk = Integer.parseInt(num1.getText().toString());

                    num2 = (EditText) findViewById(R.id.evSpAtk);
                    if (num2 == null) {
                        Toast t = Toast.makeText(Calculator.this, "Must enter a number greater than 0 but less than 255.", Toast.LENGTH_LONG);
                        t.show();     return;
                    } else {
                        evSpAtk = Integer.parseInt(num2.getText().toString());
                        if (evSpAtk >= 255) {
                            Toast t = Toast.makeText(Calculator.this, "Must enter a number greater than 0 but less than 255.", Toast.LENGTH_LONG);
                            t.show();     return;
                        }
                    }

                    num3 = (EditText) findViewById(R.id.ivSpAtk);
                    if (num3 == null) {
                        Toast t = Toast.makeText(Calculator.this, "Must enter a number greater than 0 but less than 31.", Toast.LENGTH_LONG);
                        t.show();     return;
                    } else {
                        ivSpAtk = Integer.parseInt(num3.getText().toString());
                        if (ivSpAtk >= 31) {
                            Toast t = Toast.makeText(Calculator.this, "Must enter a number greater than 0 but less than 31.", Toast.LENGTH_LONG);
                            t.show();     return;
                        }
                    }

                    spAtk = calculator.calcStat(baseSpAtk, evSpAtk, ivSpAtk, lvl);

                    num1 = (EditText) findViewById(R.id.baseSpDef);
                    if (num1 == null) {
                        Toast t = Toast.makeText(Calculator.this, "Must enter a number greater than 0.", Toast.LENGTH_LONG);
                        t.show();     return;
                    } else
                        baseSpDef = Integer.parseInt(num1.getText().toString());

                    num2 = (EditText) findViewById(R.id.evSpDef);
                    if (num2 == null) {
                        Toast t = Toast.makeText(Calculator.this, "Must enter a number greater than 0 but less than 255.", Toast.LENGTH_LONG);
                        t.show();     return;
                    } else {
                        evSpDef = Integer.parseInt(num2.getText().toString());
                        if (evSpDef >= 255) {
                            Toast t = Toast.makeText(Calculator.this, "Must enter a number greater than 0 but less than 255.", Toast.LENGTH_LONG);
                            t.show();     return;
                        }
                    }

                    num3 = (EditText) findViewById(R.id.ivSpDef);
                    if (num3 == null) {
                        Toast t = Toast.makeText(Calculator.this, "Must enter a number greater than 0 but less than 31.", Toast.LENGTH_LONG);
                        t.show();     return;
                    } else {
                        ivSpDef = Integer.parseInt(num3.getText().toString());
                        if (ivSpDef >= 31) {
                            Toast t = Toast.makeText(Calculator.this, "Must enter a number greater than 0 but less than 31.", Toast.LENGTH_LONG);
                            t.show();     return;
                        }
                    }

                    spDef = calculator.calcStat(baseSpDef, evSpDef, ivSpDef, lvl);

                    num1 = (EditText) findViewById(R.id.baseSpeed);
                    if (num1 == null) {
                        Toast t = Toast.makeText(Calculator.this, "Must enter a number greater than 0.", Toast.LENGTH_LONG);
                        t.show();     return;
                    } else
                        baseSpeed = Integer.parseInt(num1.getText().toString());

                    num2 = (EditText) findViewById(R.id.evSpeed);
                    if (num2 == null) {
                        Toast t = Toast.makeText(Calculator.this, "Must enter a number greater than 0 but less than 255.", Toast.LENGTH_LONG);
                        t.show();     return;
                    } else {
                        evSpeed = Integer.parseInt(num2.getText().toString());
                        if (evSpeed >= 255) {
                            Toast t = Toast.makeText(Calculator.this, "Must enter a number greater than 0 but less than 255.", Toast.LENGTH_LONG);
                            t.show();     return;
                        }
                    }
                    num3 = (EditText) findViewById(R.id.ivSpeed);
                    if (num3 == null) {
                        Toast t = Toast.makeText(Calculator.this, "Must enter a number greater than 0 but less than 31.", Toast.LENGTH_LONG);
                        t.show();     return;
                    } else {
                        ivSpeed = Integer.parseInt(num3.getText().toString());
                        if (ivSpeed >= 31) {
                            Toast t = Toast.makeText(Calculator.this, "Must enter a number greater than 0 but less than 31.", Toast.LENGTH_LONG);
                            t.show();     return;
                        }
                    }

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
                    temp.setText(speed + "");
                } catch (Exception e) {

                    System.out.print("Must enter a number no empty elements.");

                }
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
