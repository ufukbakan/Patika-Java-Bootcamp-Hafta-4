package dev.ufuk.bakan;

import java.util.ArrayList;
import java.util.List;

public class Main {
    static List<Integer> odds = new ArrayList<>();
    static List<Integer> evens = new ArrayList<>();

    public static void main(String[] args) {
        List<Integer> array = new ArrayList();

        for(int i = 1; i <= 10000; i++){
            array.add(i); // 1 den 10000 e kadar olan sayıları array liste ekle
        }

        byte threadCount = 4;
        int incrementAmount = array.size() / threadCount; // thread başına düşen eleman sayısı
        int lowerLimit = 0; // ilk değeri 0
        int upperLimit = incrementAmount; // ilk değeri 2500

        List<Thread> threadPool = new ArrayList<>();
        // threadPool a 4 tane threadi şu subArrayleri parametre alacak şekilde ekle:
        // thread 1 => array[0-2500]
        // thread 2 => array[2500-5000]
        // thread 3 => array[5000-7500]
        // thread 4 => array[7500-10000]
        for(int i = 0; i < threadCount; i++){
            threadPool.add(new Thread(new SeperatorThread(subArray(array, lowerLimit, upperLimit))));
            lowerLimit += incrementAmount; // ilk değeri 0'dı, sıradaki değer 2500 vs
            upperLimit += incrementAmount; // ilk değeri 2500'dü, sıradaki değer 5000 vs
            threadPool.get(i).start();;
        }

        while( threadPool.stream().anyMatch(thread -> thread.isAlive()) ){
            // thread pooldaki threadler çalışıyorken bekle
            // main threadde bir işlem yapma
        }

        System.out.print("Odds: ");
        printList(odds); // tek sayıları yazdır
        System.out.print("Evens: ");
        printList(evens); // çift sayılır yazdır

    }

    private static List<Integer> subArray(List<Integer> arr, int l, int h){
        return arr.subList(l,h);
    }

    private static <T> void printList(List<T> list){
        int i;
        for(i = 0; i < list.size() - 1; i ++){
            System.out.print(list.get(i).toString()+", ");
        }
        System.out.println(list.get(i).toString());
    }
}
