package GUI;

import service.ManageService;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ManageVehicleFrame {
    private JFrame fr;
    private ManageService manageService;
    private JPanel panel1, panelButton;
    private JTextField txtlicensePlate, txtID, txtType, txtparkingSpot, txtparkingDate, txtCheckIn, txtCheckOut, txtFee, searchFields;
    private JButton btnTimKiem, btnThoat, btnCheckIn, btnCheckOut;
    private  DefaultTableModel model;
    private JTable table;
    public ManageVehicleFrame(){
        manageService = new ManageService();

        fr = new JFrame("Main");
        fr.setSize(600, 400);
        fr.setLayout(new BorderLayout());

        fr.setLocationRelativeTo(null);
        fr.setAlwaysOnTop(true);

        Font font = new Font("Arial", Font.PLAIN, 16);

        panel1 = new JPanel(new GridLayout(2, 2, 10, 10));
        panel1.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        txtlicensePlate = new JTextField(15);
        txtID = new JTextField(15);
        txtType = new JTextField(15);
        txtparkingSpot = new JTextField(15);
        txtparkingDate = new JTextField(15);
        txtCheckIn = new JTextField(15);
        txtCheckOut = new JTextField(15);


        panel1.add(new JLabel("Biển số xe"));
        panel1.add(txtlicensePlate);
        panel1.add(new JLabel("Mã Chủ Xe"));
        panel1.add(txtID);
        panel1.add(new JLabel("Loại xe"));
        panel1.add(txtType);
        panel1.add(new JLabel("Vị trí đỗ"));
        panel1.add(txtparkingSpot);
        panel1.add(new JLabel("Ngày Đăng Kí"));
        panel1.add(txtparkingDate);
        panel1.add(new JLabel("Thời gian ra"));
        panel1.add(txtCheckIn);
        panel1.add(new JLabel("Thời gian vào"));
        panel1.add(txtCheckOut);

        btnCheckIn = new JButton("Vào");
        btnCheckOut = new JButton("Ra");
        btnTimKiem = new JButton("Tìm kiếm");
        searchFields = new JTextField(10);
        btnThoat = new JButton("Thoát");

        panelButton = new JPanel();
        panelButton.add(btnCheckIn);
        panelButton.add(btnCheckOut);
        panelButton.add(btnThoat);
        panelButton.add(btnTimKiem);
        panelButton.add(searchFields);

        model = new DefaultTableModel();
        model.setColumnIdentifiers(new String[]{"Biển số xe", "Mã chủ xe", "Loại xe", "Vị trí đỗ xe", "Ngày đăng kí thuê", "Ngày giờ vào", "Ngày giờ ra", "Phí phải trả"});
        table = new JTable(model);

        JScrollPane scrollPane = new JScrollPane(table);

        txtlicensePlate.setFont(font);
        txtID.setFont(font);
        txtType.setFont(font);
        txtparkingSpot.setFont(font);
        txtparkingDate.setFont(font);
        txtCheckIn.setFont(font);
        txtCheckOut.setFont(font);

        for (Component c : panel1.getComponents()) {
            if (c instanceof JLabel) {
                c.setFont(font);
            }
        }

        btnTimKiem.setFont(font);
        btnThoat.setFont(font);
        btnCheckIn.setFont(font);
        btnCheckOut.setFont(font);

        table.setFont(new Font("Arial", Font.PLAIN, 14));
        table.setRowHeight(25);

        btnThoat.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fr.setVisible(false);
            }
        });

        fr.add(panelButton, BorderLayout.SOUTH);
        fr.add(scrollPane);
        fr.add(panel1, BorderLayout.NORTH);
        fr.setVisible(true);
    }
}
