package it.droidcon.databinding.question_viewmodel;

import it.droidcon.databinding.TestSchedulerRule;
import it.droidcon.databinding.utils.ConnectionChecker;
import java.util.concurrent.TimeUnit;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import rx.Observable;
import rx.subjects.BehaviorSubject;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.mockito.Mockito.when;

public class QuestionViewModelTest {

    @Rule public final MockitoRule mockitoRule = MockitoJUnit.rule();

    @Rule public final TestSchedulerRule testSchedulerRule = new TestSchedulerRule();

    @Mock ConnectionChecker connectionChecker;

    @InjectMocks QuestionViewModel viewModel;

    @Before
    public void setUp() throws Exception {
        when(connectionChecker.getConnectionStatus()).thenReturn(Observable.just(true));
    }

    @Test
    public void checkButtonEnabled() throws Exception {
        createAndStartViewModel();

        viewModel.getModel().answer.set("42");

        assertButtonIsEnabled(true);
    }

    @Test
    public void disableButtonAfterTenSeconds() throws Exception {
        createAndStartViewModel();

        viewModel.getModel().answer.set("42");

        assertButtonIsEnabled(true);

        testSchedulerRule.getTestScheduler().advanceTimeBy(10, TimeUnit.SECONDS);

        assertButtonIsEnabled(false);
    }

    @Test
    public void enableButtonOnConnection() throws Exception {
        BehaviorSubject<Boolean> connectionSubject = BehaviorSubject.create(false);
        when(connectionChecker.getConnectionStatus()).thenReturn(connectionSubject);

        createAndStartViewModel();
        viewModel.getModel().answer.set("42");

        assertButtonIsEnabled(false);
        connectionSubject.onNext(true);
        assertButtonIsEnabled(true);
        connectionSubject.onNext(false);
        assertButtonIsEnabled(false);
    }

    private void assertButtonIsEnabled(boolean enabled) {
        assertThat(viewModel.getModel().sendEnabled.get()).isEqualTo(enabled);
    }

    private void createAndStartViewModel() {
        viewModel.onCreate(null, null, null, null);
        viewModel.onStart();
    }
}