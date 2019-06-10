public class Table {
	private int num = 0;
	private Object[] keys = new Object[10];
	private Object[] data = new Object[10];
	private boolean[] used = new boolean[10];

	public Table() {
		for (int i = 0; i < 10; i++)
			used[i] = false;
	}

	private int hash(Object key) {
		return Math.abs(key.hashCode()) % data.length;
	}

	public void put(Object key, Object obj) throws Exception {
		if (num == data.length)
			throw new Exception("Table    is    full");
		int idx = findIndex(key);
		if (idx != -1) {
			data[idx] = obj;
		} else {
			idx = hash(key);
			while (used[idx])
				idx = ((idx + 1) == data.length) ? 0 : (idx + 1);
			keys[idx] = key;
			data[idx] = obj;
			used[idx] = true;
			num++;
		}
	}

	private    int    findIndex(Object    key){
		int    idx    =    hash(key);
		int    count    =    0;
		while(used[idx]&    count<data.length){
			if(key.equals(keys[idx]))    return    idx;
			else    idx    =    ((idx+1)==data.length)?0:(idx+1);
			count    ++;
			}
		return  -1;
		}
	
	

	public static void main(String[] args) throws Exception {
		Table tb = new Table();
		tb.put(1, "obj1");
		tb.put(10, "obj10");
		tb.put(20, "obj20");
		
		
	}
}