// 후보 추천하기
import java.io.*;
import java.util.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int X = Integer.parseInt(br.readLine());

        Person[] people = new Person[101];
        List<Person> list = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        for(int i = 0 ; i < X ; i++){
            int num = Integer.parseInt(st.nextToken());
            if (people[num] == null){
                people[num] = new Person(num, 0, 0, false);
            }

            if (people[num].isIn){
                people[num].count++;
            } else {
                if (list.size() == N){
                    Collections.sort(list);
                    Person p = list.remove(0);
                    p.isIn = false;
                }
                people[num].count = 1;
                people[num].isIn = true;
                people[num].timeStamp = i;
                list.add(people[num]);
            }
            
        }

        Collections.sort(list, new Comparator<Person>(){
            @Override
            public int compare(Person o1, Person o2){
                return Integer.compare(o1.num,o2.num);
            }
        });
        
        for (int i = 0; i < list.size(); i++){
            System.out.printf("%d ",list.get(i).num);
        }
    }
}

class Person implements Comparable<Person> {
    int num;
    int count;
    int timeStamp;
    boolean isIn;

    Person(int num, int count, int timeStamp, boolean isIn){
        this.num = num;
        this.count = count;
        this.timeStamp = timeStamp;
        this.isIn = isIn;
    }

    @Override
    public int compareTo(Person o){
        int comp1 = Integer.compare(count, o.count);
        if (comp1==0) {
            return Integer.compare(timeStamp, o.timeStamp);
        } else {
            return comp1;
        }

    }
}