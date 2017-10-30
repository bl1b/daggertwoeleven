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

package de.jangruenewald.samples.android.daggertwoeleven.cases.injectactivity.overridenmodule;

import dagger.Module;
import dagger.Provides;
import de.jangruenewald.samples.android.daggertwoeleven.qualifiers.ProvidedString;

/**
 * Created by Jan-2 on 28.10.2017.
 */
@Module
public class BasicModule {

    @Provides @ProvidedString("overriden_string") public String provideString() {
        return "OverridenBasic";
    }
}
