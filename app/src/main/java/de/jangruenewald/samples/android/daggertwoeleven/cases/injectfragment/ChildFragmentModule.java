package de.jangruenewald.samples.android.daggertwoeleven.cases.injectfragment;

import dagger.Module;
import dagger.Provides;

import javax.inject.Named;

/**
 * Class ChildFragmentModule.
 * TODO: Description
 *
 * @author Jan Grünewald
 * @since 1.0.0
 */
@Module
public abstract class ChildFragmentModule {
    @Provides
    @Named("fragment_string_from_module")
    static String provideFragmentStringFromModule() {
        return "String from ChildFragmentModule";
    }
}
