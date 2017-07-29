package leetcode;

public class Task_Scheduler_621 {

	public int leastInterval(char[] tasks, int n) {
		int[] theTasks=new int[26];
		int[] needRest=new int[26];
		int num=tasks.length;
		for(int i=0;i<num;i++){
			theTasks[tasks[i]-'A']++;
		}
		sortDesc(theTasks, needRest, 0, 25);
		int result=0;
		while(num>0){
			boolean findTaskToDo=false;
			int i=0;
			for(i=0;i<26;i++){
				if(theTasks[i]>0&&needRest[i]==0){
					findTaskToDo=true;
					theTasks[i]--;
					needRest[i]=n;
					num--;
					break;
				}
			}
			result++;
			for(int j=0;j<26;j++){
				if(j!=i&&needRest[j]>0){
					needRest[j]--;
				}
			}
			if(findTaskToDo==true){
				sortDesc(theTasks, needRest, 0, 25);
			}
		}
		return result;
	}
	
	public void sortDesc(int[] tasks,int[] needRest,int left,int right){
		if(left<right){
			int low=left;
			int high=right;
			int pivot=tasks[low];
			int pivot2=needRest[low];
			while(low<high){
				while(low<high&&tasks[high]<=pivot){
					high--;
				}
				tasks[low]=tasks[high];
				needRest[low]=needRest[high];
				while(low<high&&tasks[low]>=pivot){
					low++;
				}
				tasks[high]=tasks[low];
				needRest[high]=needRest[low];
			}
			tasks[low]=pivot;
			needRest[low]=pivot2;
			sortDesc(tasks, needRest, left, low-1);
			sortDesc(tasks, needRest, low+1, right);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Task_Scheduler_621 t=new Task_Scheduler_621();
		char[] tasks=new char[]{'A','B','B'};
		int n=2;
		System.out.println(t.leastInterval(tasks, n));
	}

}
