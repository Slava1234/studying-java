package best_practice;

public class ToString {

}

interface Phone {
    public int hash();
}

class ToStringLesson {
    private Phone phone;
    private int s = 8;

    /*
    * Good practice is when u write documetation to ur toString method
     */
    @Override
    public String toString() {
        return "ToStringLesson{" +
                "phone=" + phone +
                ", s=" + s +
                '}';
    }
}
