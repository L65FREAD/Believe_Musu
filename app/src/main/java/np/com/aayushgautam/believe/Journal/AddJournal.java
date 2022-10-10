package np.com.aayushgautam.believe.Journal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.Calendar;
import java.util.Objects;

import np.com.aayushgautam.believe.databinding.ActivityAddJournalBinding;

public class AddJournal extends AppCompatActivity {

    ActivityAddJournalBinding binding;
    private Calendar calendar;
    private String todayDate;
    private String currentTime;
    private static int newNote = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAddJournalBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Objects.requireNonNull(getSupportActionBar()).hide();

        //getting the time and date when add new journal is clicked
        calendar = Calendar.getInstance();
        todayDate = calendar.get(Calendar.YEAR)+ "/" + (calendar.get(Calendar.MONTH) + 1)+ "/" + calendar.get(Calendar.DAY_OF_MONTH);
        currentTime = pad(calendar.get(Calendar.HOUR)) + ":" + pad(calendar.get(Calendar.MINUTE));

        //hooks for bottom icon
        binding.discard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(AddJournal.this, "Discarded", Toast.LENGTH_SHORT).show();
                onBackPressed();
            }
        });

        binding.done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title = binding.title.getText().toString();
                if (title.isEmpty()) {
                    title = "New Journal " + (newNote+=1);
                }
                String content = binding.content.getText().toString();
                if (content.isEmpty()) {
                    content = "Your Content Here";
                }
                Journal journal = new Journal(title,content,
                        todayDate,
                        currentTime);
                JournalDatabase db = new JournalDatabase(getApplicationContext());
                if (db.addJournal(journal)>0) {
                    Toast.makeText(AddJournal.this, "Journal Created", Toast.LENGTH_SHORT).show();
                }
                goToMain();
            }
        });
    }

    private void goToMain() {
        Intent intent = new Intent(getApplicationContext(), JournalDashboard.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
        finish();
    }

    private String pad(int i) {
        if (i<10){
            return "0"+i;}
        return i+"";
    }
}