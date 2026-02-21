public class StudentDto {
    private String name;
    private String email;
    private String phone;
    private String program;
    //Getters
    public String getName(){
        return this.name;
    }
    public String getEmail(){
        return this.email;
    }
    public String getPhone(){
        return this.phone;
    }
    public String getProgram(){
        return this.program;
    }
    //Setters
    public void setName(String name){
        this.name = name;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public void setPhone(String phone){
        this.phone = phone;
    }
    public void setProgram(String program){
        this.program = program;
    }
}
