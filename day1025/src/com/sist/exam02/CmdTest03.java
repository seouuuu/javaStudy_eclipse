package com.sist.exam02;

//실행시에 url을 전달받아 해당 메소드를 실행시키는 프로그램
import java.util.HashMap;
import java.io.FileReader;
import java.util.Properties;
import java.util.Set;
import java.util.Iterator;

class CmdTest03
{
	public static void main(String[] args) throws Exception
	{
		//사용자가 요청하는 서비스명을 Key로하고 일처리담당 객체를 value로 담기위한 map 생성
		HashMap<String,SistAction> map = new HashMap<String,SistAction>();

		//서비스명과 일처리담당클래스명이 있는 파일객체 생성
		FileReader fr = new FileReader("sist.properties");

		//파일의 내용을 key,value로 관리하기 위한 객체 생성
		Properties prop = new Properties();

		//파일의 내용을 읽어 들임
		prop.load(fr);

		//properties 파일로부터 key목록(서비스명)을 반복자 객체로 생성
		Iterator iter = prop.keySet().iterator();

		//key가 있는 만큼 반복실행
		while(iter.hasNext()){

			//key(서비스명)를 하나씩 가져옴
			String cmd = (String)iter.next();

			//key에 해당하는 value(일처리 담당하는 클래스이름)를 가져옴
			String clsName = (String)prop.get(cmd);

			//문자열로 되어있는 클래스이름에 해당하는 객체를 생성함
			SistAction obj = (SistAction)Class.forName(clsName).newInstance();

			//사용자가 요청할 서비스명과 일처리 담당을 하는 객체를 key,value로 하여 map에 등록
			map.put(cmd,obj);
		}

		//프로그램 실행시 전달되는 매개변수를 url변수에 저장
		String url = args[0];

		//url로부터 서비스명을 잘라 변수에 저장
		String cmd = url.substring(url.lastIndexOf("/")+1);
		
		//map으로부터 서비스명에 해당하는 일처리 담당 객체를 가져옴
		SistAction action = map.get(cmd);

		//일처리를 위한 메소드를 호출
		action.pro();

	}
}
