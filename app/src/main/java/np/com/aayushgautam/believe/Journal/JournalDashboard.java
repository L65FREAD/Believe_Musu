package np.com.aayushgautam.believe.Journal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import np.com.aayushgautam.believe.Dashboard;
import np.com.aayushgautam.believe.databinding.ActivityJournalDashboardBinding;

public class JournalDashboard extends AppCompatActivity {

    ActivityJournalDashboardBinding binding;
    List<Journal> journals;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityJournalDashboardBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Objects.requireNonNull(getSupportActionBar()).hide();

        JournalDatabase db = new JournalDatabase(this);
        journals = db.getJournals();

        if (journals.isEmpty()) {
            Journal journal = new Journal("What's a Journal?","Journaling is simply the recapturing of moments in the form of writing. We write down our feelings and thoughts into a journal to better understand them.\n" +
                "\n" +
                "Journaling has several mental health benefits. It provides us with the medium to keep our emotions in check, reduce stress, and manage anxiety. Writing down your life experiences can be future reminders that eventually everything will be fine. \n" +
                "\n" +
                "There are and will be hardships in life, but just like we outlived them before, we will eventually get past this one too. Writing a Journal not only makes us feel good, it provides us an opportunity to relive the events we’ve been through in a safe environment where we can process them without fear or stress. By journaling, we get to know ourselves better. \n" +
                "\n" +
                "Spend a few minutes every day writing in your journal. Keep a pen or paper close to you or use your smartphone. Draw or make creative interpretations if you like. Using Believe App, you can easily write unlimited journals","05/25","00:00");
            db.addJournal(journal);
        }

        journals = db.getJournals();
        JournalAdapter adapter = new JournalAdapter(journals,this);
        binding.journalList.setAdapter(adapter);

        binding.addJournal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), AddJournal.class);
                startActivity(intent);
                finish();
            }
        });


    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event)  {
        if (keyCode == KeyEvent.KEYCODE_BACK ) {
            Intent intent = new Intent(getApplicationContext(), Dashboard.class);
            startActivity(intent);
            return true;
        }

        return super.onKeyDown(keyCode, event);
    }
}