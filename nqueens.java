public class nqueens {
    public static void main(String[] args) {
        int n = 8; // Change n to the desired board size
        solveNQueens(n);
    }

    public static void solveNQueens(int n) {
        char[][] board = new char[n][n];
        for (char[] row : board) {
            for (int i = 0; i < n; i++) {
                row[i] = '.';
            }
        }

        boolean found = placeQueens(board, 0, n);

        if (!found) {
            System.out.println("No solution found.");
        }
    }

    public static void printBoard(char[][] board) {
        for (char[] row : board) {
            System.out.println(new String(row));
        }
    }

    public static boolean isSafe(char[][] board, int row, int col, int n) {
        // Check column on the left
        for (int i = 0; i < col; i++) {
            if (board[row][i] == 'Q') {
                return false;
            }
        }

        // Check upper left diagonal
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        // Check lower left diagonal
        for (int i = row, j = col; i < n && j >= 0; i++, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        return true;
    }

    public static boolean placeQueens(char[][] board, int col, int n) {
        if (col == n) {
            // All queens are placed, print the board
            printBoard(board);
            return true;
        }

        for (int i = 0; i < n; i++) {
            if (isSafe(board, i, col, n)) {
                board[i][col] = 'Q';
                if (placeQueens(board, col + 1, n)) {
                    return true;
                }
                board[i][col] = '.';
            }
        }

        return false;
    }
}

// public class nqueensbacktrack{
//     public static boolean isSafe(char board[][],int row,int col){

//         //vertical up
//         for(int i=row-1;i>=0;i--){
//             if(board[i][col]=='Q'){
//                 return false;
//             }
//         }

//         //diagonal left up
//         for(int i=row-1,j=col-1;i>=0 && j>=0;i--,j--){
//             if(board[i][j]=='Q'){
//                 return false;
//             }
//         }

//         //diagonal right up
//         for(int i=row-1,j=col+1;i>=0 && j<board.length;i--,j++){    
//             if(board[i][j]=='Q'){
//                 return false;
//             }
//         }
//         return true;
//     }
//     public static void nQueens(char board[][],int row){

//         //base case
//         if(row==board.length){
//             printBoard(board);
//             count++;
//             return;
//         }

//         for(int j=0;j<board.length;j++){
//             if(isSafe(board,row,j)){
//                 board[row][j]='Q';
//                 nQueens(board,row+1);
//                 board[row][j]='.';
//             }
//         }
//     }
    
//     public static void printBoard(char board[][]){
//         System.out.println("---------------");
//         for(int i=0;i<board.length;i++){
//             for(int j=0;j<board.length;j++){
//                 System.out.print(board[i][j]+" ");
//             }
//             System.out.println();
//         }
//     }
//     static int count=0;
//     public static void main(String[] args) {
//         int n=4;
//         char board[][]=new char[n][n];
//         for(int i=0;i<n;i++){
//             for(int j=0;j<n;j++){
//                 board[i][j]='.';
//             }
//         }
//         nQueens(board,0);
//         System.out.println();
//         System.out.println("Total ways to solve nQueens = "+count);
//     }
// }