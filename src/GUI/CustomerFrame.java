package GUI;

import model.Customer;
import service.CustomerService;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class CustomerFrame {
    private JFrame fr;
    private JPanel panel1, panelButton;
    private  JTextField txtID, txtName, txtPhone, txtRegistrationDate, searchFields;
    private  JButton btnThem, btnSua, btnXoa, btnTimKiem, btnThoat;
    private JTable table;
    private DefaultTableModel model;
    private CustomerService customerService;
    public CustomerFrame() {

        fr = new JFrame("Quản lý Khách Hàng");
        fr.setSize(600, 400);
        fr.setLayout(new BorderLayout());

        fr.setLocationRelativeTo(null);
        fr.setAlwaysOnTop(true);

        customerService = new CustomerService();

        Font font = new Font("Arial", Font.PLAIN, 16);

        panel1 = new JPanel(new GridLayout(2,2,10,10));
        panel1.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        txtID = new JTextField(15);
        txtName = new JTextField(15);
        txtPhone = new JTextField(15);
        txtRegistrationDate = new JTextField(15);

        panel1.add(new JLabel("Mã Chủ Xe"));
        panel1.add(txtID);
        panel1.add(new JLabel("Tên Chủ Xe"));
        panel1.add(txtName);
        panel1.add(new JLabel("SĐT Chủ Xe"));
        panel1.add(txtPhone);
        panel1.add(new JLabel("Ngày Đăng Kí"));
        panel1.add(txtRegistrationDate);

        for (Component c : panel1.getComponents()) {
            if (c instanceof JLabel) {
                c.setFont(font);
            }
        }

        txtID.setFont(font);
        txtPhone.setFont(font);
        txtName.setFont(font);
        txtRegistrationDate.setFont(font);

        panelButton = new JPanel();
//        btnThem = new JButton("Thêm");
//        btnSua = new JButton("Sửa");
//        btnXoa = new JButton("Xóa");
        btnTimKiem = new JButton("Tìm kiếm");
        searchFields = new JTextField(10);
        btnThoat = new JButton("Thoát");
//        panelButton.add(btnThem);
//        panelButton.add(btnXoa);
//        panelButton.add(btnSua);
        panelButton.add(btnThoat);
        panelButton.add(btnTimKiem);
        panelButton.add(searchFields);

//        btnThem.setFont(font);
//        btnSua.setFont(font);
//        btnXoa.setFont(font);
        btnTimKiem.setFont(font);
        btnThoat.setFont(font);

        model = new DefaultTableModel();
        model.setColumnIdentifiers(new String[]{"Mã KH", "Họ Tên", "SĐT", "Ngày đăng kí", "Số giờ thuê"});
        table = new JTable(model);

        JScrollPane scrollPane = new JScrollPane(table);

        table.setFont(new Font("Arial", Font.PLAIN, 14));
        table.setRowHeight(25);

        table.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting() && table.getSelectedRow() != -1){
                int row = table.getSelectedRow();
                txtID.setText(table.getValueAt(row, 0).toString());
                txtName.setText(table.getValueAt(row, 1).toString());
                txtPhone.setText(table.getValueAt(row, 2).toString());

                txtRegistrationDate.setText(table.getValueAt(row, 3).toString());

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
                fr.setVisible(false);
            }
        });

        loadCustomer();

        fr.add(panelButton, BorderLayout.SOUTH);
        fr.add(scrollPane);
        fr.add(panel1, BorderLayout.NORTH);
        fr.setVisible(true);
    }
    private void loadCustomer(){
        model.setRowCount(0);
        List<Customer> customers = customerService.getAllCustomer();
        for (Customer customer : customers){
            model.addRow(new Object[]{
                customer.getId(),
                customer.getName(),
                customer.getPhone(),
                customer.getRegistrationDate(),
                customer.getRent()
            });
        }
    }
}
