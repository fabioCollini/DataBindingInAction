package it.droidcon.databinding.data;

public class Result {
    private int goalsHomeTeam;
    private int goalsAwayTeam;

    public Result() {
    }

    public Result(int goalsHomeTeam, int goalsAwayTeam) {
        this.goalsHomeTeam = goalsHomeTeam;
        this.goalsAwayTeam = goalsAwayTeam;
    }

    public int getGoalsHomeTeam() {
        return goalsHomeTeam;
    }

    public int getGoalsAwayTeam() {
        return goalsAwayTeam;
    }
}
