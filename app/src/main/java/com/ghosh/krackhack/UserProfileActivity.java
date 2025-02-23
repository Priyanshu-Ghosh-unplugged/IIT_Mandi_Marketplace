package com.ghosh.krackhack;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.google.firebase.auth.FirebaseAuth;

public class UserProfileActivity extends AppCompatActivity {

    private TextView emailTextView;
    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);

        emailTextView = findViewById(R.id.emailTextView);
        auth = FirebaseAuth.getInstance();

        // Display user email
        emailTextView.setText(auth.getCurrentUser().getEmail());
    }
}
