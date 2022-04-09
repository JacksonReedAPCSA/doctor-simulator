import java.util.ArrayList;

public class Storage {
    private ArrayList<String> storage;
    private Letter ltr;

    public Storage(){
        storage = new ArrayList<String>();
    }

    public void addLetter(String letter, String date){
        ltr = new Letter(letter, date);
        String bruh = ltr.getLetter();
        storage.add(bruh);
    }

    public void addLetter(String letter){
        storage.add(letter);
    }

    public String getLetter(int num){
        return storage.get(num - 1);
    }

    public void delLetter(int num){
        storage.remove(num - 1);
    }
}
