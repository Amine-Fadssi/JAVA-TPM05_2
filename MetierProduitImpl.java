package tp05_2;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class MetierProduitImpl implements IProduitMetier<Produit> {
    List<Produit> listProduits = new ArrayList<>();

    @Override
    public void add(Produit p) {
        listProduits.add(p);
    }

    @Override
    public List<Produit> getAll() {
        return listProduits;
    }

    @Override
    public Produit findById(int id) {
        for (Produit produit:listProduits) {
            if (produit.getId() == id)
                return produit;
        }
        return null;
    }

    @Override
    public void delete(int id) {
        Produit deleteProduit = null;
        for (Produit produit:listProduits) {
            if (produit.getId() == id)
                deleteProduit = produit;
        }
        listProduits.remove(deleteProduit);
    }

    @Override
    public void saveAll(){
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("produits.dat"))) {
            oos.writeObject(listProduits);
            System.out.println("Serialization done. 'produits.dat'");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
