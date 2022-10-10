package np.com.aayushgautam.believe.SelfHelp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Objects;

import np.com.aayushgautam.believe.Dashboard;
import np.com.aayushgautam.believe.databinding.ActivitySelfHelpDashboardBinding;

public class SelfHelpDashboard extends AppCompatActivity {

    ActivitySelfHelpDashboardBinding binding;
    private FirebaseDatabase database;
    BlogAdapter adapter;

    private ArrayList<BlogModel> blogModels = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySelfHelpDashboardBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Objects.requireNonNull(getSupportActionBar()).hide();

        adapter = new BlogAdapter(blogModels, this);
        binding.blogList.setAdapter(adapter);

        binding.prog.setVisibility(View.VISIBLE);

        database = FirebaseDatabase.getInstance();
        database.getReference().child("Blog").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot snapshot1 : snapshot.getChildren()) {
                    BlogModel blogModel = snapshot1.getValue(BlogModel.class);
                    blogModels.add(blogModel);

                }
                adapter.notifyDataSetChanged();
                binding.prog.setVisibility(View.GONE);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.d("DATABASE ->", error.getMessage());
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