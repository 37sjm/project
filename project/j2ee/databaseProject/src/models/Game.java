package models;

import javax.persistence.*;
import java.sql.Time;

/**
 * Created by mitch on 5/2/2017.
 */
@Entity
@IdClass(GamePK.class)
public class Game {
    private long teamOneId;
    private long teamTwoId;
    private Time gameDate;
    private Long teamOneScore;
    private Long teamTwoScore;
    private Long predictedWinner;

    @Id
    @Column(name = "TEAM_ONE_ID")
    public long getTeamOneId() {
        return teamOneId;
    }

    public void setTeamOneId(long teamOneId) {
        this.teamOneId = teamOneId;
    }

    @Id
    @Column(name = "TEAM_TWO_ID")
    public long getTeamTwoId() {
        return teamTwoId;
    }

    public void setTeamTwoId(long teamTwoId) {
        this.teamTwoId = teamTwoId;
    }

    @Id
    @Column(name = "GAME_DATE")
    public Time getGameDate() {
        return gameDate;
    }

    public void setGameDate(Time gameDate) {
        this.gameDate = gameDate;
    }

    @Basic
    @Column(name = "TEAM_ONE_SCORE")
    public Long getTeamOneScore() {
        return teamOneScore;
    }

    public void setTeamOneScore(Long teamOneScore) {
        this.teamOneScore = teamOneScore;
    }

    @Basic
    @Column(name = "TEAM_TWO_SCORE")
    public Long getTeamTwoScore() {
        return teamTwoScore;
    }

    public void setTeamTwoScore(Long teamTwoScore) {
        this.teamTwoScore = teamTwoScore;
    }

    @Basic
    @Column(name = "PREDICTED_WINNER")
    public Long getPredictedWinner() {
        return predictedWinner;
    }

    public void setPredictedWinner(Long predictedWinner) {
        this.predictedWinner = predictedWinner;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Game game = (Game) o;

        if (teamOneId != game.teamOneId) return false;
        if (teamTwoId != game.teamTwoId) return false;
        if (gameDate != null ? !gameDate.equals(game.gameDate) : game.gameDate != null) return false;
        if (teamOneScore != null ? !teamOneScore.equals(game.teamOneScore) : game.teamOneScore != null) return false;
        if (teamTwoScore != null ? !teamTwoScore.equals(game.teamTwoScore) : game.teamTwoScore != null) return false;
        if (predictedWinner != null ? !predictedWinner.equals(game.predictedWinner) : game.predictedWinner != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (teamOneId ^ (teamOneId >>> 32));
        result = 31 * result + (int) (teamTwoId ^ (teamTwoId >>> 32));
        result = 31 * result + (gameDate != null ? gameDate.hashCode() : 0);
        result = 31 * result + (teamOneScore != null ? teamOneScore.hashCode() : 0);
        result = 31 * result + (teamTwoScore != null ? teamTwoScore.hashCode() : 0);
        result = 31 * result + (predictedWinner != null ? predictedWinner.hashCode() : 0);
        return result;
    }
}
