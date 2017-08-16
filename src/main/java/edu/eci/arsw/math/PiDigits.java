package edu.eci.arsw.math;

///  <summary>
import java.util.logging.Level;
import java.util.logging.Logger;

///  An implementation of the Bailey-Borwein-Plouffe formula for calculating hexadecimal
///  digits of pi.
///  https://en.wikipedia.org/wiki/Bailey%E2%80%93Borwein%E2%80%93Plouffe_formula
///  *** Translated from C# code: https://github.com/mmoroney/DigitsOfPi ***
///  </summary>
public class PiDigits {

    /**
     * Returns a range of hexadecimal digits of pi.
     *
     * @param start The starting location of the range.
     * @param count The number of digits to return
     * @return An array containing the hexadecimal digits.
     */
    public static byte[] getDigits(int start, int count, int n) {
        int hilos = n;
         byte[] digits = new byte[count];

        if (start < 0) {
            throw new RuntimeException("Invalid Interval");
        }

        if (count < 0) {
            throw new RuntimeException("Invalid Interval");
        }

        if (count < n) {
            throw new RuntimeException("Demasiados hilos para la operacion");
        }

        MyThread[] threads = new MyThread[n];

        int flag = 0;
        int numT = n;
        int a = start;

        while (numT > 0) {
            int b = count;
            while (b % n != 0) {
                b--;
            }
            threads[flag] = new MyThread(a, count / n);
            flag++;
            count = count - (b / n);
            a = a + (b / n);
            n--;
            numT--;
        }

        System.out.println("Salio del ciclo");

        for (int i = 0; i < hilos; i++) {
            threads[i].start();
        }

        try {
            for (int i = 0; i < hilos; i++) {
                threads[i].join();
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(PiDigits.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        for (int i = 0; i < hilos; i++) {
            System.out.println(threads[i].getDigits());
                    
        }
        

       

        return digits;
    }

}
