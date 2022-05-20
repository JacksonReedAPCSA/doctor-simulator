/**
 * REPRESENTS AN INGREDIENT THAT CAN BE SET TO HAVE CERTAIN VALUES, CAN BE MIXED INTO A MEDICINE
 * @author Andrei
 */
public class Ingredient {
    public static int temp = 0;
    public static int bpm = 1;
    private int potency;
    private int type;
    private int id;

    public Ingredient(int n, int p, int t) {
        id = n;
        potency = p;
        type = t;
    }

    public int getPotency() {
        return potency;
    }

    public int getType() {
        return type;
    }

    public int getID(){
        return id;
    }

    public String toString(){
        if(id == 1){
            return "mint";
        }
        if(id == 2){
            return "chilli";
        }
        if(id == 3){
            return "coffee";
        }
        if(id == 4){
            return "chocolate";
        }
        return null;
    }
}
