package Lecture23.story1;

public class InPolClient {

	public static void main(String[] args) {
		String s = "";
		// P - P
		P obj1 = new P();
		
		System.out.println(obj1.d1);
		System.out.println(obj1.d);
		obj1.Fun1();
		obj1.Fun();
		System.out.println("**************************************");
		
		// P - C
		P obj2 = new C();
		
		System.out.println(obj2.d1); // 11
		System.out.println(obj2.d); // 22? 12?
		System.out.println(((C)obj2).d); // 22? 12?
//		System.out.println(obj2.d2); 
		System.out.println(((C)(obj2)).d2); // 21
		obj2.Fun1(); // P's Fun1
		obj2.Fun(); // C's Fun
//		obj2.Fun2();
		((C)(obj2)).Fun2(); // C's Fun2
		
		System.out.println("**************************************");
		
		// C - P
//		C obj3 = new P(); not allowed to prevent runtime exceptions.

		
		// C - C
		C obj4 = new C();
		
		System.out.println(obj4.d1);
		System.out.println(obj4.d2);
		System.out.println(obj4.d); // because of LHS
		
		obj4.Fun1();
		obj4.Fun2();
		obj4.Fun(); // due to RHS
		
		// OVerloading
		Add(1.0f, 2.0f);
		Add(1);
		Add(1, 2);
		Add(1, 2, 3);
	}

	public static int Add(int o, int t){
		return o + t;
	}
	
	public static float Add(float o, float t){
		return o + t;
	}
	
// Return types not part of signature as far as function overloading is concerning
//	public static void Add(int o, int t){
//		System.out.println(o + t);
//	}
	
	public static int Add(int... args){
		int rv = 0;
		
		for(int val: args){
			rv += val;
		}
		
		return rv;
	}
}
