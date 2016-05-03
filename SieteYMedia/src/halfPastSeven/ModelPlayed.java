package halfPastSeven;

import java.util.ArrayList;

public class ModelPlayed {
	private String name;
	private double sumPoint;
	private ArrayList<Double> point;
	private int id;
	
	public ModelPlayed(int id){
		this.id = id;
		this.name = "Jugador "+this.id;
		this.point = new ArrayList<Double>();
	}
	
	public ModelPlayed(int id, String name){
		this.id = id;
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	private double sumPoint(){
		double sum = 0.0;
		
		for (int i = 0; i < point.size(); i++) {
			sum += point.get(i);
		}
		
		return sum;
	}

	public double getSumPoint() {
		this.sumPoint = sumPoint();
		return sumPoint;
	}
	
	public int getSizeCard() {
		return point.size();
	}

	public void setPoint(double point) {
		this.point.add(point);
	}

	public int getId() {
		return id;
	}

}
