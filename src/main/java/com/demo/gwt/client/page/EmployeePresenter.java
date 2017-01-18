package com.demo.gwt.client.page;

import com.demo.gwt.client.model.EmployeeProxy;
import com.demo.gwt.client.navigation.PagePlace;
import com.demo.gwt.client.requestfactory.ExpensesRequestFactory;
import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.inject.ImplementedBy;
import com.google.web.bindery.requestfactory.shared.Receiver;

import javax.inject.Inject;
import java.util.List;

/**
 * Test employee domain object.
 */
public class EmployeePresenter extends AbstractActivity {

    @ImplementedBy(EmployeeViewImpl.class)
    interface EmployeeView extends IsWidget {
        Button getGetEmployeeCountButton();

        Button getShowEmployeesButton();

        void updateEmployees(List<EmployeeProxy> employeeProxyList);
    }

    @Inject
    private EmployeeView view;
    @Inject
    private ExpensesRequestFactory requestFactory;

    public EmployeePresenter() {
    }

    public void init(PagePlace pagePlace) {
    }

    @Override
    public void start(AcceptsOneWidget panel, EventBus eventBus) {
        panel.setWidget(view.asWidget());
        view.getGetEmployeeCountButton().addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                requestFactory.employeeRequest().countEmployees().fire(new Receiver<Long>() { //todo null pointer exception?
                    @Override
                    public void onSuccess(Long response) {
                        Window.alert(String.valueOf(response));
                    }
                });
            }
        });

        view.getShowEmployeesButton().addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                requestFactory.employeeRequest().findAllEmployees().fire(new Receiver<List<EmployeeProxy>>() {
                    @Override
                    public void onSuccess(List<EmployeeProxy> response) {
                        view.updateEmployees(response);
                    }
                });
            }
        });
    }


}

