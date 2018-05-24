package Models;

public interface Entry {
    public String getName();

    public String getType();

    public Object[] getData();

    public String toFileFormat();
}
