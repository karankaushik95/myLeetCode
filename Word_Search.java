/*
Given a 2D board and a word, find if the word exists in the grid.

The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.

Example:

board =
[
  ['A','B','C','E'],
  ['S','F','C','S'],
  ['A','D','E','E']
]

Given word = "ABCCED", return true.
Given word = "SEE", return true.
Given word = "ABCB", return false.
 

Constraints:

board and word consists only of lowercase and uppercase English letters.
1 <= board.length <= 200
1 <= board[i].length <= 200
1 <= word.length <= 10^3
*/

package wordmatrix;

class Word_Search {
    public static boolean exist(char[][] board, String word) {
    
        for(int i =0; i<board.length; i++){
            for(int j=0; j<board[i].length; j++){
                if(board[i][j]==word.charAt(0)){
                    board[i][j] = '-';
                	if(findChar(board,i,j,word.substring(1))){
                       return true;
                   }
                	board[i][j] = word.charAt(0);
                }
            }
        }
        return false;
    }

    public static boolean findChar(char[][] board, int row, int column, String word){
         if(word.equals("")){
            return true;
        }else{
            try{
                if(board[row+1][column] == word.charAt(0)) {
                	board[row+1][column] = '-';
                	if(findChar(board,row+1,column,word.substring(1))) {
                		return true;
                	}
                	board[row+1][column] = word.charAt(0);
                }    
            }catch(ArrayIndexOutOfBoundsException e){
                e.printStackTrace();
            }
            try{
                if(board[row][column+1] == word.charAt(0)) {
                	board[row][column+1] = '-';
                 	if(findChar(board,row,column+1,word.substring(1))) {
                 		return true;
                 	}
                	board[row][column+1] = word.charAt(0);
                }
                    
            }catch(ArrayIndexOutOfBoundsException e){
                e.printStackTrace();
            }
            try{
                if(board[row][column-1] == word.charAt(0)) {
                	board[row][column-1] = '-';
                	if(findChar(board,row,column-1,word.substring(1))) {
                		return true;
                	}
                	board[row][column-1] = word.charAt(0);
                }
                    
            }catch(ArrayIndexOutOfBoundsException e){
                e.printStackTrace();
            }
            try{
                if(board[row-1][column] == word.charAt(0)) {
                	board[row-1][column] = '-';
                	if(findChar(board,row-1,column,word.substring(1))) {
                		return true;
                	}
                	board[row-1][column] = word.charAt(0);
                }
            }catch(ArrayIndexOutOfBoundsException e){
                e.printStackTrace();
            }
            return false;
        }
        
    }

    public static void main(String[] args) {
    	
    	char[][] board = {{'a','a'}};
    	String find = "aaa";
    	System.out.println(exist(board,find));
    	
    }
}
