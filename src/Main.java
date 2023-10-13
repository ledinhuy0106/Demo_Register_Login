import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static Scanner scanner = new Scanner(System.in);
    public static List<User> userList = new ArrayList<>();

    public static void main(String[] args) {
        userList = FileObj.readDataFromFileToList();
        UserService userService = new UserService();
        int choice;
        do {
            System.out.println("1.Đăng nhập");
            System.out.println("2.Đăng ký");
            System.out.println("Vui lòng chọn:");
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    boolean check = true;
                    while (check) {
                        User user1 = userService.login();
                        if (user1 != null) {
                            if (user1.getRole().equals("ADMIN")) {
                                System.out.println("Admin...");
                                System.out.println();
                                admin();
                                check = false;
                            }
                            if (user1.getRole().equals("USER")) {
                                System.out.println("User");
                                admin();
                                check = false;
                            }
                        } else {
                            System.out.println("Đăng nhâp không thành công, sai tài khoản hoặc mật khẩu. Vui lòng nhập lại");
                        }
                    }
                    break;
                case 2:
                    boolean check1 = true;
                    while (check1) {
                        User user1 = userService.register();
                        if (userList!=null) {
                            for (User user : userList) {
                                if (user.getName().equals(user1.getName())) {
                                    System.out.println("Đã tồn tại tên đăng nhập, vui lòng nhập tên đăng nhập khác");
                                } else {
                                    System.out.println("Đăng ký thành công, vui lòng đăng nhập");
                                    userList.add(user1);
                                    FileObj.writeDataToFile(userList);
                                    check1 = false;
                                }
                                break;
                            }
                        } else {
                            System.out.println("Đăng ký thành công, vui lòng đăng nhập");
                            userList.add(user1);
                            FileObj.writeDataToFile(userList);
                            check1 = false;
                        }
                    }
                    break;
            }
        } while (true);
    }

    private static void user() {
    }

    public static void admin() {
        int choice;
        do {
            System.out.println("1.Thêm");
            System.out.println("2.Sửa");
            System.out.println("Vui lòng chọn:");
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    System.out.println("Thêm sp");
                    break;
                case 2:
                    System.out.println("Sửa");
                    break;
            }
        } while (true);

    }
}