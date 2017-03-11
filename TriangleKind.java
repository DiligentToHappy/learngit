package tju.junit.triangle;

public class TriangleKind {
	private String equilateral="�ȱ�������";
	private String isosceles="����������";
	private String scalene="���ȱ�������";
	private String nonTriangle="��������";
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
		System.out.println("������(5, 7, 6)��"+triangle.getTriangleKind(5, 7, 6));
		System.out.println("������(5, 5, 5)��"+triangle.getTriangleKind(5, 5, 5));
		/*System.out.println("������(5, 5, 6)��"+triangle.getTriangleKind(5, 5, 6));*/
		System.out.println("������(-2, 2, 3)��"+triangle.getTriangleKind(-2, 2, 3));
		System.out.println("������(1, 2, 3)��"+triangle.getTriangleKind(1, 2, 3));
	}
}
