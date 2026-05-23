package mainpackage;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jakarta.persistence.*;


@Entity
@Table(name = "professors")
public class Professors extends Users {

    @Column(name = "email" , unique = true , nullable = false)
    private String email;
    private List<Courses> TeachingCourses ;
    List<Students> StudentsForCourse;
   List<StudentCourseGrade> GradesOfStudents;



    @Column(name = "password", nullable = false)
    private String password;

    public Professors(String username,String name,String surname,String department,String email, String password){
        super(username,name,surname,department);
        this.email = email;
       this.TeachingCourses = new ArrayList<>();
        this.password = password;
        this.StudentsForCourse = new ArrayList<>();
        this.GradesOfStudents = new ArrayList<>();

    }

    //getters
    public String getEmail(){
        return email;
    }

    public List<Courses> getTeachingSubject(){
        return TeachingCourses;
    }




    //setters

    public void setEmail(String email){
        this.email = email;
    }

    public void setTeachingCourses(List<Courses> teachingCourses) {
        TeachingCourses = teachingCourses;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    //methods

    public void Login (String username, String password){
        if(this.getUserName().equals(username) && this.password.equals(password)){
        System.out.println("Welcome , Professor "+getName()+" "+getSurName()+" 👨‍🏫 \n" );
        } else{System.out.println("Unsuccessful login, try again ..."+"\n");}
    }




     public void addGrade(Students student, Courses course, double score) {

         if (TeachingCourses.contains(course)) {

             student.ReceiveGrade(course, score);
             GradesOfStudents.add(new StudentCourseGrade(student, new Grades(course, score)));

             if (!StudentsForCourse.contains(student)) {
                        StudentsForCourse.add(student);
             }
         }else {System.out.println("Professor "+getName()+" "+getSurName()+" doesn't teach "+ course.getName());}
    }
    public void ReceiveMails(String Email){
        System.out.println(getEmail() +" received a mail from "+ Email +"\n");
    }

    public void ReceiveCourses(Courses course){
        TeachingCourses.add(course);
    }

    public void ViewAllCourses(){
       System.out.println("Professor "+getName()+" "+getSurName()+ " teaches the courses : ");
        for(Courses course : TeachingCourses){
            System.out.println(course.getName());
        }
        System.out.println();
    }

    public void ViewAllStudents(){
        System.out.println();
        System.out.println("Professor's "+getName()+" "+getSurName()+" list of student that have taken a course of his : ");
        for(Students students : StudentsForCourse){System.out.println(students.getName());}
        System.out.println();
    }

    public void ViewProfil(){
        System.out.println("View Professor "+ getName()+" "+getSurName() +" Profil : \n Username : "+getUserName()+", Name : "+getName()+", Surname : "+getSurName()+", Department : "+getDepartment()+"\n");
    }

    public void ViewGradesOfAllStudentsForTeachingCourses(){
        System.out.println();
        System.out.println("List of Students and Grades for professor's  "+getName()+" "+getSurName()+" courses :");

        for (StudentCourseGrade studentCourseGrade : GradesOfStudents) {

            System.out.println("Student : "+studentCourseGrade.getStudent().getName()+" "+studentCourseGrade.getStudent().getSurName()+
                    " , Course : " + studentCourseGrade.getGrade().getCourse().getName() + " , Score : " + studentCourseGrade.getGrade().getScore());
        }

    }


    public void Logout(){
        System.out.println(" You logged out ... \n");
    }


}
