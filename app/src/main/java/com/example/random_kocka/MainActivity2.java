package com.example.random_kocka;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Declare palette
        EditText min_value = findViewById(R.id.min_id);
        EditText max_value = findViewById(R.id.max_id);
        Button button = findViewById(R.id.button);
        TextView rez = findViewById(R.id.generated_number);

        // On click function
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random random = new Random();
                int min = Integer.parseInt(min_value.getText().toString());
                int max = Integer.parseInt(max_value.getText().toString());

                int random_value = random.nextInt(
                        (max - min + 1 ) - min
                );
                rez.setText(random_value+"");

            }
        });

    }
}