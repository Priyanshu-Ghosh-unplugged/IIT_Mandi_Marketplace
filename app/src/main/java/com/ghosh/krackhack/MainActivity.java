package com.ghosh.krackhack;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private Button addListingButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);
        addListingButton = findViewById(R.id.searchEditText);

        addListingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AddListingActivity.class);
                startActivity(intent);
            }
        });

        // Use Snackbar for user feedback
        Snackbar.make(findViewById(android.R.id.content), "Message sent", Snackbar.LENGTH_SHORT).show();


        // Load listings into the ListView (you'll need to implement this)


        //        registerUser("test@example.com", "password123");

    }

    private void registerUser(String email, String password) {
        FirebaseAuth.getInstance().createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, task -> {
                    if (task.isSuccessful()) {
                        // Registration successful
                        Toast.makeText(this, "Registration successful", Toast.LENGTH_SHORT).show();
                    } else {
                        // Registration failed
                        Toast.makeText(this, "Registration failed: " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
    }
}
