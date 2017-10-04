
public class ImagineRightTriangles_39 {

	public static void main(String[] args) {

	//	int p = 120;
		int max = 0;
		int count = 0;
		for(int p = 0; p < 1000; p++){
		for(int num1 = 300; num1 < p; num1++){
			for(int num2 = 300; num2 < p; num2++){
				for(int num3 = 300; num3 < p; num3++){
					
					if(num1+num2+num3 == p){
						if(num3 == Math.pow(Math.pow(num1, 2) + Math.pow(num2, 2), .5)){
							count++;
							System.out.println("a = " + num1 + "\nb = " + num2 + "\nc= " + num3 + "\nCount " + count);
							
						}
					}
					
					
					
				}
			}
		}
		
		if(count > max){
			max = count;
		}
		
		
		}
		
		
		
		

	}

}
