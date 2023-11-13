package tp05_2;

import java.util.List;

public interface IProduitMetier<T> {
    void add(T p);
    List<T> getAll();

    T findById(int id);
    void delete(int id);
    void saveAll();
}