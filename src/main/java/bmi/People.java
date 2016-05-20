package bmi;

public class People{
	float weight;
	float height;
	char sex;
	float bodyMassIndex;
	
	public float calcBMI(){
		this.bodyMassIndex = this.weight/this.height;
		return this.bodyMassIndex;
	}
	
	
	public void setWeight(float weight){
		this.weight = weight;
	}
	
	public void setHeight(float height){
		this.height = height;
	}
	
	public void setSex(char sex){
		this.sex = sex;
	}
	
	public float getWeight(){
		return this.weight;
	}
	
	public float getHeight(){
		return this.height;
	}
	
	public char getSex(){
		return this.sex;
	}
	

}
