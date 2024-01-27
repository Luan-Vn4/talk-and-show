package br.com.talk_and_show.activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import br.com.talk_and_show.database.DataBaseHelper;
import br.com.talk_and_show.databinding.ActivitySignupBinding;


public class SignupActivity extends AppCompatActivity {
    ActivitySignupBinding binding;
    DataBaseHelper databaseHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySignupBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        databaseHelper = new DataBaseHelper(this);

        binding.activitySignupButtonSignup.setOnClickListener(v -> {
            String email = binding.activitySignupEditTextEmail.getText().toString();
            String password = binding.activitySignupEditTextPassword.getText().toString();
            String confirmPassword = binding.activitySignupEditTextPasswordConfirm.getText().toString();

            if(email.equals("")||password.equals("")||confirmPassword.equals(""))
                Toast.makeText(SignupActivity.this, "All fields are mandatory", Toast.LENGTH_SHORT).show();
            else{
                if(password.equals(confirmPassword)){
                    Boolean checkUserEmail = databaseHelper.checkEmail(email);
                    if(!checkUserEmail){
                        Boolean insert = databaseHelper.insertData(email, password);
                        if(insert){
                            Toast.makeText(SignupActivity.this, "Signup Successfully!", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                            startActivity(intent);
                        }else{
                            Toast.makeText(SignupActivity.this, "Signup Failed!", Toast.LENGTH_SHORT).show();
                        }
                    }
                    else{
                        Toast.makeText(SignupActivity.this, "User already exists! Please login", Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(SignupActivity.this, "Invalid Password!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        binding.activitySignupTextViewLoginRedirectText.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(),LoginActivity.class);
            startActivity(intent);
        });
    }
}