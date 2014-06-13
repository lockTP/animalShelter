package shelterSystem;

import static org.junit.Assert.*;
import org.junit.Test;

public class TestAnimal {
	
	//The input of the animal's name should be correct.
	//Create an animal called Cat1 and check it.
	@Test
	public void TestAnimalNameEqual(){
		Animal animal = new Animal("Cat1");
		String s="Cat1";
		assertEquals(s, animal.name);
	}
	
	//The input of the animal's order should be correct.
	//Create an animal and set it order to 1, then check it.
	@Test
	public void TestAnimalOrder(){
		Animal animal = new Animal("a");
		animal.setOrder(1);
		assertEquals(1, animal.getOrder());
	}
	
	//The animal should equal to itself.
	//Create an animal and check if it equals to itself.
	@Test
	public void TestSelfEqual(){
		Animal a1 = new Animal("Cat1");
		assertEquals(a1,a1);
		
	}

	//Two different animal objects' name should not equal.
	//Create objects Cat1 and Cat2, then check if they are equaled.
	@Test
	public void TestNotEqualName(){
		Animal a1 = new Animal("Cat1");
		Animal a2 = new Animal("Cat2");
		assertFalse(a1.name==a2.name);
		
	}
	
	//Two animals' order should not be equaled.
	//Create objects Cat1 and Cat2, give them different order, then check if they are equaled.
	@Test
	public void TestNotEqualOrder(){
		Animal a1 = new Animal("Cat1");
		Animal a2 = new Animal("Cat2");
		a1.setOrder(1);
		a2.setOrder(2);
		assertFalse(a1.getOrder()==a2.getOrder());
		
	}
	
	//The isOlderThan method is vaild.
	//Create objects Cat1 and Cat2, give them different order, then chekc isOlderThan is working.
	@Test
	public void TestIsOlderThan1(){
		Animal a1 = new Animal("Cat1");
		Animal a2 = new Animal("Cat2");	
		a1.setOrder(1);
		a2.setOrder(2);
		assertEquals(true, a1.isOlderThan(a2));
	}
	
	//The isOlderThan method is vaild.
	//Create objects Cat1 and Cat2, give them same order, then check isOlderThan is working.
	@Test
	public void TestIsOlderThan2(){
		Animal a1 = new Animal("Cat1");
		Animal a2 = new Animal("Cat2");	
		a1.setOrder(2);
		a2.setOrder(2);
		assertEquals(false, a1.isOlderThan(a2));
	}
	
	//The isOlderThan method is vaild.
	//Create objects Cat1 and Cat2, give them different order, then chekc isOlderThan is working.
	@Test
	public void TestIsOlderThan3(){
		Animal a1 = new Animal("Cat1");
		Animal a2 = new Animal("Cat2");	
		a1.setOrder(3);
		a2.setOrder(2);
		assertEquals(false, a1.isOlderThan(a2));
	}
	
	//The animal should equal to itself.
	//Create an animal and check if it equals to itself.
	@Test
	public void TestCatSelfEqual(){
		Cat c1 = new Cat("Cat1");
		assertEquals(true, c1.equals(c1));
	}
	
	//The animal should equal to itself.
	//Create an animal and check if it equals to itself.
	@Test
	public void TestDogSelfEqual(){
		Dog d1 = new Dog("Dog1");
		assertEquals(true, d1.equals(d1));
	}
	
	//Two different Cat objects' name should not equal.
	//Create objects Cat1 and Cat2, then check if they are equaled.
	@Test
	public void TestCatNotEqual(){
		Cat c1 = new Cat("Cat1");
		Cat c2 = new Cat("Cat2");
		assertEquals(false, c1.equals(c2));
	}
	
	//Two different Dog objects' name should not equal.
	//Create objects Dog1 and Dog2, then check if they are equaled.
	@Test
	public void TestDogNotEqual(){
		Dog d1 = new Dog("Dog1");
		Dog d2 = new Dog("Dog2");
		assertEquals(false, d1.equals(d2));
	}
	//Two different kind of animal should not equal.
	//Create object Cat1 and Dog1, then check if they are equaled.
	@Test
	public void TestDogAndCatNotEqual(){
		Cat c1 = new Cat("Cat1");
		Dog d1 = new Dog("Dog1");
		assertEquals(false, c1.equals(d1));
		
	}
	
}
