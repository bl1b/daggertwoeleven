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

import dagger.BindsInstance;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;
import dagger.android.support.DaggerApplication;
import de.jangruenewald.samples.android.daggertwoeleven.cases.injectactivity.contributed.ContributedBindingModule;
import de.jangruenewald.samples.android.daggertwoeleven.qualifiers.ProvidedString;

/**
 * Class App.
 * TODO: Description
 *
 * @author Jan Grünewald
 * @since 1.0.0
 */
public class App extends DaggerApplication {

    @dagger.Component(modules = {
            AndroidSupportInjectionModule.class,
            ContributedBindingModule.class})
    interface Component extends AndroidInjector<App> {
        @dagger.Component.Builder
        abstract class Builder extends AndroidInjector.Builder<App> {
            @BindsInstance
            abstract Builder username(@ProvidedString("username") String username);
        }
    }

    @Override
    protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
        return DaggerApp_Component
                .builder()
                .username("Username from application")
                .create(this);
    }
}
