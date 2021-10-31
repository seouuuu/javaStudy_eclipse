package com.sist.exam02;

import java.io.File;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Properties;

interface Action{
	public void pro();
}

class InsertBoard implements Action{
	public void pro() {
		System.out.println("�Խù� ���");
	}
}

class ListBoard implements Action{
	public void pro() {
		System.out.println("�Խù� ���");
	}
}

class UpdateBoard implements Action{
	public void pro() {
		System.out.println("�Խù� ����");
	}
}

class LoginBoard implements Action{
	public void pro() {
		System.out.println("�α���");
	}
}

class LogoutBoard implements Action{
	public void pro() {
		System.out.println("�α׾ƿ�");
	}
}

public class PropertiesExam {

	public static void main(String[] args) throws Exception {
		
		HashMap<String, Action> map = new HashMap<String, Action>();
		FileReader fr = new FileReader("Sist.properties");
		Properties prop = new Properties();
		prop.load(fr);
		Iterator iter = prop.keySet().iterator();
		
		while(iter.hasNext()) {
			String cmd = (String)iter.next();
			String clsName = (String)prop.getProperty(cmd);
			Action obj = (Action)Class.forName(clsName).newInstance();
			map.put(cmd, obj);
		}
		
		String url = args[0];
		String cmd = url.substring(url.lastIndexOf("/")+1);
		
		Action action = map.get(cmd);
	    action.pro();
		

	}

}
