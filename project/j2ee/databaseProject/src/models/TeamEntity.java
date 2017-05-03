package models;

import javax.persistence.*;

/**
 * Created by mjs73 on 5/3/2017.
 */
@Entity
@Table(name = "TEAM", schema = "MJS73", catalog = "")
public class TeamEntity {
    private long id;
    private String name;
    private Long wins;
    private Long losses;
    private Long ties;

    @Id
    @Column(name = "ID")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "NAME")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "WINS")
    public Long getWins() {
        return wins;
    }

    public void setWins(Long wins) {
        this.wins = wins;
    }

    @Basic
    @Column(name = "LOSSES")
    public Long getLosses() {
        return losses;
    }

    public void setLosses(Long losses) {
        this.losses = losses;
    }

    @Basic
    @Column(name = "TIES")
    public Long getTies() {
        return ties;
    }

    public void setTies(Long ties) {
        this.ties = ties;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TeamEntity that = (TeamEntity) o;

        if (id != that.id) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (wins != null ? !wins.equals(that.wins) : that.wins != null) return false;
        if (losses != null ? !losses.equals(that.losses) : that.losses != null) return false;
        if (ties != null ? !ties.equals(that.ties) : that.ties != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (wins != null ? wins.hashCode() : 0);
        result = 31 * result + (losses != null ? losses.hashCode() : 0);
        result = 31 * result + (ties != null ? ties.hashCode() : 0);
        return result;
    }
}
