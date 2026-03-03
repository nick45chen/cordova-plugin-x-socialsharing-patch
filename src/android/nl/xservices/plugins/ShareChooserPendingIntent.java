package nl.xservices.plugins;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

public class ShareChooserPendingIntent extends BroadcastReceiver {
    public static String chosenComponent = null;

    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent == null) {
            return;
        }

        Bundle extras = intent.getExtras();
        if (extras == null || !extras.containsKey(Intent.EXTRA_CHOSEN_COMPONENT)) {
            return;
        }

        Object chosen = extras.get(Intent.EXTRA_CHOSEN_COMPONENT);
        if (chosen instanceof ComponentName) {
            ShareChooserPendingIntent.chosenComponent = ((ComponentName) chosen).flattenToString();
        }
    }
}
