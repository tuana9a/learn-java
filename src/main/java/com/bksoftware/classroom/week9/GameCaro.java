package com.bksoftware.classroom.week9;

import java.util.Scanner;

public class GameCaro {
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        caroThreeByThree();
    }
    public static void caroThreeByThree(){
        System.out.println("Nhập vào thằng thứ nhất");//thằng thứ nhất là 1
        String player1 = input.nextLine();
        System.out.println("Nhập vào thằng thứ hai");//thằng thứ hai là -1
        String player2 = input.nextLine();
        int[][] a = new int[3][3];
        //printXO(a);
        //boolean check = true;//chưa có ai thắng
        int step=1;
        while(step<=9){
            int choose;
            if(step%2!=0){
                System.out.println(player1 + " là X, " + player1 + " chọn ô nào (1-9)");
                do{
                    choose=input.nextInt()-1;
                    if(choose>8 || choose<0 || a[choose/3][choose%3]!=0) System.out.println(player1 + " chọn ngu, cho chọn lại");
                } while(choose>8 || choose<0 || a[choose/3][choose%3]!=0);
                a[choose/3][choose%3]=1;
            }
            else{
                System.out.println(player2 +" là O, " + player2 + " chọn ô nào (1-9)");
                do{
                    choose=input.nextInt()-1;
                    if(choose>8 || choose<0 || a[choose/3][choose%3]!=0) System.out.println(player2 + " chọn ngu, cho chọn lại");
                } while(choose>8 || choose<0 || a[choose/3][choose%3]!=0);
                a[choose/3][choose%3]=-1;
            }
            printXO(a);
            int stop = check(a,step%2);
            if(stop==1){
                System.out.println(player1 + " win! " + player2 + " NGU!");
                break;
            } else if (stop==2) {
                System.out.println(player2 + " win! " + player1 + " NGU!");
                break;
            }
            if(step==9) System.out.println("Các bạn chơi ngu vl");
            step++;
        }
    }
    public static int check(int[][] a,int turn){
        int sum;
        if(turn==1){
            if(a[1][1]==1){
              for(int i=0;i<3;++i){
                  for(int j=0;j<3;++j){
                      if(i==1 && j==1) break;
                      sum=a[i][j]+a[1][1]+a[2-i][2-j];
                      if(sum==3) return 1;
                  }
              }
            }
            sum=a[0][0]+a[0][1]+a[0][2];
            if(sum==3) return 1;
            sum=a[0][0]+a[1][0]+a[2][0];
            if(sum==3) return 1;
            sum=a[2][2]+a[1][2]+a[0][2];
            if(sum==3) return 1;
            sum=a[2][2]+a[2][1]+a[2][0];
            if(sum==3) return 1;
            return 0;

        }
        else{
            if(a[1][1]==-1) {
                for (int i = 0; i < 3; ++i) {
                    for (int j = 0; j < 3; ++j) {
                        if (i == 1 && j == 1) break;
                        sum = a[i][j] + a[1][1] + a[2 - i][2 - j];
                        if (sum == -3) return 2;
                    }
                }
            }
            sum=a[0][0]+a[0][1]+a[0][2];
            if(sum==-3) return 2;
            sum=a[0][0]+a[1][0]+a[2][0];
            if(sum==-3) return 2;
            sum=a[2][2]+a[1][2]+a[0][2];
            if(sum==-3) return 2;
            sum=a[2][2]+a[2][1]+a[2][0];
            if(sum==-3) return 2;
            return 0;
        }
    }
    public static void printXO(int[][] a){
        System.out.println("-----------");
        for(int i=0;i<3;++i){
            for(int j=0;j<3;++j){
                if(a[i][j]==1) System.out.print("|X| ");
                if(a[i][j]==-1) System.out.print("|O| ");
                if(a[i][j]==0) System.out.print("| | ");
            };
            System.out.print("\n");
        }
        System.out.println("-----------");
    }




    //thêm phần tử vào một mảng trả về một mảng mới
    public static int[] addNumberToArray(int[] in, int pos, int num){
        int[] out = new int[in.length+1];
        for(int i=0,j=0;i<out.length;++i){
            if(i==pos) out[i]=num;
            else out[i]=in[j++];
        }
        return out;

    }

}
