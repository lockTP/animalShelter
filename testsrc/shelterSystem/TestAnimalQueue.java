package shelterSystem;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

import org.hamcrest.core.IsInstanceOf;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class TestAnimalQueue {
	
	//To test Cat queue input and output an item.
	//Input a Cat and output a Cat.
	@Test
	public void TestCatQueue1(){
		AnimalQueue animalQueue= new  AnimalQueue();
		Cat cat1 = mock(Cat.class);
		animalQueue.enqueue(cat1);
		assertEquals(cat1, animalQueue.dequeueCats());
	}
	
	//To test Dog queue input and output an item.
	//Input a Dog and output a Dog.
	@Test
	public void TestDogQueue1(){
		AnimalQueue animalQueue= new  AnimalQueue();
		Dog dog1 = mock(Dog.class);
		animalQueue.enqueue(dog1);
		assertEquals(dog1, animalQueue.dequeueDogs());
	}
	

	//To test Cat queue input and output a cat.
	//Input a cat and a dog, then dequeueCat, result should be a cat
	@Test
	public void TestCatQueue2(){
		AnimalQueue animalQueue = new AnimalQueue();
		Cat cat1 = mock(Cat.class);
		Dog dog1 = mock(Dog.class);
		animalQueue.enqueue(cat1);
		animalQueue.enqueue(dog1);
		assertTrue((animalQueue.dequeueCats() instanceof Cat));
	}
	
	//To test Dog queue input and output a dog.
	//Input a cat and a dog, then dequeueDog, result should be a dog.
	@Test
	public void TestDogQueue2(){
		AnimalQueue animalQueue = new AnimalQueue();
		Cat cat1 = mock(Cat.class);
		Dog dog1 = mock(Dog.class);
		animalQueue.enqueue(cat1);
		animalQueue.enqueue(dog1);
		assertTrue((animalQueue.dequeueDogs() instanceof Dog));
	}
	
	//To test an empty cat queue.
	//Output a cat from an empty Cat queue, the result should be null.
	@Test
	public void TestEmptyCatQueue(){
		AnimalQueue animalQueue = new AnimalQueue();
//		Cat cat1 = mock(Cat.class);
//		animalQueue.enqueue(cat1);
		assertTrue(null==animalQueue.dequeueCats());
//		assertTrue((animalQueue.dequeueCats() instanceof Cat));
	}
	
	//To test an empty dog queue.
	//Output a dog from an empty Dog queue, the result should be null.
	@Test
	public void TestEmptyDogQueue(){
		AnimalQueue animalQueue = new AnimalQueue();
//		Dog dog1 = mock(Dog.class);
//		animalQueue.enqueue(dog1);
		assertTrue(null==animalQueue.dequeueDogs());
//		assertTrue((animalQueue.dequeueDogs() instanceof Dog));
	}
	
	//To test DequeueAny method is correct.
	//Input a Cat and a dog, then dequeueAny, result should be first input animal.
	@Test
	public void TestDequeAny1(){
		AnimalQueue animalQueue= new AnimalQueue();
		Cat cat1= new Cat("Cat1");
		Dog dog1= new Dog("Dog1");
		animalQueue.enqueue(cat1);
		animalQueue.enqueue(dog1);
		assertEquals(cat1, animalQueue.dequeueAny());
	}
	
	//To test DequeueAny method is correct when multiple objects have been added.
	//Input a 2 Cats and 1 dog, then dequeueAny, result should be first input animal, second input animal, third input animal.
	@Test
	public void TestDequeAny2(){
		AnimalQueue animalQueue= new AnimalQueue();
		Cat cat1= new Cat("Cat1");
		Cat cat2= new Cat("Cat2");
		Dog dog1= new Dog("Dog1");
		animalQueue.enqueue(cat1);
		animalQueue.enqueue(cat2);
		animalQueue.enqueue(dog1);
		assertEquals(cat1, animalQueue.dequeueAny());
		assertEquals(cat2, animalQueue.dequeueAny());
		assertEquals(dog1, animalQueue.dequeueAny());
	}
	
	//To test DequeueAny method is correct when multiple objects have been added.
	//Input a 2 Cats and 1 dog, then dequeueAny, result should be first input animal, second input animal, third input animal.
	@Test
	public void TestDequeAny3(){
		AnimalQueue animalQueue= new AnimalQueue();
		Cat cat1= new Cat("Cat1");
		Dog dog1= new Dog("Dog1");
		Cat cat2= new Cat("Cat2");
		animalQueue.enqueue(cat1);
		animalQueue.enqueue(dog1);
		animalQueue.enqueue(cat2);
		assertEquals(cat1, animalQueue.dequeueAny());
		assertEquals(dog1, animalQueue.dequeueAny());
		assertEquals(cat2, animalQueue.dequeueAny());
	}
	
	//To test DequeueDog method is correct when a Cat was input before a Dog.
	//Input a 2 Cats and 1 dog, then dequeueDog, result should be first input dog and ignore cat if cat was input first.
	@Test
	public void TestDequeDog1(){
		AnimalQueue animalQueue= new AnimalQueue();
		Cat cat1= new Cat("Cat1");
		Dog dog1= new Dog("Dog1");
		Cat cat2= new Cat("Cat2");
		animalQueue.enqueue(cat1);
		animalQueue.enqueue(dog1);
		animalQueue.enqueue(cat2);
		assertEquals(dog1, animalQueue.dequeueDogs());
	}
	
	//To test DequeueCat method is correct when a Dog was input before a Cat.
	//Input a 2 Cats and 1 dog, then dequeueCat, result should be first input cat and ignore dog if dog was input first.
	@Test
	public void TestDequeCat1(){
		AnimalQueue animalQueue= new AnimalQueue();
		Dog dog1= new Dog("Dog1");
		Cat cat1= new Cat("Cat1");
		Cat cat2= new Cat("Cat2");
		animalQueue.enqueue(dog1);
		animalQueue.enqueue(cat1);
		animalQueue.enqueue(cat2);
		assertEquals(cat1, animalQueue.dequeueCats());
	}
	
	//To test when Cat queue is empty, the dequeueAny method can output a dog.
	//Input a dog, the dequeueAny, the result should be a dog.
	@Test
	public void TestEmptyCatQueue2(){
		AnimalQueue animalQueue = new AnimalQueue();
		Dog dog1 = mock(Dog.class);
		animalQueue.enqueue(dog1);
		assertTrue(animalQueue.dequeueAny() instanceof Dog);
	}
	
	//To test when Dog queue is empty, the dequeueAny method can output a Cat.
	//Input a Cat, the dequeueAny, the result should be a Cat.
	@Test
	public void TestEmptyDogQueue2(){
		AnimalQueue animalQueue = new AnimalQueue();
		Cat cat1 = mock(Cat.class);
		animalQueue.enqueue(cat1);
		assertTrue(animalQueue.dequeueAny() instanceof Cat);
	}
	
	//To test Enqueue method is still working after several Dequeues. 
	//Input several animals, then do the Dequeue and the Enqueue.
	@Test
	public void TestDequeueAndEnqueue1(){
		AnimalQueue animalQueue = new AnimalQueue();
		Cat cat1 = new Cat("cat1");
		Cat cat2 = new Cat("cat2");
		Cat cat3 = new Cat("cat3");
		animalQueue.enqueue(cat1);
		animalQueue.dequeueCats();
		animalQueue.enqueue(cat2);
		animalQueue.enqueue(cat3);
		assertEquals(cat2, animalQueue.dequeueCats());
	}
	
	//To test Enqueue method is still working after several Dequeues. 
	//Input several animals, then do the Dequeue and the Enqueue.
	@Test
	public void TestDequeueAndEnqueue2(){
		AnimalQueue animalQueue = new AnimalQueue();
		Dog dog1 = new Dog("dog1");
		Dog dog2 = new Dog("dog2");
		Dog dog3 = new Dog("dog3");
		animalQueue.enqueue(dog1);
		animalQueue.dequeueDogs();
		animalQueue.enqueue(dog2);
		animalQueue.enqueue(dog3);
		assertEquals(dog2, animalQueue.dequeueDogs());
	}
	
	//To test Enqueue method is still working after several Dequeues. 
	//Input several animals, then do the Dequeue and the Enqueue.
	@Test
	public void TestDequeueAndEnqueue3(){
		AnimalQueue animalQueue = new AnimalQueue();
		Dog dog1 = new Dog("dog1");
		Cat cat1 = new Cat("cat1");
		Dog dog2 = new Dog("dog2");
		animalQueue.enqueue(dog1);
		animalQueue.dequeueDogs();
		animalQueue.enqueue(cat1);
		animalQueue.enqueue(dog2);
		assertEquals(cat1, animalQueue.dequeueAny());
	}
	
	//To test Enqueue method is still working after several Dequeues. 
	//Input several animals, then do the Dequeue and the Enqueue.
	@Test
	public void TestDequeueAndEnqueue4(){
		AnimalQueue animalQueue = new AnimalQueue();
		Dog dog1 = new Dog("dog1");
		Cat cat1 = new Cat("cat1");
		Dog dog2 = new Dog("dog2");
		animalQueue.enqueue(dog1);
		animalQueue.dequeueDogs();
		animalQueue.enqueue(cat1);
		animalQueue.enqueue(dog2);
		assertEquals(cat1, animalQueue.dequeueCats());
	}
	
	//To test Enqueue method is still working after several Dequeues. 
	//Input several animals, then do the Dequeue and the Enqueue.
	@Test
	public void TestDequeueAndEnqueue5(){
		AnimalQueue animalQueue = new AnimalQueue();
		Dog dog1 = new Dog("dog1");
		Cat cat1 = new Cat("cat1");
		Dog dog2 = new Dog("dog2");
		animalQueue.enqueue(dog1);
		animalQueue.dequeueDogs();
		animalQueue.enqueue(cat1);
		animalQueue.enqueue(dog2);
		assertEquals(dog2, animalQueue.dequeueDogs());
	}
	
	//To test the output order of queues is correct.
	//Input several animals, the do the three kinds of dequeue methods, the output order should be correct.
	@Test
	public void TestDequeueOrder(){
		AnimalQueue animalQueue = new AnimalQueue();
		Cat cat1 = new Cat("cat1");
		Cat cat2 = new Cat("cat2");
		Cat cat3 = new Cat("cat3");
		Dog dog1 = new Dog("dog1");
		Dog dog2 = new Dog("dog2");
		animalQueue.enqueue(cat1);
		animalQueue.enqueue(cat2);
		animalQueue.enqueue(dog1);
		animalQueue.enqueue(cat3);
		animalQueue.enqueue(dog2);
		assertEquals(cat1, animalQueue.dequeueAny());
		assertEquals(dog1, animalQueue.dequeueDogs());
		assertEquals(cat2, animalQueue.dequeueCats());
		assertEquals(cat3, animalQueue.dequeueAny());
		assertEquals(null, animalQueue.dequeueCats());
		assertEquals(dog2, animalQueue.dequeueAny());
	}
	
	//To test after dequeuing from an empty queue, the enqueue and dequeue methods are still working.
	//Output a cat from an empty queue, then input several animals, the queues should still working.
	@Test
	public void TestEmptyCatQueueWoking(){
		AnimalQueue animalQueue = new AnimalQueue();
		animalQueue.dequeueCats();
		Cat cat1 = mock(Cat.class);
		animalQueue.enqueue(cat1);
		assertTrue(animalQueue.dequeueCats() instanceof Cat);
	}
	
	//To test after dequeuing from an empty queue, the enqueue and dequeue methods are still working.
	//Output a dog from an empty queue, then input several animals, the queues should still working.
	@Test
	public void TestEmptyDogQueueWoking(){
		AnimalQueue animalQueue = new AnimalQueue();
		animalQueue.dequeueCats();
		Dog dog1 = mock(Dog.class);
		animalQueue.enqueue(dog1);
		assertTrue(animalQueue.dequeueDogs() instanceof Dog);
	}
	
	//To test after dequeuing from an empty queue, the enqueue and dequeue methods are still working.
	//Output any animal from an empty queue, then input several animals, the queues should still working.
	@Test
	public void TestEmptyQueueWoking(){
		AnimalQueue animalQueue = new AnimalQueue();
		animalQueue.dequeueAny();
		Dog dog1 = mock(Dog.class);
		animalQueue.enqueue(dog1);
		assertTrue(animalQueue.dequeueAny() instanceof Dog);
	}
	
}
