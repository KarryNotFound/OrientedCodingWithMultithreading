package com.whut.classes;

import java.util.Scanner;

public class Administratior extends User{
    public Administratior(String name, String password, String role) { //系统管理员
        super(name,password,role);
    }
    @Override
    public void showMenu() {

        Scanner sc = new Scanner(System.in);
        int o;
        do{
            System.out.println("\n");
            System.out.println("------欢迎登录 系统管理员 管理界面------");
            System.out.println("\t\t\t1.新增用户");
            System.out.println("\t\t\t2.删除用户");
            System.out.println("\t\t\t3.修改用户");
            System.out.println("\t\t\t4.用户列表");
            System.out.println("\t\t\t5.下载档案");
            System.out.println("\t\t\t6.档案列表");
            System.out.println("\t\t\t7.修改密码");
            System.out.println("\t\t\t8.退出登录");
            System.out.print("请输入你的选择：");
            o = sc.nextInt();
            switch (o) {
                case 1:
                    addUser();
                    break;
                case 2:
                    deleteUser();
                    break;
                case 3:
                    modifyUser();
                    break;
                case 4:
                    showUserList();
                    break;
                case 5:
                    downloadFile("#");
                    break;
                case 6:
                    showFileList();
                    break;
                case 7:
                    changePassword();
                    break;
                case 8:
                    System.out.println("登录已退出");
                    break;
                default:
                    System.out.println("输入错误");
                    break;
            }
            if(o == 8) break;
            System.out.println("程序暂停.....按回车以继续.....");
            sc.nextLine();
            sc.nextLine();
        }   while(o != 8);
    }

    private void modifyUser() {
        String name,password,role;
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入你要修改的用户名称：");
        name = sc.next();
        User u;
        if((u = DataProcessing.searchUser(name)) == null){
            System.out.println("你输入的用户不存在！");
            return;
        }
        System.out.println("请输入你要修改的用户信息：");
        System.out.println("姓名：" + u.getName());
        System.out.print("口令：");
        password = sc.next();
        System.out.print("职位：");
        role = sc.next();
        String flag;
        System.out.print("请确认(确认/不确认)：");
        flag = sc.next();
        if(!flag.equals("确认")) {
            return;
        }
        DataProcessing.update(u.getName(),password,role);
        System.out.println(u.getName()+ " 的信息已更新完毕");
        return;
    }

    private void deleteUser() {
        String name,password,role;
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入你要删除的员工信息：");
        name = sc.next();
        if(DataProcessing.searchUser(name) == null) {
            System.out.println("你要删除的员工不存在");
            return;
        }
        String flag;
        System.out.print("你确定要删除吗(确认/不确认)：");
        flag = sc.next();
        if(!flag.equals("确认")) return;
        if(DataProcessing.delete(name)) {
            System.out.println(name + " 员工删除成功！");
            return;
        }
        System.out.println("员工删除失败！");
        return;
    }

    private void addUser() {
        String name,password,role;
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入要添加的用户：");
        name = sc.next();
        if(DataProcessing.searchUser(name) != null) {
            System.out.println("用户名已存在");
            return;
        }
        System.out.print("请输入口令：");
        password = sc.next();
        System.out.print("请输入职位：");
        role = sc.next();
       if(DataProcessing.insert(name,password,role)){
           System.out.println("添加员工成功！");
            return;
       }
       System.out.println("添加员工失败！");
       System.out.println("职位不存在！！");
       return;
    }

    private void showUserList(){
        System.out.printf("%-18s %-15s %-10s\n","姓名","口令","职位");
        DataProcessing.users.forEach((s, user) -> {
            System.out.printf("%-20s %-15s %-10s\n",user.getName(),user.getPassword(),user.getRole());
        });
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
