import java.util.*;

public class Main {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    char[][] board = new char[9][9];
    for (int i = 0; i < 9; i++) {
      for (int j = 0; j < 9; j++) {
        board[i][j] = sc.next().charAt(0);
      }
    }
    sc.close();
    solveSudoku(board);
    if (isValidSudoku(board)) System.out.println(
      "correct"
    ); else System.out.println("incorrect");
  }
	    

  public static boolean validate(char[][] board,char num,int i,int j){
		for(int ii = 0;ii<9;ii++) if(board[ii][j] == num) return false;
		for(int jj = 0;jj<9;jj++) if(board[i][jj] == num) return false;
		for(int ii = i-i%3;ii<=i-i%3+2;ii++){
			for(int jj = j-j%3;jj<=j-j%3+2;jj++){
				if(board[ii][jj] == num) return false;
			}
		}
		return true;
	}
	
	public static boolean solve(char[][] board,int i,int j){
		if(i == 9)return true;
		if(j == 9) return solve(board,i+1,0);
		if(board[i][j]!='.') return solve(board,i,j+1);
		for(char num = '1';num<='9';num++){
			// validate this
			if(!validate(board,num,i,j)) continue;
			board[i][j] = (char)num;
			boolean next = solve(board,i,j+1);
			if(next) return true;
			board[i][j] = '.';
		}
		return false;
	}
	
	
  public static void solveSudoku(char[][] board) {
    // your code here
	solve(board,0,0);
  }
	 public static boolean isValidSudoku(char[][] board) {    	
    	char[] ch = new char[9];
    	int twod[][] = {{0,0},{0,1},{0,2},{1,0},{1,1},{1,2},{2,0},{2,1},{2,2}};
    	for(int i=0; i<9; i++){
    		for(int j=0; j<9; j++){
    			ch[j]=board[i][j];
    		}
    		if(!checkValid(ch))
    			return false;
    	}
    	
    	for(int i=0; i<9; i++){
    		for(int j=0; j<9; j++){
    			ch[j]=board[j][i];
    		}
    		if(!checkValid(ch))
    			return false;
    	}
    	for(int k=0; k<twod.length; k++){
    		for(int i=twod[k][0]*3, icount=0; icount<3; i++, icount++){
    			for(int j=twod[k][1]*3, jcount=0; jcount<3; j++, jcount++){
    				ch[icount*3+jcount]=board[i][j];
    			}
    		}
    		if(!checkValid(ch))
    			return false;
    	}
        return true;
    }
	

	private static boolean checkValid(char[] ch) {
		boolean[] flag = new boolean[9];
		for(int i=0; i<9; i++){
			if(ch[i]=='.')
				continue;
			if(flag[ch[i]-'0'-1])
				return false;
			flag[ch[i]-'0'-1]=true;
		}
		return true;
	}

}