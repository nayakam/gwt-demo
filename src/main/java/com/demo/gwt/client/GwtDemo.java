package com.demo.gwt.client;

import com.demo.gwt.client.injection.Injector;
import com.demo.gwt.client.navigation.MasterPage;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootPanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class GwtDemo implements EntryPoint {

    /**
     * This is the entry point method.
     */
    @Override
    public void onModuleLoad() {
        MasterPage masterPage = Injector.INSTANCE.getMasterPage();
        RootPanel.get("appContainer").add(masterPage);
    }
}
