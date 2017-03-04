public class item{
    String word;
    int count;
    public item(String word, int count){
        this.word = word;
        this.count = count;
    }
}
boolean isAdjacent(String a, String b){
    int count = 0;  
    for (int i = 0; i < a.length(); i++)
    {
        if (a.charAt(i) != b.charAt(i))
            count++;
        if (count > 1) return false;
    }
    return true;
}
int wordLadder(String beginWord, String endWord, String[] wordList) {
    Arrays.sort(wordList);
    Queue<item> q = new LinkedList<>();
    item first = new item(beginWord,1);
    q.add(first);
    while(!q.isEmpty()){
        item current = q.peek();
        q.poll();
        for(int i = 0; i < wordList.length; i++){
            if(!wordList[i].equals("0")){
                if(isAdjacent(current.word, wordList[i])){
                    System.out.println(current.word + " " + wordList[i]);
                    item newItem = new item(wordList[i], current.count + 1);
                    q.add(newItem);
                    if(wordList[i].equals(endWord))
                        return newItem.count;
                    wordList[i] = "0";
                }
            }
        }
    }
    return 0;
}
