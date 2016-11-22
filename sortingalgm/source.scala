
class Sorting {
	// quicksort
      def quicksort(str: String): String = {
      	  var arr = str.toCharArray()
		  new String(qksort(arr, 0, arr.length-1))
      }

      def qksort(str: Array[Char], start: Int, end: Int): Array[Char] = {
      	  if (start < end) {
	        var p = partition(str, start, end)
	        // println("p = "+p)
	        // str.foreach(printf("%s ",_))
	        // println()
      		qksort(str, start, p-1)
			qksort(str, p+1, end)
		  } else {
		  	str
		  }
      }

      def partition(str: Array[Char], start: Int, finish: Int): Int = {
      	  var p = finish
	  	  var firsthigh = start
	      for (i <- start to finish) {
	         if (str(i) < str(p)) {
	      	    swap(str, i, firsthigh)
		        firsthigh += 1
		     }
	  	  }

	  	  swap(str, firsthigh, p)
	      firsthigh
      }

      def swap(cs: Array[Char], i: Int, j: Int) = {
	      var swp = cs(i)
	      cs(i) = cs(j)
	  	  cs(j) = swp
      }

      // mergesort
      def mergesort(str: String) = {
      	var arr = str.toCharArray()
      	new String(mgsort(arr, 0, arr.length-1))
      }

      def mgsort(str: Array[Char], start: Int, end: Int): Array[Char] = {
      	if (start < end) {
      		var mid = (start+end)/2
      		mgsort(str, start, mid)
      		mgsort(str, mid+1, end)
      		merge(str, start, mid, end)
      	} else {
      		str
      	}
      }

      def merge(str: Array[Char], start: Int, mid: Int, end: Int) = {
      	var t = new Array[Char](end-start+1);
      	var it = 0;
      	var is = start;
      	var il = mid+1;
      	while (is <= mid && il <= end) {
      		if (str(is) < str(il)) {
      			t(it) = str(is)
      			it += 1
      			is += 1
      		} else {
      			t(it) = str(il)
      			it += 1
      			il += 1
      		}
      	}

      	while (is <= mid) {
      		t(it) = str(is)
      		it += 1
      		is += 1
      	}

      	while (il <= end) {
      		t(it) = str(il)
      		it += 1
      		il += 1
      	}
      	
      	for (i <- 0 to t.length-1) {
      		str(start+i) = t(i)
      	}
      	str
      }
}

object Main {
       def main(args: Array[String]) = {
       	   var strToSort = "asortingalgorith"
       	   // var strToSort = "0122464534634743789"
	       println("The string to sort is:")
	       println(strToSort)

	       var sortor = new Sorting
	       println("The string after sorting is:")
	       // println(sortor.quicksort(strToSort))
	       println(sortor.mergesort(strToSort))
       }
}