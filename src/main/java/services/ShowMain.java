package services;

import model.Shows;
import repository.ShowsDao;
import java.util.Scanner;

public class ShowMain {

    public static Shows enterShows() {

        Shows newShow = new Shows();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Give Title name: ");
        newShow.setTitle(scanner.nextLine());

        System.out.println("Enter description: ");
        newShow.setDescription(scanner.nextLine());

        System.out.println("Give type: ");
        newShow.setType(scanner.nextLine());

        System.out.println("Director");
        newShow.setDirector(scanner.nextLine());

        System.out.println("duration");
        newShow.setDuration(scanner.nextInt());

        ShowsDao showsDao = new ShowsDao();
        showsDao.createShows(newShow);

        System.out.println(" The new show is: " + newShow.getTitle() + " " + newShow.getType() + " " + newShow.getShowId());

        return newShow;
    }
}

        //return newShow;

/*

        Shows shows1 = new Shows("Emadepäev", "“Emadepäev” heitlik, paiguti naerma " +
                "ja paiguti hulluks ajav lavastus täis kraaklemist, rõõmu, nuttu, " +
                "armastust, ürgvarajasi hommikuid ja hirmhiliseid õhtuid, kõikjal " +
                "vedelevaid mänguasju, pähekulunud lastelaule, ebaõnnestunud " +
                "sünnipäevatorte ning lõputuid muusikakooliaktuseid.",
                120, "Komöödia", "Liis Aedmaa");

        Shows shows2 = new Shows("Sorri, ei saa aidata", "Etendus räägib keskikka " +
                "jõudnud mehe ummikaastatest. See on lugu kaduvast mehelikkusest, tugevast ja " +
                "tahtejõulisest naiselikkusest, isekusest ja andestamise raskusest, millesse on " +
                "põimitud vabastavat nalja ja huumorit.", 175, "Komöödia",
                "Tanel Ingi");

        Shows shows3 = new Shows("Peer Gynt", "Lavastuses „Peer Gynt” on norra " +
                "muinasjutumaailm ja Ibseni pillav fantaasia ühendatud tänapäeva folklooriga. " +
                "Sellest kooslusest sünnib sürrealistlik kabaree. Peer Gynt on meie aja kangelane. " +
                "Ta on noor, ilus ja andekas! Küsimusele: „Olla või mitte olla?“ " +
                "vastab Peer Gynt: „Olla ise!“", 120, "Drama", "Karl Laumets");

        Shows shows4 = new Shows("Once", "John Carney mängufilmil põhinev muusikal “Once” " +
                "(“Ükskord”) on isemoodi lugu üksindusest, kirest ja lootustest. Samuti muusika rollist meie elus.",
                140, "Muusikal", "Taago Tubin");

        Shows shows5 = new Shows("Etturid", "„Etturid” on lugu kolme noore mehe – Agu, Heiki ja " +
                "Valduri – võitlusest iseendaks jäämise nimel, samal ajal kui ümbritsev tegelikkus seda üha vähem " +
                "võimaldab. Ideaalide kuhtumise ja purunemise lugu, mis sunnib paratamatult küsima: kuidas käituksime " +
                "ise, kui satuksime samasugustesse oludesse?", 140, "Põnevusdraama",
                "Taago Tubin");

        ShowsDao showsDao = new ShowsDao();
        showsDao.createShows(shows1);
        showsDao.createShows(shows2);
        showsDao.createShows(shows3);
        showsDao.createShows(shows4);
        showsDao.createShows(shows5);
*/