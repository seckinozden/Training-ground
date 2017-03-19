public class InsertionSort {

	public static void main(String[] args) {
		
		int[] array = {11,8,50,2,7,199,9};
		
		print(array);
		insertion_sort(array);
		print(array);
	}

	// This should work for any kind of array.
	public static void insertion_sort(int s[]) {
		int i, j; /* counters */
		for (i = 1; i < s.length; i++) {
			j = i;
			while ((j > 0) && (s[j] < s[j - 1])) {
				swap(s, j, j - 1);
				j = j - 1;
			}
		}
	}

	public static void swap(int s[], int idx1, int idx2) {
		int tmp = s[idx1];
		s[idx1] = s[idx2];
		s[idx2]=tmp;
	}
	
	public static void print(int[] arr){
		
		System.out.print("content of the array: ");
		for(int i=0; i<arr.length; i++){
			System.out.print(arr[i]+" - ");
		}
		
		System.out.println();
	}

}