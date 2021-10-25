/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ImiesException;

/**
 *
 * @author lor.cdi02
 */
public class SelectDateEndException extends Exception {

    /**
     * Creates a new instance of <code>SelectDateEndException</code> without
     * detail message.
     */
    public SelectDateEndException() {
    }

    /**
     * Constructs an instance of <code>SelectDateEndException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public SelectDateEndException(String msg) {
        super(msg);
    }
}
