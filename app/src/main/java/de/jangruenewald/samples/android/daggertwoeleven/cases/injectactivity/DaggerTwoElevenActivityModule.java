package de.jangruenewald.samples.android.daggertwoeleven.cases.injectactivity;

import android.content.Context;
import dagger.Module;
import dagger.Provides;

import javax.inject.Named;

/**
 * Created by Jan-2 on 10.06.2017.
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
