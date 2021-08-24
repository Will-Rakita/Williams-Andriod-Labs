package algonquin.cst2355.raki007;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.Switch;

//represents a page on the iphone
public class MainActivity extends AppCompatActivity {
ImageView imgView;
Switch sw;
    @Override //equivalent to public static void main(String arg[])
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState); //parent constructor
        setContentView(R.layout.activity_main); //loads a layout on the page
        imgView = findViewById(R.id.imageView);
        sw = findViewById(R.id.switch1);
        sw.setOnCheckedChangeListener( (btn, isChecked) -> {
            if (isChecked)
            {
                RotateAnimation rotate = new RotateAnimation(0, 360, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
                rotate.setDuration(5000);
                rotate.setRepeatCount(Animation.INFINITE);
                rotate.setInterpolator(new LinearInterpolator());

                imgView.startAnimation(rotate);
            }
            else {
                imgView.clearAnimation();
            }
        });
    }
}