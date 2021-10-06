enum PCR{
    TRUE_POSITIVE,
    TRUE_NEGATIVE,
    FALSE_POSITIVE,
    FALSE_NEGATIVE
}
public class healthDetails {
    public int id;
    public String personName;
//    place visited in the past 14 days
    public String placeVisited;
    public boolean hasFever;
    public boolean hasCough;
    public PCR pcrStatus;

//    in case a person has disability
    public String[] specialConditions;
    public String[] medicineAllergies;

    public healthDetails(int id, String personName, String placeVisited,
                         boolean hasFever, boolean hasCough, PCR pcrStatus,
                         String[] specialConditions, String[] medicineAllergies){
        this.id = id;
        this.personName = personName;
        this.placeVisited = placeVisited;
        this.hasFever = hasFever;
        this.hasCough = hasCough;
        this.pcrStatus = pcrStatus;
        this.specialConditions = specialConditions;
        this.medicineAllergies = medicineAllergies;
    }
}
