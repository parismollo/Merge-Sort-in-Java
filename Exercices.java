class Exercices{
	public static void main(String args[]){
		int t1[] = {8, 4, 10, -5, 1};
		int t2[] = {1, 2, 3, 4, 5};
		int t3[] = {5, 4, 3, 2, 1};

		// affiche(t1);
		// System.out.println();
		// tri_insertion(t1);
		// affiche(t1);

		// System.out.println("\n------------");
		// affiche(t2);
		// System.out.println();
		// tri_insertion(t2);
		// affiche(t2);

		// System.out.println("\n------------");
		// affiche(t3);
		// System.out.println();
		// tri_insertion(t3);
		// affiche(t3);

		// int t4[] = {2, 1, 6, 8, 5, -3};
		// affiche(t4);
		// System.out.println();
		// tri_insertion_parite(t4);
		// affiche(t4);	

		// int t5[][] = {{2, 10}, {1, 5}, {1, 6}, {4, 11}, {2, 3}, {4, 3}};
		// // {{1, 5}, {1, 6}, {2, 3}, {2, 10}, {4, 3}, {4, 11}}
		// affiche(t5);
		// System.out.println("\n");
		// tri_cartes(t5);
		// affiche(t5);

		int t6[] = {3, 1, 2, 0};
		affiche(t6);
		System.out.println();
		tri_inverse(t6);
		affiche(t6);


	}
	public static void affiche(int[] t){
		for(int i=0; i<t.length; i++){
			System.out.print(t[i]+" ");
		}
	}
	public static void affiche(int[][] t){
		for(int i=0; i<t.length; i++){
			System.out.print("[");
			for(int j=0; j<t[i].length; j++){
				System.out.print(t[i][j]);
			}
			System.out.print("]");
		}

	}
	public static void tri_insertion(int[] t){
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

	public static void tri_insertion_parite(int[] t){
		tri_insertion(t);
		for(int i=1; i<t.length; i++){
			int j = i;
			while (j>0 && t[j-1] % 2 != 0 && t[j] %2 ==0){
				int aux = t[j-1];
				t[j-1] = t[j];
				t[j] = aux;
				j--;
			}
		}
	}

	public static void tri_cartes(int[][] t){
		for(int i=1; i<t.length; i++){
			int j = i;
			while (j>0 && t[j][0]<t[j-1][0]){
				int aux[] = t[j];
				t[j] = t[j-1];
				t[j-1] = aux;
				j--;
			}
		}
		for(int i=1; i<t.length; i++){
			int j = i;
			while (j>0 && t[j][0]==t[j-1][0] && t[j][1]<t[j-1][1]){
				int aux[] = t[j];
				t[j] = t[j-1];
				t[j-1] = aux;
				j--;
			}
		}
	}
	public static void tri_inverse(int[] t){
		int i = 0;
		while (i<t.length-1){
			if(t[i]>t[i+1]){
				int aux = t[i];
				t[i] = t[i+1];
				t[i+1] = aux;
				i = 0;
			}else{
				i++;
			}
		}
	}
}