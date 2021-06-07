package com.leetcode;

/**
 * 给定一个二维网格和一个单词，找出该单词是否存在于网格中。
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 * 示例:
 * board =
 * [
 *   ['A','B','C','E'],
 *   ['S','F','C','S'],
 *   ['A','D','E','E']
 * ]
 *
 * 给定 word = "ABCCED", 返回 true
 * 给定 word = "SEE", 返回 true
 * 给定 word = "ABCB", 返回 false
 * ######
 * 联系搜索和回溯算法
 */
public class SearchWordInMartix {

    public static boolean findword(char[][] cs, char[] words){

        int r = cs.length, c = cs[0].length;
        boolean found =false;
        for(int i=0; i< r; i++ ){
            for(int j=0; j<c; j++){
                if(cs[i][j] == words[0]){
                    if(dfs(i,j, cs,words,1)){
                        return true;
                   }
                }
            }
        }
        return false;

    }

    public static boolean dfs(int i, int j,
                              char[][] cs, char[] words,int depth){
        if(depth == words.length ) return true;
        //left->
        boolean found = false;
        if(j+1 < cs[0].length){
            if(cs[i][j+1] == words[depth]){
                found = dfs(i,j+1, cs, words, depth+1);
            }else{
                found = false;
            }
        }
        //right
        if(found) return true;
        if(j-1>=0){
            if(cs[i][j-1] == words[depth]){
                found = dfs(i,j-1, cs, words, depth+1);
            }else{
                found = false;
            }
        }
        //up
        if(found) return true;
        if(i-1>=0){
            if(cs[i-1][j] == words[depth]){
                found = dfs(i-1,j, cs, words, depth+1);
            }else{
                found = false;
            }
        }
        //dwon
        if(found) return true;
        if(i+1<cs.length){
            if(cs[i+1][j] == words[depth]){
                found = dfs(i+1,j, cs, words, depth+1);
            }else{
                found = false;
            }
        }
        return found;
    }


    public static void main(String[] args) {
        char[][] n = new char[][]{
                {'A','B','C','E'},
                {'S','F','C','S'},
                {'A','D','E','E'}

        };
       boolean res  = findword(n,"ABCCEDAS".toCharArray());
        System.out.println(res);
    }
}
