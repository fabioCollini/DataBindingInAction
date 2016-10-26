package it.droidcon.databinding.question_viewmodel;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import it.codingjam.lifecyclebinder.LifeCycleBinder;
import it.codingjam.lifecyclebinder.RetainedObjectProvider;
import it.droidcon.databinding.R;
import it.droidcon.databinding.databinding.QuestionViewModelBinding;
import it.droidcon.databinding.utils.ConnectionChecker;
import java.util.concurrent.Callable;

public class QuestionActivity extends AppCompatActivity {

    @RetainedObjectProvider("viewModel")
    Callable<QuestionViewModel> viewModelFactory =
            () -> new QuestionViewModel(new ConnectionChecker(getApplicationContext()));

    QuestionViewModel viewModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LifeCycleBinder.bind(this);

        QuestionViewModelBinding binding = DataBindingUtil.setContentView(this, R.layout.question_view_model);
        binding.setViewMode(viewModel);
    }
}
