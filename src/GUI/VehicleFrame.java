package GUI;

import model.Customer;
import model.Vehicle;
import service.VehicleService;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class VehicleFrame {
    private JFrame frame;
    private JPanel panel1, panelButton;
    private JTextField txtlicensePlate, txtID, txtType, txtparkingSpot, txtparkingDate, searchFields, txtCheckIn, txtCheckOut, txtFee;
    private JButton btnThem, btnSua, btnXoa, btnTimKiem, btnThoat;
    private JTable table;
    private DefaultTableModel model;
    private VehicleService vehicleService;
    public VehicleFrame() {

        vehicleService = new VehicleService();

        frame = new JFrame("Quản lý Xe");
        frame.setSize(600, 400);
        frame.setLayout(new BorderLayout());

        frame.setLocationRelativeTo(null);
        frame.setAlwaysOnTop(true);

        Font font = new Font("Arial", Font.PLAIN, 16);

        panel1 = new JPanel(new GridLayout(2,2,10,10));
        panel1.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        txtlicensePlate = new JTextField(15);
        txtID = new JTextField(15);
        txtType = new JTextField(15);
        txtparkingSpot = new JTextField(15);
        txtparkingDate = new JTextField(15);
        txtCheckIn = new JTextField(15);
        txtCheckOut = new JTextField(15);
        txtFee = new JTextField(15);



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
        panel1.add(new JLabel("Phí"));
        panel1.add(txtFee);

        panelButton = new JPanel();
        btnThem = new JButton("Thêm");
        btnSua = new JButton("Sửa");
        btnXoa = new JButton("Xóa");
        btnTimKiem = new JButton("Tìm kiếm");
        searchFields = new JTextField(10);
        btnThoat = new JButton("Thoát");
        panelButton.add(btnThem);
        panelButton.add(btnXoa);
        panelButton.add(btnSua);
        panelButton.add(btnThoat);
        panelButton.add(btnTimKiem);
        panelButton.add(searchFields);

        model = new DefaultTableModel();
        model.setColumnIdentifiers(new String[]{"Biển số xe", "Mã chủ xe", "Loại xe", "Vị trí đỗ xe", "Ngày đăng kí thuê","Ngày giờ vào", "Ngày giờ ra", "Phí phải trả"});
        table = new JTable(model);

        JScrollPane scrollPane = new JScrollPane(table);

        txtlicensePlate.setFont(font);
        txtID.setFont(font);
        txtType.setFont(font);
        txtparkingSpot.setFont(font);
        txtparkingDate.setFont(font);
        txtCheckIn.setFont(font);
        txtCheckOut.setFont(font);
        txtFee.setFont(font);

        for (Component c : panel1.getComponents()) {
            if (c instanceof JLabel) {
                c.setFont(font);
            }
        }

        btnThem.setFont(font);
        btnSua.setFont(font);
        btnXoa.setFont(font);
        btnTimKiem.setFont(font);
        btnThoat.setFont(font);

        table.setFont(new Font("Arial", Font.PLAIN, 14));
        table.setRowHeight(25);


        table.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting() && table.getSelectedRow() != -1){
                int row = table.getSelectedRow();

                txtlicensePlate.setText(table.getValueAt(row, 0).toString());
                txtID.setText(table.getValueAt(row, 1).toString());
                txtType.setText(table.getValueAt(row, 2).toString());
                txtparkingSpot.setText(table.getValueAt(row, 3).toString());
                txtparkingDate.setText(table.getValueAt(row, 4).toString());
                txtCheckIn.setText(table.getValueAt(row, 5).toString());
                txtCheckOut.setText(table.getValueAt(row, 6).toString());
                txtFee.setText(table.getValueAt(row,7).toString());
            }
        });

        btnThem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        btnXoa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        btnSua.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        btnTimKiem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        btnThoat.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
            }
        });

        loadVehicle();

        frame.add(panelButton, BorderLayout.SOUTH);
        frame.add(scrollPane);
        frame.add(panel1, BorderLayout.NORTH);
        frame.setVisible(true);
    }
    private void loadVehicle(){
        model.setRowCount(0);
        List<Vehicle> vehicles = vehicleService.getAllVehicle();
        for (Vehicle vehicle : vehicles){
            model.addRow(new Object[]{
                    vehicle.getLicensePlate(),
                    vehicle.getOwnerId(),
                    vehicle.getType(),
                    vehicle.getParkingSpot(),
                    vehicle.getParkingDate(),
                    vehicle.getCheckInTime(),
                    vehicle.getCheckOutTime(),
                    vehicle.getFee()
            });
        }
    }
}
