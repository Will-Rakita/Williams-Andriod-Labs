package algonquin.cst2355.raki007;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
/**
 * @author William Rakita
 * @version 1.0
 *
 * */
//represents a page on the iphone
public class MainActivity extends AppCompatActivity {
    /**This holds the text at the center of the screen*/
    TextView tv = null;
    /**This holds the password entered by the user*/
    EditText et = null;
    /**This button logs in the user*/
    Button btn = null;
    @Override //equivalent to public static void main(String arg[])
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState); //parent constructor
        setContentView(R.layout.activity_main); //loads a layout on the page

         tv = findViewById(R.id.textView);
         et = findViewById(R.id.editText);
         btn = findViewById(R.id.button);
        btn.setOnClickListener(clk -> {
            String password = et.getText().toString();
            if(checkPasswordComplexity(password)){
                tv.setText("You shall pass!");
            }
            else{
                tv.setText("You shall not pass!");
            }
        });
    }

    /**
     * This function checks for an uppercase letter, lowercase letter, a number and a special symbol in an input string
     *
     * @param pw The string object we are looking at
     * @return returns true if the password is complex enough
     */
    private boolean checkPasswordComplexity(String pw) {
        boolean foundUpperCase, foundLowerCase, foundNumber, foundSpecial;
        foundUpperCase = foundLowerCase = foundNumber = foundSpecial = false;

        for (int i = 0; i < pw.length(); i++) {
            if(Character.isDigit(pw.charAt(i))){
                foundNumber = true;
            }
            if(Character.isUpperCase(pw.charAt(i))){
                foundUpperCase = true;
            }
            if(Character.isLowerCase(pw.charAt(i))){
                foundLowerCase = true;
            }
            if(isSpecialCharacter(pw.charAt(i))){
                foundSpecial = true;
            }

        }
        if(foundUpperCase == foundLowerCase == foundNumber == foundSpecial == true){
            return true;
        }
        return false;


    }
    /**
     * This function checks for a special character
     *
     * @param c The char primative we are checkout
     * @return returns true if c is a #, ?, or *
     */
    boolean isSpecialCharacter(char c){
        switch (c){
            case '#':
            case '?':
            case '*':
                return true;
            default:
                return false;
        }
    }
}