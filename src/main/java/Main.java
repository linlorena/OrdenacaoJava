import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite a quantidade de números na lista: ");
        int quantidade = scanner.nextInt();
        int[] array = new int[quantidade];

        for (int i = 0; i < quantidade; i++) {
            System.out.print("Digite o " + (i + 1) + "º número: ");
            array[i] = scanner.nextInt();
        }

        System.out.print("Números digitados: ");
        for (int i = 0; i < quantidade; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();

        quicksort(array, 0, quantidade - 1);

        System.out.print("Array ordenado: ");
        for (int i = 0; i < quantidade; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    public static void quicksort(int[] array, int inicio, int fim) {
        if (inicio < fim) {
            int indicePivot = partition(array, inicio, fim);
            quicksort(array, inicio, indicePivot - 1);
            quicksort(array, indicePivot + 1, fim);
        }
    }

    public static int partition(int[] array, int inicio, int fim) {
        int pivot = array[fim];
        int i = inicio - 1;

        for (int j = inicio; j < fim; j++) {
            if (array[j] < pivot) {
                i++;
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }

        int temp = array[i + 1];
        array[i + 1] = array[fim];
        array[fim] = temp;

        return i + 1;
    }
}
