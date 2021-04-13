package com.ken.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.Collections;

public class QueenSolution {

    private int[] dx = {-1,0,1,-1,1,-1,0,1};
    private int[] dy = {-1,-1,-1,0,0,1,1,1};

    private ArrayList<int[]> attack = new ArrayList();
    private ArrayList<char[]> queen = new ArrayList();

    public ArrayList<ArrayList<char[]>> solveNQueens(int n) {

        ArrayList<ArrayList<char[]>> solution = new ArrayList<>();

        for (int i = 0; i < n; i++) {

            int[] attackOne = new int[n];
            char[] queenOne = new char[n];

            Arrays.fill(attackOne, 0);
            Arrays.fill(queenOne, '.');

            attack.add(attackOne);
            queen.add(queenOne);
        }

        backtrack(0, n, queen, attack, solution);

        for (ArrayList<char[]> arrayList : solution) {
            //debugArrays(null, arrayList);
            System.out.println("\n");
        }

        return solution;
    }

    private void putQueen(int x, int y, ArrayList<int[]> attack) {

        attack.get(x)[y] = 1;

        for(int i = 0; i < attack.size(); i++) {
            for (int j = 0; j < 8; j++){
                int nx = x + i * dx[j];
                int ny = y + i * dy[j];

                if (nx >= 0 && nx < attack.size() && ny >= 0 && ny < attack.size()){
                    attack.get(nx)[ny] = 1;
                }
            }
        }
    }

    private void backtrack(int k, int n, ArrayList<char[]> queen,
                ArrayList<int[]> attack, ArrayList<ArrayList<char[]>> solution) {
        if (k == n) {
            ArrayList<char[]> tmp = new ArrayList<char[]>();
            for (int m = 0; m < n; m++) {
                char[] tmpOne = new char[n];
                tmp.add(tmpOne);
            }
            copyMyList2(tmp, queen);
            solution.add(tmp);
            /*
            for (ArrayList<char[]> arrayList : solution) {
                debugArrays(null, arrayList);
                System.out.println("\n");
            }
            */
            return;
        }

        for (int i = 0; i < n; i++) {
            if (attack.get(k)[i] == 0) {
                ArrayList<int[]> tmp = new ArrayList<int[]>();
                for (int m = 0; m < n; m++) {
                    int[] tmpOne = new int[n];
                    tmp.add(tmpOne);
                }
                copyMyList(tmp, attack);
                //debugArrays(tmp, queen);
                queen.get(k)[i] = 'Q';
                putQueen(k, i, attack);
                //debugArrays(null, queen);
                backtrack(k+1, n, queen, attack, solution);
                copyMyList(attack, tmp);
                queen.get(k)[i] = '.';
                //debugArrays(attack, queen);
            }
        }
    }

    private void debugArrays(ArrayList<int[]> arrays, ArrayList<char[]> queen) {

        if (arrays != null) {
            System.out.println("attack");

            for (int[] item : arrays) {
                System.out.println(Arrays.toString(item));
            }
        }

        if (queen != null) {
            System.out.println("queen");
            for (char[] item : queen) {
                System.out.println(Arrays.toString(item));
            }
        }
    }

    private void copyMyList(ArrayList<int[]> des, ArrayList<int[]> src) {
        int n = des.size();

        for (int i = 0; i < n; i++) {
            int[] d = des.get(i);
            int[] s = src.get(i);
            System.arraycopy(s, 0, d, 0, s.length);
        }
    }

    private void copyMyList2(ArrayList<char[]> des, ArrayList<char[]> src) {
        int n = des.size();

        for (int i = 0; i < n; i++) {
            char[] d = des.get(i);
            char[] s = src.get(i);
            System.arraycopy(s, 0, d, 0, s.length);
        }
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<char[]>> solution = new QueenSolution().solveNQueens(8);
        System.out.println("solution " + solution.size());
        
        for (ArrayList<char[]> arrayList : solution) {
            for (char[] item : arrayList) {
                System.out.println(Arrays.toString(item));
            }
            System.out.println("\n");
        }
            
    }
    
}
