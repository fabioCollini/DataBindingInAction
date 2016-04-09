package it.droidcon.databinding.e6_viewmodel;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import it.droidcon.databinding.R;
import it.droidcon.databinding.data.MatchResult;
import it.droidcon.databinding.data.MatchResultLoader;
import it.droidcon.databinding.databinding.MatchResult6Binding;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class MatchResult6Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MatchResult6Binding binding =
                DataBindingUtil.setContentView(this, R.layout.match_result_6);
        MatchResult result = getIntent().getParcelableExtra("RESULT");
        binding.setViewModel(new MatchResultViewModel(MatchResultLoader.singleton(),
                new SnackbarManager(this), Schedulers.io(), AndroidSchedulers.mainThread(), result));
    }
}
