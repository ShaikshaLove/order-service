package io.app.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.app.dto.OrderDTO;
import io.app.enums.OrderStatus;
import io.app.model.PurchaseOrder;
import io.app.repository.PurchaseOrderRepository;
import io.app.service.IPurhasedOrderService;
@Service
public class PurchaseOrderServiceImpl implements IPurhasedOrderService {

	@Autowired
	private PurchaseOrderRepository orderRepository;

	@Override
	public PurchaseOrder placeOrder(OrderDTO orderDTO) {
		PurchaseOrder purchaseOrder=new PurchaseOrder();
		purchaseOrder.setCustomerId(orderDTO.getCustomerId());
		purchaseOrder.setOrderDetails(orderDTO.getCartItems());
		purchaseOrder.setOrderStatus(OrderStatus.PLACED);
		purchaseOrder.setPlacedDate(new Date());
		purchaseOrder.setOrderAmount(orderDTO.getTotalCost());
		return orderRepository.save(purchaseOrder);
	}

	@Override
	public List<PurchaseOrder> allPurhaseOrders() {
		return orderRepository.findAll();
	}

	@Override
	public List<PurchaseOrder> purhaseOrdersByCustomerId(Integer customerId) {
		return orderRepository.findByCustomerId(customerId);
	}

	@Override
	public List<PurchaseOrder> purhaseOrdersByPlacedDate(String placedDate) {
		SimpleDateFormat sdf=new SimpleDateFormat("yyy-MM-dd");
		Date d=null;
		try {
			d = sdf.parse(placedDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return orderRepository.findByPlacedDate(d)	;
	}

}
