package GUI;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import service.CustomerService;
import service.VehicleService;

public class MainFrame {
    private  JFrame fr;
    private  JButton btnManageCustomer, btnManageVehicle, btnManageVehicleCheck, btnThoat;
    private JMenu menuManage1, menuManage2;
    private JMenuBar menuBar;
    private JMenuItem menuCustomers, menuVehicles, menuLogout, menuExit ;
    private JPanel mainPanel, panel1;
    public MainFrame() {

        fr = new JFrame("Quản Lý Bãi Đỗ Xe");
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fr.setSize(800, 600);
        fr.setLayout(new BorderLayout());

        Font font = new Font("Arial", Font.PLAIN, 16);

        mainPanel = new JPanel(new BorderLayout());
        mainPanel.setLayout(new GridLayout(1,2));

        btnManageVehicle = new JButton("Quản lí thông tin xe");
        btnManageCustomer = new JButton("Quản lí thông tin khách hàng");
        btnManageVehicleCheck = new JButton("Quản lí thông tin ra vào");

        mainPanel.add(btnManageCustomer);
        mainPanel.add(btnManageVehicle);
        mainPanel.add(btnManageVehicleCheck);

        menuBar = new JMenuBar();
        menuManage1 = new JMenu("Quản lý");
        menuCustomers = new JMenuItem("Quản lý Khách Hàng");
        menuVehicles = new JMenuItem("Quản lý Xe");

        menuManage2 = new JMenu("Tài khoản");
        menuLogout = new JMenuItem("Đăng xuất");
        menuExit = new JMenuItem("Thoát");

        menuManage1.add(menuCustomers);
        menuManage1.add(menuVehicles);
        menuBar.add(menuManage1);

        menuManage2.add(menuLogout);
        menuManage2.add(menuExit);
        menuBar.add(menuManage2);

        btnManageCustomer.setFont(font);
        btnManageVehicle.setFont(font);

        panel1 = new JPanel();
        btnThoat = new JButton("Thoát");
        panel1.add(btnThoat);

        menuCustomers.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new CustomerFrame();
            }
        });
        btnManageCustomer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new CustomerFrame();
            }
        });

        menuVehicles.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new VehicleFrame();
            }
        });
        btnManageVehicle.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new VehicleFrame();
            }
        });

        btnManageVehicleCheck.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ManageVehicleFrame();
            }
        });

        menuLogout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fr.dispose();
                new Login();
            }
        });

        menuExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        btnThoat.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        fr.setJMenuBar(menuBar);
        fr.add(panel1, BorderLayout.SOUTH);
        fr.add(mainPanel, BorderLayout.NORTH);
        fr.setVisible(true);
    }
}
