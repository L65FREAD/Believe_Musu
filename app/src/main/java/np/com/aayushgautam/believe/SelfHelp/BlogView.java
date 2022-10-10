package np.com.aayushgautam.believe.SelfHelp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.util.Objects;

import np.com.aayushgautam.believe.databinding.ActivityBlogViewBinding;

public class BlogView extends AppCompatActivity {

    private ActivityBlogViewBinding binding;
    private String title, content, author;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityBlogViewBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Objects.requireNonNull(getSupportActionBar()).hide();

        title = getIntent().getStringExtra("title");
        content = getIntent().getStringExtra("content");
        author = getIntent().getStringExtra("author");

        binding.author.setText(author);
        binding.title.setText(title);
        binding.content.setText(content);
    }
}