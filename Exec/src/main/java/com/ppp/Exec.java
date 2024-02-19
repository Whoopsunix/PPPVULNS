package com.ppp;

/**
 * @author Whoopsunix
 */
public class Exec {
    public Exec() {
        try{
            Runtime.getRuntime().exec("open -a Calculator.app");
        }catch (Exception e){

        }
    }
}
