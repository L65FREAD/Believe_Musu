package np.com.aayushgautam.believe.WellnessCheck;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Objects;

import np.com.aayushgautam.believe.R;
import np.com.aayushgautam.believe.databinding.ActivityFactorsChooserBinding;

public class FactorsChooser extends AppCompatActivity {
    ActivityFactorsChooserBinding binding;
    ArrayList<Boolean> selectedButtons = new ArrayList<>(Collections.nCopies(12, false));
    ArrayList<String> affectSelected = new ArrayList<>();
    ArrayList<String> noAffectSelected = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityFactorsChooserBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Objects.requireNonNull(getSupportActionBar()).hide();

        //setting the responsiveness of the buttons
        //TODO this should be changed to make more flexible
        binding.goOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedButtons.set(1, !selectedButtons.get(1));
                if (selectedButtons.get(1) && !(affectSelected.size()>2)) {
                    binding.goOut.setCardBackgroundColor(getResources().getColor(R.color.blueWellnessCheck));
                    binding.goOutText.setTextColor(getResources().getColor(R.color.white));
                    affectSelected.add("Going Out");
                } else {
                    binding.goOut.setCardBackgroundColor(getResources().getColor(R.color.white));
                    binding.goOutText.setTextColor(getResources().getColor(R.color.blueWellnessCheck));
                    affectSelected.remove("Going Out");
                }
            }
        });
        binding.read.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedButtons.set(2, !selectedButtons.get(2));
                if (selectedButtons.get(2) && !(affectSelected.size()>2)) {
                    binding.read.setCardBackgroundColor(getResources().getColor(R.color.blueWellnessCheck));
                    binding.readText.setTextColor(getResources().getColor(R.color.white));
                    affectSelected.add("Reading");
                } else {
                    binding.read.setCardBackgroundColor(getResources().getColor(R.color.white));
                    binding.readText.setTextColor(getResources().getColor(R.color.blueWellnessCheck));
                    affectSelected.remove("Reading");
                }
            }
        });
        binding.watchingMovie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedButtons.set(3, !selectedButtons.get(3));
                if (selectedButtons.get(3) && !(affectSelected.size()>2)) {
                    binding.watchingMovie.setCardBackgroundColor(getResources().getColor(R.color.blueWellnessCheck));
                    binding.watchingMovieText.setTextColor(getResources().getColor(R.color.white));
                    affectSelected.add("Watching Movies");
                } else {
                    binding.watchingMovie.setCardBackgroundColor(getResources().getColor(R.color.white));
                    binding.watchingMovieText.setTextColor(getResources().getColor(R.color.blueWellnessCheck));
                    affectSelected.remove("Watching Movies");
                }
            }
        });
        binding.workOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedButtons.set(4, !selectedButtons.get(4));
                if (selectedButtons.get(4) && !(affectSelected.size()>2)) {
                    binding.workOut.setCardBackgroundColor(getResources().getColor(R.color.blueWellnessCheck));
                    binding.workOutText.setTextColor(getResources().getColor(R.color.white));
                    affectSelected.add("Working Out");
                } else {
                    binding.workOut.setCardBackgroundColor(getResources().getColor(R.color.white));
                    binding.workOutText.setTextColor(getResources().getColor(R.color.blueWellnessCheck));
                    affectSelected.remove("Working Out");
                }
            }
        });
        binding.eat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedButtons.set(5, !selectedButtons.get(5));
                if (selectedButtons.get(5) && !(affectSelected.size()>2)) {
                    binding.eat.setCardBackgroundColor(getResources().getColor(R.color.blueWellnessCheck));
                    binding.eatText.setTextColor(getResources().getColor(R.color.white));
                    affectSelected.add("Eating Well");
                } else {
                    binding.eat.setCardBackgroundColor(getResources().getColor(R.color.white));
                    binding.eatText.setTextColor(getResources().getColor(R.color.blueWellnessCheck));
                    affectSelected.remove("Eating Well");
                }
            }
        });
        binding.sleep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedButtons.set(6, !selectedButtons.get(6));
                if (selectedButtons.get(6) && !(affectSelected.size()>2)) {
                    binding.sleep.setCardBackgroundColor(getResources().getColor(R.color.blueWellnessCheck));
                    binding.sleepText.setTextColor(getResources().getColor(R.color.white));
                    affectSelected.add("Proper Sleep");
                } else {
                    binding.sleep.setCardBackgroundColor(getResources().getColor(R.color.white));
                    binding.sleepText.setTextColor(getResources().getColor(R.color.blueWellnessCheck));
                    affectSelected.remove("Proper Sleep");
                }
            }
        });


        binding.goOut1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedButtons.set(7, !selectedButtons.get(7));
                if (selectedButtons.get(7) && !(noAffectSelected.size()>2)) {
                    binding.goOut1.setCardBackgroundColor(getResources().getColor(R.color.secondBlueWellnessCheck));
                    binding.goOutText1.setTextColor(getResources().getColor(R.color.white));
                    noAffectSelected.add("Going Out");
                } else {
                    binding.goOut1.setCardBackgroundColor(getResources().getColor(R.color.white));
                    binding.goOutText1.setTextColor(getResources().getColor(R.color.secondBlueWellnessCheck));
                    noAffectSelected.remove("Going Out");
                }
            }
        });
        binding.read1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedButtons.set(8, !selectedButtons.get(8));
                if (selectedButtons.get(8) && !(noAffectSelected.size()>2)) {
                    binding.read1.setCardBackgroundColor(getResources().getColor(R.color.secondBlueWellnessCheck));
                    binding.readText1.setTextColor(getResources().getColor(R.color.white));
                    noAffectSelected.add("Reading");
                } else {
                    binding.read1.setCardBackgroundColor(getResources().getColor(R.color.white));
                    binding.readText1.setTextColor(getResources().getColor(R.color.secondBlueWellnessCheck));
                    noAffectSelected.remove("Reading");
                }
            }
        });
        binding.watchingMovie1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedButtons.set(9, !selectedButtons.get(9));
                if (selectedButtons.get(9) && !(noAffectSelected.size()>2)) {
                    binding.watchingMovie1.setCardBackgroundColor(getResources().getColor(R.color.secondBlueWellnessCheck));
                    binding.watchingMovieText1.setTextColor(getResources().getColor(R.color.white));
                    noAffectSelected.add("Watching Movies");
                } else {
                    binding.watchingMovie1.setCardBackgroundColor(getResources().getColor(R.color.white));
                    binding.watchingMovieText1.setTextColor(getResources().getColor(R.color.secondBlueWellnessCheck));
                    noAffectSelected.remove("Watching Movies");
                }
            }
        });
        binding.workOut1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedButtons.set(10, !selectedButtons.get(10));
                if (selectedButtons.get(10) && !(noAffectSelected.size()>2)) {
                    binding.workOut1.setCardBackgroundColor(getResources().getColor(R.color.secondBlueWellnessCheck));
                    binding.workOutText1.setTextColor(getResources().getColor(R.color.white));
                    noAffectSelected.add("Working Out");
                } else {
                    binding.workOut1.setCardBackgroundColor(getResources().getColor(R.color.white));
                    binding.workOutText1.setTextColor(getResources().getColor(R.color.secondBlueWellnessCheck));
                    noAffectSelected.remove("Working Out");
                }
            }
        });
        binding.eat1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedButtons.set(11, !selectedButtons.get(11));
                if (selectedButtons.get(11) && !(noAffectSelected.size()>2)) {
                    binding.eat1.setCardBackgroundColor(getResources().getColor(R.color.secondBlueWellnessCheck));
                    binding.eatText1.setTextColor(getResources().getColor(R.color.white));
                    noAffectSelected.add("Eating Well");
                } else {
                    binding.eat1.setCardBackgroundColor(getResources().getColor(R.color.white));
                    binding.eatText1.setTextColor(getResources().getColor(R.color.secondBlueWellnessCheck));
                    noAffectSelected.remove("Eating Well");
                }
            }
        });
        binding.sleep1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedButtons.set(0, !selectedButtons.get(0));
                if (selectedButtons.get(0) && !(noAffectSelected.size()>2)) {
                    binding.sleep1.setCardBackgroundColor(getResources().getColor(R.color.secondBlueWellnessCheck));
                    binding.sleepText1.setTextColor(getResources().getColor(R.color.white));
                    noAffectSelected.add("Proper Sleep");
                } else {
                    binding.sleep1.setCardBackgroundColor(getResources().getColor(R.color.white));
                    binding.sleepText1.setTextColor(getResources().getColor(R.color.secondBlueWellnessCheck));
                    noAffectSelected.remove("Proper Sleep");
                }
            }
        });

        //Button after factor selection is done
        binding.continueToWellness.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), FactorInput.class);
                startActivity(intent);
            }
        });
    }
}