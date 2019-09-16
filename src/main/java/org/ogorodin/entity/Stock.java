package org.ogorodin.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.Table;

import org.ogorodin.entity.Products.EProductType;

@Entity
@Table(name = "stock")
@SqlResultSetMapping(name = "ProductForHomeViewMapping", classes = {
		@ConstructorResult(targetClass = org.ogorodin.entity.helpers.ProductForHomeView.class, columns = {
				@ColumnResult(name = "id", type = Integer.class), @ColumnResult(name = "title", type = String.class),
				@ColumnResult(name = "productType", type = EProductType.class),
				@ColumnResult(name = "price", type = Long.class),
				@ColumnResult(name = "quantity", type = String.class) }) })
public class Stock {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "price")
	private double price;

	@Column(name = "quantity")
	private int quantity;

	@Column(name = "price_date")
	private Date priceDate;

	@ManyToOne(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	@JoinColumn(name = "product_id")
	private Products product;

	public Stock() {
	}

	public Stock(double price, int quantity, Date priceDate, Products product) {
		this.price = price;
		this.quantity = quantity;
		this.priceDate = priceDate;
		this.product = product;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Date getPriceDate() {
		return priceDate;
	}

	public void setPriceDate(Date priceDate) {
		this.priceDate = priceDate;
	}

	public Products getProduct() {
		return product;
	}

	public void setProduct(Products product) {
		this.product = product;
	}

	@Override
	public String toString() {
		return "Stock [id=" + id + ", price=" + price + ", quantity=" + quantity + ", priceDate=" + priceDate
				+ ", product=" + product + "]";
	}

}
