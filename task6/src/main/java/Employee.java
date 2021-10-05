public class Employee {
    private String title;
    private String name;
    private String mobile;
    public Employee(String title,String name,String mobile){
        this.title = title;
        this.name = name;
        this.mobile = mobile;
    }
    public String getTitle(){
        return this.title;
    }
    public String getName(){
        return this.name;
    }
    public String getMobile(){
        return this.mobile;
    }
    public void setTitle(){
        this.title = title;
    }
    public void setName(){
        this.name = name;
    }
    public void setMobile(){
        this.mobile = mobile;
    }
    public String toString(){
        return "Name "+this.name+" - "+"mobile "+this.mobile;
    }
}
