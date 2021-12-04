import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PhoneBook pBook = new PhoneBook();

        while(true) {
            System.out.println("Введите название группы или 'нет' для завершения:");
            String input = scanner.nextLine();

            if (input.equals("нет")) {
                break;
            } else {
                pBook.addGroup(input);
            }
        }

        while(true) {
            System.out.println("Введите имя контакта и номер телефона без пробелов или 'нет' для завершения:");
            String input = scanner.nextLine();
            if (input.equals("нет")) {
                break;
            }
            String[] splitInput = input.split(" ");
            Contact contact = new Contact(splitInput[0], splitInput[1]);

            System.out.println("Укажите номер группы контакта через пробел:");
            pBook.printGroup();

            List<String> listInput = new ArrayList<>();
            input = scanner.nextLine();
            splitInput = input.split(" ");
            Collections.addAll(listInput, splitInput);

            pBook.addContactAndGroup(listInput, contact);
        }

        pBook.getAll();
    }
}
