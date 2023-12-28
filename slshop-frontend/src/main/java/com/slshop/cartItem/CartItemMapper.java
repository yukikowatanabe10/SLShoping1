package com.slshop.cartItem;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.slshop.common.entity.CartItem;

@Mapper
public interface CartItemMapper {

	List<CartItem> findById(Long productId, Long customerId);
	
	public void update(CartItem cartItem);
	
	public void insert(CartItem cartItem);
	
	public List<CartItem> findAll(Long userId);
	
	public int goukei(Long userId);
}
