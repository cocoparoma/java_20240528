package day11;

public class PolymorphismEx01 {

	public static void main(String[] args) {
		Tv tv = new Tv();
		AirConditioner aircon = new AirConditioner();
		turnOn(tv);
		turnOn(aircon);

	}
//가전 제품 종료가 20개 이면 turnOn 메소드가 20개 있어야함
//turnOff까지 있다면 40개 필요
//	public static void turnOn(Tv tv) {
//		tv.power = true;
//		System.out.println(tv.name + "이 켜졌습니다.");
//	}
//	public static void turnOn(AirConditioner aircon) {
//		aircon.power = true;
//		System.out.println(aircon.name + "이 켜졌습니다.");
//	}

	// 매개변수의 다형성을 이용하면 가전 제품 종류에 상관 없이 하나의 메소드로 처리할 수 있
	public static void turnOn(Appliances app) {
		app.power = true;
		System.out.println(app.name + "이 켜졌습니다.");
	}

}

class Appliances {
	boolean power;
	String name = "가전제품";
}

class Tv extends Appliances {
	public Tv() {
		name = "Tv";
	}
}

class AirConditioner extends Tv {
	public AirConditioner() {
		name = "에어컨";
	}
}