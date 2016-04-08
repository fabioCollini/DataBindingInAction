package it.droidcon.databinding.data;

import java.util.Arrays;
import java.util.List;

public class ApiResponse {
    private List<Fixture> fixtures;

    public ApiResponse() {
    }

    public static ApiResponse create(Fixture... fixtures) {
        ApiResponse response = new ApiResponse();
        response.fixtures = Arrays.asList(fixtures);
        return response;
    }

    public List<Fixture> getFixtures() {
        return fixtures;
    }
}
