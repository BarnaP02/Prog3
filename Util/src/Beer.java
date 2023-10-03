public class Beer {
    private String name;
    private String style;
    private double alkoholfok;
    public Beer(String n, String s, double a) {
        name = n;
        style = s;
        alkoholfok = a;
    }

    public String getName() {
        return name;
    }

    public String getStyle() {
        return style;
    }

    public double getAlkoholfok() {
        return alkoholfok;
    }

    @Override
    public String toString() {
        return "sor: " + name + " jelleg: " + style + " alkoholfok: " + alkoholfok;
    }
}
