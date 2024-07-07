import exc.IsCharException;
import exc.ParametersNumberException;
import exc.ParseToIntException;

import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws ParametersNumberException, ParseToIntException, IsCharException, ParseException {
        //https://gb.ru/lessons/448483/homework
//Напишите приложение, которое будет запрашивать у пользователя следующие данные в произвольном порядке, разделенные пробелом:
//Фамилия Имя Отчество / дата рождения / номер телефона / пол
//Форматы данных:
//фамилия, имя, отчество - строки
//Дата_рождения - строка формата dd.mm.yyyy
//номер_телефона - целое беззнаковое число без форматирования
//пол - символ латиницей f или m.
//Приложение должно проверить введенные данные по количеству.
//Если количество не совпадает с требуемым, вернуть код ошибки, обработать его и показать пользователю сообщение,
//что он ввел меньше и больше данных, чем требуется.
//Приложение должно попытаться распарсить полученные значения и выделить из них требуемые параметры.
//Если форматы данных не совпадают, нужно бросить исключение, соответствующее типу проблемы. Можно использовать встроенные типы java и создать свои.
//Исключение должно быть корректно обработано, пользователю выведено сообщение с информацией, что именно неверно.
//Если всё введено и обработано верно, должен создаться файл с названием, равным фамилии, в него в одну строку должны записаться полученные данные, вида
//<Фамилия><Имя><Отчество><датарождения> <номертелефона><пол>
//Однофамильцы должны записаться в один и тот же файл, в отдельные строки.
//Не забудьте закрыть соединение с файлом.
//При возникновении проблемы с чтением-записью в файл, исключение должно быть корректно обработано, пользователь должен увидеть стектрейс ошибки.
        Scanner in = new Scanner(System.in);

        System.out.println("Введите контак в следующем формате через пробел:");
        System.out.println("Фамилия Имя Отчество дата_рождения(dd.MM.yyyy) номер_телефона пол(f или m)");

        String stringContact;

        ContactCreator contactCreator = new ContactCreator();
        Contact contact;

        while (true) {
            try {
                stringContact = in.nextLine();
                contact = contactCreator.CreateContactor(stringContact);
                System.out.println("Контакт успешно создан:");
                System.out.println(contact);

                while (true){
                    try(FileWriter writer = new FileWriter(contact.getSurname() + ".txt", true))
                    {
                        writer.write(contact.toString());
                        writer.append('\n');
                        writer.flush();
                        System.out.println("Файл записан");
                        break;
                    }
                    catch(IOException ex){
                        System.out.println("запись в файл не удалась по следующей причине:");
                        System.out.println(ex.getMessage());
                        System.out.println("Закройте файл и нажмите Enter");
                    }
                }
                System.out.println("Хотите продолжить или выйти? Y - да; любой другой символ - продолжить");
                if(in.next().equals("Y")){
                    break;
                }

            } catch (Exception e) {
                System.out.println("Произошла ошибка во время создания контакта:");
                System.out.println(e.getMessage());
                System.out.println("Попробуйте заново");
            }
        }



    }
}