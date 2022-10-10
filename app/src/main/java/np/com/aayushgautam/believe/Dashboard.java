package np.com.aayushgautam.believe;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Toast;

import java.util.Objects;

import np.com.aayushgautam.believe.AboutBelieve.AboutBelieveDashboard;
import np.com.aayushgautam.believe.ChatWithSomeone.ChatWithSomeoneDashboard;
import np.com.aayushgautam.believe.Journal.JournalDashboard;
import np.com.aayushgautam.believe.Meditate.MeditationDashboard;
import np.com.aayushgautam.believe.MentahHealthProfessional.MentalHealthDashboard;
import np.com.aayushgautam.believe.SelfHelp.SelfHelpDashboard;
import np.com.aayushgautam.believe.databinding.ActivityDashboardBinding;

public class Dashboard extends AppCompatActivity {

    ActivityDashboardBinding binding;
    private static final int MY_PERMISSIONS_REQUEST_CALL_PHONE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDashboardBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Objects.requireNonNull(getSupportActionBar()).hide();


        //main buttons hook
        binding.journal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), JournalDashboard.class);
                startActivity(intent);
            }
        });

        binding.mentalHealth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MentalHealthDashboard.class);
                startActivity(intent);
            }
        });

//        binding.aboutBelieve.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(getApplicationContext(), AboutBelieveDashboard.class);
//                startActivity(intent);
//            }
//        });

        binding.chat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ChatWithSomeoneDashboard.class);
                startActivity(intent);
            }
        });

        binding.meditation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MeditationDashboard.class);
                startActivity(intent);
            }
        });

        binding.selfHelp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!checkConnection()) {
                    return;
                }
                Intent intent = new Intent(getApplicationContext(), SelfHelpDashboard.class);
                startActivity(intent);
            }
        });

        //icons hook
        // TODO change links to socials
        binding.facebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("https://www.facebook.com/webelievein.life");
                Intent intent = new Intent(Intent.ACTION_VIEW,uri);
                startActivity(intent);
            }
        });
        binding.instagram.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("https://m.instagram.com/webelievein.life");
                Intent intent = new Intent(Intent.ACTION_VIEW,uri);
                startActivity(intent);
            }
        });
        binding.spotify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("https://anchor.fm/thebelievepodcast");
                Intent intent = new Intent(Intent.ACTION_VIEW,uri);
                startActivity(intent);
            }
        });
    }


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event)  {
        if (keyCode == KeyEvent.KEYCODE_BACK ) {
            android.os.Process.killProcess(android.os.Process.myPid());
            System.exit(1);
            return true;
        }

        return super.onKeyDown(keyCode, event);
    }

    private boolean checkConnection() {
        ConnectivityManager connectivityManager = (ConnectivityManager) getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();

        if (networkInfo == null) {
            Toast.makeText(this, "Not connected to Network", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }
}