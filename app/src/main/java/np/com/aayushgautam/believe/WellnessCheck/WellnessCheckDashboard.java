package np.com.aayushgautam.believe.WellnessCheck;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.Objects;

import np.com.aayushgautam.believe.Dashboard;
import np.com.aayushgautam.believe.databinding.ActivityWellnessCheckDashboardBinding;

public class WellnessCheckDashboard extends AppCompatActivity {


    ActivityWellnessCheckDashboardBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityWellnessCheckDashboardBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Objects.requireNonNull(getSupportActionBar()).hide();

        binding.wellnessButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), FactorsChooser.class);
                startActivity(intent);
            }
        });




    }
}