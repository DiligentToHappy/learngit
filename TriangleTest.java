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
		System.out.println("测试开始了！");
		triangle = new TriangleKind();
		System.out.println("triangle对象被初始化！");
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("triangle对象将被清理！");
		triangle = null;
		System.out.println("测试结束！");
	}
	
	@Parameters
	public static Collection<Object[]> getData()
	{
		return Arrays.asList(new Object[][]
				{
					{"等边三角形",2,2,2},
					{"等边三角形",6,6,6},
					{"等腰三角形",5,2,5},
					{"等腰三角形",2,2,3},
					{"等腰三角形",8,7,7},
		/*			{"不等边三角形",5,3,6},
					{"非三角形",1,2,3},
					{"非三角形",-2,-3,4},*/
				});	
	}
	

	//测试给定的三条边构成的三角形是否与期待值一样
	@Test
	public void testGetTriangleKind() {

		assertEquals(this.expected, triangle.getTriangleKind(a, b, c));
	}

}
