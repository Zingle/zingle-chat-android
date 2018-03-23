package me.zingle.zinglesdkdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

import me.zingle.ui.ConversationActivity;


public class MainActivity extends AppCompatActivity {

    private RelativeLayout mRlChatButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setUpChatButton();
    }

    /**
     * Opens the Zingle interface by accessing the Smooch SDK's Conversation Activity class and
     * calling the show method
     */
    private void showZingleInterface() {
        ConversationActivity.show(this);
    }

    /**
     * Assigns UI relative layout to Activity property and sets on click listener
     */
    private void setUpChatButton() {
        mRlChatButton = findViewById(R.id.mainActivity_relative_chatButton);
        mRlChatButton.setOnClickListener(mChatButtonClickListener);
    }

    /**
     * An OnClickListener that calls the showZingleInterface method when clicked
     */
    private View.OnClickListener mChatButtonClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            showZingleInterface();
        }
    };
}
