package de.jangruenewald.samples.android.daggertwoeleven.cases.injectwithconstructor;

import javax.inject.Inject;

/**
 * Created by Jan-2 on 10.06.2017.
 */

public class DaggerTwoElevenActivityProvider {

    private final String sample;

    @Inject
    public DaggerTwoElevenActivityProvider() {
        sample = "String from DaggerTwoElevenActivityProvider";
    }

    public String provideString() {
        return sample;
    }
}
