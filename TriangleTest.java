package tju.junit.triangle;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class TriangleTest {
	private int a;
	private int b;
	private int c;
	private String expected;
	private TriangleKind triangle;
	
	public TriangleTest(String expected,int a, int b,int c)
	{
		this.expected = expected;
		this.a = a;
		this.b = b;
		this.c = c;
	}
	
	@Before
	public void setUp() throws Exception {
		System.out.println("���Կ�ʼ�ˣ�");
		triangle = new TriangleKind();
		System.out.println("triangle���󱻳�ʼ����");
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("triangle���󽫱�����");
		triangle = null;
		System.out.println("���Խ�����");
	}
	
	@Parameters
	public static Collection<Object[]> getData()
	{
		return Arrays.asList(new Object[][]
				{
					{"�ȱ�������",2,2,2},
					{"�ȱ�������",6,6,6},
					{"����������",5,2,5},
					{"����������",2,2,3},
					{"����������",8,7,7},
		/*			{"���ȱ�������",5,3,6},
					{"��������",1,2,3},
					{"��������",-2,-3,4},*/
				});	
	}
	

	//���Ը����������߹��ɵ��������Ƿ����ڴ�ֵһ��
	@Test
	public void testGetTriangleKind() {

		assertEquals(this.expected, triangle.getTriangleKind(a, b, c));
	}

}
