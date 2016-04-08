package it.droidcon.databinding.data;

import android.os.Parcel;
import android.os.Parcelable;

public class MatchResult implements Parcelable {

    private final TeamScore homeTeam;
    private final TeamScore awayTeam;
    private final String gifUrl;

    public MatchResult(TeamScore homeTeam, TeamScore awayTeam, String gifUrl) {
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.gifUrl = gifUrl;
    }

    public MatchResult(Fixture f, String url) {
        homeTeam = new TeamScore(f.getHomeTeamName(), f.getResult().getGoalsHomeTeam());
        awayTeam = new TeamScore(f.getAwayTeamName(), f.getResult().getGoalsAwayTeam());
        this.gifUrl = url;
    }

    public MatchResult(String homeTeamName, String awayTeamName, int goalsHomeTeam, int goalsAwayTeam, String gifUrl) {
        homeTeam = new TeamScore(homeTeamName, goalsHomeTeam);
        awayTeam = new TeamScore(awayTeamName, goalsAwayTeam);
        this.gifUrl = gifUrl;
    }

    protected MatchResult(Parcel in) {
        homeTeam = in.readParcelable(TeamScore.class.getClassLoader());
        awayTeam = in.readParcelable(TeamScore.class.getClassLoader());
        gifUrl = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(homeTeam, flags);
        dest.writeParcelable(awayTeam, flags);
        dest.writeString(gifUrl);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<MatchResult> CREATOR = new Creator<MatchResult>() {
        @Override
        public MatchResult createFromParcel(Parcel in) {
            return new MatchResult(in);
        }

        @Override
        public MatchResult[] newArray(int size) {
            return new MatchResult[size];
        }
    };

    public TeamScore getHomeTeam() {
        return homeTeam;
    }

    public TeamScore getAwayTeam() {
        return awayTeam;
    }

    public String getGifUrl() {
        return gifUrl;
    }
}
