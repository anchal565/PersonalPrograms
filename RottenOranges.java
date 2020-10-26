import java.util.*;

public class RottenOranges {


    static class QueueStruc{
        int x;
        int y;
    }
    static Queue<QueueStruc> queue = new LinkedList<>();
    public static void positionOf2(int r, int c, int[][] matrix){
        int count = 0;
        for(int i = 0; i<r; i++){
            for(int j=0;j<c;j++){
                if(matrix[i][j] == 2) {
                    count++;
                    //QueueStruc queueStruc = new QueueStruc(i, j);
                    QueueStruc queueStruc = new QueueStruc();
                    queueStruc.x = i;
                    queueStruc.y = j;
                    queue.add(queueStruc);
                }
            }
        }
        queue.add(null);
    }

    public static boolean positionOf1(int r, int c, int[][] matrix){
        int count = 0;
        for(int i = 0; i<r; i++){
            for(int j=0;j<c;j++){
                if(matrix[i][j] == 1) {
                    return true;
                }
            }
        }
        return false;
    }

    public static int queueMethod(int r, int c, int[][] matrix){
        int count = 0;
        positionOf2(r,c,matrix);

        while (!queue.isEmpty()){
            if(positionOf1(r,c, matrix) == false)
                return count;
            while (queue.peek() == null && queue.size()>0){
                queue.poll();
            }
            if(queue.isEmpty() && positionOf1(r,c,matrix) == true){
                count = -1;
                return count;
            }

            while (queue.peek() != null) {
                QueueStruc tempStruc = new QueueStruc();
                tempStruc = queue.poll();
                //top
                if (tempStruc.x > 0 && matrix[tempStruc.x - 1][tempStruc.y] == 1) {
                    QueueStruc helpStruc = new QueueStruc();
                    helpStruc.x = tempStruc.x - 1;
                    helpStruc.y = tempStruc.y;
                    queue.add(helpStruc);
                    matrix[tempStruc.x - 1][tempStruc.y] = 2;
                }
                //bottom
                if (tempStruc.x < r - 1 && matrix[tempStruc.x + 1][tempStruc.y] == 1) {
                    QueueStruc helpStruc = new QueueStruc();
                    helpStruc.x = tempStruc.x + 1;
                    helpStruc.y = tempStruc.y;
                    queue.add(helpStruc);
                    matrix[tempStruc.x + 1][tempStruc.y] = 2;
                }
                //Left
                if (tempStruc.y > 0 && matrix[tempStruc.x][tempStruc.y - 1] == 1) {
                    QueueStruc helpStruc = new QueueStruc();
                    helpStruc.x = tempStruc.x;
                    helpStruc.y = tempStruc.y - 1;
                    queue.add(helpStruc);
                    matrix[tempStruc.x][tempStruc.y - 1] = 2;
                }
                //right
                if (tempStruc.y < c - 1 && matrix[tempStruc.x][tempStruc.y + 1] == 1) {
                    QueueStruc helpStruc = new QueueStruc();
                    helpStruc.x = tempStruc.x;
                    helpStruc.y = tempStruc.y + 1;
                    queue.add(helpStruc);
                    matrix[tempStruc.x][tempStruc.y + 1] = 2;
                }
            }
            queue.add(null);
            count ++;
        }
        if(queue.isEmpty() && positionOf1(r,c,matrix) == true){
            count = -1;
            return count;
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T= sc.nextInt();
        while (T>0){
            int r = sc.nextInt();
            int c = sc.nextInt();
            int[][] matrix = new int[r][c];
            for(int i = 0; i<r; i++)
            {
                for(int j =0; j<c; j++){
                    matrix[i][j] = sc.nextInt();
                }
            }
            int count = queueMethod(r, c, matrix);
            if(count == 0)
                System.out.println("-1");
            else
            System.out.println(count);
            T--;
        }
    }
}
