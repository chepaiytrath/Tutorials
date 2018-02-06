package com.jatin.code.practice.array;

import java.util.HashMap;

import org.apache.commons.lang3.StringUtils;

public class CheckAnagram {
	public static void main(String[] args) {
		String s1 = "123";
		String s2 = "412";
		boolean isAnagram = checkAnagramUsingArrays(s1, s2);
		System.out.println(isAnagram);
	}
	static boolean checkAnagramUsingHashMap(String s1, String s2){
		if(StringUtils.equals(s1, s2)){
		 	return true;
		}
		/*if(s1 == null ? s2 ==null : s1.equals(s2)) {
			return true;
		}*/
		if((s1 == null && s2 != null) || (s1 != null && s2 == null)) {
			return false;
		}
		if(s1.length() != s2.length()) {
			return false;
		}
		HashMap<Character, Integer> map1 = new HashMap<Character, Integer>(); 
		HashMap<Character, Integer> map2 = new HashMap<Character, Integer>();
		
		for(int i = 0; i<s1.length(); i++) {
			map1.put(s1.charAt(i), 
					(map1.get(s1.charAt(i)) == null ? 0 : (map1.get(s1.charAt(i)) + 1)));
		}
		for(int i = 0; i<s2.length(); i++) {
			map2.put(s2.charAt(i), 
					(map2.get(s2.charAt(i)) == null ? 0 : (map2.get(s2.charAt(i)) + 1)));
		}
		
		for(Character ch : map1.keySet()) {
			if(map1.get(ch) != map2.get(ch)) {
				return false;
			}
		}
		
		return true;
	}
	
	
	static boolean checkAnagramUsingArrays(String s1, String s2)
    {
        //Removing white spaces from s1 and s2 and changing case to lower
 
        String copyOfs1 = s1.replaceAll("\\s", "").toLowerCase();
 
        String copyOfs2 = s2.replaceAll("\\s", "").toLowerCase();
 
        //Initially setting status as true
 
        boolean status = true;
 
        if(copyOfs1.length() != copyOfs2.length())
        {
            //Setting status as false if copyOfs1 and copyOfs2 doesn't have same length
 
            status = false;
        }
        else
        {
            //Converting copyOfs1 to char array
 
            char[] s1ToArray = copyOfs1.toCharArray();
 
            //Checking whether each character of s1ToArray is present in copyOfs2
 
            for (char c : s1ToArray)
            {
                int index = copyOfs2.indexOf(c);
 
                if(index != -1)
                {
                    //If character is present in copyOfs2, removing that char from copyOfs2
 
                    copyOfs2 = copyOfs2.substring(0, index)+copyOfs2.substring(index+1, copyOfs2.length());
                }
                else
                {
                    //If character is not present in copyOfs2, setting status as false and breaking the loop
 
                    status = false;
 
                    break;
                }
            }
        }
        return status;
    }
}
