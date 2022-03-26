package lms.repository;

import lms.model.OrderDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface OrderDetailsRepo extends JpaRepository<OrderDetails, String> {

    @Query(value = "select * from order_details where reg_no = ?1 and return_date is null", nativeQuery = true)
    public List<OrderDetails> findOrderByRegNo(String regNo);
}
