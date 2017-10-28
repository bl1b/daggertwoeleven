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

package de.jangruenewald.samples.android.daggertwoeleven.cases.injectactivity.classic;

import android.os.Bundle;
import android.widget.TextView;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.android.support.DaggerAppCompatActivity;
import de.jangruenewald.samples.android.daggertwoeleven.R;
import de.jangruenewald.samples.android.daggertwoeleven.cases.provideinterface.FunProvider;
import de.jangruenewald.samples.android.daggertwoeleven.cases.provideinterface.FunProviderModule;
import de.jangruenewald.samples.android.daggertwoeleven.qualifiers.ProvidedString;

import javax.inject.Inject;
import javax.inject.Singleton;

public class Classic extends DaggerAppCompatActivity {

    @Subcomponent(modules = {ClassicModule.class, FunProviderModule.class}) @Singleton
    public interface ClassicComponent extends AndroidInjector<Classic> {
        @Subcomponent.Builder
        abstract class Builder extends AndroidInjector.Builder<Classic> {}
    }

    @Inject
    @ProvidedString("extensibleString")
    String extensible;

    @Inject FunProvider funProvider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_classic);

        if (extensible != null && !extensible.isEmpty()) {
            ((TextView) findViewById(R.id.tvExtensible)).setText(extensible);
        }

        if (funProvider != null) {
            ((TextView) findViewById(R.id.tvFun)).setText(funProvider.provideTheFun());
        }
    }
}
