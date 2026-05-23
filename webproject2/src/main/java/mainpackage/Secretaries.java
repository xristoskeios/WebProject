package mainpackage;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "secretaries")
public class Secretaries extends Users{

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "email" , unique = true , nullable = false)
    private String email;

    @Column(name="phone_number",unique = true,nullable=false)
    private String PhoneNumber;

    List<Students> StudentsList;

    public Secretaries(String UserName, String Name, String Surname, String Department,String email , String PhoneNumber ) {
        super(UserName, Name, Surname, Department);
        this.email  = email;
        this.PhoneNumber = PhoneNumber ;
        this.StudentsList = new ArrayList<>();
    }

//getters
    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    //setters
    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
    }

    //methods


    public void ReceiveMails(String EmailAddr){
        System.out.println(getEmail() +" received a mail from "+ EmailAddr +"/n");
    }
    public void SendMails(String EmailAddr){
        System.out.println(getName()+ " sent a mail to "+EmailAddr+" ."+"/n");
    }

    public void addCourses(Professors professor, Courses course){
        professor.ReceiveCourses(course);
    }

    public Professors CreateProfessor(String username,String name,String surname,String department,String email, String password){

        return new Professors(username,name,surname,department,email,password);

    }

    public Students CreateStudent(String UserName , String Name , String Surname , String Department,int registrationNumber, String password
            , String Email, int StudingYear ,int  Semester){

        StudentsList.add(new Students(UserName , Name ,  Surname ,  Department, registrationNumber,  password,  Email,  StudingYear ,  Semester));
        return new Students(UserName , Name ,  Surname ,  Department, registrationNumber,  password,  Email,  StudingYear ,  Semester);

    }

    public void ViewStudentsList(){
        System.out.println("View student's list : ");
        for(Students students : StudentsList){
            System.out.println(students.getName()+students.getSurName()+"\n");

        }
    }
    public Courses CreateCourses(String Name , boolean RequiredSubject , int PassPercent , String BookName){

        return new Courses( Name ,  RequiredSubject ,  PassPercent ,  BookName);

    }



}
