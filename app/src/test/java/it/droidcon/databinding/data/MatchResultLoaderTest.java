package it.droidcon.databinding.data;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import rx.Observable;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class MatchResultLoaderTest {

    @Rule public final MockitoRule mockitoRule = MockitoJUnit.rule();

    public static final String URL = "URL";

    @Mock FootballDataService footballDataService;

    @Mock GiphyService giphyService;

    @InjectMocks MatchResultLoader matchResultLoader;

    @Before
    public void setUp() throws Exception {
        when(footballDataService.getMatches()).thenReturn(Observable.just(ApiResponse.create(
                new Fixture("A", "B", 1, 2, "FINISHED"),
                new Fixture("C", "D", 3, 4, "FINISHED")
        )));

        when(giphyService.randomGif(anyString())).thenReturn(Observable.just(new GiphyResponse(URL)));
    }

    @Test
    public void testLoadFixture() {
        MatchResult matchResult = matchResultLoader.load().toBlocking().first();

        assertThat(matchResult).isNotNull();
        assertThat(matchResult.getHomeTeam().getName()).isEqualTo("C");
        assertThat(matchResult.getAwayTeam().getName()).isEqualTo("D");
    }

    @Test
    public void testLoadGif() {
        MatchResult matchResult = matchResultLoader.load().toBlocking().first();

        assertThat(matchResult.getGifUrl()).isEqualTo(URL);
    }

    @Test
    public void testLoadGifWon() {
        when(footballDataService.getMatches()).thenReturn(Observable.just(ApiResponse.create(
                new Fixture(MatchResultLoader.MY_TEAM_NAME, "D", 2, 1, "FINISHED")
        )));

        matchResultLoader.load().toBlocking().first();

        verify(giphyService).randomGif("won");
    }

    @Test
    public void testLoadGifDrawn() {
        when(footballDataService.getMatches()).thenReturn(Observable.just(ApiResponse.create(
                new Fixture(MatchResultLoader.MY_TEAM_NAME, "D", 1, 1, "FINISHED")
        )));

        matchResultLoader.load().toBlocking().first();

        verify(giphyService).randomGif("drawn");
    }

    @Test
    public void testLoadGifLost() {
        when(footballDataService.getMatches()).thenReturn(Observable.just(ApiResponse.create(
                new Fixture("A", MatchResultLoader.MY_TEAM_NAME, 2, 1, "FINISHED")
        )));

        matchResultLoader.load().toBlocking().first();

        verify(giphyService).randomGif("lost");
    }
}