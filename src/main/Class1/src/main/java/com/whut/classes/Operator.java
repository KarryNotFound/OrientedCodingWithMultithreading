package com.whut.classes;

import java.util.Scanner;

public class Operator extends User{ //档案录入人员
    public Operator(String name, String password, String role) {
        super(name,password,role);
    }

    @Override
    public void showMenu() {


        Scanner sc = new Scanner(System.in);
        int o;
        do{
            System.out.println("\n");
            System.out.println("------欢迎登录 档案录入人员 管理界面------");
            System.out.println("\t\t\t1.上传档案");
            System.out.println("\t\t\t2.下载档案");
            System.out.println("\t\t\t3.档案列表");
            System.out.println("\t\t\t4.修改密码");
            System.out.println("\t\t\t5.退出登录");
            System.out.print("请输入你的选择：");
            o = sc.nextInt();
            switch (o) {
                case 1:
                    uploadFile("#");
                    break;
                case 2:
                    downloadFile("#");
                    break;
                case 3:
                    showFileList();
                    break;
                case 4:
                    changePassword();
                    break;
                case 5:
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

    public void uploadFile(String fileName){
        System.out.println("上传文件.........");
        return;
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
