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

package de.jangruenewald.samples.android.daggertwoeleven.cases.injectactivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import de.jangruenewald.samples.android.daggertwoeleven.cases.injectfragment.aschild.ChildFragmentBindingModule;

/**
 * Class ContributedActivityBindingModule.
 * TODO: Description
 *
 * @author Jan Grünewald
 * @since 1.0.0
 */
@Module
public abstract class ContributedActivityBindingModule {
    @ContributesAndroidInjector(modules = {ContributedActivityModule.class, ChildFragmentBindingModule.class})
    abstract ContributedActivity contributeDaggerTwoElevenActivity();
}
