package JavaFx_controls_Part2;

/**
 *
 * @author fenia
 */

import javafx.beans.property.*;

public class ProjectEntry {
    
    // Declaring proprerties
    private final SimpleStringProperty programmer;
    private final SimpleStringProperty status;
    private final SimpleIntegerProperty size;

    // Constructor
    public ProjectEntry(String programmer, String status, int size) {
        this.programmer = new SimpleStringProperty(programmer);
        this.status = new SimpleStringProperty(status);
        this.size = new SimpleIntegerProperty(size);
    }

    public String getProgrammer() {
        return programmer.get();
    }

    public void setProgrammer(String programmer) {
        this.programmer.set(programmer);
    }

    public String getStatus() {
        return status.get();
    }

    public void setStatus(String status) {
        this.status.set(status);
    }

    public int getSize() {
        return size.get();
    }

    public void setSize(int size) {
        this.size.set(size);
    }
}
