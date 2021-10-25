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
public class SelectPromoException extends Exception {

    /**
     * Creates a new instance of <code>SelectPromoException</code> without
     * detail message.
     */
    public SelectPromoException() {
    }

    /**
     * Constructs an instance of <code>SelectPromoException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public SelectPromoException(String msg) {
        super(msg);
    }
}
