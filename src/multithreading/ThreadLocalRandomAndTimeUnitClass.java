package multithreading;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class ThreadLocalRandomAndTimeUnitClass {
    public static void launch() {
        int randThreadInt = ThreadLocalRandom.current().nextInt();
        long day = TimeUnit.DAYS.toDays(2);
    }
}
