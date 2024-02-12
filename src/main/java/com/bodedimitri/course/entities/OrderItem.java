package com.bodedimitri.course.entities;

import java.io.Serializable;
import java.util.Objects;

import com.bodedimitri.course.entities.pk.OrderItemPK;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_order_item")
public class OrderItem implements Serializable {

	private static final long serialVersionUID = 1L;

	@EmbeddedId //Por ser uma pk de entidade auxiliar
	private OrderItemPK id = new OrderItemPK(); //Usando a entidade auxiliar //Tem de ser instanciado para evitar um NullPointeerException
	
	private Integer quantity;
	private Double price;
	
	public OrderItem() {
		
	}

	public OrderItem(Order order, Product product,Integer quantity, Double price) {
		id.setOrder(order); //Acessando a nossa entidade auxiliar
		id.setProduct(product);
		this.quantity = quantity;
		this.price = price;
	}
	
	@JsonIgnore //JsonIgnore não esta sendo usado em um atributo mas esse metodo referencia o atributo
	public Order getOrder() {
		return id.getOrder(); //Acessando a nossa entidade auxiliar
	}
	
	public void setOrder(Order order) {
		id.setOrder(order);
	}
	
	@JsonIgnore
	public Product getProduct() {
		return id.getProduct();
	}
	
	public void setProduct(Product product) {
		id.setProduct(product);
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}
	
	public Double getSubTotal() {
		return price * quantity;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderItem other = (OrderItem) obj;
		return Objects.equals(id, other.id);
	} 
	
}
