package it.droidcon.databinding.data;

public class GiphyResponse {
    private GiphyData data;

    public GiphyResponse() {
    }

    public GiphyResponse(String url) {
        this.data = new GiphyData(url);
    }

    public GiphyData getData() {
        return data;
    }
}
