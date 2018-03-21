package id.wiryawan.restapionetoone.repository;

import id.wiryawan.restapionetoone.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
