package leetcode;

public class Student_Attendance_Record_I_551 {

	public boolean checkRecord(String s) {
		if(s.length()<=1){
			return true;
		}	
		char[] cs=s.toCharArray();
		int A_occured=0;
		int i=0;
		while(i<cs.length){
			char c=cs[i];
			if(c=='P'){
				i++;
			}
			else if(c=='A'){
				A_occured++;
				if(A_occured>1){
					return false;
				}
				i++;
			}
			else{ //c=='L'
				int L_continuous=1;
				i++;
				while(i<cs.length&&cs[i]=='L'){
					L_continuous++;
					i++;
				}
				if(L_continuous>2){
					return false;
				}
			}
		}
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Student_Attendance_Record_I_551 s=new Student_Attendance_Record_I_551();
		System.out.println(s.checkRecord("PPALLL"));
	}

}
