package dev.ufuk.bakan;

import java.util.List;

public class SeperatorThread implements Runnable{
    private List<Integer> array; // threadin kendisine ayrılan sayı dizisi (array list)
    private static Object LOCK = new Object(); // seperator threadlerin ortak (statik!) semaforu
    public SeperatorThread(List<Integer> array) {
        this.array = array;
    }

    @Override
    public void run(){
        array.forEach(x -> {
            if(x%2==0){
                synchronized(LOCK) {
                    // kritik bölge
                    Main.evens.add(x);
                }
            }else{
                synchronized(LOCK) {
                    // kritik bölge
                    Main.odds.add(x);
                }
            }
        });
    };
}
