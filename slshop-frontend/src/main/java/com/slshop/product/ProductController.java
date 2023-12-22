package com.slshop.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.slshop.common.entity.product.Product;

@Controller
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
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
        return "products/product_detail";
    }
    
    @PostMapping("/add/{productId}")
    public String viewProductDetail(@RequestParam("productId") Long productId, @RequestParam("textValue") Integer textValue, @RequestParam("userId") Long userId) {
    	//
    	
    	//商品詳細で取得したカスタマーIDと個数と商品のIDをカートアイテムのDBに登録したい
    	//取得した物をセット
    	this.productService.hozon(userId, productId, textValue);
    	return "redirect:/detail/{productId}";
    }
    

    
}
