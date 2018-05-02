package hash_equls;

public class HashEquls {
    public static void start() {
        White w1 = new White();
        White w2 = new White();
        w1.h = 5;
        w2.h = 2;


        System.out.println("w1 " + w1.hashCode());
        System.out.println("w2 " + w2.hashCode());
        System.out.println(w1.equals(w2));
    }
}

class White {
    private int i;
    public int h;
    public String name = "twitch";

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        White white = (White) o;

        if (i != white.i) return false;
        if (h != white.h) return false;
        return name != null ? name.equals(white.name) : white.name == null;
    }

    @Override
    public int hashCode() {
        int result = i;
        result = 31 * result + h;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}
