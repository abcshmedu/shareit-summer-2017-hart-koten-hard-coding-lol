package edu.hm.cs.swa.model;

/**
 * Abstract class Medium.
 *
 * @author Johannes Seidel, Michael Reile.
 */
public abstract class Medium {

    /**
     * Default c'tor.
     */
    Medium() {
    }


   /* @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((title == null) ? 0 : title.hashCode());
        return result;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Medium other = (Medium) obj;
        if (title == null) {
            if (other.title != null) {
                return false;
            }
        } else if (!title.equals(other.title)) {
            return false;
        }
        return true;
    }*/

}
