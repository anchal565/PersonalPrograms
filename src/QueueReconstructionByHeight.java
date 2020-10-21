//Pramp June Contest :
// https://leetcode.com/explore/featured/card/june-leetcoding-challenge/539/week-1-june-1st-june-7th/3352/
//Suppose you have a random list of people standing in a queue. Each person is described by a pair of integers (h, k),
// where h is the height of the person and k is the number of people in front of this person who have a height
// greater than or equal to h. Write an algorithm to reconstruct the queue.

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.Vector;

public class QueueReconstructionByHeight {
    public int[][] reconstructQueue(int[][] people) {
        Set<Integer> alreadyAddressed = new HashSet<>();
        int count = 0;
        while(count < people.length){
            int shortestPerson = shortestPerson(people, alreadyAddressed);
            //System.out.println("Short is : "+ shortestPerson + " for count : "+count);
            int i = 0, position = -1;
            while(position != people[shortestPerson][1]){
                if(!alreadyAddressed.contains(i)){
                    i++;
                    position++;
                }
                else if(alreadyAddressed.contains(i) && people[i][0] == people[shortestPerson][0]){
                    i++;
                    position++;
                }
                else{
                    i++;
                }
            }
            i= i-1;
            //System.out.println("Position for count is : "+ i+ " "+count);
            if(alreadyAddressed.contains(i)){
                while(!alreadyAddressed.contains(i)){
                    i++;
                }
            }
            //System.out.println("HII : "+ position);
            // put shortest element value at i
            int tempX = people[i][0];
            int tempY = people[i][1];
            people[i][0] = people[shortestPerson][0];
            people[i][1] = people[shortestPerson][1];
            people[shortestPerson][0] = tempX;
            people[shortestPerson][1] = tempY;
            //System.out.println("Addind in vector : "+position);
            alreadyAddressed.add(i);
            count ++;
        }
        return people;
    }
    public int shortestPerson(int[][] people, Set<Integer> alreadyAddressed){
        int shortestPersonIndex = -1, shortestPersonHeight = Integer.MAX_VALUE;
        for(int i=0; i<people.length; i++){
            if(!(alreadyAddressed.contains(i)) && shortestPersonHeight > people[i][0]){
                shortestPersonHeight = people[i][0];
                shortestPersonIndex = i;
            }
            else if(!(alreadyAddressed.contains(i)) && shortestPersonIndex != i &&
                    shortestPersonHeight == people[i][0]){

                shortestPersonIndex = people[i][1] < people[shortestPersonIndex][1]
                        ? i : shortestPersonIndex;
                //shortestPersonHeight = people[shortestPersonIndex][0];
            }
        }
        return shortestPersonIndex;
    }

    public static void main(String[] args) {
        int[][] people = {{7,0},
                {4,4},
                {7,1},
                {5,0},
                {6,1},
                {5,2},
        };
        QueueReconstructionByHeight queueReconstructionByHeight = new QueueReconstructionByHeight();
        int[][] result = queueReconstructionByHeight.reconstructQueue(people);
        for (int i=0; i<people.length; i++) {
            System.out.println(Arrays.toString(people[i]));
        }
    }
}
