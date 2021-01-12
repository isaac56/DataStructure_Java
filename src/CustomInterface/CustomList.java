package CustomInterface;

import java.util.List;

public interface CustomList<T> {
    public void add(T val);
    public void add(int index, T val);
    public boolean remove(T val);
    public List<T> getList();
    public int getSize();
}
