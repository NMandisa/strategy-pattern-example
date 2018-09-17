package za.co.fynbos.cart;

import java.util.ArrayList;
import java.util.List;

import za.co.fynbos.product.Item;
import za.co.fynbos.strategy.PaymentStrategy;

public class ShoppingCart {
	
		//List of items
		List<Item> items;
		
		public ShoppingCart(){
			this.items=new ArrayList<Item>();
		}
		
		public void addItem(Item item){
			this.items.add(item);
		}
		
		public void removeItem(Item item){
			this.items.remove(item);
		}
		
		public int calculateTotal(){
			int sum = 0;
			for(Item item : items){
				sum += item.getPrice();
			}
			return sum;
		}
		
		public void pay(PaymentStrategy paymentMethod){
			int amount = calculateTotal();
			paymentMethod.pay(amount);
		}
}