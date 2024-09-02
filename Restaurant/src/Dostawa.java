public class Dostawa extends Thread {

    public void run() {
        try {
            Thread.sleep(30000);
        } catch (InterruptedException e){
        }
        for (int i = 60; i > 0; i--) {
            System.out.print("Dostawa w drodze " + i + "\r");

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }
        }
    }
}

