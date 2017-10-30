/*
 *  Copyright (C) 2017 Jan Grünewald
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 *
 */

package de.jangruenewald.samples.android.daggertwoeleven;

import android.app.Activity;
import dagger.BindsInstance;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;
import dagger.android.support.DaggerApplication;
import de.jangruenewald.samples.android.daggertwoeleven.cases.injectactivity.classic.ClassicBindingModule;
import de.jangruenewald.samples.android.daggertwoeleven.cases.injectactivity.contributed.ContributedBindingModule;
import de.jangruenewald.samples.android.daggertwoeleven.qualifiers.ProvidedString;

import javax.inject.Inject;
import javax.inject.Provider;
import java.util.Map;

/**
 * Class App.
 * TODO: Description
 *
 * @author Jan Grünewald
 * @since 1.0.0
 */
public class App extends DaggerApplication {

    private AndroidInjector<App> appInjector;

    @dagger.Component(modules = {
            AndroidSupportInjectionModule.class,
            ContributedBindingModule.class,
            ClassicBindingModule.class,
//            MyActivityBindingModule.class
    })
    public interface Component extends AndroidInjector<App> {
        @dagger.Component.Builder
        abstract class Builder extends AndroidInjector.Builder<App> {
            @BindsInstance abstract Builder username(@ProvidedString("username") String username);
        }
    }

    @Inject Map<Class<? extends Activity>, Provider<AndroidInjector.Factory<? extends Activity>>> builderMap;

    @Override
    protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
        appInjector = DaggerApp_Component
                .builder()
                .username("Username from application")
                .create(this);

        appInjector.inject(this);
        return appInjector;
    }
}
