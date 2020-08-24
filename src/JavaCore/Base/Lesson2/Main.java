package JavaCore.Base.Lesson2;

import java.util.Arrays;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        task1();
        task2();
        task3();
        task4();
        task5();
        task6();
        task7();
    }

    private static void task1() {
        //Задание 1
        int[] array1 = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        System.out.println("Задание 1. Изначальный массив:     " + Arrays.toString(array1));
        for (int i = 0; i < array1.length; i++) {
            if (array1[i] == 1) {
                array1[i] = 0;
            } else {
                array1[i] = 1;
            }
        }
        System.out.println("Задание 1. Преобразованный массив: " + Arrays.toString(array1));
    }

    private static void task2() {
        //Задание 2
        int[] array2 = new int[8];
        for (int i = 0; i < array2.length; i++) {
            array2[i] = i * 3;
        }
        System.out.println("Задание 2: " + Arrays.toString(array2));
    }

    private static void task3() {
        //Задание 3
        int[] array3 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        System.out.println("Задание 3. Изначальный массив:     " + Arrays.toString(array3));
        for (int i = 0; i < array3.length; i++) {
            if (array3[i] < 6) {
                array3[i] *= 2;
            }
        }
        System.out.println("Задание 3. Преобразованный массив: " + Arrays.toString(array3));
    }

    private static void task4() {
        //Задание 4
        final int array4size = 10;
        int[][] array4 = new int[array4size][array4size];
        System.out.println("Задание 4:");
        for (int i = 0; i < array4size; i++) {
            array4[i][i] = 1;
            array4[i][array4size - i - 1] = 1;
            System.out.println(Arrays.toString(array4[i]));
        }
    }

    private static void task5() {
        //Задание 5
        Random random = new Random();
        final int array5size = 20;
        int[] array5 = new int[array5size];
        for (int i = 0; i < array5size; i++) {
            array5[i] = random.nextInt(100);
        }
        System.out.println("Задание 5. Массив: " + Arrays.toString(array5));
        System.out.println("Минимальный элемент: " + findMin(array5));
        System.out.println("Максимальный элемент: " + findMax(array5));
    }
    private static int findMin(int[] array) {
        int min = array[0];
        for (int i = 0; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
            }
        }
        return min;
    }
    private static int findMax(int[] array) {
        int max = array[0];
        for (int i = 0; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        return max;
    }
    private static void task6() {
        //Задание 6
        Random random = new Random();
        final int array6size = 20;
        int[] array6 = new int[array6size];
        for (int i = 0; i < array6size; i++) {
            array6[i] = random.nextInt(5);
        }
        System.out.println("Задание 6. Массив: " + Arrays.toString(array6));
        System.out.println(checkBalance(array6));
    }
    private static boolean checkBalance(int[] array) {
        int leftPos = 0;
        int rightPos = array.length - 1;
        int leftSum = 0;
        int rightSum = 0;
        while (leftPos <= rightPos) {
            if (leftSum < rightSum) {
                leftSum += array[leftPos++];
            } else {
                rightSum += array[rightPos--];
            }
        }
        return (leftSum == rightSum);
    }
    private static void task7() {
        //Задание 7
        Random random = new Random();
        final int array7size = 20;
        int[] array7 = new int[array7size];
        for (int i = 0; i < array7size; i++) {
            array7[i] = random.nextInt(10);
        }
        System.out.printf("Задание 7. Исходный массив:\n%s\n", Arrays.toString(array7));
        int shift = random.nextInt(20) - 10;
        int[] shiftedArray7 = shiftArray(array7, shift);
        System.out.printf("Задание 7. Сдвинутый массив на %d массив:\n%s\n", shift, Arrays.toString(shiftedArray7));
    }
    private static int[] shiftArray(int[] array, int n) {
        if (n == 0 || n % array.length == 0) return array;
        n = (Math.abs(n) % array.length) * (int)Math.signum(n);
        int count = 0;
        int startPosition = 0;
        while (count < array.length) {
            int currentPosition = startPosition;
            int buf = array[currentPosition];
            do {
                currentPosition = (array.length + currentPosition + n) % array.length;
                int temp = array[currentPosition];
                array[currentPosition] = buf;
                buf = temp;
                count++;
            } while (currentPosition != startPosition);
            startPosition++;
        }
        return array;
    }
}
