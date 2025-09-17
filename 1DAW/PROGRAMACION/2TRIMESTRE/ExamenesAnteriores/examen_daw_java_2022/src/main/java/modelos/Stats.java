package modelos;

import java.util.Objects;

public class Stats {

    private int id;
    private Integer ps;
    private Integer at;
    private Integer df;
    private Integer spa;
    private Integer spdf;
    private Integer spd;

    public Stats() {
    }

    public Stats(int id, Integer ps, Integer at, Integer df, Integer spa, Integer spdf, Integer spd) {
        this.id = id;
        this.ps = ps;
        this.at = at;
        this.df = df;
        this.spa = spa;
        this.spdf = spdf;
        this.spd = spd;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getPs() {
        return ps;
    }

    public void setPs(Integer ps) {
        this.ps = ps;
    }

    public Integer getAt() {
        return at;
    }

    public void setAt(Integer at) {
        this.at = at;
    }

    public Integer getDf() {
        return df;
    }

    public void setDf(Integer df) {
        this.df = df;
    }

    public Integer getSpa() {
        return spa;
    }

    public void setSpa(Integer spa) {
        this.spa = spa;
    }

    public Integer getSpdf() {
        return spdf;
    }

    public void setSpdf(Integer spdf) {
        this.spdf = spdf;
    }

    public Integer getSpd() {
        return spd;
    }

    public void setSpd(Integer spd) {
        this.spd = spd;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Stats stats = (Stats) o;
        return id == stats.id && Objects.equals(ps, stats.ps) && Objects.equals(at, stats.at) && Objects.equals(df, stats.df) && Objects.equals(spa, stats.spa) && Objects.equals(spdf, stats.spdf) && Objects.equals(spd, stats.spd);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, ps, at, df, spa, spdf, spd);
    }

    @Override
    public String toString() {
        return "Stats{" +
                "id=" + id +
                ", ps=" + ps +
                ", at=" + at +
                ", df=" + df +
                ", spa=" + spa +
                ", spdf=" + spdf +
                ", spd=" + spd +
                '}';
    }
}
