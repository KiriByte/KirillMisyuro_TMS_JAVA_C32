package repository;

import model.User;

import java.util.Optional;

public interface UserRepository {
    //CRUD
    void save(User user);

    Optional<User> findByToken(String token);

    Optional<User> findById(int id);

    Optional<User> findByLogin(String login);

    boolean updateToken(int id, String token);

    boolean deleteById(int id);

    boolean existsByLogin(String login);
}
