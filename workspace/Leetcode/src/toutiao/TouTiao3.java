package toutiao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class TouTiao3 {
	
    //用于记录操作符
    private LinkedList<String> operators=new LinkedList<>();
    //用于记录输出
    private LinkedList<String> output=new LinkedList<>();
    //用于展示后缀表达式
    private StringBuilder sb=new StringBuilder();
    String[][] map=new String[10][5];
    
    public void initMap(){
    	map[0]=new String[]{"66666","6...6","6...6","6...6","66666"};
    	map[1]=new String[]{"....6","....6","....6","....6","....6"};
    	map[2]=new String[]{"66666","....6","66666","6....","66666"};
    	map[3]=new String[]{"66666","....6","66666","....6","66666"};
    	map[4]=new String[]{"6...6","6...6","66666","....6","....6"};
    	map[5]=new String[]{"66666","6....","66666","....6","66666"};
    	map[6]=new String[]{"66666","6....","66666","6...6","66666"};
    	map[7]=new String[]{"66666","....6","....6","....6","....6"};
    	map[8]=new String[]{"66666","6...6","66666","6...6","66666"};
    	map[9]=new String[]{"66666","6...6","66666","....6","66666"};   	
    }
    
    //中缀表达式转为后缀表达式
    private String transferToPostfix(LinkedList<String> list){
        Iterator<String> it=list.iterator();
        while (it.hasNext()) {
            String s = it.next();
            if (isOperator(s)) {
                if (operators.isEmpty()) {
                    operators.push(s);
                }
                else {
                    //如果读入的操作符为非")"且优先级比栈顶元素的优先级高或一样，则将操作符压入栈
                    if (priority(operators.peek())<=priority(s)&&!s.equals(")")) {
                        operators.push(s);
                    }
                    else if(!s.equals(")")&&priority(operators.peek())>priority(s)){
                        while (operators.size()!=0&&priority(operators.peek())>=priority(s)
                                &&!operators.peek().equals("(")) {
                            if (!operators.peek().equals("(")) {
                                String operator=operators.pop();
                                sb.append(operator).append(" ");
                                output.push(operator);
                            }
                        }
                        operators.push(s);
                    }
                    //如果读入的操作符是")"，则弹出从栈顶开始第一个"("及其之前的所有操作符
                    else if (s.equals(")")) {
                        while (!operators.peek().equals("(")) {
                            String operator=operators.pop();
                            sb.append(operator).append(" ");
                            output.push(operator);
                        }
                        //弹出"("
                        operators.pop();
                    }
                }
            }
            //读入的为非操作符
            else {
                sb.append(s).append(" ");
                output.push(s);
            }
        }
        if (!operators.isEmpty()) {
            Iterator<String> iterator=operators.iterator();
            while (iterator.hasNext()) {
                String operator=iterator.next();
                sb.append(operator).append(" ");
                output.push(operator);
                iterator.remove();
            }
        }
        return calculate();
        //Collections.reverse(output);
    }
    
  //根据后缀表达式计算结果
    private String calculate(){
        LinkedList<String> mList=new LinkedList<>();
        String[] postStr=sb.toString().split(" ");
        for (String s:postStr) {
            if (isOperator(s)){
                if (!mList.isEmpty()){
                    int num1=Integer.valueOf(mList.pop());
                    int num2=Integer.valueOf(mList.pop());
                    int newNum=cal(num2,num1,s);
                    mList.push(String.valueOf(newNum));
                }
            }
            else {
                //数字则压入栈中
                mList.push(s);
            }
        }
        if (!mList.isEmpty()){
        	return mList.pop();
        }
        return "";
    }

    //判断是否操作符
    private boolean isOperator(String oper){
        if (oper.equals("+")||oper.equals("-")||oper.equals("/")||oper.equals("*")
                ||oper.equals("(")||oper.equals(")")) {
            return true;
        }
        return false;
    }
    //计算操作符的优先级
    private int priority(String s){
        switch (s) {
            case "+":return 1;
            case "-":return 1;
            case "*":return 2;
            case "/":return 2;
            case "(":return 3;
            case ")":return 3;
            default :return 0;
        }
    }

    private static int cal(int num1,int num2,String operator){
        switch (operator){
            case "+":return num1+num2;
            case "-":return num1-num2;
            case "*":return num1*num2;
            case "/":return num1/num2;
            default :return 0;
        }
    }
    
	
	public static void main(String[] args) {
		TouTiao3 t=new TouTiao3();
		t.initMap();
		Scanner in = new Scanner(System.in);
		int n = Integer.parseInt(in.nextLine());
		List<String> rs=new ArrayList<String>();
		for(int i=0;i<n;i++){
			String s=in.nextLine();
			LinkedList<String> list=new LinkedList<String>();
			for(int j=0;j<s.length();j++){
				list.add(s.charAt(j)+"");
			}		
			rs.add(t.transferToPostfix(list));
		}	
		in.close();
		for(String result:rs){
			List<Integer> nums=new ArrayList<Integer>();
			for(int j=0;j<result.length();j++){
				int num=result.charAt(j)-'0';
				nums.add(num);
			}
			for(int j=0;j<5;j++){
				System.out.print(t.map[nums.get(0)][j]);
				for(int k=1;k<nums.size();k++){
					System.out.print(".."+t.map[nums.get(k)][j]);
				}
				System.out.println();
			}
		}				
	}
}
