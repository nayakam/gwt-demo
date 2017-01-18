package com.demo.gwt.client.injection;

import com.google.gwt.core.client.GWT;
import com.google.web.bindery.event.shared.EventBus;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.demo.gwt.client.requestfactory.ExpensesRequestFactory;

class ExpensesRequestFactoryProvider implements Provider<ExpensesRequestFactory> {

    @Inject
    private EventBus eventBus;

    @Override
    public ExpensesRequestFactory get() {

        ExpensesRequestFactory requestFactory = GWT.create(ExpensesRequestFactory.class);
        requestFactory.initialize(eventBus);
        return requestFactory;
    }
}
