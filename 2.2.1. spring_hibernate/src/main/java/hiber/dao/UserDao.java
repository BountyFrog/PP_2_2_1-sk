package hiber.dao;

import hiber.model.User;

import javax.persistence.TypedQuery;
import java.util.List;

public interface UserDao {
    void add(User user);

    List<User> listUsers();

    User getUserByModelAndSeries(String model, int series);
}