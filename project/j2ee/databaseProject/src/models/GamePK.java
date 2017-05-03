package models;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.sql.Time;

/**
 * Created by mitch on 5/2/2017.
 */
public class GamePK implements Serializable {
    private long teamOneId;
    private long teamTwoId;
    private Time gameDate;

    @Column(name = "TEAM_ONE_ID")
    @Id
    public long getTeamOneId() {
        return teamOneId;
    }

    public void setTeamOneId(long teamOneId) {
        this.teamOneId = teamOneId;
    }

    @Column(name = "TEAM_TWO_ID")
    @Id
    public long getTeamTwoId() {
        return teamTwoId;
    }

    public void setTeamTwoId(long teamTwoId) {
        this.teamTwoId = teamTwoId;
    }

    @Column(name = "GAME_DATE")
    @Id
    public Time getGameDate() {
        return gameDate;
    }

    public void setGameDate(Time gameDate) {
        this.gameDate = gameDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GamePK gamePK = (GamePK) o;

        if (teamOneId != gamePK.teamOneId) return false;
        if (teamTwoId != gamePK.teamTwoId) return false;
        if (gameDate != null ? !gameDate.equals(gamePK.gameDate) : gamePK.gameDate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (teamOneId ^ (teamOneId >>> 32));
        result = 31 * result + (int) (teamTwoId ^ (teamTwoId >>> 32));
        result = 31 * result + (gameDate != null ? gameDate.hashCode() : 0);
        return result;
    }
}
