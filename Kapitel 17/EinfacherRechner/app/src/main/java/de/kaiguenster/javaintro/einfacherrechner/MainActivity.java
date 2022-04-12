package de.kaiguenster.javaintro.einfacherrechner;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void add(View view) {
        EditText numberOneField = (EditText) findViewById(R.id.numberOne);
        EditText numberTwoField = (EditText) findViewById(R.id.numberTwo);
        TextView sumField = (TextView) findViewById(R.id.sum);
        try {
            int numberOne = Integer.parseInt(numberOneField.getText().toString());
            int numberTwo = Integer.parseInt(numberTwoField.getText().toString());
            int sum = numberOne + numberTwo;
            sumField.setText(Integer.toString(sum));
        } catch(NumberFormatException e){
            sumField.setText("Fehler!");
        }
    }
}
