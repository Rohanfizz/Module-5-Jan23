import java.io.*;
import java.util.*;

public class Main {

  public static class PriorityQueue {

    ArrayList<Integer> data;

    public PriorityQueue() {
      data = new ArrayList<>();
    }

    public void swap(int i, int j) {
      int ith = data.get(i);
      int jth = data.get(j);
      data.set(i, jth);
      data.set(j, ith);
    }

    public void upheapify(int ci) {
      if (ci == 0) return;
      int pi = (ci - 1) / 2;
      if (data.get(ci) < data.get(pi)) {
        swap(pi, ci);
        upheapify(pi);
      }
    }

    public void downheapify(int pi) {
      int lci = (2 * pi) + 1;
      int rci = (2 * pi) + 2;
      int mini = pi;

      if (lci < data.size() && data.get(lci) < data.get(mini)) mini = lci;
      if (rci < data.size() && data.get(rci) < data.get(mini)) mini = rci;

      if (pi != mini) {
        swap(pi, mini);
        downheapify(mini);
      }
    }

    public void add(int val) {
      // write your code here
      data.add(val);
      upheapify(data.size() - 1);
    }

    public int remove() {
      // write your code here
      if (data.size() == 0) {
        System.out.println("Underflow");
        return -1;
      }
      int temp = data.get(0);
      swap(0, data.size() - 1);
      data.remove(data.size() - 1);
      downheapify(0);
      return temp;
    }

    public int peek() {
      // write your code here
      if (data.size() == 0) {
        System.out.println("Underflow");
        return -1;
      }
      return data.get(0);
    }

    public int size() {
      // write your code here
      return data.size();
    }
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    PriorityQueue qu = new PriorityQueue();

    String str = br.readLine();
    while (str.equals("quit") == false) {
      if (str.startsWith("add")) {
        int val = Integer.parseInt(str.split(" ")[1]);
        qu.add(val);
      } else if (str.startsWith("remove")) {
        int val = qu.remove();
        if (val != -1) {
          System.out.println(val);
        }
      } else if (str.startsWith("peek")) {
        int val = qu.peek();
        if (val != -1) {
          System.out.println(val);
        }
      } else if (str.startsWith("size")) {
        System.out.println(qu.size());
      }
      str = br.readLine();
    }
  }
}
