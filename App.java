package tp05_2;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int id;
        String nom;
        String marque;
        double prix;
        String description;
        int nombreEnStock;
        MetierProduitImpl produit = new MetierProduitImpl();
        while (true) {
            System.out.println("Menu :");
            System.out.println("1. Afficher la liste des produits.");
            System.out.println("2. Rechercher un produit par son id.");
            System.out.println("3. Ajouter un nouveau produit dans la liste.");
            System.out.println("4. Supprimer un produit par id.");
            System.out.println("5. Sauvegarder les produits.");
            System.out.println("6. Quitter ce programme.");
            System.out.print("Choisissez une option : ");

            int choix = input.nextInt();

            switch (choix) {
                case 1:
                    for (Produit pd : produit.getAll())
                        System.out.println(pd);
                    break;
                case 2:
                    System.out.println("id : ");
                    id = input.nextInt();
                    System.out.println(produit.findById(id));
                    ;
                    break;
                case 3:
                    System.out.println("id : ");
                    id = input.nextInt();
                    input.nextLine();
                    System.out.println("nom : ");
                    nom = input.nextLine();
                    System.out.println("marque : ");
                    marque = input.nextLine();
                    System.out.println("prix : ");
                    prix = input.nextDouble();
                    input.nextLine();
                    System.out.println("description : ");
                    description = input.nextLine();
                    System.out.println("nombreEnStock : ");
                    nombreEnStock = input.nextInt();
                    produit.add(new Produit(id, nom, marque, prix, description, nombreEnStock));
                    break;
                case 4:
                    System.out.println("id : ");
                    id = input.nextInt();
                    produit.delete(id);
                    break;
                case 5:
                    produit.saveAll();
                    break;
                case 6:
                    System.out.println("Programme terminé!");
                    input.close();
                    System.exit(0);
                default:
                    System.out.println("Choix invalide!");
            }
        }
    }
}
