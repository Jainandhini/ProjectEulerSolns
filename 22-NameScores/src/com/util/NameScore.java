package com.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
public class NameScore {

	BufferedReader br;
	ArrayList<String> nameList;
	
	
	NameScore(){
		nameList=new ArrayList<String>();
		
	}
	
	//returns alphabetically sorted list of strings extracted from the file
	public void nameList(File f) throws IOException {
		
		br=new BufferedReader(new FileReader(f));
		String str;
		while((str=br.readLine())!=null) {
			str=str.replace("\"", "");
			nameList.addAll(Arrays.asList(str.split(",")));
			
		}
		Collections.sort(nameList);
	}
	public Long calcNameScore(){
		Long nameScore = 0L;
		Long wordScore = 0L;
		int pos=1;
		//calculate score of each word
			for(String str:nameList) {
				wordScore = 0L;
				for (char i:str.toCharArray()) {
					wordScore+=i-'A'+1;
					//System.out.println("word: "+str+"\ti:"+i+"\tws: "+wordScore);
				}
		//add weightage of each word to the final name score
				nameScore+=pos*wordScore;
				//System.out.println("pos: "+pos+"\tword: "+str+"\tscore: "+wordScore+"\ttotal: "+nameScore);
				pos++;
			}
		return nameScore;
	}
	 
	public static void main(String args[]) throws IOException {
		NameScore ns=new NameScore();
		String fileName="C:\\Users\\jaina\\Documents\\ProjectEuler\\p22\\p022_names.txt";
		ns.nameList(new File(fileName));
		System.out.println("Final name score: "+ns.calcNameScore());
		
	}
}
//Final name score: 871198282
