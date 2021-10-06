public class PassengerDemonstration{
    public String output;
    public int id;
    public PassengerDemonstration(int id, String output){
        this.id = id;
        this.output = output;
    }
    public int getId(){
        return this.id;
    }

    @Override
    public String toString() {
        return "PassengerDemonstration{" +
                "output='" + output + '\'' +
                ", id=" + id +
                '}';
    }
}