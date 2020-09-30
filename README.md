# Reference
[ ![Download](https://api.bintray.com/packages/zingle/maven/zingle-chat/images/download.svg) ](https://bintray.com/zingle/maven/zingle-chat/_latestVersion)

You will need your Zingle SDK App ID to get started.  You can get this info [here](https://app.zingle.me/service/default/settings/channels/chat)

[Full technical docs on the SDK are available here](https://zingle.github.io/zingle-chat-android/)

# Push Notification Setup
You can develop and test the SDK without push notification support.  In order to allow Zingle to send push notifications on behalf of your app you will need to share the push certificate info with Zingle.  Please contact support@zingleme.com for assistance with Push Notification configuration.

# Adding the SDK to your project
The Zingle SDK is distributed in both AAR and JAR format. If you are using Android Studio, follow the instructions for installation of the AAR package.

**The minimum supported SDK version is API level 16, and your app must be compiled with at least API version 26. If your app needs to support earlier versions of Android, you may still try to integrate, but it is untested and we cannot guarantee compatibility.**

## Android Studio with Gradle
Add JCenter as a repository in your top-level `build.gradle` file.

```java
repositories {
    jcenter()
}
```

Add the dependencies into your application-level `build.gradle` file.

```java
compile 'me.zingle:core:3.0.2'
compile 'me.zingle:ui:3.0.2'
```

# Initialize the SDK

## Initialize from your Application class
Add the following lines of code to your onCreate method on your Application class:

```java
import android.app.Application;
import io.smooch.core.Settings;
import io.smooch.core.Smooch;
import io.smooch.core.SmoochCallback;

public class YourApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Zingle.init(this, new Settings("YOUR_INTEGRATION_ID"), new ZingleCallback<InitializationStatus>() {
            @Override
            public void run(Response<InitializationStatus> response) {
                // Handle init result
            }
        });
    }
}
```

# Displaying the Zingle Chat Interface
Once you’ve initialized Zingle, you’re ready to try it out.

Find a suitable place in your app’s interface to invoke Zingle and use the code below to display the Zingle Chat interface. You can bring up Zingle whenever you think that your user will need access to help or a communication channel to contact you.

Show the ConversationActivity:
```java
import io.smooch.ui.ConversationActivity;

...

ConversationActivity.builder().show(this);
```
# Customizing Colors
Using a `colors.xml` file in your `res/values` folder, you can change the colors used by:
```
<resources>
    <color name="Zingle_accent">#9200aa</color>
    <color name="Zingle_accentDark">#76008a</color>
    <color name="Zingle_accentLight">#be7cca</color>

    <color name="Zingle_backgroundInput">#ffffff</color>

    <color name="Zingle_btnSendHollow">#c0c0c0</color>
    <color name="Zingle_btnSendHollowBorder">#303030</color>

    <color name="Zingle_header">#989898</color>

    <color name="Zingle_messageDate">@color/Zingle_header</color>
    <color name="Zingle_messageShadow">#7f999999</color>

    <color name="Zingle_conversationBackground">#ecebeb</color>

    <color name="Zingle_remoteMessageAuthor">@color/Zingle_header</color>
    <color name="Zingle_remoteMessageBackground">#ffffff</color>
    <color name="Zingle_remoteMessageBorder">#d9d9d9</color>
    <color name="Zingle_remoteMessageText">#000000</color>

    <color name="Zingle_userMessageBackground">@color/Zingle_accent</color>
    <color name="Zingle_userMessageBorder">@color/Zingle_accentDark</color>
    <color name="Zingle_userMessageFailedBackground">@color/Zingle_accentLight</color>
    <color name="Zingle_userMessageText">#ffffff</color>
</resources>
```
If you need to update the image of the Send button, simply add an image named `zingle_btn_send_normal.png` to your `drawables`.

# Customizing strings
The strings used in the SDK interface can be customized by specifying overrides in a language strings.xml file (for example, ```res/values-en/strings.xml``` for English).  Each string name should be prepended with 'Zingle_'.  Example:

```xml
<resources>
    <string name="Zingle_activityConversation">Messages</string>
    <string name="Zingle_startOfConversation">This is the start of your conversation with the team.</string>
    <string name="Zingle_welcome">Feel free to leave us a message about anything that\'s on your mind.</string>
    <string name="Zingle_messageHint">Type a message…</string>
</resources>
```
A complete list of strings can be found [here](https://github.com/Zingle/web-chat#individual-functions).
