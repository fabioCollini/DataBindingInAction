package it.droidcon.databinding.utils;

import android.content.Context;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.cantrowitz.rxbroadcast.RxBroadcast;
import rx.Observable;

public class ConnectionChecker {

    private Context context;

    public ConnectionChecker(Context context) {
        this.context = context;
    }

    public Observable<Boolean> getConnectionStatus() {
        IntentFilter filter = new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION);
        return RxBroadcast.fromBroadcast(context, filter)
                .map(i -> getNetworkInfo())
                .map(info -> info != null && info.isConnected())
                .distinctUntilChanged();
    }

    private NetworkInfo getNetworkInfo() {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        return connectivityManager.getActiveNetworkInfo();
    }
}
