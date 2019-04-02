package org.ogorodin.entity.helpers;

import java.util.ArrayList;
import java.util.List;
/*
 * This class is used for converting... bla bla needs info
 */
public class Converter {

	private List<EmployeeForAdminView> _employeeDetails;
	private List<ProductForAdminView> _productDetails;

	public List<EmployeeForAdminView> convertToEmployeeForAdminView(Iterable<IEmployeeDetailsForAdmin> detailsList) {
		_employeeDetails = new ArrayList<>();

		for (IEmployeeDetailsForAdmin emp : detailsList) {
			_employeeDetails.add(new EmployeeForAdminView(emp.getId(), emp.getFirstName(), emp.getLastName(),
					emp.getEmail(), emp.getUsername()));
		}
		return _employeeDetails;
	}

	public List<ProductForAdminView> convertToProductForAdminView(Iterable<IProductDetailsForAdmin> detailsList) {
		_productDetails = new ArrayList<>();
		for (IProductDetailsForAdmin products : detailsList) {
			_productDetails.add(new ProductForAdminView(products.getId(), products.getProductType(), products.getTitle(),
					products.getQuantity(), products.getPrice()));
		}
		return _productDetails;
	}

}
