package de.jangruenewald.samples.android.daggertwoeleven.cases.injectwithconstructor;

import javax.inject.Inject;

/**
 * Created by Jan-2 on 10.06.2017.
 */

public class DaggerTwoElevenProvider {

    private final String sample;

    @Inject
    public DaggerTwoElevenProvider() {
        sample = "String from DaggerTwoElevenProvider";
    }

    public String provideString() {
        return sample;
    }
}
