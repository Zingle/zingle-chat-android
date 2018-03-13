# Reference

You will need your Zingle SDK App ID to get started.  You can get this info [here](https://app.zingle.me/service/default/settings/channels/chat)

[Full technical docs on the SDK are available here](https://zingle.github.io/zingle-chat-android/) 

# Push Notification Setup
You can develop and test the SDK without push notification support.  In order to allow Zingle to send push notifications on behalf of your app you will need to share the push certificate info with Zingle.  Please contact support@zingleme.com for assistance with Push Notification configuration.

# Adding the SDK to your project
The Zingle SDK is distributed in both AAR and JAR format. If you are using Android Studio, follow the instructions for installation of the AAR package.

**The minimum supported SDK version is API level 15, and your app must be compiled with at least API version 26. If your app needs to support earlier versions of Android, you may still try to integrate, but it is untested and we cannot guarantee compatibility.**

## Importing the JAR
TODO: Add info here

## Android Studio with Gradle
TODO: Add detailed info on Gradle setup here. 

# Initialize the SDK

## Initialize from your Application class
Add the following lines of code to your onCreate method on your Application class:

```java
Zingle.init(this, new Settings("YOUR_APP_ID"), new ZingleCallback() {
    @Override
    public void run(Response response) {
        // Your code after init is complete
    }
});
```
If you don’t have an Application class, you must create one to make sure Zingle is always initialized properly

## Initialize from an Activity class
You can also initialize Zingle from an Activity. This is useful if you don’t know your Zingle app ID at app launch or if you want to run multiple Zingle services in the same Android app.

Add the following line of code to your onCreate method on your Application class:
```java
Zingle.init(this);
```
If you don’t have an Application class, you must create one to make sure Zingle is always initialized properly

Add the following line of code where you want to initialize Zingle in your Activity class:
```java
Zingle.init(this, new Settings("YOUR_APP_ID"), new ZingleCallback() {
    @Override
    public void run(Response response) {
        // Your code after init is complete
    }
});
```

For example, to initialize Zingle chat when a button is tapped, you can do the following:
```java
package your.package;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import me.zingle.core.Settings;
import me.zingle.core.Zingle;
import me.zingle.core.ZingleCallback;
import me.zingle.ui.ConversationActivity;

public class YourActivity extends AppCompatActivity implements View.OnClickListener {
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button showConversationActivityButton = findViewById(R.id.button_show_conversation_activity);
        showConversationActivityButton.setOnClickListener(this);
    }

    public void onClick(View v) {
        final int id = v.getId();

        if (id == R.id.button_show_conversation_activity) {
            Zingle.init(getApplication(), new Settings("YOUR_APP_ID"), new ZingleCallback() {
                @Override
                public void run(Response response) {
                    if (response.getError() == null) {
                        ConversationActivity.show(getApplicationContext());
                    }
                }
            });

        }
    }
}
```

# Displaying the Zingle Chat Interface
Once you’ve initialized Zingle, you’re ready to try it out.

Find a suitable place in your app’s interface to invoke Zingle and use the code below to display the Zingle Chat interface. You can bring up Zingle whenever you think that your user will need access to help or a communication channel to contact you.
```java
ConversationActivity.show(this);
```

