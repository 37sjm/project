package models;

import javax.persistence.*;

/**
 * Created by mitch on 5/2/2017.
 */
@Entity
@Table(name = "LEAGUE_STANDING", schema = "MJS73", catalog = "")
@IdClass(LeagueStandingPK.class)
public class LeagueStanding {
    private long teamid;
    private long leagueid;
    private Long standing;
    private League leagueByLeagueid;

    @Id
    @Column(name = "TEAMID")
    public long getTeamid() {
        return teamid;
    }

    public void setTeamid(long teamid) {
        this.teamid = teamid;
    }

    @Id
    @Column(name = "LEAGUEID")
    public long getLeagueid() {
        return leagueid;
    }

    public void setLeagueid(long leagueid) {
        this.leagueid = leagueid;
    }

    @Basic
    @Column(name = "STANDING")
    public Long getStanding() {
        return standing;
    }

    public void setStanding(Long standing) {
        this.standing = standing;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LeagueStanding that = (LeagueStanding) o;

        if (teamid != that.teamid) return false;
        if (leagueid != that.leagueid) return false;
        if (standing != null ? !standing.equals(that.standing) : that.standing != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (teamid ^ (teamid >>> 32));
        result = 31 * result + (int) (leagueid ^ (leagueid >>> 32));
        result = 31 * result + (standing != null ? standing.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "LEAGUEID", referencedColumnName = "ID", nullable = false)
    public League getLeagueByLeagueid() {
        return leagueByLeagueid;
    }

    public void setLeagueByLeagueid(League leagueByLeagueid) {
        this.leagueByLeagueid = leagueByLeagueid;
    }
}
