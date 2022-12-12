package test;

public class Test {
	//필드, 메소드, 생성자: level이 없다, 순서 상관 x
	Test(){
	}
	void service() {
		int sum = 0;
		for(int i=1; i<=10; i++){
			sum += i;
		}
		calculate();
		num = 10;
	}
	int calculate() {
		return 0;
	}
	int num;
}
