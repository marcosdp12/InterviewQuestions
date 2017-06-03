package string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Autocomplete {
	/* Write an autocomplete class that returns all
	 * dictionary words with a given prefix
	 * dict = {"abc","acd","bcd","def","a","aba}
	 * 
	 * prefix "a" ->"abc", "acd", "a", "aba"
	 * 
	 */
	public class Node{
		String prefix;
		HashMap <Character, Node> childrem;
		boolean isWord = false;
		
		private Node (String prefix){
			this.prefix = prefix;
			this.childrem = new HashMap<Character,Node>();
		}
	}
	
	private Node tree;
	
	public Autocomplete(String [] dict){
		tree = new Node("");
		for(String word: dict){
			Node runner = tree;
			for(int i = 0; i < word.length(); i++){
				Character key = word.charAt(i);
				if(!runner.childrem.containsKey(key))
					runner.childrem.put(key, new Node(word.substring(0, i+1)));		
				runner = runner.childrem.get(key);
				if(i == word.length()-1)
					runner.isWord = true;
			}
		}
	}
	
	public List<String> getWordsForPrefix(String prefix){
		List <String> words = new ArrayList <String> (); 
		Node curr = tree;
		for(int i = 0; i < prefix.length(); i++){
			if(curr.childrem.containsKey(prefix.charAt(i))){
				curr = curr.childrem.get(prefix.charAt(i));
			}
			else return null;
		}
		findAllChildWords(curr,words);
		return words;
	}	
	
	public void findAllChildWords(Node n, List<String> words){ 
		if(n.isWord) words.add(n.prefix);
		for(Character c: n.childrem.keySet())
			findAllChildWords(n.childrem.get(c),words);
	}
	
	public static void main(String[] args) {
		/* Testing */
		String dict [] = {"oi", "ola", "gelo", "gente", "teu", "televisao", "tele"};
		Autocomplete auto = new Autocomplete(dict);
		List <String> list = auto.getWordsForPrefix("ge");
		for(String str: list){
			System.out.println(str);
		}
	}

}
