
package NIM;

public class Main {
   
    public static void main(String [] args){
        NimGame nim = new NimGame();
        nim.setLocationRelativeTo(nim);
        nim.setVisible(true);
    }
}
