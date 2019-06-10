public class MyBag<E> {
	public E[] data = null;
	public int num = 0;

	public MyBag() {
		data = (E[]) new Object[2];
		num = 0;
	}

	private void ensureCapacity(int minimumCapacity) {
		if (minimumCapacity <= data.length)
			return;
		else {
			E[] newData = (E[]) new Object[minimumCapacity];
			System.arraycopy(data, 0, newData, 0, num);
			data = newData;
		}
	}

	public void add(E a) {
		if (num == data.length)
			ensureCapacity((data.length + 1) * 2);
		data[num++] = a;
	}

	public    boolean    f(E    a){
		if(a==null)    return    false;
		int    i=0,    oldnum    =    num;
		while(i<num){
			if(data[i].equals(a))    {
				
				data[i]=data[num - 1];    
			num-­;
			}
			else    
				i++;
			}
		if(oldnum==num)    return    false;else    return    true;}

	public static void main(String[] args) {
		MyBag<Integer> bag1 = new MyBag<Integer>();
		bag1.add(2);
		bag1.add(3);
		bag1.add(2);
		bag1.add(4);
		bag1.add(5);
		bag1.f(2);
	}

}