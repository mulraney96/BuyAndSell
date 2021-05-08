package com.dcu;

public class Item {
	
	 private int itemID;
	 private String category;
	 private String itemName;
	 private String itemDescription;
	 private int sellerID;
	 private int highestBid;

	 public Item(int itemID, String category, String itemName, String itemDescription, int sellerID, int highestBid) {
		 super();
		 this.itemID = itemID;
		 this.category = category;
		 this.itemName = itemName;
		 this.itemDescription = itemDescription;
		 this.sellerID = sellerID;
		 this.highestBid = highestBid;
	 }

	public int getItemID() {
		return itemID;
	}

	public void setItemID(int itemID) {
		this.itemID = itemID;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getItemDescription() {
		return itemDescription;
	}

	public void setItemDescription(String itemDescription) {
		this.itemDescription = itemDescription;
	}

	public int getSellerID() {
		return sellerID;
	}

	public void setSellerID(int sellerID) {
		this.sellerID = sellerID;
	}
	
	public int getHighestBid() {
		return highestBid;
	}
	
	public void setHighestBid(int bid) {
		this.highestBid = bid;
	}
}
