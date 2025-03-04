package algoritmer;

public class bubblesort {

	public static void main(String[] args) {
		//testar metod
		
		int[] array = {1, 3, 7, 9, 10, 6, 4, 7, 8};
		
		int[] sortArray = bubble(array);
		
		//utskrift
		for(int a:sortArray) {
			System.out.print(a+ " ");
		}
		
		
		System.out.println(bin(sortArray, 3));

	}
	public static int[] bubble(int[] array) {
		int temp;
		int size = array.length;
		
		for(int i = size -1; i > 0; i--) { //for-sats som minskar ner arrayn efter sorteringrunderna
			for(int k = 0; k < i; k++) {
				if(array[k] > array[k+1]) {
					temp = array[k];
					array[k] = array[k+1];
					array[k + 1] = temp;
				}
			}
			
		}
		return array;
	}
	public static int bin(int[] array, int talet) {
		int index = -1;
		int min = 0;
		int max = array.length;
		int mid;
		
		while(index == -1 && min <= max) {
			mid = (max + min)/2;
			if(talet > array[mid]) {
				min = mid +1;    //nedre gräns i mitten
			}
			else if(talet < array[mid]) {
				max = mid -1;    //övr gränds i mitten
			}
			else {
				index = -1;
			}
		}
		return index;
	}

}
