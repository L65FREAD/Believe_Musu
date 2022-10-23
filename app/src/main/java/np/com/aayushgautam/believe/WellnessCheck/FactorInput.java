package np.com.aayushgautam.believe.WellnessCheck;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Objects;

import np.com.aayushgautam.believe.R;
import np.com.aayushgautam.believe.databinding.ActivityFactorInputBinding;

public class FactorInput extends AppCompatActivity {
    ActivityFactorInputBinding binding;
    ArrayList<Boolean> selectedButtons = new ArrayList<>(Collections.nCopies(7, false));
    ArrayList<ArrayList> selectedOptions = new ArrayList<>();
    int numberOfInputs = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityFactorInputBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Objects.requireNonNull(getSupportActionBar()).hide();

        binding.yes1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.yes1.setCardBackgroundColor(getResources().getColor(R.color.yello));
                binding.no1.setCardBackgroundColor(getResources().getColor(R.color.white));
                selectedButtons.set(0, true);
            }
        });

        binding.no1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.no1.setCardBackgroundColor(getResources().getColor(R.color.yello));
                binding.yes1.setCardBackgroundColor(getResources().getColor(R.color.white));
                selectedButtons.set(0, false);
            }
        });

        binding.yes2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.yes2.setCardBackgroundColor(getResources().getColor(R.color.yello));
                binding.no2.setCardBackgroundColor(getResources().getColor(R.color.white));
                selectedButtons.set(1, true);
            }
        });

        binding.no2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.no2.setCardBackgroundColor(getResources().getColor(R.color.yello));
                binding.yes2.setCardBackgroundColor(getResources().getColor(R.color.white));
                selectedButtons.set(1, false);
            }
        });

        binding.yes3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.yes3.setCardBackgroundColor(getResources().getColor(R.color.yello));
                binding.no3.setCardBackgroundColor(getResources().getColor(R.color.white));
                selectedButtons.set(2, true);
            }
        });

        binding.no3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.no3.setCardBackgroundColor(getResources().getColor(R.color.yello));
                binding.yes3.setCardBackgroundColor(getResources().getColor(R.color.white));
                selectedButtons.set(2, false);
            }
        });

        binding.yes4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.yes4.setCardBackgroundColor(getResources().getColor(R.color.yello));
                binding.no4.setCardBackgroundColor(getResources().getColor(R.color.white));
                selectedButtons.set(3, true);
            }
        });

        binding.no4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.no4.setCardBackgroundColor(getResources().getColor(R.color.yello));
                binding.yes4.setCardBackgroundColor(getResources().getColor(R.color.white));
                selectedButtons.set(3, false);
            }
        });

        binding.yes5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.yes5.setCardBackgroundColor(getResources().getColor(R.color.yello));
                binding.no5.setCardBackgroundColor(getResources().getColor(R.color.white));
                selectedButtons.set(4, true);
            }
        });

        binding.no5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.no5.setCardBackgroundColor(getResources().getColor(R.color.yello));
                binding.yes5.setCardBackgroundColor(getResources().getColor(R.color.white));
                selectedButtons.set(4, false);
            }
        });

        binding.yes6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.yes6.setCardBackgroundColor(getResources().getColor(R.color.yello));
                binding.no6.setCardBackgroundColor(getResources().getColor(R.color.white));
                selectedButtons.set(5, true);
            }
        });

        binding.no6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.no6.setCardBackgroundColor(getResources().getColor(R.color.yello));
                binding.yes6.setCardBackgroundColor(getResources().getColor(R.color.white));
                selectedButtons.set(5, false);
            }
        });

        binding.yes7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.yes7.setCardBackgroundColor(getResources().getColor(R.color.yello));
                binding.no7.setCardBackgroundColor(getResources().getColor(R.color.white));
                selectedButtons.set(6, true);
            }
        });

        binding.no7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.no7.setCardBackgroundColor(getResources().getColor(R.color.yello));
                binding.yes7.setCardBackgroundColor(getResources().getColor(R.color.white));
                selectedButtons.set(6, false);
            }
        });

        binding.continueInput.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (numberOfInputs) {
                    case 3:
                        binding.time.setText("Sunday 23/10/2022");
                        numberOfInputs--;
                        selectedOptions.add(selectedButtons);
                        binding.no1.setCardBackgroundColor(getResources().getColor(R.color.white));
                        binding.yes1.setCardBackgroundColor(getResources().getColor(R.color.white));
                        binding.no2.setCardBackgroundColor(getResources().getColor(R.color.white));
                        binding.yes2.setCardBackgroundColor(getResources().getColor(R.color.white));
                        binding.no3.setCardBackgroundColor(getResources().getColor(R.color.white));
                        binding.yes3.setCardBackgroundColor(getResources().getColor(R.color.white));
                        binding.no4.setCardBackgroundColor(getResources().getColor(R.color.white));
                        binding.yes4.setCardBackgroundColor(getResources().getColor(R.color.white));
                        binding.no5.setCardBackgroundColor(getResources().getColor(R.color.white));
                        binding.yes5.setCardBackgroundColor(getResources().getColor(R.color.white));
                        binding.no6.setCardBackgroundColor(getResources().getColor(R.color.white));
                        binding.yes6.setCardBackgroundColor(getResources().getColor(R.color.white));
                        binding.no7.setCardBackgroundColor(getResources().getColor(R.color.white));
                        binding.yes7.setCardBackgroundColor(getResources().getColor(R.color.white));
                        break;
                    case 2:
                        binding.time.setText("Monday 24/10/2022");
                        numberOfInputs--;
                        selectedOptions.add(selectedButtons);
                        binding.no1.setCardBackgroundColor(getResources().getColor(R.color.white));
                        binding.yes1.setCardBackgroundColor(getResources().getColor(R.color.white));
                        binding.no2.setCardBackgroundColor(getResources().getColor(R.color.white));
                        binding.yes2.setCardBackgroundColor(getResources().getColor(R.color.white));
                        binding.no3.setCardBackgroundColor(getResources().getColor(R.color.white));
                        binding.yes3.setCardBackgroundColor(getResources().getColor(R.color.white));
                        binding.no4.setCardBackgroundColor(getResources().getColor(R.color.white));
                        binding.yes4.setCardBackgroundColor(getResources().getColor(R.color.white));
                        binding.no5.setCardBackgroundColor(getResources().getColor(R.color.white));
                        binding.yes5.setCardBackgroundColor(getResources().getColor(R.color.white));
                        binding.no6.setCardBackgroundColor(getResources().getColor(R.color.white));
                        binding.yes6.setCardBackgroundColor(getResources().getColor(R.color.white));
                        binding.no7.setCardBackgroundColor(getResources().getColor(R.color.white));
                        binding.yes7.setCardBackgroundColor(getResources().getColor(R.color.white));
                        break;
                    default:
                        selectedOptions.add(selectedButtons);
                        Intent intent = new Intent(getApplicationContext(), Results.class);
                        startActivity(intent);
                }
            }
        });
    }
}