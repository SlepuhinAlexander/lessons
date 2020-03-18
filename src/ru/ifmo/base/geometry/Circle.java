package ru.ifmo.base.geometry;

public class Circle {
    private int radius;

    public void setRadius(int radius) {
        if (radius > 0) {
            this.radius = radius;
        }
    }

    public float perimeter()    {
        return (float) (2 * Math.PI * radius);
    }

    public float surface()  {
        return (float) (Math.PI * radius * radius);
    }


}
