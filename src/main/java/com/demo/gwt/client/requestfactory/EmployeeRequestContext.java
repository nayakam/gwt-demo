package com.demo.gwt.client.requestfactory;

import com.google.web.bindery.requestfactory.shared.Request;
import com.google.web.bindery.requestfactory.shared.RequestContext;
import com.google.web.bindery.requestfactory.shared.Service;
import com.demo.gwt.client.model.EmployeeProxy;
import com.demo.gwt.server.domain.Employee;

import java.util.List;

/**
 * Employee related requests.
 */
@Service(Employee.class)
public interface EmployeeRequestContext extends RequestContext {

    Request<Long> countEmployees();

    Request<List<EmployeeProxy>> findAllEmployees();
}
