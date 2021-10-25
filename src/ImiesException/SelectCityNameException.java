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
public class SelectCityNameException extends Exception {

    /**
     * Creates a new instance of <code>SelectCityNameException</code> without
     * detail message.
     */
    public SelectCityNameException() {
    }

    /**
     * Constructs an instance of <code>SelectCityNameException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public SelectCityNameException(String msg) {
        super(msg);
    }
}
