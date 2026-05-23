package mainpackage;

import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.*;

@Entity
@Table(name = "courses")
public class Courses {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", unique = true , nullable = false)
    private String Name;

    @Column(name =" required_subject")
    private boolean RequiredSubject;

    @Column(name = "pass_percent")
    private int PassPercent;

    @Column(name = "book_name",unique = true,nullable = false)
    private String BookName;

    @ManyToOne
    @JoinColumn(name = "professor_id")
    private Professors professor;

    public Courses() {}

   public Courses(String Name , boolean RequiredSubject , int PassPercent , String BookName){
       this.Name = Name;

       this.RequiredSubject = RequiredSubject;
       this.PassPercent = PassPercent;
       this.BookName = BookName;

   }

    //getters
    public String getName(){
        return Name;
    }

    public boolean isRequiredSubject() {
        return RequiredSubject;
    }

    public int getPassPercent() {
        return PassPercent;
    }

    public String getBookName() {
        return BookName;
    }

    public Professors getProfessor() { return professor; }

    //setters

    public void setName(String name) {
        Name = name;
    }



    public void setRequiredSubject(boolean requiredSubject) {
        RequiredSubject = requiredSubject;
    }

    public void setPassPercent(int passPercent) {
        PassPercent = passPercent;
    }

    public void setBookName(String bookName) {
       BookName = bookName;
    }

    public void setProfessor(Professors professor) { this.professor = professor; }


}
