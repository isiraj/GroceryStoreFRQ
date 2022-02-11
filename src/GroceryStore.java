import java.util.ArrayList;

public class GroceryStore
{
    /** An array of products normally stocked at the grocery store
     *  Guaranteed not to be null and to contain only non-null entries
     */
    private Product[] productsStocked;

    public GroceryStore(Product[] initialInventory)
    {
        productsStocked = initialInventory;
    }

    /** Returns an ArrayList of indices for Product elements in the
     *  productsStocked array that need to be reordered, as described in part (a)
     *  Precondition: min > 0 */
    public ArrayList<Integer> getReorderList(int min) {
        ArrayList<Integer> indices = new ArrayList<Integer>();
        for (int i = 0; i < productsStocked.length; i++) {
            if (productsStocked[i].getQuantity() <= min) {
                indices.add(i);
            }
        }
        return indices;
    }

    /** Returns true if all products named in shoppingList are available for purchase
     *  and returns false otherwise, as described in part (b)
     *  Precondition: The products named in shoppingList are found exactly once
     *  in the productsStocked array.
     */
    public boolean checkAvailability(ArrayList<String> shoppingList)
    {
        for(int i = 0; i < shoppingList.size(); i++){
            for(int z = 0; z < productsStocked.length; z++){
                if(shoppingList.get(i).equals(productsStocked[z].getName())){
                   if(productsStocked[z].getQuantity() == 0){
                       return false;
                   }
                }
            }
        }
        return true;
    }

    public ArrayList<Product> oversized(double weight)
    {
        ArrayList<Product> oversizedItems = new ArrayList<Product>();
        for (int i = 0; i < productsStocked.length; i++){
            if(productsStocked[i].getWeight() > weight){
                oversizedItems.add(productsStocked[i]);
            }
        }
        return oversizedItems;
    }



}