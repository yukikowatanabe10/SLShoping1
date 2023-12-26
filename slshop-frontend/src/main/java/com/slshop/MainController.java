package com.slshop;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.slshop.common.entity.CartItem;
import com.slshop.service.CartItemService;

@Controller
public class MainController {
	
	private CartItemService cartItemService;
	
	@Autowired
	public MainController(CartItemService cartItemService) {
		this.cartItemService = cartItemService;
	}

    @GetMapping
    public String viewHome() {
        return "index";
    }

    @GetMapping("/login")
    public String viewLoginPage() {
        return "login";
    }
    
    @GetMapping("/cart")
    public String cart(Model model) {
    	List<CartItem> cartItems = this.cartItemService.list();
    	model.addAttribute("cartItems",cartItems);
    	return "/layouts/cart";
    }
    
}
