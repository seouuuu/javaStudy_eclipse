package com.sist.exam01;

class Animal{
	
}

class Lion extends Animal{
	
}

class Tiger extends Animal{
	
}

public class Cage {
	private Object animal;
	

	public Object getAnimal() {
		return animal;
	}


	public void setAnimal(Object animal) {
		this.animal = animal;
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Cage cage = new Cage();
		cage.setAnimal(new Lion());
		
		//Lion lion = cage.getAnimal();
		//Lion�� Object�� ��Ӱ��迡 ������ �ڽ��� ���������� �θ�ü�� ������ ���� ����
		//�����Ϸ��� �ڽ�Ŭ���������� ��ȯ�� ��������
		
		//Lion lion = (Lion)cage.getAnimal();
		
		//Tiger tiger = (Tiger)cage.getAnimal();
		// cage�� Lion�� �ְ� ������ Tiger�� ��ȯ ==> ������ ���� �߻�x
		// ����� ���� �߻�
		
		//System.out.println(tiger);

	}

}
