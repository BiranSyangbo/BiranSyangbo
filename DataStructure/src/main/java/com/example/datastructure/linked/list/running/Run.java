package com.example.datastructure.linked.list.running;

public class Run {
    public double distance; //in kms
    public int time; //in seconds

    public Run prev;
    public Run next;

    //DO NOT MODIFY - Parameterized constructor
    public Run(double d, int t) {
        distance = Math.max(0, d);
        time = Math.max(1, t);
    }

    //DO NOT MODIFY - Copy Constructor to create an instance copy
    //NOTE: Only the data section should be copied over, not the links
    public Run(Run source) {
        this(source.distance, source.time);
    }

    //DO NOT MODIFY (return speed in kmph)
    public double speed() {
        return distance * 3600 / time;
    }

    /**
     * add an INSTANCE COPY of the passed object (using the copy constructor)
     * at the end of the list in which the calling object exists.
     *
     * @param run
     */
    public void addToEnd(Run run) {
        Run temp = this;
        while (temp.next != null) {
            temp = temp.next;
        }
        Run newRun = new Run(run);
        newRun.next = null;
        newRun.prev = temp;
        temp.next = newRun;
    }

    /**
     * add an INSTANCE COPY of the passed object (using the copy constructor)
     * at the front of the list in which the calling object exists
     *
     * @param run
     */
    public void addToFront(Run run) {
        Run temp = this;
        while (temp.prev != null) {
            temp = temp.prev;
        }
        Run newRun = new Run(run);
        newRun.prev = null;
        newRun.next = temp;
        temp.prev = newRun;
    }

    /**
     * @return number of objects in the list in which the calling object exists
     */
    public int size() {
        int i = 0;
        Run temp = this;
        while (temp != null) {
            temp = temp.next;
            i++;
        }

        Run prev = this;
        while (prev.prev != null) {
            prev = prev.prev;
            i++;
        }
        return i; //to be completed
    }

    /**
     * @return the index of the calling object in the list.
     * the index of the first object in the list is 0.
     */
    public int getIndex() {
        Run temp = this;
        int i = 0;
        while (temp.prev != null) {
            temp = temp.prev;
            i++;
        }
        return i; //to be completed
    }

    /**
     * @param idx
     * @return the object that exists in the list at the passed index.
     * return null if there is no object at that index
     */
    public Run get(int idx) {
        Run temp = this;
        Run temp1 = getRun(idx, temp);
        if (temp1 != null) return temp1;
        return null; //to be completed
    }

    private Run getRun(int idx, Run temp) {
        while (temp.prev != null) {
            temp = temp.prev;
        }

        for (int i = 0; temp != null; i++) {
            if (i != idx)
                temp = temp.next;
            else
                return temp;
        }
        return null;
    }

    /**
     * return a text version of the list in which the calling object exists.
     * use "->" as the separator.
     */
    public String toString() {
        StringBuilder builder = new StringBuilder();
        Run temp = this;
        while (temp.prev != null) {
            temp = temp.prev;
        }
        while (temp != null) {
            builder.append(temp.toStringIndividual());
            if (temp.next != null) {
                builder.append("->");
            }
            temp = temp.next;
        }
        return builder.toString(); //to be completed
    }

    //DO NOT MODIFY
    public String toStringIndividual() {
        return distance + " in " + time;
    }

    /**
     * insert an INSTANCE COPY of the second parameter (using the copy constructor)
     * at index idx, thereby pushing all subsequent items one place higher
     * (in terms of index).
     *
     * @param idx
     * @param run
     * @return true if an INSTANCE COPY was successfully added at
     * the given index in the list, false otherwise.
     */  //0
    public boolean add(int idx, Run run) {
        Run temp = this;
        Run temp1 = getRun(idx, temp);
        if (temp1 == null)
            return false;
        Run prev = temp1.prev;
        Run newRun = new Run(run);
        newRun.prev = prev;
        newRun.next = temp1;
        temp1.prev = newRun;
        if (prev != null)
            prev.next = newRun;
        return true;

    }

    /**
     * @param thresholdSpeed
     * @return the highest number of consecutive items in the list
     * (to which the calling object belongs) that have a speed more than
     * the thresholdSpeed.
     */
    public int longestSequenceOver(double thresholdSpeed) {
        return 0; //to be completed
    }

    /**
     * @param thresholdSpeed
     * @return an array containing representations of the runs (in order of sequence)
     * in the list to which the calling object belongs, that have a speed more than
     * the thresholdSpeed. return null if no such item exists in the list.
     */
    public String[] getRunsOver(double thresholdSpeed) {
        return null; //to be completed
    }
}
