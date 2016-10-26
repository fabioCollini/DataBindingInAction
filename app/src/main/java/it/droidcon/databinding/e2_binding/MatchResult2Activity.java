package it.droidcon.databinding.e2_binding;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import com.bumptech.glide.Glide;
import it.droidcon.databinding.R;
import it.droidcon.databinding.data.MatchResult;
import it.droidcon.databinding.databinding.MatchResult2Binding;

public class MatchResult2Activity extends AppCompatActivity {

    private MatchResult2Binding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this, R.layout.match_result_2);

        MatchResult result = getIntent().getParcelableExtra("RESULT");

        if (result.getHomeTeam() != null) {
            binding.homeTeam.setText(result.getHomeTeam().getName());
            binding.homeGoals.setText(Integer.toString(result.getHomeTeam().getGoals()));
        }
        if (result.getAwayTeam() != null) {
            binding.awayTeam.setText(result.getAwayTeam().getName());
            binding.awayGoals.setText(Integer.toString(result.getAwayTeam().getGoals()));
        }
        Glide.with(this).load(result.getGifUrl())
                .placeholder(R.drawable.loading).into(binding.resultGif);
    }
}
