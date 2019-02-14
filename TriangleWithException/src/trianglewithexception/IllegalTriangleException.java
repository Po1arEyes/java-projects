
package trianglewithexception;

/**
 *
 * @author Christopher Ludwin
 */

class IllegalTriangleException extends Exception {

private double side = 1.0;

public IllegalTriangleException(double side) {
    super("ERROR: side with length of " + side + " is larger than the sum of the other sides");

} 

public double getSide1() {
    return side;
}

}