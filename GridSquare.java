public class GridSquare{
    //instance vars
    //: pos -1 = empty 0 = x 1 = o
    public int state;


    public int pos;


    public GridSquare(int pos){
        this.pos = pos;
        //pos == argument
        //this.pos = instance var
        this.state = -1;
    }
    //charecter is either a letter or number
    public char drawSpace(){
        if (state == 0){
            //char needs '' not ""
            return 'X';
        }
        else if (state == 1){
            return 'O';
        }
        else{
            //pos becomes a string, then a char
            return Integer.toString(pos).charAt(0);
        }


    }

//    public int getState(){return state;}
//
//    public void setState(int x){state = x;}


}

