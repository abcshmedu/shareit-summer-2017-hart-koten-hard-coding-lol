package edu.hm.cs.swa.guice;

/**
 * Created by Jojo on 13.06.2017.
 */
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.servlet.GuiceServletContextListener;
import com.google.inject.servlet.ServletModule;

import edu.hm.cs.swa.controller.MediaPersistence;
import edu.hm.cs.swa.controller.MediaPersistenceImpl;
import edu.hm.cs.swa.controller.MediaService;
import edu.hm.cs.swa.controller.MediaServiceImpl;


/**
 * Context Listener to enable usage of google guice together with jersey.
 * @author <a mailto:axel.boettcher@hm.edu>Axel B&ouml;ttcher</a>
 *
 */
public class ShareitServletContextListener extends GuiceServletContextListener {

    private static final Injector injector = Guice.createInjector(new ServletModule() {
        @Override
        protected void configureServlets() {
            bind(MediaService.class).to(MediaServiceImpl.class);
            bind(MediaPersistence.class).to(MediaPersistenceImpl.class);
        }
    });

    @Override
    protected Injector getInjector() {
        return injector;
    }

    /**
     * This method is only required for the HK2-Guice-Bridge in the Application class.
     * @return Injector instance.
     */
    static Injector getInjectorInstance() {
        return injector;
    }

}