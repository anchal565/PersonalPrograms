import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class TryDate {
    public static void main(String[] args) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-mm-dd HH:mm:ss.SSS");
        String currentDate = "2020-07-02 05:30:00.0";
        Date newDate = simpleDateFormat.parse(currentDate);
        System.out.println(newDate);
        System.out.println(simpleDateFormat.format(newDate));
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-mm-dd HH:mm:ss.SSS");

        LocalDateTime del_date1 = LocalDateTime.parse(currentDate, formatter);
        System.out.println(del_date1.toString());
    }
}
