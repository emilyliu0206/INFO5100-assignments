import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Dog extends Pet implements Boardable{
    private String size;
    public int startMonth, startDay, startYear, endMonth, endDay, endYear;
    public String boarding_start_timestamp, boarding_end_timestamp;
    public Dog(String name, String ownerName, String color, String size) {
        super(name, ownerName, color);
        this.size = size;
    }

    public String getSize(){
        return this.size;
    }

    public void setBoardStart(int month, int day, int year) {
        String inputDate = convertIntegerToTimestamp(month, day, year);
        if (validateDate(inputDate)) {
            this.startMonth = month;
            this.startDay = day;
            this.startYear = year;
            this.boarding_start_timestamp = inputDate;
        }
    }

    public void setBoardEnd(int month, int day, int year) {
        String inputDate = convertIntegerToTimestamp(month, day, year);
        if (validateDate(inputDate)){
            this.endMonth = month;
            this.endDay = day;
            this.endYear = year;
            this.boarding_end_timestamp = inputDate;
        }
    }

    @Override
    public boolean boarding(int month, int day, int year) {
        String boardingTimestamp = convertIntegerToTimestamp(month, day, year);
        try{
            if (validateDate(boardingTimestamp)){
                SimpleDateFormat sdf = new SimpleDateFormat("MM/DD/YYYY");
                Date boardingStartDate = sdf.parse(boarding_start_timestamp);
                Date boardingEndDate = sdf.parse(boarding_end_timestamp);
                Date inputBoardingDate = sdf.parse(boardingTimestamp);

                if ((boardingStartDate.before(inputBoardingDate) || boardingStartDate.equals(inputBoardingDate))
                        && (boardingEndDate.after(inputBoardingDate) || boardingEndDate.equals(inputBoardingDate))){
                    return true;
                }
            }
        } catch (ParseException e){
            System.out.println("Invalid input Date");
        }

        return false;
    }

    @Override
    public String toString(){
        return  "DOG: " + "\n" + this.getPetName() + "owened by " + this.getOwnerName() + "\nColor: " + this.getColor() + "\nSex: " + this.getSex()+"\nSize: " + this.getSize();
    }

    private boolean validateDate(String inputDate){
        SimpleDateFormat sdf = new SimpleDateFormat("MM/DD/YYYY");
        try{
            sdf.parse(inputDate);
            return true;
        }catch (ParseException e){
            System.out.println("invalid input date");
        }
        return false;
    }
    private String convertIntegerToTimestamp(int month, int day, int year){
        String inputDate;
        if (day < 10){
            inputDate = month + "-0" + day + "-" + year;
        } else{
            inputDate = month + "-" + day + "-" + year;
        }
        return inputDate;
    }

}
