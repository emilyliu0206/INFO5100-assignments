package Assignment8.StudentInformationSystemInterface.model;

public class StudentModel {
    private String ID;
    private String name;
    private String gender;

    public StudentModel(String id, String name, String gender){
        this.ID = id;
        this.name = name;
        this.gender = gender;
    }

    public String getID(){
        return this.ID;
    }

    public void setID(String id){
        this.ID = id;
    }

    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getGender(){
        return this.gender;
    }

    public void setGender(String gender){
        this.gender = gender;
    }
}
