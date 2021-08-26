package algonquin.cst2355.raki007;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Date;

public class ChatRoom extends AppCompatActivity {
    RecyclerView chatList;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.chatlayout);
        chatList = findViewById(R.id.myrecycler);
        chatList.setAdapter(new MyChatAdapter());

    }
    private class ChatMessage{
        String message;
        int sendOrReceive;
        Date timesent;

    }
}
