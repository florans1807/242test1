package web.service;

import web.model.User;
import java.util.List;

public interface UserServiceIn {
    List<User> getAll();
    User get(int id);
    void add(User user);
    void update(User updatedUser);
    void delete(int id);
    User loadUserByUsername(String login);
}