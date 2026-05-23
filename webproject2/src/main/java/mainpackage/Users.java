package mainpackage;

import jakarta.persistence.*;

@Entity
@Table(name= "users")
@Inheritance(strategy = InheritanceType.JOINED)
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;

    private String UserName;
    private String Name;
    private String Surname;
    private String Department;

    @Transient
    private static int UsersCounter = 0;

    public Users() {
    }


    public Users(String UserName, String Name, String Surname, String Department)
    {
        this.UserName = UserName ;
        this.Name = Name ;
        this.Surname = Surname ;
        this.Department = Department ;
        UsersCounter++;

    }

    //getters
     public String getUserName (){
        return UserName;
     }

    public String getName() {
        return Name;
    }

    public String getSurName () {
        return Surname;
    }

    public String getDepartment () {
        return Department;
    }

    public static int getUsersCounter() {
        return UsersCounter;
    }

    //setters

    public void setUserName (String username ){
        UserName = username;
    }

    public void setName(String name) {
        Name = name;
    }

    public  void setSurname (String surname) {
        Surname = surname;
    }

    public void setDepartment(String department) {
        Department = department;
    }
}
