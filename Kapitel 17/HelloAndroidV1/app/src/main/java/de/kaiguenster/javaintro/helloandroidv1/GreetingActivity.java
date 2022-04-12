package de.kaiguenster.javaintro.helloandroidv1;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class GreetingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_greeting);

        Intent caller = getIntent();
        String name = caller.getStringExtra(MainActivity.EXTRA_NAME);
        String greeting = String.format("Hallo %s!", name);
        TextView tv = new TextView(this);
        tv.setText(greeting);
        ViewGroup layout = (RelativeLayout) findViewById(R.id.greeting_content);
        layout.addView(tv);
    }
}
