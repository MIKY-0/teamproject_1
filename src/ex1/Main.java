package ex1;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<UserValidator> user = new ArrayList<>();

        while(true) {
            System.out.print("Id 입력 : ");
            String id = scanner.nextLine();

            System.out.print("password 입력 : ");
            String password = scanner.nextLine();

            user.add(new UserValidator(id , password));
        }
    }
}
