import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        System.out.println("Same number of arrays:");
        int[][] array_1 = {
                {1, 2, 3},
                {4, 5, 6, 7},
                {8, 9}};
        int[][] array_2 = {
                {1},
                {5, 9, 11}};
        SameNumber(array_1, array_2);
        System.out.println("Add new element to an array:");
        int[] array = {11, 8, 4, 6};
        AddElement(array, 2, 0);
        Sum(12349);
        SelectionSort(array);
        int[] array1 = {1, 100,2, 8};
        int[] array2 = {1, 3, 2, 4,100};
        int[] array3 = {9, 3, 7,100};
        System.out.println("WithoutSame:");
        WithoutSame(array1, array2,array3);
        WithoutSame(array1);
    }
    /*Розробіть метод, який виводить на екран спільні елементи будь яких двох 2-вимірних масивів int[][].
        Результат роботи методу не повинен залежати від того чи є масив регулярним , чи ірегулярним(ступенчатим).
         */
    public static void SameNumber(int[][] array_1, int[][] array_2) {

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
    public static int[] AddElement(int[] array, int index, int newNumber) {
        int[] newArray = new int[array.length + 1];

        for (int i = 0; i < newArray.length - 1; i++) {
            newArray[i < index ? i : i + 1] = array[i];
            newArray[index] = newNumber;
        }
        for (int i = 0; i < newArray.length; i++) {
            System.out.println(newArray[i] + "\t");
        }
        return newArray;
    }
/*Створіть метод, який знаходить суму цифр будь якого числа int*/
    public static void Sum(int number) {
        int sum = 0;
        while (number != 0) {
            sum += number % 10;
            number /= 10;
        }
        System.out.println("Sum = " + sum);
    }
/*Створіть метод, який сортує будь який масив int[] методом вибору.*/
    public static void SelectionSort(int[] array) {
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
        for (int x = 0; x < array.length; x++) {
            System.out.println(array[x]);

        }
    }
/*Створіть метод, який приймає будь яку кількість елементів int[] та повертає масив,
який складається тільки з  елементів, які є в одному екземплярі серед усіх масивів(не виключаючи масив в якому він знаходиться).*/
    public static void WithoutSame(int[]... arrays) {
        List<Integer> arrayList = new ArrayList<>();
        boolean flag=true;
        if(arrays.length>1) {
            for (int i = 0; i < arrays.length; i++) {
                for (int i1 = 0; i1 < arrays[i].length; i1++) {
                    int number1 = arrays[i][i1];
                    for (int j = 0; j < arrays.length && flag; j++) {
                        for (int j1 = 0; j1 < arrays[j].length && flag; j1++) {
                            int number2 = arrays[j][j1];
                            if ((number1 == number2)&&((i!=j)||((i==j)&&(i1!=j1)))){
                                flag = false;
                            }
                        }
                    }
                    if (flag)
                        arrayList.add(number1);
                    flag = true;
                }
            }
            for (int i = 0; i < arrayList.size(); i++) {
                Integer value = arrayList.get(i);
                System.out.print(value + "\t");
            }
        }
        else{
            System.out.print("\nMalo massivov");

        }
    }
}
