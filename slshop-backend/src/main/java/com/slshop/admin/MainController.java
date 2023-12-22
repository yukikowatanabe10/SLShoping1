package com.slshop.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.slshop.admin.order.service.OrderService;
import com.slshop.common.entity.order.Order;

@Controller
public class MainController {

	private OrderService orderService;
	
	@Autowired
	public MainController(OrderService orderService) {
		this.orderService = orderService;	
	}
	
	
    @GetMapping
    public String viewHomePage() {
        return "index";
    }

    @GetMapping("/login")
    public String viewLoginPage() {
        return "login";
    }
    
    @GetMapping("/orders")
    public String orders(Model model) {
    	List<Order> orders = this.orderService.findOrder();
    	model.addAttribute("orders",orders);
    	return "order";
    }
}
