public class Solution {
    /*
     * @param symb: the array of symbols
     * @param oper: the array of operators
     * @return: the number of ways
     */
    public int countParenth(char[] symb, char[] oper) {
        // write your code here
        if (symb == null || symb.length == 0) {
            return 0;
        }
        int size = symb.length;
        int[][] F = new int[size][size];
        int[][] T = new int[size][size];
        for (int i = 0;i < size; ++i) {
            T[i][i] = symb[i] == 'T' ? 1 : 0;
            F[i][i] = symb[i] == 'F' ? 1 : 0;
        }
        for (int len = 1; len < size; ++len) {
            for (int i = 0, j = len; j < size; ++i, ++j) {
                T[i][j] = 0;
                F[i][j] = 0;
                for (int g = 0; g < len; ++g) {
                    int k = i + g;
                    int tik = T[i][k] + F[i][k];
                    int tkj = T[k + 1][j] + F[k + 1][j];
                    if (oper[k] == '&') {
                        T[i][j] += T[i][k] * T[k + 1][j];
                        F[i][j] += tik * tkj - T[i][k] * T[k + 1][j];
                    } else if (oper[k] == '|') {
                        T[i][j] += tik * tkj - F[i][k] * F[k + 1][j];
                        F[i][j] += F[i][k] * F[k + 1][j];
                    } else if (oper[k] == '^') {
                        T[i][j] += T[i][k] * F[k + 1][j] + T[k + 1][j] * F[i][k];
                        F[i][j] += T[i][k] * T[k + 1][j] + F[i][k] * F[k + 1][j];
                    }
                }
            }
        }
        return T[0][size - 1];
    }
}