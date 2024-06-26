package ph.phone;

import java.util.Scanner;

public class Sbtest0628Application {
    public static void main(String[] args) {
        if ( args.length < 2 ) {
            System.out.println("Error : You need program arguments (-j/-t) (filename) !");
            return;
        }
        ConsoleApplication application = new ConsoleApplication();
        Scanner input = new Scanner(System.in);
        boolean run = true;

        try {
            application.setPhoneBookService(new PhoneBookServiceImpl(args[0], args[1]));
        } catch (Exception e) {
            throw new RuntimeException("Error : " + e.getMessage());
        }
        while (run) {
            try {
                application.printTitle();
                int choice = application.getChoice(input);
                switch (choice) {
                    case 1:
                        application.insert(input);
                        break;
                    case 2:
                        application.printList();
                        break;
                    case 3:
                        application.update(input);
                        break;
                    case 4:
                        application.delete(input);
                        break;
                    case 5:
                        application.searchByName(input);
                        break;
                    case 6:
                        application.searchByGroup(input);
                        break;
                    case 7:
                        application.searchByPhone(input);
                        break;
                    case 8:
                        application.searchByEmail(input);
                        break;
                    case 9:
                        run = false;
                        break;
                    default:
                        System.out.println("!!! 잘못된 입력입니다. !!!");
                        break;
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
}