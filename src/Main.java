import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        System.out.println("Same number of arrays:");
        Main ex1 = new Main();
        int[][] array_1 = {
                {1, 2, 3},
                {4, 5, 6, 7},
                {8, 9}};
        int[][] array_2 = {
                {1},
                {5, 9, 11}};
        ex1.Same(array_1, array_2);
        System.out.println("Add new element to an array:");
        int[] array = {11, 8, 4, 6};
        ex1.AddElement(array, 2, 0);
        System.out.println("Sum of numeral:");
        ex1.SumOfNumeral(12349);
        System.out.println("Selection sort");
        ex1.SelectionSort(array);
        int[] array1 = {1, 100,2, 8};
        int[] array2 = {1, 3, 2, 4,100};
        int[] array3 = {9, 3, 7,100};
        System.out.println("Without same elements in arrays:");
        ex1.WithoutSame(array1, array2,array3);
        ex1.WithoutSame(array1);
    }
    /*Розробіть метод, який виводить на екран спільні елементи будь яких двох 2-вимірних масивів int[][].
        Результат роботи методу не повинен залежати від того чи є масив регулярним , чи ірегулярним(ступенчатим).
         */
    public void Same(int[][] array_1, int[][] array_2) {

        for (int i = 0; i < array_1.length; i++) {
            for (int j = 0; j < array_1[i].length; j++) {
                int number1 = array_1[i][j];
                for (int a = 0; a < array_2.length; a++) {
                    for (int b = 0; b < array_2[a].length; b++) {
                        int number2 = array_2[a][b];
                        if (number1 == number2) {
                            System.out.println(number1);
                        }
                    }
                }
            }
        }
    }
    /*Створіть метод, який дозволяє вставляти в будь яку позицію масиву будь яке число.
     Метод повинен повертати новий масив.*/
    public int[] AddElement(int[] array, int index, int newNumber) {
        int[] newArray = new int[array.length + 1];
        for (int i = 0; i < newArray.length - 1; i++) {
            newArray[i < index ? i : i + 1] = array[i];
            newArray[index] = newNumber;
        }
        ShowResult(newArray);
        return newArray;
    }
    /*Створіть метод, який знаходить суму цифр будь якого числа int*/
    public void SumOfNumeral(int number) {
        int sum = 0;
        while (number != 0) {
            sum += number % 10;
            number /= 10;
        }
        System.out.println("Sum = " + sum);
    }
    /*Створіть метод, який сортує будь який масив int[] методом вибору.*/
    public void SelectionSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int position = i;
            int minimal = array[i];//
            for (int j = 0; j < array.length; j++) {
                if (array[j] > minimal) {
                    position = j;
                    minimal = array[j];
                    array[position] = array[i];
                    array[i] = minimal;
                }
            }
        }
        ShowResult(array);
    }
    /*Створіть метод, який приймає будь яку кількість елементів int[] та повертає масив,
    який складається тільки з  елементів, які є в одному екземплярі серед усіх масивів(не виключаючи масив в якому він знаходиться).*/
    public void WithoutSame(int[]... arrays) {
        List<Integer> arrayList = new ArrayList<>();
        boolean flag=true;
        if(arrays.length>1) {
            SingleElement(arrayList, flag, arrays);

            for (int i = 0; i < arrayList.size(); i++) {
                Integer value = arrayList.get(i);
                System.out.print(value + "\t");
            }
        }
        else{
            System.out.print("\nNot so much arrays");
        }
    }
    public void SingleElement(List<Integer> arrayList, boolean flag, int[][] arrays) {
        for (int i = 0; i < arrays.length; i++) {
            for (int j = 0; j < arrays[i].length; j++) {
                int number1 = arrays[i][j];
                for (int i2 = 0; i2 < arrays.length && flag; i2++) {
                    for (int j2 = 0; j2 < arrays[i2].length && flag; j2++) {
                        int number2 = arrays[i2][j2];
                        if ((number1 == number2)&&((i!=i2)||((i==i2)&&(j!=j2)))){
                            flag = false;
                        }
                    }
                }
                if (flag)
                    arrayList.add(number1);
                flag = true;
            }
        }
    }
    public void ShowResult(int[] array){
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i] + "\t");
        }
    }
}