/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Color;
import model.*;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.Timer;
import transformation.DoiXung;
import transformation.ThuPhong;

/**
 *
 * @author tuanbuiquoc
 */
public class CarAnimation extends javax.swing.JFrame {

    Graphics g;
    public static int step = 5, graphWidth, graphHeight;
    public int x1 = 0, y1 = 0;
    public int x2, y2;
    String drawMode = "";

    public class carAnimation extends JPanel implements ActionListener {

        int graphHeight;
        int graphWidth;
        int x1 = -90;
        int y1 = 0;
        int ymt = 280;
        int xmt = 1;
        int x2 = -150;
        int x3 = -150;
        int dem = 0;
        int red = 34, green = 154, blue = 203;
        Color mauCayThong = new Color(46, 139, 87);//ban dem 0/100/0

        CayThong cayThong1;
        CayThong cayThong2;
        CayThong cayThong3;

        DuongTron matTroi;
        May may1;
        May may2;
        May may3;
        May may4;
        May may5;
        May may6;
        BienBao bienBao;

        New_Oto newOto;
        Oto oto;

        DoanThang denDuong1;
        DoanThang denDuong2;

        @Override
        public void setSize(int width, int height) {
            super.setSize(width, height); //To change body of generated methods, choose Tools | Templates.
        }
        Timer tm = new Timer(5, this);

        @Override
        public void paintComponent(Graphics g) {

            super.paintComponent(g);

            graphHeight = this.getBounds().height;
            graphWidth = this.getBounds().width;

            try {
                g.setColor(new Color(red, green, blue));
            } catch (java.lang.IllegalArgumentException ex) {
                red = 0;
                green = 1;
                blue = 1;
            }

//            System.out.println("rgb: " + red + "," + green + "," + blue);
            g.fillRect(0, 0, graphWidth, graphHeight / 2);
            
            g.fillRect(0, graphHeight / 2, graphWidth, graphHeight / 2);
            g.setColor(Color.black);
            g.drawLine(0, graphHeight / 2, graphWidth, graphHeight / 2);
            
           
            int inc = 1;
            int desc = -1;
            if (jCheckBox_DrawGrid.isSelected()) {
                for (int i = 0; i < graphWidth; i += step) {
                    g.setColor(Color.lightGray);

                    g.drawLine(graphWidth / 2 - i, graphHeight / 2 - graphHeight / 2, graphWidth / 2 - i, graphHeight / 2 + graphHeight / 2);

                    g.drawLine(graphWidth / 2 + i, graphHeight / 2 - graphHeight / 2, graphWidth / 2 + i, graphHeight / 2 + graphHeight / 2);

                    g.drawLine(graphWidth / 2 - graphWidth / 2, graphHeight / 2 - i, graphWidth / 2 + graphWidth / 2, graphHeight / 2 - i);

                    g.drawLine(graphWidth / 2 - graphWidth / 2, graphHeight / 2 + i, graphWidth / 2 + graphWidth / 2, graphHeight / 2 + i);

                    inc++;
                    desc--;
                }
            }

            g.setColor(Color.green);
            // set mau cho cây thông
            if (mode.equals("day")) {
                mauCayThong = new Color(46, 139, 87);
            }

            if (mode.equals("night")) {
                g.setColor(Color.lightGray);
                mauCayThong = new Color(40, 120, 60);
            }
            starShow(g);
            sunGoDown(g);

            // set màu cho mây
            g.setColor(Color.white);
            if (mode.equals("night")) {
                g.setColor(Color.lightGray);
            }

            mayX2(g);
            mayX3(g);

            if (dem == 0) {
                scene0(g);
            }
            if (dem == 1) {
                scene1(g);
            }
            if (dem == 2) {
                scene2(g);
            }
            if (dem == 3) {
                scene3(g);
            }
            if (dem == 4) {
                scene4(g);
            }
//            System.out.println("scene    " + dem);

//            oto = new Oto(graphWidth / 2 + 20 * step, graphHeight / 2 - y1 * step - 10, 50 * step);
//            oto.veOto((Graphics2D) g);
            newOto = new New_Oto(graphWidth / 2 + 20 * step, graphHeight / 2 - y1 * step - 10, graphWidth / 2 + 20 * step + 270, graphHeight / 2 - y1 * step - 10);
            newOto.veNewOto((Graphics2D) g);

            dxNewOto(newOto, (Graphics2D) g);
            newOto = new New_Oto(graphWidth / 2 + 20 * step, graphHeight / 2 - y1 * step - 10, graphWidth / 2 + 20 * step + 270, graphHeight / 2 - y1 * step - 10);
            if (jCheckBox2.isSelected()) {
                xRay(g);
            }

//            g.setColor(Color.DARK_GRAY);
//            g.fillRect(0, graphHeight / 2, graphWidth, graphHeight / 2);
            if (jCheckBox_DrawCoor.isSelected()) {
                g.setColor(Color.black);
                g.drawLine(graphWidth / 2, 0, graphWidth / 2, graphHeight);
                g.drawLine(0, graphHeight / 2, graphWidth, graphHeight / 2);
            }
             g.setColor(new Color(21, 67, 96, 50));
            g.fillRect(0, graphHeight / 2, graphWidth, graphHeight / 2);
            clear_ToaDo();
            hienToaDo();
        }
        int carRunMode = 0;
        int greyToBlue = 0;
        int demMau = 0;
        String mode = "day";
        double scale = 2;

        @Override
        public void actionPerformed(ActionEvent e) {

            if (x2 > 400) {
                x2 = -240;
            }

            if (x1 > 200) {
                x1 = -120;
                dem++;
                if (dem > 4) {
                    dem = 0;
                }
            }

            if (x3 > 800) {
                x3 = -400;
            }

            x1 = x1 + 3;
            x2 = x2 + 1;
            x3 = x3 + 2;

            demMau++;

            if (demMau % 40 == 0) {
                if (greyToBlue == 0) {
                    if (red < 3) {
                        mode = "night";
                        if (dem != 2 && dem != 3) {
                            greyToBlue = 1;
                        } else {

                        }
                        demMau = 1;
                        red = 0;
                        green = 1;
                        blue = 1;
                    }
                    red = red - 3;
                    green = green - 13;
                    blue = blue - 17;
                }
                if (greyToBlue == 1) {

                    red = red + 3;
                    green = green + 13;
                    blue = blue + 17;
                    if (red > 34) {
                        mode = "day";
                        if (dem != 1 && dem != 4) {
                            greyToBlue = 0;
                        } else {

                        }
                        demMau = 1;
                        red = 34;
                        green = 154;
                        blue = 203;
                    }
                }
            }
            if (x3 % 15 == 0 && mode.equals("night")) {
                scale = 1.5;
                scaleStar(sao1, scale);
                scaleStar(sao2, scale);
                scaleStar(sao3, scale);
                scaleStar(sao4, scale);
                scaleStar(sao5, scale);
                scaleStar(sao6, scale);
                scaleStar(sao7, scale);
                scaleStar(sao8, scale);
                scaleStar(sao9, scale);

            } else {
                initStar();
            }
//            System.out.println("scale  " + scale);
//            System.out.println("x1:" + x1);
//            System.out.println("x2:" + x2);
//            System.out.println("x3:" + x3);
            repaint();
        }

        public void clear_ToaDo() {
            jTextField_xMatTroi.setText("");
            jTextField_yMatTroi.setText("");

            jTextField_xDinhCayThong1.setText("");
            jTextField_yDinhCayThong1.setText("");

            jTextField_xDinhCayThong2.setText("");
            jTextField_yDinhCayThong2.setText("");

            jTextField_xDinhCayThong3.setText("");
            jTextField_yDinhCayThong3.setText("");

            jTextField_xTamBienBao.setText("");
            jTextField_yTamBienBao.setText("");

            jTextField_xMuiXe.setText("");
            jTextField_yMuiXe.setText("");

            jTextField_xDinhDenDuong1.setText("");
            jTextField_yDinhDenDuong1.setText("");

            jTextField_xDinhDenDuong2.setText("");
            jTextField_yDinhDenDuong2.setText("");

            jTextField_xMay1.setText("");
            jTextField_yMay1.setText("");

            jTextField_xMay2.setText("");
            jTextField_yMay2.setText("");

            jTextField_xMay3.setText("");
            jTextField_yMay3.setText("");

            jTextField_xMay4.setText("");
            jTextField_yMay4.setText("");

            jTextField_xMay5.setText("");
            jTextField_yMay5.setText("");

            jTextField_xMay6.setText("");
            jTextField_yMay6.setText("");

        }

        public void hienToaDo() {
            jTextField_xMatTroi.setText(xNguoiDung(matTroi.getxO()) + "");
            jTextField_yMatTroi.setText(yNguoiDung(matTroi.getyO()) + "");

            jTextField_xDinhCayThong1.setText(xNguoiDung(cayThong1.getxDinh()) + "");
            jTextField_yDinhCayThong1.setText(yNguoiDung(cayThong1.getyDinh()) + "");

            jTextField_xDinhCayThong2.setText(xNguoiDung(cayThong2.getxDinh()) + "");
            jTextField_yDinhCayThong2.setText(yNguoiDung(cayThong2.getyDinh()) + "");

            jTextField_xDinhCayThong3.setText(xNguoiDung(cayThong3.getxDinh()) + "");
            jTextField_yDinhCayThong3.setText(yNguoiDung(cayThong3.getyDinh()) + "");

            jTextField_xTamBienBao.setText(xNguoiDung(bienBao.getxTamBienBao()) + "");
            jTextField_yTamBienBao.setText(yNguoiDung(bienBao.getyTamBienBao()) + "");
//            if (oto != null) {
//                jTextField_xMuiXe.setText(xNguoiDung(oto.getxMuiXe()) + "");
//                jTextField_yMuiXe.setText(yNguoiDung(oto.getyMuiXe()) + "");
//            }
            
            if (newOto != null) {
                jTextField_xMuiXe.setText(xNguoiDung(newOto.getxMuiXeDuoi()) + "");
                jTextField_yMuiXe.setText(yNguoiDung(newOto.getyMuiXeDuoi()) + "");
            }

            if (denDuong1 != null) {
                jTextField_xDinhDenDuong1.setText(xNguoiDung(denDuong1.getX2()) + "");
                jTextField_yDinhDenDuong1.setText(yNguoiDung(denDuong1.getY2()) + "");

            }
            if (denDuong2 != null) {
                jTextField_xDinhDenDuong2.setText(xNguoiDung(denDuong2.getX2()) + "");
                jTextField_yDinhDenDuong2.setText(yNguoiDung(denDuong2.getY2()) + "");
            }
            if (may1 != null) {
                jTextField_xMay1.setText(xNguoiDung(may1.getxO()) + "");
                jTextField_yMay1.setText(yNguoiDung(may1.getyO()) + "");
            }

            if (may2 != null) {
                jTextField_xMay2.setText(xNguoiDung(may2.getxO()) + "");
                jTextField_yMay2.setText(yNguoiDung(may2.getyO()) + "");
            }
            if (may3 != null) {
                jTextField_xMay3.setText(xNguoiDung(may3.getxO()) + "");
                jTextField_yMay3.setText(yNguoiDung(may3.getyO()) + "");
            }
            if (may4 != null) {
                jTextField_xMay4.setText(xNguoiDung(may4.getxO()) + "");
                jTextField_yMay4.setText(yNguoiDung(may4.getyO()) + "");
            }

            if (may5 != null) {
                jTextField_xMay5.setText(xNguoiDung(may5.getxO()) + "");
                jTextField_yMay5.setText(yNguoiDung(may5.getyO()) + "");
            }
            if (may6 != null) {
                jTextField_xMay6.setText(xNguoiDung(may6.getxO()) + "");
                jTextField_yMay6.setText(yNguoiDung(may6.getyO()) + "");
            }
        }

        public void xRay(Graphics g) {
            g.setColor(new Color(0, 1, 1, 100));
            g.fillRect(0, 0, graphWidth, graphHeight);
            g.setColor(Color.cyan);
            if (matTroi != null) {
                g.drawString("Mặt trời", matTroi.getxO() + 5, matTroi.getyO() - 5);
                g.fillRect(matTroi.getxO(), matTroi.getyO(), 5, 5);
            }
            if (cayThong1 != null) {
                g.drawString("Cây thông 1", cayThong1.getxDinh() + 5, cayThong1.getyDinh() - 5);
                g.fillRect(cayThong1.getxDinh(), cayThong1.getyDinh(), 5, 5);
            }
            if (cayThong2 != null) {
                g.drawString("Cây thông 2", cayThong2.getxDinh() + 5, cayThong2.getyDinh() - 5);
                g.fillRect(cayThong2.getxDinh(), cayThong2.getyDinh(), 5, 5);
            }
            if (cayThong3 != null) {
                g.drawString("Cây thông 3", cayThong3.getxDinh() + 5, cayThong3.getyDinh() - 5);
                g.fillRect(cayThong3.getxDinh(), cayThong3.getyDinh(), 5, 5);
            }
            if (bienBao != null) {
                g.drawString("Biển báo", bienBao.getxTamBienBao() + 5, bienBao.getyTamBienBao() - 5);
                g.fillRect(bienBao.getxTamBienBao(), bienBao.getyTamBienBao(), 5, 5);
            }
            if (denDuong1 != null) {
                g.drawString("Đèn đường 1", denDuong1.getX2() + 5, denDuong1.getY2() - 5);
                g.fillRect(denDuong1.getX2(), denDuong1.getY2(), 5, 5);
            }
            if (denDuong2 != null) {
                g.drawString("Đèn đường 2", denDuong2.getX2() + 5, denDuong2.getY2() - 5);
                g.fillRect(denDuong2.getX2(), denDuong2.getY2(), 5, 5);
            }
            if (may1 != null) {
                g.drawString("Mây 1", may1.getxO() + 5, may1.getyO() - 5);
                g.fillRect(may1.getxO(), may1.getyO(), 5, 5);
            }
            if (may2 != null) {
                g.drawString("Mây 2", may2.getxO() + 5, may2.getyO() - 5);
                g.fillRect(may2.getxO(), may2.getyO(), 5, 5);
            }
            if (may3 != null) {
                g.drawString("Mây 3", may3.getxO() + 5, may3.getyO() - 5);
                g.fillRect(may3.getxO(), may3.getyO(), 5, 5);
            }
            if (may4 != null) {
                g.drawString("Mây 4", may4.getxO() + 5, may4.getyO() - 5);
                g.fillRect(may4.getxO(), may4.getyO(), 5, 5);
            }
            if (may5 != null) {
                g.drawString("Mây 5", may5.getxO() + 5, may5.getyO() - 5);
                g.fillRect(may5.getxO(), may5.getyO(), 5, 5);
            }
            if (may6 != null) {
                g.drawString("Mây 6", may6.getxO() + 5, may6.getyO() - 5);
                g.fillRect(may6.getxO(), may6.getyO(), 5, 5);
            }
            if (oto != null) {
                g.drawString("Ô tô", oto.getxMuiXe() - 20, oto.getyMuiXe() - 5);
                g.fillRect(oto.getxMuiXe(), oto.getyMuiXe(), 5, 5);
            }
            if (newOto != null) {
                g.drawString("Ô tô", newOto.getxMuiXeDuoi() - 20, newOto.getyMuiXeDuoi() - 5);
                g.fillRect(newOto.getxMuiXeDuoi(), newOto.getyMuiXeDuoi(), 5, 5);
            }
        }

        public int xNguoiDung(int x) {
            return (x - graphWidth / 2) / step;
        }

        public int yNguoiDung(int y) {
            return (y - graphHeight / 2) / -step;
        }
        Sao sao1;
        Sao sao2;
        Sao sao3;
        Sao sao4;
        Sao sao5;
        Sao sao6;
        Sao sao7;
        Sao sao8;
        Sao sao9;

        public void initStar() {
            sao1 = new Sao(333, 90, 15);
            sao2 = new Sao(444, 100, 10);
            sao3 = new Sao(555, 80, 15);
            sao4 = new Sao(111, 170, 10);
            sao5 = new Sao(222, 120, 15);
            sao6 = new Sao(720, 99, 15);
            sao7 = new Sao(190, 180, 14);
            sao8 = new Sao(380, 160, 16);
            sao9 = new Sao(606, 121, 13);
        }

        public void starShow(Graphics g) {
            if (mode.equals("night")) {
                sao1.veSao((Graphics2D) g);
                sao2.veSao((Graphics2D) g);
                sao3.veSao((Graphics2D) g);
                sao4.veSao((Graphics2D) g);
                sao5.veSao((Graphics2D) g);
                sao6.veSao((Graphics2D) g);
                sao7.veSao((Graphics2D) g);
                sao8.veSao((Graphics2D) g);
                sao9.veSao((Graphics2D) g);

                dxSao(sao1, (Graphics2D) g);
                dxSao(sao2, (Graphics2D) g);
                dxSao(sao3, (Graphics2D) g);
                dxSao(sao4, (Graphics2D) g);
                dxSao(sao5, (Graphics2D) g);
                dxSao(sao6, (Graphics2D) g);
                dxSao(sao7, (Graphics2D) g);
                dxSao(sao8, (Graphics2D) g);
                dxSao(sao9, (Graphics2D) g);
            }
        }

        public void dxDenDuong(DoanThang denDuong, Graphics2D g) {
            String modedx = "Ox";
            Diem2D diem1 = new Diem2D(denDuong.getX1(), denDuong.getY1());
            Diem2D diem2 = new Diem2D(denDuong.getX2(), denDuong.getY2());

            Diem2D diem2d = new DoiXung(diem1, modedx).doiXungDiem();

            denDuong.setX1(diem2d.getX());
            denDuong.setY1(diem2d.getY());

            diem2d = new DoiXung(diem2, modedx).doiXungDiem();
            denDuong.setX2(diem2d.getX());
            denDuong.setY2(diem2d.getY());

            denDuong.veDoanThang(g);
        }

        public void dxMay(May may, Graphics2D g) {
            String modedx = "Ox";
            Diem2D diem1 = new Diem2D(may.getxO(), may.getyO());
            Diem2D diem2 = new Diem2D(may.getxTrai(), may.getyTrai());
            Diem2D diem3 = new Diem2D(may.getxPhai(), may.getyPhai());
            Diem2D diem2d;
            diem2d = new DoiXung(diem1, modedx).doiXungDiem();
            may.setxO(diem2d.getX());
            may.setyO(diem2d.getY());

            diem2d = new DoiXung(diem2, modedx).doiXungDiem();
            may.setxTrai(diem2d.getX());
            may.setyTrai(diem2d.getY());

            diem2d = new DoiXung(diem3, modedx).doiXungDiem();
            may.setxPhai(diem2d.getX());
            may.setyPhai(diem2d.getY());

            may.veMay(g);
        }

        public void dxSao(Sao sao, Graphics2D g) {
            String modedx = "Ox";
            Diem2D diemO = new Diem2D(sao.getxO(), sao.getyO());
            Diem2D diem2d = new DoiXung(diemO, modedx).doiXungDiem();

            sao.setxO(diem2d.getX());
            sao.setyO(diem2d.getY());

            Diem2D diemTren = new Diem2D(sao.getxTren(), sao.getyTren());
            Diem2D diemDuoi = new Diem2D(sao.getxDuoi(), sao.getyDuoi());
            Diem2D diemTrai = new Diem2D(sao.getxTrai(), sao.getyTrai());
            Diem2D diemPhai = new Diem2D(sao.getxPhai(), sao.getyPhai());

            Diem2D diemTrenDuongTron = new Diem2D(sao.getxTrenDuongTron(), sao.getyTrenDuongTron());
            Diem2D diemDuoiDuongTron = new Diem2D(sao.getxDuoiDuongTron(), sao.getyDuoiDuongTron());
            Diem2D diemTraiDuongTron = new Diem2D(sao.getxTraiDuongTron(), sao.getyTraiDuongTron());
            Diem2D diemPhaiDuongTron = new Diem2D(sao.getxPhaiDuongTron(), sao.getyPhaiDuongTron());

            diem2d = new DoiXung(diemTren, modedx).doiXungDiem();
            sao.setxTren(diem2d.getX());
            sao.setyTren(diem2d.getY());

            diem2d = new DoiXung(diemDuoi, modedx).doiXungDiem();
            sao.setxDuoi(diem2d.getX());
            sao.setyDuoi(diem2d.getY());

            diem2d = new DoiXung(diemTrai, modedx).doiXungDiem();
            sao.setxTrai(diem2d.getX());
            sao.setyTrai(diem2d.getY());

            diem2d = new DoiXung(diemPhai, modedx).doiXungDiem();
            sao.setxPhai(diem2d.getX());
            sao.setyPhai(diem2d.getY());

            //
            diem2d = new DoiXung(diemTrenDuongTron, modedx).doiXungDiem();
            sao.setxTrenDuongTron(diem2d.getX());
            sao.setyTrenDuongTron(diem2d.getY());

            diem2d = new DoiXung(diemDuoiDuongTron, modedx).doiXungDiem();
            sao.setxDuoiDuongTron(diem2d.getX());
            sao.setyDuoiDuongTron(diem2d.getY());

            diem2d = new DoiXung(diemTraiDuongTron, modedx).doiXungDiem();
            sao.setxTraiDuongTron(diem2d.getX());
            sao.setyTraiDuongTron(diem2d.getY());

            diem2d = new DoiXung(diemPhaiDuongTron, modedx).doiXungDiem();
            sao.setxPhaiDuongTron(diem2d.getX());
            sao.setyPhaiDuongTron(diem2d.getY());

            sao.veSao(g);
        }

        public void dxNewOto(New_Oto newOto, Graphics2D g) {
            String modedx = "Ox";
            Diem2D diem1 = new Diem2D(newOto.getxMuiXeDuoi(), newOto.getyMuiXeDuoi());
            Diem2D diem2 = new Diem2D(newOto.getxMuiXeGiua(), newOto.getyMuiXeGiua());
            Diem2D diem3 = new Diem2D(newOto.getxMuiXeTren(), newOto.getyMuiXeTren());

            Diem2D diem2d;

            diem2d = new DoiXung(diem1, modedx).doiXungDiem();

            newOto.setxMuiXeDuoi(diem2d.getX());
            newOto.setyMuiXeDuoi(diem2d.getY());

            diem2d = new DoiXung(diem2, modedx).doiXungDiem();

            newOto.setxMuiXeGiua(diem2d.getX());
            newOto.setyMuiXeGiua(diem2d.getY());

            diem2d = new DoiXung(diem3, modedx).doiXungDiem();

            newOto.setxMuiXeTren(diem2d.getX());
            newOto.setyMuiXeTren(diem2d.getY());

            diem1 = new Diem2D(newOto.getxNocXe1(), newOto.getyNocXe1());
            diem2 = new Diem2D(newOto.getxNocXe2(), newOto.getyNocXe2());
            diem3 = new Diem2D(newOto.getxNocXe3(), newOto.getyNocXe3());

            diem2d = new DoiXung(diem1, modedx).doiXungDiem();

            newOto.setxNocXe1(diem2d.getX());
            newOto.setyNocXe1(diem2d.getY());

            diem2d = new DoiXung(diem2, modedx).doiXungDiem();

            newOto.setxNocXe2(diem2d.getX());
            newOto.setyNocXe2(diem2d.getY());

            diem2d = new DoiXung(diem3, modedx).doiXungDiem();

            newOto.setxNocXe3(diem2d.getX());
            newOto.setyNocXe3(diem2d.getY());
            //
            diem1 = new Diem2D(newOto.getxDuoiXe1(), newOto.getyDuoiXe1());
            diem2 = new Diem2D(newOto.getxDuoiXe2(), newOto.getyDuoiXe2());
            diem3 = new Diem2D(newOto.getxDuoiXe3(), newOto.getyDuoiXe3());

            diem2d = new DoiXung(diem1, modedx).doiXungDiem();

            newOto.setxDuoiXe1(diem2d.getX());
            newOto.setyDuoiXe1(diem2d.getY());

            diem2d = new DoiXung(diem2, modedx).doiXungDiem();

            newOto.setxDuoiXe2(diem2d.getX());
            newOto.setyDuoiXe2(diem2d.getY());

            diem2d = new DoiXung(diem3, modedx).doiXungDiem();

            newOto.setxDuoiXe3(diem2d.getX());
            newOto.setyDuoiXe3(diem2d.getY());
            //
            diem1 = new Diem2D(newOto.getxDuoiXe4(), newOto.getyDuoiXe4());
            diem2 = new Diem2D(newOto.getxDuoiXe5(), newOto.getyDuoiXe5());
            diem3 = new Diem2D(newOto.getxDuoiXeDuoi(), newOto.getyDuoiXeDuoi());

            diem2d = new DoiXung(diem1, modedx).doiXungDiem();

            newOto.setxDuoiXe4(diem2d.getX());
            newOto.setyDuoiXe4(diem2d.getY());

            diem2d = new DoiXung(diem2, modedx).doiXungDiem();

            newOto.setxDuoiXe5(diem2d.getX());
            newOto.setyDuoiXe5(diem2d.getY());

            diem2d = new DoiXung(diem3, modedx).doiXungDiem();

            newOto.setxDuoiXeDuoi(diem2d.getX());
            newOto.setyDuoiXeDuoi(diem2d.getY());
            //
            diem1 = new Diem2D(newOto.getxBanhXeTruoc(), newOto.getyBanhXeTruoc());
            diem2 = new Diem2D(newOto.getxBanhXeSau(), newOto.getyBanhXeSau());

            diem2d = new DoiXung(diem1, modedx).doiXungDiem();

            newOto.setxBanhXeTruoc(diem2d.getX());
            newOto.setyBanhXeTruoc(diem2d.getY());

            diem2d = new DoiXung(diem2, modedx).doiXungDiem();

            newOto.setxBanhXeSau(diem2d.getX());
            newOto.setyBanhXeSau(diem2d.getY());
            //
            diem1 = new Diem2D(newOto.getxKinh1(), newOto.getyKinh1());
            diem2 = new Diem2D(newOto.getxKinh2(), newOto.getyKinh2());
            diem3 = new Diem2D(newOto.getxKinh3(), newOto.getyKinh3());

            diem2d = new DoiXung(diem1, modedx).doiXungDiem();

            newOto.setxKinh1(diem2d.getX());
            newOto.setyKinh1(diem2d.getY());

            diem2d = new DoiXung(diem2, modedx).doiXungDiem();

            newOto.setxKinh2(diem2d.getX());
            newOto.setyKinh2(diem2d.getY());

            diem2d = new DoiXung(diem3, modedx).doiXungDiem();

            newOto.setxKinh3(diem2d.getX());
            newOto.setyKinh3(diem2d.getY());
            //
            diem1 = new Diem2D(newOto.getxKinh4(), newOto.getyKinh4());
            diem2 = new Diem2D(newOto.getxKinh5(), newOto.getyKinh5());
            diem3 = new Diem2D(newOto.getxKinh6(), newOto.getyKinh6());

            diem2d = new DoiXung(diem1, modedx).doiXungDiem();

            newOto.setxKinh4(diem2d.getX());
            newOto.setyKinh4(diem2d.getY());

            diem2d = new DoiXung(diem2, modedx).doiXungDiem();

            newOto.setxKinh5(diem2d.getX());
            newOto.setyKinh5(diem2d.getY());

            diem2d = new DoiXung(diem3, modedx).doiXungDiem();

            newOto.setxKinh6(diem2d.getX());
            newOto.setyKinh6(diem2d.getY());
            //
            diem1 = new Diem2D(newOto.getxKinh7(), newOto.getyKinh7());
            diem2 = new Diem2D(newOto.getxKinh8(), newOto.getyKinh8());
            diem3 = new Diem2D(newOto.getxKinh9(), newOto.getyKinh9());

            diem2d = new DoiXung(diem1, modedx).doiXungDiem();

            newOto.setxKinh7(diem2d.getX());
            newOto.setyKinh7(diem2d.getY());

            diem2d = new DoiXung(diem2, modedx).doiXungDiem();

            newOto.setxKinh8(diem2d.getX());
            newOto.setyKinh8(diem2d.getY());

            diem2d = new DoiXung(diem3, modedx).doiXungDiem();

            newOto.setxKinh9(diem2d.getX());
            newOto.setyKinh9(diem2d.getY());
            //
            diem1 = new Diem2D(newOto.getxChiTiet1(), newOto.getyChiTiet1());
            diem2 = new Diem2D(newOto.getxChiTiet2(), newOto.getyChiTiet2());

            diem2d = new DoiXung(diem1, modedx).doiXungDiem();

            newOto.setxChiTiet1(diem2d.getX());
            newOto.setyChiTiet1(diem2d.getY());

            diem2d = new DoiXung(diem2, modedx).doiXungDiem();

            newOto.setxChiTiet2(diem2d.getX());
            newOto.setyChiTiet2(diem2d.getY());


            newOto.veNewOto(g);
        }

        public void dxBienBao(BienBao bienBao, Graphics2D g) {
            String modedx = "Ox";
            Diem2D diemO = new Diem2D(bienBao.getxTamBienBao(), bienBao.getyTamBienBao());
            Diem2D diem2d = new DoiXung(diemO, modedx).doiXungDiem();
            bienBao.setxTamBienBao(diem2d.getX());
            bienBao.setyTamBienBao(diem2d.getY());

            Diem2D diem1 = new Diem2D(bienBao.getHinhChuNhat().getX1(), bienBao.getHinhChuNhat().getY1());
            Diem2D diem2 = new Diem2D(bienBao.getHinhChuNhat().getX2(), bienBao.getHinhChuNhat().getY2());
            Diem2D diem3 = new Diem2D(bienBao.getHinhChuNhat().getX3(), bienBao.getHinhChuNhat().getY3());
            Diem2D diem4 = new Diem2D(bienBao.getHinhChuNhat().getX4(), bienBao.getHinhChuNhat().getY4());

            diem2d = new DoiXung(diem1, modedx).doiXungDiem();

            bienBao.getHinhChuNhat().setX1(diem2d.getX());
            bienBao.getHinhChuNhat().setY1(diem2d.getY());

            diem2d = new DoiXung(diem2, modedx).doiXungDiem();
            bienBao.getHinhChuNhat().setX2(diem2d.getX());
            bienBao.getHinhChuNhat().setY2(diem2d.getY());

            diem2d = new DoiXung(diem3, modedx).doiXungDiem();
            bienBao.getHinhChuNhat().setX3(diem2d.getX());
            bienBao.getHinhChuNhat().setY3(diem2d.getY());

            diem2d = new DoiXung(diem4, modedx).doiXungDiem();
            bienBao.getHinhChuNhat().setX4(diem2d.getX());
            bienBao.getHinhChuNhat().setY4(diem2d.getY());

            diem1 = new Diem2D(bienBao.getHinhChuNhatChanBienBao().getX1(), bienBao.getHinhChuNhatChanBienBao().getY1());
            diem2 = new Diem2D(bienBao.getHinhChuNhatChanBienBao().getX2(), bienBao.getHinhChuNhatChanBienBao().getY2());
            diem3 = new Diem2D(bienBao.getHinhChuNhatChanBienBao().getX3(), bienBao.getHinhChuNhatChanBienBao().getY3());
            diem4 = new Diem2D(bienBao.getHinhChuNhatChanBienBao().getX4(), bienBao.getHinhChuNhatChanBienBao().getY4());

            diem2d = new DoiXung(diem1, modedx).doiXungDiem();

            bienBao.getHinhChuNhatChanBienBao().setX1(diem2d.getX());
            bienBao.getHinhChuNhatChanBienBao().setY1(diem2d.getY());

            diem2d = new DoiXung(diem2, modedx).doiXungDiem();
            bienBao.getHinhChuNhatChanBienBao().setX2(diem2d.getX());
            bienBao.getHinhChuNhatChanBienBao().setY2(diem2d.getY());

            diem2d = new DoiXung(diem3, modedx).doiXungDiem();
            bienBao.getHinhChuNhatChanBienBao().setX3(diem2d.getX());
            bienBao.getHinhChuNhatChanBienBao().setY3(diem2d.getY());

            diem2d = new DoiXung(diem4, modedx).doiXungDiem();
            bienBao.getHinhChuNhatChanBienBao().setX4(diem2d.getX());
            bienBao.getHinhChuNhatChanBienBao().setY4(diem2d.getY());

            bienBao.veBienBao(g);
        }

        public void dxCayThong(CayThong cayThong, Graphics2D g) {
            String modedx = "Ox";
            Diem2D diemO = new Diem2D(cayThong.getxDinh(), cayThong.getyDinh());
            Diem2D diem2d = new DoiXung(diemO, modedx).doiXungDiem();
            cayThong.setxDinh(diem2d.getX());
            cayThong.setyDinh(diem2d.getY());

            Diem2D diem1 = new Diem2D(cayThong.getHinhTamGiacCan1().getxDinh(), cayThong.getHinhTamGiacCan1().getyDinh());
            Diem2D diem2 = new Diem2D(cayThong.getHinhTamGiacCan1().getX2(), cayThong.getHinhTamGiacCan1().getY2());
            Diem2D diem3 = new Diem2D(cayThong.getHinhTamGiacCan1().getX3(), cayThong.getHinhTamGiacCan1().getY3());

            diem2d = new DoiXung(diem1, modedx).doiXungDiem();
            cayThong.getHinhTamGiacCan1().setxDinh(diem2d.getX());
            cayThong.getHinhTamGiacCan1().setyDinh(diem2d.getY());

            diem2d = new DoiXung(diem2, modedx).doiXungDiem();
            cayThong.getHinhTamGiacCan1().setX2(diem2d.getX());
            cayThong.getHinhTamGiacCan1().setY2(diem2d.getY());

            diem2d = new DoiXung(diem3, modedx).doiXungDiem();
            cayThong.getHinhTamGiacCan1().setX3(diem2d.getX());
            cayThong.getHinhTamGiacCan1().setY3(diem2d.getY());

            //quay hinh tam Giac thu 2
            diem1 = new Diem2D(cayThong.getHinhTamGiacCan2().getxDinh(), cayThong.getHinhTamGiacCan2().getyDinh());
            diem2 = new Diem2D(cayThong.getHinhTamGiacCan2().getX2(), cayThong.getHinhTamGiacCan2().getY2());
            diem3 = new Diem2D(cayThong.getHinhTamGiacCan2().getX3(), cayThong.getHinhTamGiacCan2().getY3());

            diem2d = new DoiXung(diem1, modedx).doiXungDiem();
            cayThong.getHinhTamGiacCan2().setxDinh(diem2d.getX());
            cayThong.getHinhTamGiacCan2().setyDinh(diem2d.getY());

            diem2d = new DoiXung(diem2, modedx).doiXungDiem();
            cayThong.getHinhTamGiacCan2().setX2(diem2d.getX());
            cayThong.getHinhTamGiacCan2().setY2(diem2d.getY());

            diem2d = new DoiXung(diem3, modedx).doiXungDiem();
            cayThong.getHinhTamGiacCan2().setX3(diem2d.getX());
            cayThong.getHinhTamGiacCan2().setY3(diem2d.getY());

            //quay hinh tam Giac thu 3
            diem1 = new Diem2D(cayThong.getHinhTamGiacCan3().getxDinh(), cayThong.getHinhTamGiacCan3().getyDinh());
            diem2 = new Diem2D(cayThong.getHinhTamGiacCan3().getX2(), cayThong.getHinhTamGiacCan3().getY2());
            diem3 = new Diem2D(cayThong.getHinhTamGiacCan3().getX3(), cayThong.getHinhTamGiacCan3().getY3());

            diem2d = new DoiXung(diem1, modedx).doiXungDiem();
            cayThong.getHinhTamGiacCan3().setxDinh(diem2d.getX());
            cayThong.getHinhTamGiacCan3().setyDinh(diem2d.getY());

            diem2d = new DoiXung(diem2, modedx).doiXungDiem();
            cayThong.getHinhTamGiacCan3().setX2(diem2d.getX());
            cayThong.getHinhTamGiacCan3().setY2(diem2d.getY());

            diem2d = new DoiXung(diem3, modedx).doiXungDiem();
            cayThong.getHinhTamGiacCan3().setX3(diem2d.getX());
            cayThong.getHinhTamGiacCan3().setY3(diem2d.getY());

            diem1 = new Diem2D(cayThong.getHinhChuNhat().getX1(), cayThong.getHinhChuNhat().getY1());
            diem2 = new Diem2D(cayThong.getHinhChuNhat().getX2(), cayThong.getHinhChuNhat().getY2());
            diem3 = new Diem2D(cayThong.getHinhChuNhat().getX3(), cayThong.getHinhChuNhat().getY3());
            Diem2D diem4 = new Diem2D(cayThong.getHinhChuNhat().getX4(), cayThong.getHinhChuNhat().getY4());

            diem2d = new DoiXung(diem1, modedx).doiXungDiem();

            cayThong.getHinhChuNhat().setX1(diem2d.getX());
            cayThong.getHinhChuNhat().setY1(diem2d.getY());

            diem2d = new DoiXung(diem2, modedx).doiXungDiem();
            cayThong.getHinhChuNhat().setX2(diem2d.getX());
            cayThong.getHinhChuNhat().setY2(diem2d.getY());

            diem2d = new DoiXung(diem3, modedx).doiXungDiem();
            cayThong.getHinhChuNhat().setX3(diem2d.getX());
            cayThong.getHinhChuNhat().setY3(diem2d.getY());

            diem2d = new DoiXung(diem4, modedx).doiXungDiem();
            cayThong.getHinhChuNhat().setX4(diem2d.getX());
            cayThong.getHinhChuNhat().setY4(diem2d.getY());

//                Diem2D  diem = new Diem2D(cayThong.getxDinh(), cayThong.getyDinh());
//                System.out.println(cayThong.getxDinh()+",,"+cayThong.getyDinh());
//                diem.veDiem2D(g);
            cayThong.veCayThong((Graphics2D) g);
//                return cayThong;
        }

        public void scaleStar(Sao sao, double scale) {
            int newCD = new ThuPhong(sao.getChieuDaiCanh(), scale).ThuPhongSize();
            Diem2D diemO = new Diem2D(sao.getxO(), sao.getyO());
            Diem2D diem2d = new ThuPhong(diemO, scale).ThuPhongDiem();
            int xtt = (int) diem2d.getX() - diemO.getX();// lấy điểm 1 làm gốc để tịnh tiến về sau thu phóng
            int ytt = (int) diem2d.getY() - diemO.getY();

            sao.setxO(diem2d.getX() - xtt);
            sao.setyO(diem2d.getY() - ytt);

            sao.setChieuDaiCanh(newCD);

            Diem2D diemTren = new Diem2D(sao.getxTren(), sao.getyTren());
            Diem2D diemDuoi = new Diem2D(sao.getxDuoi(), sao.getyDuoi());
            Diem2D diemTrai = new Diem2D(sao.getxTrai(), sao.getyTrai());
            Diem2D diemPhai = new Diem2D(sao.getxPhai(), sao.getyPhai());

            Diem2D diemTrenDuongTron = new Diem2D(sao.getxTrenDuongTron(), sao.getyTrenDuongTron());
            Diem2D diemDuoiDuongTron = new Diem2D(sao.getxDuoiDuongTron(), sao.getyDuoiDuongTron());
            Diem2D diemTraiDuongTron = new Diem2D(sao.getxTraiDuongTron(), sao.getyTraiDuongTron());
            Diem2D diemPhaiDuongTron = new Diem2D(sao.getxPhaiDuongTron(), sao.getyPhaiDuongTron());

            diem2d = new ThuPhong(diemTren, scale).ThuPhongDiem();
            sao.setxTren(diem2d.getX() - xtt);
            sao.setyTren(diem2d.getY() - ytt);

            diem2d = new ThuPhong(diemDuoi, scale).ThuPhongDiem();
            sao.setxDuoi(diem2d.getX() - xtt);
            sao.setyDuoi(diem2d.getY() - ytt);

            diem2d = new ThuPhong(diemTrai, scale).ThuPhongDiem();
            sao.setxTrai(diem2d.getX() - xtt);
            sao.setyTrai(diem2d.getY() - ytt);

            diem2d = new ThuPhong(diemPhai, scale).ThuPhongDiem();
            sao.setxPhai(diem2d.getX() - xtt);
            sao.setyPhai(diem2d.getY() - ytt);

            //
            diem2d = new ThuPhong(diemTrenDuongTron, scale).ThuPhongDiem();
            sao.setxTrenDuongTron(diem2d.getX() - xtt);
            sao.setyTrenDuongTron(diem2d.getY() - ytt);

            diem2d = new ThuPhong(diemDuoiDuongTron, scale).ThuPhongDiem();
            sao.setxDuoiDuongTron(diem2d.getX() - xtt);
            sao.setyDuoiDuongTron(diem2d.getY() - ytt);

            diem2d = new ThuPhong(diemTraiDuongTron, scale).ThuPhongDiem();
            sao.setxTraiDuongTron(diem2d.getX() - xtt);
            sao.setyTraiDuongTron(diem2d.getY() - ytt);

            diem2d = new ThuPhong(diemPhaiDuongTron, scale).ThuPhongDiem();
            sao.setxPhaiDuongTron(diem2d.getX() - xtt);
            sao.setyPhaiDuongTron(diem2d.getY() - ytt);
        }

        public void dxMatTroi(DuongTron matTroi, Graphics2D g) {
            String modedx = "Ox";
            Diem2D diem1 = new Diem2D(matTroi.getxO(), matTroi.getyO());
            Diem2D diem2d = new DoiXung(diem1, modedx).doiXungDiem();
            matTroi.setxO(diem2d.getX());
            matTroi.setyO(diem2d.getY());
            g.fillOval(matTroi.getxO() - matTroi.getR(), matTroi.getyO() - matTroi.getR(), matTroi.getR() * 2, matTroi.getR() * 2);
            matTroi.veDuongTronNetLien(g);
        }

        public void sunGoDown(Graphics g) {
            if (mode.equals("day")) {
                g.setColor(Color.yellow);

                g.fillOval(0 + xmt, graphHeight / 2 - y1 * step - ymt, 90, 90);

                matTroi = new DuongTron(xmt + 45, graphHeight / 2 - y1 * step - ymt + 45, 45);
                matTroi.veDuongTronNetLien((Graphics2D) g);

                ymt -= 1;
                xmt += 4;
            }
            if (ymt < -graphHeight / 2) {
                ymt = graphHeight / 2;
                xmt = 1;
            }
            dxMatTroi(matTroi, (Graphics2D) g);
            matTroi = new DuongTron(xmt + 45, graphHeight / 2 - y1 * step - ymt + 45, 45);
        }

        public void mayX2(Graphics g) {
            may1 = new May(graphWidth / 2 + x2 * step + 45, graphHeight / 2 - y1 * step - 270 + 45, 45, "May1");
            may1.veMay((Graphics2D) g);
            
            dxMay(may1, (Graphics2D) g);
            may1 = new May(graphWidth / 2 + x2 * step + 45, graphHeight / 2 - y1 * step - 270 + 45, 45, "May1"); 

            may2 = new May(graphWidth / 2 + x2 * step + 160 + 30, graphHeight / 2 - y1 * step - 220 + 30, 30, "May2");
            may2.veMay((Graphics2D) g);
            dxMay(may2, (Graphics2D) g);
            may2 = new May(graphWidth / 2 + x2 * step + 160 + 30, graphHeight / 2 - y1 * step - 220 + 30, 30, "May2");

        }

        public void mayX3(Graphics g) {
            if ((x3 > -50 || x3 < 900)) {
                
                may3 = new May(graphWidth / 2 + x3 * step + 45, graphHeight / 2 - y1 * step - 270 + 45, 45, "May3");
                may3.veMay((Graphics2D) g);

                dxMay(may3, (Graphics2D) g);
                may3 = new May(graphWidth / 2 + x3 * step + 45, graphHeight / 2 - y1 * step - 270 + 45, 45, "May3");
            }
        }

        public void scene0(Graphics g) {
            g.setColor(mauCayThong);
            cayThong1 = new CayThong(graphWidth / 2 + x1 * step + 100, graphHeight / 2 - y1 * step - 100, 100);
            cayThong1.veCayThong((Graphics2D) g);
            cayThong2 = new CayThong(graphWidth / 2 + x1 * step + 200, graphHeight / 2 - y1 * step - 145, 150);
            cayThong2.veCayThong((Graphics2D) g);
            cayThong3 = new CayThong(graphWidth / 2 + x1 * step + 0, graphHeight / 2 - y1 * step - 200, 200);
            cayThong3.veCayThong((Graphics2D) g);
            bienBao = new BienBao(graphWidth / 2 + x1 * step - 120, graphHeight / 2 - y1 * step - 146, 150,"");
            bienBao.veBienBao((Graphics2D) g);

            dxCayThong(cayThong1, (Graphics2D) g);

            dxCayThong(cayThong2, (Graphics2D) g);

            dxCayThong(cayThong3, (Graphics2D) g);

            dxBienBao(bienBao, (Graphics2D) g);
            //3 dong nay de bat xray k ph xac dinh hinh da doixung
            cayThong1 = new CayThong(graphWidth / 2 + x1 * step + 100, graphHeight / 2 - y1 * step - 100, 100);
            cayThong2 = new CayThong(graphWidth / 2 + x1 * step + 200, graphHeight / 2 - y1 * step - 145, 150);
            cayThong3 = new CayThong(graphWidth / 2 + x1 * step + 0, graphHeight / 2 - y1 * step - 200, 200);
            bienBao = new BienBao(graphWidth / 2 + x1 * step - 120, graphHeight / 2 - y1 * step - 146, 150,"");
        }

        public void scene1(Graphics g) {
            g.setColor(mauCayThong);
            cayThong1 = new CayThong(graphWidth / 2 + x1 * step - 40, graphHeight / 2 - y1 * step - 150, 150);
            cayThong1.veCayThong((Graphics2D) g);
            cayThong2 = new CayThong(graphWidth / 2 + x1 * step + 120, graphHeight / 2 - y1 * step - 200, 200);
            cayThong2.veCayThong((Graphics2D) g);

//                if (mode.equals("day") || mode.equals("night")) {
            g.setColor(Color.black);
            denDuong1 = new DoanThang(graphWidth / 2 + x1 * step - 260, graphHeight / 2 - y1 * step, graphWidth / 2 + x1 * step - 260, graphHeight / 2 - y1 * step - 130);
            denDuong1.veDoanThang((Graphics2D) g);
            denDuong2 = new DoanThang(graphWidth / 2 + x1 * step + 200, graphHeight / 2 - y1 * step, graphWidth / 2 + x1 * step + 200, graphHeight / 2 - y1 * step - 130);
            denDuong2.veDoanThang((Graphics2D) g);
//                }
            if (mode.equals("night")) {
                g.setColor(Color.yellow);
                g.fillOval(graphWidth / 2 + x1 * step - 260, graphHeight / 2 - y1 * step - 130, 20, 20);
                g.fillOval(graphWidth / 2 + x1 * step + 200, graphHeight / 2 - y1 * step - 130, 20, 20);

            }
            dxCayThong(cayThong1, (Graphics2D) g);
            dxCayThong(cayThong2, (Graphics2D) g);

            cayThong1 = new CayThong(graphWidth / 2 + x1 * step - 40, graphHeight / 2 - y1 * step - 150, 150);
            cayThong2 = new CayThong(graphWidth / 2 + x1 * step + 120, graphHeight / 2 - y1 * step - 200, 200);

            dxDenDuong(denDuong1, (Graphics2D) g);
            dxDenDuong(denDuong2, (Graphics2D) g);
            if (mode.equals("night")) {
                g.setColor(Color.yellow);
                g.fillOval(denDuong1.getX2() + 2, denDuong1.getY2() - 15, 20, 20);
                g.fillOval(denDuong2.getX2() + 2, denDuong2.getY2() - 15, 20, 20);

            }
            denDuong1 = new DoanThang(graphWidth / 2 + x1 * step - 260, graphHeight / 2 - y1 * step, graphWidth / 2 + x1 * step - 260, graphHeight / 2 - y1 * step - 130);
            denDuong2 = new DoanThang(graphWidth / 2 + x1 * step + 200, graphHeight / 2 - y1 * step, graphWidth / 2 + x1 * step + 200, graphHeight / 2 - y1 * step - 130);
        }

        public void scene2(Graphics g) {
            if (mode.equals("night")) {
                g.setColor(Color.lightGray);
            } else {
                g.setColor(Color.white);
            }
            may4 = new May(graphWidth / 2 + x1 * step + 45, graphHeight / 2 - y1 * step - 270 + 45, 45, "May4");
            may4.veMay((Graphics2D) g);

            dxMay(may4, (Graphics2D) g);
            may4 = new May(graphWidth / 2 + x1 * step + 45, graphHeight / 2 - y1 * step - 270 + 45, 45, "May4");

            may5 = new May(graphWidth / 2 + x1 * step + 160 + 30, graphHeight / 2 - y1 * step - 220 + 30, 30, "May5");
            may5.veMay((Graphics2D) g);

            dxMay(may5, (Graphics2D) g);
            may5 = new May(graphWidth / 2 + x1 * step + 160 + 30, graphHeight / 2 - y1 * step - 220 + 30, 30, "May5");

            may6 = new May(graphWidth / 2 + x1 * step - 400 + 30, graphHeight / 2 - y1 * step - 250 + 40, 40, "May6");
            may6.veMay((Graphics2D) g);

            dxMay(may6, (Graphics2D) g);
            may6 = new May(graphWidth / 2 + x1 * step - 400 + 30, graphHeight / 2 - y1 * step - 250 + 40, 40, "May6");
            g.setColor(mauCayThong);
            cayThong1 = new CayThong(graphWidth / 2 + x1 * step - 120, graphHeight / 2 - y1 * step - 200, 200);
            cayThong1.veCayThong((Graphics2D) g);

            dxCayThong(cayThong1, (Graphics2D) g);
            cayThong1 = new CayThong(graphWidth / 2 + x1 * step - 120, graphHeight / 2 - y1 * step - 200, 200);
        }

        public void scene3(Graphics g) {
            if (mode.equals("day") || mode.equals("night")) {
                g.setColor(Color.black);
                denDuong1 = new DoanThang(graphWidth / 2 + x1 * step, graphHeight / 2 - y1 * step, graphWidth / 2 + x1 * step, graphHeight / 2 - y1 * step - 130);
                denDuong1.veDoanThang((Graphics2D) g);
                denDuong2 = new DoanThang(graphWidth / 2 + x1 * step - 400, graphHeight / 2 - y1 * step, graphWidth / 2 + x1 * step - 400, graphHeight / 2 - y1 * step - 130);
                denDuong2.veDoanThang((Graphics2D) g);
            }
            if (mode.equals("night")) {
                g.setColor(Color.yellow);
                g.fillOval(graphWidth / 2 + x1 * step, graphHeight / 2 - y1 * step - 130, 20, 20);
                g.fillOval(graphWidth / 2 + x1 * step - 400, graphHeight / 2 - y1 * step - 130, 20, 20);
            }
            g.setColor(Color.black);
            dxDenDuong(denDuong1, (Graphics2D) g);
            dxDenDuong(denDuong2, (Graphics2D) g);
            if (mode.equals("night")) {
                g.setColor(Color.yellow);
                g.fillOval(denDuong1.getX2() + 2, denDuong1.getY2() - 15, 20, 20);
                g.fillOval(denDuong2.getX2() + 2, denDuong2.getY2() - 15, 20, 20);
            }
            denDuong1 = new DoanThang(graphWidth / 2 + x1 * step, graphHeight / 2 - y1 * step, graphWidth / 2 + x1 * step, graphHeight / 2 - y1 * step - 130);
            denDuong2 = new DoanThang(graphWidth / 2 + x1 * step - 400, graphHeight / 2 - y1 * step, graphWidth / 2 + x1 * step - 400, graphHeight / 2 - y1 * step - 130);
        }

        public void scene4(Graphics g) {
            bienBao = new BienBao(graphWidth / 2 + x1 * step - 80, graphHeight / 2 - y1 * step - 150, 150,"");
            bienBao.veBienBao((Graphics2D) g);
            g.setColor(mauCayThong);
            cayThong1 = new CayThong(graphWidth / 2 + x1 * step + 150, graphHeight / 2 - y1 * step - 200, 200);
            cayThong1.veCayThong((Graphics2D) g);

            dxBienBao(bienBao, (Graphics2D) g);

            dxCayThong(cayThong1, (Graphics2D) g);

            bienBao = new BienBao(graphWidth / 2 + x1 * step - 80, graphHeight / 2 - y1 * step - 150, 150,"");
            cayThong1 = new CayThong(graphWidth / 2 + x1 * step + 150, graphHeight / 2 - y1 * step - 200, 200);
        }

        public carAnimation() {
            initStar();
        }

    }

    carAnimation a = new carAnimation();

    public CarAnimation() {
        initComponents();
        new KTDH_Nhom8();
        a.setSize(KTDH_Nhom8.graphWidth, KTDH_Nhom8.graphHeight);
        a.setBorder(BorderFactory.createLineBorder(Color.black));
//        a.initStar();
        this.add(a);
        this.jCheckBox_DrawCoor.setSelected(false);
        this.jCheckBox_DrawGrid.setSelected(false);
        this.jCheckBox1.setSelected(true);
        this.setLocationRelativeTo(null);
        a.setFont(jLabel34.getFont());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jCheckBox_DrawGrid = new javax.swing.JCheckBox();
        jCheckBox_DrawCoor = new javax.swing.JCheckBox();
        jCheckBox1 = new javax.swing.JCheckBox();
        jPanel1 = new javax.swing.JPanel();
        jTextField_xMatTroi = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextField_yMatTroi = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTextField_xDinhCayThong1 = new javax.swing.JTextField();
        jTextField_yDinhCayThong1 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTextField_xDinhCayThong2 = new javax.swing.JTextField();
        jTextField_yDinhCayThong2 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jTextField_xDinhCayThong3 = new javax.swing.JTextField();
        jTextField_yDinhCayThong3 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jTextField_xTamBienBao = new javax.swing.JTextField();
        jTextField_yTamBienBao = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jTextField_xMuiXe = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jTextField_yMuiXe = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jTextField_xDinhDenDuong1 = new javax.swing.JTextField();
        jTextField_yDinhDenDuong1 = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jTextField_xDinhDenDuong2 = new javax.swing.JTextField();
        jTextField_yDinhDenDuong2 = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jTextField_xMay1 = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        jTextField_yMay1 = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jTextField_xMay2 = new javax.swing.JTextField();
        jLabel30 = new javax.swing.JLabel();
        jTextField_yMay2 = new javax.swing.JTextField();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jTextField_xMay3 = new javax.swing.JTextField();
        jLabel33 = new javax.swing.JLabel();
        jTextField_yMay3 = new javax.swing.JTextField();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jTextField_xMay4 = new javax.swing.JTextField();
        jLabel36 = new javax.swing.JLabel();
        jTextField_yMay4 = new javax.swing.JTextField();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jTextField_xMay5 = new javax.swing.JTextField();
        jLabel39 = new javax.swing.JLabel();
        jTextField_yMay5 = new javax.swing.JTextField();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jTextField_xMay6 = new javax.swing.JTextField();
        jLabel42 = new javax.swing.JLabel();
        jTextField_yMay6 = new javax.swing.JTextField();
        jCheckBox2 = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });

        jButton1.setText("Back");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton3.setText("Play");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jCheckBox_DrawGrid.setText("Draw Grid");

        jCheckBox_DrawCoor.setText("DrawCoor");

        jCheckBox1.setText("Toggle fill 5x5");
        jCheckBox1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jCheckBox1ItemStateChanged(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jTextField_xMatTroi.setEnabled(false);

        jLabel1.setText("x mặt trời");

        jLabel3.setText("y mặt trời");

        jTextField_yMatTroi.setEnabled(false);

        jLabel2.setText("x đỉnh");

        jTextField_xDinhCayThong1.setEnabled(false);

        jTextField_yDinhCayThong1.setEnabled(false);

        jLabel4.setText("y đỉnh");

        jLabel5.setText("x đỉnh");

        jTextField_xDinhCayThong2.setEnabled(false);

        jTextField_yDinhCayThong2.setEnabled(false);

        jLabel6.setText("y đỉnh");

        jLabel7.setText("x đỉnh");

        jTextField_xDinhCayThong3.setEnabled(false);

        jTextField_yDinhCayThong3.setEnabled(false);

        jLabel8.setText("y đỉnh");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel9.setText("Cây thông 1");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel10.setText("Cây thông 2");

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel11.setText("Cây thông 3");

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel12.setText("Biển báo");

        jLabel13.setText("x tâm");

        jTextField_xTamBienBao.setEnabled(false);

        jTextField_yTamBienBao.setEnabled(false);

        jLabel14.setText("y tâm");

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel15.setText("Ô tô");

        jTextField_xMuiXe.setEnabled(false);

        jLabel16.setText("x mũi xe");

        jTextField_yMuiXe.setEnabled(false);

        jLabel17.setText("y mũi xe");

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel18.setText("Đèn đường 1");

        jLabel19.setText("x đỉnh");

        jLabel20.setText("y đỉnh");

        jTextField_xDinhDenDuong1.setEnabled(false);

        jTextField_yDinhDenDuong1.setEnabled(false);

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel21.setText("Đèn đường 2");

        jLabel22.setText("x đỉnh");

        jTextField_xDinhDenDuong2.setEnabled(false);

        jTextField_yDinhDenDuong2.setEnabled(false);

        jLabel23.setText("y đỉnh");

        jLabel24.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel24.setText("Mặt trời");

        jLabel25.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel25.setText("Mây 1");

        jLabel26.setText("x mây");

        jTextField_xMay1.setEnabled(false);

        jLabel27.setText("y mây");

        jTextField_yMay1.setEnabled(false);

        jLabel28.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel28.setText("Mây 2");

        jLabel29.setText("x mây");

        jTextField_xMay2.setEnabled(false);

        jLabel30.setText("y mây");

        jTextField_yMay2.setEnabled(false);

        jLabel31.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel31.setText("Mây 3");

        jLabel32.setText("x mây");

        jTextField_xMay3.setEnabled(false);

        jLabel33.setText("y mây");

        jTextField_yMay3.setEnabled(false);

        jLabel34.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel34.setText("Mây 4");

        jLabel35.setText("x mây");

        jTextField_xMay4.setEnabled(false);

        jLabel36.setText("y mây");

        jTextField_yMay4.setEnabled(false);

        jLabel37.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel37.setText("Mây 5");

        jLabel38.setText("x mây");

        jTextField_xMay5.setEnabled(false);

        jLabel39.setText("y mây");

        jTextField_yMay5.setEnabled(false);

        jLabel40.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel40.setText("Mây 6");

        jLabel41.setText("x mây");

        jTextField_xMay6.setEnabled(false);

        jLabel42.setText("y mây");

        jTextField_yMay6.setEnabled(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10)
                            .addComponent(jLabel11)
                            .addComponent(jLabel12)
                            .addComponent(jLabel18)
                            .addComponent(jLabel21)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextField_xDinhCayThong1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField_xMatTroi, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextField_yMatTroi, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jTextField_yDinhCayThong1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel22)
                                .addGap(36, 36, 36)
                                .addComponent(jTextField_xDinhDenDuong2, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel19)
                                .addGap(36, 36, 36)
                                .addComponent(jTextField_xDinhDenDuong1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel13)
                                .addGap(38, 38, 38)
                                .addComponent(jTextField_xTamBienBao, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(36, 36, 36)
                                .addComponent(jTextField_xDinhCayThong3, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(36, 36, 36)
                                .addComponent(jTextField_xDinhCayThong2, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField_yDinhCayThong2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField_yDinhCayThong3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField_yTamBienBao, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField_yDinhDenDuong1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField_yDinhDenDuong2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel35)
                                .addGap(34, 34, 34)
                                .addComponent(jTextField_xMay4, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel32)
                                .addGap(34, 34, 34)
                                .addComponent(jTextField_xMay3, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel29)
                                .addGap(36, 36, 36)
                                .addComponent(jTextField_xMay2, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel26)
                                .addGap(36, 36, 36)
                                .addComponent(jTextField_xMay1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel27)
                                .addGap(27, 27, 27)
                                .addComponent(jTextField_yMay1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel30)
                                .addGap(27, 27, 27)
                                .addComponent(jTextField_yMay2, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel33)
                                .addGap(27, 27, 27)
                                .addComponent(jTextField_yMay3, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(jLabel36)
                                .addGap(27, 27, 27)
                                .addComponent(jTextField_yMay4, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel23)
                            .addComponent(jLabel20)
                            .addComponent(jLabel14)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTextField_xMuiXe, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(jLabel17)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField_yMuiXe, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel24)
                            .addComponent(jLabel25)
                            .addComponent(jLabel28)
                            .addComponent(jLabel31)
                            .addComponent(jLabel34)
                            .addComponent(jLabel37)
                            .addComponent(jLabel15)
                            .addComponent(jLabel40))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 2, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel8))
                                .addGap(75, 75, 75))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel38)
                                .addGap(34, 34, 34)
                                .addComponent(jTextField_xMay5, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(29, 29, 29)
                                .addComponent(jLabel39)
                                .addGap(27, 27, 27)
                                .addComponent(jTextField_yMay5, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel41)
                                .addGap(34, 34, 34)
                                .addComponent(jTextField_xMay6, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(29, 29, 29)
                                .addComponent(jLabel42)
                                .addGap(27, 27, 27)
                                .addComponent(jTextField_yMay6, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(jLabel24)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(jLabel3)
                        .addComponent(jTextField_xMatTroi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jTextField_yMatTroi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4)
                    .addComponent(jTextField_yDinhCayThong1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_xDinhCayThong1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextField_xDinhCayThong2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel6)
                        .addComponent(jTextField_yDinhCayThong2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jTextField_xDinhCayThong3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(jTextField_yDinhCayThong3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(jTextField_xTamBienBao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14)
                    .addComponent(jTextField_yTamBienBao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel18)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(jTextField_xDinhDenDuong1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20)
                    .addComponent(jTextField_yDinhDenDuong1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel21)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22)
                    .addComponent(jTextField_xDinhDenDuong2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel23)
                    .addComponent(jTextField_yDinhDenDuong2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel25)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel26)
                    .addComponent(jTextField_xMay1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel27)
                    .addComponent(jTextField_yMay1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel28)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel29)
                    .addComponent(jTextField_xMay2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel30)
                    .addComponent(jTextField_yMay2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel31)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel32)
                    .addComponent(jTextField_xMay3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel33)
                    .addComponent(jTextField_yMay3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel34)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel35)
                    .addComponent(jTextField_xMay4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel36)
                    .addComponent(jTextField_yMay4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel37)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel38)
                    .addComponent(jTextField_xMay5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel39)
                    .addComponent(jTextField_yMay5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel40)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel41)
                    .addComponent(jTextField_xMay6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel42)
                    .addComponent(jTextField_yMay6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField_xMuiXe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_yMuiXe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17)
                    .addComponent(jLabel16))
                .addContainerGap())
        );

        jCheckBox2.setText("Toggle xRay");
        jCheckBox2.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jCheckBox2ItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(66, 66, 66)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(77, 77, 77)
                .addComponent(jCheckBox_DrawGrid)
                .addGap(67, 67, 67)
                .addComponent(jCheckBox_DrawCoor)
                .addGap(52, 52, 52)
                .addComponent(jCheckBox1)
                .addGap(39, 39, 39)
                .addComponent(jCheckBox2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 81, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(646, 646, 646)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton3)
                    .addComponent(jCheckBox_DrawGrid)
                    .addComponent(jCheckBox_DrawCoor)
                    .addComponent(jCheckBox1)
                    .addComponent(jCheckBox2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed
    int play = 0;
    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        // TODO add your handling code here:

        if (play == 1) {
            a.tm.stop();
            play = 0;
        } else {
            play = 1;
            a.tm.start();
        }
    }//GEN-LAST:event_formMouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
//        a.tm.stop();
        if (play == 1) {
            a.tm.stop();
            play = 0;
            jButton3.setText("Play");
        } else {
            play = 1;
            a.tm.start();
            jButton3.setText("Pause");
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jCheckBox1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jCheckBox1ItemStateChanged
        // TODO add your handling code here:
        if (jCheckBox1.isSelected()) {
            DoanThang.unitsize = 5;
            DoanThang.fillValue = 5;
        } else {
            DoanThang.unitsize = 1;
            DoanThang.fillValue = 3;
        }
        repaint();
    }//GEN-LAST:event_jCheckBox1ItemStateChanged

    private void jCheckBox2ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jCheckBox2ItemStateChanged
        // TODO add your handling code here:
        repaint();
    }//GEN-LAST:event_jCheckBox2ItemStateChanged

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CarAnimation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CarAnimation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CarAnimation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CarAnimation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CarAnimation().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JCheckBox jCheckBox_DrawCoor;
    private javax.swing.JCheckBox jCheckBox_DrawGrid;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextField_xDinhCayThong1;
    private javax.swing.JTextField jTextField_xDinhCayThong2;
    private javax.swing.JTextField jTextField_xDinhCayThong3;
    private javax.swing.JTextField jTextField_xDinhDenDuong1;
    private javax.swing.JTextField jTextField_xDinhDenDuong2;
    private javax.swing.JTextField jTextField_xMatTroi;
    private javax.swing.JTextField jTextField_xMay1;
    private javax.swing.JTextField jTextField_xMay2;
    private javax.swing.JTextField jTextField_xMay3;
    private javax.swing.JTextField jTextField_xMay4;
    private javax.swing.JTextField jTextField_xMay5;
    private javax.swing.JTextField jTextField_xMay6;
    private javax.swing.JTextField jTextField_xMuiXe;
    private javax.swing.JTextField jTextField_xTamBienBao;
    private javax.swing.JTextField jTextField_yDinhCayThong1;
    private javax.swing.JTextField jTextField_yDinhCayThong2;
    private javax.swing.JTextField jTextField_yDinhCayThong3;
    private javax.swing.JTextField jTextField_yDinhDenDuong1;
    private javax.swing.JTextField jTextField_yDinhDenDuong2;
    private javax.swing.JTextField jTextField_yMatTroi;
    private javax.swing.JTextField jTextField_yMay1;
    private javax.swing.JTextField jTextField_yMay2;
    private javax.swing.JTextField jTextField_yMay3;
    private javax.swing.JTextField jTextField_yMay4;
    private javax.swing.JTextField jTextField_yMay5;
    private javax.swing.JTextField jTextField_yMay6;
    private javax.swing.JTextField jTextField_yMuiXe;
    private javax.swing.JTextField jTextField_yTamBienBao;
    // End of variables declaration//GEN-END:variables
}
