package com.sist.exam01;

import java.util.HashMap;

interface Action{
	public void pro();
}

class InsertBoard implements Action{
	public void pro() {
		System.out.println("게시물 등록");
	}
}

class ListBoard implements Action{
	public void pro() {
		System.out.println("게시물 목록");
	}
}

class UpdateBoard implements Action{
	public void pro() {
		System.out.println("게시물 수정");
	}
}



public class UrlExam {

	public static void main(String[] args) {
		HashMap<String, Action> map = new HashMap<String, Action>();
		
		map.put("insert.do", new InsertBoard());
		map.put("list.do", new ListBoard());
		map.put("update.do", new UpdateBoard());
		
		String url = args[0];
		String cmd = url.substring(url.lastIndexOf("/")+1);
		
		Action action = map.get(cmd);
		action.pro();

	}

}
