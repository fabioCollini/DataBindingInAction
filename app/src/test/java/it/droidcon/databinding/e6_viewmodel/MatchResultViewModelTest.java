package it.droidcon.databinding.e6_viewmodel;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import java.io.IOException;

import it.droidcon.databinding.data.MatchResult;
import it.droidcon.databinding.data.MatchResultLoader;
import rx.Observable;
import rx.schedulers.Schedulers;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class MatchResultViewModelTest {

    public static final String ERROR_MESSAGE = "ERROR MESSAGE";
    @Rule public final MockitoRule mockitoRule = MockitoJUnit.rule();

    @Mock MatchResultLoader matchResultLoader;

    @Mock SnackbarManager snackbarManager;

    private MatchResultViewModel viewModel;

    @Before
    public void setUp() {
        viewModel = new MatchResultViewModel(matchResultLoader, snackbarManager,
                Schedulers.immediate(), Schedulers.immediate(), new MatchResult("home", "away", 0, 0, "url"));
    }

    @Test
    public void testReload() {
        MatchResult result = new MatchResult("home", "away", 1, 0, "url");
        when(matchResultLoader.load()).thenReturn(Observable.just(result));

        viewModel.reload();

        assertThat(viewModel.result.get()).isSameAs(result);
    }

    @Test
    public void testReloadOnError() {
        when(matchResultLoader.load()).thenReturn(Observable.error(new IOException(ERROR_MESSAGE)));

        viewModel.reload();

        verify(snackbarManager).showError(ERROR_MESSAGE);
    }
}