package com.example.techgadgetsapp;

import java.util.ArrayList;

public class TechGadgetData {

    public static ArrayList<TechGadget> techGadgets = new ArrayList<>();

    public static void addData() {
        TechGadget tech1=new TechGadget("Techgadget 1", R.drawable.tech1, "https://wiproo.com/high-tech-gadgets-that-you-must-buy-for-your-home/");
        TechGadget tech2=new TechGadget("Techgadget 2", R.drawable.tech2, "https://mashable.com/gifts/cool-gadgets-great-gifts/?europe=true");
        TechGadget tech3=new TechGadget("Techgadget 3", R.drawable.tech3, "http://www.techglobex.net/2015/06/top-5-upcoming-gadgets-worth-waiting.html");
        techGadgets.clear();
        techGadgets.add(tech1);
        techGadgets.add(tech2);
        techGadgets.add(tech3);

    }
}
