package models;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.sql.Time;

/**
 * Created by mjs73 on 5/3/2017.
 */
public class GameEntityPK implements Serializable {
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

        GameEntityPK that = (GameEntityPK) o;

        if (teamOneId != that.teamOneId) return false;
        if (teamTwoId != that.teamTwoId) return false;
        if (gameDate != null ? !gameDate.equals(that.gameDate) : that.gameDate != null) return false;

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
