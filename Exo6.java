class Exo6{
	public static void main(String args[]){
		int t[] = {2, 9, 4, 6, 7, 10};
		display_array(t);
		System.out.println("\n");
		// int a[] = slice_array(t, find_index_frontier(t), t.length);
		// int b[] = slice_array(t, 0, find_index_frontier(t));
		// display_array(b);
		// System.out.println("\n");
		// display_array(a);
		// System.out.println("\n");
		display_array(insertion_sort_updated(t));

	}

	public static int[] insertion_sort_updated(int[] t){
		// 1. Get idx frontier.
		// 2. Separate arrays for easier manipulation
		// 3. Loop and compare element a[i] with b[i] + swap + sort. 
		int frt = find_index_frontier(t);
		int a[] = slice_array(t, 0, frt);
		int b[] = slice_array(t, frt, t.length);

		for(int i=0; i<a.length; i++){
			if(a[i]>b[0]){
				int aux = a[i];
				a[i] = b[0];
				b[0] = aux;
				insertion_sort(b);
			}
		}
		return concatenate_arrays(a, b);
		// The time complexity for the comparisons in the worst case sceneario is
		// when all elements in the first array are larger then the elements in the second array, and therefore
		// we need to swap it every time. That would be O(a.length x b.length). 
	}

	public static void insertion_sort(int[] t){
		for(int i=1; i<t.length; i++){
			int j = i;
			while (j>0 && t[j]<t[j-1]){
				int aux = t[j];
				t[j] = t[j-1];
				t[j-1] = aux;
				j--;
			}
		}
	}

	public static int find_index_frontier(int[] t){
		// Auxiliary function that allows us to find the index that separate the two sorted arrays. 
		int idx = 0 ; 
		for(int i=0; i<t.length-1; i++){
			if(t[i]>t[i+1]){
				idx = i+1;
			}
		}
		return idx; // Sorted array 1 goes from 0 to idx - 1
		// Sorted array 2 goes from idx to array.length - 1
	}

	public static int[] slice_array(int[] t, int start, int end){
		int[] arr = new int[end-start];
		for(int i=0; i<arr.length; i++){
			arr[i] = t[start+i];
		}
		return arr;
	}
	public static void display_array(int[] t){
		for(int i=0; i<t.length; i++){
			System.out.print(t[i]+" ");
		}
	}

	public static int[] concatenate_arrays(int[] a, int[] b){
		int res[] = new int[a.length+b.length];
		int current_pos = 0;
		for(int i=0; i<a.length; i++){
			res[current_pos] = a[i];
			current_pos++;
		}
		for(int j=0; j<b.length; j++){
			res[current_pos] = b[j];
			current_pos++;
		}
		return res;
	}
}