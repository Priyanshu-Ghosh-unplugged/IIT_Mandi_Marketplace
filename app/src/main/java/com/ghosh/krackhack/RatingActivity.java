package com.ghosh.krackhack;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RatingActivity extends AppCompatActivity {

    private RatingBar ratingBar;
    private Button submitButton;
    private DatabaseReference ratingsRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rating);

        ratingBar = findViewById(R.id.ratingBar);
        submitButton = findViewById(R.id.submitButton);
        ratingsRef = FirebaseDatabase.getInstance().getReference("ratings");

        submitButton.setOnClickListener(v -> {
            float rating = ratingBar.getRating();
            submitRating(rating);
        });
    }

    private void submitRating(float rating) {
        String ratingId = ratingsRef.push().getKey();
        ratingsRef.child(ratingId).setValue(rating);
        Toast.makeText(this, "Rating submitted", Toast.LENGTH_SHORT).show();
    }
}
