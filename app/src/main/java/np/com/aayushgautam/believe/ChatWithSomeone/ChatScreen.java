package np.com.aayushgautam.believe.ChatWithSomeone;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Objects;

import np.com.aayushgautam.believe.Dashboard;
import np.com.aayushgautam.believe.databinding.ActivityChatScreenBinding;

public class ChatScreen extends AppCompatActivity {

    ActivityChatScreenBinding binding;

    private String userId;
    private long sessionId;
    private String message;

    private FirebaseDatabase firebaseDatabase;
    private ArrayList<MessageModel> filteredMessages;
    private DatabaseReference mDatabase;

    private MessagesAdapter adapter;
    private int number = 1;

    private String sleep, feeling, distress, messageFirst;
    boolean debounce = true;

    private static String userIdStatic;
    private static long sessionIdStatic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityChatScreenBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Objects.requireNonNull(getSupportActionBar()).hide();

        userId = getIntent().getStringExtra("User Id");
        sessionId = getIntent().getLongExtra("Session Id",0);

        sleep = getIntent().getStringExtra("sleep");
        feeling = getIntent().getStringExtra("feeling");
        distress = getIntent().getStringExtra("distress");

        messageFirst = "Feeling"+ feeling + "Proper Sleep: " + sleep + "Distress: " + distress;

        userIdStatic = userId;
        sessionIdStatic = sessionId;

        firebaseDatabase = FirebaseDatabase.getInstance();
        mDatabase = FirebaseDatabase.getInstance().getReference();

        filteredMessages = new ArrayList<>();
        adapter = new MessagesAdapter(this, filteredMessages);
        binding.recyclerView.setAdapter(adapter);
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));

        getFilteredData();

        binding.send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                message = binding.typeMessage.getText().toString();

                if (message.isEmpty()){
                    return;
                }
                if (debounce){
                    message = messageFirst + message;
                    debounce = false;
                }
                binding.startText.setVisibility(View.GONE);
                number++;
                MessageModel messageModel = new MessageModel(userId,sessionId,true,message);

                mDatabase.child("Messages").child(userId).child(number+"").setValue(messageModel);
                binding.typeMessage.setText("");
                binding.recyclerView.smoothScrollToPosition(filteredMessages.size());
            }
        });

        binding.cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialogue();
            }
        });
    }

    private void getFilteredData(){

        firebaseDatabase.getReference().child("Messages").child(userId).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                filteredMessages.clear();
                for (DataSnapshot snapshot1 : snapshot.getChildren()) {
                    MessageModel messageModel = snapshot1.getValue(MessageModel.class);
                    if (messageModel.getSessionId() == sessionId && messageModel.getUserId().equals(userId) ) {
                        filteredMessages.add(messageModel);
                    }
                }
                adapter.notifyDataSetChanged();
                binding.recyclerView.smoothScrollToPosition(filteredMessages.size());
                number = filteredMessages.size();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.d("DATABASE ->", error.getMessage());
            }
        });
    }

    private void showDialogue(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("End Chat")
                .setMessage("Do you want to end the conversation? All the data will get deleted. We hope we were able to help :)")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        DatabaseReference userReference = FirebaseDatabase.getInstance().getReference().child("users").child(userIdStatic);
                        DatabaseReference messageReference = FirebaseDatabase.getInstance().getReference().child("Messages").child(userIdStatic);
                        messageReference.removeValue()
                        .addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void aVoid) {

                                userReference.removeValue()
                                        .addOnSuccessListener(new OnSuccessListener<Void>() {
                                            @Override
                                            public void onSuccess(Void aVoid) {
                                                Toast.makeText(ChatScreen.this, "User Data Deleted", Toast.LENGTH_SHORT).show();
                                                Intent intent = new Intent(getApplicationContext(), Dashboard.class);
                                                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                                                startActivity(intent);
                                                finish();
                                            }
                                        });
                            }
                        });
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // User cancelled the dialog
                    }
                });

        builder.create().show();
    }

    @Override
    public void onBackPressed() {
        showDialogue();
    }
}