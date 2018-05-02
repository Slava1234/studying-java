package javadoc;


public class JavaDocClass {
    public void run() {
        Sand sand = new Sand();
        sand.setField(80, "fd");

    }
}

/**
 * @author Slava
 * @version 0.1
 * @since 0.0
 *
 * This is my first <strong>Sand</strong> class
 *
 * */
class Sand {
    /**
     * I will store here my fields
     */
    int myField;

    /**
     *
     * @param myField is the real val
     * @param flag is just for fun
     * @throws RuntimeException if something is wrong
     * @return boolean value
     */
    public boolean setField(int myField, String flag) throws RuntimeException {
        this.myField = myField;
        return true;
    }

}