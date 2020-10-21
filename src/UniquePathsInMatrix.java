public class UniquePathsInMatrix {
        int noOfPaths = 0;
        public int uniquePaths(int m, int n) {
            noOfPaths(m, n, 0, 0);
            return noOfPaths;
        }
        public void noOfPaths(int m, int n, int i, int j){
            if(i==m-1 && j==n-1){
                noOfPaths++;
                return;
            }
            //right
            if(i+1<m)
                noOfPaths(m, n, i+1, j);
            //down
            if(j+1<n)
                noOfPaths(m, n, i, j+1);
        }

    public static void main(String[] args) {
        UniquePathsInMatrix uniquePathsInMatrix = new UniquePathsInMatrix();
        uniquePathsInMatrix.uniquePaths(3,2);
        System.out.println(uniquePathsInMatrix.noOfPaths);
    }

}
