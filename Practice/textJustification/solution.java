String lastString(String []words, int start, int L){
    String s = "";
    for(int i = start; i < words.length; i++){
        s += words[i];
        if(i != words.length-1)
            s += " ";
    }
    while(s.length() < L)
        s += " ";
    return s;
}
String newString(String[] words, int start, int end, int number_of_words, int extra_spaces){
    String s = "";
    int more_spaces = 0;
    int space = 0;
    if(number_of_words-1 > 0){
        more_spaces = extra_spaces % (number_of_words-1);
        space = extra_spaces / (number_of_words-1);
        for(int i = start; i < end; i++){
            s += words[i];
            if(i != end - 1){
                s += " ";
                for(int j = 0; j < space; j++){
                    s += " ";
                }
                if(more_spaces != 0){
                    s += " ";
                    more_spaces--;
                }
            }
        }
    }
    else{
        s += words[start];
        for(int i = 0; i < extra_spaces; i++)
            s += " ";
    }
    return s;
}

String[] textJustification(String[] words, int L) {
    List<String> s = new ArrayList<String>();
    int start = 0, length = -1, k = 0;
    int number_of_words = 1, extra_spaces = 0;
    for(int i = 0; i < words.length; i++){
        if(length + words[i].length() + 1 > L){
            number_of_words = i - start;
            extra_spaces = L - length;
            s.add(newString(words, start, i, number_of_words, extra_spaces));
            start = i;
            length = words[i].length();
        }
        else{
            length += words[i].length() + 1;
        }
    }
    s.add(lastString(words, start, L));
    return s.toArray(new String[s.size()]);
}
