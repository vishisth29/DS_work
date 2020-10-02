package Lecture9;

public class StringOps {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		printSubStrings("hello");
//		boolean result = isPalindrome("abccbd");
//		System.out.println(result);
//		int result = countPalindromicSS("abccbd");
//		System.out.println(result);
		System.out.println(toggleCase("abCDeF"));
	}
	
	public static void printChars(String str){
		for(int i = 0; i < str.length(); i++){
			System.out.println(str.charAt(i));
		}
	}
	
	public static void printSubStrings(String str){
		for(int i = 0; i < str.length(); i++){
			for(int j = i + 1; j <= str.length(); j++){
				System.out.println(str.substring(i, j));
			}
		}
	}

	public static boolean isPalindrome(String str){
		int left = 0, right = str.length() - 1;
		while(left < right){
			if(str.charAt(left) != str.charAt(right)){
				return false;
			}
			
			left++;
			right--;
		}
		
		return true;
	}
	
	public static int countPalindromicSS(String str){
		int retVal = 0;
		
		for(int i = 0; i < str.length(); i++){
			for(int j = i + 1; j <= str.length(); j++){
				String intermdeidate = str.substring(i, j);
				boolean isInterPalindrome = isPalindrome(intermdeidate);
				if(isInterPalindrome){
					retVal++;
				}
			}
		}
		
		return retVal;
	}

	public static String toggleCase(String str){
		String retVal = "";
		
		for(int i = 0; i < str.length(); i++){
			char cc = str.charAt(i);
			if(cc >= 'A' && cc <= 'Z'){
				char converted = (char)(cc - 'A' + 'a');
				retVal = retVal + converted;
			}
			else if(cc >= 'a' && cc <= 'z'){
				char converted = (char)(cc - 'a' + 'A');
				retVal = retVal + converted;
			}
		}
		
		return retVal;
	}
}
