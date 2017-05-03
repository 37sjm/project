package models;

import javax.persistence.*;

/**
 * Created by mjs73 on 5/3/2017.
 */
@Entity
@Table(name = "PLAYER", schema = "MJS73", catalog = "")
@IdClass(PlayerEntityPK.class)
public class PlayerEntity {
    private String name;
    private String pos;
    private long num;
    private long age;
    private Long gs;
    private Long sub;
    private Long goals;
    private Long shots;
    private Long assists;
    private Long fs;
    private Long fc;
    private long teamid;

    @Basic
    @Column(name = "NAME")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "POS")
    public String getPos() {
        return pos;
    }

    public void setPos(String pos) {
        this.pos = pos;
    }

    @Id
    @Column(name = "NUM")
    public long getNum() {
        return num;
    }

    public void setNum(long num) {
        this.num = num;
    }

    @Basic
    @Column(name = "AGE")
    public long getAge() {
        return age;
    }

    public void setAge(long age) {
        this.age = age;
    }

    @Basic
    @Column(name = "GS")
    public Long getGs() {
        return gs;
    }

    public void setGs(Long gs) {
        this.gs = gs;
    }

    @Basic
    @Column(name = "SUB")
    public Long getSub() {
        return sub;
    }

    public void setSub(Long sub) {
        this.sub = sub;
    }

    @Basic
    @Column(name = "GOALS")
    public Long getGoals() {
        return goals;
    }

    public void setGoals(Long goals) {
        this.goals = goals;
    }

    @Basic
    @Column(name = "SHOTS")
    public Long getShots() {
        return shots;
    }

    public void setShots(Long shots) {
        this.shots = shots;
    }

    @Basic
    @Column(name = "ASSISTS")
    public Long getAssists() {
        return assists;
    }

    public void setAssists(Long assists) {
        this.assists = assists;
    }

    @Basic
    @Column(name = "FS")
    public Long getFs() {
        return fs;
    }

    public void setFs(Long fs) {
        this.fs = fs;
    }

    @Basic
    @Column(name = "FC")
    public Long getFc() {
        return fc;
    }

    public void setFc(Long fc) {
        this.fc = fc;
    }

    @Id
    @Column(name = "TEAMID")
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

        PlayerEntity that = (PlayerEntity) o;

        if (num != that.num) return false;
        if (age != that.age) return false;
        if (teamid != that.teamid) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (pos != null ? !pos.equals(that.pos) : that.pos != null) return false;
        if (gs != null ? !gs.equals(that.gs) : that.gs != null) return false;
        if (sub != null ? !sub.equals(that.sub) : that.sub != null) return false;
        if (goals != null ? !goals.equals(that.goals) : that.goals != null) return false;
        if (shots != null ? !shots.equals(that.shots) : that.shots != null) return false;
        if (assists != null ? !assists.equals(that.assists) : that.assists != null) return false;
        if (fs != null ? !fs.equals(that.fs) : that.fs != null) return false;
        if (fc != null ? !fc.equals(that.fc) : that.fc != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (pos != null ? pos.hashCode() : 0);
        result = 31 * result + (int) (num ^ (num >>> 32));
        result = 31 * result + (int) (age ^ (age >>> 32));
        result = 31 * result + (gs != null ? gs.hashCode() : 0);
        result = 31 * result + (sub != null ? sub.hashCode() : 0);
        result = 31 * result + (goals != null ? goals.hashCode() : 0);
        result = 31 * result + (shots != null ? shots.hashCode() : 0);
        result = 31 * result + (assists != null ? assists.hashCode() : 0);
        result = 31 * result + (fs != null ? fs.hashCode() : 0);
        result = 31 * result + (fc != null ? fc.hashCode() : 0);
        result = 31 * result + (int) (teamid ^ (teamid >>> 32));
        return result;
    }
}
