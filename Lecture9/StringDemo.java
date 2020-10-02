package Lecture9;

public class StringDemo {

	public static void main(String[] args) {
		// Part1
		String s;
		
		// Part 2
		s = "Hello";
		System.out.println(s.length());
		
		// Part 3
		System.out.println(s.charAt(0));
		System.out.println(s.charAt(s.length() - 1));
//		System.out.println(s.charAt(s.length()));
		
		// Part 4
		System.out.println(s.substring(2, 4));
		System.out.println(s.substring(2, 3));
		System.out.println(s.substring(2, 2));
//		System.out.println(s.substring(2, 1));
		System.out.println(s.substring(2));
		
		// Part 5
		String s1 = "hi", s2 = "bye";
		String s3 = s1 + s2;
		String s4 = s1.concat(s2);
		System.out.println(s1 + ", " + s2 + ", " + s3);
		System.out.println(s1 + ", " + s2 + ", " + s4);
		
		// Part 6
		System.out.println(s.indexOf("l"));
		System.out.println(s.lastIndexOf("l"));
		System.out.println(s.indexOf("g"));
		
		// Part 7
		System.out.println(s.startsWith("Hell"));
		System.out.println(s.startsWith("hell"));
		
		// Part 8 (Immutability)
		s1 = "hello";
		s2 = "hello";
		s3 = new String("hello");
		s4 = s1;
		
		System.out.println(s1 == s2 + ", " + s1.equals(s2));
		System.out.println(s1 == s3 + ", " + s1.equals(s3));
		System.out.println(s1 == s4 + ", " + s1.equals(s4));
	}

}
