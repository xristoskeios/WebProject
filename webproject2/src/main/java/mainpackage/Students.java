package mainpackage;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "students")
public class Students extends Users{

    @Column(name = "registration_number", unique=true, nullable = false)
    private final int registrationNumber;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "email", unique = true)
    private String Email;

    @Column(name = "study_year")
    private int StudingYear;

    @Column(name = "semester")
    private int Semester;

    private List<Grades> ListOfGrades ;

    public Students() {}

    public Students (String UserName , String Name , String Surname , String Department,int registrationNumber, String password, String Email, int StudingYear ,int  Semester){
        super(UserName,Name,Surname,Department);

        if(!Email.toLowerCase().endsWith("@gmail.com")){
            throw new IllegalArgumentException("Email must end with @gmail.com");
        }

        if(StudingYear<1 || StudingYear>4){
            throw new IllegalArgumentException("Year of study must be 1-4");
        }

        if(Semester != StudingYear*2 -1 && Semester != StudingYear*2){
            throw new IllegalArgumentException("Semester of "+ StudingYear +" should be "+(StudingYear*2 - 1) +" or "+StudingYear*2);
        }

        this.registrationNumber = registrationNumber;
        this.password = password;
        this.Email = Email;
        this.ListOfGrades = new ArrayList<>();
        this.StudingYear = StudingYear;
        this.Semester = Semester;
    }




    //getter
    public int getRegistrationNumber() {
        return registrationNumber;
    }

    public String getEmail() {
        return Email;
    }

    public int getStudingYear() {
        return StudingYear;
    }

    public int getSemester() {
        return Semester;
    }

    public List<Grades> getListOfGrades() {
        return ListOfGrades;
    }

    //setters
    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        Email = email;
    }

    //Methods
    public void Login (int registNumber , String password){
        if(registNumber == registrationNumber && this.password.equals(password)){
            System.out.println("Welcome, "+ getUserName()+" 👨‍🎓"+"\n");
        }
        else{System.out.println("Unsuccessful login, try again ..."+"\n");}
    }

    public void ViewProfil(){
        System.out.println("View "+ getName()+" "+getSurName() +" Profil : \n Username : "+getUserName()+", Name : "+getName()+
                ", Surname : "+getSurName()+", Department : "+getDepartment()+", Year Of Study : "+getStudingYear()+", Semester : "+getSemester()+"\n");
    }


   public void ReceiveGrade(Courses course, double score){
        boolean existence = false;
        for(Grades grades : ListOfGrades){
            if(grades.getCourse().equals(course)){
                existence = true;
                break;
            }
        }

       if(!existence){
           ListOfGrades.add(new Grades(course,score));
       }
   }
    public void ViewAllGrades(){
        System.out.println("View "+getName()+" "+getSurName()+ " grades for every course : \n");
        for(Grades grade : ListOfGrades){
           grade.PrintCourseInfo();
        }
    }


    public void getAverage(){
        double sum = 0.0 ;

        for(Grades grade : ListOfGrades){

            sum = sum + grade.getScore();
        }

        System.out.println("Average Grade for Student "+getUserName()+" is : "+(float) sum /ListOfGrades.size()+"\n");
    }

    //Send Mails
    public void SendMailToSecretary(Secretaries secretary){
        System.out.println(getEmail()+", you send an email to  "+ secretary.getEmail()+ " succesfully"+"\n");

    }
    public void SendMailToProfessor(Professors professor){
        System.out.println(getEmail()+", you send an email to  "+ professor.getEmail()+ " succesfully"+"\n");

    }

    //Receive Mails
    public void ReceiveMailFromSecretary(Secretaries secretary){
        System.out.println(secretary.getEmail()+" , send you an email ."+"\n");
    }

    public void ReceiveMailFromProfessor(Professors professor){
        System.out.println(professor.getEmail()+" , send you an email"+"\n");
    }

    public void Logout(){
        System.out.println(" You logged out ..."+"\n");
    }
}
