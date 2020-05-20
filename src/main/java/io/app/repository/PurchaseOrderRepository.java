package io.app.repository;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.app.model.PurchaseOrder;

@Repository
public interface PurchaseOrderRepository extends JpaRepository<PurchaseOrder, String> {
         List<PurchaseOrder> findByCustomerId(Integer customerId);
         List<PurchaseOrder>  findByPlacedDate(Date placedDate);
}
