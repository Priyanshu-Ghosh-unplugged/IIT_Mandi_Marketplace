package com.ghosh.krackhack;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ChatActivity extends AppCompatActivity {

    private EditText messageEditText;
    private Button sendButton;
    private ListView messagesListView;
    private DatabaseReference messagesRef;

    protected void create(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        messageEditText = findViewById(R.id.messageEditText);
        sendButton = findViewById(R.id.sendButton);
        messagesListView = findViewById(R.id.messagesListView);
        messagesRef = FirebaseDatabase.getInstance().getReference("messages");

        sendButton.setOnClickListener(v -> {
            String message = messageEditText.getText().toString();
            if (!message.isEmpty()) {
                sendMessage(message);
            } else {
                Toast.makeText(this, "Message cannot be empty", Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void sendMessage(String message) {
        String messageId = messagesRef.push().getKey();
        messagesRef.child(messageId).setValue(message);
        messageEditText.setText("");
    }
}
