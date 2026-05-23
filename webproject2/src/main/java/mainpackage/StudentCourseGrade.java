package mainpackage;

public class StudentCourseGrade {

    private Students student;
    private Grades grade;

    public StudentCourseGrade(Students student, Grades grade){
        this.student = student;
        this.grade = grade;
    }


    //grades
    public Students getStudent() {
        return student;
    }

    public Grades getGrade() {
        return grade;
    }
}
