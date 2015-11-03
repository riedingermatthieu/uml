/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simpledraw;

/**
 *
 * @author Matthieu
 */
public interface ShapeVisitor {
    public void visit(Line l);
    public void visit(PolyLine l);
    public void visit(Circle c);
}
