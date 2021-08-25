package algonquin.cst2355.raki007;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

//represents a page on the iphone
public class MainActivity extends AppCompatActivity {

    @Override //equivalent to public static void main(String arg[])
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState); //parent constructor
        setContentView(R.layout.activity_main); //loads a layout on the page
        Button loginButton = findViewById(R.id.loginButton);
        EditText emailEditText = findViewById(R.id.editTextTextPersonName);

        Log.w( "MainActivity", "In onCreate() - Loading Widgets" );
        SharedPreferences prefs = getSharedPreferences("MyData", Context.MODE_PRIVATE);
        prefs.getString("VariableName", "Default Value");
        String emailAddress = prefs.getString("LoginName", "");
        emailEditText.setText(emailAddress);
        loginButton.setOnClickListener(  clk -> {
            Intent nextPage = new Intent( MainActivity.this, SecondActivity.class);
            Intent:nextPage.putExtra( "EmailAddress", emailEditText.getText().toString() );

            startActivity( nextPage );
            SharedPreferences.Editor editor = prefs.edit();
            editor.putString("LoginName", emailEditText.getText().toString());
            editor.apply();
        } );

    }
    protected void onStart () {
        super.onStart();
        Log.w( "MainActivity", "In onStart() - The application is now visible on screen" );

    }
    protected void onResume () {
        super.onResume();
        Log.w( "MainActivity", "In onResume() - The application is now responding to user input" );

    }
    protected void onDestroy () {
        super.onDestroy();
        Log.w( "MainActivity", "In onDestroy() - Any memory used by the application is freed." );
    }
    protected void onPause () {
        super.onPause();
        Log.w( "MainActivity", "In onPause() - The application no longer responds to user input" );


    }
}