package algonquin.cst2355.raki007;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

//represents a page on the iphone
public class MainActivity extends AppCompatActivity {

    @Override //equivalent to public static void main(String arg[])
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState); //parent constructor
        setContentView(R.layout.activity_main); //loads a layout on the page
        TextView mytext = findViewById(R.id.textview);
        Button myButton = findViewById(R.id.mybutton);
        EditText myedit = findViewById(R.id.myedittext);
        ImageView myimage = findViewById(R.id.algonquin);
        ImageButton imgbtn = findViewById( R.id.myimagebutton );
        CheckBox mycheckbox = findViewById(R.id.mycheckbox);
        Switch myswitch = findViewById(R.id.myswitch);
        RadioButton myradiobutton = findViewById(R.id.myradiobutton);

        Context context = getApplicationContext();
        int duration = Toast.LENGTH_SHORT;

        mycheckbox.setOnCheckedChangeListener( (btn, isChecked) -> {
            mycheckbox.setText("I guess you do like coffee 1");
            Toast toast = Toast.makeText(context, "Have a checkbox toast", duration);
            toast.show();
        } );
        myswitch.setOnCheckedChangeListener( (btn, isChecked) -> {
            myswitch.setText("I guess you do like coffee 2");
            Toast toast = Toast.makeText(context, "Have a switch toast", duration);
            toast.show();
        } );
        myradiobutton.setOnCheckedChangeListener( (btn, isChecked) -> {
            myradiobutton.setText("I guess you do like coffee 3");
            Toast toast = Toast.makeText(context, "Have a radiobox toast", duration);
            toast.show();
        } );
        myButton.setOnClickListener(    (vw) -> {
            // Code here executes on main thread after user presses button
                String editString = myedit.getText().toString();
                mytext.setText( "Your edit text has: " + editString);

        });
        imgbtn.setOnClickListener(    (vw) -> {
            // Code here executes on main thread after user presses button
            Toast toast = Toast.makeText(context, "The width is " + imgbtn.getWidth() + " the height is " + imgbtn.getHeight(), duration);
            toast.show();
        });

    }
}