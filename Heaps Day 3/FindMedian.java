import java.util.*;

public class Main {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    MedianFinder medianFinder = new MedianFinder();
    int n = sc.nextInt();
    for (int i = 0; i < n; i++) {
      String s = sc.next();
      if (s.equals("addNum")) medianFinder.addNum(sc.nextInt()); else if (
        s.equals("findMedian")
      ) System.out.println(medianFinder.findMedian());
    }
    sc.close();
  }
}

class MedianFinder {

  // your code here
	PriorityQueue<Integer> min;
	PriorityQueue<Integer> max;
	
  public MedianFinder() {
    // your code here
	  min = new PriorityQueue<>();
	  max = new PriorityQueue<>(Collections.reverseOrder());
  }
	public void balance(){
		if(Math.abs(min.size() - max.size()) <=1 ) return;
		
		if(min.size() > max.size()) max.add(min.remove());
		else min.add(max.remove());
	}
  public void addNum(int num) {
    // your code here
	  if(max.size() == 0) max.add(num);
	  else if(max.peek() < num) min.add(num);
	  else max.add(num);
	  balance();
  }

  public double findMedian() {
    // your code here
	  if(min.size() == max.size()){
		  return 1.0*(min.peek()+max.peek())/2.0;
	  }
	  return max.size()>min.size() ? 1.0*max.peek() : 1.0*min.peek();
  }
}
