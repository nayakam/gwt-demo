package com.demo.gwt.client.requestfactory;

import com.google.web.bindery.requestfactory.shared.RequestFactory;

/**
 * Request factory.
 */
public interface ExpensesRequestFactory extends RequestFactory {

    EmployeeRequestContext employeeRequest();
}
