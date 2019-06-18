package search;

public class BinarySearch {

	public int search_i(int arr[],int n, int target) {
		
		int left =0,right=n;
		int mid=0;
		
		while(left<=right) {
			mid=(left+right)/2;
			
			if(arr[mid]>target)
				right = mid-1;
			else if(arr[mid]<target)
				left = mid+1;
			else
				return mid;
		}
		
		return -1;
	}
	
	public int search_r(int arr[],int n, int target) {
		return search_r(arr, 0, n, target);
	}
	
	private int search_r(int arr[],int left, int right, int target) {
		
		if(left<=right) {
			int mid=(left+right)/2;
			
			if(arr[mid]>target)
				return search_r(arr, left, mid-1, target);
			else if(arr[mid]<target)
				return search_r(arr, mid+1, right, target);
			else
				return mid;
		}
		return -1;
	}
	
	public int ceil(int arr[], int n, int target) {
		
		int left=0,right=n;
		int mid=0;
		
		while(left<=right) {
			mid=(left+right)/2;
			
			if(arr[mid]>target) {
				if(mid==0 || arr[mid-1]<target)
					return mid;
				
				right=mid-1;
			}
			else if(arr[mid]<target) {				
				left=mid+1;
			}
			else
				return mid;
		}
		
		return -1;
	}
	
	public int floor(int arr[], int n, int target) {
		
		int left=0,right=n;
		int mid=0;
		
		while(left<=right) {
			mid=(left+right)/2;
			
			if(arr[mid]>target) {
				right=mid-1;
			}
			else if(arr[mid]<target) {
				if(mid==n || arr[mid+1]>target)
					return mid;
				
				left=mid+1;
			}
			else
				return mid;
		}
		
		return -1;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int arr[]= {1,4,9,16,25,36,49,64,81,100};
		int n=arr.length-1;
		
		BinarySearch b=new BinarySearch();
		
		int target=17;
		
		System.out.println(b.floor(arr, n, target));

	}

}
