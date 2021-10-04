import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.time.LocalDate;
import java.util.Set;
public class Main {

    public static void printMessage(Validator validator, DrAppointment drApp){
        Set<ConstraintViolation<DrAppointment>> violations = validator.validate(drApp);
        for (ConstraintViolation<DrAppointment> violation : violations) {
            System.out.println("Error Message: "+violation.getMessage());
        }
    }
    public static void testPatientName(Validator validator){
//        True Values
        DrAppointment drApp = new DrAppointment();
        drApp.setPatientAge(23);
        drApp.setPatientName("nada elaraby");
        drApp.setPatientEmail("nelaraby@sumerge.com");
        drApp.setDoctorName("Dina elezaby");
        drApp.setAddress("12, othman ibn affan");
        drApp.setAppointmentDate(LocalDate.now());
        System.out.println("================Testing patient name===========");
        System.out.println("Data Entered: ");
        System.out.println(drApp.toString());
        printMessage(validator,drApp);
//        -----------------------------------------------------
//        false Value
        drApp = new DrAppointment();
        drApp.setPatientAge(23);
        drApp.setPatientName("nada");
        drApp.setPatientEmail("nelaraby@sumerge.com");
        drApp.setDoctorName("Dina elezaby");
        drApp.setAddress("12, othman ibn affan");
        drApp.setAppointmentDate(LocalDate.now());
        System.out.println("================Testing patient name===========");
        System.out.println("Data Entered: ");
        System.out.println(drApp.toString());
        printMessage(validator,drApp);

//        ----------------------------------------------------
    }
    public static void testPatientAge(Validator validator){
//     true value
        DrAppointment drApp = new DrAppointment();
        drApp.setPatientAge(23);
        drApp.setPatientName("nada elaraby");
        drApp.setPatientEmail("nelaraby@sumerge.com");
        drApp.setDoctorName("Dina elezaby");
        drApp.setAddress("12, othman ibn affan");
        drApp.setAppointmentDate(LocalDate.now());
        System.out.println("==============Testing patient age=======================");

        System.out.println("Data entered: ");
        System.out.println(drApp.toString());
        printMessage(validator,drApp);
        System.out.println("==============Testing patient age=======================");
//        false value
        drApp = new DrAppointment();
        drApp.setPatientAge(160);
        drApp.setPatientName("nada elaraby");
        drApp.setPatientEmail("nelaraby@sumerge.com");
        drApp.setDoctorName("Dina elezaby");
        drApp.setAddress("12, othman ibn affan");
        drApp.setAppointmentDate(LocalDate.now());
        System.out.println("Data Entered: ");
        System.out.println(drApp.toString());
        printMessage(validator,drApp);
    }
    public static void testPatientEmail(Validator validator){

        DrAppointment drApp = new DrAppointment();
        drApp.setPatientAge(23);
        drApp.setPatientName("nada elaraby");
        drApp.setPatientEmail("nelaraby@sumerge.com");
        drApp.setDoctorName("Dina elezaby");
        drApp.setAddress("12, othman ibn affan");
        drApp.setAppointmentDate(LocalDate.now());
        System.out.println("================Testing patient email===========");

        System.out.println("Data Entered: ");
        System.out.println(drApp.toString());
        printMessage(validator,drApp);
//        ----------------------------------------------------
        drApp = new DrAppointment();
        drApp.setPatientAge(23);
        drApp.setPatientName("nada elaraby");
        drApp.setPatientEmail("nelaraby.sumerge.com");
        drApp.setDoctorName("Dina elezaby");
        drApp.setAddress("12, othman ibn affan");
        drApp.setAppointmentDate(LocalDate.now());
        System.out.println("================Testing patient email===========");

        System.out.println("Data Entered: ");
        System.out.println(drApp.toString());
        printMessage(validator,drApp);
    }
    public static void testDoctorName(Validator validator){

        DrAppointment drApp = new DrAppointment();
        drApp.setPatientAge(23);
        drApp.setPatientName("nada elaraby");
        drApp.setPatientEmail("nelaraby@sumerge.com");
        drApp.setDoctorName("Dina elezaby");
        drApp.setAddress("12, othman ibn affan");
        drApp.setAppointmentDate(LocalDate.now());
        System.out.println("================Testing doctor name===========");

        System.out.println("Data entered: ");
        System.out.println(drApp.toString());
        printMessage(validator,drApp);
//        --------------------------------------------------
        drApp = new DrAppointment();
        drApp.setPatientAge(23);
        drApp.setPatientName("nada elaraby");
        drApp.setPatientEmail("nelaraby@sumerge.com");
        drApp.setDoctorName("Dina");
        drApp.setAddress("12, othman ibn affan");
        drApp.setAppointmentDate(LocalDate.now());
        System.out.println("================Testing doctor name===========");

        System.out.println("Data entered: ");
        System.out.println(drApp.toString());
        printMessage(validator,drApp);
    }
    public static void testAddress(Validator validator){

        DrAppointment drApp = new DrAppointment();
        drApp.setPatientAge(23);
        drApp.setPatientName("nada elaraby");
        drApp.setPatientEmail("nelaraby@sumerge.com");
        drApp.setDoctorName("Dina elezaby");
        drApp.setAddress("12, othman ibn affan");
        drApp.setAppointmentDate(LocalDate.now());
        System.out.println("================Testing address===========");

        System.out.println("Data entered: ");
        System.out.println(drApp.toString());
        printMessage(validator,drApp);
//        ------------------------------------------------------
        drApp = new DrAppointment();
        drApp.setPatientAge(23);
        drApp.setPatientName("nada elaraby");
        drApp.setPatientEmail("nelaraby@sumerge.com");
        drApp.setDoctorName("Dina elezaby");
        drApp.setAddress("othman ibn affan");
        drApp.setAppointmentDate(LocalDate.now());
        System.out.println("================Testing address===========");

        System.out.println("Data Entered: ");
        System.out.println(drApp.toString());
        printMessage(validator,drApp);

    }
    public static void testAppointmentDate(Validator validator){

        DrAppointment drApp = new DrAppointment();
        drApp.setPatientAge(23);
        drApp.setPatientName("nada elaraby");
        drApp.setPatientEmail("nelaraby@sumerge.com");
        drApp.setDoctorName("Dina elezaby");
        drApp.setAddress("12, othman ibn affan");
        drApp.setAppointmentDate(LocalDate.now());
        System.out.println("================Testing appointment date===========");

        System.out.println("Data entered: ");
        System.out.println(drApp.toString());
        printMessage(validator,drApp);
//        -----------------------------------------------------
        drApp = new DrAppointment();
        drApp.setPatientAge(23);
        drApp.setPatientName("nada elaraby");
        drApp.setPatientEmail("nelaraby@sumerge.com");
        drApp.setDoctorName("Dina elezaby");
        drApp.setAddress("12, othman ibn affan");
        LocalDate today = LocalDate.now();
        LocalDate yesterday = today.minusDays(1);
        drApp.setAppointmentDate(yesterday);
        System.out.println("================Testing appointment date===========");
        System.out.println("Data Entered: ");
        System.out.println(drApp.toString());
        printMessage(validator,drApp);
    }


    public static void main(String[] args) {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        testAddress(validator);
        testAppointmentDate(validator);
        testDoctorName(validator);
        testPatientName(validator);
        testPatientAge(validator);
        testPatientEmail(validator);




    }
}
