import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/*
 Is Unique: Implement an algorithm to determine if a string has all unique characters. What if you
cannot use additional data structures? 
Hints: 
#44 - Try a hash table
#117 - Could a bit vector be useful? 
#132 - Can you solve it in 0(N log N) time? What might a solution like that look like? 

 */


public class If_All_Unique_in_String {

	/*With Additional Data Structure -TC O(n)*/
	/*public static void main(String[] args) {
		System.out.println("Enter String : ");
		Scanner in = new Scanner(System.in);
		String str = in.next();
		System.out.println("Str : "+str);
		Set<Character> unique = new HashSet<Character>();
		for(char c : str.toCharArray()) {
			unique.add(c);
		}
		if(unique.size()<str.length())
			System.out.println("Duplicate");
		else
			System.out.println("All unique");
	}*/
	
	/*Without additional DS : TC worst case O(n^2)*/
	public static void  main(String[] args) {
		System.out.println("Enter String : ");
		Scanner in = new Scanner(System.in);
		String str = in.next();
		str=str.toLowerCase();
		System.out.println("Str : "+str);
		boolean flag=true;
		for(int i =0;i<str.length();i++)
			for(int j=i+1;j<str.length();j++)
				if(str.charAt(i) == str.charAt(j))
				{
					System.out.println("Duplicate");
					flag=false;
					break;
				}
		
		if(flag)
			System.out.println("uNIQue");
					
		
	}

}
