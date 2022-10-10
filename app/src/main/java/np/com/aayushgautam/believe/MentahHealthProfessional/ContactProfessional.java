package np.com.aayushgautam.believe.MentahHealthProfessional;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.StrictMode;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import java.util.Objects;
import java.util.Properties;

import np.com.aayushgautam.believe.databinding.ActivityContactProfessionalBinding;

public class ContactProfessional extends AppCompatActivity {

    ActivityContactProfessionalBinding binding;

    private String name, contactNo, message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityContactProfessionalBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Objects.requireNonNull(getSupportActionBar()).hide();

        binding.connect.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("IntentReset")
            @Override
            public void onClick(View v) {
                name = binding.name.getText().toString();
                contactNo = binding.contactNumber.getText().toString();
                message = binding.message.getText().toString();

                StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
                StrictMode.setThreadPolicy(policy);

                if (name.isEmpty()) {
                    Toast.makeText(ContactProfessional.this, "Please fill out name!", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (contactNo.isEmpty()) {
                    Toast.makeText(ContactProfessional.this, "Please fill out contact no!", Toast.LENGTH_SHORT).show();
                    return;
                }

                String finalMessage = message + "\n Please connect me with a mental health professional. \nThank You\n "+name+"\n" + contactNo;

                final String userName = "believeappmail@gmail.com";
                final String passWord = "WeBelieveInLife";
                Properties props = new Properties();
                props.put("mail.smtp.auth","true");
                props.put("mail.smtp.starttls.enable","true");
                props.put("mail.smtp.host","smtp.gmail.com");
                props.put("mail.smtp.port", "587");

                Session session = Session.getInstance(props, new javax.mail.Authenticator(){
                    @Override
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return  new PasswordAuthentication(userName, passWord);
                    }
                });

                try {
                    Message message = new MimeMessage(session);
                    message.setFrom(new InternetAddress(userName));
                    message.setRecipients(Message.RecipientType.TO,InternetAddress.parse("binaya@koshishnepal.org"));
                    message.setSubject("Believe - Contact Professional");
                    message.setText(finalMessage);
                    Transport.send(message);
                    Toast.makeText(ContactProfessional.this, "Message Send Successfully", Toast.LENGTH_SHORT).show();
                    binding.name.setText("");
                    binding.contactNumber.setText("");
                    binding.message.setText("");
                } catch (MessagingException e) {
                    Toast.makeText(ContactProfessional.this, "You need to connect to the internet.", Toast.LENGTH_SHORT).show();
                    throw new RuntimeException(e);

                }

//                Intent email = new Intent(Intent.ACTION_SEND);
//                email.setData(Uri.parse("mailto:"));
//                email.setType("text/plain");
//                email.putExtra(Intent.EXTRA_EMAIL,  new String[]{"l65.fread@gmail.com"});
//                email.putExtra(Intent.EXTRA_SUBJECT, "Believe : Mental Health Professional Contact");
//                email.putExtra(Intent.EXTRA_TEXT, finalMessage);
//                startActivity(Intent.createChooser(email, "Choose an Email client :"));
            }
        });
    }
}