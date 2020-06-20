package sample;

public class story {

    public void story2 (){
       System.out.println("Tidak lama setelah Prajurit itu datang, kamu segera bersiap\n" +
               "dan pergi ke hutan tempat Wizard itu berada.");
       //ohButton.setText("Duna luar aku datang!");
    }

    public void StageGoblin (){
        System.out.println("Kamu melihat sebuah bayangan mendekatimu.\n" +
                "\n" +
                "KAMU DISERANG!\n");
        //ohButton.setText("Bersiap untuk menyerang");
    }

    public void story3 (){
        System.out.println("Kamu menemukan secarik kertas di tas gendong milik Goblin yang\n" +
                "yang menyerangmu tadi.\n" +
                "\n" +
                "'Dari pohon Beringin belok ke kanan'\n" +
                "\n" +
                "Kamu pun mencari sebuah pohon Beringin.");
        //ohButton.setText("Aku ingat ada Beringin di dekat sungai.");
    }

    public void story4 () {
        System.out.println("Kamu berusaha mengingat dimana kamu pernah melihat pohon Beringin\n" +
                "Kamu menyusuri pinggiran sungai sampai akhirnya kamu melihat sebuah pohon\n" +
                "yang besar dan teduh.\n");
        //ohButton.setText("Ok, sekarang belok ke kanan");
    }

    public void StageWizard(){
        System.out.println("Oops, sepertinya kamu tidak menemukan Wizard itu.\n" +
                "Tapi...\n" +
                "Wizard itu yang menemukan kamu!\n" +
                "KAMU DISERANG!\n");
        //ohButton.setText("Ah, sangat mengejutkan.");
    }

    //Bagian ini harusnya dipanggil sesudah wizard kalah

    public void storyEnd() {
        System.out.println("Kamu berhasil mengalahkan Wizard itu\n" +
                "sebagai bukti kemenangan kamu membawa tongkat milik Wizard itu.\n" +
                "Dan beberapa barang berharga lainnya.\n" +
                "\n" +
                "Selamat atas kemenanganmu!");
        //ohButton.setText("Kembali ke Menu");
    }
}
