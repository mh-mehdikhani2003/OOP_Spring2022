import java.util.Scanner;
public class television {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        long [][] matrix = new long [m][n];
        long[][] distance = new long[m][n];
        boolean[][] SPT_set = new boolean[m][n];
        boolean temp = false;
        String input;
        long min = Long.MAX_VALUE;
        int index_end_i = 0, index_end_j = 0, i1 = 0, j1 = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                input = sc.next();
                if (input.equals("*")) {
                    matrix[i][j] = 0;
                } else {
                    matrix[i][j] = Integer.parseInt(input);
                }
                SPT_set[i][j] = false;
                distance[i][j] = -10;
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0 && temp == true) {
                    index_end_i = i;
                    index_end_j = j;
                }
                if (matrix[i][j] == 0 && temp == false) {
                    SPT_set[i][j] = true;
                    temp = true;
                    distance[i][j] = 0;
                    i1 = i;
                    j1 = j;
                }
            }
        }
            while (SPT_set[index_end_i][index_end_j] == false) {
                if (i1 == m - 1 && j1 == 0) {
                    if(SPT_set[i1 +1][j1]==false) {
                        if (distance[i1 + 1][j1] >= 0 && distance[i1][j1] + matrix[i1+1][j1] < distance[i1 + 1][j1]) {
                            distance[i1 + 1][j1] = distance[i1][j1] + matrix[i1+1][j1];
                        }
                        if (distance[i1 + 1][j1] < 0) {
                            distance[i1 + 1][j1]=0;
                            distance[i1 + 1][j1] = distance[i1 ][j1] + matrix[i1 + 1][j1];
                        }
                    }
                    if(SPT_set[i1 ][j1+1]==false) {
                        if (distance[i1][j1 + 1] >= 0 && distance[i1][j1] + matrix[i1][j1+1] < distance[i1][j1 + 1]) {
                            distance[i1][j1 + 1] = distance[i1][j1] + matrix[i1][j1+1];
                        }
                        if (distance[i1][j1 + 1] < 0) {
                            distance[i1][j1 + 1]=0;
                            distance[i1][j1 + 1] = distance[i1][j1] + matrix[i1][j1 + 1];
                        }

                    }
                }
                if (i1 == m - 1 && j1 == n - 1) {
                    if(SPT_set[i1 - 1][j1]==false){
                        if (distance[i1 - 1][j1] >= 0 && distance[i1][j1] + matrix[i1 - 1][j1] < distance[i1 - 1][j1]) {
                            distance[i1 - 1][j1] = distance[i1][j1] + matrix[i1-1][j1];
                        }
                        if (distance[i1 - 1][j1] < 0) {
                            distance[i1 - 1][j1]=0;
                            distance[i1 - 1][j1] = distance[i1][j1] + matrix[i1 - 1][j1];
                        }
                    }
                    if(SPT_set[i1 ][j1-1]==false) {
                        if (distance[i1][j1 - 1] >= 0 && distance[i1][j1] + matrix[i1][j1-1] < distance[i1][j1 - 1]) {
                            distance[i1][j1 - 1] = distance[i1][j1] + matrix[i1][j1 - 1];
                        }
                        if (distance[i1][j1 - 1] < 0) {
                            distance[i1][j1 - 1]=0;
                            distance[i1][j1 - 1] = distance[i1][j1] + matrix[i1][j1 - 1];
                        }
                    }

                }
                if (i1 == 0 && j1 == n - 1) {
                    if(SPT_set[i1 ][j1-1]==false) {
                        if (distance[i1][j1 - 1] >= 0 && distance[i1][j1] + matrix[i1][j1-1] < distance[i1][j1 - 1]) {
                            distance[i1][j1 - 1] = distance[i1][j1] + matrix[i1][j1 - 1];
                        }
                        if (distance[i1][j1 - 1] < 0) {
                            distance[i1][j1 - 1]=0;
                            distance[i1][j1 - 1] = distance[i1][j1] + matrix[i1][j1 - 1];
                        }
                    }
                    if(SPT_set[i1 +1][j1]==false) {
                        if (distance[i1 + 1][j1] >= 0 && distance[i1][j1] + matrix[i1+1][j1] < distance[i1 + 1][j1]) {
                            distance[i1 + 1][j1] = distance[i1][j1] + matrix[i1+1][j1];
                        }
                        if (distance[i1 + 1][j1] < 0) {
                            distance[i1 + 1][j1]=0;
                            distance[i1 + 1][j1] = distance[i1 ][j1] + matrix[i1 + 1][j1];
                        }
                    }
                    }
                if (i1 == 0 && j1 == 0) {
                    if(SPT_set[i1 ][j1+1]==false) {
                        if (distance[i1][j1 + 1] >= 0 && distance[i1][j1] + matrix[i1][j1+1] < distance[i1][j1 + 1]) {
                            distance[i1][j1 + 1] = distance[i1][j1] + matrix[i1][j1 + 1];
                        }
                        if (distance[i1][j1 + 1] < 0) {
                            distance[i1][j1 + 1]=0;
                            distance[i1][j1 + 1] = distance[i1][j1] + matrix[i1][j1 + 1];
                        }
                    }
                    if(SPT_set[i1 +1][j1]==false) {
                        if (distance[i1 + 1][j1] >= 0 && distance[i1][j1] + matrix[i1+1][j1] < distance[i1 + 1][j1]) {
                            distance[i1 + 1][j1] = distance[i1][j1] + matrix[i1+1][j1];
                        }
                        if (distance[i1 + 1][j1] < 0) {
                            distance[i1 + 1][j1]=0;
                            distance[i1 + 1][j1] = distance[i1 ][j1] + matrix[i1 + 1][j1];
                        }
                    }
                }
                if (i1 > 0 && i1 < m - 1 && j1 == 0) {
                    if(SPT_set[i1 - 1][j1]==false){
                        if (distance[i1 - 1][j1] >= 0 && distance[i1][j1] + matrix[i1 - 1][j1] < distance[i1 - 1][j1]) {
                            distance[i1 - 1][j1] = distance[i1][j1] + matrix[i1-1][j1];
                        }
                        if (distance[i1 - 1][j1] < 0) {
                            distance[i1 - 1][j1]=0;
                            distance[i1 - 1][j1] = distance[i1][j1] + matrix[i1 - 1][j1];
                        }
                    }
                    if(SPT_set[i1 +1][j1]==false) {
                        if (distance[i1 + 1][j1] >= 0 && distance[i1][j1] + matrix[i1+1][j1] < distance[i1 + 1][j1]) {
                            distance[i1 + 1][j1] = distance[i1][j1] + matrix[i1+1][j1];
                        }
                        if (distance[i1 + 1][j1] < 0) {
                            distance[i1 + 1][j1]=0;
                            distance[i1 + 1][j1] = distance[i1 ][j1] + matrix[i1 + 1][j1];
                        }
                    }
                    if(SPT_set[i1 ][j1+1]==false) {
                        if (distance[i1][j1 + 1] >= 0 && distance[i1][j1] + matrix[i1][j1+1] < distance[i1][j1 + 1]) {
                            distance[i1][j1 + 1] = distance[i1][j1] + matrix[i1][j1+1];
                        }
                        if (distance[i1][j1 + 1] < 0) {
                            distance[i1][j1 + 1]=0;
                            distance[i1][j1 + 1] = distance[i1][j1] + matrix[i1][j1 + 1];
                        }

                    }
                }
                if (i1 > 0 && i1 < m - 1 && j1 == n - 1) {
                    if(SPT_set[i1 - 1][j1]==false){
                        if (distance[i1 - 1][j1] >= 0 && distance[i1][j1] + matrix[i1 - 1][j1] < distance[i1 - 1][j1]) {
                            distance[i1 - 1][j1] = distance[i1][j1] + matrix[i1-1][j1];
                        }
                        if (distance[i1 - 1][j1] < 0) {
                            distance[i1 - 1][j1]=0;
                            distance[i1 - 1][j1] = distance[i1][j1] + matrix[i1 - 1][j1];
                        }
                    }
                    if(SPT_set[i1 ][j1-1]==false) {
                        if (distance[i1][j1 - 1] >= 0 && distance[i1][j1] + matrix[i1][j1-1] < distance[i1][j1 - 1]) {
                            distance[i1][j1 - 1] = distance[i1][j1] + matrix[i1][j1 - 1];
                        }
                        if (distance[i1][j1 - 1] < 0) {
                            distance[i1][j1 - 1]=0;
                            distance[i1][j1 - 1] = distance[i1][j1] + matrix[i1][j1 - 1];
                        }
                    }
                    if(SPT_set[i1 +1][j1]==false) {
                        if (distance[i1 + 1][j1] >= 0 && distance[i1][j1] + matrix[i1+1][j1] < distance[i1 + 1][j1]) {
                            distance[i1 + 1][j1] = distance[i1][j1] + matrix[i1+1][j1];
                        }
                        if (distance[i1 + 1][j1] < 0) {
                            distance[i1 + 1][j1]=0;
                            distance[i1 + 1][j1] = distance[i1 ][j1] + matrix[i1 + 1][j1];
                        }
                    }

                }
                if (j1 > 0 && j1 < n - 1 && i1 == 0) {
                    if(SPT_set[i1 ][j1-1]==false) {
                        if (distance[i1][j1 - 1] >= 0 && distance[i1][j1] + matrix[i1][j1-1] < distance[i1][j1 - 1]) {
                            distance[i1][j1 - 1] = distance[i1][j1] + matrix[i1][j1 - 1];
                        }
                        if (distance[i1][j1 - 1] < 0) {
                            distance[i1][j1 - 1]=0;
                            distance[i1][j1 - 1] = distance[i1][j1] + matrix[i1][j1 - 1];
                        }
                    }
                    if(SPT_set[i1 +1][j1]==false) {
                        if (distance[i1 + 1][j1] >= 0 && distance[i1][j1] + matrix[i1+1][j1] < distance[i1 + 1][j1]) {
                            distance[i1 + 1][j1] = distance[i1][j1] + matrix[i1+1][j1];
                        }
                        if (distance[i1 + 1][j1] < 0) {
                            distance[i1 + 1][j1]=0;
                            distance[i1 + 1][j1] = distance[i1 ][j1] + matrix[i1 + 1][j1];
                        }
                    }
                    if(SPT_set[i1 ][j1+1]==false) {
                        if (distance[i1][j1 + 1] >= 0 && distance[i1][j1] + matrix[i1][j1+1] < distance[i1][j1 + 1]) {
                            distance[i1][j1 + 1] = distance[i1][j1] + matrix[i1][j1+1];
                        }
                        if (distance[i1][j1 + 1] < 0) {
                            distance[i1][j1 + 1]=0;
                            distance[i1][j1 + 1] = distance[i1][j1] + matrix[i1][j1 + 1];
                        }

                    }
                }
                if (j1 > 0 && j1 < n - 1 && i1 == m - 1) {
                    if(SPT_set[i1 - 1][j1]==false){
                        if (distance[i1 - 1][j1] >= 0 && distance[i1][j1] + matrix[i1 - 1][j1] < distance[i1 - 1][j1]) {
                            distance[i1 - 1][j1] = distance[i1][j1] + matrix[i1-1][j1];
                        }
                        if (distance[i1 - 1][j1] < 0) {
                            distance[i1 - 1][j1]=0;
                            distance[i1 - 1][j1] = distance[i1][j1] + matrix[i1 - 1][j1];
                        }
                    }
                    if(SPT_set[i1 ][j1+1]==false) {
                        if (distance[i1][j1 + 1] >= 0 && distance[i1][j1] + matrix[i1][j1+1] < distance[i1][j1 + 1]) {
                            distance[i1][j1 + 1] = distance[i1][j1] + matrix[i1][j1+1];
                        }
                        if (distance[i1][j1 + 1] < 0) {
                            distance[i1][j1 + 1]=0;
                            distance[i1][j1 + 1] = distance[i1][j1] + matrix[i1][j1 + 1];
                        }

                    }
                    if(SPT_set[i1 ][j1-1]==false) {
                        if (distance[i1][j1 - 1] >= 0 && distance[i1][j1] + matrix[i1][j1-1] < distance[i1][j1 - 1]) {
                            distance[i1][j1 - 1] = distance[i1][j1] + matrix[i1][j1 - 1];
                        }
                        if (distance[i1][j1 - 1] < 0) {
                            distance[i1][j1 - 1]=0;
                            distance[i1][j1 - 1] = distance[i1][j1] + matrix[i1][j1 - 1];
                        }
                    }
                }
                if (j1 > 0 && j1 < n - 1 && i1 > 0 && i1 < m - 1) {
                    if(SPT_set[i1 - 1][j1]==false){
                        if (distance[i1 - 1][j1] >= 0 && distance[i1][j1] + matrix[i1 - 1][j1] < distance[i1 - 1][j1]) {
                            distance[i1 - 1][j1] = distance[i1][j1] + matrix[i1-1][j1];
                        }
                        if (distance[i1 - 1][j1] < 0) {
                            distance[i1 - 1][j1]=0;
                            distance[i1 - 1][j1] = distance[i1][j1] + matrix[i1 - 1][j1];
                        }
                    }
                    if(SPT_set[i1 +1][j1]==false) {
                        if (distance[i1 + 1][j1] >= 0 && distance[i1][j1] + matrix[i1+1][j1] < distance[i1 + 1][j1]) {
                            distance[i1 + 1][j1] = distance[i1][j1] + matrix[i1+1][j1];
                        }
                        if (distance[i1 + 1][j1] < 0) {
                            distance[i1 + 1][j1]=0;
                            distance[i1 + 1][j1] = distance[i1 ][j1] + matrix[i1 + 1][j1];
                        }
                    }
                    if(SPT_set[i1 ][j1+1]==false) {
                        if (distance[i1][j1 + 1] >= 0 && distance[i1][j1] + matrix[i1][j1+1] < distance[i1][j1 + 1]) {
                            distance[i1][j1 + 1] = distance[i1][j1] + matrix[i1][j1+1];
                        }
                        if (distance[i1][j1 + 1] < 0) {
                            distance[i1][j1 + 1]=0;
                            distance[i1][j1 + 1] = distance[i1][j1] + matrix[i1][j1 + 1];
                        }

                    }
                    if(SPT_set[i1 ][j1-1]==false) {
                        if (distance[i1][j1 - 1] >= 0 && distance[i1][j1] + matrix[i1][j1-1] < distance[i1][j1 - 1]) {
                            distance[i1][j1 - 1] = distance[i1][j1] + matrix[i1][j1 - 1];
                        }
                        if (distance[i1][j1 - 1] < 0) {
                            distance[i1][j1 - 1]=0;
                            distance[i1][j1 - 1] = distance[i1][j1] + matrix[i1][j1 - 1];
                        }
                    }
                }
                min = Long.MAX_VALUE;
                for (int p = 0; p < m; p++) {
                    for (int q = 0; q < n; q++) {
                        if (SPT_set[p][q] == false && distance[p][q] < min && distance[p][q] >= 0) {
                            min = distance[p][q];
                            i1 = p;
                            j1 = q;
                        }
                    }
                }
                SPT_set[i1][j1] = true;
            }
            System.out.println(distance[index_end_i][index_end_j]);
        }
    }

