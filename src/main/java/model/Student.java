package model;

/**
 * Created by User on 29.08.2018.
 */
public class Student {

    private Long id;

    private String name;

    private String surname;

    private int age;

    private String faculty;

    public Student() {
    }

    public Student(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public Student(Long id, String name, String surname, int age, String faculty) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.faculty = faculty;
    }

    public Student(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;

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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;

        Student student = (Student) o;

        if (age != student.age) return false;
        if (faculty != null ? !faculty.equals(student.faculty) : student.faculty != null) return false;
        if (id != null ? !id.equals(student.id) : student.id != null) return false;
        if (name != null ? !name.equals(student.name) : student.name != null) return false;
        if (surname != null ? !surname.equals(student.surname) : student.surname != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (surname != null ? surname.hashCode() : 0);
        result = 31 * result + age;
        result = 31 * result + (faculty != null ? faculty.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                ", faculty='" + faculty + '\'' +
                '}';
    }
}
