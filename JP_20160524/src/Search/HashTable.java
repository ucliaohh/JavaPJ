package Search;

public class HashTable {
	
	private final int tablesize = 10;
	
	private static class ChainNode {
		protected int key;
		protected ChainNode next;

		private ChainNode(int key) {
			this.key = key;
			this.next = null;
		}
	}

	private int Search_HashTable(int[] ht, int key)
	{
		int address = key % tablesize;
		int comparetimer = 0;   //avoid the loop of death

		while(comparetimer < tablesize && ht[address] != key && ht[address] != 0)
		{
			comparetimer ++; 
			address = (address + 1) % tablesize;   //*****sequence probing*****
		}

		return address;   //no match if ht[address] = 0
	}

	private int Insert_HashTable(int[] ht, int key)
	{
		int address = Search_HashTable(ht, key);
		if(ht[address] == 0)
		{
			ht[address] = key;
			return 1;   //insert success
		}
		else
			return 0;   //the key has been insert into the hashtable yet, or the HashTable is full
	}
	
	////ChainNode
	private ChainNode[] pht = new ChainNode[tablesize];

	private ChainNode[] Search_HashTable(int key)
	{	
		int address = key % tablesize;
		
		ChainNode[] ppf = {new ChainNode(0), new ChainNode(0)};
		ppf[0] = pht[address];       //pf
		ppf[1] = pht[address].next;  //p

		while(ppf[1] != null && ppf[1].key != key)
		{
			ppf[0] = ppf[1];
			ppf[1] = ppf[0].next;
		}	
		return ppf;
	}

	private int Insert_HashTable(int key)
	{
		ChainNode[] pnode = Search_HashTable(key);
		if(pnode[1] == null)
		{
			pnode[0].next = new ChainNode(key);
			return 1;  //insert success
		}
		else
			return 0;  //the key has been insert into the hashtable yet
	}
	
	public static void main(String[] args) {
        HashTable bHash = new HashTable();
        int[] TestData = {25,36,39,47,20,58,16,35};
        int[] ht = new int[bHash.tablesize];
        for(int i = 0; i < bHash.tablesize; i++)
        	ht[0] = 0;
        for(int i = 0; i < TestData.length; i++)
        {
        	System.out.print(bHash.Insert_HashTable(ht, TestData[i]) + " ");
        }
        System.out.print("\r\n" + ht[bHash.Search_HashTable(ht, 25)]);
        System.out.print("\r\n" + ht[bHash.Search_HashTable(ht, 35)] + "\r\n");
        
    	for(int i = 0; i < bHash.tablesize; i++)
    		bHash.pht[i] = new ChainNode(0);
    	
    	int datanum = 20;
    	int[] data = new int[]{25,36,39,47,20,58,16,35,56,26,67,18,9,20,32,6,97,98,34,29};
    	for(int i = 0; i < datanum; i++)
    		System.out.print(bHash.Insert_HashTable(data[i]) + " ");
 
    	if(bHash.Search_HashTable(25) != null)
    	   System.out.print("\r\n" + bHash.Search_HashTable(25)[1].key);
    	if(bHash.Search_HashTable(35) != null)
           System.out.print("\r\n" + bHash.Search_HashTable(35)[1].key);
	}
}