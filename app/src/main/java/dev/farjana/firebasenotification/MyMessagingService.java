package dev.farjana.firebasenotification;

import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

import java.util.Objects;

public class MyMessagingService extends FirebaseMessagingService  {

    @Override
    public void onMessageReceived(@NonNull RemoteMessage remoteMessage){
        super.onMessageReceived(remoteMessage);

        getFirebaseMessage(Objects.requireNonNull(remoteMessage.getNotification()).getTitle(),remoteMessage.getNotification().getBody());
    }

    void onNewToken() {

    }

    private void getFirebaseMessage(String title, String body) {

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this,"channel")
                .setSmallIcon(R.drawable.notify_icon)
                .setContentTitle(title)
                .setContentText(body)
                .setAutoCancel(true);

        NotificationManagerCompat managerCompat= NotificationManagerCompat.from(this);
        managerCompat.notify(101,builder.build());



    }


}
