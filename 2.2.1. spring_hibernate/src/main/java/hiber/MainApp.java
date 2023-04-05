package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.hibernate.query.Query;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;
import java.util.Queue;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);
      UserService userService = context.getBean(UserService.class);
      User user1 = new User("Ruslan", "Zaitsev", "zautsev@yamde.ru");
      Car car1 = new Car(user1,"Honda", 8);
      user1.setUsercar(car1);
      userService.add(user1);
      User user2 = new User("Oleg", "Petrov", "oleg@mail.ru");
      Car car2 = new Car(user2,"BMW", 7);
      user2.setUsercar(car2);
      userService.add(user2);
      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println("Id = " + user.getId());
         System.out.println("First Name = " + user.getFirstName());
         System.out.println("Last Name = " + user.getLastName());
         System.out.println("Email = " + user.getEmail());
         System.out.println("Car  = " + user.getCar());
         System.out.println();
      }
      System.err.println(userService.searchUser(car1));
      context.close();
   }
}
