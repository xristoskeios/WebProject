package mainpackage;

public class Grades {
  private Courses course;
  private double score;

  public Grades (Courses course , double score){
      this.course = course;
      this.score = score;
  }

  //getters
    public Courses getCourse() {
        return course;
    }
    public double getScore() {
        return score;
    }

   // methods
   public void PrintCourseInfo (){
      System.out.println("Course name : "+course.getName());
      System.out.println("Score :"+getScore()+"\n");
   }
}
