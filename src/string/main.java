package string;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class main {
	
	public String compressMyWay(String s){
		String out = "";
		char [] letters = s.toCharArray(); //quebrar uma String em um vetor de char
		int sum = 1;
		int size = s.length();
		for(int i = 0; i < size; i++){
			if(i == size - 1){
				out = out + Character.toString(letters[i]) + sum;
			}
			else{
				if(letters[i]!=letters[i+1]) {
					out = out + Character.toString(letters[i]) + sum;
					sum = 1;
				}
				else sum++;
			}
		}
		return out.length() < size ? out:s;
	}
	
	/*Verify if a String is Anagram of other String */
	public boolean isAnagram(String s1, String s2){
		if(s1.length() != s2.length()) return false;
		
		s1 = s1.toLowerCase(); //transforma todas as letras em minúsculas
		s2 = s2.toLowerCase();
		
		int [] letters = new int[1<<8];
		
		for(char c:s1.toCharArray()){
			letters[c]++;
		}
		
		for(char c:s2.toCharArray()){
			letters[c]--;
		}
		for(int i:letters){
			if(i!= 0) return false;
		}
		return true;
	}
	
	public boolean isAnagramMyVersion (String str1, String str2){
		if(str1.length() != str2.length()) return false;
			
			int[] letters = new int [256];
			str1 = str1.toLowerCase();
			str2 = str2.toLowerCase();
			
			for(int i = 0; i < str1.length(); i++){
				letters[str1.charAt(i)]++; 
				letters[str2.charAt(i)]--;
			}
				
			for(int j: letters){
				if(j!=0)
					return false;
			}
			return true;
	}
	
	public String kthMostFrequent(String[] strings, int k){
		HashMap <String, Integer> map = new HashMap <String, Integer>();
		for(String s : strings){
			Integer x = map.get(s);
			if(x == null) x = 0;
			map.put(s, ++x);
		}
		
		List <Map.Entry> list = new ArrayList(map.entrySet());
		
		//como fazer um comparador
		Collections.sort(list, new Comparator(){
			public int compare(Object o1, Object o2){
				Integer v1 = (Integer) ((Map.Entry) o1).getValue();
				Integer v2 = (Integer) ((Map.Entry) o2).getValue();
				return v1.compareTo(v2);
			}
		});
		
		if(list.size() > k) return (String) (list.get(k)).getKey();
		return null;
		
	}
	
	public ArrayList<String> permutations(String str){
		ArrayList <String> results = new ArrayList <String> ();
		permutations("", str, results);
		return results; 
	}

	private void permutations(String s, String p, ArrayList<String> results){
		if(p.length()==1){
			s = s + p;
			if(!results.contains(s)) results.add(s);
		}
		else for(int i = 0; i < p.length(); i++)
				permutations(s + p.charAt(i), p.substring(0,i)+p.substring(i+1), results);
	}
	
	public String longestSubstring(String a, String b){
		String out = "";
		if(a.length()==0||b.length()==0) return out;
		
		int [][] cache = new int[a.length()][b.length()];
		
		for(int i = 0; i < a.length(); i++){
			for(int j = 0; j < b.length();j++){
				if(a.charAt(i) == b.charAt(j)){
					if(i==0||j==0){
						cache[i][j]=1;
					} else{
						cache[i][j] = cache[i-1][j-1]+1;
					}
					if(cache[i][j]>out.length()) out = a.substring(i - cache[i][j] + 1, i+1);
				}
			}
		}
		return out;
	}
	
	/* Given a string and a dictionary HashSet, write a function to determine the minimum number of
	 * characters to delete to make a word.
	 */
	static public int deleteMyWay(HashSet<String> dict, String word){
		int difmin = -1;
		Iterator <String> iterator = dict.iterator();
		
		while(iterator.hasNext()){
			String actual = iterator.next();
			if(word.contains(actual)){
				int dif = word.length() - actual.length();
				if(difmin==-1||dif < difmin){
					difmin = dif;
				}
			}
		}
		return difmin;
	}
	
	public int delete(String query, HashSet<String> dictionary){
		Queue <String> queue = new LinkedList<String>();
		Set<String> queueElements = new HashSet<String>();
		
		queue.add(query);
		queueElements.add(query);
		
		while(!queue.isEmpty()){
			String s = queue.remove();
			queueElements.remove(s);
			if(dictionary.contains(s)) return query.length() - s.length();
			for(int i = 0; i < s.length(); i++){
				String sub = s.substring(0,i) + s.substring(i+1,s.length());
				if(!queueElements.contains(sub)&&sub.length()>0){
					queue.add(sub);
					queueElements.add(sub);
				}	
			}
		}
		return -1;
	}
		
	
	public main() {
		
	}
	public static void main(String[] args){
		main test = new main();
		//System.out.println(test.isAnagram("ABcdornf","baronFDc"));
		//System.out.println(test.isAnagramMyVersion("ABcdornf","baronFDc"));
		//System.out.println(test.compressMyWay("abbbbbb"));
		/*ArrayList<String> results = test.permutations("aabc");
		for(String s:results){
			System.out.print(s + " ") ;
		}*/
		
		HashSet <String> dict = new HashSet <String>();
		dict.add("a");
		dict.add("aa");
		dict.add("aaaa");
		
		//int aux = test.minimumDif(dict, "abc");
		//System.out.println(aux);
		
		
	}
}
