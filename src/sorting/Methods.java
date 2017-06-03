package sorting;

import java.util.ArrayList;

import string.main;

public class Methods {

	public Methods() {
		// TODO Auto-generated constructor stub
	}
	
	static void bubbleSort (int n, int [] numbers){
		int i, p;
		boolean trocou;
		for(p = n-2, trocou = true; p>=0 && trocou == true; p--)
			for(trocou = false, i=0; i<=p; i++){
				if(numbers[i]>numbers[i+1]){
					int temp;
					temp = numbers[i];
					numbers[i] = numbers[i+1];
					numbers[i+1] = temp;
					trocou = true;
				}
			}
	}
	
	static void insertionSort (int n, int [] numbers){
		int i, j, aux;
		boolean achou;
		for(i = 1; i < n; i++){
			aux = numbers[i];
			achou = false; j = i-1;
			while(j>=0 && !achou){
				if(aux < numbers[j]){
					numbers[j+1] = numbers[j];
					j--;
				}
				else achou = true;
			if(j+1 != i)
				numbers[j+1] = aux;
			}
		}
	}
	
	public static void main(String[] args){
		int [] numbers = { 1, 2, 5, 4, 3, 8,15, 2, 1, 9, 7 };
		int n = numbers.length;
		Methods.bubbleSort(n, numbers);
		for(int i = 0; i < n; i++)
			System.out.print(numbers[i]+ " ");
		
		System.out.print("\n");
		int [] numbers2 = { 1, 27, 5, 4, 84,15, 2, 12, 90, 70 };
		int n2 = numbers2.length;
		Methods.insertionSort(n2, numbers2);
		for(int i = 0; i < n2; i++)
			System.out.print(numbers2[i]+ " ");
		
	}
}
