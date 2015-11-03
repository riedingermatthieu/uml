/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simpledraw;

import java.awt.Point;
import java.util.List;

/**
 *
 * @author Matthieu
 */
public class XmlVisitor implements ShapeVisitor {
    
    StringBuilder XML;
    
    public XmlVisitor() {
        XML = new StringBuilder();
    }
    
    @Override
    public void visit(Line l) {
        StringBuilder result = new StringBuilder("<line ");
        result.append("x0=").append(l.getStart().x).append(", ");
        result.append("y0=").append(l.getStart().y).append(", ");
        result.append("x1=").append(l.getEnd().x).append(", ");
        result.append("y1=").append(l.getEnd().y).append("/>");
        result.append("\n");
        XML.append(result);
    }

    @Override
    public void visit(PolyLine l) {
        StringBuilder result = new StringBuilder("<polyline>\n");
        List<Point> points = l.getPoints();
        for (Point p : points) {
            result.append("\t<point ");
            result.append("x=").append(p.x).append(", ");
            result.append("y=").append(p.y).append("/>");
            result.append("\n");
        }
        result.append("</polyline>\n");
        XML.append(result);
    }

    @Override
    public void visit(Circle c) {
        StringBuilder result = new StringBuilder("<circle ");
        Point center = c.getCenter();
        result.append("x0=").append(center.x).append(", ");
        result.append("y0=").append(center.y).append(", ");
        result.append("radius=").append(c.getRadius()).append("/>");
        result.append("\n");
        XML.append(result);
    }
    
    public String getXML() {
        return XML.toString();
    }
    
}
