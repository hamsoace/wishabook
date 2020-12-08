package com.moringaschool.wishabook.UI;

import java.util.ArrayList;
import java.util.List;

public class SuperClass {
    protected final List<Word> offers;

    public SuperClass()
    {
        offers = new ArrayList<>();
    }

    public List<Word> getOffers(){return offers;};
}
