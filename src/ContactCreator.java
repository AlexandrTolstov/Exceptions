import exc.IsCharException;
import exc.ParametersNumberException;
import exc.ParseToIntException;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ContactCreator {
    private Contact contact;

    private String surname;
    private String name;
    private String lastName;
    private Date dateOfBirth;
    private int phoneNumber;
    private char gender;

    public Contact CreateContactor(String strContact) throws ParametersNumberException, ParseException, ParseToIntException, IsCharException {
        String[] words = strContact.split(" ");
        if(words.length != 6){
            throw new ParametersNumberException("Количество параметров должно быть равно 6, а вы ввели " + words.length);
        }else {
            for (int i = 0; i < words.length; i++) {
                if(i<3 && hasDigits(words[i])){
                    throw new ParametersNumberException("Фамилия имя или отчество содержат цифры");
                }
            }
            surname = words[0];
            name = words[1];
            lastName = words[2];
            dateOfBirth = stringToDate(words[3]);
            phoneNumber = stringToInt(words[4]);
            gender = stringToGender(words[5]);
        }
        return new Contact(surname, name, lastName, dateOfBirth, phoneNumber, gender);
    }

    private boolean hasDigits(String str){
        boolean isDigit = false;
        for (int i = 0; i < str.length(); i++) {
            if(Character.isDigit(str.charAt(i))){
                isDigit = true;
                break;
            }
        }
        return isDigit;
    }

    private Date stringToDate(String str) throws ParseException {
        Date date;
        DateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");
        try {
            date = formatter.parse(str);
        } catch (ParseException e) {
            throw e;
        }
        return date;
    }

    private int stringToInt(String str) throws ParseToIntException {
        int num;
        try {
            num = Integer.parseInt(str);
        }catch (Exception e){
            throw new ParseToIntException("Номер телефона не является числом");
        }
        return num;
    }

    private char stringToGender(String str) throws IsCharException {
        if(str.length() > 1){
            throw new IsCharException("Символов у пола не должно быть больше одного");
        }else if(str.charAt(0) != 'f' && str.charAt(0) != 'm'){
            throw new IsCharException("Введен не верно пол. Должно быть введено следующее f - женский; m - мужской");
        }else {
            return str.charAt(0);
        }
    }
}
