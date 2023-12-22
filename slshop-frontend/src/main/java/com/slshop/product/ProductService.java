package com.slshop.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.slshop.common.entity.CartItem;
import com.slshop.common.entity.product.Product;

@Service
public class ProductService {

    private final ProductMapper productMapper;

    @Autowired
    public ProductService(ProductMapper productMapper) {
        this.productMapper = productMapper;
    }

    public List<Product> getProducts() {
        return productMapper.findAll();
    }

    public Product getProduct(Long id) {
        Product product = productMapper.findById(id);
        return product;
    }
    
    public void hozon(Long userId, Long productId, Integer quantity) {
    	CartItem cartItem = new CartItem();
    	this.productMapper.insert(userId.intValue(), productId.intValue(),quantity);
    }
   
}
