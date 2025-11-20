
// Bubble Sort----------------------------------------------------------
// time complexity: O(n^2) in the worst and average case, O(n) in the best case
// space complexity: O(1) - in-place sorting algorithm
public class Sorting {
    public static int[] bubbleSort(int[] arr){
        int n= arr.length;

        for(int i=0;i<n-1;i++){
            boolean swapped;
            swapped = false;
            for(int j=0;j<n-i-1;j++){
                if(arr[j]>arr[j+1]){
                    // swap arr[j] and arr[j+1]
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1]=temp;
                    swapped = true;
                }
            }
        }
        return arr;
    }

    public static int[] selectionSort(int[] arr){
        int n= arr.length;
        for(int j=0;j<n-1;j++){
            int minidx=j;
            for(int i=j+1;i<n;i++){
                if(arr[minidx]>arr[i]){
                    minidx=i;
                }
            }
            int temp = arr[j];
            arr[j] = arr[minidx];
            arr[minidx]=temp;
        }
        return arr;
    }

    public static int[] insertionSort(int[] arr){
        int n= arr.length;

        for(int i=1;i<n;i++){
            int cur = arr[i];
            int j= i-1;
            while(j>=0 && cur<arr[j]){
                arr[j+1]=arr[j];
                j--;
            }
            // place cur at correct position
            arr[j+1]=cur;
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] array = {64, 34, 25, 12, 22, 11, 90};
        // bubbleSort(array);
        // selectionSort(array);
        insertionSort(array);
        System.out.println("Sorted array:");
        for (int num : array) {
            System.out.print(num + " ");
        }
    }
}