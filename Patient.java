import java.util.ArrayList;

/**
 * REPRESENTS A PATIENT WITH SOME VALUES LIKE TEMPERATURE AND BPM
 * @author Damian
 */

public class Patient{
    private ArrayList<Integer> temp = new ArrayList<Integer>(1);
    private ArrayList<Integer> bpm = new ArrayList<Integer>(1);
    private String name;

    /**
     * Construct a patient with a temperature from 34-44 Celcius and bpm from 40-160.
     */
    public Patient(){
        temp.add(randomizer(34, 44));
        bpm.add(randomizer(40, 160));
    }

    /**
     * Return a number between a specified range inclusive
     * @param min minimum number value, must be int
     * @param max maximum number value, must be int
     * @return an int between min and max inclusive
     */
    public int randomizer(int min, int max){
        int num = (int) (Math.random() * (max - min)) + min;
        return num;
    }

    public int getTemp(){
        return temp.get(temp.size() - 1);
    }
    
    /**
     * Add the temperature of the patient by 1-5 Celcius inclusive, when using blanket
     */
    public void addTemp(){
        int prev = temp.get(temp.size() - 1);
        temp.add(prev + randomizer(1, 5));
        bpm.add(bpm.get(bpm.size() -1));
    }

    /**
     * Add the temperature of the patient by the potency of the medicine object
     */
    public void addTempMed(int potency){
        int prev = temp.get(temp.size() - 1);
        temp.add(prev + potency);
        bpm.add(bpm.get(bpm.size() -1));
    }

    /**
     * Decrease the temperature of the patient by 1-5 Celcius inclusive, when using Ice pack
     */
    public void decTemp(){
        int prev = temp.get(temp.size() - 1);
        temp.add(prev - randomizer(1, 5));
        bpm.add(bpm.get(bpm.size() -1));
    }

    public String tempArray(){
        String array = temp.toString();
        return array;
    }

    public ArrayList<Integer> tempGraph(){
        return temp;
    }

    public String bpmArray(){
        String array = bpm.toString();
        return array;
    }

    public int getBpm(){
        return bpm.get(bpm.size() - 1);
    }

    /**
     * Add the bpm of the patient by 10-50 Celcius inclusive, when using defibrillators
     */
    public void addBpm(){
        int prev = bpm.get(bpm.size() - 1);
        bpm.add(prev + randomizer(10, 50));
        temp.add(temp.get(temp.size() -1));
    }
    
    /**
     * Decrease the bpm of the patient by 10-50 Celcius inclusive, when using ice pack
     */
    public void decBpm(){
        int prev = bpm.get(bpm.size() - 1);
        bpm.add(prev - randomizer(10, 50));
        temp.add(temp.get(temp.size() -1));
    }

    /**
     * Add the bpm of the patient by the potency of the medicine object
     */
    public void addBpmMed(int potency){
        int prev = bpm.get(bpm.size() - 1);
        bpm.add(prev + potency);
        temp.add(temp.get(temp.size() -1));
    }

    public ArrayList<Integer> bpmGraph(){
        return bpm;
    }

    public void setName(String n){
        name = n; 
    }

    public String getName(){
        return name;
    }
    /**
     * A checker to specific values for temperature and bpm, return true if it is outside
     * @param minTemp minimum temperature
     * @param maxTemp maximum temperature
     * @param minBpm minimum bpm
     * @param maxBpm maximum bpm
     * @return return true is value is outside the checker range
     */
    public boolean checkCondition(int minTemp, int maxTemp, int minBpm, int maxBpm){
        int currentTemp = temp.get(temp.size() - 1);
        int currentBpm = bpm.get(bpm.size() - 1);
        return (currentTemp < minTemp || currentTemp > maxTemp || currentBpm < minBpm || currentBpm > maxBpm);
    }
    
}