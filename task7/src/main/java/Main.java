import java.lang.reflect.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        ArrayList<healthDetails> passengers = new ArrayList<healthDetails>();
//        an Example health details
        String[] condition1 = {"MS"};
        String[] allergies1 = {};
        passengers.add(new healthDetails(1,"Nada","Home",
                false,false,PCR.TRUE_NEGATIVE,condition1,allergies1));
//        2
        String[] condition2 = {};
        String[] allergies2 = {"painkillers allergy"};
        passengers.add(new healthDetails(2,"Salma","CFC mall",true,false,
                PCR.TRUE_NEGATIVE,condition2,allergies2));
//        3
        passengers.add(new healthDetails(3,"ghada","Macdonalds",false,
                false,PCR.FALSE_POSITIVE,condition2,allergies1));
//        4
        String[] condtions3 = {"Sneezing"};
        String [] allergies3 = {"profine allergy"};
        passengers.add(new healthDetails(4,"Mona","Home",false,false,
                PCR.TRUE_NEGATIVE,condtions3,allergies3));
//        5
        passengers.add(new healthDetails(5,"Kimmi","Sahel",true,true,
                PCR.TRUE_NEGATIVE,condition2,allergies1));
        for(healthDetails hd:passengers){
            runTest(hd);
            System.out.println("=========================================");
        }


    }
    public static void runTest(healthDetails passenger1){
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
