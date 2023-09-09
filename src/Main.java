import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Main {
    FileHandler fileHandler = new FileHandler();
    SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
    public static void main(String[] args) {
        Main program = new Main();
        program.start();
    }
    public void start(){
        ArrayList phoneBook = new ArrayList();
        Scanner sc = new Scanner(System.in);
        phoneBook = AddRecord(phoneBook);
        sc.close();
    }
    public ArrayList<String> AddRecord(ArrayList<String> phoneBook) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Введите фамилию, имя, отчество, дату рождения - строка формата dd.mm.yyyy, " +
                    "\nномер телефона - целое беззнаковое число без форматирования (9-10 цифр), пол - символ латиницей f или m. (разделите данные пробелом)");
            String data = sc.nextLine();
            String[] split_string = data.split(" ");
// Приложение должно проверить введенные данные по количеству.
// Если количество не совпадает с требуемым, вернуть код ошибки,
// обработать его и показать пользователю сообщение,
// что он ввел меньше и больше данных, чем требуется.
            if (split_string.length < 6) {
                System.out.println("Ошибка: Мало данных! Повторите воод.");
                AddRecord(phoneBook);
            } else if (split_string.length > 6) {
                System.out.println("Ошибка: Много данных! Повторите воод.");
                AddRecord(phoneBook);
            }
            phoneBook.add(Arrays.toString(split_string));
            System.out.println(phoneBook);
            String[] name = TryParse(split_string);
            System.out.println(getInfo(name));
            String filePath = "/Users/station/Desktop/HomeWork/Final_Lesson3/" + name[0] + ".txt";
            fileHandler.save(name, filePath);

        } //Для проверки: Иванов Петр Сергеевич 12.12.2022 4242344234 m
        return phoneBook;
    }
    public String[] TryParse(String[] data){
        String[] full = new String[6];
        try {
            full[0] = isAlpha(data[0]);
            full[1] = isAlpha(data[1]);
            full[2] = isAlpha(data[2]);
            full[3] = TryParseDate(data[3]);
            full[4] = isNumber(data[4]);
            full[5] = isGender(data[5]);
            return full;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public String TryParseDate(String data){
        try {
            Date dateOfBirth = sdf.parse(data);
            return String.valueOf(sdf.format(dateOfBirth));
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
    public String isAlpha(String s) {
        if (s != null && s.matches("^[а-яА-Я]*$")) {
            return s;
        }
        System.out.println("Проверьте ввод имени: " + s + " ?");
        start();
        return null;
    }
    public String isNumber(String s) {
        if (s != null && s.matches("[0-9]{9,10}")) {
            return s;
        }
            System.out.println("Проверьте ввод телефона: " + s + " ?");
            start();
            return null;
        }
    public String isGender(String s) {
        if (s != null && s.equals("m") || s.equals("f")) {
            return s;
        }
        System.out.println("Проверьте ввод пола: " + s + " ?");
        start();
        return null;
    }
    public String getInfo(String[] s) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < s.length; i++) {
            stringBuilder.append(s[i] + " ");
        }
        return stringBuilder.toString();
    }
}