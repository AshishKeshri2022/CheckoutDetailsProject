package com.runner;

import java.util.ArrayList;

import org.testng.TestNG;

public class MainClass {

	public static void main(String[] args) 
	{
		TestNG runner=new TestNG();
		
		ArrayList<String> al=new ArrayList<String>();
		al.add(System.getProperty("user.dir")+"\\testng.xml");
		runner.setTestSuites(al);
		runner.run();

	}

}
