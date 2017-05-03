package models;

import javax.persistence.*;

/**
 * Created by mitch on 5/2/2017.
 */
@Entity
public class Team {
    private long id;
    private String name;
    private Long wins;
    private Long losses;
    private Long ties;

    //ManyToOne relationship implemented in the player class

    //ManyToMany
    @ManyToMany
    @JoinTable(name = "Tournament", schema = "MJS73",
                joinColumns = @JoinColumn(name = ""))

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

        Team team = (Team) o;

        if (id != team.id) return false;
        if (name != null ? !name.equals(team.name) : team.name != null) return false;
        if (wins != null ? !wins.equals(team.wins) : team.wins != null) return false;
        if (losses != null ? !losses.equals(team.losses) : team.losses != null) return false;
        if (ties != null ? !ties.equals(team.ties) : team.ties != null) return false;

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
