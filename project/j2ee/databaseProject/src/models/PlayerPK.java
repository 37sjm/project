package models;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by mitch on 5/2/2017.
 */
public class PlayerPK implements Serializable {
    private long num;
    private long teamid;

    @Column(name = "NUM")
    @Id
    public long getNum() {
        return num;
    }

    public void setNum(long num) {
        this.num = num;
    }

    @Column(name = "TEAMID")
    @Id
    public long getTeamid() {
        return teamid;
    }

    public void setTeamid(long teamid) {
        this.teamid = teamid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PlayerPK playerPK = (PlayerPK) o;

        if (num != playerPK.num) return false;
        if (teamid != playerPK.teamid) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (num ^ (num >>> 32));
        result = 31 * result + (int) (teamid ^ (teamid >>> 32));
        return result;
    }
}
