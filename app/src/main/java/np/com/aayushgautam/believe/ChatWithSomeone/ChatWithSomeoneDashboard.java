package np.com.aayushgautam.believe.ChatWithSomeone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Calendar;
import java.util.Objects;
import java.util.Random;

import np.com.aayushgautam.believe.QuestionnaireActivity;
import np.com.aayushgautam.believe.databinding.ActivityChatWithSomeoneDashboardBinding;

public class ChatWithSomeoneDashboard extends AppCompatActivity {

    private ActivityChatWithSomeoneDashboardBinding binding;
    private String userId;
//    private long sessionId;
//    private DatabaseReference mDatabase;
    private Calendar calendar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityChatWithSomeoneDashboardBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Objects.requireNonNull(getSupportActionBar()).hide();

//        mDatabase = FirebaseDatabase.getInstance().getReference();

        binding.chatWithSomeoneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userId = binding.nickname.getText().toString();
                if (userId.isEmpty()){
                    Toast.makeText(ChatWithSomeoneDashboard.this, "Please add a nickname", Toast.LENGTH_SHORT).show();
                    return;
                }

                Intent intent = new Intent(getApplicationContext(), QuestionnaireActivity.class);
                intent.putExtra("nickname", userId);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
                finish();

//                sessionId = (long)Math.floor(Math.random()*(100000000000000L+1 +1)+1);
//                String longUserId = userId + sessionId;
//                UserModel user = new UserModel(userId, sessionId);
//                mDatabase.child("users").child(longUserId).setValue(user);
//
//                Intent intent = new Intent(getApplicationContext(), ChatScreen.class);
//                intent.putExtra("User Id", longUserId);
//                intent.putExtra("Session Id", sessionId);
//                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
//                startActivity(intent);
//                finish();

            }
        });
    }

}