package suan_fa_ke;

/**
 * @author huanghanqian
 * ABCAB*A=DDDDDD
 */
public class DigitalMystery {
	
	public void solve(){
		for(int A=1;A<10;A++){
			for(int B=0;B<10;B++){
				for(int C=0;C<10;C++){
					int ABCAB=A*10000+B*1000+C*100+A*10+B;
					int DDDDDD=ABCAB*A;
					//判断DDDDDD是否相同，有个一条语句的trick：if(DDDDDD % 111111 == 0)
					int pow=100000;
					int D=DDDDDD/pow;
					int rest=DDDDDD%pow;
					boolean isAllSame=true;
					pow=pow/10;
					while(pow>=10){
						if(rest/pow!=D){
							isAllSame=false;
							break;
						}
						rest=rest%pow;
						pow=pow/10;
					}
					if(isAllSame){
						System.out.println("A="+A+",B="+B+",C="+C+",ABCAB="+ABCAB+",DDDDDD="+DDDDDD);
					}
				}
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DigitalMystery d=new DigitalMystery();
		d.solve();
	}

}
