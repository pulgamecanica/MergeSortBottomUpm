public class MergeSort{

	private static boolean less(Integer v, Integer w){
		if (v < w)
			return true;
		else
			return false;
	}

	private static void merge (int[] a, int[] aux, int lo, int mid, int hi) {
		 for (int k = lo; k <= hi; k++)
		 	aux[k] = a[k];
		 int i = lo, j = mid+1;
		 for (int k = lo; k <= hi; k++)
		 {
			 if (i > mid) a[k] = aux[j++];
			 else if (j > hi) a[k] = aux[i++];
			 else if (less(aux[j], aux[i])) a[k] = aux[j++];
			 else a[k] = aux[i++];
		 }
	}

	private static void sort (int[] a) {
		 int N = a.length;
		 int[] aux = new int[N];
		 for (int sz = 1; sz < N; sz = sz+sz)
		 for (int lo = 0; lo < N-sz; lo += sz+sz)
		 merge(a, aux, lo, lo+sz-1, Math.min(lo+sz+sz-1, N-1));
	}
	public static void main (String[] args){ 
		int length = Integer.parseInt(args[1]);
		int[] arr = new int[args.length-1];
		for (int i = 1; i<args.length;i++)
			arr[i-1] = Integer.parseInt(args[i]);
		sort(arr);
		for (int i = 0; i < arr.length; i++)
			System.out.println(arr[i]);	

	}
}