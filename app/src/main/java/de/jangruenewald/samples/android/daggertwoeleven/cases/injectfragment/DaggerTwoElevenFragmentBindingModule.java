package de.jangruenewald.samples.android.daggertwoeleven.cases.injectfragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Class DaggerTwoElevenFragmentBindingModule.
 * TODO: Description
 *
 * @author Jan Grünewald
 * @since 1.0.0
 */
@Module
public abstract class DaggerTwoElevenFragmentBindingModule {
    @ContributesAndroidInjector(modules = {DaggerTwoElevenFragmentModule.class})
    abstract DaggerTwoElevenFragment contributeDaggerTwoElevenFragment();
}
