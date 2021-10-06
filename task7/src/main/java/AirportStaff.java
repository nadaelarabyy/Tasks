import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.Arrays;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@interface Staff {
    String userRole() default "GUEST";
}

public class AirportStaff {


    @Staff(userRole = "Post Officer")
    public PassengerDemonstration PostOfficer(healthDetails details){
        String out = details.personName +" reached Post Office\n"+
                "Data Seen:\n"+"PCR Status: "+details.pcrStatus+
                " Special Conditions: "+
                ((details.specialConditions.length>0)? Arrays.toString(details.specialConditions)
                        :"No Special Conditions");
        return new PassengerDemonstration(1,out);


    }
    @Staff(userRole = "Health Officer")
    public PassengerDemonstration HealthOfficer(healthDetails details){
        String out = details.personName+ " reached Health Officer\n"+
                "Data Seen:\n"+ "PCR Status: "+ details.pcrStatus+
                " Special Conditions: "+
                ((details.specialConditions.length>0)? Arrays.toString(details.specialConditions)
                        :"No Special Conditions")+"\nPlace visited in the last 14 days: "+
                details.placeVisited+" has a fever: "+details.hasFever+" has a cough: "+
                details.hasCough+" Medicine Allergies: "+((details.medicineAllergies.length>0)?
                Arrays.toString(details.medicineAllergies):" No medicine allergies");
        return new PassengerDemonstration(2,out);

    }
    @Staff(userRole = "PCR Test Conductor")
    public PassengerDemonstration PCRTestConductor(healthDetails details){
        String out="";

        if(details.hasFever)
    {
        out = details.personName + " reached PCR Test"+
                "Data Seen:\n"+
                " has a fever: " +details.hasFever +
                " has a cough: " + details.hasCough;
    }
        else{
            out = details.personName+"==> There is no need for PCR test";
        }
        return new PassengerDemonstration(3,out);

    }
    @Staff(userRole = "Immigration Officer")
    public PassengerDemonstration ImmigrationOfficer(healthDetails details){
        String out = details.personName+ " reached the immigration Office\n"+
                "Data Seen:\n"+
                "PCR Status: "+ details.pcrStatus+
                " Special Conditions: "+
                ((details.specialConditions.length>0)? Arrays.toString(details.specialConditions)
                        :"No Special Conditions")+" Place visited in the last 14 days: "+
                details.placeVisited;
        return new PassengerDemonstration(4,out);

    }
}
