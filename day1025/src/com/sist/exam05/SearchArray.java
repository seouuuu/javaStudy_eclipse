package com.sist.exam05;

public class SearchArray {

	//search 메소드 body안에 예외 객체 생성될 수 있음
	//메소드 안에서 예외가 발생될 때 
	//메소드 안에서 직접 try-catch로 예외처리 할 수도 있고 메소드 호출하는 쪽으로 예외 전파(throws) 가능
 	public static int search(int []arr, int value) throws NotFoundException {
		int index = -1; //배열의 인덱스는 0부터 시작하므로 인덱스가 아닌 값을 설정
		
		for(int i=0;i<arr.length; i++) {
			if(arr[i] == value) {
				index = i;
			}
		}
		
		//value를 배열에서 찾지 못하면 index = -1
		if(index == -1) {
			throw new NotFoundException("배열에 찾는 값 "+value+"가(이) 없습니다.");
		}
		
		return index;
	}
	
	public static void main(String[] args) {
		try {
			int []data = {2,4,10,9,6};
			int n = search(data,100);
			//메소드 호출하는 쪽에서 예외처리 해야함
			System.out.println(n);
		}catch(NotFoundException e ) {  //catch(Exception e ) 도 가능
			System.out.println("예외발생:"+e.getMessage());
		}
	}
}
