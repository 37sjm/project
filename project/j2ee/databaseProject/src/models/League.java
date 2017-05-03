package models;

import javax.persistence.*;
import java.util.List;

/**
 * Created by mitch on 5/2/2017.
 */
@Entity
public class League {
    private long id;
    private String name;
    private String location;
    
    @ManyToMany
    @JoinTable(name = "league_standing", schema = "MJS73",
                joinColumns = @JoinColumn(name = "leagueid", referencedColumnName = "id", nullable = false),
                inverseJoinColumns = @JoinColumn(name = "teamid", referencedColumnName = "id", nullable = false))
    private List<Team> teams;


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
    @Column(name = "LOCATION")
    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        League league = (League) o;

        if (id != league.id) return false;
        if (name != null ? !name.equals(league.name) : league.name != null) return false;
        if (location != null ? !location.equals(league.location) : league.location != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (location != null ? location.hashCode() : 0);
        return result;
    }
}
