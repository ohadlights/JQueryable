package jqueryable.samples.fruits;

public abstract class FruitProduct implements Product, Fruit {
	
	private final long serialNumber;
	
	private final float basePrice;
	
	private final String name;
	
	private final float weight;
	
	protected FruitProduct(long serialNumber, float basePrice, String name, float weight) {
		this.serialNumber = serialNumber;
		this.basePrice = basePrice;
		this.name = name;
		this.weight = weight;
	}
	
	@Override
	public long getSerialNumber() {
		return this.serialNumber;
	}
	
	@Override
	public float getPrice() {
		return this.basePrice * this.weight;
	}
	
	@Override
	public String getName() {
		return this.name;
	}
	
	@Override
	public float getWeight() {
		return this.weight;
	}
	
	@Override
	public String toString() {
		return String.format("%s: weights %.2f and costs %.2f", this.name, this.weight, getPrice());
	}

}
