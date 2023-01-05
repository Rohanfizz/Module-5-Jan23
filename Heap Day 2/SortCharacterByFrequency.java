import java.util.*;

class Solution {

  public class Helper implements Comparable<Helper> {

    char c;
    int freq;

    Helper(char c, int freq) {
      this.c = c;
      this.freq = freq;
    }

    public int compareTo(Helper other) {
      if (this.freq == other.freq) return other.c - this.c;
      return other.freq - this.freq;
    }
  }

  public String frequencySort(String s) {
    HashMap<Character, Integer> hm = new HashMap<>();
    for (char c : s.toCharArray()) {
      hm.put(c, hm.getOrDefault(c, 0) + 1);
    }
    PriorityQueue<Character> pq = new PriorityQueue<>((a, b) -> {
      if (a.freq == b.freq) return b.c - a.c;
      return b.freq - a.freq;
    });

    for (char c : hm.keySet()) {
      pq.add(new Helper(c, hm.get(c)));
    }

    StringBuilder sb = new StringBuilder();
    while (pq.size() > 0) {
      Helper top = pq.remove();
      while (top.freq-- > 0) sb.append(top.c);
    }
    return sb.toString();
  }
}
