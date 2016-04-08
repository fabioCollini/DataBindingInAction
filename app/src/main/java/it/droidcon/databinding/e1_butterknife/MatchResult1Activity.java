package it.droidcon.databinding.e1_butterknife;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import butterknife.Bind;
import butterknife.ButterKnife;
import it.droidcon.databinding.R;
import it.droidcon.databinding.data.MatchResult;

public class MatchResult1Activity extends AppCompatActivity {

    @Bind(R.id.result_gif)
    ImageView resultGif;
    @Bind(R.id.home_team)
    TextView homeTeam;
    @Bind(R.id.away_team)
    TextView awayTeam;
    @Bind(R.id.home_goals)
    TextView homeGoals;
    @Bind(R.id.away_goals)
    TextView awayGoals;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.match_result_1);
        ButterKnife.bind(this);
        updateDetail(getIntent().getParcelableExtra("RESULT"));
    }

    @SuppressLint("SetTextI18n")
    private void updateDetail(MatchResult result) {
        if (result.getHomeTeam() != null) {
            homeTeam.setText(result.getHomeTeam().getName());
            homeGoals.setText(Integer.toString(result.getHomeTeam().getGoals()));
        }
        if (result.getAwayTeam() != null) {
            awayTeam.setText(result.getAwayTeam().getName());
            awayGoals.setText(Integer.toString(result.getAwayTeam().getGoals()));
        }
        Glide.with(this).load(result.getGifUrl())
                .placeholder(R.drawable.loading).into(resultGif);
    }
}
