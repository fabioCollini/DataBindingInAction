package it.droidcon.databinding.data;

import retrofit.http.GET;
import rx.Observable;

public interface FootballDataService {
    @GET("/v1/teams/99/fixtures")
    Observable<ApiResponse> getMatches();
}
