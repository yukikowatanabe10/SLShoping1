package com.slshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.slshop.cartItem.CartItemMapper;
import com.slshop.common.entity.CartItem;

@Service
public class CartItemService {

	public final CartItemMapper cartItemMapper;
	
	@Autowired
	public CartItemService(CartItemMapper cartItemMapper) {
		this.cartItemMapper = cartItemMapper;
	}
	
	public List<CartItem> findById(Long productId, Long customerId) {
		return this.cartItemMapper.findById(productId,customerId);
	}
	
	public void update(CartItem cartItem) {
		
//		cartItem.setId(cartItem.getCustomer().getId());
//		cartItem.setQuantity(cartItem.getQuantity());
		System.out.println();
		System.out.println(cartItem.getCustomer().getId());
		this.cartItemMapper.update(cartItem);
	}
	
	public void insert(CartItem cartItem) {
		this.cartItemMapper.insert(cartItem);
	}
	
	public List<CartItem> list(Long userId){
		return this.cartItemMapper.findAll(userId);
	}
	
	 public Integer goukei(Long userId) {
	        return this.cartItemMapper.goukei(userId);
	    }

	
 }
