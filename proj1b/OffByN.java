public class OffByN implements CharacterComparator{
    private int N;
    public OffByN(int n){
        if(n<0 || n>25){
            System.out.println("ileagel inpurt n");
        }
        N = n;
    }
    public boolean equalChars(char x, char y) {
        int dif = x - y;
        if( (dif+N)%32==0 || (dif-N)%32 == 0){
            return true;
        }
        return false;
    }
}