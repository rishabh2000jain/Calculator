package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView upperText, lowerText;
    static String text = "";
    static double number1 = 0, number2 = 0;
    //op type is the type of operation button is pressed like mul,add,sub etc.
    static String opType = "";
    Double lastValue = 0D;
    //dotPress make shore that the dot is pressed only once.
    boolean dotPress = false;
    //opButtonPressed confirms that the operation button is pressed only once.
    boolean opButtonPressed = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        upperText = findViewById(R.id.text_view_upper);
        lowerText = findViewById(R.id.text_view_lower);

    }

    void textSetter(String s) {
        number1 = Double.parseDouble(text);
        lowerText.clearComposingText();
        upperText.setText(text.concat(" "+s));
        text = "";
        opButtonPressed = true;
    }


    public void divFun(View view) {
        if (!opButtonPressed && !text.equals("")) {
            textSetter("/");
            opType = "Div";
            dotPress = false;

        }
    }

    public void mulFun(View view) {
        if (!opButtonPressed && !text.equals("")) {
            textSetter("*");
            opType = "Mul";
            dotPress = false;
        }
    }

    public void subFun(View view) {
        if (!opButtonPressed && !text.equals("")) {
            textSetter("-");
            opType = "Sub";
            dotPress = false;
        }
    }

    public void addFun(View view) {
        if (!opButtonPressed && !text.equals("")) {
            textSetter("+");
            opType = "Add";
            dotPress = false;
        }
    }


    public void equalFun(View view) {
        if (opButtonPressed) {
            number2 = Double.parseDouble(text);
            if (opType.equals("Add")) {
                try {
                    lastValue = number1 + number2;
                } catch (Exception e) {
                    upperText.clearComposingText();
                    lowerText.setText("Error");
                }

                upperText.clearComposingText();
                lowerText.setText(lastValue.toString());
            } else if (opType.equals("Sub")) {
                try {
                    lastValue = number1 - number2;
                } catch (Exception e) {
                    upperText.clearComposingText();
                    lowerText.setText("Error");
                }
                upperText.clearComposingText();
                lowerText.setText(lastValue.toString());
            } else if (opType.equals("Mul")) {
                try {
                    lastValue = number1 * number2;
                } catch (Exception e) {
                    upperText.clearComposingText();
                    lowerText.setText("Error");
                }
                upperText.clearComposingText();
                lowerText.setText(lastValue.toString());
            } else if (opType.equals("Div")) {
                try {
                    lastValue = number1 / number2;
                } catch (Exception e) {
                    upperText.clearComposingText();
                    lowerText.setText("Error");
                }
                upperText.clearComposingText();
                lowerText.setText(lastValue.toString());
            }
            opButtonPressed = false;
            number1 = 0;
            number2 = 0;
            text = "";

        }
    }


    public void clickAction(View v) {
        switch (v.getId()) {
            case R.id.b0:
                text = text.concat("0");
                lowerText.setText(text);
                break;
            case R.id.b1:
                text = text.concat("1");
                lowerText.setText(text);
                break;
            case R.id.b2:
                text = text.concat("2");
                lowerText.setText(text);
                break;
            case R.id.b3:
                text = text.concat("3");
                lowerText.setText(text);
                break;
            case R.id.b4:
                text = text.concat("4");
                lowerText.setText(text);
                break;
            case R.id.b5:
                text = text.concat("5");
                lowerText.setText(text);
                break;
            case R.id.b6:
                text = text.concat("6");
                lowerText.setText(text);
                break;
            case R.id.b7:
                text = text.concat("7");
                lowerText.setText(text);
                break;
            case R.id.b8:
                text = text.concat("8");
                lowerText.setText(text);
                break;
            case R.id.b9:
                text = text.concat("9");
                lowerText.setText(text);
                break;
            case R.id.b_dot:
                if (!dotPress) {
                    text = text.concat(".");
                    lowerText.setText(text);
                    dotPress = true;

                } else {
                    Toast.makeText(this, "Dot is on valid once in a number", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.resetButton:
                upperText.setText("");
                lowerText.setText("");
                text="";
                number2=0;
                number1=0;
                opButtonPressed = false;
                dotPress = false;
                lastValue = 0D;
                opType = "";
                break;
            case R.id.resultButton:
                number1=lastValue;
                lowerText.setText("");
                upperText.setText(lastValue.toString());
                break;


        }
    }
}
