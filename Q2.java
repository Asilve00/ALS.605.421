import java.util.Vector;

 public class Q2 <E extends Comparable<E>> implements Cloneable{

	private Vector<E> stackA;
	private Vector<E> stackB;
	private char IDa = 'A', IDb = 'B', IDo = ' ';

	public Q2(){
		setStackA();
		setStackB();
	}
	public Q2(Vector<E> a, Vector<E> b){
	
		stackA = a;
		stackB = b;

		}
	public char ID(Vector<E> v){
		if(v==stackA){
			return IDa;
		}
		
		if(v==stackB){
			return IDb;
		}
		return IDo;
	}

	public void PushA(E a){
		stackA.insertElementAt(a,0);
	}
	
	public void PushB(E b){
		stackB.insertElementAt(b,0);
	}
	
	public void multiPush(E a[],E b[]){
		multiPushA(a);
		multiPushB(b);
	}
	private void multiPushA(E a[]){
		int i = 0;
		while(i<a.length){
		stackA.insertElementAt(a[i],0);
		i++;
		}
	}
	
	private void multiPushB(E b[]){
		int i = 0;
		while(i<b.length){
			
		stackB.insertElementAt(b[i],0);
		i++;
		}
	}
	
	
	private Vector<E> multiPopA(int count){
		Vector<E> pops = new Vector<E>();
		E temp;
		if(count> stackA.size()){
			count = stackA.size();
		}
		while(count>0){
			temp = stackA.firstElement();
			pops.add(temp);
			stackA.removeElement(temp);
			count--;
		}
		return pops;
	}
	
	public void MultiPopA(int count){
		Vector<E> temp = new Vector<E>();
		temp = multiPopA(count);
		printPop(temp);
	}
	
	private Vector<E> multiPopB(int count){
		Vector<E> pops = new Vector<E>();
		E temp;
		if(count> stackB.size()){
			count = stackB.size();
		}
		while(count>0){
			temp = stackB.firstElement();
			pops.add(temp);
			stackB.removeElement(temp);
			count--;
		}
		return pops;
	}
	
	public void MultiPopB(int count){
		Vector<E> temp = new Vector<E>();
		temp = multiPopB(count);
		printPop(temp);
	}
	

	
	public void printS(Vector<E> v){
		int i = 0;
		if(!v.isEmpty()){
		System.out.print("--TOP OF STACK--\n");
		while(i<v.size()){
		
			System.out.println(v.elementAt(i));
			i++;
		}
		System.out.print("-------------\n");
		}else{
			System.out.print("The stack is empty.");
		}
	}
	public void printPop(Vector<E> v){
		int i = 0;
		if(!v.isEmpty()){
		System.out.print("[ ");
		while(i<v.size()){
			System.out.print(v.elementAt(i) + " ");
			i++;
		}
			System.out.print("]\n");
		}
	}

	public void Transfer(char c, int count){
		if(c == 'A'){
			
		transferA(count);
		}else{
			if(c == 'B'){
				transferB(count);
			}
		}
	}
	
	private void transferA(int count){
	//Stack A is Pop Stack
	int n;
	n = stackA.size();
	E temp;
	if(n<count){
		count = n;
	}
	while(count!=0){
		temp = stackA.firstElement();
		PushB(temp);
		stackA.remove(temp);
		count--;
	}
	printS(stackB);	
}
private void transferB(int count){
	//Stack B is Pop Stack
	int n;
	E temp;
	n = getStackB().size();
	if(n<count){
		count = n;
	}
	while(count!=0){
		temp = stackB.firstElement();
		PushA(temp);
		stackB.remove(temp);
		count--;
	}
	printS(stackA);	
}

public Vector<E> getStackA() {
	return stackA;
}

public void setStackA() {
	this.stackA = new Vector<E>();
}

public Vector<E> getStackB() {
	return stackB;
}

public void setStackB() {
	this.stackB = new Vector<E>();
}
private void clearStacks(){
	stackA.clear();
	stackB.clear();
}
public void endQ2(){
	clearStacks();
}
public void resetStacks(){
	clearStacks();
	setStackA();
	setStackB();
	
}
public boolean empty(){
	boolean ept=false;
	if(stackA.isEmpty()){
		ept = true;
	}
	if(stackB.isEmpty()){
		ept = true;
	}
	return ept;
}
 
}
