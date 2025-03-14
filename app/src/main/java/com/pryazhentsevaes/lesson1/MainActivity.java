package com.pryazhentsevaes.lesson1;

import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            TextView myTextView = (TextView) findViewById(R.id.textView);
            myTextView.setText("New text in MIREA");
            Button myButton = (Button) findViewById(R.id.button);
            myButton.setText("MireaButton");
            CheckBox myCheckBox = (CheckBox) findViewById(R.id.checkBox);
            myCheckBox.setChecked(true);
            return insets;
        });
    }
}