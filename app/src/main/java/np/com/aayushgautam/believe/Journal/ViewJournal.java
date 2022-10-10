package np.com.aayushgautam.believe.Journal;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Toast;

import np.com.aayushgautam.believe.R;
import np.com.aayushgautam.believe.databinding.ActivityViewJournalBinding;

public class ViewJournal extends AppCompatActivity {

    ActivityViewJournalBinding binding;
    private long id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityViewJournalBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        getSupportActionBar().hide();

        id = getIntent().getLongExtra("id",0);

        final JournalDatabase db  = new JournalDatabase(this);
        final Journal journal = db.getJournal(id);

        binding.title.setText(journal.getTitle());
        binding.content.setText(journal.getContent());

        binding.discard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db.deleteJournal(journal.getID());
                Intent intent = new Intent(getApplicationContext(), JournalDashboard.class);
                Toast.makeText(ViewJournal.this, "Journal Deleted", Toast.LENGTH_SHORT).show();
                startActivity(intent);
                finish();
            }
        });

        binding.done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                journal.setTitle(binding.title.getText().toString());
                journal.setContent(binding.content.getText().toString());
                db.editJournal(journal);
                Toast.makeText(ViewJournal.this, "Journal Updated", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(), JournalDashboard.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
                finish();
            }
        });

    }
}