package de.jangruenewald.samples.android.daggertwoeleven;

import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;
import dagger.android.support.DaggerApplication;

/**
 * Created by Jan-2 on 09.05.2017.
 */
public class DaggerTwoElevenApplication extends DaggerApplication {

    @dagger.Component(
            modules = {
                    DaggerTwoElevenBindingModule.class,
                    AndroidSupportInjectionModule.class
            }
    )
    interface Component extends AndroidInjector<DaggerTwoElevenApplication> {
        @dagger.Component.Builder
        abstract class Builder extends AndroidInjector.Builder<DaggerTwoElevenApplication> {}
    }

    @Override
    protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
        return DaggerDaggerTwoElevenApplication_Component.builder().create(this);
    }
}
