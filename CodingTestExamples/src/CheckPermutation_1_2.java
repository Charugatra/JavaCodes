import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

/*
 * 1.2 Check Permutation: Given two strings, write a method 
 * to decide if one is a permutation of the other.
Hints: #1 , #84, #122, #131 
 * 
 #1. 1.2 Describe what it means for two strings to be 
 permutations of each other. Now, look at
that definition you provided. 
Can you check the strings against that definition? 

#84. 1.2 There is one solution that isO(N log N) time. Another solution uses some space, but
isO(N) time. 

#122. 1,2 Could a hash table be useful? 

#131. 12 Two strings that are permutations should have the same characters, but in different
orders. Can you make the orders the same? 

*/

/* Worst case O(n)*/
public class CheckPermutation_1_2 {

	public static void main(String[] args) {
		// one solution is sorting
		// another is using bit vector
		Scanner in = new Scanner(System.in);
		
		System.out.println("Enter first string :");
		String str1 = in.nextLine();
		System.out.println("Enter second string :");
		String str2 = in.nextLine();
		
		if(checkPermutation(str1, str2))
			System.out.println("Permutation");
		else
			System.out.println("Not a Permutation");
		
	}

	private static boolean checkPermutation(String str1, String str2) {
		if (str1.length()!= str2.length())
			return false;
		
		HashMap<Character, Integer> h1 = new HashMap<Character,Integer>();
		//HashMap<Character, Integer> h2 = new HashMap<Character,Integer>();
		for(int i=0; i<str1.length();i++)
		{
			char c1 = str1.charAt(i);
			//char c2 = str2.charAt(i);
			if(h1.containsKey(c1))
			{
				int value = h1.get(c1);
				h1.put(c1, value+1);
			}
			else {
				h1.put(c1,1);
			}
		}
		
		for(char c : str2.toCharArray())
		{
			if(h1.containsKey(c))
			{
				int value = h1.get(c) -1;
				if(value<0)
				{
					return false;
				}
				h1.put(c,value);
				
			}
			else
				return false;
		}
		
		
		/*
//			if(h2.containsKey(c2))
//			{
//				int value = h2.get(c2);
//				h2.put(c2, value+1);
//			}
//			else {
//				h2.put(c2,1);
//			}	
		}	
//		Set<Character> h1keys = h1.keySet();
//		for(char key : h1keys)
//		{
//			
//			if(h2.containsKey(key))
//			{
//				if(h1.get(key) != h2.get(key))
//					return false;
//			}
//			else
//				return false;
//		}*/
		return true;
	}

}
