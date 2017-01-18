package com.demo.gwt.client.injection;

import com.demo.gwt.client.navigation.MasterPage;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.inject.client.GinModules;
import com.google.gwt.inject.client.Ginjector;

@GinModules(InjectorModule.class)
public interface Injector extends Ginjector {

    Injector INSTANCE = GWT.create(Injector.class);

    MasterPage getMasterPage();

    EventBus getEventBus();

}
