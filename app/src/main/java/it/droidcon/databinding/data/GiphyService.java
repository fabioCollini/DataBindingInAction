package it.droidcon.databinding.data;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

public interface GiphyService {
    @GET("/v1/gifs/random?api_key=dc6zaTOxFJmzC")
    Observable<GiphyResponse> randomGif(@Query("tag") String tag);
}
