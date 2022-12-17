public class Palindrome {
    public Deque<Character> wordToDeque(String word){
        int lenth = word.length();
        char temp;
        Deque<Character> backGroup = new LinkedListDeque<>();

        for(int i = 0;i<lenth;i++){
            temp = word.charAt(i);
            backGroup.addLast(temp);
        }

        return backGroup;
    }

    private static boolean isPalindrome(Deque<Character> word){
        if(word.isEmpty() || word.size()==1){
            return true;
        }
        if(word.removeFirst()!=word.removeLast()){
            return false;
        }
        return isPalindrome(word);
    }
    public boolean isPalindrome(String word){
        Deque<Character> wordDeque = wordToDeque(word);
        return isPalindrome(wordDeque);
    }

    private static boolean isPalindrome(Deque<Character> word,CharacterComparator cc){
        if(word.isEmpty() || word.size()==1){
            return true;
        }
        if(!cc.equalChars(word.removeFirst(),word.removeLast())){
            return false;
        }
        return isPalindrome(word,cc);
    }
    public boolean isPalindrome(String word, CharacterComparator cc){
        Deque<Character> wordDeque = wordToDeque(word);
        return isPalindrome(wordDeque,cc);
    }
}