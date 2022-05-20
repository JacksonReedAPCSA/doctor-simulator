/**
 * REPRESENTS THE DIFFICULTY OF THE GAME, CAN BE MODIFIED
 * @author Damian
 */
public class Events{
    private int difficulty;
    private boolean isEvent;

    public Events(int d){
        difficulty = d;
    }

    /**
     * Setting isEvent to true in a random chance, 1/8 on difficulty 0 and 1/4 on difficulty 1
     */
    public void triggerCondition(){
        if(difficulty == 0){
            boolean[] wheel = {false, false, false, true, false, false, false, false};
            isEvent =  wheel[randomizer(0, 7)];
        }
        if(difficulty == 1){
            boolean[] wheel = {false, true, false, false};
            isEvent = wheel[randomizer(0,3)];
        }  
    }

    public int randomizer(int min, int max){
        int num = (int) (Math.random() * (max - min)) + min;
        return num;
    }

    public boolean getEvent(){
        return isEvent;
    }
}
