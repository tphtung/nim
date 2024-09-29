package NIM;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.util.Pair;
import javax.swing.JButton;
import javax.swing.JOptionPane;

public class MainBoardNguoi implements ActionListener {

    private BoardNguoi bNguoi;
    private List<JButton> list = new ArrayList<>();
    private int count;
    private String value;
    private String currentPlayer = A_VALUE;
    public static final String A_VALUE = "A";
    public static final String B_VALUE = "B";
    public static final String EMPTY_VALUE = "";
    private int MODE;// MODE == 0 -> Máy, 1-> Người
    private int LEVEL;// LEVEL == 0 -> dễ, 1-> khó
    private int modeFile;

    private int matNim[][];
    private int binNim[][];//mảng nhị phân, dòng cuối lưu Nim sum

    public MainBoardNguoi(BoardNguoi bNguoi) {
        this.bNguoi = bNguoi;
        matNim = new int[6][6];
        binNim = new int[7][8];
    }

    public void init() {
        count = list.size();
        this.value = EMPTY_VALUE;
        setMapNim();
        bNguoi.init();
    }

    public void setMapNim() {
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                matNim[i][j] = 0;
            }
        }

        int i, check = 0;//CHuyển từ list qua mảng 2 chiều
        int x = 0, y = 0;
        for (i = 0; i < list.size(); i++) {
            if (check != list.get(i).getBounds().y) {
                x++;
                y = 0;
            }

            if ((list.get(i).isVisible())) {
                matNim[x][y] = (list.get(i).isVisible() ? 1 : 0);
                y++;
            }
            check = list.get(i).getBounds().y;
        }
        calcBinNim();
    }

    public void showGameExist() {//  tạo lại bảng đã lưu
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                if (matNim[i][j] == 1) {
                    addButton(j * (bNguoi.getjPanel1().getHeight() / 6), i * (bNguoi.getjPanel1().getWidth() / 6));
                    bNguoi.getjPanel1().getComponentAt(j * 53, i * 53).setName("YES");
                } else {
                    bNguoi.getjPanel1().getComponentAt(j * 53, i * 53).setName("NO");
                }
            }
        }
    }

    public boolean readFile() {
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                matNim[i][j] = 0;
            }
        }

        FileInputStream file = null;
        try {
            file = new FileInputStream("board.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            Scanner dt = new Scanner(file, "UTF-8");
            modeFile = dt.nextInt();
            LEVEL = dt.nextInt();
            dt.nextLine();
            currentPlayer = dt.nextLine();
            for (int i = 0; i < 6; i++) {
                for (int j = 0; j < 6; j++) {
                    matNim[i][j] = dt.nextInt();
                }
            }
            dt.nextLine();
            dt.close();
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public void printNim() {// in mảng
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                System.out.printf("%5d", matNim[i][j]);
            }
            System.out.println("");
        }
    }

    public String toStringNIM() {
        String s = "";
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                s += matNim[i][j] + (j < 5 ? " " : "");
            }
            s += (i < 5 ? "\n" : "");
        }
        return s;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public int index(JButton button) {
        return bNguoi.getjPanel1().getComponentZOrder(button);
    }

    public int GetBoundsX(JButton button) {
        return button.getBounds().x;
    }

    public int GetBoundsY(JButton button) {
        return button.getBounds().y;
    }

    public String addButton(int x, int y) {
        int wight = bNguoi.getjPanel1().getWidth() / 6;
        int hight = bNguoi.getjPanel1().getHeight() / 6;
        JButton btn = new JButton();
        btn.setBounds(x, y, wight, hight);
        btn.setBackground(new Color(255, 254, 241));
        btn.setName("Hien");
        list.add(btn);
        bNguoi.getjPanel1().add(btn);
        return btn.getName();
    }

//TẠO BẢNG 
    public void addGroup() {
        int i, j, route;
        Random rand = new Random();
        route = rand.nextInt(6) + 1;
        for (i = 0; i < bNguoi.getjPanel1().getHeight() - 2; i = i + bNguoi.getjPanel1().getHeight() / 6) {
            for (j = 0; j < bNguoi.getjPanel1().getWidth() - 2; j = j + bNguoi.getjPanel1().getWidth() / 6) {
                if (route != 0) {
                    addButton(j, i);
                    bNguoi.getjPanel1().getComponentAt(j, i).setName("YES");
                    route--;
                } else {
                    bNguoi.getjPanel1().getComponentAt(j, i).setName("NO");
                }
            }
            route = rand.nextInt(6) + 1;
        }
    }

//CẬP NHẬT TRẠNG THÁI CỦA LIST    
    public void capNhat(JButton button) {

        int i, j, X = button.getX(), Y = button.getY();

        for (i = 0; i < list.size(); i++) {
            int x = list.get(i).getX();
            int y = list.get(i).getY();
            list.get(i).setLocation(x, y);
        }
    }

//KIỂM TRA AI THẮNG
    public void solo() {
        if (count == 0) {
            if (currentPlayer.equals(A_VALUE)) {
                JOptionPane.showMessageDialog(null, "CHÚC MỪNG NGƯỜI CHƠI 1 ĐÃ THẮNG!!!", "WIN", -1);
            } else if (currentPlayer.equals(B_VALUE)) {
                if (MODE == 0) {
                    JOptionPane.showConfirmDialog(null, "BẠN ĐÃ THUA!!!", "LOSE", -1);
                } else {
                    JOptionPane.showConfirmDialog(null, "CHÚC MỪNG NGƯỜI CHƠI 2 ĐÃ THẮNG!!!", "WIN", -1);
                }
            }
        } else {

        }

    }

    public List<JButton> getList() {
        return list;
    }

    public void setList(List<JButton> list) {
        this.list = list;
    }

// sự kiện người chơi
    @Override
    public void actionPerformed(ActionEvent e) {

        JButton button = (JButton) e.getSource();
        int x = button.getX();
        int y = button.getY();
        playGame(x, y);

        setValue(currentPlayer);
        solo();
        if (currentPlayer.equals(B_VALUE)) {
            bNguoi.getPlayer1().setBackground(new Color(255, 247, 77));
            bNguoi.getPlayer2().setBackground(new Color(255, 254, 241));
        } else {
            bNguoi.getPlayer2().setBackground(new Color(255, 247, 77));
            bNguoi.getPlayer1().setBackground(new Color(255, 254, 241));
        }
//        if (MODE == 1) {
        currentPlayer = currentPlayer.equals("A") ? B_VALUE : A_VALUE;
//        }

        if (MODE == 0) {
            Thread th = new Thread(new Runnable() {
                @Override
                public void run() {
                    if (currentPlayer.equals(B_VALUE)) {
                        if (LEVEL == 1) {
                            BOTHard();
                        } else {
                            computerPlay();
                        }

                    }
                }
            });
            th.start();
        }
    }

    public int countButton(int row) {
        int count = 0;
        for (int i = 0; i < 6; i++) {
            count += matNim[row][i];
        }
        return count;
    }

    public int randomRow() {
        System.out.println("RANDOMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM");
        int selcrow = 0;

        Random rand = new Random();
        boolean check = false;

        while (!check) {
            int rd = (Math.abs(rand.nextInt()) % 6);
            System.out.println("\nRANDOM:" + rd);
            System.out.println("COUNT: " + countButton(rd) + "\n");
            if (countButton(rd) > 0) {
                selcrow = rd;
                check = true;
            }
        }
        return selcrow;
    }

    public int randomNum(int row) {
        int num = 0;

        Random rand = new Random();
        boolean check = false;

        while (!check) {
            int rd = (Math.abs(rand.nextInt()) % (countButton(row) <= 1 ? countButton(row) : countButton(row) - 1));
//            if (rd <= countButton(row)) {
            num = rd;
            check = true;
//            }
        }
        return num;
    }

    public void computerPlay() {

        int selectedRow = randomRow();
        int numRow = randomNum(selectedRow);
//            selectedRow = selectedRow == 0 ? selectedRow : selectedRow - 1;
        System.out.println("Máy chọn: " + selectedRow + " " + numRow);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }

        playGame(numRow * (bNguoi.getjPanel1().getWidth() / 6), selectedRow * (bNguoi.getjPanel1().getWidth() / 6));
//            setValue(currentPlayer);
        solo();
        currentPlayer = A_VALUE;

        printNim();
        bNguoi.getPlayer1().setBackground(new Color(255, 247, 77));
        bNguoi.getPlayer2().setBackground(new Color(255, 254, 241));

    }

    //code cho máy khó ------------------
    public void initBinGame() {//khởi tạo, gán tất cả các ô bằng -1;
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 8; j++) {
                binNim[i][j] = -1;
            }
        }
    }

    public void appendBit(int row, int x) {// chèn bit vào hàng, chuyển thập phân sang nhị phân
        boolean flag = false;
        for (int i = 7; i >= 0 && !flag; i--) {
            if (binNim[row][i] == -1) {
                binNim[row][i] = x;
                flag = true;
            }
        }
    }

    public void toBinnary(int row, int number) {// chuyển thập phân sang nhị phân
        appendBit(row, number % 2);
        if (number / 2 != 0) {
            toBinnary(row, number / 2);
        }
    }

    public void allNimSum() {// tính NimSum dạng nhị phân bằng phương pháp XOR
        int count;
        for (int i = 7; i >= 0; i--) {
            count = 0;
            for (int j = 0; j < 6; j++) {
                if (binNim[j][i] == 1) {
                    count++;
                }
            }
            appendBit(6, count % 2);
        }
    }

    public void formatBin() {// định dạng nhị phân -1 thành 0
        for (int i = 0; i < 6 + 1; i++) {
            for (int j = 0; j < 8; j++) {
                if (binNim[i][j] == -1) {
                    binNim[i][j] = 0;
                }
            }
        }
    }

    public void calcBinNim() {// tính số ô trên mỗi hàng và gọi hàm chuyển thành nhị phân
        initBinGame();
        int rowSum;
        for (int i = 0; i < 6; i++) {
            rowSum = 0;
            for (int j = 0; j < 6; j++) {
                rowSum += matNim[i][j];
            }
            toBinnary(i, rowSum);
        }
        allNimSum();
        formatBin();
    }

    public int toDecimal(int row) {// chuyển dòng nhị phân sang thập phân
        int result = 0;
        for (int i = 0; i < 8; i++) {
            result += binNim[row][i] * Math.pow(2, 7 - i);
        }
        return result;
    }

    public int lenBit(int row) {//tính chiều dài bit của dòng nhị phân
        for (int i = 0; i < 8; i++) {
            if (binNim[row][i] == 1) {
                return (8 - i);
            }
        }
        return 0;
    }

    public int findRowSameNimSum() {//tìm hàng thích hợp khi độ dài NimSum != (nhỏ hơn) bất kì dòng nào.
        for (int i = 0; i < 6; i++) {
            if (lenBit(6) > 0 && binNim[i][8 - lenBit(6)] == 1) {//kiem tra neu hang co cot tai bit lon nhat cua NimSum = 1 thi doi bit;
                return i;
            }
        }
        return 0;
    }

    public int selectedRow() {//tìm hàng thích hợp cho BOTHard chơi
        int bitNimSum = lenBit(6);// chiều dài của NimsumBinary
        for (int i = 0; i < 6; i++) {
            if (lenBit(i) == bitNimSum) {
                return i;
            }
        }
        return findRowSameNimSum();
    }

    public void changeBitRow(int row) {// đổi bit tại những vị trí bit Nimsum == 1
        for (int i = 7; i >= (8 - lenBit(6)); i--) {
            if (binNim[6][i] == 1) {
                binNim[row][i] = Math.abs(binNim[row][i] - 1);
            }
        }
    }

    public void printBinGame() {
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 8; j++) {
                System.out.printf("%d  ", binNim[i][j]);
            }
            System.out.println();
        }

        System.out.println("KQ: ");
        for (int i = 0; i < 8; i++) {
            System.out.printf("%d  ", binNim[6][i]);
        }
        System.out.println();
    }

    public void BOTHard() {
        int selcrow = selectedRow();//chon hang
        int numRow = toDecimal(selcrow); // so o trong hang

//        try {
//            Thread.sleep(1500);
//        } catch (InterruptedException e) {
//            System.out.println(e);
//        }
        if (toDecimal(6) > 0) {
            changeBitRow(selcrow);
            numRow = toDecimal(selcrow);
        } else {
            if (count > 0) {
                selcrow = randomRow();
                numRow = randomNum(selcrow);
            }

        }
        System.out.println("Máy chọn: " + selcrow + " " + numRow);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException ex) {
            Logger.getLogger(MainBoardNguoi.class.getName()).log(Level.SEVERE, null, ex);
        }
        playGame(numRow * (bNguoi.getjPanel1().getWidth() / 6), selcrow * (bNguoi.getjPanel1().getWidth() / 6));
        System.out.println("NIM sum: " + toDecimal(6));
        solo();
        currentPlayer = A_VALUE;
        calcBinNim();
        bNguoi.getPlayer1().setBackground(new Color(255, 247, 77));
        bNguoi.getPlayer2().setBackground(new Color(255, 254, 241));
    }

    //------------------------------------
    // chơi game, 2 tham số là tọa độ
    public void playGame(int x, int y) {
        int temp = 0;
        for (int i = x; i < bNguoi.getjPanel1().getWidth() - 2; i = i + bNguoi.getjPanel1().getWidth() / 6) {
            bNguoi.getjPanel1().getComponentAt(i, y).setVisible(false);
            bNguoi.getjPanel1().remove(bNguoi.getjPanel1().getComponentAt(i, y));
            bNguoi.getjPanel1().revalidate();
            bNguoi.getjPanel1().repaint();
            temp++;
            if (bNguoi.getjPanel1().getComponentAt(i + bNguoi.getjPanel1().getHeight() / 6, y).getName().equals("YES")) {
                continue;
            } else {
                break;
            }
        }
        setMapNim();
        count = count - temp;

        printNim();
        System.out.println();
        printBinGame();
    }

    public int getMODE() {
        return MODE;
    }

    public void setMODE(int MODE) {
        this.MODE = MODE;
    }

    public int getLEVEL() {
        return LEVEL;
    }

    public void setLEVEL(int LEVEL) {
        this.LEVEL = LEVEL;
    }

    public int getModeFile() {
        return modeFile;
    }

    public void setModeFile(int modeFile) {
        this.modeFile = modeFile;
    }

    public String getCurrentPlayer() {
        return currentPlayer;
    }

}
