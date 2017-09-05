package leetcode;

public class Bulb_Switcher_II_672 {

	public int flipLights(int n, int m) {
		if(m==0) return 1;
        if(n==1) return 2;
        if(n==2&&m==1) return 3;
        if(n==2) return 4;
        if(m==1) return 4;
        if(m==2) return 7;
        if(m>=3) return 8;
        return 8;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Bulb_Switcher_II_672 b=new Bulb_Switcher_II_672();
		System.out.println(b.flipLights(0, 1));
	}

}
