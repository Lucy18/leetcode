
public class test2 {

	static int a;
	int b;
	static int c;
	
	public int aa(){
		a++;
		return a;
	}
	
	public int bb(){
		b++;
		return b;
	}
	
	public static int cc(){
		c++;
		return c;
	}

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		test2 t=new test2();
		t.aa();
		System.out.println(t.aa());
		t.bb();
		System.out.println(t.bb());
		t.cc();
		System.out.println(t.cc());
	}

}
