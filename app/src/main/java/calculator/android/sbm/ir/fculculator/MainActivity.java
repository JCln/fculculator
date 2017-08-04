package calculator.android.sbm.ir.fculculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import calculator.android.sbm.ir.fculculator.calculation.Calc;
import calculator.android.sbm.ir.fculculator.calculation.ICalc;

public class MainActivity extends AppCompatActivity {
    ICalc evaluation =new Calc();
    boolean flag ;
    int historyCounter = 1;
    Button button1, button2, button3, button4, button5,
            button6, button7, button8, button9, buttonC,
            button0, buttonOK , cleanButton;
    Button buttonMinus, buttonPlus, buttonDivide, buttonMultiply;
    TextView firstTextView, resultTextView , historyTextView;
    ListView historylistView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initializeItems();
        setAllClickListeners();
  }

    private void setAllOperatorClickListeners() {
        setNumPlusClickListener();
        setNumMinusClickListener();
        setNumMultiplyClickListener();
        setNumDivideClickListener();
    }

    private void eval() {
       String s=firstTextView.getText().toString();
        resultTextView.setText(evaluation.eval(s).toString());
    }

    private void initializeItems() {
        setNumberButton();
        setOperatorButton();
        initializedTexts();
    }

    private void setNumberButton() {
        button0 = (Button) findViewById(R.id.button0);
        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);
        button4 = (Button) findViewById(R.id.button4);
        button5 = (Button) findViewById(R.id.button5);
        button6 = (Button) findViewById(R.id.button6);
        button7 = (Button) findViewById(R.id.button7);
        button8 = (Button) findViewById(R.id.button8);
        button9 = (Button) findViewById(R.id.button9);
        buttonC = (Button) findViewById(R.id.buttonClear);
        cleanButton = (Button) findViewById(R.id.cleanButton);
        buttonOK = (Button) findViewById(R.id.buttonOK);
    }

    private void setOperatorButton() {
        buttonMinus = (Button) findViewById(R.id.buttonMinus);
        buttonPlus = (Button) findViewById(R.id.buttonPlus);
        buttonDivide = (Button) findViewById(R.id.buttonDivide);
        buttonMultiply = (Button) findViewById(R.id.buttonMultiply);
    }

    private void initializedTexts() {
        firstTextView = (TextView) findViewById(R.id.firstTextView);
        resultTextView = (TextView) findViewById(R.id.resultTextView);
        historyTextView = (TextView) findViewById(R.id.textViewHistory);
        //historylistView=(ListView) findViewById(R.id.listViewHistory);
    }

    private void setAllClickListeners() {
        setButton0();
        setButton1();
        setButton2();
        setButton3();
        setButton4();
        setButton4();
        setButton5();
        setButton6();
        setButton7();
        setButton8();
        setButton9();
        setButtonC();
        setCleanButton();
        setButtonEqualClickListener();
        setAllOperatorClickListeners();
    }

    private void setNumPlusClickListener() {
        buttonPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                   if (!firstTextView.getText().toString().isEmpty() && bugOperators((flag))) {
                           firstTextView.append("+");
                       }
                   else
                       ABRToast();
            }
        });
    }

    private void setNumMinusClickListener() {
        buttonMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!firstTextView.getText().toString().isEmpty() && bugOperators((flag))) {
                    firstTextView.append("-");
                }
                else
                    ABRToast();
            }
        });
    }

    private void setNumMultiplyClickListener() {
        buttonMultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!firstTextView.getText().toString().isEmpty() && bugOperators((flag))) {
                    firstTextView.append("*");
                }
                else
                    ABRToast();
            }
        });
    }

    private void setNumDivideClickListener() {
        buttonDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!firstTextView.getText().toString().isEmpty() && bugOperators((flag))) {
                    firstTextView.append("/");
                }
                else
                    ABRToast();
            }
        });
    }

    private void ABRToast(){
        Toast.makeText(getApplicationContext(), "enter number", Toast.LENGTH_SHORT).show();
    }

    private void setButton0() {
        button0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                firstTextView.append("0");
            }
        });
    }

    private void setButton1() {
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                firstTextView.append("1");
            }
        });
    }

    private void setButton2() {
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                firstTextView.append("2");
            }
        });
    }

    private void setButton3() {
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                firstTextView.append("3");
            }
        });
    }

    private void setButton9() {
        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                firstTextView.append("9");
            }
        });
    }

    private void setButton4() {
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                firstTextView.append("4");
            }
        });

    }

    private void setButton6() {
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                firstTextView.append("6");
            }
        });
    }

    private void setButton7() {
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                firstTextView.append("7");
            }
        });
    }

    private void setButton5() {
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                button5.setEnabled(true);
                firstTextView.append("5");
            }
        });
    }

    private void setButton8() {
        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                button8.setEnabled(true);
                firstTextView.append("8");
            }
        });
    }

    private void setButtonC() {
        buttonC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String a = firstTextView.getText().toString();
                if (a.length() > 0) {
                    firstTextView.setText(a.substring(0 , a.length() -1));
                }
            }
        });
    }

    private void setCleanButton() {
        cleanButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                firstTextView.setText(null);
                resultTextView.setText(null);
                historyTextView.setText(null);
                historyCounter = 1;
            }
        });
    }
    private void setButtonEqualClickListener() {
        buttonOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    eval();
                    String newline="\n";
                    String s =firstTextView.getText().toString();
                    String b =resultTextView.getText().toString();
                    historyTextView.append(" "+historyCounter + " : "+ s + " = " + b );
                    historyCounter++;
                    historyTextView.append(newline);
                    historyTextView.setMovementMethod(new ScrollingMovementMethod());
                } catch (Exception e) {
                    ABRToast();
                }
            }
        });
    }

    private boolean bugOperators(Boolean flag) {
        String s = firstTextView.getText().toString();
        if (s.endsWith("+") || s.endsWith("-") || s.endsWith("*") || s.endsWith("/")) {
            ABRToast();
            return false;
        }
        else {
            eval();
            return true;
        }
    }
}
