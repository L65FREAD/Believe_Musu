package np.com.aayushgautam.believe.Journal;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import np.com.aayushgautam.believe.R;
import np.com.aayushgautam.believe.databinding.JournalRecyclerBinding;

public class JournalAdapter extends RecyclerView.Adapter<JournalAdapter.JournalViewHolder> {

    List<Journal> journals;
    Context context;

    public JournalAdapter(List<Journal> journals, Context context){
        this.journals = journals;
        this.context = context;

        Collections.reverse(journals);
    }

    @NonNull
    @Override
    public JournalViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.journal_recycler,parent,false);
        return new JournalAdapter.JournalViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull JournalViewHolder holder, int position) {
        final Journal journal = journals.get(position);
        holder.binding.time.setText(journal.getTime());
        holder.binding.journalTitle.setText(journal.getTitle());
        holder.binding.date.setText(journal.getDate());

        holder.binding.cardJournal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), ViewJournal.class);
                intent.putExtra("id", journal.getID());
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                v.getContext().startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return journals.size();
    }

    class JournalViewHolder extends RecyclerView.ViewHolder {

        JournalRecyclerBinding binding;

        public JournalViewHolder(@NonNull View itemView) {
            super(itemView);
            binding = JournalRecyclerBinding.bind(itemView);
        }
    }
}
