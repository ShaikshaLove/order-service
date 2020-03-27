package io.app.resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class OrderResource {
	
	@Value("${server.port}")
	private int port;
	
	@GetMapping
	public String save() {
		return "OrderService at "+port;
	}

}
