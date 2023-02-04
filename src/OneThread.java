import java.util.concurrent.Callable;

public class OneThread implements Callable<Long> {
    final int[] array;

    public OneThread(int[] array) {
        this.array = array;
    }

    @Override
    public Long call() {
        long sum = 0;
        for (int i : array) {
            sum += i;
        }
        return sum;
    }
}
