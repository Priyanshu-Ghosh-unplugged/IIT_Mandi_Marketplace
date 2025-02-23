package com.ghosh.krackhack;

import android.net.Uri;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

public class Listing {
    private String title;
    private String price;
    private String condition;

    public Listing() {} // Default constructor required for calls to DataSnapshot.getValue(Listing.class)

    public Listing(String title, String price, String condition) {
        this.title = title;
        this.price = price;
        this.condition = condition;
    }

    // Getters and setters...

    private void addListing(Listing listing) {
        DatabaseReference databaseRef = FirebaseDatabase.getInstance().getReference("listings");
        String listingId = databaseRef.push().getKey();
        databaseRef.child(listingId).setValue(listing);
    }

    private void uploadImage(Uri imageUri) {
        StorageReference storageRef = FirebaseStorage.getInstance().getReference("images/" + imageUri.getLastPathSegment());
        storageRef.putFile(imageUri).addOnSuccessListener(taskSnapshot -> {
            // Image uploaded successfully
        });
    }

    private EditText searchEditText;

    protected void onCreate(int savedInstanceState) {
        //super.clone(savedInstanceState);
        onCreate(R.layout.activity_listing);

        searchEditText = searchEditText.findViewById(R.id.searchEditText);
        searchEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                filterListings(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {}
        });
    }

    private void filterListings(String query) {
        // Implement filtering logic based on the query
    }


}

