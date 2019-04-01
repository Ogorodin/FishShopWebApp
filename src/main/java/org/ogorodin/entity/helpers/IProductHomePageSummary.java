package org.ogorodin.entity.helpers;

import org.ogorodin.entity.Products.EProductType;

public interface IProductHomePageSummary {
	
	int getId();

	String getTitle();

	EProductType getProductType();

	double getPrice();

	int getQuantity();
}
