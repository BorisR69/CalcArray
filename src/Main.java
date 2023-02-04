import java.util.Date;
import java.util.concurrent.ForkJoinPool;

public class Main {

    public static void main(String[] args) {
        int elementQuantity = 20000000;
        int element = 4;
        int[] array = getArray(elementQuantity, element);

        // Время начала отсчета 1 поток
        System.out.println("Один поток\n" + "Время начала отсчета: " + new Date());
        OneThread oneThread = new OneThread(array);
        long sum = oneThread.call();
        System.out.println("Сумма элементов массива: " + sum);
        System.out.println("Среднее арифметическое суммы элементов массива: " + sum / elementQuantity);
        // Время окончания отсчета 1 поток
        System.out.println("Время окончания отсчета: " + new Date());

        // Время начала отсчета несколько потоков
        System.out.println("\nНесколько потоков\n" + "Время начала отсчета: " + new Date());
        ArrayCounter counter = new ArrayCounter(array);
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        System.out.println("Сумма элементов массива: " + forkJoinPool.invoke(counter));
//        System.out.println("Среднее арифметическое суммы элементов массива: " + forkJoinPool.invoke(counter) / elementQuantity);
        // Время окончания отсчета  несколько потоков
        System.out.println("Время окончания отсчета: " + new Date());
    }

    // Метод заполнения массива
    public static int[] getArray(int capacity, int element) {
        int[] array = new int[capacity];
        for (int i = 0; i < capacity; i++) {
            array[i] = element;
        }
        return array;
    }
}