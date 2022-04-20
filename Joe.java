/*
DoctorSimulator: make choices to either save or hurt your patient, Joe. Joe will have a randomized condition at the start of the game.
@author Damian, Andrei
@
*/
public class Joe{
    public int temp;
    private int avgTemp;
    public Joe(){
        avgTemp = temp / 2;
    }

    public int randomTemp(){
        int random = (int)(Math.random() * 29) + 72;
        return random;
    }

    public int getTemp(){
        return avgTemp;
    }

    public void addTemp(int num){
        temp += num;
    }
}



