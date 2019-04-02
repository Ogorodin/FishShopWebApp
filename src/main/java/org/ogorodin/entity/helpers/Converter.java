package org.ogorodin.entity.helpers;

import java.util.ArrayList;
import java.util.List;

public class Converter {

	private List<EmployeeForAdminView> _employeeDetails;

	public List<EmployeeForAdminView> convertToEmployeeForAdminView(Iterable<IEmployeeDetailsForAdmin> detailsList) {
		_employeeDetails = new ArrayList<>();

		for (IEmployeeDetailsForAdmin emp : detailsList) {
			_employeeDetails.add(new EmployeeForAdminView(emp.getId(), emp.getFirstName(), emp.getLastName(),
					emp.getEmail(), emp.getUsername()));
		}
		return _employeeDetails;
	}

}
