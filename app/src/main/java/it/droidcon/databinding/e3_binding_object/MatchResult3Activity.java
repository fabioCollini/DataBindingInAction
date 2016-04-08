package it.droidcon.databinding.e3_binding_object;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.bumptech.glide.Glide;

import it.droidcon.databinding.R;
import it.droidcon.databinding.data.MatchResult;
import it.droidcon.databinding.databinding.MatchResult3Binding;

public class MatchResult3Activity extends AppCompatActivity {

    private MatchResult3Binding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.match_result_3);
        updateDetail(getIntent().getParcelableExtra("RESULT"));
    }

    private void updateDetail(MatchResult result) {
        binding.setResult(result);
        Glide.with(this).load(result.getGifUrl())
                .placeholder(R.drawable.loading).into(binding.resultGif);
    }
}
