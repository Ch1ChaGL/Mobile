package com.example.a1krsonya;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Main extends AppCompatActivity {

    private ArrayAdapter<String> arad;

    EditText num1, num2;
    ListView lw;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        num1 = (EditText) findViewById(R.id.num1);
        num2 = (EditText) findViewById(R.id.num2);
        lw = (ListView) findViewById(R.id.lw);
        arad=new ArrayAdapter<String>(this,R.layout.le);
        lw.setAdapter(arad);
    }

    public void plus(View view){
        // Получаем значения из EditText
        String input1 = num1.getText().toString();
        String input2 = num2.getText().toString();

        // Проверяем, что оба ввода не пусты
        if (!input1.isEmpty() && !input2.isEmpty()) {
            // Преобразуем строки в числа
            int number1 = Integer.parseInt(input1);
            int number2 = Integer.parseInt(input2);

            // Складываем числа
            int sum = number1 + number2;
            String answer = ""+sum + " = " + number1 + " + " + number2;
            arad.add(answer);
        }
    }
    public void minus(View view){
        // Получаем значения из EditText
        String input1 = num1.getText().toString();
        String input2 = num2.getText().toString();

        // Проверяем, что оба ввода не пусты
        if (!input1.isEmpty() && !input2.isEmpty()) {
            // Преобразуем строки в числа
            int number1 = Integer.parseInt(input1);
            int number2 = Integer.parseInt(input2);

            // Складываем числа
            int sum = number1 - number2;
            String answer = ""+sum + " = " + number1 + " - " + number2;
            arad.add(answer);
        }
    }

    public void multiply(View view){
        // Получаем значения из EditText
        String input1 = num1.getText().toString();
        String input2 = num2.getText().toString();

        // Проверяем, что оба ввода не пусты
        if (!input1.isEmpty() && !input2.isEmpty()) {
            // Преобразуем строки в числа
            int number1 = Integer.parseInt(input1);
            int number2 = Integer.parseInt(input2);

            // Складываем числа
            int sum = number1 * number2;
            String answer = ""+sum + " = " + number1 + " * " + number2;
            arad.add(answer);
        }
    }

    public void devided(View view){
        // Получаем значения из EditText
        String input1 = num1.getText().toString();
        String input2 = num2.getText().toString();

        // Проверяем, что оба ввода не пусты
        if (!input1.isEmpty() && !input2.isEmpty()) {
            // Преобразуем строки в числа
            int number1 = Integer.parseInt(input1);
            int number2 = Integer.parseInt(input2);

            if (number2 == 0) return;
            // Складываем числа
            double sum = (double) number1 / (double) number2;
            String answer = ""+sum + " = " + number1 + " / " + number2;
            arad.add(answer);
        }
    }

    public void clear(View view){
        arad.clear();
    }

}
