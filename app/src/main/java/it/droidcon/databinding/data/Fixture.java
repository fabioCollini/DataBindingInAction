package it.droidcon.databinding.data;

public class Fixture {
    private String homeTeamName;
    private String awayTeamName;
    private Result result;
    private String status;

    public Fixture() {
    }

    public Fixture(String homeTeamName, String awayTeamName, int goalsHomeTeam, int goalsAwayTeam, String status) {
        this.homeTeamName = homeTeamName;
        this.awayTeamName = awayTeamName;
        this.result = new Result(goalsHomeTeam, goalsAwayTeam);
        this.status = status;
    }

    public String getHomeTeamName() {
        return homeTeamName;
    }

    public String getAwayTeamName() {
        return awayTeamName;
    }

    public Result getResult() {
        return result;
    }

    public String getStatus() {
        return status;
    }
}
