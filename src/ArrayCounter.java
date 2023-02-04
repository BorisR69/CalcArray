import java.util.Arrays;
import java.util.concurrent.RecursiveTask;

public class ArrayCounter extends RecursiveTask<Long> {
    final int[] array;

    public ArrayCounter(int[] array) {
        this.array = array;
    }

    @Override
    protected Long compute() {
        if (array.length <= 2) {
            long sum = 0;
            for (int i : array) {
                sum += i;
            }
            return sum;
        }
        ArrayCounter firstHalfArrayValueSumCounter = new ArrayCounter(Arrays.copyOfRange(array, 0, array.length / 2));
        ArrayCounter secondHalfArrayValueSumCounter = new ArrayCounter(Arrays.copyOfRange(array, array.length / 2, array.length));
        firstHalfArrayValueSumCounter.fork();
        secondHalfArrayValueSumCounter.fork();
        return firstHalfArrayValueSumCounter.join() + secondHalfArrayValueSumCounter.join();
    }
}
