package basic;

public class TestArraySelectionSort {
    public void start() {
        int[] a = {80, 12, 42, 60, 93};

        int t;
        int i, j;
        for (i = 0; i < a.length; i++) {
            t = a[i];
            for (j = i - 1; j >= a[i]-1 && a[j] > t; j--){
                a[j + 1] = a[j];
            }
            a[j + 1] = t;
        }


        System.out.print("\nSorted = ");
        for (i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }


    }
}
