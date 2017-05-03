package models;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by mitch on 5/2/2017.
 */
public class LeagueStandingPK implements Serializable {
    private long teamid;
    private long leagueid;

    @Column(name = "TEAMID")
    @Id
    public long getTeamid() {
        return teamid;
    }

    public void setTeamid(long teamid) {
        this.teamid = teamid;
    }

    @Column(name = "LEAGUEID")
    @Id
    public long getLeagueid() {
        return leagueid;
    }

    public void setLeagueid(long leagueid) {
        this.leagueid = leagueid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LeagueStandingPK that = (LeagueStandingPK) o;

        if (teamid != that.teamid) return false;
        if (leagueid != that.leagueid) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (teamid ^ (teamid >>> 32));
        result = 31 * result + (int) (leagueid ^ (leagueid >>> 32));
        return result;
    }
}
