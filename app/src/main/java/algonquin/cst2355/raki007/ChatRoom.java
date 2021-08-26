package algonquin.cst2355.raki007;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

public class ChatRoom extends AppCompatActivity {
    RecyclerView chatList;
    Button Send;
    Button Receive;
    TextView MessageText;
    ArrayList<ChatMessage> messages = new ArrayList<>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.chatlayout);
        chatList = findViewById(R.id.myrecycler);
        chatList.setAdapter(new MyChatAdapter());
        Send = findViewById(R.id.sendButton);
        Receive = findViewById(R.id.receiveButton);
        MessageText = findViewById(R.id.editTextTextPersonName2);
        MyChatAdapter adt = new MyChatAdapter();
        chatList.setAdapter(adt);
        chatList.setLayoutManager(new LinearLayoutManager(this));

        Send.setOnClickListener(clk -> {
            SimpleDateFormat sdf = new SimpleDateFormat("EEEE, dd-MMM-yyyy hh-mm-ss a", Locale.getDefault());
            String currentDateandTime = sdf.format(new Date());
            ChatMessage thisMessage = new ChatMessage(MessageText.getText().toString() , 1,currentDateandTime  );
            messages.add(thisMessage);
            MessageText.setText("");
            adt.notifyItemInserted(messages.size()-1);

        });
        Receive.setOnClickListener(clk -> {

            SimpleDateFormat sdf = new SimpleDateFormat("EEEE, dd-MMM-yyyy hh-mm-ss a", Locale.getDefault());

            String currentDateandTime = sdf.format(new Date());
            ChatMessage thisMessage = new ChatMessage(MessageText.getText().toString() , 2,currentDateandTime  );
            messages.add(thisMessage);
            MessageText.setText("");
            adt.notifyItemInserted(messages.size()-1);
        });

    }

    private class ChatMessage {
        String message;
        int sendOrReceive;
        String timesent;

        public ChatMessage(String message, int sendOrReceive, String timesent) {
            this.message = message;
            this.sendOrReceive = sendOrReceive;
            this.timesent = timesent;
        }

        public String getMessage() {
            return message;
        }

        public int getSendOrReceive() {
            return sendOrReceive;
        }

        public String getTimesent() {
            return timesent;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public void setSendOrReceive(int sendOrReceive) {
            this.sendOrReceive = sendOrReceive;
        }

        public void setTimesent(String timesent) {
            this.timesent = timesent;
        }
    }

    private class MyRowViews extends RecyclerView.ViewHolder {
        TextView messageText;
        TextView timeText;

        public MyRowViews(View itemView) {
            super(itemView);

            messageText = itemView.findViewById(R.id.textView4);
            timeText = itemView.findViewById(R.id.textView5);

        }

        public MyRowViews onCreateViewHolder(ViewGroup parent, int viewType) {
            return null;
        }

        public void onBindViewHolder(MyRowViews holder, int position) {

        }
    }
    private class MyChatAdapter extends RecyclerView.Adapter<MyRowViews>{

        public void MyRowViews (MyRowViews holder, int position) {

        }
        @Override
        public MyRowViews onCreateViewHolder(ViewGroup parent, int viewType){
            LayoutInflater inflater = getLayoutInflater();
            int layoutID;
                    if(viewType == 1)
                        layoutID = R.layout.sent_message;
                    else
                        layoutID = R.layout.receive_message;

            View loadedRow = inflater.inflate(layoutID, parent, false);
            return new MyRowViews(loadedRow);
        }
        @Override
        public void onBindViewHolder(MyRowViews holder, int position){
            holder.messageText.setText(messages.get(position).getMessage());
            holder.timeText.setText(messages.get(position).getTimesent());
        }
        @Override
        public int getItemCount() {

            return messages.size();
        }

        /**
         * Return the view type of the item at <code>position</code> for the purposes
         * of view recycling.
         *
         * <p>The default implementation of this method returns 0, making the assumption of
         * a single view type for the adapter. Unlike ListView adapters, types need not
         * be contiguous. Consider using id resources to uniquely identify item view types.
         *
         * @param position position to query
         * @return integer value identifying the type of the view needed to represent the item at
         * <code>position</code>. Type codes need not be contiguous.
         */
        @Override
        public int getItemViewType(int position) {
            return super.getItemViewType(position);
        }
    }
}
