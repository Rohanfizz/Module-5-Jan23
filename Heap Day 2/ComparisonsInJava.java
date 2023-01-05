import java.util.*;

public class Main
{
    public static class Student implements Comparable<Student>{
        String name;
        int ht;
        int wt;
        Student(String name,int ht,int wt){
            this.name = name;
            this.ht=ht;
            this.wt=wt;
        }
        public int compareTo(Student other){
            if(other.ht == this.ht) return other.wt-this.wt;
            return this.ht-other.ht;
        }
    }
    public static class StudentComparatorHeight implements Comparator<Student>{
        public int compare(Student a,Student b){
            return b.ht-a.ht;
        }
    }
     
     public static class StudentComparatorWeight implements Comparator<Student>{
        public int compare(Student a,Student b){
            return a.wt-b.wt;
        }
    }   
	public static void main(String[] args) {
		PriorityQueue<Student> pq = new PriorityQueue<>(new StudentComparatorHeight());
		PriorityQueue<Student> pq2 = new PriorityQueue<>(new StudentComparatorWeight());
		PriorityQueue<Student> pq3 = new PriorityQueue<>((a,b)->{
	       if(a.ht == b.ht) return b.wt-a.wt;
		    return a.ht-b.ht;
		});
		
		pq.add(new Student("Rohan",10,15));
		pq.add(new Student("Rahul",100,78));
		pq.add(new Student("Shivam",1,75));
		System.out.println(pq.remove().name);
		
		pq2.add(new Student("Rohan",10,15));
		pq2.add(new Student("Rahul",100,78));
		pq2.add(new Student("Shivam",1,75));
		System.out.println(pq2.remove().name);
		
		pq3.add(new Student("Rohan",10,15));
		pq3.add(new Student("Rahul",100,78));
		pq3.add(new Student("Shivam",10,75));
		
		System.out.println(pq3.remove().name);
		
	}
}
