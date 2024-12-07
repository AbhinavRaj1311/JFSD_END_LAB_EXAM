package hibernate_xml;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "students")
public class Student {
    @Id
    @Column(name = "regdno")
    int regdno;

    @Column(name = "name")
    String name;

    @Column(name = "cgpa")
    int cgpa;

    public int getRegdno() {
        return regdno;
    }

    public void setRegdno(int regdno) {
        this.regdno = regdno;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCgpa() {
        return cgpa;
    }

    public void setCgpa(int cgpa) {
        this.cgpa = cgpa;
    }
}