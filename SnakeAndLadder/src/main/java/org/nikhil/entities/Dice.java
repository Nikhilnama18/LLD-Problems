package org.nikhil.entities;

import java.util.concurrent.ThreadLocalRandom;

public class Dice {
    public Integer roll(){
        return ThreadLocalRandom.current().nextInt(1,7);
    }
}
