import java.util.Arrays;
import java.util.Calendar;

public class Main {

    private static int array[] = {0, 7, 1, 8, 4, 9, 2, 5, 3, 6};

    public static void main(String[] args) {
        showArray(array);
        //bubbleSort(array);
        quickSort(array, 0, array.length-1);
        showArray(array);
        System.out.println("linearSearch -> " + linearSearch(array, 13));
        System.out.println("binarySearch -> " + binarySearch(array, 5, 0, array.length-1));
    }

    // метод вывода массива на консоль
    public static void showArray(int[] array) {
        System.out.println(Arrays.toString(array));
    }

    // метод сортировки пузырьком
    public static void bubbleSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int y = 1; y < array.length - i; y++) {
                if (array[y - 1] > array[y]) {
                    array[y] += array[y - 1];
                    array[y - 1] = array[y] - array[y - 1];
                    array[y] -= array[y - 1];
                }
            }
        }
    }

    // метод быстрой сортировки
    public static void quickSort(int[] array, int low, int high) {
        if (array.length == 0)
            return;//завершить выполнение, если длина массива равна 0

        if (low >= high)
            return;//завершить выполнение если уже нечего делить

        // выбрать опорный элемент
        int middle = low + (high - low) / 2;
        int opora = array[middle];

        // разделить на подмассивы, который больше и меньше опорного элемента
        int i = low, j = high;
        while (i <= j) {
            while (array[i] < opora) {
                i++;
            }

            while (array[j] > opora) {
                j--;
            }

            if (i <= j) {//меняем местами
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                i++;
                j--;
            }
        }

        // вызов рекурсии для сортировки левой и правой части
        if (low < j)
            quickSort(array, low, j);

        if (high > i)
            quickSort(array, i, high);
    }

    // метод линейного поиска
    public static int linearSearch(int array[], int elementToSearch) {
        for (int index = 0; index < array.length; index++) {
            if (array[index] == elementToSearch)
                return index;
        }
        return -1;
    }

    //метод бинарного поиска
    public static int binarySearch(int[] sortedArray, int elementToSearch, int firstIndex,
    int lastIndex) {
        int index = -1;

        while (firstIndex <= lastIndex) {
            int middleIndex = (firstIndex + lastIndex) / 2;
            if (sortedArray[middleIndex] < elementToSearch) {
                firstIndex = middleIndex + 1;
            } else if (sortedArray[middleIndex] > elementToSearch) {
                lastIndex = middleIndex - 1;
            } else if (sortedArray[middleIndex] == elementToSearch) {
                index = middleIndex;
                break;
            }
        }
        return index;
    }

    // метод вывода '*' в необходимом виде (первый алгоритм)
    public static void lastAlgorithm(int x) {
        char[] a = new char[x];
        for (int i = 0; i < a.length; i++) {
            a[i] = '*';
            System.out.print(a[i]);
        }
        System.out.println();
        if (x == 0) {
            return;
        } else {
            lastAlgorithm(x - 1);
        }
    }

    // метод вывода '*' в необходимом виде (второй алгоритм)
    public static void lastAlgorithm2(int x) {
        char a = '*';
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < x - i; j++) {
                System.out.print(a);
            }
            System.out.println();
        }
    }

}