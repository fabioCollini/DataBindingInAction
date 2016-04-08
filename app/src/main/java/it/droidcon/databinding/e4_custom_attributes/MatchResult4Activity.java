package it.droidcon.databinding.e4_custom_attributes;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import it.droidcon.databinding.R;
import it.droidcon.databinding.data.MatchResult;
import it.droidcon.databinding.databinding.MatchResult4Binding;

public class MatchResult4Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MatchResult4Binding binding =
                DataBindingUtil.setContentView(this, R.layout.match_result_4);
        MatchResult result = getIntent().getParcelableExtra("RESULT");
        binding.setResult(result);
    }
}
