package rocks.zipcodewilmington.tictactoe;

/**
 * @author leon on 6/22/18.
 */
public class Board {
    private Character[][] pole;



    public Board(Character[][] matrix) {
        this.pole = matrix;

    }
    public Boolean isInFavorOfLetter(char letter){
        int countDiag1 = 0;
        int countDiag2=0;
        int countHor = 0;
        int countVert = 0;
        for (int i =0; i<pole.length; i++){
            for(int j =0; j<pole.length; j++){

                if (i==j&&pole[i][j]==letter){
                    countDiag1 +=1;
                }
                if (i+j==2 && pole[i][j]==letter){
                    countDiag2+=1;
                }
                if (pole[i][j]==letter){
                    countHor+=1;
                }
                if (pole[j][i]==letter){
                    countVert+=1;
                }
            }
            if (countHor ==3||countVert==3){
                return true;
            }
            else{
                countHor =0;
                countVert = 0;
            }
        }
        if (countDiag1 ==3||countDiag2==3){
            return true;
        }

        return false;

    }

    public Boolean isInFavorOfX() {
        return isInFavorOfLetter('X');
    }

    public Boolean isInFavorOfO() {
        return isInFavorOfLetter('O');
    }

    public Boolean isTie() {
        if (isInFavorOfX()==isInFavorOfO()) {
            return true;
        }
        return false;
    }

    public String getWinner() {
        if (isTie()){
            return "";
        }
        else if(isInFavorOfX()) {
            return "X";
        }
        else{
            return "O";
        }

    }

}
