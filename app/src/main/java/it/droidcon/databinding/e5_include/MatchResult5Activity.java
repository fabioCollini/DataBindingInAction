package it.droidcon.databinding.e5_include;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import it.droidcon.databinding.R;
import it.droidcon.databinding.databinding.MatchResult5Binding;

public class MatchResult5Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MatchResult5Binding binding =
                DataBindingUtil.setContentView(this, R.layout.match_result_5);
        binding.setResult(getIntent().getParcelableExtra("RESULT"));
    }
}
