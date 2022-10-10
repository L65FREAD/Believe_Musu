package np.com.aayushgautam.believe;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Pair;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;
import java.util.concurrent.Executor;

import np.com.aayushgautam.believe.databinding.ActivitySplashScreenBinding;

public class SplashScreen extends AppCompatActivity {


    Animation bottomAnim;
    ActivitySplashScreenBinding binding;


    private static final int SPLASH_SCREEN = 4500;


    ArrayList<String> quotes = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySplashScreenBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Objects.requireNonNull(getSupportActionBar()).hide();

        //Animation Hook
        bottomAnim = AnimationUtils.loadAnimation(this, R.anim.bottom_animation_file);

        addItemsToArrayList();
        Random rand = new Random();
        int upperBound = quotes.size();
        int int_random = rand.nextInt(upperBound);

        binding.quote.setText(quotes.get(int_random));

        //Setting the Animation
        binding.quote.setAnimation(bottomAnim);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent goToDashboard = new Intent(SplashScreen.this, Dashboard.class);
                ActivityOptions activityOptions = ActivityOptions.makeSceneTransitionAnimation(SplashScreen.this);
                startActivity(goToDashboard, activityOptions.toBundle());
                finish();
            }
        }, SPLASH_SCREEN);

    }

    private void addItemsToArrayList(){
        quotes.add("Just when the caterpillar thought its world was over, it turned into a butterfly!");
        quotes.add("Smile, breathe and go slowly ");
        quotes.add("Trust the process.");
        quotes.add("Head up, heart open. To better days!");
        quotes.add("Prevention is better than cure.");
        quotes.add("You may have to fight the battle more than once to win it");
        quotes.add("We’re all in this together. Choose love.");
        quotes.add("Sometimes life gets weird. Hang in there. It gets better.");
        quotes.add("Here's to you—steadier, stronger and better every day.");
        quotes.add("It's okay to ask for help ");
        quotes.add("You are stronger than your challenges");
        quotes.add("Inhale love. Exhale gratitude.");
        quotes.add("Start with optimism :)");
        quotes.add("Mindset matters :)");
        quotes.add("Head up, heart open. To better days!");
        quotes.add("Do your part, things will get better!");
        quotes.add("This will all end soon!");
        quotes.add("Everything will eventually be fine");
        quotes.add("Remember, Don't Panic.");
        quotes.add("Wish it, believe it, and it will be so");
    }
}