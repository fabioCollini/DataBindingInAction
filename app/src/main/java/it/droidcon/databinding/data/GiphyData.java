package it.droidcon.databinding.data;

import com.google.gson.annotations.SerializedName;

public class GiphyData {

    @SerializedName("image_url")
    private String url;

    public GiphyData() {
    }

    public GiphyData(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }
}
