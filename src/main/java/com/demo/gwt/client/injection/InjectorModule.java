package com.demo.gwt.client.injection;

import com.demo.gwt.client.navigation.MasterPage;
import com.demo.gwt.client.requestfactory.ExpensesRequestFactory;
import com.google.gwt.inject.client.AbstractGinModule;
import com.google.inject.Singleton;
import com.google.web.bindery.event.shared.EventBus;
import com.google.web.bindery.event.shared.SimpleEventBus;
import com.demo.gwt.client.navigation.MasterPageImpl;


class InjectorModule extends AbstractGinModule {

    @Override
    protected void configure() {
        bind(EventBus.class).to(SimpleEventBus.class).in(Singleton.class);
        bind(MasterPage.class).to(MasterPageImpl.class);
        bind(ExpensesRequestFactory.class).toProvider(ExpensesRequestFactoryProvider.class).in(Singleton.class);
    }
}
