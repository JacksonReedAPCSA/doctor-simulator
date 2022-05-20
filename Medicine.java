import java.util.ArrayList;

/**
 * REPRESENTS A MEDICINE THAT IS MADE OUT OF 3 DIFFERENT INGREDIENTS, COMBINING THE EFFECTS
 * @author Andrei
 */

public class Medicine {
    private ArrayList<Ingredient> ingredients = new ArrayList<Ingredient>();
    private int tempPotency;
    private int bpmPotency;
  
    public Medicine(Ingredient ing1, Ingredient ing2, Ingredient ing3) {
        ingredients.add(ing1);
        ingredients.add(ing2);
        ingredients.add(ing3);
    }
    
    public void setPotencies() {
        for(int i = 0; i < ingredients.size(); i++) {
        if(ingredients.get(i).getType() == 0) {
            tempPotency += ingredients.get(i).getPotency();
        }
        else if(ingredients.get(i).getType() == 1) {
            bpmPotency += ingredients.get(i).getPotency();
        }
        }
    }
    
    public int getTempPotency() {
        return tempPotency; 
    }
    
    public int getBpmPotency() {
        return bpmPotency;
    }
    
    public String toString() {
        String medSentence = "A ";
        if(tempPotency > 0) {
        medSentence += "warming ";
        if(bpmPotency > 0) {
            medSentence += "and stimulating ";
        }
        else if(bpmPotency < 0) {
            medSentence += "and soothing ";
        }
        }
        else if(tempPotency < 0) {
        medSentence += "chilling ";
        if(bpmPotency > 0) {
            medSentence += "and stimulating ";
        }
        else if(bpmPotency < 0) {
            medSentence += "and soothing ";
        }
        }
        else {
        if(bpmPotency > 0) {
            medSentence += "and stimulating ";
        }
        else if(bpmPotency < 0) {
            medSentence += "and soothing ";
        }
        }
        medSentence += "medicine is given to the patient.";
        return medSentence;
    }
}
