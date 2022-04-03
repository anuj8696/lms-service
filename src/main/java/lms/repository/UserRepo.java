package lms.repository;

import lms.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepo extends JpaRepository<User, String> {
    @Query(value = "select * from student where reg_no = ?1", nativeQuery = true)
    public User findByRegNo(String regNo);
}
