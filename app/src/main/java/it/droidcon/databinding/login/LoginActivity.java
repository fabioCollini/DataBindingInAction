package it.droidcon.databinding.login;

import android.databinding.DataBindingUtil;
import android.databinding.OnRebindCallback;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import com.transitionseverywhere.TransitionManager;
import it.codingjam.lifecyclebinder.LifeCycleBinder;
import it.codingjam.lifecyclebinder.RetainedObjectProvider;
import it.droidcon.databinding.R;
import it.droidcon.databinding.databinding.LoginBinding;
import it.droidcon.databinding.utils.ConnectionChecker;
import java.util.concurrent.Callable;

import static android.support.design.widget.Snackbar.LENGTH_LONG;

public class LoginActivity extends AppCompatActivity {

    @RetainedObjectProvider("loginViewModel") Callable<LoginViewModel> factory =
            () -> new LoginViewModel(new ConnectionChecker(getApplicationContext()));

    LoginViewModel loginViewModel;

    private LoginBinding binding;

    @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.login);
        binding.addOnRebindCallback(new OnRebindCallback() {
            @Override public boolean onPreBind(ViewDataBinding binding) {
                ViewGroup root = (ViewGroup) binding.getRoot();
                TransitionManager.beginDelayedTransition(root);
                return true;
            }
        });
        LifeCycleBinder.bind(this);
        binding.setLoginViewModel(loginViewModel);
    }

    public void send(View view) {
        Snackbar.make(binding.getRoot(), "AAAA", LENGTH_LONG).show();
    }
}
