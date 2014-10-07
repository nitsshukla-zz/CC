package com.cc.oct;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CCSQUARE {
	static Map<String, Boolean> map = new HashMap<String, Boolean>();
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int N = scan.nextInt();
		for(int i=0;i<N;i++){
			String ss  = scan.nextInt()+" "+ scan.nextInt();
			map.put(ss, true);
		}
		for(String s:map.keySet())
			for(String s1:map.keySet()){
				if(s!=s1)
					getVal(s,s1);
			}
	}

	private static void getVal(String s, String s1) {
			int x0=Integer.valueOf(s.split(" ")[0]);int x1=Integer.valueOf(s1.split(" ")[0]);
			int y0=Integer.valueOf(s.split(" ")[1]);int y1=Integer.valueOf(s1.split(" ")[1]);
	double[][] sixpts = getSixPts(x0,x1,y0,y1);
	System.out.println("getting for:"+s+" "+s1);
	for(int i=0;i<6;i++)
		System.out.println(Arrays.toString(sixpts[i]));
	}

	private static double[][] getSixPts(int x0, int x1, int y0, int y1) {
		double[][] pts = new double[6][2];
		double deg=(Math.atan((y1-y0)/(x1-x0)));
		double l= Math.sqrt((x0-x1)*(x0-x1)+(y0-y1)*(y0-y1));
		System.out.println("deg: "+deg*180/Math.PI);
		pts[0][0]=x0+l/Math.sqrt(2)*Math.cos(deg+Math.PI/4);
		pts[0][1]=y0+l/Math.sqrt(2)*Math.sin(deg+Math.PI/4);
		pts[1][0]=x0+2*l*Math.cos(deg+Math.PI/2)/Math.sqrt(2);
		pts[1][1]=y0+2*l*Math.sin(deg+Math.PI/2)/Math.sqrt(2);
		pts[2][0]=x0+l*Math.cos(deg+Math.PI/2);
		pts[2][1]=y0+l*Math.sin(deg+Math.PI/2);
		pts[3][0]=x0-l/Math.sqrt(2)*Math.cos(deg+Math.PI/4);
		pts[3][1]=y0-l/Math.sqrt(2)*Math.sin(deg+Math.PI/4);
		pts[4][0]=x0-2*l*Math.cos(180*Math.PI/(deg+45))/Math.sqrt(2);
		pts[4][1]=y0-2*l*Math.sin(180*Math.PI/(deg+45))/Math.sqrt(2);
		pts[5][0]=x0-l*Math.cos(180*Math.PI/(deg+90));
		pts[5][1]=y0-l*Math.sin(180*Math.PI/(deg+90));
		return pts;
	}

}
