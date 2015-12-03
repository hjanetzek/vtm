package org.oscim.layers.vector.geometries;

import com.vividsolutions.jts.geom.Geometry;
import org.oscim.core.GeoPoint;
import org.oscim.utils.geom.GeomBuilder;

import java.util.List;
import java.util.ArrayList;

public class TriangleStripDrawable implements Drawable{
    protected Style style;
    protected Geometry bbox;
    List<GeoPoint> points;

    public TriangleStripDrawable(Style style) {
        this(new ArrayList<GeoPoint>(), style);

    }

    public TriangleStripDrawable(List<GeoPoint> points, Style style) {
        this.points = points;
        this.style = style;
        // TODO calculate bbox
        bbox = new GeomBuilder()
                .point(-180, -90)
                .point(-180, 90)
                .point(180, 90)
                .point(180, -90)
                .toPolygon();
    }

    public void setStyle(Style style) {
        this.style = style;
    }

    @Override
    public Style getStyle() {
        return style;
    }

    @Override
    public Geometry getGeometry() {
        return bbox;
    }

    public List<GeoPoint> getPoints() {
        return points;
    }

    public void addPoint(GeoPoint point) {
        points.add(point);
    }
}