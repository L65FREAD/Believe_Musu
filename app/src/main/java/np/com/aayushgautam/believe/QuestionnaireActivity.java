package np.com.aayushgautam.believe;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Calendar;
import java.util.Objects;

import np.com.aayushgautam.believe.ChatWithSomeone.ChatScreen;
import np.com.aayushgautam.believe.ChatWithSomeone.UserModel;
import np.com.aayushgautam.believe.MentahHealthProfessional.MentalHealthDashboard;
import np.com.aayushgautam.believe.databinding.ActivityQuestionareBinding;

public class QuestionnaireActivity extends AppCompatActivity {

    ActivityQuestionareBinding binding;

    private String userId;
    private long sessionId;
    private DatabaseReference mDatabase;
    private Calendar calendar;

    private String feeling, sleep, distress;
    private int distressRating;
    RadioButton button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityQuestionareBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Objects.requireNonNull(getSupportActionBar()).hide();

        mDatabase = FirebaseDatabase.getInstance().getReference();

        userId = getIntent().getStringExtra("nickname");

        binding.continueToPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                
                button = findViewById(binding.firstQuestionGroup.getCheckedRadioButtonId());
                if (button == null){
                    Toast.makeText(QuestionnaireActivity.this, "You have some questions unanswered.", Toast.LENGTH_SHORT).show();
                    return;
                }
                feeling = button.getText().toString();
                
                button = findViewById(binding.secondQuestionGroup.getCheckedRadioButtonId());
                if (button == null){
                    Toast.makeText(QuestionnaireActivity.this, "You have some questions unanswered.", Toast.LENGTH_SHORT).show();
                    return;
                }
                sleep = button.getText().toString();

                button = findViewById(binding.thirdQuestionGroup.getCheckedRadioButtonId());
                if (button == null){
                    Toast.makeText(QuestionnaireActivity.this, "You have some questions unanswered.", Toast.LENGTH_SHORT).show();
                    return;
                }
                distress = button.getText().toString();


                if ((feeling.equalsIgnoreCase("sad")
                                && sleep.equalsIgnoreCase("false")
                                && distress.equalsIgnoreCase("false"))) {
                    showDialogue();
                }
            showDialogue();


            }
        });


        //setting a new user room

    }

    private void showDialogue(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Do You Need Professional Counselling?")
                .setMessage("According to your answers, we feel like Professional Support might me more useful for you. Would you like to connect with a Mental Health Specialist Instead?")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        Intent intent = new Intent(getApplicationContext(), MentalHealthDashboard.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                        startActivity(intent);
                        finish();
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        sessionId = (long)Math.floor(Math.random()*(100000000000000L+1 +1)+1);
                        String longUserId = userId + sessionId;
                        UserModel user = new UserModel(userId, sessionId);
                        mDatabase.child("users").child(longUserId).setValue(user);

                        Intent intent = new Intent(getApplicationContext(), ChatScreen.class);
                        intent.putExtra("User Id", longUserId);
                        intent.putExtra("Session Id", sessionId);
                        intent.putExtra("feeling", feeling);
                        intent.putExtra("sleep", sleep);
                        intent.putExtra("distress", distress);
                        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                        startActivity(intent);
                        finish();
                    }
                });

        builder.create().show();
    }

}



//        userId = getIntent().getStringExtra("User Id");
//        sessionId = getIntent().getLongExtra("Session Id",0);