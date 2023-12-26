package com.slshop.product;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.slshop.common.entity.CartItem;
import com.slshop.common.entity.product.Product;
import com.slshop.security.CustomerUserDetails;
import com.slshop.service.CartItemService;
@Controller
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;
    private final CartItemService cartItemService;
    
    @Autowired
    public ProductController(ProductService productService, CartItemService cartItemService) {
        this.productService = productService;
        this.cartItemService = cartItemService;
        
    }
    @GetMapping
    public String viewProducts(Model model) {
        List<Product> products = productService.getProducts();
        model.addAttribute("products", products);
        return "products/products";
    }
    @GetMapping("/detail/{productId}")
    public String viewProductDetail(@PathVariable("productId") Long productId, Model model) {
        Product product = productService.getProduct(productId);
        model.addAttribute("id", productId);
        model.addAttribute("product", product);
        //System.out.println("productId: " + productId);
        return "products/product_detail";
    }
    @PostMapping("/add/{productId}")
    public String hiddenProductDetail(@PathVariable("productId") Long productId, @RequestParam("textValue") Integer textValue, @AuthenticationPrincipal CustomerUserDetails user,RedirectAttributes redirectAttributes) {
    	//productIdがあるかどうか調べる。
    	List<CartItem> cartItems = this.cartItemService.findById(productId,user.getCustomer().getId()); 
    	if(cartItems.isEmpty()) {
    		//新しくcartItemを作る。
    		CartItem cartItem1 = new CartItem();
    		//カスタマーIDをセットする
    		cartItem1.setCustomer(user.getCustomer());
    		//プロダクトIDをセットする
    		cartItem1.setProduct(productService.getProduct(productId));
    		//数量を入力する
    		cartItem1.setQuantity(textValue);
    		cartItemService.insert(cartItem1);
    }else {
    	CartItem cartItem2 = cartItems.get(0);
    	if(user.getCustomer().getId() == cartItem2.getCustomer().getId() && (cartItem2.getQuantity() + textValue) > 10) {
        	redirectAttributes.addFlashAttribute("message","最大数量は10個です");
    	}else {
    		int newQuantity = cartItem2.getQuantity() + textValue;
            cartItem2.setQuantity(newQuantity);
    		this.cartItemService.update(cartItem2);
        	redirectAttributes.addFlashAttribute("message","商品を追加しました");
        }
    		
    }
    	//CartItem cartItem2 = cartItem.get();

    	
    	
    	
    	return "redirect:/products/detail/{productId}";
    
    }
}