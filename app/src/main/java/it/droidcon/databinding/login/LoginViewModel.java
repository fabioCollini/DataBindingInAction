package it.droidcon.databinding.login;

import android.os.Bundle;
import it.droidcon.databinding.utils.BaseRxViewModel;
import it.droidcon.databinding.utils.ConnectionChecker;
import rx.subscriptions.CompositeSubscription;

public class LoginViewModel extends BaseRxViewModel<LoginModel> {

    private ConnectionChecker connectionChecker;

    public LoginViewModel(ConnectionChecker connectionChecker) {
        this.connectionChecker = connectionChecker;
    }

    @Override protected LoginModel createModel(Bundle arguments) {
        return new LoginModel();
    }

    @Override protected void onStart(CompositeSubscription subscription) {
        //subscription.add(
        //        Observable.combineLatest(
        //                toRx(model.userName),
        //                toRx(model.password),
        //                connectionChecker.getConnectionStatus(),
        //                (userName, password, connected) ->
        //                        !userName.isEmpty() && !password.isEmpty() && connected
        //        ).subscribe(model.sendEnabled::set)
        //);
    }
}
