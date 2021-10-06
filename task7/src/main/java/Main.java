import java.lang.reflect.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
//        an Example health details
        String[] condition1 = {"MS"};
        String[] allergies1 = {};
        healthDetails passenger1 = new healthDetails(1,"Nada","Home",
                false,false,PCR.TRUE_NEGATIVE,condition1,allergies1);
        try {
            Class annotatedClass = AirportStaff.class;
            Method[] methods = annotatedClass.getMethods();
            ArrayList<PassengerDemonstration> demonstrations = new ArrayList<PassengerDemonstration>();
            for(Method method: methods){
                if(method.isAnnotationPresent(Staff.class)){
                    Staff staff = method
                            .getAnnotation(Staff.class);
                    Object demoInst = method.invoke(AirportStaff.class.newInstance(),passenger1);
                    demonstrations.add((PassengerDemonstration) demoInst);
                }
            }
            List<PassengerDemonstration> display = demonstrations.stream()
                    .sorted(Comparator.comparingInt(PassengerDemonstration::getId))
                            .collect(Collectors.toList());
            for(PassengerDemonstration pd:display){
                System.out.println(pd.output);
            }

        }
        catch (Exception e){
            e.printStackTrace();
        }

    }
}
