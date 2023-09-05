package com.example.a4;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class Main extends AppCompatActivity {
    EditText numberOne, numberTwo;
    TextView result;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.main_act);
        numberOne = (EditText) findViewById(R.id.num1);
        numberTwo = (EditText) findViewById(R.id.num2);

        result = (TextView) findViewById(R.id.result);
    }

    public boolean hasErr(EditText num1, EditText num2){
        if(num1.getText().toString().equals("") || num2.getText().toString().equals("")) {
            Toast.makeText(this, "Не все поля заполнены", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }
    public void toPlus(View view){
        if (!hasErr(numberOne, numberTwo)) return;
        else{
            double num1 = Double.valueOf(numberOne.getText().toString());
            double num2 = Double.valueOf(numberTwo.getText().toString());
            double res = num1+num2;
            result.setText(String.valueOf(num1) + " + " + String.valueOf(num2) + " = " + String.valueOf(res));
        }

    }
    public void toMinus(View view){
        if (!hasErr(numberOne, numberTwo)) return;
        else {
            double num1 = Double.valueOf(numberOne.getText().toString());
            double  num2 = Double.valueOf(numberTwo.getText().toString());
            double res = num1 - num2;
            result.setText(String.valueOf(num1) + " - " + String.valueOf(num2) + " = " + String.valueOf(res));
        }

    }
    public void toMultiply(View view){

        if (!hasErr(numberOne, numberTwo)) return;
        else {
            double num1 = Double.valueOf(numberOne.getText().toString());
            double num2 = Double.valueOf(numberTwo.getText().toString());
            double res = num1 * num2;

            result.setText(String.valueOf(num1) + " * " + String.valueOf(num2) + " = " + String.valueOf(res));
        }

    }
    public void toDivided(View view) {
        if (!hasErr(numberOne, numberTwo)) return;
        else {
            try {
                double num1 = Double.valueOf(numberOne.getText().toString());
                double num2 = Double.valueOf(numberTwo.getText().toString());

                if (num2 == 0) {
                    throw new Exception("Деление на 0 не возможно");
                }

                double res = num1 / num2;

                result.setText(String.valueOf(num1) + " / " + String.valueOf(num2) + " = " + String.valueOf(res));

            } catch (Exception ex) {
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setMessage("Делить на 0 нельзя")
                        .setTitle("Erorr")
                        .setPositiveButton("Продолжить", (dialog, which) -> result.setText("Error"));
                AlertDialog dialog = builder.create();
                dialog.show();

                //Toast.makeText(this, ex.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                //result.setText("NaN");
            }
        }

    }
}
