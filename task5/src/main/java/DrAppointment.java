import javax.validation.constraints.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.Optional;

public class DrAppointment {
    @NotEmpty
    @Size(min = 10, max = 100, message
            = "Patient name must be between 10 and 100 characters")
    public String patientName;
    @Positive
    @Max(value = 150, message = "Age should not be greater than 150")
    public  int patientAge;
//    253 Sesame Street
//    @NotEmpty
    @Pattern(regexp = "[1-9][0-9]*,\\s(\\w\\s?)+(St.|st.|Street|street)?",
            message = "Address should contain building number and street name")
    public String address;
    @Email(message = "Email should be valid")
    public String patientEmail;
    @NotEmpty
    @Size(min = 10, max = 100, message
            = "Doctor name must be between 10 and 100 characters")
    public String doctorName;
    @FutureOrPresent
    public LocalDate appointmentDate;

    public DrAppointment(){}
//    patient name
//    getter & setter
    public String getPatientName(){
        return this.patientName;
    }
    public  void setPatientName(String name){
        this.patientName = name;
    }
//    ----------------------------------------
//    patient age --> getter and setter
    public int getPatientAge(){
        return this.patientAge;
    }
    public  void setPatientAge(int age){
        this.patientAge = age;
    }
//    ----------------------------------------
//    address ->> getter and setter
    public String getAddress(){
        return  this.address;
    }
    public  void setAddress(String address){
        this.address = address;
    }
//    ----------------------------------------
//    patient email --> getter and setter
    public String getPatientEmail(){
        return this.patientEmail;
    }
    public void setPatientEmail(String email){
        this.patientEmail = email;
    }
//    ----------------------------------------
//    doctor name --> getter and setter
    public String getDoctorName(){
        return this.doctorName;
    }
    public void setDoctorName(String name){
        this.doctorName = name;
    }
//    ----------------------------------------
//    appointment --> getter and setter
    public Optional<@FutureOrPresent LocalDate> getAppointmentDate(){
        return Optional.ofNullable(this.appointmentDate);
    }
    public void setAppointmentDate(LocalDate date){
        this.appointmentDate = date;
    }
//    ------------------------------------------
    public String toString(){
        return "Patient name: "+this.patientName +"\nage: "+this.patientAge+"\nemail: "+this.patientEmail
                +"\nDoctor name: "+this.doctorName+"\nappointment date: "+this.appointmentDate;
    }


}
