package codejam;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Kickstart_2017_B_Cards_Game {

	int testcaseCount=0;
	long[] result;
	
	public void readFromFile() {
		File file = new File("B-large-practice.in");
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader(file));
			String tempString = reader.readLine();
			testcaseCount = Integer.parseInt(tempString);
			result=new long[testcaseCount];
			for (int i = 0; i < testcaseCount; i++) {
					tempString = reader.readLine();
					int cardsNum=Integer.parseInt(tempString);
					int[] red=new int[cardsNum];
					int[] blue=new int[cardsNum];
					tempString = reader.readLine();
					String[] tmpRed = tempString.split(" ");
					tempString = reader.readLine();
					String[] tmpBlue = tempString.split(" ");
					for(int j=0;j<cardsNum;j++){
						red[j] = Integer.parseInt(tmpRed[j]);
						blue[j] = Integer.parseInt(tmpBlue[j]);
					}
					long ans=solve2(cardsNum, red, blue);
					System.out.println(ans);
					result[i]=ans;
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e1) {
				}
			}
		}
	}
	
	public void outputToFile() {
		FileWriter fw = null;
		try {
			fw = new FileWriter("output.txt");
			for (int i = 1; i <= testcaseCount; i++) {
				fw.write("Case #" + i + ": " + result[i - 1] + "\r\n");
			}
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (fw != null) {
				try {
					fw.close();
				} catch (IOException e1) {
				}
			}
		}
	}
	
	public int solve(int cardNum,int[] red,int[] blue){
		boolean[] removed=new boolean[cardNum];
		return helper(cardNum, red, blue, removed, cardNum);
	}
	
	public int helper(int cardNum,int[] red,int[] blue,boolean[] removed,int restCard){
		if(restCard==1){
			return 0;
		}
		int min=Integer.MAX_VALUE;
		for(int i=0;i<cardNum;i++){
			if(removed[i]==true){
				continue;
			}
			for(int j=0;j<cardNum;j++){
				if(j!=i&&removed[j]==false){
					int xor=Math.min(red[i]^blue[j], red[j]^blue[i]);
					removed[i]=true;
					int rest1=helper(cardNum, red, blue, removed, restCard-1);
					removed[i]=false;
					removed[j]=true;
					int rest2=helper(cardNum, red, blue, removed, restCard-1);
					removed[j]=false;
					int restMin=Math.min(rest1, rest2);
					min=Math.min(min, xor+restMin);
				}
			}
		}
		return min;
	}
	
	public List<Edge> MiniSpanTreeInit(int cardNum,int[] red,int[] blue){
		List<Edge> edges=new ArrayList<Edge>();
		for(int i=0;i<cardNum-1;i++){
			for(int j=i+1;j<cardNum;j++){
				edges.add(new Edge(i, j, Math.min(red[i]^blue[j], red[j]^blue[i])));
			}
		}
		return edges;
	}
	
	//判断是否在同一棵树中
	//如果不在同一棵树中，则合并树
	public boolean InATree(int v1,int v2,List<Set<Integer>> trees){
		int index1=-1;
		int index2=-1;
		for(int i=0;i<trees.size();i++){
			if(trees.get(i).contains(v1)){
				index1=i;//没有break，因为不确定这时候v2有没有找到
				         //应该不会重复找到，因为之后会合并树
			}
			if(trees.get(i).contains(v2)){
				index2=i;
			}
		}
		if(index1==index2){
			return true;
		}
		else{
			Set<Integer> set1=trees.get(index1);
			Set<Integer> set2=trees.get(index2);
			//将index2上的节点合并到index1上去，删除index2
			for(Integer ii:set2){
				set1.add(ii);
			}
			trees.remove(index2);
			return false;
		}		
	}
	
	public long kruskal(int cardNum,List<Edge> edges){
		long totalCost=0;
		Collections.sort(edges, (a,b) -> a.cost-b.cost);
		List<Set<Integer>> trees=new ArrayList<Set<Integer>>();
		//有几个点，就构造几个树
		for(int i=0;i<cardNum;i++){
			Set<Integer> tmp=new HashSet<Integer>();
			tmp.add(i);
			trees.add(tmp);
		}
		//有cardNum个点，应该有cardNum-1个边
		int count=0;
		for(int i=0;i<edges.size()&&count<cardNum-1;i++){
			Edge e=edges.get(i);
			if(!InATree(e.v1, e.v2, trees)){
				totalCost+=e.cost;
				count++;
			}		
		}
		return totalCost;
	}
	
	public long solve2(int cardNum,int[] red,int[] blue){
		return kruskal(cardNum, MiniSpanTreeInit(cardNum,red,blue));
	}
	
	public void procedure() {
		readFromFile();
		outputToFile();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Kickstart_2017_B_Cards_Game k=new Kickstart_2017_B_Cards_Game();
		k.procedure();
	}
	
	class Edge{
		int v1;//两个顶点的索引
		int v2;
		int cost;
		public Edge() {
		}
		public Edge(int vertex1,int vertex2,int c){
			this.v1=vertex1;
			this.v2=vertex2;
			this.cost=c;
		}
	}

}
