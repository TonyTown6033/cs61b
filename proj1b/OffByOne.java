public class OffByOne implements CharacterComparator{
    @Override
    public boolean equalChars(char x, char y) {
        int dif = x - y;
        if((dif+1)%32==0 || (dif-1)%32==0){
            return true;
        }
        return false;
    }
}