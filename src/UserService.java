public class UserService {
   public User login(){
       System.out.println("Tên đăng nhập: ");
       String username= Main.scanner.nextLine();
       System.out.println("Mật khẩu:");
       String password= Main.scanner.nextLine();
       for (User user: Main.userList){
           if (user.getName().equals(username)&&user.getPassword().equals(password)){
               return user;
           }
       }
       return null;
   }

   public User register(){
       System.out.println("Tên đăng nhập: ");
       String username= Main.scanner.nextLine();
       System.out.println("Mật khẩu:");
       String password= Main.scanner.nextLine();
       return new User(username,password, User.Role.USER.getRole());
   }
}
