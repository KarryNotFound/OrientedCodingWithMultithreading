package com.whut;

import com.whut.classes.DataProcessing;
import com.whut.classes.User;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int o;
        do {
            System.out.println("\n");
            System.out.println("------ 欢迎来到档案管理系统 ------");
            System.out.println("\t\t\t1.登录");
            System.out.println("\t\t\t0.退出");

            System.out.print("请输入你的选择：");
            o = sc.nextInt();
            switch (o) {
                case 1:
                    login();
                    break;
                case 0:
                    System.exit(0);
                    break;
                default:
                    System.out.println("输入错误");
                    break;
            }
            System.out.println("程序暂停.....按回车以继续.....");
            sc.nextLine();
            sc.nextLine();
        } while(o != 0);
    }


    public static void login() {
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入用户名：");
        String name,password;
        name = sc.next();
        if(DataProcessing.searchUser(name) == null){
            System.out.println("你输入的用户不存在！！");
            return;
        }
        System.out.print("请输入口令：");
        password = sc.next();
        User u = DataProcessing.search(name,password);
        if(u == null) {
            System.out.println("你输入的用户信息不存在！");
            return;
        }
        u.showMenu();
    }


}