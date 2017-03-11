package tju.junit.triangle;

public class TriangleKind {
	private String equilateral="等边三角形";
	private String isosceles="等腰三角形";
	private String scalene="不等边三角形";
	private String nonTriangle="非三角形";
	private String triangleKind=null;
	public String getTriangleKind(int a,int b,int c)
	{
		if(isTriangle(a, b, c)){
			if( a == b && b == c){
				triangleKind = equilateral;	
			}else if(a == c || b == c || a == b){
				triangleKind = isosceles;
			}else{
				triangleKind = scalene;
			}
		}
		return triangleKind;
		
	}
	private boolean isTriangle(int a, int b, int c){
		if(a <= 0 || b <= 0 || c <= 0){
			triangleKind=nonTriangle;
			return false;
		}else if(a + b > c && a + c > b && b + c > a){
	         return true;
	    }else{
	    	 triangleKind=nonTriangle;
	         return false;
	    }
    }
	public static void main(String args[])
	{
		int a = 12;
		TriangleKind triangle = new TriangleKind();
		System.out.println("三角形(5, 7, 6)是"+triangle.getTriangleKind(5, 7, 6));
		System.out.println("三角形(5, 5, 5)是"+triangle.getTriangleKind(5, 5, 5));
		/*System.out.println("三角形(5, 5, 6)是"+triangle.getTriangleKind(5, 5, 6));*/
		System.out.println("三角形(-2, 2, 3)是"+triangle.getTriangleKind(-2, 2, 3));
		System.out.println("三角形(1, 2, 3)是"+triangle.getTriangleKind(1, 2, 3));
	}
}
