package com.sist.exam02;

public class Test {
	// 8��
	public static void drawAll(GameCharacter []arr) {
		for(GameCharacter character : arr) {
			character.draw();
			
			//((Hobitt)character).getRing();
			//����
			
			if(character instanceof Hobitt) {
				((Hobitt)character).getRing();
			}
		}
	}
	
	/*9��
	public static void drawAll(Object []arr) {
		for(Object character : arr) {
			((GameCharacter)character).draw();
		}
	}
	*/

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GameCharacter g1 = new Hobitt();
		//is a ���迡 ������ �θ��� ���������� �ڽ�Ŭ������ ��ü�� ������ �� ����
		
		g1.getLife();
		//��ü�� �޼����� ������ �ڽ��� Ŭ�������� ���� ã��
		//������ �θ�Ŭ���� �޼ҵ� ����
		
		//g1.getRing();
		//����
		//is a ���迡 ������ �θ��� ���������� �ڽ�Ŭ������ ��ü ���� ����������
		//�ڽ�Ŭ������ ���Ӱ� �߰��� �޼ҵ带 �ٷ� ȣ���� �� ����.����ȯ �ʿ�
		((Hobitt)g1).getRing();
		
		System.out.println("-------------------------------");
		
		/*
		GameCharacter []arr = new GameCharacter[6];
		arr[0] = new Hobitt();
		arr[1] = new Hobitt();
		arr[2] = new Titan();
		arr[3] = new Titan();
		arr[4] = new Sorcerer();
		arr[5] = new Sorcerer();
		*/
		
		GameCharacter []arr = {
				new Hobitt(),
				new Hobitt(),
				new Titan(),
				new Titan(),
				new Sorcerer(),
				new Sorcerer(),	
		};
		/*
		for(GameCharacter character : arr) {
			character.draw();
		}
		*/
		drawAll(arr);
		
	}
}
