package day15;

import java.util.ArrayList;

public class ThreadWaitEx1 {
	public static void main(String[] args) throws Exception {
		Table table = new Table();
		
		new Thread(new Cook(table), "COOK1").start();
		new Thread(new Customer(table, "donut"), "CUST1").start();
		new Thread(new Customer(table, "burger"), "CUST2").start();
		
		Thread.sleep(100);
		System.exit(0);
	}
}

class Customer implements Runnable {
	private Table table;
	private String food;
	
	Customer (Table table, String food) {
		this.table = table;
		this.food = food;
	}
	
	public synchronized void run() {
		while(true) {
			try {Thread.sleep(10);} catch(InterruptedException e) {}
			String name = Thread.currentThread().getName();
			
			if(eatFood())
				System.out.println(name + " ate a " + food);
			else
				System.out.println(name + " failed to eat. :(");
		}
	}
	
	boolean eatFood() { return table.remove(food);} // 음식을 먹을 때
}

class Cook implements Runnable {
	private Table table;
	
	Cook(Table table) { this.table = table; }
	
	public void run() {
		while(true) {
		int idx = (int)(Math.random()*table.dishNum());
		table.add(table.dishNames[idx]); // 테이블에 식사 놓을 때 exception
		
		try { Thread.sleep(1); } catch(InterruptedException e) {}
		}
	}
}

class Table { 
	String[] dishNames = { "donut","donut","burger" };
	final int MAX_FOOD = 6;
	
	private ArrayList<String> dishes = new ArrayList<>();
	
	public synchronized void add(String dish){ // 음식을 추가할 때 -> 여러 쓰레드가 공유하는 메서드
		String name = Thread.currentThread().getName();
		
		while(dishes.size() >= MAX_FOOD) {
			System.out.println(name+"is waiting.");
			try {
				wait();
				Thread.sleep(500);
			} catch(Interrupted Exception e) {}
		}
//		if(dishes.size() >= MAX_FOOD)
//			return;
//		dishes.add(dish);
//		notify();
//		System.out.println("Dishes: " +dishes.toString());
	}
	
	public boolean remove(String dishName) { // 음식을 먹을 때 -> 여러 쓰레드가 공유하는 메서드
		synchronized(this) {
		
		while(dishes.size() == 0) {
			for(int i=0;i<dishes.size();i++)
				if(dishName.equals(dishes.get(i))) {
					dishes.remove(i);
					notify();
					return true;
				}
			}
			return false;
		}
	}
	public int dishNum() { return dishNames.length; }
}
