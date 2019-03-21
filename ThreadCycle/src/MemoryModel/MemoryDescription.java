package MemoryModel;

public class MemoryDescription {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i = 5;
		Object obj = new Object();
		MemoryDescription memory = new MemoryDescription();
		memory.localMemory(obj);
	}
	public void localMemory(Object obj) {
		String str=obj.toString();
		System.out.println(str);
	}

}
/*
 * Load all runtime classes in heap space
 * line 5: main() one thread block is created in stack  
 * line 7: store i in stack (local variable)
 * line 8: Creating object stores in heap (remains till application)
 * line 9: memory object stores in heap sapce
 * line 10:create one block for method localMemory() in stack(LIFO)
 * line 12:String pool in heap will be created and stores the value of str which is 
 * the value of obj.
 */