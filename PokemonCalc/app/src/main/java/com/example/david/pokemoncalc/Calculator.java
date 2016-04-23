package com.example.david.pokemoncalc;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class Calculator extends AppCompatActivity {

    private Button homeButton;
    private Button calcButton;
    private Spinner nature;
    private TextView temp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        final double[] natMulti= new double[] {1,1,1,1,1,1};
        //http://www.ahotbrew.com/android-dropdown-spinner-example/
        //start
        nature= (Spinner) findViewById(R.id.spinner);
        String[] natures= new String[] {
                "----V----","Adamant","Bashful","Bold","Brave","Calm","Careful"
                ,"Docile","Gentle","Hardy","Hasty","Impish","Jolly"
                ,"Lax","Lonely","Mild","Modest","Naive","Naughty"
                ,"Quiet","Quirky","Rash","Relaxed","Sassy","Serious"
                ,"Timid"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, natures);
        nature.setAdapter(adapter);
        nature.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Log.v("nature", (String) parent.getItemAtPosition(position));
                for(int i=0; i<6; i++)
                    natMulti[i]=1;
                if (position == 1) {
                    natMulti[1] = 1.1;
                    natMulti[3] = .9;
                }

                if (position == 3) {
                    natMulti[2] = 1.1;
                    natMulti[1] = .9;
                }
                if (position == 4) {
                    natMulti[1] = 1.1;
                    natMulti[5] = .9;
                }
                if (position == 5) {
                    natMulti[4] = 1.1;
                    natMulti[1] = .9;
                }
                if (position == 6) {
                    natMulti[4] = 1.1;
                    natMulti[3] = .9;
                }
                if (position == 8) {
                    natMulti[4] = 1.1;
                    natMulti[2] = .9;
                }
                if (position == 10) {
                    natMulti[5] = 1.1;
                    natMulti[2] = .9;
                }
                if (position == 11) {
                    natMulti[2] = 1.1;
                    natMulti[3] = .9;
                }
                if (position == 12) {
                    natMulti[5] = 1.1;
                    natMulti[3] = .9;
                }
                if (position == 13) {
                    natMulti[2] = 1.1;
                    natMulti[4] = .9;
                }
                if (position == 14) {
                    natMulti[1] = 1.1;
                    natMulti[2] = .9;
                }
                if (position == 15) {
                    natMulti[3] = 1.1;
                    natMulti[2] = .9;
                }
                if (position == 16) {
                    natMulti[3] = 1.1;
                    natMulti[1] = .9;
                }
                if (position == 17) {
                    natMulti[5] = 1.1;
                    natMulti[4] = .9;
                }
                if (position == 18) {
                    natMulti[1] = 1.1;
                    natMulti[4] = .9;
                }
                if (position == 19) {
                    natMulti[3] = 1.1;
                    natMulti[5] = .9;
                }
                if (position == 21) {
                    natMulti[3] = 1.1;
                    natMulti[4] = .9;
                }
                if (position == 22) {
                    natMulti[2] = 1.1;
                    natMulti[5] = .9;
                }
                if (position == 23) {
                    natMulti[4] = 1.1;
                    natMulti[5] = .9;
                }
                if (position == 25) {
                    natMulti[5] = 1.1;
                    natMulti[1] = .9;
                }
            }
                @Override
                public void onNothingSelected (AdapterView < ? > parent){

                }
            }

            );
            //end
            calcButton=(Button) findViewById(R.id.calc);

            calcButton.setOnClickListener(new View.OnClickListener()

            {
                @Override
                public void onClick (View v){
                int hp, atk, def, spAtk, spDef, speed;
                double baseHp = 0, baseAtk = 0, baseDef = 0, baseSpAtk = 0, baseSpDef = 0, baseSpeed = 0, lvl = 0;
                double evHp = 0, evAtk = 0, evDef = 0, evSpAtk = 0, evSpDef = 0, evSpeed = 0;
                double ivHp = 0, ivAtk = 0, ivDef = 0, ivSpAtk = 0, ivSpDef = 0, ivSpeed = 0;
                try {
                    EditText num1 = (EditText) findViewById(R.id.baseHp);
                    if (num1 == null) {
                        Toast t = Toast.makeText(Calculator.this, "Must enter a number greater than 0.", Toast.LENGTH_LONG);
                        t.show();
                        return;
                    } else
                        baseHp = Integer.parseInt(num1.getText().toString());

                    EditText num2 = (EditText) findViewById(R.id.evHp);
                    if (num2 == null) {
                        Toast t = Toast.makeText(Calculator.this, "Must enter a number greater than 0 but less than 255.", Toast.LENGTH_LONG);
                        t.show();
                        return;
                    } else {
                        evHp = Integer.parseInt(num2.getText().toString());
                        if (evHp > 255) {
                            Toast t = Toast.makeText(Calculator.this, "Must enter a number greater than 0 but less than 255.", Toast.LENGTH_LONG);
                            t.show();
                            return;
                        }
                    }

                    EditText num3 = (EditText) findViewById(R.id.ivHp);
                    if (num2 == null) {
                        Toast t = Toast.makeText(Calculator.this, "Must enter a number greater than 0 but less than 31.", Toast.LENGTH_LONG);
                        t.show();
                        return;
                    } else {
                        ivHp = Integer.parseInt(num3.getText().toString());
                        if (ivHp > 31) {
                            Toast t = Toast.makeText(Calculator.this, "Must enter a number greater than 0 but less than 31.", Toast.LENGTH_LONG);
                            t.show();
                            return;
                        }
                    }

                    EditText num4 = (EditText) findViewById(R.id.lvl);
                    if (num4 == null) {
                        Toast t = Toast.makeText(Calculator.this, "Must enter a number greater than 0.", Toast.LENGTH_LONG);
                        t.show();
                        return;
                    } else {
                        lvl = Integer.parseInt(num4.getText().toString());
                        if (evAtk > 100 || lvl <= 0) {
                            Toast t = Toast.makeText(Calculator.this, "Must enter a number greater than 0 but less than or equal to 100.", Toast.LENGTH_LONG);
                            t.show();
                            return;
                        }
                    }

                    StatsCalculator calculator = new StatsCalculator();
                    hp = calculator.calcHp(baseHp, evHp, ivHp, lvl);

                    num1 = (EditText) findViewById(R.id.baseAtk);
                    if (num1 == null) {
                        Toast t = Toast.makeText(Calculator.this, "Must enter a number greater than 0.", Toast.LENGTH_LONG);
                        t.show();
                        return;
                    } else
                        baseAtk = Integer.parseInt(num1.getText().toString());

                    num2 = (EditText) findViewById(R.id.evAtk);
                    if (num2 == null) {
                        Toast t = Toast.makeText(Calculator.this, "Must enter a number greater than 0 but less than 255.", Toast.LENGTH_LONG);
                        t.show();
                        return;
                    } else {
                        evAtk = Integer.parseInt(num2.getText().toString());
                        if (evAtk > 255) {
                            Toast t = Toast.makeText(Calculator.this, "Must enter a number greater than 0 but less than 255.", Toast.LENGTH_LONG);
                            t.show();
                            return;
                        }
                    }

                    num3 = (EditText) findViewById(R.id.ivAtk);
                    if (num3 == null) {
                        Toast t = Toast.makeText(Calculator.this, "Must enter a number greater than 0 but less than 31.", Toast.LENGTH_LONG);
                        t.show();
                        return;
                    } else {
                        ivAtk = Integer.parseInt(num3.getText().toString());
                        if (ivAtk > 31) {
                            Toast t = Toast.makeText(Calculator.this, "Must enter a number greater than 0 but less than 31.", Toast.LENGTH_LONG);
                            t.show();
                            return;
                        }
                    }

                    atk = calculator.calcStat(baseAtk, evAtk, ivAtk, lvl,natMulti[1]);

                    num1 = (EditText) findViewById(R.id.baseDef);
                    if (num1 == null) {
                        Toast t = Toast.makeText(Calculator.this, "Must enter a number greater than 0.", Toast.LENGTH_LONG);
                        t.show();
                        return;
                    } else
                        baseDef = Integer.parseInt(num1.getText().toString());

                    num2 = (EditText) findViewById(R.id.evDef);
                    if (num2 == null) {
                        Toast t = Toast.makeText(Calculator.this, "Must enter a number greater than 0 but less than 255.", Toast.LENGTH_LONG);
                        t.show();
                        return;
                    } else {
                        evDef = Integer.parseInt(num2.getText().toString());
                        if (evDef > 255) {
                            Toast t = Toast.makeText(Calculator.this, "Must enter a number greater than 0 but less than 255.", Toast.LENGTH_LONG);
                            t.show();
                            return;
                        }
                    }

                    num3 = (EditText) findViewById(R.id.ivDef);
                    if (num3 == null) {
                        Toast t = Toast.makeText(Calculator.this, "Must enter a number greater than 0 but less than 31.", Toast.LENGTH_LONG);
                        t.show();
                        return;
                    } else {
                        ivDef = Integer.parseInt(num3.getText().toString());
                        if (ivDef > 31) {
                            Toast t = Toast.makeText(Calculator.this, "Must enter a number greater than 0 but less than 31.", Toast.LENGTH_LONG);
                            t.show();
                            return;
                        }
                    }

                    def = calculator.calcStat(baseDef, evDef, ivDef, lvl, natMulti[2]);

                    num1 = (EditText) findViewById(R.id.baseSpAtk);
                    if (num1 == null) {
                        Toast t = Toast.makeText(Calculator.this, "Must enter a number greater than 0.", Toast.LENGTH_LONG);
                        t.show();
                        return;
                    } else
                        baseSpAtk = Integer.parseInt(num1.getText().toString());

                    num2 = (EditText) findViewById(R.id.evSpAtk);
                    if (num2 == null) {
                        Toast t = Toast.makeText(Calculator.this, "Must enter a number greater than 0 but less than 255.", Toast.LENGTH_LONG);
                        t.show();
                        return;
                    } else {
                        evSpAtk = Integer.parseInt(num2.getText().toString());
                        if (evSpAtk > 255) {
                            Toast t = Toast.makeText(Calculator.this, "Must enter a number greater than 0 but less than 255.", Toast.LENGTH_LONG);
                            t.show();
                            return;
                        }
                    }

                    num3 = (EditText) findViewById(R.id.ivSpAtk);
                    if (num3 == null) {
                        Toast t = Toast.makeText(Calculator.this, "Must enter a number greater than 0 but less than 31.", Toast.LENGTH_LONG);
                        t.show();
                        return;
                    } else {
                        ivSpAtk = Integer.parseInt(num3.getText().toString());
                        if (ivSpAtk > 31) {
                            Toast t = Toast.makeText(Calculator.this, "Must enter a number greater than 0 but less than 31.", Toast.LENGTH_LONG);
                            t.show();
                            return;
                        }
                    }

                    spAtk = calculator.calcStat(baseSpAtk, evSpAtk, ivSpAtk, lvl, natMulti[3]);

                    num1 = (EditText) findViewById(R.id.baseSpDef);
                    if (num1 == null) {
                        Toast t = Toast.makeText(Calculator.this, "Must enter a number greater than 0.", Toast.LENGTH_LONG);
                        t.show();
                        return;
                    } else
                        baseSpDef = Integer.parseInt(num1.getText().toString());

                    num2 = (EditText) findViewById(R.id.evSpDef);
                    if (num2 == null) {
                        Toast t = Toast.makeText(Calculator.this, "Must enter a number greater than 0 but less than 255.", Toast.LENGTH_LONG);
                        t.show();
                        return;
                    } else {
                        evSpDef = Integer.parseInt(num2.getText().toString());
                        if (evSpDef > 255) {
                            Toast t = Toast.makeText(Calculator.this, "Must enter a number greater than 0 but less than 255.", Toast.LENGTH_LONG);
                            t.show();
                            return;
                        }
                    }

                    num3 = (EditText) findViewById(R.id.ivSpDef);
                    if (num3 == null) {
                        Toast t = Toast.makeText(Calculator.this, "Must enter a number greater than 0 but less than 31.", Toast.LENGTH_LONG);
                        t.show();
                        return;
                    } else {
                        ivSpDef = Integer.parseInt(num3.getText().toString());
                        if (ivSpDef > 31) {
                            Toast t = Toast.makeText(Calculator.this, "Must enter a number greater than 0 but less than 31.", Toast.LENGTH_LONG);
                            t.show();
                            return;
                        }
                    }

                    spDef = calculator.calcStat(baseSpDef, evSpDef, ivSpDef, lvl, natMulti[4]);

                    num1 = (EditText) findViewById(R.id.baseSpeed);
                    if (num1 == null) {
                        Toast t = Toast.makeText(Calculator.this, "Must enter a number greater than 0.", Toast.LENGTH_LONG);
                        t.show();
                        return;
                    } else
                        baseSpeed = Integer.parseInt(num1.getText().toString());

                    num2 = (EditText) findViewById(R.id.evSpeed);
                    if (num2 == null) {
                        Toast t = Toast.makeText(Calculator.this, "Must enter a number greater than 0 but less than 255.", Toast.LENGTH_LONG);
                        t.show();
                        return;
                    } else {
                        evSpeed = Integer.parseInt(num2.getText().toString());
                        if (evSpeed > 255) {
                            Toast t = Toast.makeText(Calculator.this, "Must enter a number greater than 0 but less than 255.", Toast.LENGTH_LONG);
                            t.show();
                            return;
                        }
                    }
                    num3 = (EditText) findViewById(R.id.ivSpeed);
                    if (num3 == null) {
                        Toast t = Toast.makeText(Calculator.this, "Must enter a number greater than 0 but less than 31.", Toast.LENGTH_LONG);
                        t.show();
                        return;
                    } else {
                        ivSpeed = Integer.parseInt(num3.getText().toString());
                        if (ivSpeed > 31) {
                            Toast t = Toast.makeText(Calculator.this, "Must enter a number greater than 0 but less than 31.", Toast.LENGTH_LONG);
                            t.show();
                            return;
                        }
                    }

                    speed = calculator.calcStat(baseSpeed, evSpeed, ivSpeed, lvl, natMulti[5]);

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
                    if (temp != null) {
                        temp.setText(speed + "");
                    }
                } catch (Exception e) {

                    Toast t = Toast.makeText(Calculator.this, "Must enter a number. No empty elements.", Toast.LENGTH_LONG);
                    t.show();

                }
            }
            }

            );
            homeButton=(Button) findViewById(R.id.home);

            homeButton.setOnClickListener(new View.OnClickListener()

            {
                @Override
                public void onClick(View v) {
                    finish();
                }
            });

    }

}
