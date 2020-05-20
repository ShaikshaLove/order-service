package io.app.service;

import java.util.List;

import io.app.dto.OrderDTO;
import io.app.model.PurchaseOrder;

public interface IPurhasedOrderService {
   public PurchaseOrder placeOrder(OrderDTO orderDTO);
   List<PurchaseOrder> allPurhaseOrders();
   List<PurchaseOrder> purhaseOrdersByCustomerId(Integer customerId);
   List<PurchaseOrder> purhaseOrdersByPlacedDate(String placedDate);
}
