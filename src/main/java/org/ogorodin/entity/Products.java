package org.ogorodin.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "products")
public class Products {

	public enum EProductType {
		FW_FISH, SW_FISH, P_FISH, CRAB_FISH, FW_PLANT, P_PLANT, TANK, FILTER, CO2, FOOD
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "title")
	private String title;

	@Column(name = "description")
	private String description;

	@Column(name = "type")
	@Enumerated(EnumType.STRING)
	private EProductType productType;

	@OneToMany(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST,
			CascadeType.REFRESH }, mappedBy = "product")
	@JsonBackReference
	private List<Stock> stock;

	@ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST,
			CascadeType.REFRESH })
	@JoinTable(name = "products_order", joinColumns = @JoinColumn(name = "id"), inverseJoinColumns = @JoinColumn(name = "product_id"))
	private List<Orders> orders;

	public Products() {
	}

	public Products(String title, String description, EProductType productType) {
		this.title = title;
		this.description = description;
		this.productType = productType;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public EProductType getProductType() {
		return productType;
	}

	public void setProductType(EProductType productType) {
		this.productType = productType;
	}

	public List<Stock> getStock() {
		return stock;
	}

	public void setStock(List<Stock> stockData) {
		this.stock = stockData;
	}

	@Override
	public String toString() {
		return "Products [id=" + id + ", title=" + title + ", description=" + description + ", productType="
				+ productType + ", stockData=" + stock + "]";
	}

}
