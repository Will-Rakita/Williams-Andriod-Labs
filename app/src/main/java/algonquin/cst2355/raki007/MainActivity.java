package algonquin.cst2355.raki007;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
//represents a page on the iphone
public class MainActivity extends AppCompatActivity {

    @Override //equivalent to public static void main(String arg[])
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState); //parent constructor
        setContentView(R.layout.activity_main); //loads a layout on the page
    }
}