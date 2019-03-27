package model;

/**
 * Created by User on 13.02.2019.
 */
public class Subject {

    private Long id;

    private String name;

    private int credits;

    private String semestar;

    private int fakultet;

    public Subject() {
    }

    public Subject(String name, int credits, String semestar) {
        this.name = name;
        this.credits = credits;
        this.semestar = semestar;
    }

    public Subject(Long id, String name, int credits, String semestar) {
        this.id = id;
        this.name = name;
        this.credits = credits;
        this.semestar = semestar;
    }

    public Subject(Long id, String name, int credits, String semestar, int fakultet) {
        this.id = id;
        this.name = name;
        this.credits = credits;
        this.semestar = semestar;
        this.fakultet = fakultet;
    }

    public Long getId() {return id;}

    public void setId(Long id) {this.id = id;}

    public String getName() {return name;}

    public void setName(String name) {this.name = name;}

    public int getCredits() {return credits;}

    public void setCredits(int credits) {this.credits = credits;}

    public String getSemestar() {return semestar;}

    public void setSemestar(String semestar) {this.semestar = semestar;}

    public int getFakultet() {return fakultet;}

    public void setFakultet(int fakultet) {this.fakultet = fakultet;}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Subject)) return false;

        Subject subject = (Subject) o;

        if (credits != subject.credits) return false;
        if (fakultet != subject.fakultet) return false;
        if (id != null ? !id.equals(subject.id) : subject.id != null) return false;
        if (name != null ? !name.equals(subject.name) : subject.name != null) return false;
        if (semestar != null ? !semestar.equals(subject.semestar) : subject.semestar != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + credits;
        result = 31 * result + (semestar != null ? semestar.hashCode() : 0);
        result = 31 * result + fakultet;
        return result;
    }
}


