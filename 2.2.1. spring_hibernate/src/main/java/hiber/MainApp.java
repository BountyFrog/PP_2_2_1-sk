package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.CarService;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class MainApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        UserService userService = context.getBean(UserService.class);
        CarService carService = context.getBean(CarService.class);

        User user1 = new User("User1", "Lastname1", "user1@mail.ru");
        User user2 = new User("User2", "Lastname2", "user2@mail.ru");
        User user3 = new User("User3", "Lastname3", "user3@mail.ru");
        User user4 = new User("User4", "Lastname4", "user4@mail.ru");

        Car car1 = new Car("Model1", 12345, user4);
        Car car2 = new Car("Model2", 23456, user3);
        Car car3 = new Car("Model3", 34567, user2);
        Car car4 = new Car("Model4", 45678, user1);

        userService.add(user1);
        userService.add(user2);
        userService.add(user3);
        userService.add(user4);

        carService.add(car1);
        carService.add(car2);
        carService.add(car3);
        carService.add(car4);

        List<User> users = userService.listUsers();
        for (User user : users) {
            System.out.println("Id = " + user.getId());
            System.out.println("First Name = " + user.getFirstName());
            System.out.println("Last Name = " + user.getLastName());
            System.out.println("Email = " + user.getEmail());
            System.out.println("Car - " + user.getCar());
        }

        User user5 = userService.getUserByModelAndSeries("Model1", 12345);
        User user6 = userService.getUserByModelAndSeries("Model2", 23456);
        System.out.println(user5);
        System.out.println(user6);

        context.close();
    }
}