package com.sist.book;

import java.util.Date;

public class OrdersVO {
	private int orderid;
	private int custid;
	private int bookid;
	private int saleprice;
	private Date orderdate;
	
	public OrdersVO(int orderid,int custid,int bookid,int saleprice,Date orderdate){
		//OrdersVO o = new OrderdsVO(1,1,1,8000,'2021/11/09'); �̷������� ��ü ���� ����
		//�̰͸� ����� OrdersVO o = new OrdersVO(); �Ұ���
		this.orderid = orderid;
		this.custid = custid;
		this.bookid = bookid;
		this.saleprice = saleprice;
		this.orderdate = orderdate;
	}
	
	//�⺻������(�Ű������� �ϳ��� ������ �ʴ� ������)
	//����ڰ� �����ڸ� �ϳ��� ����� �����ϸ� �ڹٴ� ���̻� �⺻�����ڸ� �������� �����Ƿ� �ʿ��ϴٸ� ��������
	public OrdersVO() {
		super();
		
	}
	
	public void setOrderid(int orderid) {
		this.orderid = orderid;
		
	}
	
	public int getOrderid() {
		return orderid;
	}

	public int getCustid() {
		return custid;
	}

	public void setCustid(int custid) {
		this.custid = custid;
	}

	public int getBookid() {
		return bookid;
	}

	public void setBookid(int bookid) {
		this.bookid = bookid;
	}

	public int getSaleprice() {
		return saleprice;
	}

	public void setSaleprice(int saleprice) {
		this.saleprice = saleprice;
	}

	public Date getOrderdate() {
		return orderdate;
	}

	public void setOrderdate(Date orderdate) {
		this.orderdate = orderdate;
	}

	@Override
	public String toString() {
		return "OrdersVO [orderid=" + orderid + ", custid=" + custid + ", bookid=" + bookid + ", saleprice=" + saleprice
				+ ", orderdate=" + orderdate + "]";
	}
	
}
