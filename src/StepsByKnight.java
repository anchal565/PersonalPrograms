import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class QueueStructure{
    int x_coordinate;
    int y_coordinate;
    int count;
}

public class StepsByKnight {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int T = sc.nextInt();
        for(int t=0;t<T;t++){
            int N = sc.nextInt();
            int[] knight_pos = new int[2];
            int[] target_pos = new int[2];
            for(int i=0; i<2;i++){
                knight_pos[i] = sc.nextInt();
            }
            for(int i=0; i<2; i++){
                target_pos[i] = sc.nextInt();
            }
            if(target_pos[0]< 0 || target_pos[1]< 0 || target_pos[0] > N || target_pos[1] > N) {
                System.out.println("Target cannot be reached");
                break;
            }

            if(knight_pos[0]< 0 || knight_pos[1]< 0 || knight_pos[0] > N || knight_pos[1] > N) {
                System.out.println("Target cannot be reached");
                break;
            }

            int[] xtrack = new int[]{1,-1,1,-1,-2,-2,2,2};
            int[] ytrack = new int[]{2,2,-2,-2,1,-1,1,-1};
            boolean[][] visited = new boolean[N][N];
            for(int i=0; i<N; i++){
                for(int j=0;j<N;j++){
                    visited[i][j] = false;
                }
            }

            Queue<QueueStructure> queue = new LinkedList<>();
            QueueStructure queueStructure = new QueueStructure();
            queueStructure.x_coordinate = knight_pos[0]-1;
            queueStructure.y_coordinate = knight_pos[1]-1;
            queueStructure.count = 0;
            queue.add(queueStructure);
            visited[knight_pos[0]-1][knight_pos[1]-1] = true;
            QueueStructure tempQueue = queue.peek();
            QueueStructure temp;
            while(!(tempQueue.x_coordinate == target_pos[0]-1 && tempQueue.y_coordinate == target_pos[1]-1)) {
                tempQueue = queue.poll();

                 for (int x = 0; x < xtrack.length; x++) {
                        temp = new QueueStructure();
                        if (tempQueue.x_coordinate + xtrack[x] >= 0 && tempQueue.x_coordinate + xtrack[x] < N
                                && tempQueue.y_coordinate + ytrack[x] >= 0 && tempQueue.y_coordinate + ytrack[x] < N
                                && visited[tempQueue.x_coordinate + xtrack[x]][tempQueue.y_coordinate + ytrack[x]] != true) {
                            temp.x_coordinate = tempQueue.x_coordinate + xtrack[x];
                            temp.y_coordinate = tempQueue.y_coordinate + ytrack[x];
                            temp.count = tempQueue.count + 1;
                            visited[temp.x_coordinate][temp.y_coordinate] = true;
                            queue.add(temp);
                        }

                    }
                 if(queue.isEmpty()) {
                     System.out.println("Target cannot be reached");
                     break;
                 }

            }
            if(queue.size() == 0)
                System.out.println("Target cannot be reached");

            else
                System.out.println("Count is : "+tempQueue.count);



        }

    }


}
