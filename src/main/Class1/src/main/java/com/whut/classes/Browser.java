package com.whut.classes;

import java.util.Scanner;

public class Browser extends User{ //档案浏览人员
    public Browser(String name, String password, String role) {
        super(name,password,role);
    }

    @Override
    public void showMenu() {


        Scanner sc = new Scanner(System.in);
        int o;
       do{
           System.out.println("\n");
           System.out.println("------欢迎登录 档案浏览人员 管理界面------");
           System.out.println("\t\t\t1.下载档案");
           System.out.println("\t\t\t2.档案列表");
           System.out.println("\t\t\t3.修改密码");
           System.out.println("\t\t\t4.退出登录");
            System.out.print("请输入你的选择：");
            o = sc.nextInt();
            switch (o) {
                case 1:
                    downloadFile("#");
                    break;
                case 2:
                    showFileList();
                    break;
                case 3:
                    changePassword();
                    break;
                case 4:
                    System.out.println("登录已退出");
                    break;
                default:
                    System.out.println("输入错误");
                    break;
            }
            if(o == 4) break;
           System.out.println("程序暂停.....按回车以继续.....");
           sc.nextLine();
           sc.nextLine();
        }   while(o != 4);
    }

    public void changePassword() {
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入你现在的密码：");
        String p = sc.next();
        if(p.equals(this.getPassword())){
            System.out.print("请输入你要更改的密码：");
            p = sc.next();
            System.out.print("请再次输入你要更改的密码：");
            String pAgain = sc.next();
            if(p.equals(pAgain)){
                DataProcessing.update(getName(),p,getRole());
                System.out.println("信息更改完毕！");
            }else{
                System.out.println("两次输入的密码不一致！");
            }
        }else{
            System.out.println("密码输入错误！");
        }
    }
}
