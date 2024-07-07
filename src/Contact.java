import exc.IsDigitException;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Contact {
    // Фамилия / Имя / Отчество / дата рождения / номер телефона / пол
    //Форматы данных:
    //фамилия, имя, отчество - строки
    //Дата_рождения - строка формата dd.mm.yyyy
    //номер_телефона - целое беззнаковое число без форматирования
    //пол - символ латиницей f или m.
    private String surname;
    private String name;
    private String lastName;
    private Date dateOfBirth;
    private int phoneNumber;
    private char gender;

    public String getSurname() {
        return surname;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public char getGender() {
        return gender;
    }

    public Contact(String surname, String name, String lastName, Date dateOfBirth, int phoneNumber, char gender){
        this.surname = surname;
        this.name = name;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
    }

    @Override
    public String toString() {
        DateFormat df = new SimpleDateFormat("dd.MM.yyyy");
        return surname + " " + name + " " + lastName + " " + df.format(dateOfBirth.getTime()) + " " + phoneNumber + " " + gender;
    }
}
