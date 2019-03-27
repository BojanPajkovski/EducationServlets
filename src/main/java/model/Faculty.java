package model;

/**
 * Created by User on 22.08.2018.
 */
public class Faculty {

    private Long id;

    private String name;

    private String description;

    private String location;

    private int universityId;

    private boolean tecnical;

    public Faculty(boolean tecnical) {

        this.tecnical = tecnical;
    }

    public Faculty() {

    }

    public Faculty( String name, String description, boolean tecnical  ) {
        this.name = name;
        this.description = description;
        this.tecnical = tecnical;
    }

    public Faculty(String name, String description, String location) {
        this.name = name;
        this.description = description;
        this.location = location;
    }

    public Faculty(Long id, String name, String description, String location, boolean tecnical) {
        this.id =id;
        this.name = name;
        this.description = description;
        this.location = location;

        this.tecnical = tecnical;
    }

    public Faculty(String name, String description, String location, int universityId) {

        this.name = name;
        this.description = description;
        this.location = location;
        this.universityId = universityId;

    }

    public Faculty(Long id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public Faculty(Long id, String name, String description, String location, int universityId, boolean tecnical) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.location = location;
        this.universityId = universityId;
        this.tecnical = tecnical;
    }

    public int getUniversityId() {
        return universityId;
    }

    public void setUniversityId(int universityId) {
        this.universityId = universityId;
    }

    public boolean isTecnical() {
        return tecnical;
    }

    public void setTecnical(boolean tecnical) {
        this.tecnical = tecnical;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


}
