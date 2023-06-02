package com.iwu.ywuu;

import java.util.HashMap;

public class map {
    public static void main(String[] args) {
        HashMap<String,String> mymap = new HashMap<String,String>();
        mymap.put("Tom","CoreJava");
        mymap.put("John","JSP");
        mymap.put("Susan","JSP");
        mymap.put("Lucy","JSP");
        
        mymap.replace("Lucy","CoreJava");

        /*for (String key:mymap.keySet()) {
            System.out.println(key+" "+mymap.get(key));
        }*/

        for (String key:mymap.keySet()) {
            if(mymap.get(key).equals("JSP")){
                System.out.println(key+" "+mymap.get(key));
            }
        }
    }
   
    
}
