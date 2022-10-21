//https://www.geeksforgeeks.org/search-almost-sorted-array/
//https://www.youtube.com/watch?v=W3-KgsCVH1U&list=PL_z_8CaSLPWeYfhtuKHj-9MpYb6XQJ_f2&index=9
import java.io.*;
 
class GFG {
    // A recursive binary search based function.
    // It returns index of x in given array
    // arr[l..r] is present, otherwise -1
    int binarySearch(int arr[], int l, int r, int x)
    {
        if (r >= l) {
            int mid = l + (r - l) / 2;
 
            // If the element is present at
            // one of the middle 3 positions
            if (arr[mid] == x)
                return mid;
            if (mid > l && arr[mid - 1] == x)
                return (mid - 1);
            if (mid < r && arr[mid + 1] == x)
                return (mid + 1);
 
            // If element is smaller than mid, then
            // it can only be present in left subarray
            if (arr[mid] > x)
                return binarySearch(arr, l, mid - 2, x);
 
            // Else the element can only be present
            // in right subarray
            return binarySearch(arr, mid + 2, r, x);
        }
 
        // We reach here when element is
        // not present in array
        return -1;
    }
 
    // Driver code
    public static void main(String args[])
    {
        GFG ob = new GFG();
        int arr[] = { 3, 2, 10, 4, 40 };
        int n = arr.length;
        int x = 4;
        int result = ob.binarySearch(arr, 0, n - 1, x);
        if (result == -1)
            System.out.println(
                "Element is not present in array");
        else
            System.out.println(
                "Element is present at index " + result);
    }
}