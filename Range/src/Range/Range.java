package Range;

public class Range {
    private double from;
    private double to;

    public Range(double from, double to) {
        this.from = from;
        this.to = to;
    }

    public double getFrom() {
        return from;
    }

    public void setFrom(double from) {
        this.from = from;
    }

    public double getTo() {
        return to;
    }

    public void setTo(double to) {
        this.to = to;
    }

    public double getLength() {
        return to - from;
    }

    public boolean isInside(double number) {
        return number >= from && number <= to;

    }

    public Range getIntersection(Range range) {
        if (from > range.getFrom() && to < range.getTo()) {
            return new Range(from, to);
        } else if (from < range.getFrom() && to > range.getTo()) {
            return new Range(range.getFrom(), range.getTo());
        } else if (from > range.getFrom() && from < range.getTo()) {
            return new Range(from, range.getTo());
        } else if (to < range.getTo() && to > range.getFrom()) {
            return new Range(range.getFrom(), to);
        } else {
            return null;
        }
    }

    public Range[] getMerge(Range range) {
        Range[] ranges = {null, null};

        if (from < range.getFrom() && to > range.getTo()) {
            ranges[0] = new Range(from, to);
        } else if (range.isInside(from) && range.isInside(to)) {
            ranges[0] = new Range(range.getFrom(), range.getTo());
        } else if (range.isInside(from)) {
            ranges[0] = new Range(range.getFrom(), to);
        } else if (range.isInside(to)) {
            ranges[0] = new Range(from, range.getTo());
        } else {
            ranges[0] = new Range(from, to);
            ranges[1] = new Range(range.getFrom(), range.getTo());
        }

        return ranges;
    }

    public Range[] getSubtraction(Range range) {
        Range[] ranges = {null, null};

        if (from < range.getFrom() && to > range.getTo()) {
            ranges[0] = new Range(from, range.getFrom());
            ranges[1] = new Range(range.getTo(), to);
        } else if (from > range.getFrom() && to < range.getTo()) {
            return ranges;
        } else if (from > range.getFrom() && from < range.getTo()) {
            ranges[0] = new Range(range.getTo(), to);
        } else if (to < range.getTo() && to > range.getFrom()) {
            ranges[0] = new Range(from, range.getFrom());
        }

        return ranges;
    }
}
