package practice.algorithms.backTracking;

import java.io.*;
import java.util.*;

public class CrossWord {

    public static void crossWord(char[][] grid,String[] words, int index){
        if(words.length == index){
            print(grid);
            return;
        }
        String word = words[index];
        for(int i=0;i< grid.length;i++){
            for(int j=0;j<grid.length;j++){
                if(grid[i][j] == '-' || grid[i][j] == word.charAt(0)) {
                    if (canPlaceHorizontally(grid, word, i, j)) {
                        boolean[] placed = placeWordHorizontally(grid, word, i, j);
                        crossWord(grid, words, index + 1);
                        UnPlaceHorizontally(grid, placed, i, j);
                    }
                    if (canPlaceVertically(grid, word, i, j)) {
                        boolean[] wePlace = placeWordVertically(grid, word, i, j);
                        crossWord(grid, words, index + 1);
                        UnPlaceVertically(grid, wePlace, i, j);
                    }
                }
            }
        }
    }

    public static boolean canPlaceHorizontally(char[][] grid, String word, int i,int j){
        if(j-1 >= 0 && grid[i][j-1] != '+'){
            return false;
        }
        else if( j+word.length() < grid[i].length && grid[i][j+word.length()] != '+' ){
            return false;
        }
        for(int jj=0;jj<word.length();jj++){
            if( j + jj >= grid[i].length )
                return false;

            if(grid[i][j+jj] == '-' || grid[i][j+jj] == word.charAt(jj) )
                continue;
            else
                return false;
        }
        return true;
    }
    public static boolean canPlaceVertically(char[][] grid, String word, int i,int j){
        if(i-1 >= 0 && grid[i-1][j] != '+'){
            return false;
        }
        else if( i+word.length() < grid.length && grid[i+word.length()][j] != '+' ){
            return false;
        }
        for(int ii=0;ii<word.length();ii++){
            if( i + ii >= grid.length )
                return false;

            if(grid[i+ii][j] == '-' || grid[i+ii][j] == word.charAt(ii) )
                continue;
            else
                return false;
        }
        return true;
    }
    public static  boolean[] placeWordHorizontally(char[][] grid, String word, int i, int j){
        boolean[] wePlaced = new boolean[word.length()];
        for(int jj=0;jj<word.length();jj++){
            if(grid[i][j+jj] == '-'){
                grid[i][j+jj] = word.charAt(jj);
                wePlaced[jj] = true;
            }
        }
        return wePlaced;
    }
    public static  boolean[] placeWordVertically(char[][] grid, String word, int i, int j){
        boolean[] wePlaced = new boolean[word.length()];
        for(int ii=0;ii<word.length();ii++){
            if(grid[i+ii][j] == '-'){
                grid[i+ii][j] = word.charAt(ii);
                wePlaced[ii] = true;
            }
        }
        return wePlaced;
    }
    public static void UnPlaceHorizontally(char[][] grid, boolean[] wePlaced, int i,int j){
        for(int jj=0;jj<wePlaced.length;jj++){
            if(wePlaced[jj])
              grid[i][j+jj] = '-';
        }
    }
    public static void UnPlaceVertically(char[][] grid, boolean[] wePlaced, int i,int j){
        for(int ii=0;ii<wePlaced.length;ii++){
            if(wePlaced[ii])
                grid[i+ii][j] = '-';
        }
    }


    public static void print(char[][] arr){
        for(int i = 0 ; i < arr.length; i++){
            for(int j = 0 ; j < arr.length; j++){
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }

    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        char[][] arr = new char[10][10];
        for(int i = 0 ; i < arr.length; i++){
            String str = scn.next();
            arr[i] = str.toCharArray();
        }
        int n = scn.nextInt();
        String[] words = new String[n];
        for(int i = 0 ; i  < words.length; i++){
            words[i] = scn.next();
        }
        crossWord(arr,words,0);
    }
}
