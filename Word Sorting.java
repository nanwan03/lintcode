public class Solution {
    /**
     * @param alphabet: the new alphabet
     * @param words: the original string array
     * @return: the string array after sorting
     */
    public String[] wordSort(char[] alphabet, String[] words) {
        // Write your code here
        char []Into = new char[1000];
        char []Outto = new char[1000];
        for(int i = 0; i < alphabet.length; i++) {
            Into[(int)alphabet[i]] = (char)('a' + i);
            Outto['a' + i] = alphabet[i];
        }
        for(int i = 0; i < words.length; i++) {
            String temp = new String();
            for(int j = 0; j < words[i].length(); j++) {
                temp += Into[(int)words[i].charAt(j)];
            }
            words[i] = temp;
        }
        Arrays.sort(words);
        for(int i = 0; i < words.length; i++) {
            String temp = new String();
            for(int j = 0; j < words[i].length(); j++) {
                temp += Outto[(int)words[i].charAt(j)];
            }
             words[i] = temp;
        }
        return words;
    }
}