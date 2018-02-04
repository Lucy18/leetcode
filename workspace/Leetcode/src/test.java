
public class test {
	
	public void test2(int n) {
		int count=0;
        for (int i = 1; i <= n; i++)
           for (int j = 1; j <= i; j++)
              for (int k = 1; k <= j; k++)
                count++;
        System.out.println(count);
	}

	public static void main(String[] args) {
		test t=new test();
		t.test2(4);
	}
}
