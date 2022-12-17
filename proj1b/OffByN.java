public class OffByN implements CharacterComparator{
    private int N;
    public OffByN(int n){
        if(n<0 || n>25){
            System.out.println("ileagel inpurt n");
            System.exit(0);
        }
        N = n;
    }
    public boolean equalChars(char x, char y) {
        int dif = x - y;
        if( dif==N || dif == -N){
            return true;
        }
        return false;
    }
}