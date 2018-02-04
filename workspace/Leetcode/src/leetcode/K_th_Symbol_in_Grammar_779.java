package leetcode;

public class K_th_Symbol_in_Grammar_779 {

	public int kthGrammar(int N, int K) {
		if(K==1){
			return 0;
		}
		if(K==2){
			return 1;
		}
		if(K%2==1){
			return kthGrammar(-1, (K+1)/2);
		}
		else{
			return 1-kthGrammar(-1, K/2);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		K_th_Symbol_in_Grammar_779 k=new K_th_Symbol_in_Grammar_779();
		System.out.println(k.kthGrammar(30, 434991989));	
	}

}
