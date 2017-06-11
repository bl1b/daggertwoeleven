package de.jangruenewald.samples.android.daggertwoeleven.cases.injectactivity;

import android.content.Context;
import dagger.Module;
import dagger.Provides;

import javax.inject.Named;

/**
 * Class DaggerTwoElevenActivityModule.
 * TODO: Description
 *
 * @author Jan Grünewald
 * @since 1.0.0
 */
@Module
public abstract class DaggerTwoElevenActivityModule {
    @Provides
    @Named("string_from_module")
    static String provideStringFromModule() {
        return "String from DaggerTwoElevenActivityModule";
    }

    @Provides
    @Named("context_from_activity")
    static Context provideContextFromActivity(DaggerTwoElevenActivity activity) {
        return activity;
    }
}
