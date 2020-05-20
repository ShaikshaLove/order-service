package io.app.resource;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.app.dto.OrderDTO;
import io.app.dto.OrderPlaced;
import io.app.dto.SuccessResponse;
import io.app.model.PurchaseOrder;
import io.app.service.IPurhasedOrderService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMethod;
@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*", allowedHeaders = "*",methods = {RequestMethod.DELETE,
		                 RequestMethod.GET,RequestMethod.PUT,RequestMethod.POST})
public class OrderResource {

	@Autowired
	private IPurhasedOrderService orderServie;

	@PostMapping("/orders")
	public ResponseEntity<SuccessResponse<OrderPlaced>> save(@RequestBody OrderDTO orderDTO) {
		PurchaseOrder purchaseOrder=orderServie.placeOrder(orderDTO);
		OrderPlaced orderPlaced=new OrderPlaced(purchaseOrder.getOrderId()
				,purchaseOrder.getPlacedDate()
				,purchaseOrder.getOrderAmount()
				,purchaseOrder.getOrderStatus());
		SuccessResponse<OrderPlaced> res=new SuccessResponse<>(orderPlaced,HttpStatus.OK.value());
		System.out.println(orderDTO);
		return new ResponseEntity<SuccessResponse<OrderPlaced>>(res,HttpStatus.OK);
	}

	@GetMapping("/orders")
	public ResponseEntity<SuccessResponse<List<PurchaseOrder>>> all(){
		return new ResponseEntity<>(new SuccessResponse<List<PurchaseOrder>>(orderServie.allPurhaseOrders(),HttpStatus.OK.value()),HttpStatus.OK);
	}

	@GetMapping("/customers/{customerId}/orders")
	public ResponseEntity<SuccessResponse<List<PurchaseOrder>>>  allByCustomerId(@PathVariable("customerId") Integer customerId){
		List<PurchaseOrder> po=orderServie.purhaseOrdersByCustomerId(customerId);
		return new ResponseEntity<>(new SuccessResponse<List<PurchaseOrder>>(po,HttpStatus.OK.value()),HttpStatus.OK);
	} 
	@GetMapping("/orders/{placedDate}")
	public ResponseEntity<SuccessResponse<List<PurchaseOrder>>>  allByDate(@PathVariable("placedDate") String placedDate){
		List<PurchaseOrder> po=orderServie.purhaseOrdersByPlacedDate(placedDate);
		return new ResponseEntity<>(new SuccessResponse<List<PurchaseOrder>>(po,HttpStatus.OK.value()),HttpStatus.OK);
	}


}
