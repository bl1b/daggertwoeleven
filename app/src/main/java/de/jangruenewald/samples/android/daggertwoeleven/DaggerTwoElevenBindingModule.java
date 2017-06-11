package de.jangruenewald.samples.android.daggertwoeleven;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import de.jangruenewald.samples.android.daggertwoeleven.cases.injectactivity.DaggerTwoElevenActivity;
import de.jangruenewald.samples.android.daggertwoeleven.cases.injectactivity.DaggerTwoElevenActivityModule;
import de.jangruenewald.samples.android.daggertwoeleven.cases.injectfragment.DaggerTwoElevenFragmentBindingModule;

/**
 * Class DaggerTwoElevenBindingModule.
 * TODO: Description
 *
 * @author Jan Grünewald
 * @since 1.0.0
 */
@Module
public abstract class DaggerTwoElevenBindingModule {
    @ContributesAndroidInjector(modules = {DaggerTwoElevenActivityModule.class, DaggerTwoElevenFragmentBindingModule.class})
    abstract DaggerTwoElevenActivity contributeDaggerTwoElevenActivity();
}
