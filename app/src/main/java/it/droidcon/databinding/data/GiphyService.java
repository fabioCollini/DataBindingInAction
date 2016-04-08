package it.droidcon.databinding.data;

import retrofit.http.GET;
import retrofit.http.Query;
import rx.Observable;

public interface GiphyService {
    @GET("/v1/gifs/random?api_key=dc6zaTOxFJmzC")
    Observable<GiphyResponse> randomGif(@Query("tag") String tag);
}
