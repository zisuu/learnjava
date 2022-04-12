package de.kaiguenster.javaintro.helloandroidv1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_NAME = "de.kaiguenster.helloandroidv1.NAME";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void doneClicked(View view){
        EditText textField = findViewById(R.id.inputName);
        String name = textField.getText().toString();
        Intent next = new Intent(this, GreetingActivity.class);
        next.putExtra(EXTRA_NAME, name);
        startActivity(next);
    }
}
