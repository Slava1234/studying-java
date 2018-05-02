package best_practice;

public class CloneClass {

}

/*
* BETTER NOT USE CLONE
 */

class Hero implements Cloneable {
    private String name;


    /*
    * the best clone method practice
     */
    @Override
    protected Hero clone() {
        Hero hero = null;
        try {
            hero = (Hero) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return hero;
    }
}