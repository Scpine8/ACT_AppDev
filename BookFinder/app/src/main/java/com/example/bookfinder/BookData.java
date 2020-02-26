package com.example.bookfinder;

import android.content.res.Resources;
import android.os.Build;

import androidx.annotation.RequiresApi;

import java.util.ArrayList;
import java.util.Comparator;

public class BookData {

    public static ArrayList<Book> books = new ArrayList<>();

    public static void getData() {
        // book1
        String donqDesc = "WITH AN INTRODUCTION BY HAROLD BLOOM. Widely regarded as the world's first modern novel, and one of the funniest and most tragic books ever written, Don Quixote chronicles the famous picaresque adventures of the noble knight-errant Don Quixote de La Mancha and his faithful squire, Sancho Panza, as they travel through sixteenth-century Spain. Unless you read Spanish, you've never read Don Quixote.";
        String donqLink = "https://www.bookdepository.com/Don-Quixote-Miguel-de-Cervantes/9780099469698";
        Book donQ = new Book("Don Quixote", R.drawable.donquixote, donqDesc, donqLink);

        // book2
        String grimmDesc = "In this beautiful book of classic fairy tales, award-winning author Philip Pullman has chosen his fifty favourite stories from the Brothers Grimm and presents them in a'clear as water' retelling, in his unique and brilliant voice. \n" +
                "From the quests and romance of classics such as 'Rapunzel', 'Snow White' and 'Cinderella' to the danger and wit of such lesser-known tales as 'The Three Snake Leaves', 'Hans-my-Hedgehog' and 'Godfather Death'.";
        String grimmLink = "https://www.bookdepository.com/Grimm-Tales-Philip-Pullman/9780141442228";
        Book grimm = new Book("Grimm Tales : For Young and Old", R.drawable.grimtales, grimmDesc, grimmLink);

        // book3
        String elonDesc = "South African born Elon Musk is the renowned entrepreneur and innovator behind PayPal, SpaceX, Tesla, and SolarCity. Musk wants to save our planet; he wants to send citizens into space, to form a colony on Mars; he wants to make money while doing these things; and he wants us all to know about it. He is the real-life inspiration for the Iron Man series of films starring Robert Downey Junior.";
        String elonLink = "https://www.bookdepository.com/Elon-Musk-Ashlee-Vance/9780753557525?ref=grid-view";
        Book elon = new Book("Elon Musk : How the Billionaire CEO of SpaceX and Tesla is Shaping our Future", R.drawable.elonmusk, elonDesc, elonLink);

        books.clear();
        // cars.add(car1)
        books.add(donQ);
        // cars.add(car2)
        books.add(grimm);
        // cars.add(car3)
        books.add(elon);
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public static void sortData() {
        books.sort(new Comparator<Book>() {
            @Override
            public int compare(Book b1, Book b2) {
                return b1.getName().compareToIgnoreCase(b2.getName());
            }
        });
    }
}
