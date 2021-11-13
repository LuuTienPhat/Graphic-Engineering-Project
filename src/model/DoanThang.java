/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.awt.Color;
import java.awt.Graphics2D;
//import view.KTDH_Nhom8;

/**
 *
 * @author tuanbuiquoc
 */
public class DoanThang {

    private int x1, x2, y1, y2;
    private String drawMode = "";
    public static int unitsize = 5;
    public static int fillValue = 5;

    public DoanThang(int x1, int y1, int x2, int y2) {
        int a = x1 % unitsize;
        this.x1 = x1 - a;
        a = y1 % unitsize;
        this.y1 = y1 - a;
        a = x2 % unitsize;
        this.x2 = x2 - a;
        a = y2 % unitsize;
        this.y2 = y2 - a;
    }

    public int getX1() {
        return x1;
    }

    public int getX2() {
        return x2;
    }

    public int getY1() {
        return y1;
    }

    public int getY2() {
        return y2;
    }

    public String getDrawMode() {
        return drawMode;
    }

    public void setX1(int x1) {
        int a = x1 % DoanThang.unitsize;
        this.x1 = x1 - a;
    }

    public void setX2(int x2) {
        int a = x2 % DoanThang.unitsize;
        this.x2 = x2 - a;
    }

    public void setY1(int y1) {
        int a = y1 % DoanThang.unitsize;
        this.y1 = y1 - a;
    }

    public void setY2(int y2) {
        int a = y2 % DoanThang.unitsize;
        this.y2 = y2 - a;
    }

    public void setDrawMode(String drawMode) {
        this.drawMode = drawMode;
    }

    public void veDoanThang(Graphics2D g) {
//        g.setColor(Color.red);
        int x, y, Dx, Dy, p;
        Dx = Math.abs(x2 - x1);
        Dy = Math.abs(y2 - y1);
//        p = 2 * Dy - Dx;
        x = x1;
        y = y1;
        g.fillRect(x, y, fillValue, fillValue); //ve diem pixel dau tien

        int x_unit = unitsize, y_unit = unitsize;

        g.fillRect(x, y, fillValue, fillValue);

        //xét trường hợp để cho y_unit và x_unit để vẽ tăng lên hay giảm xuống
        if (x2 - x1 < 0) {
            x_unit = -x_unit;
        }
        if (y2 - y1 < 0) {
            y_unit = -y_unit;
        }
        if (Dx >= Dy) {
            p = 2 * Dy - Dx;

            while (x != x2) {
                if (p < 0) {
                    p += 2 * Dy;
                } else {
                    p += 2 * (Dy - Dx);
                    y += y_unit;
                }
                x += x_unit;
                g.fillRect(x, y, fillValue, fillValue);
            }
        } else {
            p = 2 * Dx - Dy;

            while (y != y2) {
                if (p < 0) {
                    p += 2 * Dx;
                } else {
                    p += 2 * (Dx - Dy);
                    x += x_unit;
                }
                y += y_unit;
                g.fillRect(x, y, fillValue, fillValue);
            }
        }
    }

    public void veDoanThangNetDut(Graphics2D g) {
        g.setColor(Color.RED);  //dat mau hinh ve la red
        int dem = 0;
        int x, y, Dx, Dy, p;
        Dx = Math.abs(x2 - x1);
        Dy = Math.abs(y2 - y1);
//        p = 2 * Dy - Dx;
        x = x1;
        y = y1;
        int x_unit = unitsize, y_unit = unitsize;

//        g.fillRect(x - 1, y - 1, 3, 3);
        //xét trường hợp để cho y_unit và x_unit để vẽ tăng lên hay giảm xuống
        if (x2 - x1 < 0) {
            x_unit = -x_unit;
        }
        if (y2 - y1 < 0) {
            y_unit = -y_unit;
        }
        if (Dx >= Dy) {
            p = 2 * Dy - Dx;

            while (x != x2) {
                if (p < 0) {
                    p += 2 * Dy;
                } else {
                    p += 2 * (Dy - Dx);
                    y += y_unit;
                }
                x += x_unit;
                if (dem < 3) {
                    g.fillRect(x, y, fillValue, fillValue);
                    dem++;
                } else if (dem < 5) {
                    dem++;
                } else {
                    dem = 0;
                    g.fillRect(x, y, fillValue, fillValue);
                }
            }
        } else {
            p = 2 * Dx - Dy;

            while (y != y2) {
                if (p < 0) {
                    p += 2 * Dx;
                } else {
                    p += 2 * (Dx - Dy);
                    x += x_unit;
                }
                y += y_unit;
                if (dem < 3) {
                    g.fillRect(x, y, fillValue, fillValue);
                    dem++;
                } else if (dem < 5) {
                    dem++;
                } else {
                    dem = 0;
                    g.fillRect(x, y, fillValue, fillValue);
                }

            }
        }
    }

    public void veDoan2ChamGach(Graphics2D g) {
        g.setColor(Color.RED);  //dat mau hinh ve la red
        int dem = 0;
        int x, y, Dx, Dy, p;
        Dx = Math.abs(x2 - x1);
        Dy = Math.abs(y2 - y1);
//        p = 2 * Dy - Dx;
        x = x1;
        y = y1;
        int x_unit = unitsize, y_unit = unitsize;

//        g.fillRect(x - 1, -y - 1, 3, 3);
        //xét trường hợp để cho y_unit và x_unit để vẽ tăng lên hay giảm xuống
        if (x2 - x1 < 0) {
            x_unit = -x_unit;
        }
        if (y2 - y1 < 0) {
            y_unit = -y_unit;
        }
        if (Dx >= Dy) {
            p = 2 * Dy - Dx;

            while (x != x2) {
                if (p < 0) {
                    p += 2 * Dy;
                } else {
                    p += 2 * (Dy - Dx);
                    y += y_unit;
                }
                x += x_unit;
                if (dem < 10) {
                    g.fillRect(x, y, fillValue, fillValue);
                    dem++;
                } else if (dem < 13) {
                    dem++;
                } else if (dem < 14) {
                    g.fillRect(x, y, fillValue, fillValue);
                    dem++;
                } else if (dem < 17) {
                    dem++;
                } else if (dem < 18) {
                    g.fillRect(x, y, fillValue, fillValue);
                    dem++;
                } else if (dem < 20) {
                    dem++;
                } else {
                    dem = 0;
                }
            }
        } else {
            p = 2 * Dx - Dy;
            while (y != y2) {
                if (p < 0) {
                    p += 2 * Dx;
                } else {
                    p += 2 * (Dx - Dy);
                    x += x_unit;
                }
                y += y_unit;
                if (dem < 10) {
                    g.fillRect(x, y, fillValue, fillValue);
                    dem++;
                } else if (dem < 13) {
                    dem++;
                } else if (dem < 14) {
                    g.fillRect(x, y, fillValue, fillValue);
                    dem++;
                } else if (dem < 17) {
                    dem++;
                } else if (dem < 18) {
                    g.fillRect(x, y, fillValue, fillValue);
                    dem++;
                } else if (dem < 20) {
                    dem++;
                } else {
                    dem = 0;
                }
            }
        }
    }

    public void veDoanChamGach(Graphics2D g) {
        g.setColor(Color.RED);  //dat mau hinh ve la red
        int dem = 0;
        int x, y, Dx, Dy, p;
        Dx = Math.abs(x2 - x1);
        Dy = Math.abs(y2 - y1);

        x = x1;
        y = y1;
        int x_unit = unitsize, y_unit = unitsize;

        g.fillRect(x, y, fillValue, fillValue);

        //xét trường hợp để cho y_unit và x_unit để vẽ tăng lên hay giảm xuống
        if (x2 - x1 < 0) {
            x_unit = -x_unit;
        }
        if (y2 - y1 < 0) {
            y_unit = -y_unit;
        }
        if (Dx >= Dy) {
            p = 2 * Dy - Dx;

            while (x != x2) {
                if (p < 0) {
                    p += 2 * Dy;
                } else {
                    p += 2 * (Dy - Dx);
                    y += y_unit;
                }
                x += x_unit;
                if (dem < 5) {
                    g.fillRect(x, y, fillValue, fillValue);
                    dem++;
                } else if (dem < 12) {
                    dem++;
                } else if (dem < 13) {
                    g.fillRect(x, y, fillValue, fillValue);
                } else if (dem < 20) {
                    dem++;
                } else {
                    dem = 0;
                    g.fillRect(x, y, fillValue, fillValue);
                }
            }
        } else {
            p = 2 * Dx - Dy;

            while (y != y2) {
                if (p < 0) {
                    p += 2 * Dx;
                } else {
                    p += 2 * (Dx - Dy);
                    x += x_unit;
                }
                y += y_unit;
                if (dem < 5) {
                    g.fillRect(x, y, fillValue, fillValue);
                    dem++;
                } else if (dem < 12) {
                    dem++;
                } else if (dem < 13) {
                    g.fillRect(x, y, fillValue, fillValue);
                    dem++;
                } else if (dem < 20) {
                    dem++;
                } else {
                    dem = 0;
                    g.fillRect(x, y, fillValue, fillValue);
                }
            }
        }
    }
}
