//There are two sorted arrays nums1 and nums2 of size m and n respectively.
//Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).

///Example 1:
//nums1 = [1, 3]
//nums2 = [2]

//The median is 2.0

//Example 2:
//nums1 = [1, 2]
//nums2 = [3, 4]

//The median is (2 + 3)/2 = 2.5

import java.util.Arrays;

public class MedianOfTwoSortedArray {
	// Always arr1 will be less than arr2 in size
	public static double findMedianSortedArrays(int[] arr1, int[] arr2) {
		double median = 0.0;
		int m = arr1.length;
		int n = arr2.length;
		// no elements in both the array, return -1
		if (m == 0 && n == 0)
			return -1;
		
		// no elements in first array, return median of second array
		else if (m == 0)
			median = MedianOf1(arr2, n);
		
		// 1 elements in both the array -> avg of both
		else if (m == 1 && n == 1)
			median = avg(arr1[0], arr2[0]);
		
		// 1 element in first array A, second array B size is odd
		else if (m == 1 && n % 2 != 0) {
			
			// a[0] less than B[mid-1] -> avg of B[mid-1] & B[mid]
			if (arr1[0] <= arr2[(n / 2) - 1])
				median = avg(arr2[(n / 2) - 1], arr2[n / 2]);
			
			// a[0] is in between than B[mid-1] & B[mid] -> avg of A[0] & B[mid]
			else if (arr1[0] > arr2[(n / 2) - 1] && arr1[0] <= arr2[(n / 2)])
				median = avg(arr1[0], arr2[n / 2]);
			
			// a[0] is in between than B[mid] & B[mid+1] -> avg of B[mid] & A[0]
			else if (arr1[0] > arr2[(n / 2)] && arr1[0] <= arr2[(n / 2)+1])
				median = avg(arr2[n / 2], arr1[0]);
			
			// a[0] is greater than B[mid+1] -> avg of B[mid] & B[mid+1]
			else if (arr1[0] > arr2[(n / 2)+1])
				median = avg(arr2[n / 2], arr2[(n / 2) + 1]);
		}
		
		// 1 element in first array A, second array B size is even
		else if (m == 1 && n % 2 == 0) {
			
			// a[0] less than B[mid-1] -> B[mid-1]
			if (arr1[0] <= arr2[(n / 2) - 1])
				median = arr2[(n / 2) - 1];
			
			// a[0] is in between than B[mid-1] & B[mid] -> A[0]
			else if (arr1[0] > arr2[(n / 2) - 1] && arr1[0] <= arr2[(n / 2)])
				median = arr1[0];
			
			// a[0] is in between than B[mid] & B[mid+1] -> B[mid]
			else if (arr1[0] > arr2[(n / 2)] && arr1[0] <= arr2[(n / 2)+1])
				median = arr2[n / 2];
		}
		
		// 2 elements in both the array
		else if (m == 2 && n == 2) 
			median = MedianOf4(arr1[0],arr1[1],arr2[0],arr2[1]);	
				
		// 2 element in first array, second array B size is odd
        // then median will be one of the following 3 elements
        // 1. Middle element of larger array
        // 2. Max of first element of smaller array and element
        //    just before the middle in bigger array
        // 3. Min of second element of smaller array and element
        //    just after the middle in bigger array
		else if (m == 2 && n % 2 != 0) 
			median = MedianOf3(arr2[n/2], Math.max(arr1[0], arr2[(n/2)-1]), Math.min(arr1[1], arr2[(n/2)+1]));	
				
		// 2 element in first array, second array B size is even
        // then median will be one of the following 4 elements
        // 1) & 2) The middle two elements of larger array
        // 3) Max of first element of smaller array and element
        //    just before the first middle element in bigger array
        // 4. Min of second element of smaller array and element
        //    just after the second middle in bigger array
		else if (m == 2 && n % 2 == 0) 
			median = MedianOf4(arr2[n/2], arr2[(n/2) - 1], Math.max(arr1[0], arr2[(n/2)-2]), Math.min(arr1[1], arr2[(n/2)+1]));	
		
		// recursion for others
		else{
			
			/* if A[mid] <= B[mid], then median must exist in
	        A[from mid....] and B[....till mid] */
			int adjm = m%2 == 0 ? (m/2)-1 : m/2;
			int adjn = n%2 == 0 ? (n/2)-1 : n/2;
			if(arr1[adjm] <= arr2[adjn]){
				int[] a1 = Arrays.copyOfRange(arr1, adjm, arr1.length);
				int[] a2 = Arrays.copyOfRange(arr2, 0, arr2.length-adjm);
				// To make ar1 array always smaller than ar2
				int[] ar1 = a1.length <= a2.length ? a1 : a2;
				int[] ar2 = a2.length >= a1.length ? a2 : a1;
				return findMedianSortedArrays(ar1, ar2);				
			}
			
			/* if A[mid] > B[mid], then median must exist in
	        A[till mid....] and B[....from mid] */
			else{

				int[] a1 = Arrays.copyOfRange(arr1, 0, arr1.length-adjn);
				int[] a2 = Arrays.copyOfRange(arr2, adjn, arr2.length);
				// To make ar1 array always smaller than ar2
				int[] ar1 = a1.length <= a2.length ? a1 : a2;
				int[] ar2 = a2.length >= a1.length ? a2 : a1;
				return findMedianSortedArrays(ar1, ar2);
			}				
			
		}
		
		return median;
	}

	public static double avg(int a, int b) {
		return (double) (a + b) / 2.0;
	}

	public static double MedianOf1(int[] arr, int n) {
		if (n % 2 == 0)
			return (double) avg(arr[n / 2], arr[(n / 2) - 1]);
		else
			return arr[n / 2];
	}
	
	public static double MedianOf4(int a, int b, int c, int d) {
		int min = Math.min(a, Math.min(b, Math.min(c, d)));
		int max = Math.max(a, Math.max(b, Math.max(c, d)));
		return (double)(a+b+c+d - min - max)/2.0;
	}
	public static double MedianOf3(int a, int b, int c) {
		int min = Math.min(a, Math.min(b, c));
		int max = Math.max(a, Math.max(b, c));
		return (double)(a+b+c - min - max);
	}

	public static void main(String[] args) {
		int[] nums1 = {1, 3, 5, 7, 9};
		int[] nums2 = {11, 13, 15};
		// To make arr1 array always smaller than arr2
		int[] arr1 = nums1.length <= nums2.length ? nums1 : nums2;
		int[] arr2 = nums2.length >= nums1.length ? nums2 : nums1;
		System.out.println(findMedianSortedArrays(arr1, arr2));
	}

}
