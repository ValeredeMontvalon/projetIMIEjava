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
public class SelectDateBeginException extends Exception {

    /**
     * Creates a new instance of <code>SelectDateStartException</code> without
     * detail message.
     */
    public SelectDateBeginException() {
    }

    /**
     * Constructs an instance of <code>SelectDateStartException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public SelectDateBeginException(String msg) {
        super(msg);
    }
}
