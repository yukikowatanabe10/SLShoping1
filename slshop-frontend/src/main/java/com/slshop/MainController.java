package com.slshop;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.slshop.common.entity.CartItem;
import com.slshop.security.CustomerUserDetails;
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
	public String cart(Model model, @AuthenticationPrincipal CustomerUserDetails user) {
		List<CartItem> cartItems = this.cartItemService.list(user.getCustomer().getId());
		model.addAttribute("cartItems", cartItems);
		if (!cartItems.isEmpty()) {
			int goukeis = cartItemService.goukei(user.getCustomer().getId());
			model.addAttribute("goukeis", goukeis);
		} else {
			int goukeis = 0;
			model.addAttribute("goukeis", goukeis);
		}
		return "/layouts/cart";
	}
	
	@PostMapping("/delete")
	public  String delete() {
		return "redirect:/layouts/cart";
	}

}

//XMLに合計SQL文を書く
//マッパーに書く
//サービスに書く
//コントローラーへの受け渡し
