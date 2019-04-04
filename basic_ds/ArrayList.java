package basic_ds;

public class ArrayList {

	final static int DEFAULT_SIZE = 100;
	final static double increaseFactor=0.75;
	private int currentIndex;
	public int arr[];
	public int size;
	
	
	ArrayList()
	{
		this(DEFAULT_SIZE);
		size = DEFAULT_SIZE;
		this.currentIndex=0;
	}
	ArrayList(int size)
	{
		this.size=size;
		this.arr=new int[size];
		this.currentIndex=0;
	}
	ArrayList(int arr[])
	{
		this.size=arr.length;
		this.arr=arr;
		this.currentIndex=this.size;
	}
	
	public boolean add(int element)
	{
		if(this.currentIndex>increaseFactor*this.size)
			doubleElement();
		
		this.arr[this.currentIndex]=element;
		this.currentIndex++;
		
		return true;
	}
	public boolean addAt(int atIndex, int element) 
	{
		if (atIndex<0)
			return false;
		
		if(this.currentIndex>increaseFactor*this.size)
			doubleElement();
		
		for(int i=this.currentIndex-1;i>atIndex;i--)
			this.arr[i+1]=this.arr[i];
		
		this.arr[atIndex]=element;
		this.currentIndex++;
		
		return true;
	}
	
	public int removeAt(int atIndex) 
	{
		if (atIndex<0)
			return -1;
		
		int element=this.arr[atIndex];
		
		for(int i=atIndex;i<this.currentIndex-1;i++)
			this.arr[i]=this.arr[i+1];
		
		this.currentIndex--;
		this.arr[this.currentIndex]=0;
		
		return element;
	}
	
	public boolean remove(int element)
	{
		return this.remove(element,false);
	}
	
	public boolean remove(int element, boolean fromEnd) 
	{
		if(fromEnd)
		{
			for(int i=this.currentIndex-1;i>=0;i--)
			{
				if(this.arr[i]==element)
				{
					this.removeAt(i);
					return true;
				}
			}
		}
		else
		{
			for(int i=0;i<=this.currentIndex-1;i++)
			{
				if(this.arr[i]==element)
				{
					this.removeAt(i);
					return true;
				}
			}
		}
		
		return false;
	}
	
	public boolean contains(int element)
	{
		for(int i=0;i<=this.currentIndex-1;i++)
		{
			if(this.arr[i]==element)
				return true;
		}
		
		return false;
	}
	
	public int searchIndex(int element)
	{
		return this.searchIndex(element,false);
	}
	
	public int searchIndex(int element, boolean fromEnd)
	{
		if(fromEnd)
		{
			for(int i=this.currentIndex-1;i>=0;i--)
			{
				if(this.arr[i]==element)
					return i;
			}
		}
		else
		{
			for(int i=0;i<=this.currentIndex-1;i++)
			{
				if(this.arr[i]==element)
					return i;
			}
		}
		
		return -1;
	}
	public boolean update(int index,int element)
	{
		if(index<0 || index>=this.currentIndex)
			return false;
		
		this.arr[index]=element;
		
		return true;
	}
	
	// utility methods
	private void doubleElement()
	{
		int arr[]=new int[2*this.size];
		
		for(int i=0;i<this.size;i++)
		{
			arr[i]=this.arr[i];
		}
		
		this.arr=arr;
		this.size=2*this.size;
	}
	
	private void traverse()
	{
		for(int i=0;i<=this.currentIndex+1;i++)
			System.out.print(this.arr[i]+" ");
		
		System.out.println();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ArrayList arr=new ArrayList(4);
		arr.add(1);
		arr.add(2);
		arr.add(3);
		
		//System.out.println(arr.size);
		arr.add(4);
		arr.add(4);
		
		
		System.out.println(arr.update(3,5));
		System.out.println(arr.contains(0));
		arr.traverse();
	}

}
