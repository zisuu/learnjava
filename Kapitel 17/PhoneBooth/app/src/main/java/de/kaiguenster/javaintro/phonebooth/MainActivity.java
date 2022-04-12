package de.kaiguenster.javaintro.phonebooth;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void callClicked(View view){
        EditText numberField = findViewById(R.id.number);
        String number = numberField.getText().toString();
        Intent next = new Intent(Intent.ACTION_DIAL);
        next.setData(Uri.parse("tel:" + number));
        startActivity(next);
    }
}
