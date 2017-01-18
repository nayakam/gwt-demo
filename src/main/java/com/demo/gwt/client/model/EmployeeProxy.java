package com.demo.gwt.client.model;

import com.google.web.bindery.requestfactory.shared.EntityProxy;
import com.google.web.bindery.requestfactory.shared.ProxyFor;
import com.demo.gwt.server.domain.Employee;

/**
 * Client proxy for {@link Employee}.
 */
@ProxyFor(Employee.class)
public interface EmployeeProxy extends EntityProxy {

    String getDepartment();

    String getDisplayName();

    Long getId();

    String getPassword();

    EmployeeProxy getSupervisor();

    String getUserName();

    void setDepartment(String department);

    void setDisplayName(String displayName);

    void setPassword(String password);

    void setSupervisor(EmployeeProxy supervisor);

    void setUserName(String userName);
}
