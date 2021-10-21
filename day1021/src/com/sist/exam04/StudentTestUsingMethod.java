package com.sist.exam04;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentTestUsingMethod {
	public static Scanner sc = new Scanner(System.in);
	
	public static void printMenu() {
		System.out.print("1.추가, 2.검색, 3.삭제, 4.모두출력, 5.모두삭제, 0.종료");
		System.out.println("메뉴를 선택하세요==>");
	}
	
	public static void insertStudent(ArrayList<Student> list) {
		String name,addr,phone;
		System.out.println("학생의 이름을 입력하세요==>");
		name = sc.next();
		System.out.println("학생의 주소를 입력하세요==>");
		addr = sc.next();
		System.out.println("학생의 전화번호를 입력하세요==>");
		phone = sc.next();
		list.add(new Student(name, addr, phone));
	}
	
	public static void searchStudent(ArrayList<Student> list) {
		String name;
		System.out.println("검색할 학생의 이름을 입력하세요==>");
		name = sc.next();
		Student searchStudent = null;
		for(int i=0; i<list.size();i++) {
			if(list.get(i).getName().equals(name)) {
				searchStudent = list.get(i);
				break;
			}
		}
		if(searchStudent != null) {
			System.out.println(searchStudent);
		}else {
			System.out.println("찾고자 하는 학생 "+name+"은 없습니다.");
		}
	}
	
	public static void deleteStudent(ArrayList<Student> list) {
		String name;
		System.out.println("삭제할 학생의 이름을 입력하세요==>");
		name = sc.next();
		int i;
		int cnt = list.size(); 
	
		for(i=0; i<list.size();i++) {
			if(list.get(i).getName().equals(name)) {
				list.remove(i);
				break;
			}
		}
		if(i<cnt) {   
			System.out.println(name + "학생의 데이터를 삭제하였습니다.");
		}else {
			System.out.println("삭제하려는 학생 "+ name + "은(는) 없습니다." );
		}
	}
	
	public static void printStudent(ArrayList<Student> list) {
		if(list.isEmpty()) {
			System.out.println("데이터가 없습니다.");
		}else {
			for(Student student :list) {
				System.out.println(student);
			}
		}
	}
	
	public static void clearStudent(ArrayList<Student> list) {
		list.clear();
		System.out.println("데이터를 모두 삭제하였습니다.");
	}

	public static void main(String[] args) {
		ArrayList<Student> list = new ArrayList<Student>();
		
		while(true) {
			printMenu();
			int menu = sc.nextInt();
			
			if(menu == 0) {
				break;
			}
			
			switch(menu) {
				case 1:insertStudent(list);break;
				case 2:searchStudent(list);break;
				case 3:deleteStudent(list);break;
				case 4:printStudent(list);break;
				case 5:clearStudent(list);break;
			}
		}
	}
}
