package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Find_Duplicate_File_in_System_609 {

	public List<List<String>> findDuplicate(String[] paths) {
		List<List<String>> result=new ArrayList<List<String>>();
		HashMap<String, List<String>> map=new HashMap<String, List<String>>();
		for(int i=0;i<paths.length;i++){
			dealString(map, paths[i]);
		}
		Iterator iter = map.entrySet().iterator();
		while (iter.hasNext()) {
			Map.Entry entry = (Map.Entry) iter.next();
			String key = (String)entry.getKey();
			List<String> val =(List<String>) entry.getValue();
			if(val.size()>=2){
				result.add(val);
			}
		}
		return result;
	}
	
	public void dealString(HashMap<String, List<String>> map,String s){
		String[] buffer=s.split(" ");
		String path=buffer[0];
		for(int i=1;i<buffer.length;i++){
			String the=buffer[i];
			String[] nBuffer=the.split("\\(");
			String exactPath=path+"/"+nBuffer[0];
			String content=nBuffer[1].substring(0, nBuffer[1].length()-1);
			List<String> list;
			if(map.get(content)==null){
				list=new ArrayList<String>();				
			}
			else{
				list=map.get(content);
			}
			list.add(exactPath);
			map.put(content, list);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Find_Duplicate_File_in_System_609 f=new Find_Duplicate_File_in_System_609();
		String[] paths=new String[]{"root/a 1.txt(abcd) 2.txt(efgh)", "root/c 3.txt(abcd)", "root/c/d 4.txt(efgh)", "root 4.txt(efgh)"};
		List<List<String>> result=f.findDuplicate(paths);
		for(List<String> list:result){
			for(String s:list){
				System.out.print(s+" ");
			}
			System.out.println();
		}
	}

}
