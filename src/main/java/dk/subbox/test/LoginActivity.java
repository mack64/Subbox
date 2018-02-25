package dk.subbox.test;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

import static dk.subbox.test.LoginHelperMethods.isValidPassword;
import static dk.subbox.test.LoginHelperMethods.isValidUsername;


public class LoginActivity extends FragmentActivity {


    private EditText usernameEditText;
    private EditText passwordEditText;
    private Button signInButton;
    private Button signUpButton;

    private HttpsURLConnection connection;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        this.usernameEditText = findViewById(R.id.usernameEditText);
        this.passwordEditText = findViewById(R.id.passwordEditText);
        this.signInButton = findViewById(R.id.signInButton);
        this.signUpButton = findViewById(R.id.signUpButton);

        try {

            URL url = new URL("https://app.subbox.dk/");
            connection = (HttpsURLConnection) url.openConnection();

        }catch (MalformedURLException e){
            //TODO: DEV change the catch code when releasing.
            Log.e("Alert","MalformedURL server1");
            e.printStackTrace();
        } catch (IOException e) {
            Log.e("Alert","some error server2");
            e.printStackTrace();
        }



        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO: login into server here.

                Log.e("Alert","you clicked login");



                if (!isValidPassword(passwordEditText.getText().toString())){
                    //TODO: handle writing input.
                    return;
                }

                if (!isValidUsername(usernameEditText.getText().toString())){
                    //TODO: handle writing input.
                    return;
                }
            }
        });

        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Log.e("Alert","you clicked signup");
                //TODO: sing the user up here.

                Intent intent = new Intent(LoginActivity.this,SignUpActivity.class);
                LoginActivity.this.startActivity(intent);

            }
        });

    }




}
