package com.sist.exam05;

import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class NestedVectorTable {

	public static void main(String[] args) {
		Vector<Vector<String>> list = new Vector<Vector<String>>();
		
		Vector<String> row1 = new Vector<String>();
		row1.add("ȫ�浿");
		row1.add("����");
		row1.add("010-1234-5678");
		
		Vector<String> row2 = new Vector<String>();
		row2.add("������");
		row2.add("��õ");
		row2.add("010-1234-2222");
		
		Vector<String> row3 = new Vector<String>();
		row3.add("������");
		row3.add("����");
		row3.add("010-1234-3333");
		
		list.add(row1);
		list.add(row2);
		list.add(row3);
		
		Vector<String> colNames = new Vector<String>();
		colNames.add("�̸�");
		colNames.add("�ּ�");
		colNames.add("��ȭ");
		
		
		JTable table = new JTable(list,colNames);  //JTable ���� 
		JScrollPane jsp = new JScrollPane(table);  //��ũ�ѹ� ���� �� ���̺� �ֱ�
		JFrame frame = new JFrame();			   //JFrame ����
		frame.add(jsp);                            //frame�� ���̺� ���� ��ũ�ѹ� �ֱ� 
		frame.setSize(400,300);
		frame.setVisible(true);
		}
	}





