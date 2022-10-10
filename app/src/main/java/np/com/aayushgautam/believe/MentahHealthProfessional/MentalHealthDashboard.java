package np.com.aayushgautam.believe.MentahHealthProfessional;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.Objects;

import np.com.aayushgautam.believe.databinding.ActivityMentalHealthDashboardBinding;

public class MentalHealthDashboard extends AppCompatActivity {

    ActivityMentalHealthDashboardBinding binding;
    private static final int MY_PERMISSIONS_REQUEST_CALL_PHONE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMentalHealthDashboardBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Objects.requireNonNull(getSupportActionBar()).hide();

        binding.suicideHelpline.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String number = ("tel:" + "166006152007");
                Intent intent = new Intent(Intent.ACTION_CALL);
                intent.setData(Uri.parse(number));
                if (ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(MentalHealthDashboard.this, "Reached Here", Toast.LENGTH_SHORT).show();
                    ActivityCompat.requestPermissions(MentalHealthDashboard.this,
                            new String[]{Manifest.permission.CALL_PHONE},
                            MY_PERMISSIONS_REQUEST_CALL_PHONE);
                } else {
                    try {
                        startActivity(intent);
                    } catch(SecurityException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        binding.contactMentalHealthProfessional.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ContactProfessional.class);
                startActivity(intent);
            }
        });

    }
}