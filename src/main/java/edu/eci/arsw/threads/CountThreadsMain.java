/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.threads;

/**
 *
 * @author hcadavid
 */
public class CountThreadsMain {

    public static void main(String a[]) {

        CountThread t1 = new CountThread(0, 999);
        CountThread t2 = new CountThread(1000, 1999);
        CountThread t3 = new CountThread(2000, 2999);

        /**t1.start();
        t2.start();
        t3.start();*/
        
        t1.run();
        t2.run();
        t3.run();
        

    }

}
