public class Letter {
    private String letter;
    private int month = 0;
    private int day = 0;
    private int year = 0;

    public Letter(){
        letter = "empty.";
        parseDate("01/01/2022");
    }

    public Letter(String letter, String date){
        this.letter = letter;
        parseDate(date);
    }

    public void setContent(String letter){
        this.letter = letter;
    }
    public void setMonth(int month){
        this.month = month;
    }

    public void setDay(int day){
        this.day = day;
    }

    public void setYear(int year){
        this.year = year;
    }

    public String getLetter(){
        return letter;
    }

    public int getMonth(){
        return month;
    }

    public int getDay(){
        return day;
    }

    public int getYear(){
        return year;
    }

    public void parseDate(String date){
        /*
        date has to be mm/dd/yyyy format inclusive
        */
        if(date.length() != 10){
            setMonth(1);
            setDay(1);
            setYear(2022);
        }
        int month = Integer.parseInt(date.substring(0,2));
        int day = Integer.parseInt(date.substring(3,5));
        int year = Integer.parseInt(date.substring(6));
        setMonth(month);
        setDay(day);
        setYear(year);
   }
}
