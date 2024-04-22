
public class IST411Controller {
      public static void main(String[] args) { //main method class aka "controller"
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() { //run will initiate the view class and set the frame to visible
                IST411View frame = new IST411View();
                frame.setVisible(true);
            }
        });
    }
}
