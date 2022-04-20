public class DoctorSimulator {
    public static void main(String[] args){
        Joe joe;
        joe = new Head();
        System.out.println("Welcome Doctor! Here is your patient, Joe, and some of the information about them:" +
                            "\nTemperature: " + joe.getTemp() + " celcius");
    }
}
