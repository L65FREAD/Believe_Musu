package np.com.aayushgautam.believe.Meditate;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Toast;

import java.util.Objects;
import java.util.concurrent.TimeUnit;

import np.com.aayushgautam.believe.R;
import np.com.aayushgautam.believe.databinding.ActivityMeditationWindowBinding;

public class MeditationWindow extends AppCompatActivity {

    ActivityMeditationWindowBinding binding;
    private long duration, seconds, minutes;
    CountDownTimer countDownTimer;
    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMeditationWindowBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Objects.requireNonNull(getSupportActionBar()).hide();

        mediaPlayer = MediaPlayer.create(this, R.raw.meditation_music);

        binding.minute.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length()==2){
                    binding.seconds.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });

        binding.startMeditating.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(binding.minute.getText().length()==0) {
                    minutes = 0;
                    if (binding.seconds.getText().length() == 0) {
                        Toast.makeText(MeditationWindow.this, "Please enter a duration!", Toast.LENGTH_SHORT).show();
                    } else {
                        seconds = Long.parseLong(binding.seconds.getText().toString());
                    }
                } else {
                    minutes = Long.parseLong(binding.minute.getText().toString());
                    if (binding.seconds.getText().length() == 0) {
                        seconds = Long.parseLong(binding.seconds.getText().toString());
                    }
                }

                if (minutes>60) {
                    Toast.makeText(MeditationWindow.this, "Enter valid minute format!", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (seconds>60) {
                    Toast.makeText(MeditationWindow.this, "Enter valid seconds format!", Toast.LENGTH_SHORT).show();
                    return;
                }

                duration = TimeUnit.MINUTES.toMillis(minutes) + TimeUnit.SECONDS.toMillis(seconds);

                mediaPlayer.start();
                mediaPlayer.setLooping(true);

                binding.countDownMinutes.setVisibility(View.VISIBLE);
                binding.countDownSeconds.setVisibility(View.VISIBLE);

                binding.minute.setVisibility(View.GONE);
                binding.seconds.setVisibility(View.GONE);

                binding.gif.setVisibility(View.VISIBLE);
                binding.stopMeditating.setVisibility(View.VISIBLE);
                binding.startMeditating.setVisibility(View.GONE);

                countDownTimer =  new CountDownTimer(duration, 1000){
                    @Override
                    public void onTick(long millisUntilFinished) {
                        long minutesRemaining = TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished);
                        long secondsRemaining = TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished) - minutesRemaining*60;

                        binding.countDownMinutes.setText(formatTime(minutesRemaining));
                        binding.countDownSeconds.setText(formatTime(secondsRemaining));

                    }
                    @Override
                    public void onFinish() {
                        mediaPlayer.stop();
                        binding.seconds.setText("");
                        binding.minute.setText("");

                        binding.gif.setVisibility(View.GONE);

                        binding.stopMeditating.setVisibility(View.GONE);
                        binding.startMeditating.setVisibility(View.VISIBLE);

                        binding.countDownMinutes.setVisibility(View.GONE);
                        binding.countDownSeconds.setVisibility(View.GONE);

                        binding.minute.setVisibility(View.VISIBLE);
                        binding.seconds.setVisibility(View.VISIBLE);

                        mediaPlayer.reset();
                        instantiateMediaPlayer();

                    }
                };
                countDownTimer.start();
            }
        });

        binding.stopMeditating.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                countDownTimer.cancel();

                binding.gif.setVisibility(View.GONE);

                binding.stopMeditating.setVisibility(View.GONE);
                binding.startMeditating.setVisibility(View.VISIBLE);

                binding.countDownMinutes.setVisibility(View.GONE);
                binding.countDownSeconds.setVisibility(View.GONE);

                binding.minute.setVisibility(View.VISIBLE);
                binding.seconds.setVisibility(View.VISIBLE);
                binding.seconds.setText("");
                binding.minute.setText("");

                mediaPlayer.reset();
                instantiateMediaPlayer();
            }
        });
    }

    private void instantiateMediaPlayer() {
        mediaPlayer = MediaPlayer.create(this, R.raw.meditation_music);
    }

    private String formatTime(long minutesRemaining) {
        if (minutesRemaining<10) {
            return "0"+minutesRemaining;
        }
        return minutesRemaining+"";
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event)  {
        if (keyCode == KeyEvent.KEYCODE_BACK ) {
            mediaPlayer.stop();
            Intent intent = new Intent(getApplicationContext(), MeditationDashboard.class);
            startActivity(intent);
            return true;
        }

        return super.onKeyDown(keyCode, event);
    }
}