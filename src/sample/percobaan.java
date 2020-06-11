package sample;
import java.util.Scanner;

public class percobaan {

    public static void play(String args[]) {
        String namaPemain;
        String pilihan;
        Scanner in = new Scanner(System.in);

        System.out.println("Kamu mengambil secarik kertas sayembara lalu mengisinya dengan sebuah nama");
        namaPemain = in.nextLine();

        System.out.println(namaPemain + " adalah namamu?");
        System.out.println("Yes/No");
        pilihan = in.nextLine();
        if (pilihan.equals("yes")) {
            npc();
        }
        else {
            return;
        }
    }
    public static void npc(){
System.out.println("Kamu terbangun dari tidurmu oleh suara ketukan.");
System.out.println("Kamu pun membuka pintu dan melihat seorang prajurit berdiri tegap dengan segulung kertas.");
    }
}
