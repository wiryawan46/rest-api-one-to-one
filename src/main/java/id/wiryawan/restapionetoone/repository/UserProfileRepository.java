package id.wiryawan.restapionetoone.repository;

import id.wiryawan.restapionetoone.model.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserProfileRepository extends JpaRepository<UserProfile, Integer> {
}
