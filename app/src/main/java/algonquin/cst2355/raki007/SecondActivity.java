package algonquin.cst2355.raki007;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Intent fromPrevious = getIntent();
        String emailAddress = fromPrevious.getStringExtra("EmailAddress");
        TextView text = findViewById(R.id.textView3);
        EditText phoneNumber = findViewById(R.id.editTextPhone);
        Button callNumber = findViewById(R.id.button);
        ImageView changePicture = findViewById(R.id.imageView);


        text.setText("Welcome back " + emailAddress);

        changePicture.setOnClickListener(  clk -> {
            Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult( cameraIntent, 3456);
        } );
        callNumber.setOnClickListener(  clk -> {
            Intent call = new Intent(Intent.ACTION_DIAL);
            call.setData(Uri.parse("tel:" + phoneNumber));
        } );

        File file= new File("Picture.png");
        if(file.exists()) {
            Bitmap theImage = BitmapFactory.decodeFile("Picture.png");
            changePicture.setImageBitmap( theImage );
        }
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode,resultCode,data);
        if(requestCode == 3456){
            if(resultCode == RESULT_OK){
                Bitmap thumbnail = data.getParcelableExtra("data");
                ImageView changePicture = findViewById(R.id.imageView);
                changePicture.setImageBitmap(thumbnail);
                FileOutputStream fOut = null;
                try {    fOut = openFileOutput( "Picture.png", Context.MODE_PRIVATE); thumbnail.compress(Bitmap.CompressFormat.PNG, 100, fOut);    fOut.flush();    fOut.close();}
                catch (IOException e) {    e.printStackTrace();}
            }
        }
    }
    protected void onPause () {
        super.onPause();
        EditText editTextPhone = findViewById(R.id.editTextPhone);
        SharedPreferences prefs = getSharedPreferences("MyData", Context.MODE_PRIVATE);
        prefs.getString("PhoneNumber", "Default Value");
        String PhoneNumber = prefs.getString("PhoneNumber", "");
        editTextPhone.setText(PhoneNumber);
    }
}