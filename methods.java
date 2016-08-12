package net.TicTacToe;

import java.util.Random;

public class methods {
	final static int moves[] = {4, 0, 2, 6, 8, 1, 3, 5, 7};
	static boolean won[] = new boolean[1 << 9];
    static final int DONE = (1 << 9) - 1;
    static final int OK = 0;
    static final int WIN = 1;
    static final int LOSE = 2;
    static final int STALEMATE = 3;

    /**
     * Mark all positions with these bits set as winning.
     */
    static void isWon(int pos) {
	for (int i = 0 ; i < DONE ; i++) {
	    if ((i & pos) == pos) {
		won[i] = true;
	   		}
		}
    }

    /**
     * Initialize all winning positions.
     */
    static {
	isWon((1 << 0) | (1 << 1) | (1 << 2));
	isWon((1 << 3) | (1 << 4) | (1 << 5));
	isWon((1 << 6) | (1 << 7) | (1 << 8));
	isWon((1 << 0) | (1 << 3) | (1 << 6));
	isWon((1 << 1) | (1 << 4) | (1 << 7));
	isWon((1 << 2) | (1 << 5) | (1 << 8));
	isWon((1 << 0) | (1 << 4) | (1 << 8));
	isWon((1 << 2) | (1 << 4) | (1 << 6));
    }
   
	
	public int aMove(boolean[] M){
		int noMove = -1;
			for(int i=0; i<9;i++){
				if(M[i]){
					return i;
				}
			}
		
		return noMove;
		
	}
	int bestMove(int white, int black) {
    	int bestmove = -1;

    	loop:
    		for (int i = 0 ; i < 9 ; i++) {
    			int mw = moves[i];
    			if (((white & (1 << mw)) == 0) && ((black & (1 << mw)) == 0)) {
    				int pw = white | (1 << mw);
    				if (won[pw]) {
    					// white wins, take it!
    					return mw;
    				}
    				for (int mb = 0 ; mb < 9 ; mb++) {
    					if (((pw & (1 << mb)) == 0) && ((black & (1 << mb)) == 0)) {
    						int pb = black | (1 << mb);
    						if (won[pb]) {
    							// black wins, take another
    							continue loop;
    						}
    					}
    				}
    				// Neither white nor black can win in one move, this will do.
    				if (bestmove == -1) {
    					bestmove = mw;
    				}
    			}
    		}
    	if (bestmove != -1) {
    		return bestmove;
    	}
    	// No move is totally satisfactory, try the first one that is open
    	for (int i = 0 ; i < 9 ; i++) {
    		int mw = moves[i];
    		if (((white & (1 << mw)) == 0) && ((black & (1 << mw)) == 0)) {
    			return mw;
    		}
    	}
    	// No more moves
    	return -1;
    }
	int cState(int white, int black){
        int cstate = -1;
        int[] spaces = {0,1,2,3,4,5,6,7,8};
        int[] newMoves = setPriority();
        loop:
        
        for(int i = 0; i < 9; i++){
    			int mw = newMoves[i];
    			if (((white & (1 << mw)) == 0) && ((black & (1 << mw)) == 0)) {
    				int pw = white | (1 << mw);
    				if (won[pw]) {
    					// white wins, take it!
    					return mw;
    				}
    				for (int mb = 0 ; mb < 9 ; mb++) {
    					if (((pw & (1 << mb)) == 0) && ((black & (1 << mb)) == 0)) {
    						int pb = black | (1 << mb);
    						if (won[pb]) {
    							// black wins, take another
    							continue loop;
    						}
    					}
    				}
    				// Neither white nor black can win in one move, this will do.
    				if (cstate == -1) {
    					cstate = mw;
    				}
    			}
    		}
    	if (cstate != -1) {
    		return cstate;
    	}
    	// No move is totally satisfactory, try the first one that is open
    	for(int i = 0 ; i < 9 ; i++) {
    		int mw = newMoves[i];
    		if (((white & (1 << mw)) == 0) && ((black & (1 << mw)) == 0)) {
    			return mw;
                }
    	}
        //Check for win
        
        //Check for connect two

        //Any legal move
      
        return -1;
    }
    
    int DFS(int white, int black){
        int dfs = -1;
        
        return -1;
    }
    
    int BFS(int white, int black){
        int bfs = -1;
        
        return -1;
    }
    int lHeur(int white, int black){
        int lheur = -1;
        
        return -1;
    }
    
    int MinMax(int white, int black){
        int minmax = -1;
        
        return -1;
    }
    
    int AlphaBeta(int white, int black){
        int AB = -1; 
        
        return -1;
    }
    
    public int[] setPriority(){
        
        Random rand = new Random();
        int n = moves.length;
        int[] A = moves;
        int []P = new int[n];
        for(int i = 0; i <n; i++){
            P[i] = rand.nextInt(n*n*n);
        }
        int temp, next;
        for(int i = 0; i<(n-1); i++){
           next = P[i+1];
            if(P[i]>next){
               temp = P[i];
               P[i] = next;
               P[i+1] = temp;
               next = A[i+1];
               temp = A[i];
               A[i] = next;
               A[i+1] = temp;
           }
        }
        
        return A;
    }

   
}

