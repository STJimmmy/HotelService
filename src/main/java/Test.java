import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Test{
    public static void main(String[] args) {

        String input = "19.03.1985";
        String input2 = "6.03.1985";


        String regex = "^(?:(?:31(\\.)(?:0?[13578]|1[02]))\\1|(?:(?:29|30)(\\.)(?:0?[1,3-9]|1[0-2])\\2))(?:(?:1[6-9]|[2-9]\\d)\\d{2})$|^(?:29(\\.)0?2\\3(?:(?:1[6-9]|[2-9]\\d)(?:0[48]|[2468][048]|[13579][26])|(?:16|[2468][048]|[3579][26])00))$|^(?:0?[1-9]|1\\d|2[0-8])(\\.)(?:0?[1-9]|1[0-2])\\4(?:(?:1[6-9]|[2-9]\\d)\\d{2})$";

        boolean regexCheck = input.matches(regex);
        boolean regexCheck2 = input2.matches(regex);

        System.out.println(regexCheck);
        System.out.println(regexCheck2);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        LocalDate birthday = LocalDate.parse(input, formatter);
        LocalDate birthday2 = LocalDate.parse(input2, formatter);
        System.out.println(birthday);
        System.out.println(birthday2);

    }


}