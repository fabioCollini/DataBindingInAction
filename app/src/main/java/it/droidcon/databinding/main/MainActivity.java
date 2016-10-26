package it.droidcon.databinding.main;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import it.cosenonjaviste.mv2m.ViewModelActivity;
import it.cosenonjaviste.mv2m.rx.AndroidSchedulerManager;
import it.droidcon.databinding.R;
import it.droidcon.databinding.contact_1.ContactActivity;
import it.droidcon.databinding.data.MatchResultLoader;
import it.droidcon.databinding.databinding.ActivityMainBinding;
import it.droidcon.databinding.e1_butterknife.MatchResult1Activity;
import it.droidcon.databinding.e2_binding.MatchResult2Activity;
import it.droidcon.databinding.e3_binding_object.MatchResult3Activity;
import it.droidcon.databinding.e4_custom_attributes.MatchResult4Activity;
import it.droidcon.databinding.e5_include.MatchResult5Activity;
import it.droidcon.databinding.e6_viewmodel.MatchResult6Activity;
import it.droidcon.databinding.login.LoginActivity;
import it.droidcon.databinding.question.QuestionActivity;
import it.droidcon.databinding.utils.SnackbarManager;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends ViewModelActivity<MainViewModel> {

    @Override
    public MainViewModel createViewModel() {
        return new MainViewModel(new AndroidSchedulerManager(),
                MatchResultLoader.singleton(), new SnackbarManager());
    }

    @Override
    protected void onCreate(Bundle state) {
        super.onCreate(state);
        viewModel.reload();
        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.setViewModel(viewModel);
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));

        List<Class<? extends AppCompatActivity>> activities = Arrays.asList(
                MatchResult1Activity.class,
                MatchResult2Activity.class,
                MatchResult3Activity.class,
                MatchResult4Activity.class,
                MatchResult5Activity.class,
                MatchResult6Activity.class,
                ContactActivity.class,
                it.droidcon.databinding.contact_2.ContactActivity.class,
                it.droidcon.databinding.contact_3.ContactActivity.class,
                LoginActivity.class,
                QuestionActivity.class,
                it.droidcon.databinding.question_viewmodel.QuestionActivity.class
        );

        binding.recyclerView.setAdapter(new RecyclerView.Adapter<ActivityClassViewHolder>() {
            @Override
            public ActivityClassViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                return new ActivityClassViewHolder(getLayoutInflater().inflate(android.R.layout.simple_list_item_1, parent, false));
            }

            @Override
            public void onBindViewHolder(ActivityClassViewHolder holder, int position) {
                Class<? extends AppCompatActivity> c = activities.get(position);
                ((TextView) holder.itemView).setText(c.getSimpleName());
                holder.itemView.setOnClickListener(v -> {
                    Intent intent = new Intent(MainActivity.this, c).putExtra("RESULT", viewModel.getModel().matchResult.get());
                    startActivity(intent);
                });
            }

            @Override
            public int getItemCount() {
                return activities.size();
            }
        });
    }


    private class ActivityClassViewHolder extends RecyclerView.ViewHolder {
        public ActivityClassViewHolder(View itemView) {
            super(itemView);
        }
    }
}
