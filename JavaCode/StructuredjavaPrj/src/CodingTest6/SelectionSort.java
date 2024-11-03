package CodingTest6;

public class SelectionSort {
	static public void SelSort(int[] n) {
		int k = n.length;
		
		for(int i = 0; i<k-1; i++) {
			int minIndex = i;
			for(int j=i+1; j<k; j++) {
				if(n[j] < n[minIndex]) {
					minIndex = j;					
				}
			}
			int temp = n[minIndex];
			n[minIndex] = n[i];
			n[i] = temp;
		}

	}

	public static void main(String[] args) {
		int[] arr = { 64, 25, 12, 22, 11 };
		SelSort(arr);
		for (int k : arr)
			System.out.println(k);

	}

}
